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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SearchBookS bookS = new SearchBookSiml(new SearchBookIml());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String guanjianzi = request.getParameter("guanjianzi");
		String guancangflag = request.getParameter("guancangflag");
		String flag = request.getParameter("flag");
		if (flag != null && guanjianzi != null) {
			guanjianzi = URLDecoder.decode(guanjianzi, "utf-8");
			flag = URLDecoder.decode(flag, "utf-8");
			guancangflag = URLDecoder.decode(guancangflag, "utf-8");
		}
		System.out.println(guanjianzi + "\t" + flag+"\t"+guancangflag);
		List<BookTable> list = null;
		if ("0".equals(flag)) {
			list = bookS.SearchBookSimlByAll(guanjianzi,guancangflag);

		} else if ("1".equals(flag)) {
			list = bookS.SearchBookSimlByTiming(guanjianzi,guancangflag);

		} else if ("2".equals(flag)) {
			list = bookS.SearchBookSimlByzuozhe(guanjianzi,guancangflag);

		} else {
			list = bookS.SearchBookSimlByzhutuci(guanjianzi,guancangflag);

		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String json = gson.toJson(list);
		PrintWriter writer = response.getWriter();
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
