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
import com.shop.POJO.AdminPOJO;
/***
 * 查询后台用户处理
 * @author Administrator
 *
 */
public class QueryAdminServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		String remember[] = request.getParameterValues("remember");//判断是否选择记住我
		HttpSession session = request.getSession();
		

		
		List<AdminPOJO> list = ShopDAOFactory.getAdminDAOInsancet().findByNP(username, password);
		if(list.size() != 0){
			session.setAttribute("username", username);
			response.sendRedirect("backstage\\index.jsp");
//			if(remember[0].equals("1")){
//				System.out.println(remember[0]);
//				session.setMaxInactiveInterval(3);
//			}
			
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('账户或密码错误');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		System.out.println(username);
		System.out.println(password);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
