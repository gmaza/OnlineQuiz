package Repository;

import java.util.List;

import Interfaces.IMessageRepository;
import Models.Message;

public class MessageRepository implements IMessageRepository {

	@Override
	public Message Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> GetAllFrom(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> GetAllTo(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> GetAll(int userFrom, int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Update(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Save(Message message) {
		// TODO Auto-generated method stub

	}

}
