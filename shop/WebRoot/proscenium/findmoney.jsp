<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="com.shop.POJO.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="/shop/proscenium/css/content.css" rel="stylesheet" type="text/css" />
<title>�ʽ������¼��ѯ</title>


</head>


<body>
	<!--ͷ�� -->
	<div id="head">
		<div id="head-in">
			<div id="logo">
				<div style="margin-top:28px;">
					<a href="/shop/proscenium/index.jsp"><img src="/shop/proscenium/img/daodao.PNG" /></a>
				</div>
			</div>
			<div id="logo-right">
				<div id="login">
					
					<table style="height:30px; width:810px; background-color:rgb(177,0,0); float:right;color:rgb(255,208,192); font-size:12px;">
						<tr>
							<%
								if(session.getAttribute("username") == "" || session.getAttribute("username") == null){
							 %>
							<td width="100"><span>������ӭ��������</span></td>
							<td><a href="/shop/LoginServlet?id=1&url=<%=request.getRequestURI() %>">���¼</a></td>
							<td><a href="/shop/LoginServlet?id=3&url=<%=request.getRequestURI() %>">���ע��</a></td>
							<%}else{ %>
							<td width="20"><span>HI,</span></td>
							<td><a href="#"><%=session.getAttribute("username") %></a></td>
							<td><a href="/shop/LoginServlet?id=2">�˳�</a></td>
							<%} %>
							<td><span></span></td>
							<td><img src="/shop/proscenium/img/1.PNG" /></td>
							<td><a>�ҹ�ע��Ʒ��</a></td>
							<td><img src="/shop/proscenium/img/2.png" /></td>
							<td><a href="#">���ﳵ<span style="font-weight:bold;">0</span>��</a></td>
							<td width="65"><span>�ղؼ�</span></td>
							<td><img src="/shop/proscenium/img/3.png" /></td>
							<td><a href="#">�ֻ���</a></td>
							<td><a onclick="AddFavorite(window.location,document.title)" href="#">�����ղ�</a></td>
							<td><span>��վ����</span></td>
							<td><span>������Ʒ����</span></td>
						</tr>
					</table>
				</div>
				<div id="find">
				<form action="/shop/FindServlet" method="post">
					<table style="float:right;width:735px; margin-top:12px;">
						<tr>
							<td>
								<input type="text" style="height:30px; width:640px; color:rgb(204,204,204);" placeholder=" ���� ��è ��Ʒ/����" name="find"/>
								
							</td>
							<td width="95" style=" background-color:rgb(82,57,49); text-align:center;">
								<input type="submit" value="�� ��" style="color:#FFFFFF; background-color:rgb(82,57,49); width:45px; height:30px;  font-size:14px;  border:0px solid #FFFFFF;">
							</td>
						</tr>
					</table>
				</form>
				</div>
			</div>
		</div>	
	</div>
	<!-- -->
	<div id="bar">
		<div id="bar-in">
			<table style="width:1180px; color:#FFFFFF; font-size:14px; height:30px; text-align:center;">
				<tr>
					<td width="250"></td>
					<td><a href="/shop/proscenium/index.jsp">��ҳ</a></td>
					<td><a href="/shop/proscenium/deposit.jsp">�û����</a></td>
					<td><a href="/shop/proscenium/draw.jsp">�û�ȡ��</a></td>
					<td><a href="/shop/proscenium/transfer.jsp">�û�ת��</a></td>
					<td><a href="/shop/FindMoney">�û��ʽ������ѯ</a></td>
					<td><a href="/shop/FindBalance1">����ѯ</a></td>
					<td><a href="#">ҽҩ��</a></td>
					<td width="300"></td>
					<td width="80"><a href="#">�������ֲ�</a></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- ����-->
	
	<div id="content">
		<div id="content-in">
			<div style="width:980px; height:70px;"></div>
			<center style="color:red; font-size:30px; font-weight:bold;">�ʽ������¼��</center>
			<div style="width:980px; height:20px;"></div>
			<center>
			<% 
					List<FindsFlowPOJO> list = (List<FindsFlowPOJO>)request.getAttribute("list");	
						
			%>
			<table style="width:780px; text-align: center; border-collapse:collapse;" border="1">
				<tr>
					<th>���</th>
					<th>���</th>
					<th>����</th>
					<th>ʱ��</th>
					<th>��ע</th>
				</tr>
				<%
					for(int i=0;i<list.size();i++){	
				%>
				<tr>
					<td><%=(i+1) %></td>
					<td><%=list.get(i).getfSum() %></td>
					<%if(list.get(i).getfType() == 1){ %>
					<td>���</td>
					<%} %>
					<%if(list.get(i).getfType() == 2){ %>
					<td>ȡ��</td>
					<%} %>
					<%if(list.get(i).getfType() == 3){ %>
					<td>ת��</td>
					<%} %>
					<%if(list.get(i).getfType() == 4){ %>
					<td>ת��</td>
					<%} %>
					<%if(list.get(i).getfType() == 5){ %>
					<td>����</td>
					<%} %>
					<td><%=list.get(i).getfDate() %></td>
					<td><%=list.get(i).getfRemark() %></td>
				</tr>
				<%} %>
			</table>
			
			</center>
		</div>
	</div>
	
	<div id="bottom">
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td>Copyright  2011 ��������ѧԺУ���칫�Ұ�Ȩ���� </td>
			</tr>
			<tr>
				<td>��ַ������ʡ�����м���������·600��  |  �������룺361024  |  �绰��0592-6291536 6291537  |  ���棺0592-6291993
</td>
			</tr>
		</table>
	</div>
	
	
	

</body>
</html>