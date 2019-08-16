package com.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BlackuserMapper;
import com.pojo.Blackuser;
import com.service.BlackuserService;

@Service
public class BlackuserServiceImp implements BlackuserService{

	@Autowired
	private BlackuserMapper blackuserMapper;
	
	@Override
	public List<Blackuser> getBlack(Blackuser blackuser) {
		return blackuserMapper.selectBlack(blackuser);
	}

	@Override
	public int insertBlack(Blackuser blackuser) {
		return blackuserMapper.insertBlack(blackuser);
	}

	@Override
	public int updateBlack(Blackuser blackuser) {
		return blackuserMapper.updateBlack(blackuser);
	}

	@Override
	public int deleteBlack(Blackuser blackuser) {
		return blackuserMapper.deleteBlack(blackuser);
	}
}
