package com.service;

import java.util.List;

import com.pojo.Userinfo;

public interface UserinfoService {
	public List<Userinfo> getUser(Userinfo userinfo);
	public int addUser(Userinfo userinfo);
	public int updateUser(Userinfo userinfo);
	public int deleteUser(Userinfo userinfo);
}
