 
<%@page contentType="text/html; charset=GBK"%>
<form action="Demo06.jsp" method="post" enctype="multipart/form-data">
	ѡ���ļ���<input type="file" name="pic"/><br>
	�ļ����ƣ�<input type="text" name="picname"/><br>
	<input type="submit" value="�ύ"/>
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
			smartupload.initialize(pageContext);//��ʼ���ϴ��ļ�
			smartupload.upload();//׼���ϴ�
			String name = smartupload.getRequest().getParameter("picname");//ȡ���ļ�����
			//String end_name = smartupload.getFiles().getFile(0).getFileExt();//ȡ���ļ��ĺ�׺
			//String filename = getServletContext().getRealPath("/")+"upload/"+name+"."+end_name;//�ļ��ľ���·��
			//smartupload.getFiles().getFile(0).saveAs(filename);//�����ļ�
			String file = smartupload.getFiles().getFile(0).getFileName();
		 %>
		
		 <h1><%= file%></h1>
	</body>
</html>	 
