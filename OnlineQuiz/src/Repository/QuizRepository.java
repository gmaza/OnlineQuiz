package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Database.DatabaseHelper;
import Interfaces.IQuizRepository;
import Models.Quiz;
import Models.User;

public class QuizRepository implements IQuizRepository {
	
	DatabaseHelper helper;
	
	public QuizRepository() {
		helper = new DatabaseHelper();
	}

	@Override
	public Quiz Get(int id) {
		String query = "Select * from quizzes where ID = " + id;
		ResultSet rs = helper.ExcecuteSelect(query);
		Quiz quiz = null;
		try {
			if (rs.next()) {
				quiz = new Quiz();
				UserRepository repo = new UserRepository();
				quiz.SetID(rs.getInt("ID"));
				quiz.SetName(rs.getString("QuizName"));
				quiz.SetDate(rs.getDate("CreateDate"));
				quiz.SetAuthor(repo.Get(rs.getInt("Author")));
				quiz.SetNumberOfQuestions(rs.getInt("QuestionsNum"));
				quiz.SetTakenNumber(rs.getInt("TakenNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quiz;
		
	}

	private List<Quiz> GetAllHelper(ResultSet rs){
		List<Quiz> quizList = new ArrayList<Quiz>();
		try {
			while (rs.next()){
				Quiz quiz = new Quiz();
				UserRepository repo = new UserRepository();
				quiz.SetID(rs.getInt("ID"));
				quiz.SetName(rs.getString("QuizName"));
				quiz.SetDate(rs.getDate("CreateDate"));
				quiz.SetAuthor(repo.Get(rs.getInt("Author")));
				quiz.SetNumberOfQuestions(rs.getInt("QuestionsNum"));
				quiz.SetTakenNumber(rs.getInt("TakenNum"));
				quizList.add(quiz);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quizList; 
	}
	
	@Override
	public List<Quiz> GetAll() {
		String query = "Select * from quizzes";
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public List<Quiz> GetAll(int userID) {
		String query = "Select * from quizzes where Author = " + userID;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public List<Quiz> GetAll(User user) {
		String query = "Select * from quizzes where Author = " + user.GetID();
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public List<Quiz> GetAll(String username) {
		UserRepository repo = new UserRepository();
		String query = "Select * from quizzes where Author = " + repo.Get(username).GetID();
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public boolean Delete(int id) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("ID", "" + id );
		helper.Delete("quizzes", mp);
		return true;
	}

	@Override
	public boolean Update(Quiz quiz) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("QuizName","'" +quiz.GetName()+"'");
		mp.put("CreateDate","'" +quiz.GetDate()+"'");
		mp.put("Author","" +quiz.GetAuthor().GetID());
		mp.put("QuestionsNum","" +quiz.GetNumberOfQuestions());
		mp.put("TakenNum",""+quiz.GetTakenNumber());
		helper.Update("quizzes", mp, quiz.GetID());
		return true;
	}

	@Override
	public int Save(Quiz quiz) {
		String newstring = new SimpleDateFormat("yyyy-MM-dd").format(quiz.GetDate());
		
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("QuizName","'" +quiz.GetName()+"'");
		mp.put("CreateDate","'" +newstring+"'");
		mp.put("Author","" +quiz.GetAuthor().GetID());
		mp.put("QuestionsNum","" +quiz.GetNumberOfQuestions());
		mp.put("TakenNum",""+quiz.GetTakenNumber());
		return helper.Insert("quizzes", mp);
	}

	@Override
	public void SaveRange(List<Quiz> quizzes) {
		for (Quiz quiz : quizzes){
			Save(quiz);
		}
		
	}

}
