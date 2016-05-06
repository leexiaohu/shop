package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.CommodityByPOJO;
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;
import com.shop.POJO.FindsFlowPOJO;
import com.shop.POJO.UserClientPOJO;
import com.shop.PUB.FindBalance;
/***
 * 前台购买商品处理
 * @author Administrator
 *
 */
public class GMServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uNum = (String) session.getAttribute("username");
		String bCount = request.getParameter("number");
		String cNum = request.getParameter("cNum");
		String cPrice = request.getParameter("cPrice");
		String span = request.getParameter("span");
		
		int  bSum = Integer.parseInt(bCount) * Integer.parseInt(cPrice);
		int sum = FindBalance.findbl(uNum);
		boolean bool5 = true;
		if(uNum == null || uNum == ""){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('您还未登录！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		if(Integer.parseInt(bCount) == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('您未填入购买数量！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		if(Integer.parseInt(span) == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('商品已售空！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		if(sum < bSum){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('账户余额不足，请尽快充值！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		if(bool5){
			List<UserClientPOJO> list = ShopDAOFactory.getUserClientDAOInsancet().findByUNum(uNum);
			int uId = list.get(0).getuId();
			String uName = list.get(0).getuName();
			
			List<CommodityPOJO> list1 = ShopDAOFactory.getCommodityDAOInsancet().findBycNum(cNum);
			int cId = list1.get(0).getcId();
			String cName = list1.get(0).getcName();
			
			String bId = "" + (ShopDAOFactory.getCommodityByDAOInsancet().findMax()+1);
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String bDate = df.format(new Date());	
			java.util.Date bDate1=null;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			try {
				bDate1 = sdf.parse(bDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			CommodityByPOJO pojo = new CommodityByPOJO(Integer.parseInt(bId),uId,uName,cId,cName,Integer.parseInt(bCount),bSum,bDate1);
			boolean bool = ShopDAOFactory.getCommodityByDAOInsancet().doIns(pojo);
			
	//		System.out.println(uId);
	//		System.out.println(uName);
	//		System.out.println(cId);
	//		System.out.println(cName);
	//		System.out.println(bCount);
	//		System.out.println(bSum);
	//		System.out.println(bDate);
			
			List<CommodityHistoryPOJO> list2 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findByNum(cNum);
			
			int hId = list2.get(0).gethId();
			int hInc = list2.get(0).gethInC();
			int hOutc = list2.get(0).gethOutC() + Integer.parseInt(bCount);
			
			CommodityHistoryPOJO pojo1 = new CommodityHistoryPOJO(hId,cNum,hInc,hOutc,cName);
			boolean bool1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().doUpd(pojo1);
			
			//修改资金流向表
			int max = ShopDAOFactory.getFindsFlowDAOInsancet().findMax();
			List<UserClientPOJO> list3 = ShopDAOFactory.getUserClientDAOInsancet().findByUNum(uNum);
			int uId3 = list.get(0).getuId();
			SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
			String fDate = df3.format(new Date());
			java.util.Date fDate1=null;
			SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd");
			try {
				fDate1 = sdf.parse(fDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String fRemarks = uNum + "买" + cName + "花了" + bSum + "元金额";
			FindsFlowPOJO pojo3 = new FindsFlowPOJO((++max),uId,uNum,bSum,5,fDate1,fRemarks);
			boolean bool3 = ShopDAOFactory.getFindsFlowDAOInsancet().doIns(pojo3);
			
			if(bool&&bool1&&bool3){		
				request.getRequestDispatcher("/proscenium/temp3.jsp?" + cNum).forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
