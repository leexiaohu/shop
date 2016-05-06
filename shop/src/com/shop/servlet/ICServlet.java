package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * 后台添加商品处理
 * @author Administrator
 *
 */
public class ICServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		/**
		 * 处理图片上传功能
		 */
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
		String cNum = smartupload.getRequest().getParameter("cNum");
		
//		byte a[] = cNum.getBytes("ISO8859-1");
//		cNum = new String(a);
		String cName = smartupload.getRequest().getParameter("cName");
//		byte b[] = cName.getBytes("ISO8859-1");
//		cName = new String(b);
		String cFormat = smartupload.getRequest().getParameter("cFormat");
//		byte c[] = cFormat.getBytes("ISO8859-1");
//		cFormat = new String(c);
		String cPrice = smartupload.getRequest().getParameter("cPrice");
//		byte d[] = cPrice.getBytes("ISO8859-1");
//		cPrice = new String(d);
		String cContent = smartupload.getRequest().getParameter("cContent");
//		byte e[] = cContent.getBytes("ISO8859-1");
//		cContent = new String(e);
		
		
//		String cImg = request.getParameter("cImg");
//		byte f[] = cImg.getBytes("ISO8859-1");
//		cImg = new String(f);
		
		
		String cStatus = smartupload.getRequest().getParameter("cStatus");
//		byte g[] = cStatus.getBytes("ISO8859-1");
//		cStatus = new String(g);
		String hinc = smartupload.getRequest().getParameter("hinc");
//		byte i[] = hinc.getBytes("ISO8859-1");
//		hinc = new String(g);
		String cIDate = smartupload.getRequest().getParameter("cIDate");
//		byte h[] = cIDate.getBytes("ISO8859-1");
//		cIDate = new String(h);
		
		
		System.out.println("cNum  " + cNum);
		System.out.println("cName  " + cName);
		System.out.println("cFormat  " + cFormat);
		System.out.println("cPrice  " + cPrice);
		System.out.println("cContent  " + cContent);
//		System.out.println("cImg" + cImg);
		System.out.println("cStatus  " + cStatus);
		System.out.println("hinc  " + hinc);
		System.out.println("cIDate" + cIDate);
		
		
		
		
		
		
		
		String name = smartupload.getFiles().getFile(0).getFileName();//取得文件名称
		String filename = getServletContext().getRealPath("/")+"upload/"+name;

		String cImg = "/shop/upload/" + name;
		System.out.println(cImg);
		try {
			smartupload.getFiles().getFile(0).saveAs(filename);
		} catch (Exception e1) {
			e1.printStackTrace();
		}//保存文件
		
		
		List<CommodityPOJO> list = ShopDAOFactory.getCommodityDAOInsancet().findAll();
		List<CommodityHistoryPOJO> list1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findAll();
		int max = ShopDAOFactory.getCommodityDAOInsancet().findMax();
		int max1 = ShopDAOFactory.getCommodityHistoryDAOInsancet().findMax();
		boolean bool = false;
		boolean bool1 = false;
		
		for(int j=0;j<list1.size();j++){
			if(cNum.equals(list1.get(j).getcNum())){
				bool = true;
			}
		}
		
		System.out.println(bool);
	
		java.util.Date cIDate1=null;
		java.util.Date cODate1=null;
		if(bool){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('商品已存在！');");
			out.println("history.back();");
			out.println("</script>");
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			try {
				cIDate1=sdf.parse(cIDate);
				cODate1=sdf.parse("05/25/1992");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			 
			for(int k=0;k<Integer.parseInt(hinc);k++){
				CommodityPOJO pojo = new CommodityPOJO((++max),cNum,cName,cFormat,cPrice,cContent,cImg,cIDate1,cODate1,Integer.parseInt(cStatus));
				ShopDAOFactory.getCommodityDAOInsancet().doIns(pojo);	

			}
			
			CommodityHistoryPOJO pojoh = new CommodityHistoryPOJO((++max1),cNum,Integer.parseInt(hinc),0,cName);
			ShopDAOFactory.getCommodityHistoryDAOInsancet().doIns(pojoh);
			
			//提示商品添加成功
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('商品添加成功！');");
			out.println("history.back();");
			out.println("</script>");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
