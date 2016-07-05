package Interfaces;

import java.util.List;

import Models.AnswerResult;
import Models.Result;

public interface IResultRepository {
	public Result Get(int id);
	
	public List<Result> GetAll(int quizID, int userID);
	public List<Result> GetAllByQuiz(int quizID);
	public List<Result> GetAllByUser(int userID);
	
	public boolean Update(Result result);
	public int Save(Result result);
	
	public int SaveAnswerResult(AnswerResult answerResult);
	public AnswerResult GetAnswerResult(int id);
	public AnswerResult GetAnswerResult(int resultID, int answerID);
	public List<AnswerResult> GetAllAnswerResultByResult(int resultID);
	public List<AnswerResult> GetAllAnswerResultByResult(Result result);
	
}
