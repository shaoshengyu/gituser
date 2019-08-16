package com.dao;

import java.util.List;

import com.pojo.Transactioninfo;


public interface TransactioninfoMapper {
	public List<Transactioninfo> selectTransaction(Transactioninfo transactioninfo);
	public int insertTransaction(Transactioninfo transactioninfo);
	public int updateTransaction(Transactioninfo transactioninfo);
	public int deleteTransaction(Transactioninfo transactioninfo);
}