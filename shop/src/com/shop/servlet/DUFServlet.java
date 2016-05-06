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
 * 后台删除用户
 * @author Administrator
 *
 */
public class DUFServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");

		List<UserClientPOJO> list = ShopDAOFactory.getUserClientDAOInsancet().findByNum(Integer.parseInt(num));
		request.setAttribute("list", list);
		request.getRequestDispatcher("/backstage/duser.jsp").forward(request, response);


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
