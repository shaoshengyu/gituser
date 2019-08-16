package com.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.FilePo;
import com.pojo.Messageinfo;
import com.pojo.Sellhouseinfo;
import com.pojo.Transactioninfo;
import com.pojo.Userinfo;
import com.service.MessageinfoService;
import com.service.SellhouseinfoService;
import com.service.TransactioninfoService;
import com.service.UserinfoService;
@Controller
@RequestMapping("/origin")
public class OriginController {
	@Autowired
	SellhouseinfoService sellhouseinfoService;
	
	@Autowired
	UserinfoService userinfoService;
	
	@Autowired
	MessageinfoService messageinfoService;
	
	@Autowired
	TransactioninfoService transservice;
	
	@RequestMapping("/showforgetpwd")
	public String showupdatepwd() {
		return "originforgetpwd";
	}
	//用户登陆的验证
	@RequestMapping(value="/validateUser")
	public String login(Userinfo userinfo,HttpSession session,HttpServletResponse response,HttpServletRequest request) {
		List<Userinfo>  user= userinfoService.getUser(userinfo);//
		if(user.size()==0) {
			session.setAttribute("loginmsg", "用户名或用户密码错误，请核对！！");
			//跳转页面的数据
			Sellhouseinfo sellhouseinfo=new Sellhouseinfo();
			List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(sellhouseinfo);
			request.setAttribute("sellinfo", sellinfo);
			return "origin";
			
		}else if(user.get(0).getUserstatus().equals("禁用")){
			session.setAttribute("loginmsg", "该账户已经被禁用！！！");
			//跳转页面的数据
			Sellhouseinfo sellhouseinfo=new Sellhouseinfo();
			List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(sellhouseinfo);
			request.setAttribute("sellinfo", sellinfo);
			session.setAttribute("username", user.get(0).getUsername());
			
			return "origin";
		}else if(user.get(0).getUserrole().equals("管理员")) {
			session.setAttribute("loginmsg", "");
		    session.setAttribute("userrole", user.get(0).getUserrole());
		    session.setAttribute("username", user.get(0).getUsername());
		    session.setAttribute("userid", user.get(0).getUserid());
		    //提供跳转页面数据
		    Transactioninfo ti=new Transactioninfo();
		    List<Transactioninfo> trans = transservice.getTransaction(ti);
		    if(trans.size()==0){
				session.setAttribute("tranmsg", "对不起，未找到符合条件的交易记录");
				return "adminchakanjiaoyi";
			}else{
				session.setAttribute("tranmsg", "");
				request.setAttribute("transList", trans);
				return "adminchakanjiaoyi";
				}
		}else if(user.get(0).getUserrole().equals("普通用户")) {
			 session.setAttribute("loginmsg", "");
			 session.setAttribute("userrole", user.get(0).getUserrole());
			 session.setAttribute("username", user.get(0).getUsername());
			 session.setAttribute("userid", user.get(0).getUserid());
			 //为user界面提供房源信息数据
			 Sellhouseinfo shinfo=new Sellhouseinfo();
			 List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(shinfo);
			 request.setAttribute("sellinfo", sellinfo);
			return "user";
		}else if(user.get(0).getUserrole().equals("中介")) {
			session.setAttribute("loginmsg", "");
			session.setAttribute("userrole", user.get(0).getUserrole());
			session.setAttribute("username", user.get(0).getUsername());
			session.setAttribute("userid", user.get(0).getUserid());
			//添加中介初始页面信息
			Messageinfo me=new Messageinfo();
			int mediaid=(int) request.getSession().getAttribute("userid");
			me.setMediaid(mediaid);
			List<Messageinfo> m = messageinfoService.getMessage(me);
			if(m.size()==0){
				session.setAttribute("liuyanmsg", "无留言信息");
				return "mediamessage";
			}else{
				session.setAttribute("liuyanmsg", "");
				request.setAttribute("messageList",m);
				return "mediamessage";
			}
		}else {
			return "UserLogin";
		}
		
	}
	//添加用户账号
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("userinfo") Userinfo userinfo,HttpSession session,FilePo filePo, HttpServletRequest request) {
		Userinfo us=new Userinfo();
		us.setUsername(userinfo.getUsername());
		List<Userinfo> user=userinfoService.getUser(us);
		if(user.size()>0){
			session.setAttribute("addusermsg", "用户名已存在！！");
			//用于为origin页面显示房源提供信息
	        Sellhouseinfo shinfo=new Sellhouseinfo();
			List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(shinfo);
			request.setAttribute("sellinfo", sellinfo);
			return "origin";
		}else{
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
	    userinfo.setUserimage(fileName);
		userinfo.setUserstatus("启用");
		userinfo.setUsercredit(0);
		userinfoService.addUser(userinfo);
        request.setAttribute("userinfo", userinfo);
        session.setAttribute("addusermsg", "");
        //用于为origin页面显示房源提供信息
        Sellhouseinfo shinfo=new Sellhouseinfo();
		List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(shinfo);
		request.setAttribute("sellinfo", sellinfo);
        return "origin";
	  }
	}
	//忘记密码--找回密码
	@RequestMapping("/forget")
	public String forgetUser(Userinfo userinfo,HttpServletRequest request,HttpSession session){
		Userinfo us=new Userinfo();
		us.setUseremail(userinfo.getUseremail());
		us.setUsername(userinfo.getUsername());
		List<Userinfo> user = userinfoService.getUser(us);
		if(user.size()==0) {
			session.setAttribute("forgetpasswordmsg", "验证信息错误！！");
			return "originforgetpwd";
		}else{
			userinfoService.updateUser(userinfo);
			session.setAttribute("forgetpasswordmsg", "");
			request.setAttribute("userinfo", userinfo);
			 //用于为origin页面显示房源提供信息
	        Sellhouseinfo shinfo=new Sellhouseinfo();
			List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(shinfo);
			request.setAttribute("sellinfo", sellinfo);
			return "origin";		
	  }
	}
	
	//显示所有房源信息
		@RequestMapping("/showhouseinfo")
		public String showhouseinfo(Sellhouseinfo sellhouseinfo,HttpServletRequest request,HttpSession session){
				session.setAttribute("msg", "");
				List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(sellhouseinfo);
				request.setAttribute("sellinfo", sellinfo);
				return "origin";
		}
	
	//点击获取用户信息	
		@RequestMapping(value="/showuserinfo")
		public String getuserid(Userinfo userinfo,HttpServletRequest request){
				userinfo.setUserid(userinfo.getUserid());
				userinfo.setUserrole("普通用户");
				List<Userinfo> use = userinfoService.getUser(userinfo);
				request.setAttribute("us", use.get(0));
				return "userinfo";	
	}
	//点击获取中介信息	
	@RequestMapping(value="/mediainfo")
	public String mediainfo(Userinfo userinfo,HttpSession session,HttpServletRequest request){
				userinfo.setUserid(userinfo.getUserid());
				userinfo.setUserrole("中介");
				List<Userinfo> uu=userinfoService.getUser(userinfo);			
				request.setAttribute("media",uu.get(0));
				return "mediainfo";
		}
	
}
