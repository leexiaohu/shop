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
 * 后台修改商品信息处理
 * @author Administrator
 *
 */
public class ModifyCommodityFServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String num = request.getParameter("num");
			System.out.println(num);
			List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findByNum(Integer.parseInt(num));
			request.setAttribute("list", list);
			request.getRequestDispatcher("/backstage/modify.jsp").forward(request, response);
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getcName());
			}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
