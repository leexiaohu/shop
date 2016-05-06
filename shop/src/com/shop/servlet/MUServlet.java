package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.lxh.smart.SmartUpload;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.UserClientPOJO;
/***
 * ��̨�û���Ϣ�޸Ĵ���
 * @author Administrator
 *
 */
public class MUServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		SmartUpload smartupload = new SmartUpload();		
		PageContext pageContext = null;
		JspFactory _jspxFactory = null;
		_jspxFactory = JspFactory.getDefaultFactory();
		pageContext = _jspxFactory.getPageContext(this,request,response,"",true,8192,true);		
		smartupload.initialize(pageContext);//��ʼ���ϴ��ļ�
		try {
			smartupload.upload();//׼���ϴ�
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		request.setCharacterEncoding("gbk");
		String uId = smartupload.getRequest().getParameter("uId");
		String uName = smartupload.getRequest().getParameter("uName");
		String uPsw = smartupload.getRequest().getParameter("uPsw");
		String uNum = smartupload.getRequest().getParameter("uNum");
		String uRName = smartupload.getRequest().getParameter("uRName");
		String uTel = smartupload.getRequest().getParameter("uTel");
		String uAdd = smartupload.getRequest().getParameter("uAdd");
		String uEmail = smartupload.getRequest().getParameter("uEmail");
		String uStatus = smartupload.getRequest().getParameter("uStatus");
		
		
		UserClientPOJO pojo = new UserClientPOJO(Integer.parseInt(uId),uName,uPsw,uNum,uRName,uTel,uAdd,uEmail,Integer.parseInt(uStatus));
		ShopDAOFactory.getUserClientDAOInsancet().doUpd(pojo);
		
		//��ʾ�û���Ϣ�޸ĳɹ�
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('�û���Ϣ�޸ĳɹ���');");
		out.println("history.back();");
		out.println("</script>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
