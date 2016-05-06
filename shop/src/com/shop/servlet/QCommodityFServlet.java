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
/***
 * 后台查询商品处理
 * @author Administrator
 *
 */
public class QCommodityFServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String num = request.getParameter("num");
			System.out.println(num);
			List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findAll();
			request.setAttribute("list", list);
			List<CommodityHistoryPOJO> list1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findByYNum(Integer.parseInt(num));
			request.setAttribute("list1", list1);
			System.out.println("list  " + list.size());
			System.out.println("list1   " + list1.size());
			request.getRequestDispatcher("/backstage/qcommodity.jsp").forward(request, response);
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.get(i).getcName());
//			}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
