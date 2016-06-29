package Interfaces;

import java.util.List;

import Models.User;

public interface IUserRepository {
	public User Get(int id);
	public User Get(String username);
	public List<User> GetAll();
	
	public boolean Delete(int id);
	public boolean Delete(String username);
	public boolean Delete(User user);
	
	public boolean Update(User user);
	public boolean ChangePassword(int id, String NewPassword); 
	
	public void Save(User user);
	public void SaveRange(List<User> users);
	
	public List<User> GetFriends(int id);
	public List<User> GetFriends(String  username);
	public List<User> GetFriends(User  user);	
	
	public String Login(String username, String Password);
}
