package Interfaces;

import java.util.List;

import Models.Message;

public interface IMessageRepository {
	public Message Get(int id);
	public List<Message> GetAll();
	public List<Message> GetAllFrom(int userID);
	public List<Message> GetAllTo(int userID);
	public List<Message> GetAll(int userFrom, int userID );
	
	public boolean Update(Message message);
	public void Save(Message message);

}
