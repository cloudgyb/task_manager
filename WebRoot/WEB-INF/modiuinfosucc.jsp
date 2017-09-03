<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息修改成功！</title>
    <!-- 引入Bootstrap框架 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
	<!-- 引入Bootstrap js -->
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
  </head>
  
  <body>
   		<button class="btn btn-success">信息修改成功！</button><br>
  </body>
</html>
