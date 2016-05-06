package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;

public class DeleteCommodityFServlet extends HttpServlet {
	/***
	 * 后台删除商品
	 * 
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String num = request.getParameter("num");

			List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findByNum(Integer.parseInt(num));
			request.setAttribute("list", list);
			List<CommodityHistoryPOJO> list1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findAll();
			request.setAttribute("list1", list1);
			request.getRequestDispatcher("/backstage/dcommodity.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
