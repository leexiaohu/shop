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
import com.shop.PUB.FindBalance;
/***
 * 前台转账处理
 * @author Administrator
 *
 */
public class TransferServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String transfer = request.getParameter("transfer");
		String username1 = request.getParameter("username1");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		boolean bool5 = true;
		
		if(transfer == ""){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('请输入要取出的金额！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		
		if(username1 == ""){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('请输入要存入的账户！');");
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
		
		if(username1.equals(username)){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('不能给自己账户转账，请重新输入！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		
		int sum = FindBalance.findbl(username);
		
		if(sum < Integer.parseInt(transfer)){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('余额不足！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		
		List<UserClientPOJO> list5 = ShopDAOFactory.getUserClientDAOInsancet().findByUNum(username1);
		if(list5.size() == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('转入的账户不存在，请重新输入！');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		if(bool5){
			int max = ShopDAOFactory.getFindsFlowDAOInsancet().findMax();
			List<UserClientPOJO> list = ShopDAOFactory.getUserClientDAOInsancet().findByUNum(username);
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
			
			String fRemarks = username + "转出" + transfer + "元金额给" + username1;
			String fRemarks1 = username + "转入" + transfer + "元金额给" + username1;
			FindsFlowPOJO pojo = new FindsFlowPOJO((++max),uId,username,Integer.parseInt(transfer),4,fDate1,fRemarks);
			FindsFlowPOJO pojo1 = new FindsFlowPOJO((++max),uId,username1,Integer.parseInt(transfer),3,fDate1,fRemarks1);
			boolean bool = ShopDAOFactory.getFindsFlowDAOInsancet().doIns(pojo);
			boolean bool1 = ShopDAOFactory.getFindsFlowDAOInsancet().doIns(pojo1);
			
			if(bool && bool1){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.flush();
				out.println("<script>");
				out.println("alert('转账成功！');");
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
