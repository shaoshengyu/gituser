package com.dao;

import java.util.List;

import com.pojo.Userinfo;

public interface UserinfoMapper {
	//方法名跟 .xml文件中的id相同
	public List<Userinfo> selectUser(Userinfo userinfo);
	public int insertUser(Userinfo userinfo);
	public int updateUser(Userinfo userinfo);
	public int deleteUser(Userinfo userinfo);
}