<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/index1.css" rel="stylesheet" type="text/css" />
<title>首页</title>
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
	            alert("加入收藏失败，请使用Ctrl+D进行添加");
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
                                alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
                        }
                        var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
                        prefs.setCharPref('browser.startup.homepage',vrl);
                 }
        }
}
</script>
</head>
<style type="text/css">
		
		/* 这里是设置对联样式滴 */
		#leftDiv,#rightDiv{
  			/* width:250px; 宽度 */
   			height:250px; /* 高度 */
   			background-color:#e5e5e5; /* 背景颜色 */
   			border:1px solid #ddd; /* 边框样式 */
   			position:absolute; /* 绝对定位激活 */
		}
</style>

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
							<td><img src="img/1.PNG" /></td>
							<td><a>我关注的品牌</a></td>
							<td><img src="img/2.png" /></td>
							<td><a href="#">购物车<span style="font-weight:bold;">0</span>件</a></td>
							<td width="65"><span>收藏夹</span></td>
							<td><img src="img/3.png" /></td>
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
			<!--大图区 -->
			<div id="content1">
			<script language =javascript >
				var curIndex=0;//时间间隔(单位毫秒)，每秒钟显示一张，数组共有5张图片放在Photos文件夹下。
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
									Hi，你好！你可能感兴趣的品牌：
								</td>
							</tr>
						</table>
					</div>
					<div id="xpicture">
						<!--图群 -->
						<div style="height:438px; width:930px;">
							<div style="height:438px; width:465px; float:left;">
								<div style="height:438px; width:155; float:left;">
									<div><a href="#" title="清新酸奶自己酿"><img src="img/41.png" /></a></div>
									<div><a href="#" title="席卷水星，清凉一夏"><img src="img/42.png" /></a></div>
								</div>
								<div style="height:438px; width:310; float:right;">
									<div style="height:438px; width:155; float:left;">
										<div><a href="#" title="床垫5折封顶抢购"><img src="img/43.png" /></a></div>
										<div><a href="#" title="释放无限创造力"><img src="img/44.png" /></a></div>
									</div>
									<div style="height:438px; width:155; float:right;">
										<div><a href="#" title="'鞋'梦想一起远行"><img src="img/45.png" /></a></div>
										<div><a href="#" title="乔丹年中促"><img src="img/46.png" /></a></div>
										<div><a href="#" title="雷朋夏日，与潮有染"><img src="img/47.png" /></a></div>
									</div>
								</div>
							</div>
							<div style="height:438px; width:465px; float:right;">
								<div style="height:438px; width:155; float:left;">
									<div><a href="#" title="清新酸奶自己酿"><img src="img/41.png" /></a></div>
									<div><a href="#" title="席卷水星，清凉一夏"><img src="img/42.png" /></a></div>
								</div>
								<div style="height:438px; width:310; float:right;">
									<div style="height:438px; width:155; float:left;">
										<div><a href="#" title="床垫5折封顶抢购"><img src="img/43.png" /></a></div>
										<div><a href="#" title="释放无限创造力"><img src="img/44.png" /></a></div>
									</div>
									<div style="height:438px; width:155; float:right;">
										<div><a href="#" title="'鞋'梦想一起远行"><img src="img/45.png" /></a></div>
										<div><a href="#" title="乔丹年中促"><img src="img/46.png" /></a></div>
										<div><a href="#" title="雷朋夏日，与潮有染"><img src="img/47.png" /></a></div>
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
									<td style="font-size:14px; color:rgb(65,65,65);">美容珠宝</td>
									<td style="width:380px;"></td>
									<td><a href="#">护肤</a></td>
									<td>|</td>
									<td><a href="#">彩妆</a></td>
									<td>|</td>
									<td><a href="#">洗护</a></td>
									<td>|</td>
									<td><a href="#">防晒</a></td>
									<td>|</td>
									<td><a href="#">脱毛膏</a></td>
									<td>|</td>
									<td><a href="#">睫毛增长液</a></td>
									<td>|</td>
									<td><a href="#">珍珠</a></td>
									<td>|</td>
									<td><a href="#">户外专业表</a></td>
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
										<a href="#" title="刀刀狗密封画面随身杯"><img src="img/1/9.jpg" height="321"  width="206"/></a>
									</div>
									<div style="height:321px; width:220px; float:right;">
										<a href="#" title="刀刀狗iphone苹果手机壳"><img src="img/1/10.jpg" height="321" width="220" /></a>
									</div>
								</div>
							</div>
							
							<div style="height:321px; width:400px; float:right;">
								<div style="height:321px; width:206; float:left;">
									<a href="#" title="刀刀狗毛绒骨头型汽车头枕颈椎靠垫"><img src="img/1/11.jpg" height="321"  width="206"/></a>
								</div>
								<div style="height:321px; width:194; float:right;">
									<a href="#" title="刀刀狗毛绒骨头型汽车头枕颈椎靠垫"><img src="img/1/12.jpg"  height="321" width="194"/></a>
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
									<td style="font-size:14px; color:rgb(65,65,65);">美容珠宝</td>
									<td style="width:380px;"></td>
									<td><a href="#">护肤</a></td>
									<td>|</td>
									<td><a href="#">彩妆</a></td>
									<td>|</td>
									<td><a href="#">洗护</a></td>
									<td>|</td>
									<td><a href="#">防晒</a></td>
									<td>|</td>
									<td><a href="#">脱毛膏</a></td>
									<td>|</td>
									<td><a href="#">睫毛增长液</a></td>
									<td>|</td>
									<td><a href="#">珍珠</a></td>
									<td>|</td>
									<td><a href="#">户外专业表</a></td>
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
										<a href="#" title="刀刀狗坐姿毛绒玩具"><img src="img/1/1.jpg" height="321"  width="206"/></a>
									</div>
									<div style="height:321px; width:220px; float:right;">
										<a href="#" title="刀刀狗32开记事本"><img src="img/1/2.jpg" height="321" width="220" /></a>
									</div>
								</div>
							</div>
							
							<div style="height:321px; width:400px; float:right;">
								<div style="height:321px; width:206; float:left;">
									<a href="#" title="刀刀狗摇头玩具"><img src="img/1/3.jpg" height="321"  width="206"/></a>
								</div>
								<div style="height:321px; width:194; float:right;">
									<a href="#" title="刀刀狗毛绒玩具有纸尿布款"><img src="img/1/4.jpg"  height="321" width="194"/></a>
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
									<td style="font-size:14px; color:rgb(65,65,65);">美容珠宝</td>
									<td style="width:380px;"></td>
									<td><a href="#">护肤</a></td>
									<td>|</td>
									<td><a href="#">彩妆</a></td>
									<td>|</td>
									<td><a href="#">洗护</a></td>
									<td>|</td>
									<td><a href="#">防晒</a></td>
									<td>|</td>
									<td><a href="#">脱毛膏</a></td>
									<td>|</td>
									<td><a href="#">睫毛增长液</a></td>
									<td>|</td>
									<td><a href="#">珍珠</a></td>
									<td>|</td>
									<td><a href="#">户外专业表</a></td>
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
										<a href="#" title="刀刀狗32开笔记本"><img src="img/1/5.jpg" height="321"  width="206"/></a>
									</div>
									<div style="height:321px; width:220px; float:right;">
										<a href="#" title="刀刀狗摇头玩具车内饰摆件"><img src="img/1/6.jpg" height="321" width="220" /></a>
									</div>
								</div>
							</div>
							
							<div style="height:321px; width:400px; float:right;">
								<div style="height:321px; width:206; float:left;">
									<a href="#" title="刀刀狗毛绒玩具无纸尿布/有纸尿布款"><img src="img/1/7.jpg" height="321"  width="206"/></a>
								</div>
								<div style="height:321px; width:194; float:right;">
									<a href="#" title="刀刀狗卡通卡贴"><img src="img/1/8.jpg"  height="321" width="194"/></a>
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
				<td>Copyright  2011 厦门理工学院校长办公室版权所有 </td>
			</tr>
			<tr>
				<td>地址：福建省厦门市集美区理工路600号  |  邮政编码：361024  |  电话：0592-6291536 6291537  |  传真：0592-6291993
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
	//下面这段删除后，对联将不跟随屏幕而移动。
	window.setInterval("heartBeat()",1);
	//-->
	</script>
		<div id="leftDiv" style="top:100px;left:95px; border-style:none;" ><a href=http://www.baidu.com target=_blank><img src="img/ad6.PNG" style="width:241px;" border="0"/></a></div>
</body>
</html>
