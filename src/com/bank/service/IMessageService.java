package com.bank.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;





import com.bank.beans.Message;
import com.bank.beans.MessageExample;
import com.bank.beans.MessageReader;
import com.common.service.GenericService;

public interface IMessageService extends GenericService<Message, Long>{

    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

	List<Message> loadAllMessages(String userid,String key, int pageIndex, int pageSize,
			String sortField, String sortOrder);

	public int selectReadNumByUser(String userid,Long messageid);
	
	public int insertMessageReader(MessageReader messageReader);
	
	public List<Message> selectMessagesByUser(Integer num,String userid);

}
