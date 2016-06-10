package com.bestsnail.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestsnail.bean.BookTable;
import com.bestsnail.daoiml.SearchBookIml;
import com.bestsnail.utils.GetGson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * 用于发送热门的图书搜索到android端，用于显示热门图书
 * @author liang
 *
 */
@WebServlet("/SendReMenSousuo")
public class SendReMenSousuo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		List<BookTable> searchBookList = new SearchBookIml().SearchBookList(98);
		PrintWriter writer = response.getWriter();
		Gson gson = GetGson.mGetGson();
		String json = gson.toJson(searchBookList);
		writer.print(json);
		writer.close();
		
		
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
