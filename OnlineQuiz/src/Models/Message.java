package Models;

public class Message {
	private int _id;
	private String _name;
	private String _content;
	private User _userFrom;
	private User _userTo;
	private boolean _isRead;
	
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
	
	public String GetContent(){
		return _content;
	}	
	public void SetContent(String content){
		_content = content;
	}
	
	public User GetUserFrom(){
		return _userFrom;
	}	
	public void SetUserFrom(User user){
		_userFrom = user;
	}
	
	public User GetUserTo(){
		return _userTo;
	}	
	public void SetUserTo(User user){
		_userTo = user;
	}
	
	public boolean GetIsRead(){
		return _isRead;
	}	
	public void SetIsRead(boolean isRead){
		_isRead = isRead;
	}
}
