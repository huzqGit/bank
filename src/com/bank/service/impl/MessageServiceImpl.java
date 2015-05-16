package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Message;
import com.bank.dao.IMessageDao;
import com.bank.service.IMessageService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("messageService")
public class MessageServiceImpl extends GenericServiceImpl<Message, String>  implements IMessageService {
	@Resource
	private IMessageDao messageDao;
	
	@Override
	public Message loadMessage(String messageId) {
		Message message = messageDao.getMessageById(messageId);
		return message;
	}
	@Override
	public String saveMessage(Message message) {
		String messageId = messageDao.insertMessage(message);
		return messageId;
	}
	@Override
	public void updateMessage(Message message) {
		messageDao.updateMessage(message);
		
	}
	@Override
	public void deleteMessage(String messageId) {
		messageDao.deleteMessage(messageId);
	}
	@Override
	public List<Message> loadAllMessages(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder) {
		List<Message> messages = messageDao.loadAllMessages(key, pageIndex, pageSize, sortField, sortOrder);
		return messages;
	}
	@Override
	public GenericDAO<Message, String> getGenericDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
