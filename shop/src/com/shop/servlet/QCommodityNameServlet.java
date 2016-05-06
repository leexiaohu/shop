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
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;
/***
 * 后台查询商品名称处理
 * @author Administrator
 *
 */
public class QCommodityNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cNum = request.getParameter("cNum");
		byte a[] = cNum.getBytes("ISO8859-1");
		cNum = new String(a);
		System.out.println("kkkkkkk" + cNum);
		List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findAll();
		HttpSession session = request.getSession();
		
		List<CommodityHistoryPOJO> list1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findByNum(cNum);
		 
		session.setAttribute("listsize", list1.size());
		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
		request.getRequestDispatcher("/backstage/qcommodity.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
