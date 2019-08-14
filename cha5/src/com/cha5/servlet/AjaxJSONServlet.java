package com.cha5.servlet;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cha5.pojo.GameBean;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AjaxJSONServlet
 */
@WebServlet("/AjaxJSONServlet")
public class AjaxJSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxJSONServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//JavaBean定义信息
		GameBean g1=new GameBean("11111111", "ios","豪煜","圣剑使");
		GameBean g2=new GameBean("22222222", "ios","小小陆","元素使");
		GameBean g3=new GameBean("12345678", "安卓","梁凯","盾战士");
		GameBean g4=new GameBean("aaaaaaaa", "安卓","孙迪","神射手");
		// 使用Map模拟数据库
		Map<String, GameBean> datas = new HashMap<String, GameBean>();
		datas.put(g1.getZhanghao(), g1);
		datas.put(g2.getZhanghao(), g2);
		datas.put(g3.getZhanghao(), g3);
		datas.put(g4.getZhanghao(), g4);

		// 获取Ajax请求数据
		String zhanghao = request.getParameter("zhanghao");
		// 根据账号从模拟数据库查信息
		GameBean data = datas.get(zhanghao);
		if (data == null) {
			data =new GameBean("","未登陆过本游戏","未登陆过本游戏","未登陆过本游戏");
		}
		//创建Jackson插件的ObjectMapper对象
		ObjectMapper mapper=new ObjectMapper();
		//将一个Java对象转换成JSON后请求结果数据响应输出
		mapper.writeValue(response.getWriter(),data);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
