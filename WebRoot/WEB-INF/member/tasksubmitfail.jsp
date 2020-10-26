<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>任务上传失败</title>
    
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
	
  </head>
  
  <body>
  	<span style="color:red">任务上传失败！注意上传的文件为格式rar,zip,7z的压缩文件,大小不超过20M</span><a href="${pageContext.request.contextPath}/member/getdonetask.action?uid=${sessionScope.task_user.uid}" >点击查看以完成任务</a>
  </body>
</html>
