package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;
/***
 * 后台进货商品处理
 * @author Administrator
 *
 */
public class JHServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String innum = request.getParameter("innum");
		byte a[] = innum.getBytes("ISO8859-1");
		innum = new String(a);
		
		String cNum = request.getParameter("cNum");
		
		List<CommodityHistoryPOJO> list = ShopDAOFactory.getCommodityHistoryDAOInsancet().findByNum(cNum);
		
		int hid = list.get(0).gethId();
		int hinc = list.get(0).gethInC();
		int houtc = list.get(0).gethOutC();
		
		CommodityHistoryPOJO pojo = new CommodityHistoryPOJO(hid,cNum,(hinc+Integer.parseInt(innum)),houtc);
		boolean bool = ShopDAOFactory.getCommodityHistoryDAOInsancet().doUpd(pojo);
		
		List<CommodityPOJO> list1 = ShopDAOFactory.getCommodityDAOInsancet().findBycNum(cNum);
		
		int cId = list1.get(0).getcId();
		String cName = list1.get(0).getcName();
		String cFormat = list1.get(0).getcFormat();
		String cPrice = list1.get(0).getcPrice();
		String cContent = list1.get(0).getcContent();
		String cImg = list1.get(0).getcImg();
		Date cIDate = list1.get(0).getcIDate();
		Date cODate = list1.get(0).getcODate();
		int cStatus = list1.get(0).getcStatus();
		
		
		
		for(int i=0;i<Integer.parseInt(innum);i++){
			int max = ShopDAOFactory.getCommodityDAOInsancet().findMax();
			CommodityPOJO pojo1 = new CommodityPOJO((max+1),cNum,cName,cFormat,cPrice,cContent,cImg,cIDate,cODate,cStatus);
			ShopDAOFactory.getCommodityDAOInsancet().doIns(pojo1);
		}
		
		
		if(bool){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('进货成功！');");
			out.println("history.back();");
			out.println("</script>");
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('进货失败！');");
			out.println("history.back();");
			out.println("</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
