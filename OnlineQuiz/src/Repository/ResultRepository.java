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
import Models.Result;

public class ResultRepository implements IResultRepository {

	DatabaseHelper helper;

	public ResultRepository() {
		helper = new DatabaseHelper();
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
				UserRepository userrepo = new UserRepository();
				result.SetUser(userrepo.Get(rs.getInt("UserID")));
				QuizRepository quizrepo = new QuizRepository();
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
				UserRepository userrepo = new UserRepository();
				result.SetUser(userrepo.Get(rs.getInt("UserID")));
				QuizRepository quizrepo = new QuizRepository();
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
				"AND UserID = " + userID;
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

	@Override
	public boolean Update(Result result) {
		String sdate = new SimpleDateFormat("yyyy-MM-dd").format(result.GetStartDate());
		String edate = new SimpleDateFormat("yyyy-MM-dd").format(result.GetEndDate());
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("UserID","" +result.GetUser().GetID());
		mp.put("QuizID","" +result.GetQuiz().GetID());
		mp.put("StartDate","'" +sdate+"'");
		mp.put("EndDate","'" +edate+"'");
		mp.put("Score", "" + result.GetScore());
		helper.Update("results", mp, result.GetID());
		return true;
	}

	@Override
	public int Save(Result result) {
		String sdate = new SimpleDateFormat("yyyy-MM-dd").format(result.GetStartDate());
		String edate = new SimpleDateFormat("yyyy-MM-dd").format(result.GetEndDate());
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("UserID","" +result.GetUser().GetID());
		mp.put("QuizID","" +result.GetQuiz().GetID());
		mp.put("StartDate","'" +sdate+"'");
		mp.put("EndDate","'" +edate+"'");
		mp.put("Score", "" + result.GetScore());
		return helper.Insert("results", mp);
	}

}
