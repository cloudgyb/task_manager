<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <title>上传的任务</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
  	<style type="text/css">
  	</style>
  	<script type="text/javascript">
  		$(document).ready(function(){
  			$('a[data-tid]').click(function(){
  				if(confirm('你确定要删除这条任务吗？')){
  	  				location.href='${pageContext.request.contextPath}/admin/deletetask.action?tid='+$(this).attr("data-tid");
  				}
  			});
  		});
  	</script>
  </head>
  
  <body>
  	<div class="panel panel-info">
	  <div class="panel-heading">
	  		<span class="h3" style="font-family:隶书">我已发布的任务</span><a
				style="float:right;padding-left:20px;"
				href="javascript:window.history.go(-1);"> <span class="badge"><span
					class="glyphicon glyphicon-arrow-right"></span></span>
			</a> <a style="float:right;padding-left:20px;"
				href="javascript:location.reload();"> <span class="badge"><span
					class="glyphicon glyphicon-refresh"></span> </span>
			</a> <a style="float:right;padding-left:20px;"
				href="javascript:window.parent.location.reload();"> <span
				class="badge"><span class="glyphicon glyphicon-home"></span></span>
			</a> <a style="float:right;padding-left:20px;"
				href="javascript:window.history.go(1);"> <span class="badge"><span
					class="glyphicon glyphicon-arrow-left"></span></span>
			</a>
	  </div>
	  <table class="table  table-striped table-hover">
  		<c:choose>
  		<c:when test="${fun:length(requestScope.selfuploadtask)==0 }">
  			<tr>
  				<td colspan='4' class="text-center">
  					<img alt="没有数据" src="<%=basePath%>img/hintimg/notask_1.png" /><br>
  					<a href='${pageContext.request.contextPath}/admin/gouploadspace'>去发布任务</a>
  				</td>
  			</tr>
  		</c:when>
  		<c:otherwise>
  			<thead>
  				<tr><th>任务名</th><th>任务上传日期</th><th>任务截止日期</th><th>操作</th></tr>
  			</thead>
	   	 	<c:forEach  items='${requestScope.selfuploadtask }' var="selftask">
	    		<tr><td>${selftask.tname }</td><td>${selftask.tstart }</td><td>${selftask.tend }</td><td><a href="${pageContext.request.contextPath}/admin/viewtask.action?tid=${selftask.tid}"><button class="btn btn-success btn-sm">查看</button></a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/modifytask.action?tid=${selftask.tid}"><button class="btn btn-warning btn-sm">修改</button></a>&nbsp;&nbsp;<a href="javascript:void(0);" data-tid='${selftask.tid}'><button class="btn btn-danger btn-sm">删除</button></a></td></tr>
	    	</c:forEach>
	    </c:otherwise>
    	</c:choose>
      </table>
	</div>
  </body>
</html>
