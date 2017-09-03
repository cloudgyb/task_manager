<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'nodonetask.jsp' starting page</title>
    
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
	<!-- 如果IE版本低于9引入下面的js库使其支持html5和css3 -->
	<script src="<%=basePath%>/js/html5shiv-3.7.0.js"></script>
    <script src="<%=basePath%>/js/respond-1.4.2.min.js"></script>
	
  </head>
  
  <body>
  	完成的任务已删除！<a href="${pageContext.request.contextPath}/member/getdonetask.action?uid=${sessionScope.task_user.uid}" >点击查看以完成任务</a>
  </body>
</html>
