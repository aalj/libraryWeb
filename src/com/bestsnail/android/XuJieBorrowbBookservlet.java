package com.bestsnail.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestsnail.daoiml.BorrowingDaoIml;

/**
 * Servlet implementation class XuJieBorrowbBookservlet
 */
@WebServlet("/XuJieBorrowbBookservlet")
public class XuJieBorrowbBookservlet extends HttpServlet {
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
		String xunum = request.getParameter("xunum");
		String borroe_id = request.getParameter("borroe_id");
		int stu_id_n = 0;
		int xunum_n = 0;
		int borroe_id_n = 0;
		if (stu_id != null && xunum != null && borroe_id != null) {
			stu_id_n = Integer.parseInt(stu_id);
			xunum_n = Integer.parseInt(xunum);
			borroe_id_n = Integer.parseInt(borroe_id);

		}
		System.out.println(stu_id + "\t" + xunum + "\t" + borroe_id + "\t");
		int xujienum = new BorrowingDaoIml().BorrowingXuJieByStuId(borroe_id_n, xunum_n, stu_id_n);
		PrintWriter writer = response.getWriter();

		writer.print(xujienum);
		writer.close();

		;
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
