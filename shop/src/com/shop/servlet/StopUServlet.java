package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.UserClientPOJO;
/***
 * 后台账号停用启用处理
 * @author Administrator
 *
 */
public class StopUServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uName = request.getParameter("uName");
		String uStatus = request.getParameter("uStatus");
		List<UserClientPOJO> list1 = ShopDAOFactory.getUserClientDAOInsancet().findByName(uName);
		
		int uId = list1.get(0).getuId();
		String uPsw = list1.get(0).getuPsw();
		String uNum = list1.get(0).getuNum();
		String uRName = list1.get(0).getuRName();
		String uTel = list1.get(0).getuTel();
		String uAdd = list1.get(0).getuAdd();
		String uEmail = list1.get(0).getuEmail();
		UserClientPOJO pojo;
		if(uStatus.equals("1")){
			pojo = new UserClientPOJO(uId,uName,uPsw,uNum,uRName,uTel,uAdd,uEmail,2);
		}
		else{
			pojo = new UserClientPOJO(uId,uName,uPsw,uNum,uRName,uTel,uAdd,uEmail,1);
		}
		
		boolean bool = ShopDAOFactory.getUserClientDAOInsancet().doUpd(pojo);
		
		if(bool && uStatus.equals("1")){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('账户已停用！');");
			out.println("history.back();");
			out.println("</script>");
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('账户已启用！');");
			out.println("history.back();");
			out.println("</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
