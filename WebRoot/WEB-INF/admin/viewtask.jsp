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
    <title>任务详情</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  	 <div class="panel panel-danger">
	  	<div class="panel-heading">
	  		<span class="h3" style="font-family:隶书">任务详情</span><a
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
	  	<table class="table table-striped table-hover">
	    	<thead></thead>
		    <tbody>
			    <tr class="success">
			    	<td>
			    		<div class="input-group">
			    			<span class="input-group-addon">任务名称</span>
			    			<input type="text" value="${requestScope.t.tname}" class="form-control"/>
			    		</div>
			    	</td>
			    	<td>
			    		<div class="input-group">
				    		<span class="input-group-addon">开始日期</span>
				    		<input type="date" value="${requestScope.t.tstart}" class="form-control" />
			    		</div>
			    	</td>
			    	<td>
			    		<div class="input-group">
				    		<span class="input-group-addon">截止日期</span>
				    		<input type="date" value="${requestScope.t.tend}" class="form-control" />
			    		</div>
			    	</td>
			    	<td>
			    		<div class="input-group">
				    		<span class="input-group-addon">任务范围</span>
				    		<input type="text" value="${requestScope.t.tscope}" class="form-control"/>
			    		</div>
			    	</td>
			    </tr>
	   		</tbody>
    	</table>
   		<div class="panel-body">
   			 <c:if test="${fun:length(requestScope.t.taffix)!=0 }">
				 <span class="text-primary">任务相关资料: </span><a href="downloadfile.action?downloadFileName=${requestScope.t.taffix}&cate=1"><button class="btn btn-success btn-sm">点击下载</button></a>
   			 </c:if>
    		<hr>
		    <p class="text-primary h4"><code><span class="glyphicon glyphicon-info-sign"></span>&nbsp;任务要求描述</code></p>
		    <textarea rows="6" class="form-control">${requestScope.t.tdesc}</textarea>
		  	<hr>
   		</div>
   		<div class="panel-footer">
   			<a href="${pageContext.request.contextPath}/admin/modifytask.action?tid=${requestScope.t.tid}">
   				<button class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>&nbsp;修改</button>
   			</a>
   		</div>
	</div>
    
  </body>
</html>
