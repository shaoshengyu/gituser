package com.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ReportinfoMapper;
import com.pojo.Reportinfo;
import com.service.ReportinfoService;

@Service
public class ReportinfoServiceImp implements ReportinfoService{
	
	@Autowired
	private ReportinfoMapper reportinfoMapper;
	
	@Override
	public List<Reportinfo> getReport(Reportinfo reportinfo){
		return reportinfoMapper.selectReport(reportinfo);
	}
	
	@Override
	public int addReport(Reportinfo reportinfo){
		return reportinfoMapper.insertReport(reportinfo);
	}
	
	@Override
	public int updateReport(Reportinfo reportinfo){
		return reportinfoMapper.updateReport(reportinfo);
	}
	
	@Override
	public int deleteReport(Reportinfo reportinfo){
		return reportinfoMapper.deleteReport(reportinfo);
	}

}
