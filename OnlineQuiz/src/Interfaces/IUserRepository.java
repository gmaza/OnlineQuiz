package Interfaces;

import java.util.List;

import Models.User;

public interface IUserRepository {
	public User Get(int id);
	public User Get(String username);
	public List<User> GetAll();
	
	public int Delete(int id);
	public int Delete(String username);
	public int Delete(User user);
	
	public int Update(User user);
	
	public void Save(User user);	
	
	public List<User> GetFriends(int id);
	public List<User> GetFriends(String  username);
	public List<User> GetFriends(User  user);
	
	public boolean Login(String username, String Password);
}
