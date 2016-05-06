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
/***
 * 后台根据商品名称查询商品处理
 * @author Administrator
 *
 */
public class QueryCommodityNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cName = request.getParameter("cName");
		byte a[] = cName.getBytes("ISO8859-1");
		cName = new String(a);
		List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findByName(cName);
		request.setAttribute("list", list);
		HttpSession session = request.getSession();
		session.setAttribute("listsize", list.size());
		request.getRequestDispatcher("/backstage/qchistory.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
