package com.service;

import java.util.List;

import com.pojo.Messageinfo;

public interface MessageinfoService {
	public List<Messageinfo> getMessage(Messageinfo messageinfo);
	public int addMessage(Messageinfo messageinfo);
	public int updateMessage(Messageinfo messageinfo);
	public int deleteMessage(Messageinfo messageinfo);
}
