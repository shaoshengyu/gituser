package com.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pojo.Sellhouseinfo;
import com.service.SellhouseinfoService;

public class LoginInteceptor extends HandlerInterceptorAdapter{
	@Autowired
	SellhouseinfoService sellhouseinfoService;
	
	//试图之前拦截
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		HttpSession session =request.getSession();
		String userName=(String) request.getSession().getAttribute("username");//从session中取出属性值
		if (null==userName||"".equals(userName)) {
			session.setAttribute("interMsg", "请先登陆");
			Sellhouseinfo sellhouseinfo=new Sellhouseinfo();
			List<Sellhouseinfo> sellinfo = sellhouseinfoService.getSell(sellhouseinfo);
			request.setAttribute("sellinfo", sellinfo);
			request.getRequestDispatcher("/WEB-INF/views/origin.jsp").forward(request, response);
			return false;
		}
		session.setAttribute("interMsg", "");
		return true;
	}	
}
