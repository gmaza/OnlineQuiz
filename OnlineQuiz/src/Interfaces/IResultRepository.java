package Interfaces;

import java.util.List;

import Models.Result;

public interface IResultRepository {
	public Result Get(int id);
	
	public List<Result> GetAll(int quizID, int userID);
	public List<Result> GetAllByQuiz(int quizID);
	public List<Result> GetAllByUser(int userID);
	
	public boolean Update(Result result);
	public int Save(Result result);
}
