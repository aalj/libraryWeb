package com.bestsnail.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestsnail.daoiml.CeollectBookIml;
import com.bestsnail.daoiml.SearchLectures;

/**
 * Servlet implementation class SetCeollectBook
 */
@WebServlet("/SetCeollectBook")
public class SetCeollectBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("kankan neirong ");

		String book_id = request.getParameter("book_id");
		String stu_id = request.getParameter("stu_id");
		System.out.println(book_id + "-------------" + stu_id);
		int lec_id_n = Integer.parseInt(book_id);
		int stu_id_n = Integer.parseInt(stu_id);
		CeollectBookIml  bookIml = new  CeollectBookIml();
		PrintWriter writer = response.getWriter();

		boolean lecturesRegistration = bookIml.isCeollectBook(book_id, stu_id);

		if (lecturesRegistration) {
			int i = bookIml.setCeollectBook(book_id, stu_id) ;

			if (i > 0) {
				writer.print("收藏成功");

			} else {
				writer.print("收藏失败");

			}
		} else {
			writer.print("这本书你已经收藏了");
		}

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
