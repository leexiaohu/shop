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
 * 后台查询前台用户处理
 * @author Administrator
 *
 */
public class QueryUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		boolean bool5 = true;
		HttpSession session = request.getSession();
		List<UserClientPOJO> list = ShopDAOFactory.getUserClientDAOInsancet().findByNP(username, password);
//		System.out.println(list.size() + "jjj");
		if(list.size() != 0){
			if(list.get(0).getuStatus() == 2){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.flush();
				out.println("<script>");
				out.println("alert('账户已被停用，请联系管理员！');");
				out.println("history.back();");
				out.println("</script>");
				bool5 = false;
			}else{
				session.setAttribute("username", list.get(0).getuNum());
				response.sendRedirect("proscenium/temp.jsp");
			}
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('账户或密码错误');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
