package com.bestsnail.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestsnail.bean.NewsTable;
import com.bestsnail.bean.ResourceDynamicsTable;
import com.bestsnail.daoiml.SearchNews;
import com.bestsnail.daoiml.SearchResourceDynamics;
import com.bestsnail.utils.GetGson;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetResourceDynamics
 */
@WebServlet("/GetResourceDynamics")
public class GetResourceDynamics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String page = request.getParameter("page");
		
		
//		String pagenum = request.getParameter("pagenum");
		
		int page_n = Integer.parseInt(page);
//		int pagenum_n = Integer.parseInt(pagenum);
		List<ResourceDynamicsTable> newsByLimit = new SearchResourceDynamics().SearchResourceByLimit(page_n, 30);
		
		
		
		
		Gson mGetGson = GetGson.mGetGson();
		String json = mGetGson.toJson(newsByLimit);
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
