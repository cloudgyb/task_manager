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
    <title>未完成的任务列表</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
	<!-- 如果IE版本低于9引入下面的js库使其支持html5和css3 -->
	<script src="<%=basePath%>/js/html5shiv-3.7.0.js"></script>
    <script src="<%=basePath%>/js/respond-1.4.2.min.js"></script>
	<style type="text/css">
     th,td{ text-align:center; /*设置水平居中*/
      vertical-align:middle;/*设置垂直居中*/}
	</style>
  </head>
  
  <body>
  	<div class="panel panel-danger">
  		<div class="panel-heading">
			<span class="h3" style="font-family:隶书">待完成任务</span>
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
	  		<c:when test="${fun:length(requestScope.nodonetask)==0 }">
	  			<div class="text-center">
	  				<img src="<%=basePath%>img/hintimg/taskalldone.png"/>
	  				<br><span class="text-primary">哎呦，不错哦！任务都做完啦！</span>
	  			</div>
	  		</c:when>
	  		<c:otherwise>
	  			<thead>
	  				<tr>
	  					<th>任务名</th>
	  					<th>任务上传人</th>
	  					<th>任务上传日期</th>
	  					<th>任务截止日期</th>
	  					<th>操作</th>
	  				</tr>
	  			</thead>
		   	 	<c:forEach  items='${requestScope.nodonetask }' var="userundonetask">
		    		<tr>
		    			<td class="text-primary">${userundonetask.tname }</td>
		    			<td>${userundonetask.tuname }</td>
		    			<td>${userundonetask.tstart }</td>
		    			<td>${userundonetask.tend }</td>
		    			<td>
		    				<a href="${pageContext.request.contextPath}/member/godotask.action?tid=${userundonetask.tid}" class="btn btn-success btn-sm">去完成</a>
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
