package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInteceptor extends HandlerInterceptorAdapter{
	//试图之前拦截
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		HttpSession session =request.getSession();
		String userRole=(String) request.getSession().getAttribute("userrole");//从session中取出属性值
		if(userRole.equals("管理员"))
		{
			session.setAttribute("interMsg", "该权限为管理员权限");
			request.getRequestDispatcher("/WEB-INF/views/UserLogin.jsp").forward(request, response);
			return false;
		}
		session.setAttribute("interMsg", "");
		return true;
	}	
}
