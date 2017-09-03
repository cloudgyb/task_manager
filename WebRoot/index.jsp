<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">  
	<title>南工社团任务管理系统-用户登录</title>
	<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>coin/favicon.ico" media="screen" />
	<!-- 引入自定义css -->
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<style type="text/css">
		#main{ position: relative;top: 5px; background: #5199fd; width:100%;height: 600px;}
		#main #container{position:relative;top: 50px;margin: 0 auto;width: 1100px;height: 400px;}
		#zc{position: relative;top: -420px;left: 780px;border-radius: 5px;padding:20px 20px;width: 300px;height: 400px;background: white url();}
		#footer{height:50px;width:100%;font-size: 30px;position: relative;}
		#foot-container{ width: 550px;  margin: 0 auto;position: relative;}
		#foot-container ul li{ float: left; font-size: 15px;display: inline-block;line-height: 50px;color:#6161ec;}
		#foot-container ul li a{text-decoration: none;color:#6161ec;}
		#foot-container ul li a:hover{text-decoration: underline;color: red;}
	</style>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#myCarousel").carousel({interval: "2000"});
		});
	</script>
</head>
<body>
	<div id="header">
		<div id="header-container">
			<div id="logo">
				<img src="./coin/logo2.png" style="width:150px;height: 50px;">
				<span style="color:#142533;font-family: 隶书;display: inline-block; font-size: 35px;height:50px;line-height: 50px;">任务管理系统</span>
			</div>
			<div id="top-navi">
				<ul>
					<li><a href="#">南工首页&nbsp;|&nbsp; </a></li>
					<li><a href="#">常见问题&nbsp;|&nbsp; </a></li>
					<li><a href="#">联系我们&nbsp;|&nbsp; </a></li>
					<li><a href="#">帮助中心 </a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="main">
		<div id="container"><!-- slide  -->
			<div id="myCarousel" class="carousel slide  carousel-fade" style="width:700px;height: 400px">
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>   
				<div class="carousel-inner">
					<div class="item active">
						<img src="img/carousel/g1.png" alt="First slide" style="width:700px;height: 400px;">
					</div>
					<div class="item">
						<img src="img/carousel/g2.png" alt="Second slide" style="width:700px;height: 400px;">
					</div>
					<div class="item">
						<img src="img/carousel/g3.png" alt="Third slide" style="width:700px;height: 400px;">
					</div>
					<div class="item">
						<img src="img/carousel/g4.png" alt="Third slide" style="width:700px;height: 400px;">
					</div>
				</div>
			</div> 
			
			<div id="zc">
				<div class="h3" style="font-family:隶书">用户登录</div>
				<form class="form">
					<div class="form-group">
						<label for="uid" class="sr-only">用户账号</label>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" name="uid" id="uid" placeholder="请输入学号" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" name="uid" id="upasswd" placeholder="请输入密码" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-tag"></span>
							</span>
							<select name="ucategory" id="ucategory" class="form-control">
						    	<option value="0">社团成员</option>
						    	<option value="1">管理员</option>	
						    	<option value="2">维护人员</option>
							</select>
						</div>
					</div>
					<div class="checkbox">
					    <label>
					      <input type="checkbox"> 记住密码
					    </label>
					    <span style="float:right"><a href="#">忘记密码？</a></span>
					</div><br>
					<input type="button" value="登    录" id="loginbutt" class="form-control" style="background:#da2121;color:white">
					<div id="loginMess" style='color:red;font-size:20px'></div>
				</form>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="foot-container">
			<ul>
				<li>&copy;版权所有：南工社团&nbsp;|&nbsp;</li>
				<li><a href="">友情链接</a>&nbsp;|&nbsp;</li>
				<li><a href="http://soft-bysj.nyist.net/" target="_blank">软件学院导航页</a>&nbsp;|&nbsp;</li>
				<li><a href="http://61.163.231.194:8080/Lab2.0/" target="_blank">软件学院实验系统</a></li>
			</ul>
		</div>
	</div>
	<!-- 对用户输入进行登录前验证 -->
	<script type="text/javascript" src="js/logincheck.js" charset="utf-8"></script>
</body>
</html>
