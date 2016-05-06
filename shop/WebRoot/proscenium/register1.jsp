<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/head.css" rel="stylesheet" type="text/css" />
<title>注册页</title>

</head>


<body>
	

	<div id="head">
		<div id="head-in">
			<div id="logo">
				<div style="margin-top:21px;">
					<img src="img/logo.png" />
				</div>
			</div>
			
		</div>
	</div>
	<div style="margin-left:240px;">
		<div style="z-index: -1;position:absolute;">
			<img src="img/login1.jpg" height="808"  width="992" />
		</div>
		<div style="z-index: 1;padding-top: 150px;">
			<table style="margin-left: 20px;">		
					<tr>			
						<td style="font-size:20px; font-weight:bold;">
							<img src="img/name.jpg" height="90"  width="290"/>
						</td>
						<td>
						<input value=" " style="width:350px; height:38px;font-size:22px;" size=65 name="username" id="username"/>
						</td>
						<td id="u_info"></td>
					</tr>
					<tr >
						<td style="font-size:20px; font-weight:bold;">
						   <img src="img/psw.jpg" height="90"  width="290"/>
						</td>
						<td>
						<input  value=""  style="width:350px; height:38px;" type="password"/>
						</td>	
						<td></td>				
					</tr>
					
									
					<tr >
						<td style="font-size:20px; font-weight:bold;">
						<img src="img/checkpsw.jpg" height="90"  width="290"/>
						</td>		
						<td colspan="2"><input  value=""  style="width:350px; height:38px;" type="password"/></td>
					</tr>
				 
									
					<tr>
						<td style="font-size:20px; font-weight:bold;">
							<img src="img/yanzhengma.jpg" height="90"  width="290"/>
						</td>
						<td>
							<input value=" " style="width:170px; height:38px;font-size:22px;"size=65/></td>
						
						<td>
								<img src="checkInfoServlet" title="验证码,看不清楚?请点击刷新验证码" style="cursor:pointer" onclick="this.src='checkInfoServlet?'+Math.random()" style="display:inline;"/>
						</td>
					</tr>
					<tr>
						<td style="padding-left: 250px;"><input type="submit" value="注册"/></td>
					
					</tr>	
				
			</table>	
		</div>
	</div>
														
</body>
</html>