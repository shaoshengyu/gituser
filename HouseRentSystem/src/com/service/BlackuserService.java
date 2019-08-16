package com.service;

import java.util.List;

import com.pojo.Blackuser;

public interface BlackuserService {
	
	public List<Blackuser> getBlack(Blackuser blackuser);
	public int insertBlack(Blackuser blackuser);
	public int updateBlack(Blackuser blackuser);
	public int deleteBlack(Blackuser blackuser);

}
