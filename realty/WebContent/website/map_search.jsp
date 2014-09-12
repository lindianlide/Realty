<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
 	String membername=(String)session.getAttribute("membername");
	String memrole = (String)session.getAttribute("memrole");
	if(memrole==null){
		memrole="1";
	}
	System.out.print(memrole);
 %>
 <% 
   String path = request.getContextPath(); 
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PhvZF9yCpEwS4FSljdGm7f7A"></script>
 <%@include file="/website/inc/head.inc"%>
 <style type="text/css">
 #search_map {
	position:relative;
	width:1000px;
	height:120px;
	z-index:1;
	font-size:14px;
	background: #eee;
	border: 5px solid #999999;
	}
#search_detail{
	position:relative;
	width:1000px;
	height:500px;
	z-index:2;
	background: #eee;	
	border: 5px solid #999999;  
  }
 </style>
</head>
<body onload="innitmap()">
 <%@include file="/website/inc/header.inc"%>
 <div>
  <div id="search_map">
  <blockquote>
    <p>区域：
	 <a id="00" href="javascript:void(0);" onclick="bb(0,00)">全部</a> &nbsp;
	 <a id="01" href="javascript:void(0);" onclick="bb(0,01)">市南</a> &nbsp;
	 <a id="02" href="javascript:void(0);" onclick="bb(0,02)">市北</a> &nbsp;
	 <a id="03" href="javascript:void(0);" onclick="bb(0,03)">李沧</a> &nbsp;
	 <a id="05" href="javascript:void(0);" onclick="bb(0,05)">城阳</a> &nbsp;
	 <a id="06" href="javascript:void(0);" onclick="bb(0,06)">黄岛</a> &nbsp;
	 <a id="07" href="javascript:void(0);" onclick="bb(0,07)">即墨市</a> &nbsp;
	 <a id="08" href="javascript:void(0);" onclick="bb(0,08)">胶州市</a> &nbsp;
	 <a id="09" href="javascript:void(0);" onclick="bb(0,09)">胶南市</a> &nbsp;
	 <a id="010" href="javascript:void(0);" onclick="bb(0,10)">平度市</a> &nbsp;
	 <a id="011" href="javascript:void(0);" onclick="bb(0,11)">莱西市</a>&nbsp;
	 <a id="012" href="javascript:void(0);" onclick="bb(0,12)">其他</a></p>
	<p>户型：
	 <a id="10" href="javascript:void(0);" onclick="bb(1,0)">全部</a> &nbsp;
	 <a id="11" href="javascript:void(0);" onclick="bb(1,1)">住宅</a>&nbsp;
	 <a id="12" href="javascript:void(0);" onclick="bb(1,2)">商用</a>&nbsp;
	 <a id="13" href="javascript:void(0);" onclick="bb(1,3)">办公</a>&nbsp;
	  <a id="14" href="javascript:void(0);" onclick="bb(1,4)">其他</a></p>
    <p>价格：
	 <a id="20" href="javascript:void(0);" onclick="bb(2,0)">全部</a>&nbsp; 
	 <a id="21" href="javascript:void(0);" onclick="bb(2,1)">6000以下</a>&nbsp;
	 <a id="22" href="javascript:void(0);" onclick="bb(2,2)">6000--8000</a>&nbsp;
	 <a id="23" href="javascript:void(0);" onclick="bb(2,3)">8000--12000</a>&nbsp;
	 <a id="24" href="javascript:void(0);" onclick="bb(2,4)">12000以上</a> 
	 <input name="searchbuilding" id="searchbuilding" class="textfield" type="text" size="20" /> 
	 <input type="button" name="searchs" id="searchs" value="搜索" onclick="bb(3,0)"/>
	</p>	    
  </blockquote>
  </div>
  <div id="search_detail"></div>
 </div>
</body>
<script type="text/javascript">
function innitmap(){
	 var map = new BMap.Map("search_detail");         // 创建Map实例
	 map.centerAndZoom(new BMap.Point(120.355035, 36.233677), 10);
	 map.addControl(new BMap.NavigationControl()); //添加平移缩放控件
	 map.addControl(new BMap.ScaleControl());  //添加放大、缩小控件
	 map.enableScrollWheelZoom();//允许鼠标滑轮操作 
	 
 
	 //市南 
	 var point1 = new BMap.Point(120.419426,36.080281);
	 var myIcon = new BMap.Icon("images/house.png", new BMap.Size(100,50));
	 var marker = new BMap.Marker(point1,{icon:myIcon});  // 创建标注
	 map.addOverlay(marker);	
	 marker.setTitle("市南"); 
	 marker.addEventListener("click", function(e){	
		 map.centerAndZoom(point1, 14);
	 });	
	 
	 var opts = {
			  position : point1,    // 指定文本标注所在的地理位置
			  offset   : new BMap.Size(-30, -15)    //设置文本偏移量
			 
			}
	 var label = new BMap.Label("市南区房产数量：1897", opts);  // 创建文本标注对象
	 label.setStyle({
			 color : "red",
			 fontSize : "12px",
			 height : "20px",
			 lineHeight : "20px",
			 fontFamily:"微软雅黑"
		 });
	 map.addOverlay(label); 
	
	//市北
	 var point2 = new BMap.Point(120.380906,36.093814);
	 var myIcon = new BMap.Icon("images/house.png", new BMap.Size(100,50));
	 var marker = new BMap.Marker(point2,{icon:myIcon});  // 创建标注
	 map.addOverlay(marker);
	 marker.setTitle("市北 "); 
	 marker.addEventListener("click", function(e){	
		 map.centerAndZoom(point2, 14);
	 });
	//崂山 
	 var point3 = new BMap.Point(120.47433,36.115276);
	 var myIcon = new BMap.Icon("images/house.png", new BMap.Size(100,50));
	 var marker = new BMap.Marker(point3,{icon:myIcon});  // 创建标注
	 map.addOverlay(marker);
	 marker.setTitle("崂山 ");
	 marker.addEventListener("click", function(e){	
		 map.centerAndZoom(point3, 14);
	 });
	//李沧 
	 var point4 = new BMap.Point(120.440123,36.151189);
	 var myIcon = new BMap.Icon("images/house.png", new BMap.Size(100,50));
	 var marker = new BMap.Marker(point4,{icon:myIcon});  // 创建标注
	 map.addOverlay(marker);
	 marker.setTitle("李沧 ");
	 marker.addEventListener("click", function(e){	
		 map.centerAndZoom(point4, 14);
	 });
	//城阳 
	 var point5 = new BMap.Point(120.404478,36.313287);
	 var myIcon = new BMap.Icon("images/house.png", new BMap.Size(100,50));
	 var marker = new BMap.Marker(point5,{icon:myIcon});  // 创建标注
	 map.addOverlay(marker);
	 marker.setTitle("城阳 ");
	 marker.addEventListener("click", function(e){
		 map.centerAndZoom(point5, 14);
	 });
	//黄岛 
	 var point6 = new BMap.Point(120.204695,35.965152);
	 var myIcon = new BMap.Icon("images/house.png", new BMap.Size(100,50));
	 var marker = new BMap.Marker(point6,{icon:myIcon});  // 创建标注
	 map.addOverlay(marker);	
	 marker.setTitle("黄岛");
	 marker.addEventListener("click", function(e){	
		 map.centerAndZoom(point6, 13);
	 });	 
}
</script>
</html>