package Repository;

import Database.DatabaseHelper;
import Interfaces.*;
import sun.reflect.generics.repository.AbstractRepository;

public class UnitOfWork {
	public UnitOfWork(){
		DatabaseHelper helper = new DatabaseHelper();
		_answers = new AnswerRepositor(helper);
		_messages =new MessageRepository();
		_questions=new QuestionRepository(helper);
		_quizes=new QuizRepository(helper);
		_results=new ResultRepository(helper);
		_users=new UserRepository(helper);
	}
	
	public IAnswerRepository GetAnswers(){
		return _answers;
	}
	
	public IMessageRepository GetMessages(){
		return _messages;
	}
	public IQuestionRepository GetQuestions(){
		return _questions;
	}
	public IQuizRepository GetQuizes(){
		return _quizes;
	}
	public IResultRepository GetResults(){
		return _results;
	}
	public IUserRepository GetUsers(){
		return _users;
	}	
	
	private IAnswerRepository _answers;
	private IMessageRepository _messages;
	private IQuestionRepository _questions;
	private IQuizRepository _quizes;
	private IResultRepository _results;
	private IUserRepository _users;
}
