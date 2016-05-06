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
import com.shop.POJO.FindsFlowPOJO;
import com.shop.POJO.UserClientPOJO;

/***
 * 前台存款处理
 * @author Administrator
 *
 */
public class DepositServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deposit = request.getParameter("deposit");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		boolean bool5 = true;
		if(deposit == ""){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('请输入要存入的金额！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		
		if(username == null){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('您还未登录！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		if(bool5){
			int max = ShopDAOFactory.getFindsFlowDAOInsancet().findMax();
			
			List<UserClientPOJO> list = ShopDAOFactory.getUserClientDAOInsancet().findByUNum(username);
			System.out.println(list.size());
			int uId = list.get(0).getuId();
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String fDate = df.format(new Date());
			java.util.Date fDate1=null;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			try {
				fDate1 = sdf.parse(fDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
					
			
			String fRemarks = username + "存入" + deposit + "元金额";
			
			FindsFlowPOJO pojo = new FindsFlowPOJO((++max),uId,username,Integer.parseInt(deposit),1,fDate1,fRemarks);
			boolean bool = ShopDAOFactory.getFindsFlowDAOInsancet().doIns(pojo);
			
			if(bool){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.flush();
				out.println("<script>");
				out.println("alert('存款成功！');");
				out.println("history.back();");
				out.println("</script>");
			}
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
