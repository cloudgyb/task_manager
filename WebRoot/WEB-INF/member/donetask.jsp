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
    
    <title>My JSP 'nodonetask.jsp' starting page</title>
    
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
	<!-- 如果IE版本低于9引入下面的js库使其支持html5和css3 -->
	<script src="<%=basePath%>/js/html5shiv-3.7.0.js"></script>
    <script src="<%=basePath%>/js/respond-1.4.2.min.js"></script>
	<style type="text/css">
     	th,td{ text-align:center; /*设置水平居中*/}
	</style>
	<script type="text/javascript">
		
	</script>
  </head>
  
  <body>
  	<table class="table table-bordered table-striped table-hover">
  		<c:choose>
  		<c:when test="${fun:length(requestScope.userdonetask)==0 }">
  			<button class="btn btn-success">没有以完成的任务</button>
  		</c:when>
  		<c:otherwise>
  			<thead>
  				<tr><th>任务名</th><th>任务上传人</th><th>任务上传日期</th><th>任务截止日期</th><th>任务完成日期</th><th>操作</th></tr>
  			</thead>
	   	 	<c:forEach  items='${requestScope.userdonetask }' var="task">
	    		<tr>
	    			<td>${task.tname }</td>
	    			<td>${task.tuname }</td>
	    			<td>${task.tstart }</td>
	    			<td>${task.tend }</td>
	    			<td>${task.tdone }</td>
	    			<td>
	    				<a href="member/viewdonetask.action?tid=${task.tid}&uid=${sessionScope.task_user.uid}"><button class="btn btn-success">查看</button></a>&nbsp;&nbsp;
	    				<a href="member/modifydonetask.action?tid=${task.tid}&uid=${sessionScope.task_user.uid}"><button class="btn btn-warning">修改</button></a>&nbsp;&nbsp;
	    				<a href="member/deletedonetask.action?tid=${task.tid}&uid=${sessionScope.task_user.uid}"><button class="btn btn-danger">删除</button></a>
	    			</td>
	    		</tr>
	    	</c:forEach>
	    </c:otherwise>
    	</c:choose>
    </table>
    
  </body>
</html>
