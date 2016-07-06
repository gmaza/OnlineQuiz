package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import Database.DatabaseHelper;
import Helper.HashHelper;
import Interfaces.IUserRepository;
import Models.User;

public class UserRepository implements IUserRepository {

	DatabaseHelper helper;
	
	public UserRepository() {
		helper = new DatabaseHelper();
	}
	
	@Override
	public User Get(int id) {
		String query = "Select * from users where ID = " + id;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetHelper(rs);
	}

	@Override
	public User Get(String username) {
		String query = "Select * from users where UserName = '" + username + "'";
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetHelper(rs);
	}
	
	private User GetHelper(ResultSet rs){
		User user = null;
		try {
			if (rs.next()) {
				user = new User();
				user.SetUsername(rs.getString("UserName"));
				user.SetID(rs.getInt("ID"));
				user.SetPasswordHash(rs.getString("PasswordHash"));
				user.SetFirstname(rs.getString("FirstName"));
				user.SetLastname(rs.getString("LastName"));
				user.SetAge(rs.getInt("Age"));
				user.SetMail(rs.getString("Mail"));
				user.SetScore(rs.getInt("Score"));
				user.SetIsAdmin((rs.getInt("IsAdmin")==1)?true:false);
				user.SetLoginToken(rs.getString("LoginToken"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return user;
	}
	
	private List<User> GetAllHelper(ResultSet rs){
		ArrayList<User> userList = new ArrayList<User>();
		try {
			while (rs.next()) {
				User user = new User();
				user.SetUsername(rs.getString("UserName"));
				user.SetID(rs.getInt("ID"));
				user.SetPasswordHash(rs.getString("PasswordHash"));
				user.SetFirstname(rs.getString("FirstName"));
				user.SetLastname(rs.getString("LastName"));
				user.SetAge(rs.getInt("Age"));
				user.SetMail(rs.getString("Mail"));
				user.SetScore(rs.getInt("Score"));
				user.SetIsAdmin((rs.getInt("IsAdmin")==1)?true:false);
				user.SetLoginToken(rs.getString("LoginToken"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public List<User> GetAll() {
		String query = "Select * from users";
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public boolean Delete(int id) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("ID", "" + id );
		helper.Delete("users", mp);
		return true;
	}

	@Override
	public boolean Delete(String username) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("UserName", "'" + username + "'" );
		helper.Delete("users", mp);
		return true;
	}

	@Override
	public boolean Delete(User user) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("ID", "" + user.GetID() );
		helper.Delete("users", mp);
		return true;
	}

	@Override
	public boolean Update(User user) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("UserName","'" +user.GetUsername()+"'");
		mp.put("PasswordHash","'" +user.GetPasswordHash()+"'");
		mp.put("FirstName","'" +user.GetFirstname()+"'");
		mp.put("LastName","'" +user.GetLastname()+"'");
		mp.put("Age",""+user.GetAge());
		mp.put("Mail","'" +user.GetMail()+"'");
		mp.put("Score","" +user.GetScore());
		mp.put("IsAdmin",(user.GetIsAdmin()?"1":"0"));
		mp.put("LoginToken","'" +user.GetLoginToken()+"'");
		helper.Update("users", mp, user.GetID());
		return true;
	}

	@Override
	public boolean ChangePassword(int id, String NewPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Save(User user) {
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("UserName","'" +user.GetUsername()+"'");
		mp.put("PasswordHash","'" +user.GetPasswordHash()+"'");
		mp.put("FirstName","'" +user.GetFirstname()+"'");
		mp.put("LastName","'" +user.GetLastname()+"'");
		mp.put("Age",""+user.GetAge());
		mp.put("Mail","'" +user.GetMail()+"'");
		mp.put("Score","" +user.GetScore());
		mp.put("IsAdmin",(user.GetIsAdmin()?"1":"0"));
		helper.Insert("users", mp);
	}

	@Override
	public void SaveRange(List<User> users) {
		for(User user : users){
			Save(user);
		}
		
	}
	
	public int AddFriend(User from, User to){
		HashMap<String,String> mp = new HashMap<String,String>();
		mp.put("UserID1", "" + from.GetID());
		mp.put("UserID2", "" + to.GetID());
		mp.put("IsConfirmed", "" + 0);
		return helper.Insert("friendships", mp);
	}
	
	public void ConfirmFriend(User from, User to){
		HashMap<String,String> mp1 = new HashMap<String,String>();
		mp1.put("UserID1", "" + from.GetID());
		mp1.put("UserID2", "" + to.GetID());
		mp1.put("IsConfirmed", "" + 1);
		helper.Insert("friendships", mp1);
		
		HashMap<String,String> mp2 = new HashMap<String,String>();
		mp2.put("UserID1", "" + to.GetID());
		mp2.put("UserID2", "" + from.GetID());
		helper.Delete("friendships", mp2);
		mp2.put("IsConfirmed", "" + 1);
		helper.Insert("friendships", mp2);
	}

	@Override
	public List<User> GetFriends(int id) {
		String query = "select users.ID, UserName, PasswordHash, FirstName, LastName, Age, Mail, Score, IsAdmin, LoginToken"
				+ " from friendships inner join users "
				+ "on friendships.UserID2=users.ID "
				+ "where IsConfirmed=1 and friendships.UserID1= " + id;
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public List<User> GetFriends(String username) {
		String query = "select users.ID, UserName, PasswordHash, FirstName, LastName, Age, Mail, Score, IsAdmin, LoginToken"
				+ " from friendships inner join users "
				+ "on friendships.UserID2=users.ID "
				+ "where IsConfirmed=1 and friendships.UserID1= " + Get(username).GetID();
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public List<User> GetFriends(User user) {
		String query = "select users.ID, UserName, PasswordHash, FirstName, LastName, Age, Mail, Score, IsAdmin, LoginToken"
				+ " from friendships inner join users "
				+ "on friendships.UserID2=users.ID "
				+ "where IsConfirmed=1 and friendships.UserID1= " + user.GetID();
		ResultSet rs = helper.ExcecuteSelect(query);
		return GetAllHelper(rs);
	}

	@Override
	public String Login(String username, String Password) {
		User user = Get(username);
		if(user == null) return "";
		HashHelper hh = new HashHelper();
		String st = hh.Hash(Password);
		if (user.GetPasswordHash().equals(st)){
			user.SetLoginToken(UUID.randomUUID().toString());
			Update(user);
			return user.GetLoginToken();
		}
		return "";
	}

	
	
	
}
