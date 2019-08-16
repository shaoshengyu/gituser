package com.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MessageinfoMapper;
import com.pojo.Messageinfo;
import com.service.MessageinfoService;

@Service
public class MessageinfoServiceImp implements MessageinfoService {

	@Autowired
	private MessageinfoMapper messageinfoMapper;
	
	
	@Override
	public List<Messageinfo> getMessage(Messageinfo messageinfo) {
		return messageinfoMapper.selectMessage(messageinfo);
	}

	@Override
	public int addMessage(Messageinfo messageinfo) {
		return messageinfoMapper.insertMessage(messageinfo);
	}

	@Override
	public int updateMessage(Messageinfo messageinfo) {
		return messageinfoMapper.updateMessage(messageinfo);
	}

	@Override
	public int deleteMessage(Messageinfo messageinfo) {
		return messageinfoMapper.deleteMessage(messageinfo);
	}


}
