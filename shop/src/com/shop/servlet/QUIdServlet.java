package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.UserClientPOJO;
/***
 * 后台查询用户Id查询
 * @author Administrator
 *
 */
public class QUIdServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uName = request.getParameter("uName");
		List<UserClientPOJO> list = ShopDAOFactory.getUserClientDAOInsancet().findByName(uName);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/backstage/qu_particular.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
