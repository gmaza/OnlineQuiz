package Repository;

import java.util.ArrayList;
import java.util.List;

import Interfaces.IQuestionRepository;
import Models.Question;
import Models.Quiz;

public class QuestionRepository implements IQuestionRepository {

	@Override
	public Question Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> GetAll(int quizID) {
		List<Question> questions = new ArrayList<Question>();
		
		for(int i=0; i< 5; i++){
			Question question = new Question();
			question.SetID(i);
			question.SetQuestion("vin shechama venaxi?");
			question.SetQuestionType(0);
			questions.add(question);
		}
		return questions;
	}

	@Override
	public List<Question> GetAll(Quiz quiz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Save(Question question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void SaveRange(List<Quiz> questions) {
		// TODO Auto-generated method stub

	}

}
