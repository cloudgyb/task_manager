<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>批改任务主界面</title>
<link rel="shortcut icon" type="image/x-icon"
	href="<%=basePath%>coin/favicon.ico" media="screen" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#submitscore-btn").click(function(){
			var score = $("#score").val();
			if(score===null||score.trim()===''){
				$("#errMess").html("请输入成绩！");
				$("#score").focus();
			}else if(!(score.trim()>=0&&score.trim()<=100)){
				$("#errMess").html("输入的成绩不合法！成绩应>=0 且 <=100");
				$("#score").focus();
			}else{
				$.post("admin/submitscore",
						{"uid":${request.user.uid},
							"tid":${request.task.tid},
							"score":score},
						function(data,status){
							if(status==="success"){
								if(data.mess === "ok"){
									location.href="admin/gosubmitscoresucc";
								}else{
									$("#errMess").html(data.mess);
								}
								console.log(data);								
							}else{
								$("#errMess").html("服务器异常，请稍后重试！");
							}
				});
			}
		});
	});
</script>
<style type="text/css">
</style>
</head>

<body>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<span class="h3" style="font-family:隶书">任务批改</span><a
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
		<table class="table">
			<thead></thead>
			<tbody>
				<tr><!--任务信息  -->
					<td class="hidden">
						<div class="input-group">
							<span class="input-group-addon">任务ID</span>
							<input id="tid" type="text" value="${request.task.tid }" class="form-control"/>
						</div>
					</td>
					<td>
						<div class="input-group">
							<span class="input-group-addon">任务名称</span>
							<input type="text" value="${request.task.tname }" class="form-control"/>
						</div>
					</td>
					<td>
						<div class="input-group">
							<span class="input-group-addon">任务开始日期</span>
							<input type="text" value="${request.task.tstart }" class="form-control"/>
						</div>
					</td>
					<td>
						<div class="input-group">
							<span class="input-group-addon">任务截至日期</span>
							<input type="text" value="${request.task.tend }" class="form-control"/>
						</div>
					</td>
				</tr>
				<tr> <!-- 用户信息 -->
					<td>
						<div class="input-group">
							<span class="input-group-addon">学号</span>
							<input id="uid" type="text" value="${request.user.uid}" class="form-control"/>
						</div>
					</td>
					<td>
						<div class="input-group">
							<span class="input-group-addon">姓名</span>
							<input type="text" value="${request.user.uname }" class="form-control"/>
						</div>
					</td>
					<td>
						<div class="input-group">
							<span class="input-group-addon">级别</span>
							<input type="text" value="${request.user.ugrade }" class="form-control"/>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="panel-body">
			<div class="row">
				<p class="text-info col-md-6">任务要求</p>
				<c:if test="${not empty request.task.taffix}">
				<p class="col-md-6">任务要求附件：
					<a role="button" class="btn btn-success btn-sm" href="downloadfile.action?downloadFileName=${request.task.taffix}&cate=1">下载</a>
				</p>
				</c:if>
			</div>
			
							
			<textarea rows="5" class="form-control" disabled>${request.task.tdesc }</textarea>
			<hr>
			<p class="text-info">任务完成过程中遇到的问题及解决方法</p>
			<textarea rows="5" class="form-control" disabled>${request.donetaskdetail.ttext1}</textarea>
			<hr>
			<p class="text-info">任务完成过程中的心得与体会</p>
			<textarea rows="5" class="form-control" disabled>${request.donetaskdetail.ttext2}</textarea>
			<hr>
			<c:if test="${not empty request.donetaskdetail.staffix }">
			<span>用户任务附件：<a role="button" class="btn btn-success btn-sm" href="downloadfile.action?downloadFileName=${request.donetaskdetail.staffix}&cate=0">下载</a></span>
			</c:if>
		</div>
		<div class="panel-footer">
			<div class="row">
				<div class="col-md-5">
					<div class="input-group">
						<span class="input-group-addon">输入评定分数</span>
						<input id="score" type="number" max="100" min="0" class="form-control"/>
					</div>
				</div>
				<div class="col-md-2">
					<button id="submitscore-btn" class="btn btn-success">提交成绩</button>
				</div>
				<div class="col-md-5" id="errMess" style="color:red"></div>
			</div>
		</div>
	</div>
</body>
</html>
