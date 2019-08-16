package com.service;

import java.util.List;

import com.pojo.Transactioninfo;

public interface TransactioninfoService {
	public List<Transactioninfo> getTransaction(Transactioninfo transactioninfo);
	public int addTransaction(Transactioninfo transactioninfo);
	public int updateTransaction(Transactioninfo transactioninfo);
	public int deleteTransaction(Transactioninfo transactioninfo);

}
