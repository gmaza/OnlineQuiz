package Models;

public class User {
	private int _id;
	private String _username;
	private String _passwordHash;
	private String _firstname;
	private String _lastname;
	private int _age;
	private String _mail;
	private int _score;
	private boolean _isAdmin;
	private String _loginToken;
	
	public int GetID(){
		return _id;
	}
	public void SetID(int id){
		_id = id;
	}

	public String GetUsername(){
		return _username;
	}
	
	public void SetUsername(String username){
		_username = username;
	}

	public String GetPasswordHash(){
		return _passwordHash;
	}
	
	public void SetPasswordHash(String passwordHash){
		_passwordHash = passwordHash;
	}
	
	public String GetFirstname(){
		return _firstname;
	}
	
	public void SetFirstname(String firstname){
		_firstname = firstname;
	}

	
	public String GetLastname(){
		return _lastname;
	}
	public void SetLastname(String lastname){
		_lastname = lastname;
	}

	
	public String GetMail(){
		return _mail;
	}
	public void SetMail(String mail){
		_mail = mail;
	}

	
	public int GetAge(){
		return _age;
	}
	public void SetAge(int age){
		_age = age;
	}
	
	public int GetScore(){
		return _score;
	}
	public void SetScore(int score){
		_score = score;
	}
	
	public boolean GetIsAdmin(){
		return _isAdmin;
	}
	public void SetIsAdmin(boolean isAdmin){
		_isAdmin = isAdmin;
	}
	public String GetLoginToken(){
		return _loginToken;
	}
	public void SetLoginToken(String loginToken){
		_loginToken = loginToken;
	}
}

