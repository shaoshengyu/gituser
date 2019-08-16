package com.dao;

import java.util.List;

import com.pojo.Sellhouseinfo;


public interface SellhouseinfoMapper {

	public List<Sellhouseinfo> selectSell(Sellhouseinfo sellhouseinfo);
	public int insertSell(Sellhouseinfo sellhouseinfo);
	public int updateSell(Sellhouseinfo sellhouseinfo);
	public int deleteSell(Sellhouseinfo sellhouseinfo);
}