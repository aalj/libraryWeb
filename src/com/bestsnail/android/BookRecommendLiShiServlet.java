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

import com.bestsnail.bean.RecommendedBookTable;
import com.bestsnail.daoiml.BookRecommendDaoIml;
import com.bestsnail.utils.GetGson;
import com.google.gson.Gson;

/**
 * Servlet implementation class BookRecommendLiShiServlet
 */
@WebServlet("/BookRecommendLiShiServlet")
public class BookRecommendLiShiServlet extends HttpServlet {
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
		String stu_id = request.getParameter("stu_id");
		BookRecommendDaoIml bookRecommend = new BookRecommendDaoIml();
		 List<RecommendedBookTable> bookRecommendLishi = bookRecommend.getBookRecommend(stu_id);
		 Gson mGetGson = GetGson.mGetGson();
		PrintWriter writer = response.getWriter();
		if (bookRecommendLishi.size() > 0) {
			String json = mGetGson.toJson(bookRecommendLishi);
			writer.print(json);
		} else {
			writer.print("no");
		}
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
