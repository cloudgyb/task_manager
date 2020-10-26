<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>已完成任务详情</title>
    <meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css">
	<!--[if lt IE 9]>
		<script src="<%=basePath%>/js/html5shiv-3.7.0.js"></script>
	    <script src="<%=basePath%>/js/respond-1.4.2.min.js"></script>
    <![endif]-->
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
	
  </head>
  
  <body>
  	<div class="panel panel-danger">
  		<div class="panel-heading">
			<span class="h3" style="font-family:隶书">已完成任务详情</span>
			<a style="float:right;padding-left:20px;" href="javascript:window.history.go(-1);"> 
				<span class="badge" data-toggle="tooltip"  data-placement="bottom" title="前进">
					<span class="glyphicon glyphicon-arrow-right">
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
  		<table class="table table-hover table-bordered">
	  		<thead><tr><th colspan="3">任务相关信息</th></tr></thead>
	  		<tbody>
	  			<tr class="success">
	  				<td>
	  					<div class="input-group">
	  						<span class="input-group-addon">用户名</span>
	  						<input type="text" class="form-control" value="${sessionScope.task_user.uname}" disabled />
	  					</div>
	  				</td>
	  				<td>
	  					<div class="input-group">
	  						<span class="input-group-addon">任务名</span>
	  						<input type="text" class="form-control" value="${requestScope.task.tname}" disabled />
	  					</div>
	  				</td>
	  				<td>
	  					<div class="input-group">
	  						<span class="input-group-addon">上传人</span>
	  						<input type="text" class="form-control" value="${requestScope.task.tuid}" disabled/>
	  					</div>
	  				</td>
	  			</tr>
	  			<tr class="danger">
	  				<td>
	  					<div class="input-group">
	  						<span class="input-group-addon">开始日期</span>
		  					<input type="text" class="form-control" value="${requestScope.task.tstart}" disabled/>
	  					</div>
	  				</td>
	  				<td>
	  					<div class="input-group">
	  						<span class="input-group-addon">截止日期</span>
		  					<input type="text" class="form-control" value="${requestScope.task.tend}" disabled/>
	  					</div>
	  				</td>
	  				<td>
	  					<div class="input-group">
	  						<span class="input-group-addon">对应级别</span>
	  					  	<input type="text" class="form-control" value="${requestScope.task.tscope}" disabled/>
	  					</div>
	  				</td>
	  			</tr>
	  		</tbody>
  		</table>
  		<div class="panel-body">
  			<c:if test="${fun:length(requestScope.task.taffix)!=0 }">
		    	<span class="text-primary">任务相关资料:</span>&nbsp;<a href="downloadfile.action?downloadFileName=${requestScope.task.taffix}" class="btn btn-success btn-sm">点击下载</a>
		    </c:if>
		    <h5 class="text-primary">任务要求</h5>
		    <textarea rows="8" class="form-control" disabled>${requestScope.task.tdesc}</textarea>
		    <hr>
			<h5 class="text-primary">任务完成过程中遇到的问题及解决方法</h5>
			<textarea name="ttext" rows="8" class="form-control">${requestScope.utstatus.ttext1 }</textarea>
		    <hr>
		    <h5 class="text-primary">任务完成过程中的心得与体会</h5>
		    <textarea  name="ttext2" rows="8" class="form-control">${requestScope.utstatus.ttext2 }</textarea>
		 </div>
		 <div class="panel-footer">
		 	<c:if test="${fun:length(requestScope.utstatus.staffix)!=0 }">
		    	<span class="text-primary">任务完成相关文档:</span>&nbsp;<a href="downloadfile.action?downloadFileName=${requestScope.utstatus.staffix}" class="btn btn-success btn-sm">点击下载</a>
		    </c:if>
		 </div>
  	 </div>
  	
  	
    
     <script>
  		$(function () { $("[data-toggle='tooltip']").tooltip(); });
  	</script>
  </body>
</html>
