package com.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TransactioninfoMapper;
import com.pojo.Transactioninfo;
import com.service.TransactioninfoService;
@Service
public class TransactioninfoServiceImp implements TransactioninfoService{
	@Autowired
	private TransactioninfoMapper transactioninfoMapper;
	
	@Override
	public List<Transactioninfo> getTransaction(Transactioninfo transactioninfo) {
		return transactioninfoMapper.selectTransaction(transactioninfo);
	}

	@Override
	public int addTransaction(Transactioninfo transactioninfo) {
		return transactioninfoMapper.insertTransaction(transactioninfo);
	}

	@Override
	public int updateTransaction(Transactioninfo transactioninfo) {
		return transactioninfoMapper.updateTransaction(transactioninfo);
	}

	@Override
	public int deleteTransaction(Transactioninfo transactioninfo) {
		return transactioninfoMapper.deleteTransaction(transactioninfo);
	}

}
