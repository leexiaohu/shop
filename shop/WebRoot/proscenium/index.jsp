<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/index1.css" rel="stylesheet" type="text/css" />
<title>��ҳ</title>
<script type="text/javascript">
	function AddFavorite(sURL, sTitle)
	{
	    try
	    {
	        window.external.addFavorite(sURL, sTitle);
	    }
	    catch (e)
	    {
	        try
	        {
	            window.sidebar.addPanel(sTitle, sURL, "");
	        }
	        catch (e)
	        {
	            alert("�����ղ�ʧ�ܣ���ʹ��Ctrl+D�������");
	        }
	    }
	}
</script>

<script type="text/javascript">
function SetHome(obj,vrl){
        try{
                obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl);
        }
        catch(e){
                if(window.netscape) {
                        try {
                                netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                        }
                        catch (e) {
                                alert("�˲�����������ܾ���\n�����������ַ�����롰about:config�����س�\nȻ�� [signed.applets.codebase_principal_support]��ֵ����Ϊ'true',˫�����ɡ�");
                        }
                        var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
                        prefs.setCharPref('browser.startup.homepage',vrl);
                 }
        }
}
</script>
</head>
<style type="text/css">
		
		/* ���������ö�����ʽ�� */
		#leftDiv,#rightDiv{
  			/* width:250px; ��� */
   			height:250px; /* �߶� */
   			background-color:#e5e5e5; /* ������ɫ */
   			border:1px solid #ddd; /* �߿���ʽ */
   			position:absolute; /* ���Զ�λ���� */
		}
</style>

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
							<td><img src="img/1.PNG" /></td>
							<td><a>�ҹ�ע��Ʒ��</a></td>
							<td><img src="img/2.png" /></td>
							<td><a href="#">���ﳵ<span style="font-weight:bold;">0</span>��</a></td>
							<td width="65"><span>�ղؼ�</span></td>
							<td><img src="img/3.png" /></td>
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
			<!--��ͼ�� -->
			<div id="content1">
			<script language =javascript >
				var curIndex=0;//ʱ����(��λ����)��ÿ������ʾһ�ţ����鹲��5��ͼƬ����Photos�ļ����¡�
				var timeInterval=3500;
				var arr=new Array();
				arr[0]="img/ad1.PNG";
				arr[1]="img/ad2.PNG";
				arr[2]="img/ad3.PNG";
				arr[3]="img/ad4.PNG";
				arr[4]="img/ad5.PNG";
				setInterval(changeImg,timeInterval);
				function changeImg()
				{    
					var obj=document.getElementById("obj");    
					if (curIndex==arr.length-1)     
					{       
						 curIndex=0;    
					}   
					else    
					{        
						curIndex+=1;    
					}    
					obj.src=arr[curIndex];
				}
			</script>
				<div id="picture">
					<div style="width:930px; float:right;"><a href="#"><img  id=obj src="img/ad1.PNG" width="925" height="356" border="0"/></a></div>
				</div>
			</div>
			<div id="content2">
				<div id="content-left"></div>
				<div id="content-right">
					<div id="hi">
						<table style="height:35px; margin-left:5px;">
							<tr>
								<td>
									Hi����ã�����ܸ���Ȥ��Ʒ�ƣ�
								</td>
							</tr>
						</table>
					</div>
					<div id="xpicture">
						<!--ͼȺ -->
						<div style="height:438px; width:930px;">
							<div style="height:438px; width:465px; float:left;">
								<div style="height:438px; width:155; float:left;">
									<div><a href="#" title="���������Լ���"><img src="img/41.png" /></a></div>
									<div><a href="#" title="ϯ��ˮ�ǣ�����һ��"><img src="img/42.png" /></a></div>
								</div>
								<div style="height:438px; width:310; float:right;">
									<div style="height:438px; width:155; float:left;">
										<div><a href="#" title="����5�۷ⶥ����"><img src="img/43.png" /></a></div>
										<div><a href="#" title="�ͷ����޴�����"><img src="img/44.png" /></a></div>
									</div>
									<div style="height:438px; width:155; float:right;">
										<div><a href="#" title="'Ь'����һ��Զ��"><img src="img/45.png" /></a></div>
										<div><a href="#" title="�ǵ����д�"><img src="img/46.png" /></a></div>
										<div><a href="#" title="�������գ��볱��Ⱦ"><img src="img/47.png" /></a></div>
									</div>
								</div>
							</div>
							<div style="height:438px; width:465px; float:right;">
								<div style="height:438px; width:155; float:left;">
									<div><a href="#" title="���������Լ���"><img src="img/41.png" /></a></div>
									<div><a href="#" title="ϯ��ˮ�ǣ�����һ��"><img src="img/42.png" /></a></div>
								</div>
								<div style="height:438px; width:310; float:right;">
									<div style="height:438px; width:155; float:left;">
										<div><a href="#" title="����5�۷ⶥ����"><img src="img/43.png" /></a></div>
										<div><a href="#" title="�ͷ����޴�����"><img src="img/44.png" /></a></div>
									</div>
									<div style="height:438px; width:155; float:right;">
										<div><a href="#" title="'Ь'����һ��Զ��"><img src="img/45.png" /></a></div>
										<div><a href="#" title="�ǵ����д�"><img src="img/46.png" /></a></div>
										<div><a href="#" title="�������գ��볱��Ⱦ"><img src="img/47.png" /></a></div>
									</div>
								</div>
							</div>

						</div>
						<div style="height:12px; width:930px;"></div>
						<div style="width:930px; height:90px;">
							<a href="#"><img src="img/31.png" /></a>
						</div>
					</div>
					<!-- 1F-->
					<div style=" width:930px;">
						<div style="height:10px; width:930px;">
						</div>
						<div style="height:40px; width:930px;" id="file">
							<table style="height:40px; width:930px; margin-left:5px; font-size:10px; color:rgb(146,146,146); text-align:center;">
								<tr>
									<td style="width:25px; font-size:16px; color:rgb(65,65,65);">1F</td>
									<td style="font-size:14px; color:rgb(65,65,65);">�����鱦</td>
									<td style="width:380px;"></td>
									<td><a href="#">����</a></td>
									<td>|</td>
									<td><a href="#">��ױ</a></td>
									<td>|</td>
									<td><a href="#">ϴ��</a></td>
									<td>|</td>
									<td><a href="#">��ɹ</a></td>
									<td>|</td>
									<td><a href="#">��ë��</a></td>
									<td>|</td>
									<td><a href="#">��ë����Һ</a></td>
									<td>|</td>
									<td><a href="#">����</a></td>
									<td>|</td>
									<td><a href="#">����רҵ��</a></td>
								</tr>
							</table>
						</div>
						<div style="height:2px; width:930px; background-color:#000000;"></div>
						<div style="height:321px; width:930px;">
							<div style="height:321px; width:530px; float:left;">
								<div style="height:321px; width:110px; float:left;">
									<img src="img/50.png" />
								</div>
								<div style="height:321px; width:420px; float:right;">
									<div style="height:321px; width:200px; float:left;">
										<a href="#" title="�������ܷ⻭������"><img src="img/1/9.jpg" height="321"  width="206"/></a>
									</div>
									<div style="height:321px; width:220px; float:right;">
										<a href="#" title="������iphoneƻ���ֻ���"><img src="img/1/10.jpg" height="321" width="220" /></a>
									</div>
								</div>
							</div>
							
							<div style="height:321px; width:400px; float:right;">
								<div style="height:321px; width:206; float:left;">
									<a href="#" title="������ë�޹�ͷ������ͷ��׵����"><img src="img/1/11.jpg" height="321"  width="206"/></a>
								</div>
								<div style="height:321px; width:194; float:right;">
									<a href="#" title="������ë�޹�ͷ������ͷ��׵����"><img src="img/1/12.jpg"  height="321" width="194"/></a>
								</div>
							</div>
						</div>
					</div>
					
					<div style=" width:930px;">
						<div style="height:10px; width:930px;">
						</div>
						<div style="height:40px; width:930px;" id="file">
							<table style="height:40px; width:930px; margin-left:5px; font-size:10px; color:rgb(146,146,146); text-align:center;">
								<tr>
									<td style="width:25px; font-size:16px; color:rgb(65,65,65);">2F</td>
									<td style="font-size:14px; color:rgb(65,65,65);">�����鱦</td>
									<td style="width:380px;"></td>
									<td><a href="#">����</a></td>
									<td>|</td>
									<td><a href="#">��ױ</a></td>
									<td>|</td>
									<td><a href="#">ϴ��</a></td>
									<td>|</td>
									<td><a href="#">��ɹ</a></td>
									<td>|</td>
									<td><a href="#">��ë��</a></td>
									<td>|</td>
									<td><a href="#">��ë����Һ</a></td>
									<td>|</td>
									<td><a href="#">����</a></td>
									<td>|</td>
									<td><a href="#">����רҵ��</a></td>
								</tr>
							</table>
						</div>
						<div style="height:2px; width:930px; background-color:#000000;"></div>
						<div style="height:321px; width:930px;">
							<div style="height:321px; width:530px; float:left;">
								<div style="height:321px; width:110px; float:left;">
									<img src="img/50.png" />
								</div>
								<div style="height:321px; width:420px; float:right;">
									<div style="height:321px; width:200px; float:left;">
										<a href="#" title="����������ë�����"><img src="img/1/1.jpg" height="321"  width="206"/></a>
									</div>
									<div style="height:321px; width:220px; float:right;">
										<a href="#" title="������32�����±�"><img src="img/1/2.jpg" height="321" width="220" /></a>
									</div>
								</div>
							</div>
							
							<div style="height:321px; width:400px; float:right;">
								<div style="height:321px; width:206; float:left;">
									<a href="#" title="������ҡͷ���"><img src="img/1/3.jpg" height="321"  width="206"/></a>
								</div>
								<div style="height:321px; width:194; float:right;">
									<a href="#" title="������ë�������ֽ�򲼿�"><img src="img/1/4.jpg"  height="321" width="194"/></a>
								</div>
							</div>
						</div>
					</div>
					
					
					<div style=" width:930px;">
						<div style="height:10px; width:930px;">
						</div>
						<div style="height:40px; width:930px;" id="file">
							<table style="height:40px; width:930px; margin-left:5px; font-size:10px; color:rgb(146,146,146); text-align:center;">
								<tr>
									<td style="width:25px; font-size:16px; color:rgb(65,65,65);">3F</td>
									<td style="font-size:14px; color:rgb(65,65,65);">�����鱦</td>
									<td style="width:380px;"></td>
									<td><a href="#">����</a></td>
									<td>|</td>
									<td><a href="#">��ױ</a></td>
									<td>|</td>
									<td><a href="#">ϴ��</a></td>
									<td>|</td>
									<td><a href="#">��ɹ</a></td>
									<td>|</td>
									<td><a href="#">��ë��</a></td>
									<td>|</td>
									<td><a href="#">��ë����Һ</a></td>
									<td>|</td>
									<td><a href="#">����</a></td>
									<td>|</td>
									<td><a href="#">����רҵ��</a></td>
								</tr>
							</table>
						</div>
						<div style="height:2px; width:930px; background-color:#000000;"></div>
						<div style="height:321px; width:930px;">
							<div style="height:321px; width:530px; float:left;">
								<div style="height:321px; width:110px; float:left;">
									<img src="img/50.png" />
								</div>
								<div style="height:321px; width:420px; float:right;">
									<div style="height:321px; width:200px; float:left;">
										<a href="#" title="������32���ʼǱ�"><img src="img/1/5.jpg" height="321"  width="206"/></a>
									</div>
									<div style="height:321px; width:220px; float:right;">
										<a href="#" title="������ҡͷ��߳����ΰڼ�"><img src="img/1/6.jpg" height="321" width="220" /></a>
									</div>
								</div>
							</div>
							
							<div style="height:321px; width:400px; float:right;">
								<div style="height:321px; width:206; float:left;">
									<a href="#" title="������ë�������ֽ��/��ֽ�򲼿�"><img src="img/1/7.jpg" height="321"  width="206"/></a>
								</div>
								<div style="height:321px; width:194; float:right;">
									<a href="#" title="��������ͨ����"><img src="img/1/8.jpg"  height="321" width="194"/></a>
								</div>
							</div>
						</div>
					</div>
						
					<div style="height:12px; width:930px;">
					</div>
					<div style="width:930px; height:90px;">
						<a href="#"><img src="img/32.png" /></a>
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
	<!--
	<div id="ad" style="position:absolute;border:1px solid #000;right:0; height:34; width:195px;"><a href="#" target="_blank"><img src="img/sign1.PNG" /></a></div>
	<script type="text/javascript">
		function rightBottomAd(){
			var abc = document.getElementById("ad");
			abc.style.top = document.documentElement.scrollTop+document.documentElement.clientHeight-30+"px"; 
			setTimeout(function(){rightBottomAd();},50);
		}
		rightBottomAd();
	</script>
	  -->
	
	
	
	<script type="text/javascript"> 
	lastScrollY = 0;
	function heartBeat(){ 
	var diffY;
	if (document.documentElement && document.documentElement.scrollTop)
 	diffY = document.documentElement.scrollTop;
	else if (document.body)
 	diffY = document.body.scrollTop
	else
    {/*Netscape stuff*/}
 
	//alert(diffY);
	percent=.1*(diffY-lastScrollY); 
	if(percent>0)percent=Math.ceil(percent); 
	else percent=Math.floor(percent); 
	//alert(document.getElementById("leftDiv").style.top);
	var t=document.getElementById("leftDiv").style.top;
	var w=t.substring(0,(t.length-2));
	//alert(w);
	if(w >100){
	document.getElementById("leftDiv").style.top = parseInt(document.getElementById("leftDiv").style.top)+(percent-10)+"px";
	lastScrollY=lastScrollY+percent-10; 
	}
	else{
	document.getElementById("leftDiv").style.top = parseInt(document.getElementById("leftDiv").style.top)+(percent)+"px";
	lastScrollY=lastScrollY+percent; 
	}
	//alert(lastScrollY);
	}
	//�������ɾ���󣬶�������������Ļ���ƶ���
	window.setInterval("heartBeat()",1);
	//-->
	</script>
		<div id="leftDiv" style="top:100px;left:95px; border-style:none;" ><a href=http://www.baidu.com target=_blank><img src="img/ad6.PNG" style="width:241px;" border="0"/></a></div>
</body>
</html>
