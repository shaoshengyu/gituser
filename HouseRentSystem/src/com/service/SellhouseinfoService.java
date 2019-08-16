package com.service;

import java.util.List;

import com.pojo.Sellhouseinfo;



public interface SellhouseinfoService {
	public List<Sellhouseinfo> getSell(Sellhouseinfo sellhouseinfo);
	public int insertSell(Sellhouseinfo sellhouseinfo);
	public int updateSell(Sellhouseinfo sellhouseinfo);
	public int deleteSell(Sellhouseinfo sellhouseinfo);

}
