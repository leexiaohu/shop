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

public class ContentServlet extends HttpServlet {

	/***
	 * 获取商品具体信息
	 * 进入购买界面
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cNum = request.getParameter("cNum");

		List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findBycNum(cNum);
		List<CommodityHistoryPOJO> list1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findByNum(cNum);
		
		String find = (String) session.getAttribute("find");
		
		List<CommodityPOJO> list2 = ShopDAOFactory.getCommodityDAOInsancet().findByName(find);

		List<CommodityHistoryPOJO> list3 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findByName(find);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);	
		session.setAttribute("listsize", list3.size());
		
		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
	
		
		request.getRequestDispatcher("/proscenium/content.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
