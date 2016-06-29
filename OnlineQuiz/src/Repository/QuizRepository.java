package Repository;

import java.util.List;

import Interfaces.IQuizRepository;
import Models.Quiz;
import Models.User;

public class QuizRepository implements IQuizRepository {

	@Override
	public Quiz Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quiz> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quiz> GetAll(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quiz> GetAll(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quiz> GetAll(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Quiz quiz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Save(Quiz quiz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SaveRange(List<Quiz> quizes) {
		// TODO Auto-generated method stub
		
	}

}
