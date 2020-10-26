<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <title>已完成任务</title>
    
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
	<!-- 如果IE版本低于9引入下面的js库使其支持html5和css3 -->
	<!--[if lt IE 9]>
		<script src="<%=basePath%>/js/html5shiv-3.7.0.js"></script>
	    <script src="<%=basePath%>/js/respond-1.4.2.min.js"></script>
    <![endif]-->
	<style type="text/css">
     	th,td{ text-align:center; /*设置水平居中*/}
	</style>
  </head>
  
  <body>
  	<div class="panel panel-primary">
  		<div class="panel-heading">
			<span class="h3" style="font-family:隶书">已完成任务</span>
			<a style="float:right;padding-left:20px;" href="javascript:window.history.go(-1);"> 
				<span class="badge" data-toggle="tooltip"  data-placement="bottom" title="前进">
					<span
						class="glyphicon glyphicon-arrow-right">
					</span>
				</span>
			</a> 
			<a style="float:right;padding-left:20px;" href="javascript:location.reload();"> 
					<span class="badge" data-toggle="tooltip"  data-placement="bottom" title="刷新本页">
						<span class="glyphicon glyphicon-refresh"></span> 
					</span>
			</a> 
			<a style="float:right;padding-left:20px;" href="javascript:window.parent.location.reload();">
				 <span class="badge" data-toggle="tooltip"  data-placement="bottom" title="回到主页">
				 	<span class="glyphicon glyphicon-home"></span>
				 </span>
			</a> 
			<a style="float:right;padding-left:20px;" href="javascript:window.history.go(1);">
				 <span class="badge" data-toggle="tooltip"  data-placement="bottom" title="后退" >
				 	<span class="glyphicon glyphicon-arrow-left"></span>
				 </span>
			</a>
  		</div>
  		<table class="table table-striped table-hover">
	  		<c:choose>
	  		<c:when test="${fun:length(requestScope.userdonetask)==0 }">
	  			<div class="text-center">
	  				<img src="<%=basePath%>img/hintimg/nodonetask.png"/>
	  				<br><span class="text-primary">哼！一个任务都没做！</span>
	  			</div>
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
		    				<a href="member/viewdonetask.action?tid=${task.tid}&uid=${sessionScope.task_user.uid}" class="btn btn-success btn-sm">查看</a>&nbsp;&nbsp;
		    				<a href="member/modifydonetask.action?tid=${task.tid}&uid=${sessionScope.task_user.uid}" class="btn btn-warning btn-sm">修改</a>&nbsp;&nbsp;
		    				<a href="member/deletedonetask.action?tid=${task.tid}&uid=${sessionScope.task_user.uid}" class="btn btn-danger btn-sm">删除</a>
		    			</td>
		    		</tr>
		    	</c:forEach>
		    </c:otherwise>
	    	</c:choose>
	    </table>
  	</div>
    <script>
  		$(function () { $("[data-toggle='tooltip']").tooltip(); });
  	</script>
  </body>
</html>
