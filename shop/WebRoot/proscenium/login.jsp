<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<title></title>
</head>

<body>
	<style>
		.adminbutton{
			text-align:center; 
			height:40px; 
			width:300px; 
			color:#FFFFFF; 
			font-weight:bold; 
			font-size:14px;
			background:rgb(193,2,2);
		}
	</style>
	<div id="head">
		<div id="head-in">
			<div id="logo">
				<div style="margin-top:21px;">
					<a href="/shop/proscenium/index.jsp"><img src="/shop/proscenium/img/daodao.PNG" /></a>
				</div>
			</div>
		</div>
	
	</div>
	<div id="content">
		<div id="content-in">
			<div id="content-left">
				<div id="left-pic">
					<img src="img/loginleft1.jpg" />
				</div>
			</div>
			<div id="content-right">
				<div id="right-pic" style="position:absolute; z-index:1;">
					<img src="img/login.jpg" height="380"  width="381"/>
				</div>
				<div id="right-pic" style="position:absolute; z-index:2;">
					<div style="width:300px; margin:0 auto; margin-top:30px; margin-left:40px;">
					<form action="/shop/QueryUserServlet" method="post">
						<table style="width:300px;">
							<tr height="25">
								<td style="font-size:14px; font-weight:bold;">��¼��:</td>
								<td style="text-align:right;font-size:14px;">�ֻ���̬�����¼</td>
							</tr>
							<tr>
								<td colspan="2"><input value=" �ֻ���/��Ա��/����" style="width:300px; height:28px;" name="username"/></td>
							</tr>
							<tr height="30">
								<td style="font-size:14px; font-weight:bold;">��¼����:</td>
								<td style="text-align:right;font-size:14px;"><a href="#" style="text-decoration:none;">���ǵ�¼���룿</a></td>
								
							</tr>
							<tr>
								<td colspan="2"><input  style="width:300px; height:28px;" type="password" name="password"/></td>
							</tr>
							<tr>
								<td colspan="2" style="height:40px; color:#666666"><input type="checkbox" /> ��ȫ�ؼ���¼</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="��     ¼"  class="adminbutton" onmouseout="this.style.backgroundColor="""onmouseover="this.style.backgroundColor='efefef'"/></td>
							</tr>
							<tr height="30">
								<td style="font-size:14px; font-weight:bold;"></td>
								<td style="text-align:right;font-size:14px;"><a href="#" style="text-decoration:none;">���ע��</a></td>
								
							</tr>
						</table>
					</form>
					</div>
				</div>
			</div>
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