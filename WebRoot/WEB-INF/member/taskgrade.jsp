<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>任务成绩</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
  </head>
  
  <body>
   		<table class="table table-bordered table-striped table-hover">
  		<c:choose>
  		<c:when test="${fun:length(requestScope.taskgrade)==0 }">
  			<button class="btn btn-success">没有以完成的任务的成绩</button>
  		</c:when>
  		<c:otherwise>
  			<thead>
  				<tr><th>任务名</th><th>成绩评定人</th><th>成绩评定日期</th><th>分数</th></tr>
  			</thead>
	   	 	<c:forEach  items='${requestScope.taskgrade }' var="grade">
	    		<tr><td>${grade.tname }</td><td>${grade.dealUserName }</td><td>${grade.dealDate}</td><td><button class="btn btn-success">${grade.score }</button></tr>
	    	</c:forEach>
	    </c:otherwise>
    	</c:choose>
    </table>
  </body>
</html>
