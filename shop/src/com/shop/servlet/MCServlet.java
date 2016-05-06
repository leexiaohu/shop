package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.lxh.smart.SmartUpload;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;
/***
 * 后台修改商品处理
 * @author Administrator
 *
 */
public class MCServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		SmartUpload smartupload = new SmartUpload();		
		PageContext pageContext = null;
		JspFactory _jspxFactory = null;
		_jspxFactory = JspFactory.getDefaultFactory();
		pageContext = _jspxFactory.getPageContext(this,request,response,"",true,8192,true);		
		smartupload.initialize(pageContext);//初始化上传文件
		try {
			smartupload.upload();//准备上传
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		request.setCharacterEncoding("gbk");
		String cId = smartupload.getRequest().getParameter("cId");
		
		String cNum = smartupload.getRequest().getParameter("cNum");

		String cName = smartupload.getRequest().getParameter("cName");

		String cFormat = smartupload.getRequest().getParameter("cFormat");

		String cPrice = smartupload.getRequest().getParameter("cPrice");

		String cContent = smartupload.getRequest().getParameter("cContent");

		String cStatus = smartupload.getRequest().getParameter("cStatus");

		String cIDate = smartupload.getRequest().getParameter("cIDate");
		
		String cODate = smartupload.getRequest().getParameter("cIDate");

		String cImg = smartupload.getRequest().getParameter("cImg");
		
//		System.out.println("cId  " + cId);
//		System.out.println("cNum  " + cNum);
//		System.out.println("cName  " + cName);
//		System.out.println("cFormat  " + cFormat);
//		System.out.println("cPrice  " + cPrice);
//		System.out.println("cContent  " + cContent);
//		System.out.println("cStatus  " + cStatus);
//		System.out.println("cIDate" + cIDate);
		
		String name = smartupload.getFiles().getFile(0).getFileName();//取得文件名称
		String filename = getServletContext().getRealPath("/")+"upload/"+name;

		if(!name.equals("")){
			cImg = "/shop/upload/" + name;
//			System.out.println(cImg);
//			System.out.println(filename);
			try {
				smartupload.getFiles().getFile(0).saveAs(filename);
			} catch (Exception e1) {
				e1.printStackTrace();
			}//保存文件
		
		}
		java.util.Date cIDate1=null;
		java.util.Date cODate1=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			cIDate1=sdf.parse(cIDate);
			cODate1=sdf.parse(cODate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CommodityPOJO pojo = new CommodityPOJO(Integer.parseInt(cId),cNum,cName,cFormat,cPrice,cContent,cImg,cIDate1,cODate1,Integer.parseInt(cStatus));
		ShopDAOFactory.getCommodityDAOInsancet().doUpd(pojo);	
		
		//提示商品修改成功
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('商品修改成功！');");
		out.println("history.back();");
		out.println("</script>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
