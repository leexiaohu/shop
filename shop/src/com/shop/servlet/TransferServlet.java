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
 * ǰ̨ת�˴���
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
			out.println("alert('������Ҫȡ���Ľ�');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		
		if(username1 == ""){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('������Ҫ������˻���');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		
		if(username == null){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('����δ��¼��');");
			out.println("history.back();");
			out.println("</script>");
			bool5 = false;
		}
		
		if(username1.equals(username)){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('���ܸ��Լ��˻�ת�ˣ����������룡');");
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
			out.println("alert('���㣡');");
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
			out.println("alert('ת����˻������ڣ����������룡');");
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
			
			String fRemarks = username + "ת��" + transfer + "Ԫ����" + username1;
			String fRemarks1 = username + "ת��" + transfer + "Ԫ����" + username1;
			FindsFlowPOJO pojo = new FindsFlowPOJO((++max),uId,username,Integer.parseInt(transfer),4,fDate1,fRemarks);
			FindsFlowPOJO pojo1 = new FindsFlowPOJO((++max),uId,username1,Integer.parseInt(transfer),3,fDate1,fRemarks1);
			boolean bool = ShopDAOFactory.getFindsFlowDAOInsancet().doIns(pojo);
			boolean bool1 = ShopDAOFactory.getFindsFlowDAOInsancet().doIns(pojo1);
			
			if(bool && bool1){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.flush();
				out.println("<script>");
				out.println("alert('ת�˳ɹ���');");
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
