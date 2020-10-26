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
    <title>发布任务</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#submit-btn').click(function(){
				var tname = $('#tname').val();
				var tend = $("#tend").val();
				var tscope = $("#tscope").val();
				var tdesc = $("#tdesc").val();
				var tfile = $("#tfile").val();
				if(tname.trim()===''){
					alert("任务名称不能为空！");
					$('#tname').focus(); return;
				}else if(tname.trim().length>60){
					alert('任务名称不能超过60个字！');
					$('#tname').focus(); return;
				}
				
				if(tend.trim()===''){
					alert('请填写任务截至时间！');
					$(this).val('发布');
					$('#tend').focus();return ;
				}else{
					var dateRegex = /^\d{4}-\d{2}-\d{2}$/;
					var rs = dateRegex.test(tend.trim());
					if(!rs){
						alert('日期格式不正确！格式为：yyyy-MM-dd\n例如:2017-09-23');
						$(this).val('发布');
						$('#tend').focus(); return;
					}else{
						if(new Date(tend)<=new Date()){
							alert('任务截止日期不能是已经过去日期！');
							$(this).val('发布');
							$('#tend').focus(); return;
						}
					}
				}
				if(tscope==='-1'){
					alert("请选择任务对应年级！");
					$(this).val('发布');
					$("#tscope").focus();return;
				}
				if(tdesc.trim()===''){
					alert('请填写任务要求！');
					$(this).val('发布');
					$('#tdesc').focus(); return;
				}else if(tdesc.length>16380){
					alert('任务要求太长了！\n请删除一些字符！');
					$(this).val('发布');
					$('#tdesc').focus(); return;
				}
				if(tfile===''){
					var t = confirm('你没有上传任务相关资料\n确定不上传资料,发布任务？');
					if(!t){
						return;
					}
				}
				$(this).val('任务发布中...');
				$('form').submit();
			});
			$("#tdesc").bind("input propertychange",function(){
				var wn = Number(16380-$(this).val().length);
				if(wn<0){
					alert('字数超出限制，多出的将被截断！');
					$(this).val($(this).val().substring(0,16380));
					return;
				}
				$('#wordnum').html(wn);
			});
		});
	</script>
  </head>
  
  <body>
	<div class="panel panel-warning">
		<div class="panel-heading">
			<span class="h3" style="font-family:隶书">发布任务</span><a
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
		<div class="panel-body">
			<form action="admin/uploadtask.action" method="post" enctype="multipart/form-data">
				<table class="table table-striped table-hover">
					<thead>
						<tr><th colspan="3">填写任务要求</th></tr>
					</thead>
				 	<tbody>
						<tr class="success">
							<td>
								<div class="input-group">
									<span class="input-group-addon">任务名称</span>
									<input type="text" id='tname' name="task.tname" value="${requestScope.t.tname}" class="form-control" required="required"/>
								</div>
						 	</td>
							<td>
								<div class="input-group">
									<span class="input-group-addon">截止日期</span>
									<input type="date" id='tend' name="task.tend" value="${requestScope.t.tend}" class="form-control"/>
								</div>
							</td>
							<td>
								<div class="input-group">
									<span class="input-group-addon">任务适用范围</span>
									<select id='tscope' name="task.tscope" class="form-control">
										<option value="-1">--请选择--</option>
										<option value="14">14级</option>
										<option value="15">15级</option>
										<option value="16">16级</option>
										<option value="17">17级</option>
									</select>
									<!--input type="text" name="task.tscope" value="${requestScope.t.tscope}" class="form-control"/ -->
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<hr>
				<p class="text-primary">任务要求描述</p>
				<textarea id='tdesc' name="task.tdesc" rows="8" class="form-control">${requestScope.t.tdesc}</textarea>
				<p class='text-danger'>共可以填写16380字，还可以填写<span id='wordnum'>16380</span>个字</p>
				<hr>
				<span class="text-primary">上传任务相关资料：</span><input type="file" id='tfile' name="file" style="display:inline" /><span style="color:red">*上传任务相关资料或文档的压缩文件，格式rar,zip,7z,大小不超过20M</span><br>
				<hr>
				<input id='submit-btn' type="button" value="发布" class="btn btn-success"/>
			</form>
		</div>
	</div>
  </body>
</html>
