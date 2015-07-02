package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;










import com.bank.beans.Message;
import com.bank.beans.MessageExample;
import com.bank.beans.MessageReader;
import com.bank.dao.IMessageDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("messageDao")
public class MessageDaoImpl extends GenericMyBatisDAOSupport<Message, Long> implements IMessageDao {



	@Override
	public int countByExample(MessageExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(MessageExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().delete("message.deleteByExample", example);
		return num;
	}

	@Override
	public int insert(Message record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert("message.insert", record);
		return num;
	}

	@Override
	public int insertSelective(Message record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Message> selectByExample(MessageExample example) {
		// TODO Auto-generated method stub
		List<Message> messages = this.getSqlSession().selectList("message.selectByExample",example);
		return messages;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateByExampleSelective(Message record, MessageExample example) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update("message.updateByExampleSelective", map);
		return num;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateByExample(Message record, MessageExample example) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update("message.updateByExampleSelective", map);
		return num;
	}

	@Override
	public List<Message> loadAllMessages(String key, int pageIndex, int pageSize, String sortField, String sortOrder) {
		Map<String, Object> map = new HashMap<String,Object>();
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
	@Override
	public int selectReadNumByUser(String userid, Long messageid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("messageid", messageid);
		int num = this.getSqlSession().selectOne("message.selectReadNumByUser", map);
		return num;
	}

	@Override
	public int insertMessageReader(MessageReader messageReader) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert("message.insertMessageReader",messageReader);
		return num;
	}

}
