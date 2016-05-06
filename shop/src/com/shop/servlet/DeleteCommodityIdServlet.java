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

public class DeleteCommodityIdServlet extends HttpServlet {

	/***
	 * 后台按照cId删除商品
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cId = request.getParameter("cId");
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("confirm('确认继续删除？');");
		out.println("</script>");
		
		
		List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findById(Integer.parseInt(cId));
		
		String cNum = list.get(0).getcNum();
		List<CommodityHistoryPOJO> list3 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findByNum(cNum);
		int hId = list3.get(0).gethId();
		ShopDAOFactory.getCommodityHistoryDAOInsancet().doDel(hId);
		ShopDAOFactory.getCommodityDAOInsancet().doDel(Integer.parseInt(cId));
		
		request.setAttribute("list", list);//可以分页删除
		
		
		HttpSession session = request.getSession();
		List<CommodityPOJO> list1 = ShopDAOFactory.getCommodityDAOInsancet().findAll();
		session.setAttribute("listsize", list1.size());
		
	
		out.flush();
		out.println("<script>");
		out.println("alert('删除成功！');");
		out.println("history.back();");
		out.println("</script>");
		
		
		List<CommodityHistoryPOJO> list2 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findAll();
		request.setAttribute("list1", list2);
		request.getRequestDispatcher("/backstage/dcommodity.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
