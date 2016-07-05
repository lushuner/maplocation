<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	//请求json，输出是json
	function requestJson() {
		var sendData = "{\"id\":"+$("#id").val()+"}";
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath }/requestJson",
			contentType: "application/json; charset=utf-8", 
			data : sendData,
			success : function(backdata) {
				$("#h").html("name="+backdata.name+"  ,password="+backdata.password);
			}
		}); 
	}
	//请求key/value，输出是json
	function responseJson() {
		var sendData = "id="+$("#id").val();
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath }/responseJson",
			data : sendData,
			success : function(backdata) {
				$("#h").html("name="+backdata.name+"  ,password="+backdata.password);
			}	
		});
	}
	

</script>
</head>
<body>
	<h1 id="h">h1</h1>
	${user.id }
	${user }
	${data }
	ID: <input id="id" type="text" name="uid">
	<input type="button" onclick="requestJson()" value="请求json，输出是json" />
	<input type="button" onclick="responseJson()" value="请求key/value，输出是json" />
</body>
</html>