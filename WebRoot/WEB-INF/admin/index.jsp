<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <title>南工社团任务管理系统</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>coin/favicon.ico" media="screen" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			//用户信息下拉显示框控制--开始
			$("#userInfo").mouseover(function(){
				$("#messBox").show();
			}).mouseout(function(){$("#messBox").hide(); });
			$("#user_info").mouseout(function(){$("#messBox").hide(); });
			//用户信息下拉显示框控制--结束	
			$("#lndiv li").click(function(){
				$(this).addClass("navitem-active").siblings().removeClass("navitem-active");
			 	if($(this).index()==0)
			 		{ $("iframe").attr('src','${pageContext.request.contextPath}/admin/getselfuploadtask.action');}
			 	else if($(this).index()==1){$("iframe").attr('src','${pageContext.request.contextPath}/admin/gouploadspace.action');}
			 	else if($(this).index()==2){$("iframe").attr('src','${pageContext.request.contextPath}/admin/marktaskindex.action?uid=${sessionScope.task_user.uid}');}
			 	else if($(this).index()==3){$("iframe").attr('src','${pageContext.request.contextPath}/admin/goviewgrade.action');}
			 	else if($(this).index()==4){$("iframe").attr('src','${pageContext.request.contextPath}/modifyuinfo.action');}
			});
			$("#personInfo").click(function(){
				$("iframe").attr('src','${pageContext.request.contextPath}/modifyuinfo.action');
			});
		});
	</script>
	<!-- 自定义css -->
	<style type="text/css">
		*{ margin:0;padding:0; }
		body{ background: #000 url(<%=basePath%>img/bg2.jpg); color:white;font-family:serif;font-weight: bold;}
		/*	//////////////////////////////////////////////////////////////////////////////*/
		#top-navi{	width:100%;height:50px;z-index: 999}
		@media(max-width:800px){ #top-navi{width:900px; }}
		#top-navi li{ list-style: none; float: left;padding-left: 10px;cursor: pointer;}
		.show{display: block;}
		a:hover{ text-decoration: none; }
		#messBox{ width: 20px;height:20px; }
		#user_info{width: 190px;height: 230px;border-radius: 5px;  position: relative;top: -10px;right: 33px;z-index: 999;}
		#user_info #box1{width:190px;height: 100px;background:#4487e4;border-radius:5px 5px 0 0;  }
		#user_info #box2{position: relative; width:190px;height: 130px;background:white;border-radius:0 0 5px 5px; border:1px #4487e4 solid;}
		#user_info #box2 div{ height:30px;padding-left: 20px;}
		#user_info #box2 div a{line-height: 30px;color:rgb(0,0,0);font-size: 10px;}
		#user_info #box2 div:hover{ background:#ccc;cursor: pointer; }
		/*////////////////////////////////////////////////////////////////////////////////*/
		#left-navi{ position: absolute;width: 50%;margin-top: 10%; }
		#left-navi div{}
		#left-navi div li{ padding-left:30px;list-style: none;height: 40px; cursor: pointer;}
		#left-navi div li:hover,.navitem-active{ background:rgba(255,255,255,0.5);/*filter:alpha(opacity=50); -moz-opacity:0.5; -khtml-opacity: 0.5; opacity: 0.5; color:green; z-index: -1*/}
		#left-navi div li span{ color:white;line-height: 40px;z-index: 900 }
		/*///////////////////////////////////////////////////////////////////////////////*/
		#main{ position: absolute;top: 60px; left: 160px; width: 88%;height: 90%;background: white;z-index:1;border-radius: 5px;padding: 10px;}
	</style>
  </head>
  
  <body>
  	<!-- 头部导航———开始 -->
  	<div id="top-navi">
  		<li><a href="<%=basePath%>adminIndex"><img src="<%=basePath%>coin/logo4.png" alt="ng_logo" style="width:150px;height:50px;"/></a></li>
  		<li><span style="line-height: 50px; font-size: 30px; font-family: 隶书">任务管理系统</span></li>
  		<li style="float: right;"><span style="padding-right: 30px;"><a href="${pageContext.request.contextPath}/logout" style="font-size: 15px;color:white;line-height: 50px">退出</a></span></li>
  		<li style="float: right;"><span style="font-size: 15px;line-height: 50px">帮助中心</span></li>
  		<li style="float: right;"><span style="font-size: 15px;line-height: 50px">更换皮肤</span></li>
  		<li style="float: right;"><span style="font-size: 15px;line-height: 50px">${sessionScope.task_user.uname}</span></li>
  		<li id="userInfo" style="float: right;"><img id="user_head" src="<%=basePath%>img/user_head.jpg" alt="user_head" style="width: 40px;height: 40px;border-radius: 50%;cursor: pointer;line-height: 50px;" />
  			<div id="messBox" style="display: none;">
  				<div style="content: ;width:0px;height:0px;border:15px dotted;position: relative;left:8px;top:-9px;border-color: transparent transparent  #4487e4 transparent;"></div>
	  			<div id="user_info">
	  				<div id="box1">
	  					<img src="./img/user_head.jpg" style="width: 40px;height: 40px;border-radius: 50%;cursor: pointer;position: absolute;top: 25px;left: 10px;">
	  					<div style="position: absolute;top: 25px;left: 60px;">
		  					<div id="userName" style="color:white">${sessionScope.task_user.uname}</div>
		  					<div id="userID" style="color:white">${sessionScope.task_user.uid}</div>
	  					</div>
	  				</div>
	  				<div id="box2">
	  					<div id="personInfo"><a href="javascript:void();">个人资料</a></div>
	  					<div><a href="#">帮助中心</a></div>
	  					<div><a href="#">意见反馈</a></div>
	  					<div><a href="${pageContext.request.contextPath}/logout.action">退出</a></div>
	  				</div>
	  			</div>
  			</div>
  		</li>
  	</div>
  	<!-- 头部导航———结束 -->
  	<!-- 侧边功能栏———开始 -->
  	<div id="left-navi">
  		<div id="lndiv">
  			<li><span><span class="glyphicon glyphicon-list"></span>&nbsp;查看上传的任务</span></li>
  			<li><span><span class="glyphicon glyphicon-open"></span>&nbsp;上传任务</span></li>
  			<li><span><span class="glyphicon glyphicon-ok"></span>&nbsp;批改任务</span></li>
  			<li><span><span class="glyphicon glyphicon-th-list"></span>&nbsp;查看任务成绩</span></li>
  			<li><span><span class="glyphicon glyphicon-cog"></span>&nbsp;个人资料设置</span></li>
  		</div>
  	</div>
  	<!-- 侧边功能栏———结束 -->
  	<!-- 内联框架———开始 -->
  	<div id="main">
  		<iframe src="${pageContext.request.contextPath}/admin/getselfuploadtask.action" width="100%" height="100%" frameborder="0"></iframe>
  	</div>
  	<!-- 内联框架———结束 -->
  	<script type="text/javascript">
  	</script>
  </body>	
</html>