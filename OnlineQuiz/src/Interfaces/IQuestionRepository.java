package Interfaces;

import java.util.List;


import Models.Question;
import Models.Quiz;

public interface IQuestionRepository {
	public Question Get(int id);
	public List<Question> GetAll();
	public List<Question> GetAll(int quizID);
	public List<Question> GetAll(Quiz quiz);
	
	public boolean Delete(int id);
	
	public boolean Update(Question question);
	
	public void Save(Question question);
	public void SaveRange(List<Quiz> questions);
}
