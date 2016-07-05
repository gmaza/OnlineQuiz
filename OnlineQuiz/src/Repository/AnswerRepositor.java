package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Database.DatabaseHelper;
import Interfaces.IAnswerRepository;
import Models.Answer;
import Models.Question;

public class AnswerRepositor implements IAnswerRepository {

	DatabaseHelper helper;
	
	public AnswerRepositor() {
		helper = new DatabaseHelper();
	}
	
	@Override
	public Answer Get(int id) {
		String query = "Select * from answers where ID = " + id;
		ResultSet rs = helper.ExcecuteSelect(query);
		Answer answer = null;
		try {
			if (rs.next()) {
				answer = new Answer();
				QuestionRepository repo = new QuestionRepository();
				answer.SetID(rs.getInt("ID"));
				answer.SetQuestion(repo.Get(rs.getInt("QuestionID")));
				answer.SetAnswer(rs.getString("Answer"));
				answer.SetAnswerType((rs.getInt("AnswerType")==1)?true:false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answer;
	}
	
	private List<Answer> GetAllHelper(ResultSet rs){
		List<Answer> answerList = new ArrayList<Answer>();
		try {
			while (rs.next()){
				Answer answer = new Answer();
				QuestionRepository repo = new QuestionRepository();
				answer.SetID(rs.getInt("ID"));
				answer.SetQuestion(repo.Get(rs.getInt("QuestionID")));
				answer.SetAnswer(rs.getString("Answer"));
				answer.SetAnswerType((rs.getInt("AnswerType")==1)?true:false);
				answerList.add(answer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answerList;
	}

	@Override
	public List<Answer> GetAll() {
		String query = "Select * from answers";
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public List<Answer> GetAll(int questionID) {
		String query = "Select * from answers where QuestionID = " + questionID;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public List<Answer> GetAll(Question question) {
		String query = "Select * from answers where QuestionID = " + question.GetID();
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public boolean Delete(int id) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("ID", "" + id );
		helper.Delete("answers", mp);
		return true;
	}

	@Override
	public boolean Update(Answer answer) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("QuestionID","" +answer.GetQuestion().GetID());
		mp.put("Answer","'" +answer.GetAnswer()+"'");
		mp.put("AnswerType","" +(answer.GetAnswerType()==true?1:0));
		helper.Update("answers", mp, answer.GetID());
		return true;
	}

	@Override
	public int Save(Answer answer) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("QuestionID","" +answer.GetQuestion().GetID());
		mp.put("Answer","'" +answer.GetAnswer()+"'");
		mp.put("AnswerType","" +(answer.GetAnswerType()==true?1:0));
		return helper.Insert("answers", mp);

	}

	@Override
	public void SaveRange(List<Answer> answers) {
		for (Answer answer : answers){
			Save(answer);
		}
	}

}
