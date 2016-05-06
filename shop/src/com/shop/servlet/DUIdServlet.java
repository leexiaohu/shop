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
import com.shop.POJO.CommodityPOJO;
import com.shop.POJO.UserClientPOJO;
/***
 * 
 *后台根据用户Id删除用户
 * @author Administrator
 *
 */
public class DUIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uName = request.getParameter("uName");
		List<UserClientPOJO> list5 = ShopDAOFactory.getUserClientDAOInsancet().findByName(uName);
		ShopDAOFactory.getUserClientDAOInsancet().doDel(list5.get(0).getuId());
		List<UserClientPOJO> list = ShopDAOFactory.getUserClientDAOInsancet().findByName(uName);
		request.setAttribute("list", list);//可以分页删除
		
		HttpSession session = request.getSession();
		List<UserClientPOJO> list1 = ShopDAOFactory.getUserClientDAOInsancet().findAll();
		session.setAttribute("listsize", list1.size());
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('删除成功！');");
		out.println("history.back();");
		out.println("</script>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
