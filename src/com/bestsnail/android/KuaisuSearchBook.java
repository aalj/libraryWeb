package com.bestsnail.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestsnail.bean.BookTable;
import com.bestsnail.daoiml.SearchBookIml;
import com.bestsnail.minterface.service.SearchBookS;
import com.bestsnail.serviceiml.SearchBookSiml;
import com.bestsnail.utils.GetGson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/KuaisuSearchBook")
public class KuaisuSearchBook extends HttpServlet {
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
		String guanjianzi = request.getParameter("guanjianzi");
		String temp = request.getParameter("temp");
		System.out.println(guanjianzi + "-----------------------");
		if (guanjianzi != null) {
			guanjianzi = URLDecoder.decode(guanjianzi, "utf-8");

		}
		List<BookTable> list = null;
		PrintWriter writer = response.getWriter();
		String json = null;
		SearchBookIml searchBookIml = new SearchBookIml();
		Gson gson = GetGson.mGetGson();
		if ("12".equals(temp)) {
			list = searchBookIml.DSearchBookListByAlle(guanjianzi);

			json = gson.toJson(list);

		} else {
			list = searchBookIml.DSearchBookListByAll(guanjianzi);

			json = gson.toJson(list);

		}
		writer.print(json);

		writer.close();

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
