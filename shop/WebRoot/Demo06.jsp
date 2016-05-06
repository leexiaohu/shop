 
<%@page contentType="text/html; charset=GBK"%>
<form action="Demo06.jsp" method="post" enctype="multipart/form-data">
	选择文件：<input type="file" name="pic"/><br>
	文件名称：<input type="text" name="picname"/><br>
	<input type="submit" value="提交"/>
</form>	   
<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="smartupload" class="org.lxh.smart.SmartUpload" scope="page">
</jsp:useBean>
<html>
	<head>
		<title>smartupload</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("GBK");
			smartupload.initialize(pageContext);//初始化上传文件
			smartupload.upload();//准备上传
			String name = smartupload.getRequest().getParameter("picname");//取得文件名称
			//String end_name = smartupload.getFiles().getFile(0).getFileExt();//取得文件的后缀
			//String filename = getServletContext().getRealPath("/")+"upload/"+name+"."+end_name;//文件的绝对路径
			//smartupload.getFiles().getFile(0).saveAs(filename);//保存文件
			String file = smartupload.getFiles().getFile(0).getFileName();
		 %>
		
		 <h1><%= file%></h1>
	</body>
</html>	 
