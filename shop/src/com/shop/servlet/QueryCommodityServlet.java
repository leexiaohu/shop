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
/***
 * 后台查询商品处理
 * @author Administrator
 *
 */
public class QueryCommodityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		CommodityPOJO pojo = new CommodityPOJO(16,"00004","刀刀狗","黑色","100.5",1,"刀刀狗主题裤子","/shop/backstage/img/1.jpg");
//		boolean list1 = ShopDAOFactory.getCommodityDAOInsancet().doIns(pojo);
//		boolean bool = ShopDAOFactory.getCommodityDAOInsancet().doUpd(pojo);
//		boolean list = ShopDAOFactory.getCommodityDAOInsancet().doDel(3);
//		System.out.println(list1);
//		System.out.println(bool);
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getcId());
//			System.out.println(list.get(i).getcNum());
//			System.out.println(list.get(i).getcName());
//			System.out.println(list.get(i).getcFormat());
//			System.out.println(list.get(i).getcPrice());
//			System.out.println(list.get(i).getcStatus());
//			System.out.println(list.get(i).getcContent());
//			System.out.println(list.get(i).getcImg());
//		}
		
		
		
		String id = request.getParameter("id");
		List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findAll();
		request.setAttribute("list", list);
		HttpSession session = request.getSession();
		
		
		
//		response.sendRedirect("backstage\\qcommodity.jsp");
		
		if(id.equals("11")){
			List<CommodityHistoryPOJO> list1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findAll();
			request.setAttribute("list1", list1);
			session.setAttribute("listsize", list1.size());
//			System.out.println(list1.size());
			request.getRequestDispatcher("/backstage/qcommodity.jsp").forward(request, response);
		}
		
		if(id.equals("13")){
			session.setAttribute("listsize", list.size());
			request.getRequestDispatcher("/backstage/modify.jsp").forward(request, response);
		}
		if(id.equals("14")){
			List<CommodityHistoryPOJO> list1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findAll();
			request.setAttribute("list1", list1);
			session.setAttribute("listsize", list.size());
			request.getRequestDispatcher("/backstage/dcommodity.jsp").forward(request, response);
		}
		if(id.equals("15")){
			session.setAttribute("listsize", list.size());
			request.getRequestDispatcher("/backstage/qchistory.jsp").forward(request, response);
		}
			

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
