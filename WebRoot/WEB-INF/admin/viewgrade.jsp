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
<title>查看成绩</title>
<link rel="shortcut icon" type="image/x-icon"
	href="<%=basePath%>coin/favicon.ico" media="screen" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//用下拉菜单的第一个任务初始化页面
		var tid = $("#t_item").val();
		var tname = $("#t_item  option:selected").text();
		if(tid==null||tid==="undefined"){
			$("#grades").html("<h3 style='color:red'>暂时还没有数据！</h3>");
			return;
		}
		getGradesByTid(tid,tname,"admin/getgradeitems?tid=");
		//下拉菜单选择其他任务
		$("#t_item").change(function(){
			var tid = $(this).val();
			var tname = $("#t_item  option:selected").text();
			getGradesByTid(tid,tname,"admin/getgradeitems?tid=");
		});
		var t = 0;
		//成绩排序
		$("#score-sort").click(function(){
			var tid = $("#t_item").val();
			if(tid==null||tid==="undefined"){
				$("#grades").html("<h3 style='color:red'>暂时还没有数据！</h3>");
				return;
			}
			var tname = $("#t_item  option:selected").text();
			var urls= ["admin/getgradeitemsorderbydesc?tid=","admin/getgradeitemsorderbyasc?tid="];
			getGradesByTid(tid,tname,urls[Math.abs(t)]);
			t = ~t;
		});
	});
	var getGradesByTid = function(tid,tname,url){
		$("#grades").html("<tr align='center'>"+
				"<td colspan='7'>"+
				"<img src='<%=basePath %>img/loading1.gif' style='width:200px;height:200px' /></td></tr>");
		
		$.get(url+tid,function(data,status){
			var gradesHtml = '';
			if(status==="success"){
				var t_items = data.gradeItems;
				console.log(t_items);
				if(t_items==="undefined"){
					$("#grades").html("<h3 style='color:red'>服务器内部出错了！</h3>");
					return;
				}
				if(t_items.length==0){
					gradesHtml = "<h3 style='color:red'>还没有成绩呢！</h3>";
				}else{
					for(var i = 0;i<t_items.length;i++){
						gradesHtml += "<tr>"+
								  "<td>"+(i+1)+"</td>"+
								  "<th style='display:none'>"+t_items[i].tid+"</th>"+
								  "<td>"+tname+"</td>"+
								  "<td>"+t_items[i].uname+"</td>"+
								  "<td>"+t_items[i].tuname+"</td>"+
								  "<td>"+t_items[i].checkDate+"</td>"+
								  "<td>"+t_items[i].score+"</td>"+
								  "</tr>";
					}
				}
			}else{
				gradesHtml = "<h3 style='color:red'>服务器内部出错了！</h3>";
			}
			$("#grades").html(gradesHtml);
		});
		
	};
</script>
<style type="text/css">
	#score-sort{ cursor:pointer;}
</style>
</head>

<body>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<span class="h3" style="font-family:隶书">成绩管理</span><a
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
					<div class="input-group">
						<span class="input-group-addon">年级</span>
						<select class="form-control">
							<option>14</option>
							<option>15</option>
							<option>16</option>
							<option>17</option>
						</select>
					</div>
				</div>
				<div class="col-md-3">
					<div class="input-group">
						<span class="input-group-addon">任务选择</span>
						<select class="form-control" id="t_item">
							<optgroup label="我上传的任务">
								<c:forEach items="${requestScope.tasks }" var="task">
									<option value="${task.tid }">${task.tname}</option>
								</c:forEach>
							</optgroup>
							<optgroup label="其他任务">
							</optgroup>
						</select>
					</div>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>#</th><th style="display:none">任务ID</th><th>任务名</th><th>成员姓名</th><th>成绩评定人</th><th>评定日期</th><th id="score-sort">分数 <span class="glyphicon glyphicon-sort-by-order-alt"></span></th>
					</tr>
				</thead>
				<tbody id="grades">
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
