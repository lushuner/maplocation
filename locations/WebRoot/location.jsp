<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
	function upload() {
		var sendData = "{\"longitude\":"+$("#longitude").text()+","+
						"\"latitude\":"+$("#latitude").text()+","+
						"\"direction\":"+$("#direction").text()+","+
						"\"speed\":"+$("#speed").text()+"}";
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath }/uploadLocation",
			contentType: "application/json; charset=utf-8", 
			data : sendData,
		}); 
	}
	
	function download() {

		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath }/downloadLocations",
			contentType: "application/json; charset=utf-8", 
			cache:false,
			success:function(data){
				$("#locTable tbody").empty();
				for(var i = 0; i < data.length; i++){
					var temp = data[i];
					$("#locTable").append("<tr><td>"+temp.longitude+"</td><td>"+temp.latitude+"</td><td>"+temp.direction+"</td><td>"+temp.speed+"</td><td>"+temp.date+"</td></tr>");
				}
			}
		}); 
	}
	function CurInfo(longtitude,latitude,direction,speed){
		$("#longitude").html(longtitude);
		$("#latitude").html(latitude);
		$("#direction").html(direction);
		$("#speed").html(speed);
	}
	</script>

</head>

<body>
	经度：<label id="longitude">106.54</label>
	纬度：<label id="latitude">29.601</label>
	速度：<label id="speed">10.472977</label>
	方向：<label id="direction">80</label>
	<p>
	<button id="uploadBt" type="button" onclick="upload()" class="btn btn-primary">上传</button>
	<button id="downloadBt" type="button" onclick="download()" class="btn btn-success">下载</button>
	<form>
   <table id="locTable" class="table">
      <thead><tr><th>经度</th><th>纬度</th><th>速度</th><th>方向</th><th>时间</th></tr></thead>
      <tbody></tbody>
   </table>

	</form>

	<a href="${pageContext.request.contextPath }/map.jsp">地图显示</a>
</body>
</html>
