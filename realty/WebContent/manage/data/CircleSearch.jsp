<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;}
#l-map{height:100%;width:78%;float:left;border-right:2px solid #bcbcbc;}
#r-result{height:100%;width:20%;float:left;}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PhvZF9yCpEwS4FSljdGm7f7A"></script>
<title>地图自定义距离搜索</title>
</head>
<body>
<div id="l-map"></div>
<div id="r-result"></div>
</body>

 <!-- 地图初始化 -->
<script type="text/javascript">
  var map = new BMap.Map("l-map");
  var point = new BMap.Point(120.33333, 36.06667);
  map.centerAndZoom(point, 14);
  var myIcon = new BMap.Icon("images/manage/02.png", new BMap.Size(30,30));
  var marker = new BMap.Marker(point,{icon:myIcon});  // 创建标注
  map.addOverlay(marker);
  marker.setTitle("新鑫花园 ");
     
</script>
 
 
<!--//从选择点开始划线  -->
<script type="text/javascript">
  var polyline=[];
  var i=1;
  var j=1;
  var dis;
  var point2;
  var point3;
  var circle;
  var pointnum = document.getElementById("r-result");
 
  marker.addEventListener("click" , showpoint);

  function showpoint(){
	  <!--画圆  -->  
	  var WriteCircle = function(e1){
		  if( i>1 ){	
			  if(j>1){
				 // alert(j);
				  map.removeOverlay(circle);
				  map.removeEventListener("click" , WriteCircle);
				  
				  i=1;
				  j=1;
			  }else{
			      point2 = new BMap.Point(e1.point.lng , e1.point.lat);
			      dis = map.getDistance(point,point2);
			      circle = new BMap.Circle(point, dis , {fillColor:"blue", strokeWeight: 1 ,fillOpacity: 0.3, strokeOpacity: 0.3 , });
			      map.addOverlay(circle); 
			  			
			      map.removeOverlay(polyline[i-1]);
			      map.removeEventListener("mousemove",WriteLine);			  			  
			      j++;
			      openinfo();	
			  }		  		  	  		  
		  }
	  };
	  map.addEventListener("click" , WriteCircle);
	  
	  <!--画线  -->  
	  var WriteLine = function(e){	 
		    
		    var writepoint = document.getElementById("r-result");
		    writepoint.innerHTML="("+e.point.lng+","+e.point.lat+")"+"</br>两点之间的距离为："+map.getDistance(point,new BMap.Point(e.point.lng, e.point.lat))+"米";
		  
			polyline[i] = new BMap.Polyline([
			              new BMap.Point(120.33333, 36.06667),
			              new BMap.Point(e.point.lng, e.point.lat)
			              ], {strokeColor:"blue", strokeWeight:3, strokeOpacity:0.5}
			 );                               
			map.addOverlay(polyline[i]);
						
			if(i>=2){
				   map.removeOverlay(polyline[i-1]);
			    }	
			i++;  
	  };
	  map.addEventListener("mousemove",WriteLine);
   }
</script>
 
<!--  连线后弹出选择框 -->
<script type="text/javascript"> 
  function openinfo(){
	  sContent ="<div><center><font color=blue>"+
		  "银行:<img style='float:center ; margin:5px' id='bank'        src='images/manage/house/01_01.png' width='25' height='25' title='银行' onclick='selectvalue(01)' onMouseOver='changeinage(01)' onMouseOut='changeoutinage(01)'/> &nbsp;&nbsp;&nbsp;&nbsp;"+
		  "学校:<img style='float:center ; margin:5px' id='school'      src='images/manage/house/02_01.png' width='25' height='25' title='学校' onclick='selectvalue(02)' onMouseOver='changeinage(02)' onMouseOut='changeoutinage(02)'/><br/>"+
		  "超市:<img style='float:center ; margin:5px' id='supermarket' src='images/manage/house/03_01.png' width='25' height='25' title='超市' onclick='selectvalue(03)' onMouseOver='changeinage(03)' onMouseOut='changeoutinage(03)'/>&nbsp;&nbsp;&nbsp;&nbsp;"+
		  "医院:<img style='float:center ; margin:5px' id='hospital'    src='images/manage/house/04_01.png' width='25' height='25' title='医院' onclick='selectvalue(04)' onMouseOver='changeinage(04)' onMouseOut='changeoutinage(04)'/><br/>"+
		  "酒店:<img style='float:center ; margin:5px' id='hotel'       src='images/manage/house/05_01.png' width='25' height='25' title='酒店' onclick='selectvalue(05)' onMouseOver='changeinage(05)' onMouseOut='changeoutinage(05)'/>&nbsp;&nbsp;&nbsp;&nbsp;"+
		  "公交:<img style='float:center ; margin:5px' id='hotel'       src='images/manage/house/05_01.png' width='25' height='25' title='公交' onclick='selectvalue(06)' /><br/><br/>"+
		  "&nbsp;<input type='text' margin-left:5px > &nbsp;&nbsp;&nbsp;&nbsp; <input type='button' value='确定'>"+
		  "</font></center></div>";
	   infoWindow = new BMap.InfoWindow(sContent);
	   map.openInfoWindow(infoWindow,point2); //开启信息窗口	   
 }
 
 var housename;
 function selectvalue(selvalue){
	  map.closeInfoWindow(infoWindow,point);
	  switch(selvalue){
	  case 01: housename="银行";
	  break;
	  case 02: housename="学校";
	  break;
	  case 03: housename="超市";
	  break;
	  case 04: housename="医院";
	  break;
	  case 05: housename="酒店";
	  break;
	 }	 
	  searchInfo(dis,housename);
 }
</script>

<!--  根据距离周边信息搜索 -->
<script type="text/javascript">
 function searchInfo(distance,selecthouse){
	  alert(distance+selecthouse);
	  var myKeys = selecthouse;
	  var local = new BMap.LocalSearch(point, {
        renderOptions: {
     	     map: map,
           autoViewport: false,
           selectFirstResult: true,
           panel: "r-result"
        },
        pageCapacity: 8
     });
	  local.searchNearby(myKeys,point,distance);
 }
</script>

<!-- 弹出框图片特效  -->
<script type="text/javascript">
 function changeinage(value){
	 switch(value){
	  case 01: document.getElementById("bank").setAttribute("src", "images/manage/house/01.png");
	  break;
	  case 02: document.getElementById("school").setAttribute("src", "images/manage/house/02.png");
	  break;
	  case 03: document.getElementById("supermarket").setAttribute("src", "images/manage/house/03.png");
	  break;
	  case 04: document.getElementById("hospital").setAttribute("src", "images/manage/house/04.png");
	  break;
	  case 05: document.getElementById("hotel").setAttribute("src", "images/manage/house/05.png");
	  break;
	 }	 
 }
 
 function changeoutinage(value){
	 switch(value){
	  case 01: document.getElementById("bank").setAttribute("src", "images/manage/house/01_01.png");
	  break;
	  case 02: document.getElementById("school").setAttribute("src", "images/manage/house/02_01.png");
	  break;
	  case 03: document.getElementById("supermarket").setAttribute("src", "images/manage/house/03_01.png");
	  break;
	  case 04: document.getElementById("hospital").setAttribute("src", "images/manage/house/04_01.png");
	  break;
	  case 05: document.getElementById("hotel").setAttribute("src", "images/manage/house/05_01.png");
	  break;
	 }	
 }
</script>
</html>