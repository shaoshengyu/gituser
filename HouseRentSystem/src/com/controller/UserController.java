package com.controller;


import java.io.File;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pojo.Blackuser;
import com.pojo.FilePo;
import com.pojo.Messageinfo;
import com.pojo.Reportinfo;
import com.pojo.Sellhouseinfo;
import com.pojo.Transactioninfo;
import com.pojo.Userinfo;
import com.service.BlackuserService;
import com.service.MessageinfoService;
import com.service.ReportinfoService;
import com.service.SellhouseinfoService;
import com.service.TransactioninfoService;
import com.service.UserinfoService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	SellhouseinfoService sellhouseinfoService;
	
	@Autowired
	UserinfoService userinfoService;
	
	@Autowired
	TransactioninfoService transactioninfoService;
	
	@Autowired
	BlackuserService blackuserService;

	@Autowired
	TransactioninfoService transservice;
	
	@Autowired
	ReportinfoService reportinfoService;
	
	@Autowired
	MessageinfoService messageinfoService;
	
	@RequestMapping("/useraddhouse")
	public String addhouse() {
		return "userAddhouse";
	}
	
	
	//用户上传房源
	@RequestMapping(value="/addHouse")
	public String addHouse(Sellhouseinfo sellhouseinfo,FilePo filePo,HttpSession session,HttpServletRequest request){
		 Userinfo ui=new Userinfo();
		 ui.setUserid(sellhouseinfo.getMediaid());
		 ui.setUserrole("中介");
		 ui.setUserstatus("启用");
		 List<Userinfo> u=userinfoService.getUser(ui);
		if(u.size()==0){
		    session.setAttribute("addhousemsg", "该中介号不存在或已被加入黑名单！！");
			return "userAddhouse";
		}else{	
			Date date=new Date(System.currentTimeMillis());
			int ownerid=(int) request.getSession().getAttribute("userid");
			sellhouseinfo.setOwnerid(ownerid);
			sellhouseinfo.setMediaid(u.get(0).getUserid());
			//文件上传
	        String fileName = filePo.getMyfile().getOriginalFilename();
	        File targetFile = new File("D:/image",fileName);
	        if(!targetFile.exists()){
	        	  targetFile.mkdirs();
	          }
	          
	          try{
	        	  filePo.getMyfile().transferTo(targetFile);
	          }catch(Exception e){
	        	  e.printStackTrace();
	          }	
	          sellhouseinfo.setHouseimage(fileName);
	          sellhouseinfo.setCreatetime(date);
	          sellhouseinfo.setHousestatus("出租中");
	          sellhouseinfo.setRentlength("见面私聊");
	          sellhouseinfoService.insertSell(sellhouseinfo);   
	          request.setAttribute("sellhouseinfo", sellhouseinfo);
	          session.setAttribute("addhousemsg", "");
	          //为user界面提供房源信息数据
	          Sellhouseinfo shinfo=new Sellhouseinfo();
	          List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(shinfo);
	          request.setAttribute("sellinfo", sellinfo);
	          return "user";
		  }
		}
	//用户交易信息查询
	@RequestMapping(value="/usertransaction")
	public String usertransaction(Transactioninfo transactioninfo,HttpSession session,HttpServletRequest request){
			int ownerid=(int) request.getSession().getAttribute("userid");
			transactioninfo.setOwnerid(ownerid);
			 List<Transactioninfo> t=transactioninfoService.getTransaction(transactioninfo);
			 if(t.size()==0){
				    session.setAttribute("tranmsg", "无交易信息");
					return "usertransinfo";
			 }else{
					session.setAttribute("tranmsg", "");
					request.setAttribute("transList",t);
					return "usertransinfo";}
			 }
	//用户交易信息查询--精确查询
	@RequestMapping(value="/usertransaction2")
	public String usertransaction2(Transactioninfo transactioninfo,HttpSession session,HttpServletRequest request){
			if(transactioninfo.getTranstatus().equals(""))
			{
				transactioninfo.setTranstatus(null);
			}
			int ownerid=(int) request.getSession().getAttribute("userid");
			transactioninfo.setOwnerid(ownerid);
			 List<Transactioninfo> t=transactioninfoService.getTransaction(transactioninfo);
			 if(t.size()==0){
				    session.setAttribute("tranmsg", "无交易信息");
					return "usertransinfo";
			 }else{
					session.setAttribute("tranmsg", "");
					request.setAttribute("transList",t);
					return "usertransinfo";}
			 }
	//用户查看已上传房源信息
	@RequestMapping("/ownhouse")
	public String queryhouse(Userinfo userinfo,Sellhouseinfo sellinfo,HttpServletRequest request,HttpSession session) {
			int ownerid=(int) request.getSession().getAttribute("userid");
			sellinfo.setOwnerid(ownerid);
			List<Sellhouseinfo> house = sellhouseinfoService.getSell(sellinfo);
			if(house.size()==0) 
			{
				session.setAttribute("ownhousemsg", "未上传房源信息");
			}else
			{
				session.setAttribute("ownhousemsg", "");
				request.setAttribute("ownhouse",house);
			}

			return "userownhouse";
		}
	//举报功能--从交易界面获取值
	@RequestMapping("/juBaovalue")
	public String juBao(Userinfo userinfo,HttpSession session,HttpServletRequest request) {
			userinfo.setUserid(userinfo.getUserid());
			request.setAttribute("userid", userinfo.getUserid());	
			return "userjubao";			
		}
	//举报功能---将填写的举报信息保存到数据库
	@RequestMapping(value="/jubao")
	public String black(Blackuser blackuser,Userinfo userinfo,HttpSession session,HttpServletRequest request) throws ParseException{
		  Date date = new Date(System.currentTimeMillis());
		 /* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		  String da=dateFormat.format(date);
		  Date date2=(Date) dateFormat.parse(da);
	      System.out.println(date2);
	      System.out.println(new Date(System.currentTimeMillis()));*/
	      blackuser.setUserid(userinfo.getUserid());
		  blackuser.setCreatetime(date);
		  blackuserService.insertBlack(blackuser);
		  //为user界面提供房源信息数据
		  Sellhouseinfo shinfo=new Sellhouseinfo();
		  List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(shinfo);
		  request.setAttribute("sellinfo", sellinfo);
				
		  return "user";
			
		}
	
	//用户添加交易记录--获取点击信息
	@RequestMapping("/transaction")
	public String uptransaction(Sellhouseinfo sellinfo,HttpSession session,HttpServletRequest request) {
			sellinfo.getHouseid();
			List<Sellhouseinfo> hou = sellhouseinfoService.getSell(sellinfo);
			request.setAttribute("trans",hou.get(0));
			return "useruptrans";
		}
	//用户添加交易记录--添加交易信息
	@RequestMapping("/transaction2")
	public String addtransaction(Transactioninfo transinfo,HttpSession session,HttpServletRequest request) {
			Date date=new Date(System.currentTimeMillis());
			transinfo.setCreatetime(date);
			transservice.addTransaction(transinfo);
			//更改房子的状态
			Sellhouseinfo sh=new Sellhouseinfo();
			sh.setHouseid(transinfo.getHouseid());
			sh.setHousestatus("已出租");
			sellhouseinfoService.updateSell(sh);
			//为user界面提供房源信息数据
			 Sellhouseinfo shinfo=new Sellhouseinfo();
			 List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(shinfo);
			 request.setAttribute("sellinfo", sellinfo);
			 return "user";
		}
		
	//用户点赞功能
	@RequestMapping("/usercredit")
	public String addcredit(Userinfo userinfo,HttpSession session,HttpServletRequest request) {
			List<Userinfo> us = userinfoService.getUser(userinfo);
			Userinfo user = new Userinfo();
			user.setUserid(userinfo.getUserid());
			user.setUsercredit(us.get(0).getUsercredit()+1);
			userinfoService.updateUser(user);
			//传入页面数据
			Transactioninfo transactioninfo=new Transactioninfo();
			int ownerid=(int) request.getSession().getAttribute("userid");
			transactioninfo.setOwnerid(ownerid);
			List<Transactioninfo> t=transactioninfoService.getTransaction(transactioninfo);
			request.setAttribute("transList",t);
			return"usertransinfo";
	}
	
	//用户评价功能--获取信息	
	@RequestMapping(value="/comment")
	public String showcomment(Transactioninfo ts ,HttpServletRequest request){
			Transactioninfo trans = new Transactioninfo();
			trans.setCustomid(ts.getCustomid());
			trans.setMediaid(ts.getMediaid());
			trans.setOwnerid(ts.getOwnerid());
			request.setAttribute("trans", trans);
			return "usercomment";
		}
	//用户评价功能--上传评价信息		
	@RequestMapping("/savecommentinfo")
	public String comment(Reportinfo reportinfo,HttpSession session,HttpServletRequest request) {
			reportinfoService.addReport(reportinfo);
			//为user界面提供房源信息数据
			 Sellhouseinfo shinfo=new Sellhouseinfo();
			 List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(shinfo);
			 request.setAttribute("sellinfo", sellinfo);
			return "user";
			
		}
	//显示所有房源信息
	@RequestMapping("/showhouseinfo")
	public String showhouseinfo(Sellhouseinfo sellhouseinfo,HttpServletRequest request,HttpSession session){
			session.setAttribute("msg", "");
			List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(sellhouseinfo);
			request.setAttribute("sellinfo", sellinfo);
			return "userselecthouse";
	}
	//显示所有房源信息--精确显示房源信息
		@RequestMapping("/selhouse")
		public String selhouse(Sellhouseinfo sellhouseinfo,HttpServletRequest request,HttpSession session){
			//因为筛选的原因，当没有悬着筛选条件的时候，要把传入的值进行恢复
			if(sellhouseinfo.getLocationprovince().equals("0"))
			{
				sellhouseinfo.setLocationprovince(null);
			}
			if(sellhouseinfo.getLocationcity().equals("0"))
			{
				sellhouseinfo.setLocationcity(null);;
			}
			if(sellhouseinfo.getLocationqu().equals("0"))
			{
				sellhouseinfo.setLocationqu(null);
			}
			if(sellhouseinfo.getSpace().equals("0")) {
				sellhouseinfo.setSpace(null);
			}
				
			List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(sellhouseinfo);
			if(sellinfo.size()==0){
				session.setAttribute("housemsg", "对不起，未找到符合条件的房源");
				return "userselecthouse";
			}else{
				session.setAttribute("housemsg", "");
				request.setAttribute("sellinfo", sellinfo);
				return "userselecthouse";
			}
		}
	//找中介
	@RequestMapping("/medialist")
	public String medialist( Userinfo userinf,HttpServletRequest request) {
		    userinf.setUserrole("中介");
			userinf.setUserstatus("启用");
			List<Userinfo> list = userinfoService.getUser(userinf);
			request.setAttribute("userinf", list);
			return "usermedialist";
		}
	
	//获取私信信息
	@RequestMapping("/getmessageinfo")
	public String getmessageinfo(Messageinfo messageinfo,HttpSession session,HttpServletRequest request){
		int ownerid=(int) request.getSession().getAttribute("userid");
		messageinfo.setUserid(ownerid);
		request.setAttribute("messageinfo", messageinfo);
		return "useraddmessage";
	}
	
	//保存私信内容
	@RequestMapping("/savemessageinfo")
	public String savemessageinfo(Messageinfo messageinfo,HttpSession session,HttpServletRequest request){
		messageinfo.setStatus("未处理");
		Date date=new Date(System.currentTimeMillis());
		messageinfo.setCreatetime(date);
		messageinfoService.addMessage(messageinfo);
		//获取返回页面的数据
		Userinfo userinf=new Userinfo();
		userinf.setUserrole("中介");
		userinf.setUserstatus("启用");
		List<Userinfo> list = userinfoService.getUser(userinf);
		request.setAttribute("userinf", list);
		return "usermedialist";
	}
}