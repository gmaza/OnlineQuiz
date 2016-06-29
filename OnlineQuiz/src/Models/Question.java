package Models;

public class Question {
	public enum type {
		QuestionResponse, FillInTheBlank, MultipleChoice, 
		PictureResponse, MultipleChoiceWithMultipleAnswers
	}
	
	private int id;
	private Quiz quiz;
	private String question;
	private type questionType;
	
	public int GetID(){
		return id;
	}
	public void SetID(int id){
		this.id = id;
	}
	public Quiz GetQuiz(){
		return quiz;
	}
	public void SetQuiz(Quiz quiz){
		this.quiz = quiz;
	}
	public String GetQuestion(){
		return question;
	}
	public void SetQuestion(String question){
		this.question = question;
	}
	public type GetQuestionType(){
		return this.questionType;
	}
	public void SetQuestionType(type questionType){
		this.questionType = questionType;
	}
	public void SetQuestionType(int ind){
		this.questionType = type.values()[ind];
	}
}
