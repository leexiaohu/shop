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
 * 后台查询用户处理
 * @author Administrator
 *
 */
public class QUServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		List<UserClientPOJO> list = ShopDAOFactory.getUserClientDAOInsancet().findAll();
//		System.out.println(list.get(0).getuId());
//		System.out.println(list.get(0).getuName());
//		System.out.println(list.get(0).getuNum());
//		System.out.println(list.get(0).getuPsw());
//		System.out.println(list.get(0).getuRName());
//		System.out.println(list.get(0).getuTel());
//		System.out.println(list.get(0).getuAdd());
//		System.out.println(list.get(0).getuEmail());
//		System.out.println(list.get(0).getuStatus());
		
		HttpSession session = request.getSession();
		request.setAttribute("list", list);
		if(id.equals("21")){
			session.setAttribute("listsize", list.size());
			request.getRequestDispatcher("/backstage/quser.jsp").forward(request, response);
		}
		if(id.equals("23")){
			session.setAttribute("listsize", list.size());
			request.getRequestDispatcher("/backstage/muser.jsp").forward(request, response);
		}
		if(id.equals("24")){
			session.setAttribute("listsize", list.size());
			request.getRequestDispatcher("/backstage/duser.jsp").forward(request, response);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
