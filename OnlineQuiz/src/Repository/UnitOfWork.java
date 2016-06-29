package Repository;

import Interfaces.*;
import sun.reflect.generics.repository.AbstractRepository;

public class UnitOfWork {
	public UnitOfWork(){
		_answers = new AnswerRepositor();
		_messages =new MessageRepository();
		_questions=new QuestionRepository();
		_quizes=new QuizRepository();
		_results=new ResultRepository();
		_users=new UserRepository();
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
