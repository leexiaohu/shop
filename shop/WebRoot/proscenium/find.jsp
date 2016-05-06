<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="com.shop.POJO.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="/shop/proscenium/css/find.css" rel="stylesheet" type="text/css" />
<title>Find</title>

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
				<%
					List<CommodityPOJO> list = (List<CommodityPOJO>)request.getAttribute("list");
					List<CommodityHistoryPOJO> list1 = (List<CommodityHistoryPOJO>)request.getAttribute("list1");
					int  listsize = (Integer)session.getAttribute("listsize");
				%>
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
					<td width="100">共找到<%=listsize %>件商品</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 内容-->
	<div id="content">
		<div id="content-in">
			<div style="height:10px; width:1180px;"></div>
			
			<div style="width:1130px; height:80px; border-style:solid; border-color:#996633;">
				<div style="float:left; width:150px; height:80px; background-color:rgb(247,245,245);">
					<table style="font-size:12px; margin-left:10px; margin-top:5px; color:#996633;">
						<tr>
							<td>分类</td>
						</tr>
					</table>
				</div>
				<div style="float:left; width:980px; height:80px;" id="font">
					<table style="font-size:12px; margin-left:20px;color:#996633; width:960px; height:80px; text-align: center">
						<tr>
							<td><a href="/shop/ClassifyServlet?cName=T-shirt">T-shirt</a></td>
							<td><a href="/shop/ClassifyServlet?cName=背心">背心</a></td>
							<td><a href="/shop/ClassifyServlet?cName=笔记本">笔记本</a></td>
							<td><a href="/shop/ClassifyServlet?cName=抱枕">抱枕</a></td>
							<td><a href="/shop/ClassifyServlet?cName=公仔">公仔</a></td>
							<td><a href="/shop/ClassifyServlet?cName=暖手宝">暖手宝</a></td>
							<td><a href="/shop/ClassifyServlet?cName=内裤">内裤</a></td>
							<td><a href="/shop/ClassifyServlet?cName=卡贴">卡贴</a></td>
							<td><a href="/shop/ClassifyServlet?cName=明信片">明信片</a></td>
							<td><a href="/shop/ClassifyServlet?cName=相册">相册</a></td>
						</tr>
						<tr>
							<td><a href="/shop/ClassifyServlet?cName=学生杯">学生杯</a></td>
							<td><a href="/shop/ClassifyServlet?cName=保温杯">保温杯</a></td>
							<td><a href="/shop/ClassifyServlet?cName=马克杯">马克杯</a></td>
							<td><a href="/shop/ClassifyServlet?cName=头饰品">头饰品</a></td>
							<td><a href="/shop/ClassifyServlet?cName=手机套">手机套</a></td>
							<td><a href="/shop/ClassifyServlet?cName=包包">包包</a></td>
							<td><a href="/shop/ClassifyServlet?cName=被子">被子</a></td>
							<td><a href="/shop/ClassifyServlet?cName=面巾纸">面巾纸</a></td>
							<td><a href="/shop/ClassifyServlet?cName=手帕纸">手帕纸</a></td>
							<td><a href="/shop/ClassifyServlet?cName=抽纸巾">抽纸巾</a></td>
						</tr>
					</table>
				</div>
			</div>
			
			<div style="width:1130px; height:40px; border-style:solid; border-color:#996633; border-top-style:none;">
				<div style="float:left; width:150px; height:40px; background-color:rgb(247,245,245);">
					<table style="font-size:12px; margin-left:10px; margin-top:5px; color:#996633;">
						<tr>
							<td>品牌</td>
						</tr>
					</table>
				</div>
				<div style="float:right; width:980px; height:40px;" id="font">
					<table style="font-size:12px; margin-left:20px;color:#996633; width:960px; height:40px;">
						<tr>
							<td><a href="#">Disney/迪斯尼</a></td>
							<td><a href="#">Disney/迪斯尼</a></td>
							<td><a href="#">Disney/迪斯尼</a></td>
							<td><a href="#">Disney/迪斯尼</a></td>
							<td><a href="#">Disney/迪斯尼</a></td>
							<td><a href="#">Disney/迪斯尼</a></td>
							<td><a href="#">Disney/迪斯尼</a></td>
							<td><a href="#">Disney/迪斯尼</a></td>
						</tr>
					</table>
				</div>
			</div>
			
			<!-- 你是不是想找-->
			<div style="width:1130px; height:50px;" id="ni">
				<table style="width:1130px; height:28px; color:#996633; font-size:13px; text-align:center;">
					<tr>
						<td style="width:100px;">您是不是想找</td>
						<td style="width:40px;"></td>
						<td><a href="#">中学生书包</a></td>
						<td>|</td>
						<td><a href="#">儿童书包</a></td>
						<td>|</td>
						<td><a href="#">迪斯尼书包</a></td>
						<td>|</td>
						<td><a href="#">幼儿书包</a></td>
						<td>|</td>
						<td><a href="#">芭比书包</a></td>
						<td>|</td>
						<td><a href="#">书包双肩女韩版</a></td>
						<td>|</td>
						<td><a href="#">书包双肩英伦版</a></td>
						<td>|</td>
						<td><a href="#">书包双肩女时尚</a></td>
						<td>|</td>
						<td style="width:200px;"></td>
					</tr>
				</table>
			</div>
			
			<div style="width:1130px; height:30px;">
				<span  style="color:red; font-size:22px; font-weight:bold;">热销商品</span>
			</div>
			
			<%
				List<CommodityHistoryPOJO> list2 = (List<CommodityHistoryPOJO>)request.getAttribute("list2"); 
				List<CommodityPOJO> list3 = (List<CommodityPOJO>)request.getAttribute("list3"); 
			%>
			<div style="width:1180px; height:336px;" >
				<!-- 一排图片展览1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=0;i<5;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list3.size();j++){ 
						if(list2.get(i).getcNum().equals(list3.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list2.get(i).getcNum() %>"><img src="<%=list3.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list3.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list2.get(i).getcNum() %>"><%=list3.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);"> <span style="color:rgb(196,145,115);"></span></span>
						<img alt="" src="/shop/proscenium/img/r.png">
					</div>
				</div>
				<%} %>
			</div>
			</div>
			
			
			<div style="width:1130px; height:30px;">
				<div style="width:1128px; height:150px;"></div>
			</div>
			
			<div style="width:1130px; height:30px; margin-top:50px;">
				<span  style="color:red; font-size:22px; font-weight:bold;">你想要的商品</span>
			</div>
			
			<% 
				if(listsize <= 5){
			 %>
			<!-- 一排图片展览1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=0;i<listsize;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
			</div>
			<%} %>
			<!--  大于5小于10 -->
			<%
			if(listsize <= 10 && listsize > 5){
			 %>
			<!-- 一排图片展览1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=0;i<5;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
				
				<%
					for(int i=5;i<listsize;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
			</div>
			<%} %>
			
			<!--  大于10小于15 -->
			<% 
				if(listsize <= 15 && listsize > 10){
			 %>
			<!-- 一排图片展览1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=0;i<5;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
				
				<!-- 一排图片展览1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=5;i<10;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
				
				<!-- 一排图片展览1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=10;i<listsize;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
			</div>
			<%} %>
			
			<!--  大于15 -->
			<% 
				if(listsize > 15){
			 %>
			<!-- 一排图片展览1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=0;i<5;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
				
				<!-- 一排图片展览1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=5;i<10;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
				
				<!-- 一排图片展览1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=10;i<15;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
			</div>
			<%} %>
			
			
			
			
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
