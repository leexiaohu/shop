package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.CommodityPOJO;
/***
 * 后台根据商品Id查询商品处理
 * @author Administrator
 *
 */
public class QueryCommodityIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cId = request.getParameter("cId");
		List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findById(Integer.parseInt(cId));
		request.setAttribute("list", list);
		request.getRequestDispatcher("/backstage/bc_particular.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
