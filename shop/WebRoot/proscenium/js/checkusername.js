$("document").ready(function() {
				$("#username").blur(function(){
					$.post("checkUsernameServlet",{username:this.value},function(data,textStatus){
							if("yes"==data){
								$("#u_info").text("用户名可用");	
							}else{
								$("#u_info").text("用户名应经被注册，请从新填写");	
							}
						});		
					});
			
});