package Models;

import java.time.Duration;
import java.util.Date;

public class Result {
	private int id;
	private User user;
	private Quiz quiz;
	private Date startDate;
	private Date endDate;
	private int score;
	
	public int GetID(){
		return id;
	}
	public void SetID(int id){
		this.id = id;
	}
	public User GetUser(){
		return user;
	}
	public void SetUser(User user){
		this.user = user;
	}
	public Quiz GetQuiz(){
		return quiz;
	}
	public void SetQuiz(Quiz quiz){
		this.quiz = quiz;
	}
	public Date GetStartDate(){
		return startDate;
	}
	public void SetStartDate(Date startDate){
		this.startDate = startDate;
	}
	public Date GetEndDate(){
		return endDate;
	}
	public void SetEndDate(Date endDate){
		this.endDate = endDate;
	}
	public int GetScore(){
		return score;
	}
	public void SetScore(int score){
		this.score = score;
	}
}
