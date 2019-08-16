package com.service;

import java.util.List;

import com.pojo.Reportinfo;

public interface ReportinfoService {
	//Service中的JAVA文件连接dao层里的文件
	public List<Reportinfo> getReport(Reportinfo reportinfo);
	public int addReport(Reportinfo reportinfo);
	public int updateReport(Reportinfo reportinfo);
	public int deleteReport(Reportinfo reportinfo);
}
