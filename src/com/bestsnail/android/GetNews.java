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
 * Servlet implementation class GetNews
 */
@WebServlet("/GetNews")
public class GetNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("kankan neirong ");

		String page = request.getParameter("page");
		String pagenum = request.getParameter("pagenum");

		int page_n = Integer.parseInt(page);
		int pagenum_n = Integer.parseInt(pagenum);
		List<NewsTable> searchResourceByLimit = new SearchNews().SearchNewsByLimit(page_n,
				pagenum_n);

		Gson mGetGson = GetGson.mGetGson();
		String json = mGetGson.toJson(searchResourceByLimit);
		PrintWriter writer = response.getWriter();
		writer.print(json);
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
