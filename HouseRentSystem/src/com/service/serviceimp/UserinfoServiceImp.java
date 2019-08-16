package com.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserinfoMapper;
import com.pojo.Userinfo;
import com.service.UserinfoService;

@Service
public class UserinfoServiceImp implements UserinfoService {

	@Autowired
	private UserinfoMapper userinfoMapper;
	
	@Override
	public List<Userinfo> getUser(Userinfo userinfo) {
		return userinfoMapper.selectUser(userinfo);
	}

	@Override
	public int addUser(Userinfo userinfo) {
		return userinfoMapper.insertUser(userinfo);
	}

	@Override
	public int updateUser(Userinfo userinfo) {
		return userinfoMapper.updateUser(userinfo);
	}

	@Override
	public int deleteUser(Userinfo userinfo) {
		return userinfoMapper.deleteUser(userinfo);
	}

}
