/*
 * 登录合法性验证
 * 验证空值
 * 验证不合法值
 */
$(document).ready(function(){
	$("#loginbutt").click(function(){
		var uid = $("#uid").val();
		var upasswd = $("#upasswd").val();
		var ucategory = $("#ucategory").val();
		var err = $("#loginMess");
		var regExp1 = /^\d{10}$/; //验证学号
		var regExp2 = /^[0-9a-zA-Z-+*/_]{6,12}$/;//验证密码
		if(uid==null||uid==""){
			err.html("学号不能为空！");
			$("#uid").focus();
			return ;
		}else if(upasswd==null||upasswd==""){
			err.html("密码不能为空！");
			$("#upasswd").focus();
			return ;
		}else{
			if(!regExp1.test(uid)){
				err.html("学号为10位数字！");
				$("#uid").focus();
				return ;
			}
			if(!regExp2.test(upasswd)){
				err.html("密码不小于6位，不能包含！@#$%/等特殊字符！");
				$("#upasswd").focus();
				return ;
			}
			login(uid,upasswd,ucategory);
		}
	});
	function login(auid,aupasswd,aucategory){
		$.post(
				"login.action",
				{uid:auid,upasswd:aupasswd,ucategory:aucategory},
				function(data,status){
					if(status=='success'){
						console.log(data.mess+data.code+status);
						if(data.code=='-2'||data.code=='-1'){
							$("#loginMess").html(data.mess);
						}
						if(data.code=='0'){
							window.location.href="memberIndex";
						}else if(data.code=='1'){
							window.location.href="adminIndex";
						}else if(data.code=='2'){
							window.location.href="supporterIndex";
						}
						//$("#loginMess").html(data.mess);
					}else{
						$("#loginMess").html("服务器错误！");
					}
					
				}
		);
	}
});
