package com.bestsnail.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestsnail.bean.CollectBook;
import com.bestsnail.daoiml.CeollectBookIml;
import com.bestsnail.utils.GetGson;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetCollection
 */
@WebServlet("/GetCollection")
public class GetCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String parameter = request.getParameter("stu_id");
		String parameter_page = request.getParameter("page");

		int parseInt = Integer.parseInt(parameter);
		System.out.println("********" + parseInt + "**************");
		int parseInt_page = Integer.parseInt(parameter_page);
		System.out.println("********" + parseInt_page + "**************");

		List<CollectBook> list_collectbooks = new CeollectBookIml().getCollectBookByStuid(parseInt, parseInt_page);
		System.out.println(list_collectbooks);
		Gson gson = GetGson.mGetGson();
		String json = gson.toJson(list_collectbooks);
		PrintWriter writer = response.getWriter();
		System.out.println(json);
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
