<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<html>
  <head> 
	
  </head>
  
  <body>
  <%String cNum = request.getParameter("cNum"); %>
    	<span>����ɹ���<a href="/shop/ContentServlet?cNum=<%=cNum %>">�������</a></span>
  </body>
</html>
