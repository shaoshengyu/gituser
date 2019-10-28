package com.cha5.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使用Map模拟数据库
		Map<String,String> datas=new HashMap<String,String>();
		datas.put("11111111","ios,豪煜,圣剑使");
		datas.put("22222222","ios,小小陆,元素使");
		datas.put("12345678","安卓,梁凯,盾战士");
		datas.put("aaaaaaaa","安卓,孙迪,神射手");
		
		//获取Ajax请求数据
		String zhanghao=request.getParameter("zhanghao");
		//根据账号从模拟数据库查信息
		String data=datas.get(zhanghao);
		if(data==null) {
			data="未登陆过本游戏,未登陆过本游戏,未登陆过本游戏";					
		}
		//将请求结果数据响应输出
		response.getWriter().print(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
