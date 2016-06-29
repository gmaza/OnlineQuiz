package Models;

import java.time.Duration;
import java.util.Date;

public class Result {
	private int id;
	private User user;
	private Quiz quiz;
	private Date date;
	private Duration time;
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
	public Date GetDate(){
		return date;
	}
	public void SetDate(Date date){
		this.date = date;
	}
	public Duration GetTime(){
		return time;
	}
	public void SetTime(Duration time){
		this.time = time;
	}
	public int GetScore(){
		return score;
	}
	public void SetScore(int score){
		this.score = score;
	}
}
