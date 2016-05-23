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
import com.bestsnail.daoiml.BookRecommendDaoIml;
import com.bestsnail.daoiml.BorrowingDaoIml;
import com.bestsnail.utils.GetGson;
import com.google.gson.Gson;


@WebServlet("/BookRecommendServlet")
public class BookRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String bookname =  URLDecoder.decode( request.getParameter("bookname") , "utf-8");
		String bookzuthor = URLDecoder.decode( request.getParameter("bookzuthor"), "utf-8") ;
		String chuabanshe = URLDecoder.decode( request.getParameter("chuabanshe"), "utf-8") ;
		String bookisbn =URLDecoder.decode(  request.getParameter("bookisbn"), "utf-8") ;
		String stu_id =  request.getParameter("stu_id") ;
		BookRecommendDaoIml bookRecommend    = new  BookRecommendDaoIml();
		int saveBookRecommend = bookRecommend.saveBookRecommend(stu_id, bookname, bookzuthor, chuabanshe, bookisbn);
//		Gson mGetGson = GetGson.mGetGson();
		PrintWriter writer = response.getWriter();
		if(saveBookRecommend>0){
			writer.print("推荐成功");
		}else{
			writer.print("推荐失败");
		}
		writer.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
