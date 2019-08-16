package com.dao;

import java.util.List;

import com.pojo.Messageinfo;

public interface MessageinfoMapper {
	public List<Messageinfo> selectMessage(Messageinfo messageinfo);
	public int insertMessage(Messageinfo messageinfo);
	public int updateMessage(Messageinfo messageinfo);
	public int deleteMessage(Messageinfo messageinfo);
}