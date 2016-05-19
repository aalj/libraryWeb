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

import com.bestsnail.bean.BorrowTable;
import com.bestsnail.daoiml.BorrowingDaoIml;
import com.bestsnail.utils.GetGson;
import com.google.gson.Gson;

/**
 * Servlet implementation class BorrowingHistoryServlet
 */
@WebServlet("/BorrowingHistoryServlet")
public class BorrowingHistoryServlet extends HttpServlet {
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
		String stu_id = URLDecoder.decode(request.getParameter("stu_id"), "utf-8");
		String page = URLDecoder.decode(request.getParameter("page"), "utf-8");
		int nStu_id = 0;
		int npage = 0;
		if(stu_id!=null&&page!=null){
			nStu_id = Integer.parseInt(stu_id);
			npage=Integer.parseInt(page);
		}
		
		
		
		BorrowingDaoIml  borrowingHistoryDaoIml = new  BorrowingDaoIml();
		List<BorrowTable> borrowingHByStuId = borrowingHistoryDaoIml.BorrowingHByStuId(nStu_id, npage); 
		Gson mGetGson = GetGson.mGetGson();
		PrintWriter writer = response.getWriter();
		
		if(borrowingHByStuId.size()>0){
			String json = mGetGson.toJson(borrowingHByStuId);
			System.out.println("----"+json);
			writer.print(json);
			
		}else{
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
