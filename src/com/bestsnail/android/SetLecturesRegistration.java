package com.bestsnail.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestsnail.daoiml.SearchLectures;

/**
 * 进行报名的
 */
@WebServlet("/SetLecturesRegistration")
public class SetLecturesRegistration extends HttpServlet {
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

		String lec_id = request.getParameter("lec_id");
		String stu_id = request.getParameter("stu_id");
		System.out.println(lec_id + "-------------" + stu_id);
		int lec_id_n = Integer.parseInt(lec_id);
		int stu_id_n = Integer.parseInt(stu_id);
		SearchLectures searchLectures = new SearchLectures();
		PrintWriter writer = response.getWriter();

		boolean lecturesRegistration = searchLectures.isLecturesRegistration(lec_id_n, stu_id_n);

		if (lecturesRegistration) {
			int i = searchLectures.setLecturesRegistration(lec_id_n, stu_id_n);

			if (i > 0) {
				writer.print("报名成功");

			} else {
				writer.print("报名失败");

			}
		} else {
			writer.print("改讲座你已经报名了");
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
