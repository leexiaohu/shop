$("document").ready(function() {
				$("#username").blur(function(){
					$.post("checkUsernameServlet",{username:this.value},function(data,textStatus){
							if("yes"==data){
								$("#u_info").text("�û�������");	
							}else{
								$("#u_info").text("�û���Ӧ����ע�ᣬ�������д");	
							}
						});		
					});
			
});