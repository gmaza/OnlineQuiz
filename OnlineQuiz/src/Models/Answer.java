package Models;

import Models.Question.type;

public class Answer {
	private int id;
	private Question question;
	private String answer;
	private boolean answerType;
	
	public int GetID(){
		return id;
	}
	public void SetID(int id){
		this.id = id;
	}
	public Question GetQuestion(){
		return question;
	}
	public void SetQuestion(Question question){
		this.question = question;
	}
	public String GetAnswer(){
		return answer;
	}
	public void SetAnswer(String answer){
		this.answer = answer;
	}
	public boolean GetAnswerType(){
		return this.answerType;
	}
	public void SetAnswerType(boolean answerType){
		this.answerType = answerType;
	}
	
}
