<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="com.shop.POJO.*"%>
<html lang="en">
<head>
	
	<meta http-equiv="content-type" content="text/html; charset=gbk">
	<title>艾欧尼亚商城后台管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">

	<!-- The styles -->
	<link id="bs-css" href="/shop/backstage/css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link href="/shop/backstage/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="/shop/backstage/css/charisma-app.css" rel="stylesheet">
	<link href="/shop/backstage/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='/shop/backstage/css/fullcalendar.css' rel='stylesheet'>
	<link href='/shop/backstage/css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='/shop/backstage/css/chosen.css' rel='stylesheet'>
	<link href='/shop/backstage/css/uniform.default.css' rel='stylesheet'>
	<link href='/shop/backstage/css/colorbox.css' rel='stylesheet'>
	<link href='/shop/backstage/css/jquery.cleditor.css' rel='stylesheet'>
	<link href='/shop/backstage/css/jquery.noty.css' rel='stylesheet'>
	<link href='/shop/backstage/css/noty_theme_default.css' rel='stylesheet'>
	<link href='/shop/backstage/css/elfinder.min.css' rel='stylesheet'>
	<link href='/shop/backstage/css/elfinder.theme.css' rel='stylesheet'>
	<link href='/shop/backstage/css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='/shop/backstage/css/opa-icons.css' rel='stylesheet'>
	<link href='/shop/backstage/css/uploadify.css' rel='stylesheet'>

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="/shop/backstage/favicon.ico">
		
</head>

<body>
		<!-- topbar starts -->
		
	
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="/shop/backstage/index.jsp"> <img alt="Charisma Logo" src="/shop/backstage/img/logo20.png" /> <span>Ionia</span></a>
				
				<!-- theme selector starts -->
				<div class="btn-group pull-right theme-container" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-tint"></i><span class="hidden-phone"> 改变  主题/皮肤</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="themes">
						<li><a data-value="classic" href="#"><i class="icon-blank"></i> 经典</a></li>
						<li><a data-value="cerulean" href="#"><i class="icon-blank"></i>  天蓝</a></li>
						<li><a data-value="cyborg" href="#"><i class="icon-blank"></i> 电子</a></li>
						<li><a data-value="redy" href="#"><i class="icon-blank"></i> 炫红</a></li>
						<li><a data-value="journal" href="#"><i class="icon-blank"></i> 杂志</a></li>
						<li><a data-value="simplex" href="#"><i class="icon-blank"></i> 简约</a></li>
						<li><a data-value="slate" href="#"><i class="icon-blank"></i> 深沉</a></li>
						<li><a data-value="spacelab" href="#"><i class="icon-blank"></i> 纯白</a></li>
						<li><a data-value="united" href="#"><i class="icon-blank"></i> 橘红</a></li>
					</ul>
				</div>
				<!-- theme selector ends -->
				
				<!-- user dropdown starts -->
				<div class="btn-group pull-right" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone"><%=session.getAttribute("username") %></span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="/shop/backstage/login.jsp">退出</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				
				<div class="top-nav nav-collapse">
					<ul class="nav">
						<li><a href="#">访问</a></li>
						<li>
							<form class="navbar-search pull-left">
								<input placeholder="搜索" class="search-query span2" name="query" type="text">
							</form>
						</li>
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- topbar ends -->
		<div class="container-fluid">
		<div class="row-fluid">
				
			<!-- left menu starts -->
			<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet">菜单</li>
						<li><a class="ajax-link" href="/shop/backstage/index.jsp"><i class="icon-home"></i><span class="hidden-tablet"> 主界面</span></a></li>
						<li><a class="ajax-link" href="/shop/QueryCommodityServlet?id=11"><i class="icon-calendar"></i><span class="hidden-tablet"> 商品维护</span></a></li>
						<li><a class="ajax-link" href="/shop/QUServlet?id=21"><i class="icon-align-justify"></i><span class="hidden-tablet"> 用户维护</span></a></li>
						<li class="nav-header hidden-tablet">二级菜单</li>
						<li><a class="ajax-link" href="/shop/QueryCommodityServlet?id=11"><i class="icon-calendar"></i><span class="hidden-tablet"> 商品查看</span></a></li>
						<li><a class="ajax-link" href="/shop/backstage/instance.jsp"><i class="icon-calendar"></i><span class="hidden-tablet"> 商品添加</span></a></li>
						<li><a class="ajax-link" href="/shop/QueryCommodityServlet?id=13"><i class="icon-calendar"></i><span class="hidden-tablet"> 商品修改</span></a></li>
						<li><a class="ajax-link" href="/shop/QueryCommodityServlet?id=14"><i class="icon-calendar"></i><span class="hidden-tablet"> 商品删除</span></a></li>
						<li><a class="ajax-link" href="/shop/QueryCommodityServlet?id=15"><i class="icon-calendar"></i><span class="hidden-tablet"> 商品历史记录</span></a></li>
					</ul>
					
				</div><!--/.well -->
			</div><!--/span-->
			<!-- left menu ends -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
			<!-- content starts -->
			
			<div>
				<ul class="breadcrumb">
					<li>
						<a href="/shop/backstage/index.jsp">首页</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="/shop/QueryCommodityServlet?id=13">商品修改</a>
					</li>
				</ul>
			</div>
			
			
			<!-- 开始 -->
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-calendar"></i> 商品修改</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div style="height:30px; width:1000px;">
						<div style="width:550px;"></div>
						<div style="width:450px; float:right; margin-top: 10px; ">
							<form action="/shop/ModifyCommodityNameServlet" method="post">
								<span style="color:black;font-size:14px;">查询(按商品名字):</span>
								<input type="text" style="width:200px;" name="cName">
							</form>
						</div>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>商品编号</th>
								  <th>商品名称</th>
								  <th>商品单价</th>
								  <th>商品状态</th>
								  <th>操作</th>
							  </tr>
						  </thead>   
						  <tbody>
						  	<%
						  		int  listsize = (Integer)session.getAttribute("listsize");
								List<CommodityPOJO> list = (List<CommodityPOJO>)request.getAttribute("list");
								if(list.size() > 9){
								for(int i=0;i<10;i++){
							%>
							<tr>
								<td><%=list.get(i).getcNum() %></td>
								<td class="center"><%=list.get(i).getcName() %></td>
								<td class="center"><%=list.get(i).getcPrice()%></td>

								<%if(list.get(i).getcStatus() == 1){%>
								<td class="center">
									上市
								</td>
								<%}else{ %>
								<td class="center">
									下架
								</td>
								<% }%>

								<td class="center">
									<a class="btn btn-info" href="/shop/ModifyCommodityIdServlet?cId=<%=list.get(i).getcId() %>">
										<i class="icon-edit icon-white"></i>  
										修改                                           
									</a>
									
								</td>
							</tr>
							<%} 
							}else{
							for(int i=0;i<list.size();i++){
							%>
							<tr>
								<td><%=list.get(i).getcNum() %></td>
								<td class="center"><%=list.get(i).getcName() %></td>
								<td class="center"><%=list.get(i).getcPrice()%></td>
								 
								<%if(list.get(i).getcStatus() == 1){%>
								<td class="center">
									上市
								</td>
								<%}else{ %>
								<td class="center">
									下架
								</td>
								<% }%>
								
								<td class="center">
									<a class="btn btn-info" href="/shop/ModifyCommodityIdServlet?cId=<%=list.get(i).getcId() %>">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									
								</td>
							</tr>
							<%} 
							}%>
						  </tbody>
					  </table>   
					  <div class="pagination pagination-centered">
						  <ul>
							<li><a href="#">共<%=((listsize/10)+1) %>页</a></li>
							<%for(int i=1;i<((listsize/10)+2);i++){ %>
								<li><a href="/shop/ModifyCommodityFServlet?num=<%=i %>">[<%=i %>]</a></li>
							<%} %>
							
						  </ul>
						</div>           
					</div>
				</div><!--/span-->
			
			</div><!--/row-->

			
			
			<!--/row-->
			
			
			
			
			
    
					<!-- content ends -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row-->
				
		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">脳</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a>
				<a href="#" class="btn btn-primary">Save changes</a>
			</div>
		</div>

		<footer>
			<p class="pull-left">&copy; <a href="#" target="_blank">厦门理工学院</a> 2013</p>
			<p class="pull-right">制作人: <a href="#">黄志勇</a></p>
		</footer>
		
	</div><!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	<script src="/shop/backstage/js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="/shop/backstage/js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="/shop/backstage/js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="/shop/backstage/js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="/shop/backstage/js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="/shop/backstage/js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="/shop/backstage/js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="/shop/backstage/js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="/shop/backstage/js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="/shop/backstage/js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="/shop/backstage/js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="/shop/backstage/js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="/shop/backstage/js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="/shop/backstage/js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="/shop/backstage/js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="/shop/backstage/js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='/shop/backstage/js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='/shop/backstage/js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="/shop/backstage/js/excanvas.js"></script>
	<script src="/shop/backstage/js/jquery.flot.min.js"></script>
	<script src="/shop/backstage/js/jquery.flot.pie.min.js"></script>
	<script src="/shop/backstage/js/jquery.flot.stack.js"></script>
	<script src="/shop/backstage/js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="/shop/backstage/js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="/shop/backstage/js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="/shop/backstage/js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="/shop/backstage/js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="/shop/backstage/js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="/shop/backstage/js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="/shop/backstage/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="/shop/backstage/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="/shop/backstage/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="/shop/backstage/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="/shop/backstage/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>
	
		
</body>
</html>
