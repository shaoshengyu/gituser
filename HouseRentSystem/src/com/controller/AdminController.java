package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Blackuser;
import com.pojo.Reportinfo;
import com.pojo.Transactioninfo;
import com.pojo.Userinfo;
import com.service.BlackuserService;
import com.service.ReportinfoService;
import com.service.TransactioninfoService;
import com.service.UserinfoService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	ReportinfoService reportservice;

	@Autowired
	BlackuserService blackuserService;

	@Autowired
	UserinfoService userinfoService;
	
	@Autowired
	TransactioninfoService transservice;
   //处理举报信息--显示举报信息
	@RequestMapping("/chulijuBao")
	public String chulijuBao(Blackuser blackuser,HttpSession session,HttpServletRequest request) {
		List<Blackuser> ba = blackuserService.getBlack(blackuser);
		 if(ba.size()==0){
			    session.setAttribute("chulijuBaomsg", "无举报信息");
				return "adminchulijubao";
			}else{
				session.setAttribute("chulijuBaomsg", "");
				request.setAttribute("jubaoList",ba);
				return "adminchulijubao";
			}			
	}
	//处理举报信息--正确举报
	@RequestMapping(value="/chulijubaoa")
	public String chuliblacka(Blackuser blackuser,HttpSession session,HttpServletRequest request){
		Userinfo un=new Userinfo();
		un.setUserid(blackuser.getUserid());
		un.setUserstatus("禁用");
		userinfoService.updateUser(un);	
		blackuserService.deleteBlack(blackuser);
		Blackuser bl=new Blackuser();
		List<Blackuser> ba = blackuserService.getBlack(bl);
		 if(ba.size()==0){
			    session.setAttribute("chulijuBaomsg", "无举报信息");
				return "adminchulijubao";
			}else{
				session.setAttribute("chulijuBaomsg", "");
				request.setAttribute("jubaoList",ba);
				return "adminchulijubao";
			}		
	}
	//处理举报信息--错误举报
	@RequestMapping(value="/chulijubaob")
	public String chuliblackb(Blackuser blackuser,HttpSession session,HttpServletRequest request){
		blackuser.setBlackid(blackuser.getBlackid());
		blackuserService.deleteBlack(blackuser);		
		
		Blackuser bl=new Blackuser();
		List<Blackuser> ba = blackuserService.getBlack(bl);
		if(ba.size()==0){
		    session.setAttribute("chulijuBaomsg", "无举报信息");
			return "adminchulijubao";
		}else{
			session.setAttribute("chulijuBaomsg", "");
			request.setAttribute("jubaoList",ba);
			return "adminchulijubao";
		}			
	}
	//管理员查看当天交易记录
	@RequestMapping("/seltrans")
	public String selecttrans(Transactioninfo transinfo,HttpServletRequest request,HttpSession session) {
		List<Transactioninfo> trans = transservice.getTransaction(transinfo);
		if(trans.size()==0){
			session.setAttribute("tranmsg", "对不起，未找到符合条件的交易记录");
			return "adminchakanjiaoyi";
		}else{
			session.setAttribute("tranmsg", "");
			request.setAttribute("transList", trans);
			return "adminchakanjiaoyi";
			}
		
	}
	
	//查看评价信息
		@RequestMapping("/selrep")
		public String selectreps(Reportinfo reportinfo,HttpServletRequest request,HttpSession session) {
			List<Reportinfo> rep = reportservice.getReport(reportinfo);
			if(rep.size()==0){
				session.setAttribute("repmsg", "对不起，未找到符合条件的评价记录");
				return "adminchakanpingjia";
			}else{
				session.setAttribute("repmsg", "");
				request.setAttribute("repList", rep);
				return "adminchakanpingjia";
				}
			
		}

}
