package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Database.DatabaseHelper;
import Interfaces.IResultRepository;
import Models.Answer;
import Models.AnswerResult;
import Models.Result;

public class ResultRepository implements IResultRepository {

	DatabaseHelper helper;

	public ResultRepository(DatabaseHelper helper) {
		this.helper = helper;
	}

	@Override
	public Result Get(int id) {
		String query = "Select * from results where ID = " + id;
		ResultSet rs = helper.ExcecuteSelect(query);
		Result result = null;
		try {
			if (rs.next()) {
				result = new Result();
				result.SetID(rs.getInt("ID"));
				UserRepository userrepo = new UserRepository(helper);
				result.SetUser(userrepo.Get(rs.getInt("UserID")));
				QuizRepository quizrepo = new QuizRepository(helper);
				result.SetQuiz(quizrepo.Get(rs.getInt("QuizID")));
				result.SetStartDate(rs.getDate("StartDate"));
				result.SetEndDate(rs.getDate("EndDate"));
				result.SetScore(rs.getInt("Score"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private List<Result> GetAllHelper(ResultSet rs){
		List<Result> resultList = new ArrayList<Result>();
		try {
			while (rs.next()){
				Result result = new Result();
				result.SetID(rs.getInt("ID"));
				UserRepository userrepo = new UserRepository(helper);
				result.SetUser(userrepo.Get(rs.getInt("UserID")));
				QuizRepository quizrepo = new QuizRepository(helper);
				result.SetQuiz(quizrepo.Get(rs.getInt("QuizID")));
				result.SetStartDate(rs.getDate("StartDate"));
				result.SetEndDate(rs.getDate("EndDate"));
				result.SetScore(rs.getInt("Score"));
				resultList.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<Result> GetAll(int quizID, int userID) {
		String query = "Select * from results where QuizID = " + quizID + 
				" AND UserID = " + userID;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public List<Result> GetAllByQuiz(int quizID) {
		String query = "Select * from results where QuizID = " + quizID;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public List<Result> GetAllByUser(int userID) {
		String query = "Select * from results where UserID = " + userID;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	private AnswerResult GetAnswerResultHelper(ResultSet rs){
		AnswerResult answerResult = null;	
		try {
			if (rs.next()){
				answerResult = new AnswerResult();
				answerResult.SetID(rs.getInt("ID"));
				ResultRepository repo = new ResultRepository(helper);
				answerResult.SetResult(repo.Get(rs.getInt("ResultID")));
				if (rs.getInt("AnswerID")!=0) {
					AnswerRepositor ansrepo = new AnswerRepositor(helper);
					answerResult.SetAnswer(ansrepo.Get(rs.getInt("AnswerID")));
					answerResult.SetText(null);
				} else {
					answerResult.SetAnswer(null);
					answerResult.SetText(rs.getString("Text"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answerResult;
	}

	@Override
	public AnswerResult GetAnswerResult(int id){
		String query = "Select * from answerresults where ID = " + id;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAnswerResultHelper(rs);
	}

	@Override
	public AnswerResult GetAnswerResult(int resultID, int answerID){
		String query = "Select * from answerresults where ResultID = " + resultID +
				" AND AnswerID = " + answerID;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAnswerResultHelper(rs);
	}

	private List<AnswerResult> GetAllAnswerResultByResultHelper(ResultSet rs){
		List<AnswerResult> answerResultList = new ArrayList<AnswerResult>();
		try {
			while (rs.next()) {
				AnswerResult answerResult = new AnswerResult();
				answerResult.SetID(rs.getInt("ID"));
				ResultRepository repo = new ResultRepository(helper);
				answerResult.SetResult(repo.Get(rs.getInt("ResultID")));
				if (rs.getInt("AnswerID")!=0) {
					AnswerRepositor ansrepo = new AnswerRepositor(helper);
					answerResult.SetAnswer(ansrepo.Get(rs.getInt("AnswerID")));
					answerResult.SetText(null);
				} else {
					answerResult.SetAnswer(null);
					answerResult.SetText(rs.getString("Text"));
				}
				answerResultList.add(answerResult);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answerResultList;
	}

	@Override
	public List<AnswerResult> GetAllAnswerResultByResult(int resultID){
		String query = "Select * from answerresults where ResultID = " + resultID;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllAnswerResultByResultHelper(rs);
	}

	@Override
	public List<AnswerResult> GetAllAnswerResultByResult(Result result){
		String query = "Select * from answerresults where ResultID = " + result.GetID();
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllAnswerResultByResultHelper(rs);
	}


	@Override
	public boolean Update(Result result) {
		String sdate = new SimpleDateFormat("yyyy-MM-dd").format(result.GetStartDate());
		String edate = result.GetEndDate()==null? "null" : new SimpleDateFormat("yyyy-MM-dd").format(result.GetEndDate());
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("UserID","" +result.GetUser().GetID());
		mp.put("QuizID","" +result.GetQuiz().GetID());
		mp.put("StartDate","'" +sdate+"'");
		if(!edate.equals("null"))
			mp.put("EndDate","'" +edate+"'");
		mp.put("Score", "" + result.GetScore());
		helper.Update("results", mp, result.GetID());
		return true;
	}

	@Override
	public int Save(Result result) {
		String sdate = new SimpleDateFormat("yyyy-MM-dd").format(result.GetStartDate());
		String edate = result.GetEndDate()==null? "null" : new SimpleDateFormat("yyyy-MM-dd").format(result.GetEndDate());
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("UserID","" +result.GetUser().GetID());
		mp.put("QuizID","" +result.GetQuiz().GetID());		
		mp.put("StartDate","'" +sdate+"'");
		if(!edate.equals("null"))
			mp.put("EndDate","'" +edate+"'");
		mp.put("Score", "" + result.GetScore());
		return helper.Insert("results", mp);
	}

	@Override
	public int SaveAnswerResult(AnswerResult answerResult){
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("ResultID","" + answerResult.GetResult().GetID());
		if (answerResult.GetAnswer()!= null) {
			mp.put("AnswerID","" + answerResult.GetAnswer().GetID());
		} else {
			mp.put("Text", "'" + answerResult.GetText() +"'");
		}
		return helper.Insert("answerresults", mp);
	}

}
