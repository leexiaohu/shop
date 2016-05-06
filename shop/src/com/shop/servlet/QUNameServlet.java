package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.UserClientPOJO;
/***
 * 后台查询用户名查询
 * @author Administrator
 *
 */
public class QUNameServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uName = request.getParameter("uName");
		byte a[] = uName.getBytes("ISO8859-1");
		uName = new String(a);
		List<UserClientPOJO> list = ShopDAOFactory.getUserClientDAOInsancet().findByName(uName);
		request.setAttribute("list", list);
		HttpSession session = request.getSession();
		session.setAttribute("listsize", list.size());
		request.getRequestDispatcher("/backstage/quser.jsp").forward(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
