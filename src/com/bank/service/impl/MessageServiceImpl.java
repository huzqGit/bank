package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;






import com.bank.beans.Message;
import com.bank.beans.MessageExample;
import com.bank.beans.MessageReader;
import com.bank.dao.IMessageDao;
import com.bank.service.IMessageService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("messageService")
public class MessageServiceImpl extends GenericServiceImpl<Message, Long>  implements IMessageService {
	@Resource
	private IMessageDao messageDao;
	

	@Override
	public GenericDAO<Message, Long> getGenericDAO() {
		// TODO Auto-generated method stub
		return messageDao;
	}


	@Override
	public int countByExample(MessageExample example) {
		// TODO Auto-generated method stub
		return messageDao.countByExample(example);
	}


	@Override
	public int deleteByExample(MessageExample example) {
		// TODO Auto-generated method stub
		return messageDao.deleteByExample(example);
	}


	@Override
	public int insert(Message record) {
		// TODO Auto-generated method stub
		return messageDao.insert(record);
	}


	@Override
	public int insertSelective(Message record) {
		// TODO Auto-generated method stub
		return messageDao.insertSelective(record);
	}


	@Override
	public List<Message> selectByExample(MessageExample example) {
		// TODO Auto-generated method stub
		return messageDao.selectByExample(example);
	}


	@Override
	public int updateByExampleSelective(Message record, MessageExample example) {
		// TODO Auto-generated method stub
		return messageDao.updateByExampleSelective(record, example);
	}


	@Override
	public int updateByExample(Message record, MessageExample example) {
		// TODO Auto-generated method stub
		return messageDao.updateByExample(record, example);
	}


	@Override
	public List<Message> loadAllMessages(String userid,String key, int pageIndex,
			int pageSize, String sortField, String sortOrder) {
		// TODO Auto-generated method stub
		List<Message> messages = messageDao.loadAllMessages(key, pageIndex, pageSize, sortField, sortOrder);
		if(userid!=null){
			for(Message message:messages){
				int num = messageDao.selectReadNumByUser(userid, message.getMessageid());
				message.setReadnum(num);
			}
		}
		return messages;
	}


	@Override
	public int selectReadNumByUser(String userid, Long messageid) {
		// TODO Auto-generated method stub
		return messageDao.selectReadNumByUser(userid, messageid);
	}


	@Override
	public int insertMessageReader(MessageReader messageReader) {
		// TODO Auto-generated method stub
		int num = messageDao.insertMessageReader(messageReader);
		return num;
	}


	@Override
	public List<Message> selectMessagesByUser(Integer num, String userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
