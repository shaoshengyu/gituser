package com.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/media")
public class MediaController {

	@Autowired
	TransactioninfoService transservice;
	
	@Autowired
	SellhouseinfoService sellhouseinfoService;
	
	@Autowired
	MessageinfoService messageinfoService;
	
	@Autowired
	UserinfoService userinfoService;
	
	@Autowired
	TransactioninfoService transactioninfoService;
	
	
	@RequestMapping("/mediaaddhouse")
	public String addhouse() {
		return "mediaAddhouse";
	}
	
	//中介查看交易信息
	@RequestMapping(value="/mediatransaction")
	public String mediatransaction(Transactioninfo transactioninfo,HttpSession session,HttpServletRequest request){
		int mediaid=(int) request.getSession().getAttribute("userid");
		transactioninfo.setOwnerid(mediaid);
		 List<Transactioninfo> t=transactioninfoService.getTransaction(transactioninfo);
		 if(t.size()==0){
			    session.setAttribute("mediatranmsg", "无交易信息");
				return "mediatransinfo";
			}else{
				session.setAttribute("mediatranmsg", "");
				request.setAttribute("transList",t);
				return "mediatransinfo";
			}
	}
	//中介上传房源信息
	@RequestMapping(value="/addHouse")
	public String addHouse(Sellhouseinfo sellhouseinfo,FilePo filePo,HttpSession session,HttpServletRequest request){
		 Userinfo ui=new Userinfo();
		 ui.setUserid(sellhouseinfo.getOwnerid());
		 ui.setUserrole("普通用户");
		 ui.setUserstatus("启用");
		 List<Userinfo> u=userinfoService.getUser(ui);
		if(u.size()==0){
		    session.setAttribute("addhousemsg", "该用户号不存在或已被加入黑名单！！");
			return "mediaAddhouse";
		}else{	
			Date date=new Date(System.currentTimeMillis());
			int ownerid=(int) request.getSession().getAttribute("userid");
			sellhouseinfo.setOwnerid(u.get(0).getUserid());
			sellhouseinfo.setMediaid(ownerid);
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
	          sellhouseinfo.setRentlength("见面私聊");;
	          sellhouseinfoService.insertSell(sellhouseinfo);   
	          request.setAttribute("sellhouseinfo", sellhouseinfo);
	          session.setAttribute("addhousemsg", "");
	          //获取首页信息
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
		  }
		}
	//中介查看已上传房源信息
		@RequestMapping("/ownhouse")
		public String queryhouse(Userinfo userinfo,Sellhouseinfo sellinfo,HttpServletRequest request,HttpSession session) {
			 
				int ownerid=(int) request.getSession().getAttribute("userid");
				sellinfo.setMediaid(ownerid);
				List<Sellhouseinfo> house = sellhouseinfoService.getSell(sellinfo);
				if(house.size()==0) 
				{
					session.setAttribute("ownhousemsg", "未上传房源信息");
				}else
				{
					session.setAttribute("ownhousemsg", "");
					request.setAttribute("ownhouse",house);
				}

				return "mediaownhouse";
			}
	//中介查看留言信息		
	@RequestMapping(value="/seemessage")
	public String message(Messageinfo messageinfo,HttpSession session,HttpServletRequest request){
		Messageinfo me=new Messageinfo();
		int mediaid=(int) request.getSession().getAttribute("userid");
		me.setMediaid(mediaid);
		me.setStatus("未处理");
		List<Messageinfo> m = messageinfoService.getMessage(me);
		if(m.size()==0){
			session.setAttribute("liuyanmsg", "无留言信息");
			return "mediamessage";
		}else{
			session.setAttribute("liuyanmsg", "");
			request.setAttribute("messageList",m);
			return "mediamessage";
		}
	}
	
	//处理信息
	@RequestMapping(value="/updatemessage")
	public String updatemessage(Messageinfo messageinfo,HttpSession session,HttpServletRequest request){
		messageinfo.getMessageid();
		Messageinfo mi=new Messageinfo();
		mi.setMessageid(messageinfo.getMessageid());
		mi.setStatus("已处理");
		messageinfoService.updateMessage(mi);
		//获取返回页面信息
		Messageinfo me=new Messageinfo();
		int mediaid=(int) request.getSession().getAttribute("userid");
		me.setMediaid(mediaid);
		me.setStatus("未处理");
		List<Messageinfo> m = messageinfoService.getMessage(me);
		if(m.size()==0){
			session.setAttribute("liuyanmsg", "无留言信息");
			return "mediamessage";
		}else{
			session.setAttribute("liuyanmsg", "");
			request.setAttribute("messageList",m);
			return "mediamessage";
		}
	}
	//中介上传交易记录--获取所需信息		
	@RequestMapping("/transaction")
	public String uptransaction(Sellhouseinfo sellinfo,HttpSession session,HttpServletRequest request) {
		sellinfo.getHouseid();
		List<Sellhouseinfo> hou = sellhouseinfoService.getSell(sellinfo);
		request.setAttribute("trans",hou.get(0));
		return "mediauptrans";
	}
	//中介上传交易记录--保存所填信息		
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
		//为跳转页面提供数据
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
	}


}
