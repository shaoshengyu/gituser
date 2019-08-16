package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		//获取会话对象
		HttpSession session=request.getSession();
		
		//从会话获取shopping(购物车)属性对象
		Map<String,Integer> pur =(Map<String,Integer>)session.getAttribute("shopping");
		//若无shopping属性对象，则实例化一个
		
		String sessionId=request.getSession().getId();
		Cookie cookie=new Cookie("sessionId",request.getSession().getId());
		cookie.setMaxAge(365*24*60*60);
		response.addCookie(cookie);
		
		if(pur==null) {
			pur = new HashMap<String,Integer>();
		}
		//获取要购买电器
		String[] equipments=request.getParameterValues("equipment");
		if(equipments!=null&&equipments.length!=0) {
			for(String e:equipments) {
				//判断电器是否已经在shopping中
				if(pur.get(e)!=null) {
					//该电器已放入购物车数量
					int count=pur.get(e);
					pur.put(e, count+1);
				}else {
					//之前未放入该电器时
					pur.put(e,1);
				}
			}
		}
		//将更新后shopping存储在会话中
		session.setAttribute("shopping", pur);
		response.sendRedirect("Purchase2Servlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
