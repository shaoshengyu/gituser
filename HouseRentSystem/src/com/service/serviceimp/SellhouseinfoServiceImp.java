package com.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SellhouseinfoMapper;
import com.pojo.Sellhouseinfo;
import com.service.SellhouseinfoService;

@Service
public class SellhouseinfoServiceImp implements SellhouseinfoService{

	@Autowired
	private SellhouseinfoMapper sellhouseinfoMapper;
	
	@Override
	public List<Sellhouseinfo> getSell(Sellhouseinfo sellhouseinfo) {
		return sellhouseinfoMapper.selectSell(sellhouseinfo);
	}

	@Override
	public int insertSell(Sellhouseinfo sellhouseinfo) {
		return sellhouseinfoMapper.insertSell(sellhouseinfo);
	}

	@Override
	public int updateSell(Sellhouseinfo sellhouseinfo) {
		return sellhouseinfoMapper.updateSell(sellhouseinfo);
	}

	@Override
	public int deleteSell(Sellhouseinfo sellhouseinfo) {
		return sellhouseinfoMapper.deleteSell(sellhouseinfo);
	}

}
