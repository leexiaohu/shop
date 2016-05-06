package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.FindsFlowPOJO;
import com.shop.PUB.*;
/***
 * 前台查询余额处理
 * @author Administrator
 *
 */
public class FindBalance1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		boolean bool5 = true;
		if(username == "" || username == null){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('未登录账户！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		
		if(bool5){
			int sum = FindBalance.findbl(username);
			session.setAttribute("sum", sum);
			request.getRequestDispatcher("/proscenium/balance.jsp").forward(request, response);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
