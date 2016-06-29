package Repository;

import java.util.List;

import Interfaces.IAnswerRepository;
import Models.Answer;
import Models.Question;

public class AnswerRepositor implements IAnswerRepository {

	@Override
	public Answer Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> GetAll(int questionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> GetAll(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Answer answer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Save(Answer answer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void SaveRange(List<Answer> answers) {
		// TODO Auto-generated method stub

	}

}
