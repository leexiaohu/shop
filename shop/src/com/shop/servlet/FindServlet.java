package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;
/***
 * 前台查询商品处理
 * @author Administrator
 *
 */
public class FindServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String find = request.getParameter("find");
		byte a[] = find.getBytes("ISO8859-1");
		find = new String(a);
		
		List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findByName(find);

		List<CommodityHistoryPOJO> list1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findByName(find);
		
		System.out.println(list.size() + "list");
		System.out.println(list1.size() + "list1");
		
		List<CommodityHistoryPOJO> list2 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findT();
		List<CommodityPOJO> list3 = ShopDAOFactory.getCommodityDAOInsancet().findAll();
		HttpSession session = request.getSession();
		
		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		
		session.setAttribute("listsize", list1.size());
		
		session.setAttribute("find", find);
		
//		for(int i=0;i<list1.size();i++){
//			System.out.println(list1.get(i).getcName());
//		}
		
		request.getRequestDispatcher("/proscenium/find.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
