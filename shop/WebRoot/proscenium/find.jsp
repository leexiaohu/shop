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
					<td><a href="/shop/proscenium/index.jsp">��ҳ</a></td>
					<td><a href="/shop/proscenium/deposit.jsp">�û����</a></td>
					<td><a href="/shop/proscenium/draw.jsp">�û�ȡ��</a></td>
					<td><a href="/shop/proscenium/transfer.jsp">�û�ת��</a></td>
					<td><a href="/shop/FindMoney">�û��ʽ������ѯ</a></td>
					<td><a href="/shop/FindBalance1">����ѯ</a></td>
					<td><a href="#">ҽҩ��</a></td>
					<td width="300"></td>
					<td width="100">���ҵ�<%=listsize %>����Ʒ</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- ����-->
	<div id="content">
		<div id="content-in">
			<div style="height:10px; width:1180px;"></div>
			
			<div style="width:1130px; height:80px; border-style:solid; border-color:#996633;">
				<div style="float:left; width:150px; height:80px; background-color:rgb(247,245,245);">
					<table style="font-size:12px; margin-left:10px; margin-top:5px; color:#996633;">
						<tr>
							<td>����</td>
						</tr>
					</table>
				</div>
				<div style="float:left; width:980px; height:80px;" id="font">
					<table style="font-size:12px; margin-left:20px;color:#996633; width:960px; height:80px; text-align: center">
						<tr>
							<td><a href="/shop/ClassifyServlet?cName=T-shirt">T-shirt</a></td>
							<td><a href="/shop/ClassifyServlet?cName=����">����</a></td>
							<td><a href="/shop/ClassifyServlet?cName=�ʼǱ�">�ʼǱ�</a></td>
							<td><a href="/shop/ClassifyServlet?cName=����">����</a></td>
							<td><a href="/shop/ClassifyServlet?cName=����">����</a></td>
							<td><a href="/shop/ClassifyServlet?cName=ů�ֱ�">ů�ֱ�</a></td>
							<td><a href="/shop/ClassifyServlet?cName=�ڿ�">�ڿ�</a></td>
							<td><a href="/shop/ClassifyServlet?cName=����">����</a></td>
							<td><a href="/shop/ClassifyServlet?cName=����Ƭ">����Ƭ</a></td>
							<td><a href="/shop/ClassifyServlet?cName=���">���</a></td>
						</tr>
						<tr>
							<td><a href="/shop/ClassifyServlet?cName=ѧ����">ѧ����</a></td>
							<td><a href="/shop/ClassifyServlet?cName=���±�">���±�</a></td>
							<td><a href="/shop/ClassifyServlet?cName=��˱�">��˱�</a></td>
							<td><a href="/shop/ClassifyServlet?cName=ͷ��Ʒ">ͷ��Ʒ</a></td>
							<td><a href="/shop/ClassifyServlet?cName=�ֻ���">�ֻ���</a></td>
							<td><a href="/shop/ClassifyServlet?cName=����">����</a></td>
							<td><a href="/shop/ClassifyServlet?cName=����">����</a></td>
							<td><a href="/shop/ClassifyServlet?cName=���ֽ">���ֽ</a></td>
							<td><a href="/shop/ClassifyServlet?cName=����ֽ">����ֽ</a></td>
							<td><a href="/shop/ClassifyServlet?cName=��ֽ��">��ֽ��</a></td>
						</tr>
					</table>
				</div>
			</div>
			
			<div style="width:1130px; height:40px; border-style:solid; border-color:#996633; border-top-style:none;">
				<div style="float:left; width:150px; height:40px; background-color:rgb(247,245,245);">
					<table style="font-size:12px; margin-left:10px; margin-top:5px; color:#996633;">
						<tr>
							<td>Ʒ��</td>
						</tr>
					</table>
				</div>
				<div style="float:right; width:980px; height:40px;" id="font">
					<table style="font-size:12px; margin-left:20px;color:#996633; width:960px; height:40px;">
						<tr>
							<td><a href="#">Disney/��˹��</a></td>
							<td><a href="#">Disney/��˹��</a></td>
							<td><a href="#">Disney/��˹��</a></td>
							<td><a href="#">Disney/��˹��</a></td>
							<td><a href="#">Disney/��˹��</a></td>
							<td><a href="#">Disney/��˹��</a></td>
							<td><a href="#">Disney/��˹��</a></td>
							<td><a href="#">Disney/��˹��</a></td>
						</tr>
					</table>
				</div>
			</div>
			
			<!-- ���ǲ�������-->
			<div style="width:1130px; height:50px;" id="ni">
				<table style="width:1130px; height:28px; color:#996633; font-size:13px; text-align:center;">
					<tr>
						<td style="width:100px;">���ǲ�������</td>
						<td style="width:40px;"></td>
						<td><a href="#">��ѧ�����</a></td>
						<td>|</td>
						<td><a href="#">��ͯ���</a></td>
						<td>|</td>
						<td><a href="#">��˹�����</a></td>
						<td>|</td>
						<td><a href="#">�׶����</a></td>
						<td>|</td>
						<td><a href="#">�ű����</a></td>
						<td>|</td>
						<td><a href="#">���˫��Ů����</a></td>
						<td>|</td>
						<td><a href="#">���˫��Ӣ�װ�</a></td>
						<td>|</td>
						<td><a href="#">���˫��Ůʱ��</a></td>
						<td>|</td>
						<td style="width:200px;"></td>
					</tr>
				</table>
			</div>
			
			<div style="width:1130px; height:30px;">
				<span  style="color:red; font-size:22px; font-weight:bold;">������Ʒ</span>
			</div>
			
			<%
				List<CommodityHistoryPOJO> list2 = (List<CommodityHistoryPOJO>)request.getAttribute("list2"); 
				List<CommodityPOJO> list3 = (List<CommodityPOJO>)request.getAttribute("list3"); 
			%>
			<div style="width:1180px; height:336px;" >
				<!-- һ��ͼƬչ��1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=0;i<5;i++){
				%>
				<!-- һ��ͼƬչ��-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list3.size();j++){ 
						if(list2.get(i).getcNum().equals(list3.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list2.get(i).getcNum() %>"><img src="<%=list3.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>��<%=list3.get(j).getcPrice() %></span>
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
				<span  style="color:red; font-size:22px; font-weight:bold;">����Ҫ����Ʒ</span>
			</div>
			
			<% 
				if(listsize <= 5){
			 %>
			<!-- һ��ͼƬչ��1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=0;i<listsize;i++){
				%>
				<!-- һ��ͼƬչ��-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>��<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">������ <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
			</div>
			<%} %>
			<!--  ����5С��10 -->
			<%
			if(listsize <= 10 && listsize > 5){
			 %>
			<!-- һ��ͼƬչ��1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=0;i<5;i++){
				%>
				<!-- һ��ͼƬչ��-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>��<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">������ <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
				
				<%
					for(int i=5;i<listsize;i++){
				%>
				<!-- һ��ͼƬչ��-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>��<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">������ <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
			</div>
			<%} %>
			
			<!--  ����10С��15 -->
			<% 
				if(listsize <= 15 && listsize > 10){
			 %>
			<!-- һ��ͼƬչ��1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=0;i<5;i++){
				%>
				<!-- һ��ͼƬչ��-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>��<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">������ <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
				
				<!-- һ��ͼƬչ��1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=5;i<10;i++){
				%>
				<!-- һ��ͼƬչ��-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>��<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">������ <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
				
				<!-- һ��ͼƬչ��1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=10;i<listsize;i++){
				%>
				<!-- һ��ͼƬչ��-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>��<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">������ <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
			</div>
			<%} %>
			
			<!--  ����15 -->
			<% 
				if(listsize > 15){
			 %>
			<!-- һ��ͼƬչ��1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=0;i<5;i++){
				%>
				<!-- һ��ͼƬչ��-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>��<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">������ <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
				
				<!-- һ��ͼƬչ��1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=5;i<10;i++){
				%>
				<!-- һ��ͼƬչ��-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>��<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">������ <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
					</div>
				</div>
				<%} %>
				
				<!-- һ��ͼƬչ��1-->
			<div style="width:1180px; height:336px;">
				<%
					for(int i=10;i<15;i++){
				%>
				<!-- һ��ͼƬչ��-->
				<div style="width:216px; height:336px; float:left; border:5px solid #FFFFFF;" onmouseover="javascript:this.style.border='5px solid rgb(234,229,225)';" onmouseout="javascript:this.style.border='5px solid #FFFFFF';">
					<%for(int j=0;j<list.size();j++){ 
						if(list1.get(i).getcNum().equals(list.get(j).getcNum())){
					%>
					<div style="width:216px; height:216px;">
						<a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><img src="<%=list.get(j).getcImg() %>" / width="216" height="216"></a>
					</div>
					<div style="width:216px; height:20px; color:#FF0000; font-weight:bold; font-size:14px;">
						<span>��<%=list.get(j).getcPrice() %></span>
					</div>
					<div id="xx" style="width:216px; height:40px; color:rgb(102,102,102);font-size:12px;">
						<span><a href="/shop/ContentServlet?cNum=<%=list1.get(i).getcNum() %>"><%=list.get(j).getcContent() %></a></span>
					</div>
					<%
						break;
						} 
					}%>
					<div style="width:216px; height:60px;font-size:12px;">
						<span style="color:rgb(167,167,167);">������ <span style="color:rgb(196,145,115);"><%=list1.get(i).gethOutC() %></span></span>
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
				<td>Copyright  2011 ������ѧԺУ���칫�Ұ�Ȩ���� </td>
			</tr>
			<tr>
				<td>��ַ������ʡ�����м�������·600��  |  �������룺361024  |  �绰��0592-6291536 6291537  |  ���棺0592-6291993
</td>
			</tr>
		</table>
	</div>
	
	
	

</body>
</html>
