<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />  
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>index</title>
	<style type="text/css">  
	html{height:100%}  
	body{height:95%;margin:0px;padding:0px}  
	#container{height:100%}  
	#btn{
		align:center;
	}
	</style> 
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=fDCqSvqjVjVRFdb8dERLNzfKFM4n3qIN">
	//v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
	//v1.4版本及以前版本的引用方式：src="http://api.map.baidu.com/api?v=1.4&key=您的密钥&callback=initialize"
	</script>
</head>
<body>
	<div id="container"></div> 
	<div id="tab1"></div>
	<a href="${pageContext.request.contextPath }/location.jsp">返回首页</a>
	<!-- <button id="btn1" onclick="getLocations()">按钮1</button> -->
	<script type="text/javascript"> 
	var map = new BMap.Map("container");          // 创建地图实例  
	/* var point = new BMap.Point(116.404, 39.915);  // 创建点坐标  
	map.centerAndZoom(point, 15);  */                 // 初始化地图，设置中心点坐标和地图级别  
	/* window.setTimeout(function(){  
	    map.panTo(new BMap.Point(116.409, 39.918));    
	}, 2000); */
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.NavigationControl());    
	map.addControl(new BMap.ScaleControl());    
	map.addControl(new BMap.OverviewMapControl());    
	map.addControl(new BMap.MapTypeControl());    
	map.setCurrentCity("北京"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用 
	
	/* var marker = new BMap.Marker(point);        // 创建标注    
	map.addOverlay(marker);                     // 将标注添加到地图中
	marker.addEventListener("click", function(){    
	 	alert("您点击了标注");    
	}); */
	
	/* var opts = {    
	 width : 250,     // 信息窗口宽度    
	 height: 100,     // 信息窗口高度    
	 title : "Hello"  // 信息窗口标题   
	}    
	var infoWindow = new BMap.InfoWindow("World", opts);  // 创建信息窗口对象    
	map.openInfoWindow(infoWindow, map.getCenter());      // 打开信息窗口 */
	
	/* var polyline = new BMap.Polyline([    
       new BMap.Point(116.399, 39.910),    
       new BMap.Point(116.405, 39.920)    
     ],    
     {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.5}    
    );    
    map.addOverlay(polyline); */
    
    function CurInfo(Longitude,Latitude,Direction,Speed){
    	CurLongitude = Longitude;
    	CurLatitude = Latitude;
    	CurDirection = Direction;
    	CurSpeed = Speed;
    	alert(CurLongitude +","+CurLatitude+","+CurDirection+","+CurSpeed);
    }
    getLocations();
    function getLocations(){
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath }/showLocations",
			contentType: "application/json; charset=utf-8", 
			cache:false,
			success:function(data){
			    var obj = eval(data);
			    AddMakerOnMap(obj);
			}
		}); 
	};

    function AddMakerOnMap(res){
    	var data_info = new Array();
    	for(var i=0;i<res.LocationInfo.length;i++){
    		var e = new Date();
    		e.setTime(res.LocationInfo[i].date);
    		/* var str=e.Format("yyyy-MM-dd hh:mm:ss"); */
    		var str="yyyy-MM-dd hh:mm:ss";
    		data_info[i]=[res.LocationInfo[i].longitude,res.LocationInfo[i].latitude,str+"<br/>"];
    	}
    	
    	for(var i=0;i<data_info.length;i++){
    		var marker=new BMap.Marker(new BMap.Point(data_info[i][0],data_info[i][1])); //创建标注
    		var tpoint=new BMap.Point(data_info[i][0],data_info[i][1]);
    		map.centerAndZoom(tpoint,15);
    		var content=data_info[i][2];
    		map.addOverlay(marker);   //将标注添加到地图中
    		addClickHandler(content,marker);	
    	}
    }
    
    function addClickHandler(content,marker){
    	marker.addEventListener("click",function(e){
    		openInfo(content,e);
    	});
    }
    
    function openInfo(content,e){
    	var opts={
    		width:250,  //信息窗口宽度
    		height:90,	//信息窗口高度
    		title:"传感信息",	//信息窗口标题
    		enableMessage:true	//设置允许信息窗发送短息
    	};
    	var p=e.target;
    	var point=new BMap.Point(p.getPosition().lng,p.getPosition().lat);
    	var infoWindow=new BMap.InfoWindow(content,opts);	//创建信息窗口对象
    	map.openInfoWindow(infoWindow,point);	//开启信息窗口
    }
    
	</script>  
	
</body>
</html>