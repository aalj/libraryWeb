package com.bestsnail.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestsnail.bean.Student;
import com.bestsnail.daoiml.LoginDao;
import com.bestsnail.utils.GetGson;
import com.google.gson.Gson;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String xuehao = URLDecoder.decode(request.getParameter("xuehao"), "utf-8");
		String pwd = URLDecoder.decode(request.getParameter("pwd"), "utf-8");
		
		Student mLogin = new LoginDao().MLogin(xuehao,pwd);
		Gson mGetGson = GetGson.mGetGson();
		String json = mGetGson.toJson(mLogin);
		System.out.println(xuehao);
		System.out.println(pwd);
		System.out.println(json);
		PrintWriter writer = response.getWriter();
		writer.print(json);
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
