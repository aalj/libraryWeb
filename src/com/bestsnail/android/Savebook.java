package com.bestsnail.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestsnail.daoiml.SavbookDao;

/**
 * Servlet implementation class Savebook
 */
@WebServlet("/Savebook")
public class Savebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charse=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String isbn_infos = URLDecoder.decode(request.getParameter("isbn_infos"), "utf-8");
		String suoshuhao_infos = URLDecoder.decode(request.getParameter("suoshuhao_infos"), "utf-8");
		String names = URLDecoder.decode(request.getParameter("names"), "utf-8");
		String zuozhes = URLDecoder.decode(request.getParameter("zuozhes"), "utf-8");
		String chubanshe_ets = URLDecoder.decode(request.getParameter("chubanshe_ets"), "utf-8");
		SavbookDao savebook = new SavbookDao();
		// String name,int isbn,String suo,String zuozhe,String chubanshe
		boolean addCoupon = savebook.addCoupon(names, isbn_infos, suoshuhao_infos, zuozhes, chubanshe_ets);

		PrintWriter writer = response.getWriter();
		if (addCoupon) {
			writer.print("保存成功");
		} else {
			writer.print("提交失败");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
