package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Database.DatabaseHelper;
import Interfaces.IQuestionRepository;
import Models.Question;
import Models.Quiz;

public class QuestionRepository implements IQuestionRepository {
	
	DatabaseHelper helper;
	
	public QuestionRepository() {
		helper = new DatabaseHelper();
	}

	@Override
	public Question Get(int id) {
		String query = "Select * from questions where ID = " + id;
		ResultSet rs = helper.ExcecuteSelect(query);
		Question question = null;
		try {
			if (rs.next()) {
				question = new Question();
				QuizRepository repo = new QuizRepository();
				question.SetID(rs.getInt("ID"));
				question.SetQuiz(repo.Get(rs.getInt("QuizID")));
				question.SetQuestion(rs.getString("Question"));
				question.SetQuestionType(rs.getInt("QuestionType"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return question;
	}

	private List<Question> GetAllHelper(ResultSet rs){
		List<Question> questionList = new ArrayList<Question>();
		try {
			while (rs.next()){
				Question question = new Question();
				QuizRepository repo = new QuizRepository();
				question.SetID(rs.getInt("ID"));
				question.SetQuiz(repo.Get(rs.getInt("QuizID")));
				question.SetQuestion(rs.getString("Question"));
				question.SetQuestionType(rs.getInt("QuestionType"));
				questionList.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionList;
	}
	
	@Override
	public List<Question> GetAll() {
		String query = "Select * from questions";
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public List<Question> GetAll(int quizID) {
		String query = "Select * from questions where QuizID = " + quizID;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
		
		
	}

	@Override
	public List<Question> GetAll(Quiz quiz) {
		String query = "Select * from questions where QuizID = " + quiz.GetID();
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public boolean Delete(int id) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("ID", "" + id );
		helper.Delete("questions", mp);
		return true;
	}

	@Override
	public boolean Update(Question question) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("QuizID","" +question.GetQuiz().GetID());
		mp.put("Question","'" +question.GetQuestion()+"'");
		mp.put("QuestionType","" +question.GetQuestionType().ordinal());
		helper.Update("questions", mp, question.GetID());
		return true;
	}

	@Override
	public int Save(Question question) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("QuizID","" +question.GetQuiz().GetID());
		mp.put("Question","'" +question.GetQuestion()+"'");
		mp.put("QuestionType","" +question.GetQuestionType().ordinal());
		return helper.Insert("questions", mp);
	}

	@Override
	public void SaveRange(List<Question> questions) {
		for (Question question : questions){
			Save(question);
		}

	}

}
