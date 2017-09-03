<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <title>服务器内部错误</title>
    <style type="text/css">
    	*{ margin:0;padding:0px;}
    	body{ position:relative; }
    	#servererr{width:430px;height:390px;background:white url(./img/500.jpg); margin:0 auto; }
   		#prepage{width:430px;height:20px; margin:0 auto; }
    </style>
  </head>
  
  <body>
  	<div id="servererr">
    </div>
    <div id="prepage"><a href="javascript:window.history.back();">返回上一页</a></div>
  </body>
</html>
