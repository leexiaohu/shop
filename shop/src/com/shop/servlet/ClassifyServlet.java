package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;

public class ClassifyServlet extends HttpServlet {

	/***
	 * 前台查询商品
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cName = request.getParameter("cName");
		byte a[] = cName.getBytes("ISO8859-1");
		cName = new String(a);


		List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findByName(cName);
		List<CommodityHistoryPOJO> list1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findByName(cName);
		List<CommodityHistoryPOJO> list2 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findT();
		List<CommodityPOJO> list3 = ShopDAOFactory.getCommodityDAOInsancet().findAll();
		HttpSession session = request.getSession();
		
		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		
		session.setAttribute("listsize", list1.size());
		session.setAttribute("find", cName);
		
		request.getRequestDispatcher("/proscenium/find.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
