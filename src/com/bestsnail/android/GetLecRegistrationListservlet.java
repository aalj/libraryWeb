package com.bestsnail.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestsnail.bean.BorrowTable;
import com.bestsnail.bean.LecturesRegistrationTable;
import com.bestsnail.daoiml.BorrowingDaoIml;
import com.bestsnail.daoiml.SearchLectures;
import com.bestsnail.utils.GetGson;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetLecRegistrationListservlet
 */
@WebServlet("/GetLecRegistrationListservlet")
public class GetLecRegistrationListservlet extends HttpServlet {
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
		String page = request.getParameter("page");

		int nStu_id = 0;
		int npage = 0;
		if (stu_id != null) {
			nStu_id = Integer.parseInt(stu_id);
			npage = Integer.parseInt(page);

		}

		SearchLectures lectures = new SearchLectures();
		List<LecturesRegistrationTable> lecturesRegistrationb = lectures.getLecturesRegistrationb(nStu_id, npage);

		Gson mGetGson = GetGson.mGetGson();
		PrintWriter writer = response.getWriter();

		if (lecturesRegistrationb.size() > 0) {
			String json = mGetGson.toJson(lecturesRegistrationb);
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
