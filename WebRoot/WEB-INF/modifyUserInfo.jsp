<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户基本信息修改</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css">
	<!-- 首先引入jQuery库-->
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
	<!-- 如果IE版本低于9引入下面的js库使其支持html5和css3 -->
	<script src="<%=basePath%>js/html5shiv-3.7.0.js"></script>
    <script src="<%=basePath%>js/respond-1.4.2.min.js"></script>
  </head>
  
  <body>
   	<form action="modiuinfosubm.action" method="post" name="upduinfo">
   		<table class="table table-hover table-bordered">
   			<thead><tr class="active" ><th colspan="3" class="text-primary">用户资料修改</th></tr></thead>
   			<tbody>
   				<tr class="success">
   					<td>用户学号：<input name="user.uid" type="text" value="${sessionScope.task_user.uid }" disabled/></td>
   					<td>用户姓名：<input name="user.uname" type="text" value="${sessionScope.task_user.uname }"/></td>
   					<td>用户年级：<input name="user.ugrade" type="text" value="${sessionScope.task_user.ugrade }" disabled/></td>
   				</tr>
   				<tr class="info">
   					<td>用户班级：<input name="user.uclass" type="text" value="${sessionScope.task_user.uclass }"/></td>
   					<td>用户年龄：<input name="user.uage" type="text" value="${sessionScope.task_user.uage }"/></td>
   					<td>用户性别： <input name="user.usex" id="usexf" type="radio" value="f"
   						<c:if test="${sessionScope.task_user.usex=='f' }">checked</c:if> />男
   			   			 <input name="user.usex" id="usexm" type="radio" value="m" 
   						<c:if test="${sessionScope.task_user.usex=='m' }">checked</c:if> />女<br>
   					</td>
   				</tr>
   				<tr class="danger">
   					<td>用户手机：<input name="user.utel" type="text" value="${sessionScope.task_user.utel }"/></td>
   					<td>用户 Q Q：<input name="user.uqq" type="text" value="${sessionScope.task_user.uqq }"/></td>
   					<td>用户email：<input name="user.uemail" type="text" value="${sessionScope.task_user.uemail }"/></td>
   				</tr>
   				<tr class="warning">
   					<td>密保问题：<input name="user.upasswdQues" type="text" value="${sessionScope.task_user.upasswdQues }"/></td>
   					<td>密保答案：<input name="user.upasswdAns" type="text" value="${sessionScope.task_user.upasswdAns }"/></td>
   					<td></td>
   				</tr>
   				<tr>
   					<td colspan="3"><input type="submit" value="保存修改" class="btn btn-success"/>
   				</tr>
   			</tbody>
   		</table>
   	</form>
  </body>
</html>
