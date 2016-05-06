<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="com.shop.POJO.*"%>
<%@page import="java.text.*"%>
<html lang="en">
<head>
	
	<meta http-equiv="content-type" content="text/html; charset=gbk">
	<title>��ŷ�����̳Ǻ�̨����ϵͳ</title>
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
						<i class="icon-tint"></i><span class="hidden-phone"> �ı�  ����/Ƥ��</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="themes">
						<li><a data-value="classic" href="#"><i class="icon-blank"></i> ����</a></li>
						<li><a data-value="cerulean" href="#"><i class="icon-blank"></i>  ����</a></li>
						<li><a data-value="cyborg" href="#"><i class="icon-blank"></i> ����</a></li>
						<li><a data-value="redy" href="#"><i class="icon-blank"></i> �ź�</a></li>
						<li><a data-value="journal" href="#"><i class="icon-blank"></i> ��־</a></li>
						<li><a data-value="simplex" href="#"><i class="icon-blank"></i> ��Լ</a></li>
						<li><a data-value="slate" href="#"><i class="icon-blank"></i> ���</a></li>
						<li><a data-value="spacelab" href="#"><i class="icon-blank"></i> ����</a></li>
						<li><a data-value="united" href="#"><i class="icon-blank"></i> �ٺ�</a></li>
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
						<li><a href="/shop/backstage/login.jsp">�˳�</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				
				<div class="top-nav nav-collapse">
					<ul class="nav">
						<li><a href="#">����</a></li>
						<li>
							<form class="navbar-search pull-left">
								<input placeholder="����" class="search-query span2" name="query" type="text">
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
						<li class="nav-header hidden-tablet">�˵�</li>
						<li><a class="ajax-link" href="/shop/backstage/index.jsp"><i class="icon-home"></i><span class="hidden-tablet"> ������</span></a></li>
						<li><a class="ajax-link" href="/shop/QueryCommodityServlet?id=11"><i class="icon-calendar"></i><span class="hidden-tablet"> ��Ʒά��</span></a></li>
						<li><a class="ajax-link" href="/shop/QUServlet?id=21"><i class="icon-align-justify"></i><span class="hidden-tablet"> �û�ά��</span></a></li>
						<li class="nav-header hidden-tablet">�����˵�</li>
						<li><a class="ajax-link" href="/shop/QUServlet?id=21"><i class="icon-align-justify"></i><span class="hidden-tablet"> �û��鿴</span></a></li>
						<li><a class="ajax-link" href="/shop/QUServlet?id=23"><i class="icon-align-justify"></i><span class="hidden-tablet"> �û��޸�</span></a></li>
						<li><a class="ajax-link" href="/shop/QUServlet?id=24"><i class="icon-align-justify"></i><span class="hidden-tablet"> �û�ɾ��</span></a></li>
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
						<a href="/shop/backstage/index.jsp">��ҳ</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="/shop/QUServlet?id=23">�û��޸�</a>
					</li>
				</ul>
			</div>
			
			
			<!-- ��ʼ -->
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-align-justify"></i> �û��޸�</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal" method="post" action="/shop/MUServlet" enctype="multipart/form-data">
						  <fieldset>
							<%
								List<UserClientPOJO> list = (List<UserClientPOJO>)request.getAttribute("list");
							 %>
							 <input type="hidden" value="<%=list.get(0).getuId() %>" name="uId"/>
							 <input type="hidden" value="<%=list.get(0).getuStatus() %>" name="uStatus"/>
							<div class="control-group">
							  <div  style="margin-top:15px"></div>
							  <label class="control-label" for="typeahead">�û����� </label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="typeahead"  name="uName" value="<%=list.get(0).getuName() %>" data-provide="typeahead" data-items="4" data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
							  </div>
							 <div  style="margin-top:15px"></div>
							  <label class="control-label" for="typeahead">����</label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="typeahead"  name="uPsw" value="<%=list.get(0).getuPsw() %>" data-provide="typeahead" data-items="4" data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
							  </div>
							  <div  style="margin-top:15px"></div>
							  <label class="control-label" for="typeahead">�˺�</label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="typeahead"  name="uNum" value="<%=list.get(0).getuNum() %>" data-provide="typeahead" data-items="4" data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
							  </div>
							  <div  style="margin-top:15px"></div>
							  <label class="control-label" for="typeahead">��ʵ����</label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="typeahead"  name="uRName" value="<%=list.get(0).getuRName() %>" data-provide="typeahead" data-items="4" data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
							  </div>
							   <div  style="margin-top:15px"></div>
							  <label class="control-label" for="typeahead">�绰</label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="typeahead"  name="uTel" value="<%=list.get(0).getuTel() %>" data-provide="typeahead" data-items="4" data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
							  </div>
							  <div  style="margin-top:15px"></div>
							  <label class="control-label" for="typeahead">��ַ</label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="typeahead"  name="uAdd" value="<%=list.get(0).getuAdd() %>" data-provide="typeahead" data-items="4" data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
							  </div>
							   <div  style="margin-top:15px"></div>
							  <label class="control-label" for="typeahead">Email</label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="typeahead"  name="uEmail" value="<%=list.get(0).getuEmail() %>" data-provide="typeahead" data-items="4" data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
							  </div>
							  
							  
							 
							 
							  
							</div>
							       
							
							<div class="form-actions">
							  <button type="submit" class="btn btn-primary">�޸�</button>
							  <button type="reset" class="btn">ȡ��</button>
							</div>
						  </fieldset>
						</form>
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
				<button type="button" class="close" data-dismiss="modal">×</button>
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
			<p class="pull-left">&copy; <a href="#" target="_blank">������ѧԺ</a> 2013</p>
			<p class="pull-right">������: <a href="#">��־��</a></p>
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
