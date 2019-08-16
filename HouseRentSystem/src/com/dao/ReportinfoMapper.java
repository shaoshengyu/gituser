package com.dao;

import java.util.List;

import com.pojo.Reportinfo;


public interface ReportinfoMapper {
    
	public List<Reportinfo> selectReport(Reportinfo reportinfo);
	public int insertReport(Reportinfo reportinfo);
	public int updateReport(Reportinfo reportinfo);
	public int deleteReport(Reportinfo reportinfo);
}