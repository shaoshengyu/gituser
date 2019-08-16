package com.cheese.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)
	                  throws Exception{
		String userName =(String) request.getSession().getAttribute("userName");
		if(null == userName || "".equals(userName)){
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
			return false;
		}
		return true;
	}

}
