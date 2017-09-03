<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>任务工作空间</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
	<!-- 如果IE版本低于9引入下面的js库使其支持html5和css3 -->
	<script src="<%=basePath%>/js/html5shiv-3.7.0.js"></script>
    <script src="<%=basePath%>/js/respond-1.4.2.min.js"></script>
    <style type="text/css">
    	body{ margin:20px;}
    </style>
  </head>
  
  <body>
  	<h4>任务上传</h4>
  	<table class="table table-hover table-bordered">
  		<thead><tr><th colspan="3">任务相关信息</th></tr></thead>
  		<tbody>
  			<tr class="info">
  				<td>用户名：<input type="text" class="form-control" value="${sessionScope.task_user.uname}" disabled /></td>
  				<td>任务名：<input type="text" class="form-control" value="${requestScope.task.tname}" disabled /></td>
  				<td>上传人：<input type="text" class="form-control" value="${requestScope.task.tuid}" disabled/></td>
  			</tr>
  			<tr class="danger">
  				<td>开始日期：<input type="text" class="form-control" value="${requestScope.task.tstart}" disabled/></td>
  				<td>截止日期：<input type="text" class="form-control" value="${requestScope.task.tend}" disabled/></td>
  				<td>适用级别：<input type="text" class="form-control" value="${requestScope.task.tscope}" disabled/></td>
  			</tr>
  		</tbody>
  	</table>
  	<c:if test="${fun:length(requestScope.task.taffix)!=0 }">
    	<span class="text-primary">任务相关资料:</span><a href="downloadfile.action?downloadFileName=${requestScope.task.taffix}"><button class="btn btn-success">点击下载</button></a>
    </c:if>
    <h5 class="text-primary">任务要求</h5>
    <textarea rows="10" class="form-control" disabled>${requestScope.task.tdesc}</textarea>
    <hr>
    <form action="member/usertasksubmit.action?uid=${sessionScope.task_user.uid}&tid=${requestScope.task.tid}" method="post" enctype="multipart/form-data">
	    <h5 class="text-primary">任务完成过程中遇到的问题及解决方法</h5>
	    <textarea name="ttext1" rows="10" class="form-control"></textarea>
	    <hr>
	    <h5 class="text-primary">任务完成过程中的心得与体会</h5>
	    <textarea  name="ttext2" rows="10" class="form-control"></textarea>
	    <hr>
	    <span class="text-primary">任务完成相关文档</span><input type="file" name="file" style="display:inline" /><span style="color:red">*可以上传任务完成后的程序或文档等相关的材料的压缩文件，格式rar,zip,7z,大小不超过20M</span><br>
	  	<input type="submit" value="提交" class="btn btn-success"/>
  	</form>
  </body>
</html>
