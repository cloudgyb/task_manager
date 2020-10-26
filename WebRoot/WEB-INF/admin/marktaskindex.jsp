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
<title>批改任务索引页</title>
<link rel="shortcut icon" type="image/x-icon"
	href="<%=basePath%>coin/favicon.ico" media="screen" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	//获取为批改任务列表
	function getnotyetmarktask(tid) {
		$.get("<%=basePath%>admin/getnotyetmarktask?tid="+ tid,
			function(data, status) {
				var taskcontiner = $("#tasklist");
				if (data.tlist == null) {//tlist为空后台服务器出错
					console.log(data);
					taskcontiner.html("<tr><td colspan='6'><h3 class='text-danger'>获取数据失败！</h3></td></tr>");
					return;
				}
				//数组长度为0，没有用户完成任务
				if (data.tlist.length == 0) {
					taskcontiner.html("<tr><td colspan='6' class='text-center'><img title='暂无数据' src='<%=basePath%>img/hintimg/nochecktask.png' /></td></tr>");
				} else {
					var tasks = data.tlist;
					var htmlstr = "";
					for (var i = 0; i < tasks.length; i++) {
						console.log(tasks[i]);
						htmlstr = htmlstr
								+"<tr><td hidden='hidden'>"+tasks[i].tid+"</td>"
								+"<td>"+tasks[i].uid+"</td>"
								+"<td>"+tasks[i].tname+"</td>"
								+"<td>"+tasks[i].tstartTime+"</td>"
								+"<td>"+tasks[i].tendTime+"</td>"
								+"<td><a href='admin/getuserdonetask?tid="
									+tasks[i].tid
									+"&uid="+tasks[i].uid+"'><button class='btn btn-success btn-sm'>批改</button></a></td></tr>";
					}
					$("#tasklist").html(htmlstr);
				}
			});
	}
	$(document).ready(function() {
		var curr_taskid = $("#taskname").val();
		if(curr_taskid === null){
			$("#tasklist").html("<tr><td colspan='6'>你还没有发布任务哦，快去发布新的任务吧！"+
					"<a href='admin/gouploadspace'><button class='btn btn-success btn-sm'>好的，我马上去  &nbsp;:）</button></a></td></tr>");
			return;
		}
		//console.log(curr_taskid);
		getnotyetmarktask(curr_taskid);//网页加载完毕，自动获取下拉菜单中第一个未批改任务
		$("#taskname").change(function(){
			getnotyetmarktask($("#taskname").val());
			//alert($(this).val());
		});
		//var obj = {"tlist":[{"tendTime":"2017-09-10T00:00:00","tid":1,"tname":"c++学习","tstartTime":"2017-07-29T00:00:00","uid":1515925611}]}
	});
</script>
<style type="text/css">
</style>
</head>

<body>
	<div class="panel panel-success">
		<div class="panel-heading">
			<span class="h3" style="font-family:隶书">任务完成情况</span><a
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
		<div class="panel-body">
			<div class="row">
				<div class="col-md-2">
					<span class="sr-only">任务完成状态</span> <select class="form-control">
						<option value="0">已完成</option>
						<option value="1">未完成</option>
					</select>
				</div>
				<div class="col-md-5">
					<div class="input-group">
						<span class="input-group-addon">选择任务</span> <select id="taskname"
							class="form-control">
							<c:forEach items="${request.tasks}" var="t">
								<option value="${t.tid}">${t.tname }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th hidden="hidden">tid</th>
					<th>学号</th>
					<th>任务名称</th>
					<th>任务开始日期</th>
					<th>任务截至日期</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id='tasklist'>
				<!-- dom 动态生成 -->
			</tbody>
		</table>
	</div>
</body>
</html>
