package Interfaces;

import java.util.List;

import Models.Quiz;
import Models.User;

public interface IQuizRepository {
	public Quiz Get(int id);
	public List<Quiz> GetAll();
	public List<Quiz> GetAll(int userID);
	public List<Quiz> GetAll(User user);
	public List<Quiz> GetAll(String username);
	
	public boolean Delete(int id);
	
	public boolean Update(Quiz quiz);
	
	public int Save(Quiz quiz);
	public void SaveRange(List<Quiz> quizes);
}
