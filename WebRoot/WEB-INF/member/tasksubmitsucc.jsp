<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>任务上传成功</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
	
  </head>
  
  <body>
  	<a href="${pageContext.request.contextPath}/member/getdonetask.action?uid=${sessionScope.task_user.uid}" ><button class="btn btn-success">任务上传成功！点击查看以完成任务</button></a>
  </body>
</html>
