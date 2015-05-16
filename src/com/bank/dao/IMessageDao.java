package com.bank.dao;

import java.util.List;

import com.bank.beans.Menu;
import com.bank.beans.Message;
import com.common.dao.GenericDAO;


public interface IMessageDao extends GenericDAO<Message, Long> {
	
	public Message getMessageById(String messageId);

	public String insertMessage(Message message);
	
	public void updateMessage(Message message);

	public void deleteMessage(String messageId);

	public List<Message> loadAllMessages(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder);


}
