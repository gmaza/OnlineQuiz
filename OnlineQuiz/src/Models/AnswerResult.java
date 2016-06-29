package Models;

public class AnswerResult {
	private int id;
	private Result result;
	private Answer answer;
	private String text;

	public int GetID(){
		return id;
	}
	public void SetID(int id){
		this.id = id;
	}
	public Result GetResult(){
		return result;
	}
	public void SetResult(Result result){
		this.result = result;
	}
	public Answer GetAnswer(){
		return answer;
	}
	public void SetAnswer(Answer answer){
		this.answer = answer;
	}
	public String GetText(){
		return text;
	}
	public void SetText(String text){
		this.text = text;
	}
}
