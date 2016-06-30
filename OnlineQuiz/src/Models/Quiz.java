package Models;

import java.util.Date;

public class Quiz {
	private int _id;
	private String _name;
	private Date _createDate;
	private User _author;
	private int _questionsNum;
	private int _takenNum;
	
	public int GetID(){
		return _id;
	}	
	public void SetID(int id){
		_id = id;
	}
	
	public String GetName(){
		return _name;
	}
	public void SetName(String name){
		_name = name;
	}
	
	public Date GetDate(){
		return _createDate;
	}	
	public void SetDate(Date date){
		_createDate = date;
	}
	
	public User GetAuthor(){
		return _author;
	}	
	public void SetAuthor(User author){
		_author = author;
	}
	public int GetNumberOfQuestions(){
		return _questionsNum;
	}
	public void SetNumberOfQuestions(int questionsNum){
		_questionsNum = questionsNum;
	}
	public int GetTakenNumber(){
		return _takenNum;
	}
	public void SetTakenNumber(int takenNum){
		_takenNum = takenNum;
	}
}
