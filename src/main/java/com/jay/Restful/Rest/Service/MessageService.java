package com.jay.Restful.Rest.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.jay.Restful.Db.DatabaseClass;
import com.jay.Restful.Rest.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessage();

	public MessageService(){
		messages.put(1L, new Message(1, "Hello World", "Jayavardhan"));
		messages.put(2L, new Message(2, "Hello India", "Patil"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()){
			cal.setTime(message.getDate());
			if(cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;

	}
	

	public Message getmessage(Long id) {
		return messages.get(id);
	}
	
	public Message addmessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message UpdateMessage(Message message){
		if (message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removemessage(long id){
		return messages.remove(id);
	}
}
