<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <meta charset="utf-8" />
    <title>修改任务</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  	<div class="panel panel-info">
	  <div class="panel-heading">
	  		<span class="h3" style="font-family:隶书">修改任务要求</span><a
				style="float:right;padding-left:20px;"
				href="javascript:window.parent.history.go(-1);"> <span class="badge"><span
					class="glyphicon glyphicon-arrow-right"></span></span>
			</a> <a style="float:right;padding-left:20px;"
				href="javascript:location.reload();"> <span class="badge"><span
					class="glyphicon glyphicon-refresh"></span> </span>
			</a> <a style="float:right;padding-left:20px;"
				href="javascript:window.parent.location.reload();"> <span
				class="badge"><span class="glyphicon glyphicon-home"></span></span>
			</a> <a style="float:right;padding-left:20px;"
				href="javascript:window.parent.history.go(1);"> <span class="badge"><span
					class="glyphicon glyphicon-arrow-left"></span></span>
			</a>
	  </div>
	  <form action="admin/uploadtask.action?task.tid=${requestScope.t.tid}" method="post" enctype="multipart/form-data">
	     <table class="table table-bordered table-striped table-hover">
	    	<thead></thead>
		    <tbody>
			    <tr class="success">
			    	<td>
			    		<div class="input-group">
			    			<span class="input-group-addon">任务名称</span>
			    			<input type="text" name="task.tname" class="form-control" value="${requestScope.t.tname}" />
			    		</div>
			    	</td>
			    	<td>
			    		<div class="input-group">
			    			<span class="input-group-addon">开始日期</span>
			    			<input type="date" name="task.tstart" class="form-control" value="${requestScope.t.tstart}" disabled/>
			    		</div>
			    	</td>
			    	<td>
			    		<div class="input-group">
			    			<span class="input-group-addon">截止日期</span>
			    			<input type="date" name="task.tend" class="form-control" value="${requestScope.t.tend}" />
			    		</div>
			    	</td>
			    	<td>
			    		<div class="input-group">
			    			<span class="input-group-addon">任务范围</span>
			    			<input type="text" name="task.tscope" class="form-control" value="${requestScope.t.tscope}" />
			    		</div>
			    	</td>
			    </tr>
	   		</tbody>
	     </table>
	     <div class="panel-body">
	     	<textarea name="task.tdesc" rows="6" class="form-control">${requestScope.t.tdesc}</textarea>
  			<hr>
  			<span class="text-primary">任务相关资料上传：</span><input type="file" name="file" style="display:inline" /><span style="color:red">*上传任务相关资料或文档的压缩文件，格式rar,zip,7z,大小不超过20M</span><br>
	  		<hr>
	  		<input type="submit" value="确定修改" class="btn btn-success"/>
	 	 </div>
  		</form>
	</div>
  </body>
</html>
