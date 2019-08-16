package com.dao;

import java.util.List;

import com.pojo.Blackuser;

public interface BlackuserMapper {


	public List<Blackuser> selectBlack(Blackuser blackuser);
	public int insertBlack(Blackuser blackuser);
	public int updateBlack(Blackuser blackuser);
	public int deleteBlack(Blackuser blackuser);
}