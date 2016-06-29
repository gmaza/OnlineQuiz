package Repository;

import java.util.List;

import Interfaces.IResultRepository;
import Models.Result;

public class ResultRepository implements IResultRepository {

	@Override
	public Result Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> GetAll(int quizID, int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> GetAllByQuiz(int quizID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> GetAllByUser(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Update(Result result) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Save(Result result) {
		// TODO Auto-generated method stub

	}

}
