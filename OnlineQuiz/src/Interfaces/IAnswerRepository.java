package Interfaces;

import java.util.List;

import Models.Answer;
import Models.Question;

public interface IAnswerRepository {
	public Answer Get(int id);
	public List<Answer> GetAll();
	public List<Answer> GetAll(int questionID);
	public List<Answer> GetAll(Question question);
	
	public boolean Delete(int id);
	
	public boolean Update(Answer answer);
	
	public int Save(Answer answer);
	public void SaveRange(List<Answer> answers);
}
