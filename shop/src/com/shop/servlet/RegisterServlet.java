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
import com.shop.POJO.UserClientPOJO;
/***
 * 前台注册处理
 * @author Administrator
 *
 */
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		username = username.trim();
		password = password.trim();
		String yzm = request.getParameter("yzm");
		String rand = (String) session.getAttribute("rand");
		boolean bool5 = true;
		List<UserClientPOJO> list = ShopDAOFactory.getUserClientDAOInsancet().findByUNum(username);
		System.out.println(list.size());
		if(list.size() != 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('账户已存在！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		
		if(!yzm.equals(rand)){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('验证码输入错误！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		if(list.size() == 0 && bool5){
			int max = ShopDAOFactory.getUserClientDAOInsancet().findMax();
			UserClientPOJO pojo = new UserClientPOJO((++max),"",password,username,"","","","",1);
			boolean bool = ShopDAOFactory.getUserClientDAOInsancet().doReg(pojo);
			
			session.setAttribute("username",username);
			request.getRequestDispatcher("/proscenium/temp2.jsp").forward(request, response);;
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
