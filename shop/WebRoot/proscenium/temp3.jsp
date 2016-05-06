<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<html>
  <head> 
	
  </head>
  
  <body>
  <%String cNum = request.getParameter("cNum"); %>
    	<span>购买成功，<a href="/shop/ContentServlet?cNum=<%=cNum %>">点击返回</a></span>
  </body>
</html>
