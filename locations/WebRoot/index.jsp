<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<form action="${pageContext.request.contextPath }/loginCheck"
		method="post">
		<table width="100%" border=1>
			<tr>
				<td>ID:<input name="id" type="text" /></td>
			</tr>
			<tr>
				<td>密码:<input name="password" type="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="登陆" /><a href="${pageContext.request.contextPath }/regist.jsp"><input type="button" value="注册" /></a></td>
			</tr>
		</table>
	</form>

</body>
</html>
