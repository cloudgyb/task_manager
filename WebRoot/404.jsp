<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8"/>
    <title>访问的资源不存在</title>
    <style type="text/css">
    	*{ margin:0;padding:0px;}
    	body{ position:relative; }
    	#notfound{width:430px;height:390px;background:white url(./img/404_1.jpg); margin:0 auto; }
   		#prepage{width:430px;height:390px; margin:0 auto; }
    </style>
  </head>
  
  <body>
    <div id="notfound">
    </div>
    <div id="prepage"><a href="" onclick="window.history.back();">返回上一页</a></div>
  </body>
</html>
