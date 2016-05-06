package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/***
 * 前台用户登录处理
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("id");
		String url = request.getParameter("url");
		
//		System.out.println(url);
		HttpSession session = request.getSession();
		if(type.equals("1")){
			session.setAttribute("url", url);
			response.sendRedirect("proscenium/login.jsp");
		}
		
		if(type.equals("2")){
			session.setAttribute("username", "");
			response.sendRedirect("proscenium/index.jsp");
		}
		
		if(type.equals("3")){
			session.setAttribute("url", url);
			response.sendRedirect("proscenium/register.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
