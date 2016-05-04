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
		List<String> list = new ArrayList<>();
		list.add("书籍一");
		list.add("书籍二");
		list.add("书籍三");
		list.add("书籍四");
		list.add("书籍五");
		list.add("书籍六");
		list.add("书籍七");
		list.add("书籍八");
		list.add("书籍九");
		System.out.println("kankankankn knkankn a ");
		PrintWriter writer = response.getWriter();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String json = gson.toJson(list);
		writer.print(json);
		writer.close();
		
		
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
