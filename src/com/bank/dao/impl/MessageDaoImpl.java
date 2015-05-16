package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bank.beans.Message;
import com.bank.dao.IMessageDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("messageDao")
public class MessageDaoImpl extends GenericMyBatisDAOSupport<Message, Long> implements IMessageDao {

	@Override
	public Message getMessageById(String messageId) {
		Message message = getSqlSession().selectOne("message.getMessageById", messageId);
		return message;
	}

	public String insertMessage(Message message) {
		String messageId = (message.getMessageId() == null || message.getMessageId().toString().equals(""))? UUID.randomUUID().toString() : message.getMessageId();
		message.setMessageId(messageId);
		getSqlSession().insert("message.insertSelective", message);
		return message.getMessageId();
	}
	
	@Override
	public void updateMessage(Message message) {
		getSqlSession().update("message.update", message);
		
	}

	public void deleteMessage(String messageId) {
		getSqlSession().delete("message.delete", messageId);
	}

	@Override
	public List<Message> loadAllMessages(String key, int pageIndex, int pageSize, String sortField, String sortOrder) {
		Map<String, Object> map = new HashMap();
		int start = pageIndex * pageSize, end = start + pageSize;
		if ("desc".equals(sortOrder) == false) sortOrder = "asc";
		map.put("start", start);
		map.put("end", end);
		map.put("sortOrder", sortOrder);
		map.put("sortField", sortField);
		map.put("key", key);
		List<Message> messages = getSqlSession().selectList("message.loadAllMessages", map);
		return messages;
	}



}
