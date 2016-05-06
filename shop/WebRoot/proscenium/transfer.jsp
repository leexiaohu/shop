<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="com.shop.POJO.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="/shop/proscenium/css/content.css" rel="stylesheet" type="text/css" />
<title>转账</title>


</head>


<body>
	<!--头部 -->
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
							<td width="100"><span>旺，欢迎来刀刀！</span></td>
							<td><a href="/shop/LoginServlet?id=1&url=<%=request.getRequestURI() %>">请登录</a></td>
							<td><a href="/shop/LoginServlet?id=3&url=<%=request.getRequestURI() %>">免费注册</a></td>
							<%}else{ %>
							<td width="20"><span>HI,</span></td>
							<td><a href="#"><%=session.getAttribute("username") %></a></td>
							<td><a href="/shop/LoginServlet?id=2">退出</a></td>
							<%} %>
							<td><span></span></td>
							<td><img src="/shop/proscenium/img/1.PNG" /></td>
							<td><a>我关注的品牌</a></td>
							<td><img src="/shop/proscenium/img/2.png" /></td>
							<td><a href="#">购物车<span style="font-weight:bold;">0</span>件</a></td>
							<td width="65"><span>收藏夹</span></td>
							<td><img src="/shop/proscenium/img/3.png" /></td>
							<td><a href="#">手机版</a></td>
							<td><a onclick="AddFavorite(window.location,document.title)" href="#">加入收藏</a></td>
							<td><span>网站导航</span></td>
							<td><span>所有商品分类</span></td>
						</tr>
					</table>
				</div>
				<div id="find">
				<form action="/shop/FindServlet" method="post">
					<table style="float:right;width:735px; margin-top:12px;">
						<tr>
							<td>
								<input type="text" style="height:30px; width:640px; color:rgb(204,204,204);" placeholder=" 搜索 天猫 商品/店铺" name="find"/>
								
							</td>
							<td width="95" style=" background-color:rgb(82,57,49); text-align:center;">
								<input type="submit" value="搜 索" style="color:#FFFFFF; background-color:rgb(82,57,49); width:45px; height:30px;  font-size:14px;  border:0px solid #FFFFFF;">
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
					<td><a href="/shop/proscenium/index.jsp">首页</a></td>
					<td><a href="/shop/proscenium/deposit.jsp">用户存款</a></td>
					<td><a href="/shop/proscenium/draw.jsp">用户取款</a></td>
					<td><a href="/shop/proscenium/transfer.jsp">用户转账</a></td>
					<td><a href="/shop/FindMoney">用户资金流向查询</a></td>
					<td><a href="/shop/FindBalance1">余额查询</a></td>
					<td><a href="#">医药馆</a></td>
					<td width="300"></td>
					<td width="80"><a href="#">刀刀俱乐部</a></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 内容-->
	
	<div id="content">
		<div id="content-in">
			<form action="/shop/TransferServlet" method="post">
				<table style="width:880px; margin-top:100px; height:80px;">
					<tr>
						<td style="text-align:right">请输入您要转出的金额</td>
						<td style="width:30px;"></td>
						<td><input type="text" name="transfer"></td>
					</tr>
					<tr>
						<td style="text-align:right">请输入要转入的账号</td>
						<td style="width:30px;"></td>
						<td><input type="text" name="username1"></td>
					</tr>
					<tr>
						<td style="text-align:right"></td>
						<td style="width:30px;"></td>
						<td><input type="submit" value="提交"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<div id="bottom">
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td>Copyright  2011 厦门理工学院校长办公室版权所有 </td>
			</tr>
			<tr>
				<td>地址：福建省厦门市集美区理工路600号  |  邮政编码：361024  |  电话：0592-6291536 6291537  |  传真：0592-6291993
</td>
			</tr>
		</table>
	</div>
	
	
	

</body>
</html>
