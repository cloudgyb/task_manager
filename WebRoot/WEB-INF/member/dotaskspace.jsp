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
    <meta charset="utf-8" />
    <title>任务工作空间</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
	<!-- [if le IE 9]>
	<script src="<%=basePath%>/js/html5shiv-3.7.0.js"></script>
    <script src="<%=basePath%>/js/respond-1.4.2.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
  	 <div class="panel panel-danger">
  		<div class="panel-heading">
			<span class="h3" style="font-family:隶书">做任务空间</span>
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
  		<table class="table">
	  		<thead><tr><th colspan="3">任务相关信息</th></tr></thead>
	  		<tbody>
	  			<tr>
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
	  			<tr>
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
	  						<span class="input-group-addon">适用级别</span>
	  						<input type="text" class="form-control" value="${requestScope.task.tscope}" disabled/>
	  					</div>
	  				</td>
	  			</tr>
	  		</tbody>
  		</table>
  		<div class="panel-body">
  			<c:if test="${fun:length(requestScope.task.taffix)!=0 }">
    		<span class="text-primary">任务相关资料:&nbsp;</span><a href="downloadfile.action?downloadFileName=${requestScope.task.taffix}" class="btn btn-success btn-sm">点击下载</a>
   			</c:if>
		    <h5 class="text-primary">任务要求</h5>
		    <textarea rows="10" class="form-control" disabled>${requestScope.task.tdesc}</textarea>
		    <hr>
		    <form action="member/usertasksubmit.action?uid=${sessionScope.task_user.uid}&tid=${requestScope.task.tid}" method="post" enctype="multipart/form-data">
			    <h5 class="text-primary">任务完成过程中遇到的问题及解决方法</h5>
			    <textarea id="ttext1" name="ttext1" rows="8" class="form-control"></textarea>
			   	<p class='text-danger'>共可以填写16380字，还可以填写<span id='wordnum'>16380</span>个字</p>
			    <hr>
			    <h5 class="text-primary">任务完成过程中的心得与体会</h5>
			    <textarea id="ttext2" name="ttext2" rows="8" class="form-control"></textarea>
			    <p class='text-danger'>共可以填写16380字，还可以填写<span id='wordnum1'>16380</span>个字</p>
			    <hr>
			    <span class="text-primary">任务完成相关文档</span>&nbsp;<input type="file" id="tfile" name="file" style="display:inline" /><span style="color:red">*可以上传任务完成后的程序或文档等相关的材料的压缩文件，格式rar,zip,7z,大小不超过20M</span><br>
			  	<input type="button" id="submitBtn" value="提交" class="btn btn-success"/>
		  	</form>
  		</div>
  	</div>
  		
  	<script>
  	 	$(function () {
			$("[data-toggle='tooltip']").tooltip(); 
			$("#ttext1").bind("input propertychange",function(){
				var wn = Number(16380-$(this).val().length);
				if(wn<0){
					alert('字数超出限制，多出的将被截断！');
					$(this).val($(this).val().substring(0,16380));
					return;
				}
				$('#wordnum').html(wn);
			});	
			$("#ttext2").bind("input propertychange",function(){
				var wn = Number(16380-$(this).val().length);
				if(wn<0){
					alert('字数超出限制，多出的将被截断！');
					$(this).val($(this).val().substring(0,16380));
					return;
				}
				$('#wordnum1').html(wn);
			});	
			$("#submitBtn").click(function(){
				var ttext1 = $("#ttext1").val();
				var ttext2 = $("#ttext2").val();
				if(ttext1===''){
					alert("请填写任务完成过程中遇到的问题及解决方法");
					$("#ttext1").focus();return;
				}else if(ttext1.length > 16380){
					alert("填写的任务完成过程中遇到的问题及解决方法太长了\n请删除一些！");
					$("#ttext1").focus();return;
				}
				if(ttext2===''){
					alert("请填写任务完成过程中的心得与体会");
					$("#ttext2").focus();return;
				}else if(ttext2.length > 16380){
					alert("填写的任务完成过程中遇到的问题及解决方法太长了\n请删除一些！");
					$("#ttext2").focus();return;
				}
				if($("#tfile").val()===''){
					var t = confirm("你确定不上传文件，\n直接提交？");
					if(!t){
						return;
					}
				}
				$(this).val("提交中...");
				$("form").submit();
			});
  		});
  	</script>
  
  </body>
</html>
