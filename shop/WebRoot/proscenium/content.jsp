<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="com.shop.POJO.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="/shop/proscenium/css/content.css" rel="stylesheet" type="text/css" />
<title>Find</title>
<script type="text/javascript">
	function ack(){
	
		return confirm("确认购买吗？");
		
	}
</script>

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
			<div style="width:980px; height:50px; margin-top:20px;">
				<%
					List<CommodityPOJO> list = (List<CommodityPOJO>)request.getAttribute("list");
					List<CommodityHistoryPOJO> list1 = (List<CommodityHistoryPOJO>)request.getAttribute("list1");	
					for(int i=0;i<list.size();i++){
						if(list1.get(0).getcNum().equals(list.get(i).getcNum())){			
				%>
				<table style="width:980px; height:50px; font-size:16px; font-weight:bold;">
					<tr>
						<td><span><%=list1.get(0).getcName() %></span></td>
					</tr>
				</table>
			</div>
			
			<!-- 购买区域 -->
			<div style="width:980px;">
				<div style="width:380px; height:420px; float:left;">
					<table style="width:380px; height:420px; border:1px solid #CCCCCC;">
						<tr>
							<td>
								<img src="<%=list.get(i).getcImg() %>"  width="380" height="380"/>
							</td>
						</tr>
						<tr height="40px;">
							<td></td>
						</tr>
					</table>
				</div>
				<div style="width:600px; height:420px; float:right;">
				<form action="/shop/GMServlet" method="post">
				<input type="hidden" name="cNum" value="<%=list1.get(0).getcNum() %>"/>
				<input type="hidden" name="cPrice" value="<%=list.get(i).getcPrice() %>"/>
				<input type="hidden" name="span" value="<%=(list1.get(0).gethInC()-list1.get(0).gethOutC()) %>"/>
					<table style="width:585px; height:420px; margin-left:15px; color:rgb(153,153,153); font-size:14px;">
						<tr height="50px;">
							<td style="width:80px;">价格</td>
							<td style="color:#FF0000; font-size:24px;">￥<%=list.get(i).getcPrice() %></td>
						</tr>
						<tr>
							<td>月销量</td>
							<td><span style="color:rgb(51,136,187);"><%=list1.get(0).gethOutC() %></span>件</td>
						</tr>
						<tr>
							<td>规格</td>
							<td><%=list.get(i).getcFormat() %></td>
						</tr>
						<tr>
							<td>描述</td>
							<td><%=list.get(i).getcContent() %></td>
						</tr>
						<tr>
							<td>数量</td>
							<td>
								<span style="display: block;">
									<input type="text" name="number" value="0" id="number" style="width: 50px;"/>
									<input type="button" value=" + " id="add" onclick="javascript:var v = document.getElementById('number').value;v++;document.getElementById('number').value=v;var kc=document.getElementById('kc').innerHTML; if(kc<=v){document.getElementById('number').value=kc;}if(kc==0){alert('库存不足');}"/>
									<input type="button" value=" - " id="sub" onclick="javascript:var v = document.getElementById('number').value;v--;if(v>=1){document.getElementById('number').value=v}else{document.getElementById('number').value=0;}"/>库存<span id="kc"><%=(list1.get(0).gethInC()-list1.get(0).gethOutC()) %></span>
								</span>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="submit" value="立刻购买"  onclick="return ack();" style="color:#FFFFFF; background-color:rgb(181,113,54); height:30px; width:150px; border:0px solid #FFFFFF; font-size:14px;"/>
							</td>
						</tr>
						<tr>
							<td></td>
							<td style="height:0px;"></td>
						</tr>
					</table>
				</form>
					
				</div>
			</div>
			<%
				break;}
			
			} %>
			
			
			<!-- 相关商品 -->
			<!--  
			<div style="width:980px; height:306px;">
				<table style="width:980px;height:150px; font-size:20px; color:red; font-weight: bold;">
					
					<tr>
						<td>相关商品</td>
					</tr>
				</table>
			</div>
			-->
			<%
				List<CommodityPOJO> list2 = (List<CommodityPOJO>)request.getAttribute("list2");
				List<CommodityHistoryPOJO> list3 = (List<CommodityHistoryPOJO>)request.getAttribute("list3");
				int  listsize = (Integer)session.getAttribute("listsize");
			%>
			
			<div style="width:980px; height:336px;margin-top:200px;">
				<%
					if(listsize < 5){
					for(int i=0;i<listsize;i++){
				%>
				<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list2.size();j++){ 
						if(list3.get(i).getcNum().equals(list2.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list3.get(i).getcNum() %>"><img src="<%=list2.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list2.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list3.get(i).getcNum() %>"><%=list2.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list3.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} 
				}else{
					for(int i=0;i<4;i++){%>
					<!-- 一排图片展览-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list2.size();j++){ 
						if(list3.get(i).getcNum().equals(list2.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list3.get(i).getcNum() %>"><img src="<%=list2.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>￥<%=list2.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list3.get(i).getcNum() %>"><%=list2.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">月销量 <span style="color:rgb(196,145,115);"><%=list3.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} }%>
			</div>
			
			
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
