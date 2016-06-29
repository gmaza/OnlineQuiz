package Repository;

import java.util.List;

import Interfaces.IUserRepository;
import Models.User;

public class UserRepository implements IUserRepository {

	@Override
	public User Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User Get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ChangePassword(int id, String NewPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Save(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void SaveRange(List<User> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> GetFriends(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> GetFriends(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> GetFriends(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Login(String username, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
