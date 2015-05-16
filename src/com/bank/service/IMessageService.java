package com.bank.service;

import java.util.List;

import com.bank.beans.Message;
import com.common.service.GenericService;

public interface IMessageService extends GenericService<Message, String>{

	Message loadMessage(String messageId);

	String saveMessage(Message message);

	void updateMessage(Message message);

	void deleteMessage(String messageId);

	List<Message> loadAllMessages(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder);

	
}
