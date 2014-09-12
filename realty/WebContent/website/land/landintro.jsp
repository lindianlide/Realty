<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.*" %>
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
<%
int landId =Integer.parseInt(request.getParameter("landId"));
LandAction land=new LandAction();
RegionAction region=new RegionAction();
List<Land> landList=land.searchLand(landId,memrole);
String sellway= land.sellwaySearch(landList.get(0).getLandSellway().getSellwayId());
String landusage =land.landusageSearch(landList.get(0).getLandUsage().getUsageId());
String landposs= land.landpossSearch(landList.get(0).getLandPoss().getLandpossId());
List landPhotoList=land.landPhoto(landId,"land_photo");
List landLocationList =land.landPhoto(landId, "land_location");
String regionstring=region.regionSearch(landList.get(0).getRegionId());
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="pragma" content="no-cache" />
 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PhvZF9yCpEwS4FSljdGm7f7A"></script>
 <script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp&key=d84d6d83e0e51e481e50454ccbe8986b"></script>
</head>
 <%@include file="/website/inc/head.inc"%>
 <link rel="stylesheet" href="/realty/css/theme-responsive.css">
    <link href="css/navigationpic.css" rel="stylesheet" type="text/css" />
 <link rel="stylesheet" href="/realty/css/buildinfo.css"> 
 
 <link href="css/lightbox.css" rel="stylesheet" type="text/css" />
 <link href="css/album.css" rel="stylesheet" type="text/css" />
 <script src="js/album.js" type="text/javascript"></script>
 <script src="js/lightbox.js" type="text/javascript"></script>
 
  
 <style type="text/css">
 .image_ul{ padding:0; margin:0; list-style:none}
 .img-scroll { /* position:relative; */ margin:20px auto; width:920px;}
 .img-scroll .prev { position:absolute; display:blue; width:50px; height:300px; background-color:#CCFFCC;
                        left:0;cursor:pointer;top:0; text-align:center; line-height:300px}
 .img-scroll .next { position:absolute; display:blue; width:50px; height:300px; background-color:#CCFFCC;
                     top:0; text-align:center; line-height:300px ; margin-left:10px;right:0;cursor:pointer;}

 .img-list { position:relative; width:800px; height:300px; margin-left:60px; overflow:hidden}
 .img-list1 { position:relative; width:800px; height:300px; margin-left:60px; overflow:hidden}
 .img-list2 { position:relative; width:800px; height:300px; margin-left:60px; overflow:hidden}
 .img-list3 { position:relative; width:800px; height:300px; margin-left:60px; overflow:hidden}
 .img-list ul { width:9999px;}
 .img-list li { float:left; display:inline; width:250px; margin-right:10px; height:250px; background-color:#BDBDDF; text-align:center; line-height:280px;}
 .img-list1 ul { width:9999px;}
 .img-list1 li { float:left; display:inline; width:250px; margin-right:10px; height:250px; background-color:#BDBDDF; text-align:center; line-height:280px;}
 .img-list2 ul { width:9999px;}
 .img-list2 li { float:left; display:inline; width:250px; margin-right:10px; height:250px; background-color:#BDBDDF; text-align:center; line-height:280px;}
 .img-list3 ul { width:9999px;}
 .img-list3 li { float:left; display:inline; width:250px; margin-right:10px; height:250px; background-color:#BDBDDF; text-align:center; line-height:280px;}
 
 #photo li { position:relative;width:920px;height: 20px;}
 #photoli ul li {float:left; width: 60px; /* 宽度根据元素内容调整 */}
</style>
<body onload="buidmap()">
<%@include file="/website/inc/header.inc"%>
<div id="background">
<div id="headinfo">
	<div id="titleinfo1">地号：<%=landList.get(0).getLandId()%></div><!-- 缺少字段 -->
	<div id="titleinfo2">土地所属行政区：<%=regionstring %></div>
	<div id="titleinfo3">商圈/学区：</div><!-- 缺少字段 -->
</div>
<div id="basicinfo">
<div id="imageinfo">
  <div id="album">
  <%if(!landPhotoList.isEmpty()) {%>
    <div id="pic"> <a href="picupload/land/<%=landPhotoList.get(0)%>" rel="lightbox" id="ShowLightBox"><img src="picupload/land/<%=landPhotoList.get(0)%>" alt="点击查看完全尺寸" id="placeholder" /></a> </div>
    <div id="thumbs">
      <ul>
      <%for(int i=0;i<landPhotoList.size();i++){ %>
        <li><a onclick="return showPic(this);" href="picupload/land/<%=landPhotoList.get(i)%>" title=""><img src="picupload/land/<%=landPhotoList.get(i) %>" alt=" " /></a></li><%} %>
        
      </ul>
    </div><%}else{ %>
    <div id="pic">无图片 </div>
   <%} %>
  </div>
  </div>
<div id="centerinfo1">地址： <%=landList.get(0).getAddress()%></div>
<div id="centerinfo2">土地用途：<%=landusage%></div>
<div id="centerinfo3">土地面积：<%=landList.get(0).getLandArea()%></div>
<div id="centerinfo4">
  <p>楼面地价：<%=landList.get(0).getInitialPrice()%></p>
  <p>土地总价：<%=landList.get(0).getDealTotle()%></p>
  <p>土地使用性质：<%=landposs%> </p>   
   <p>出让方式：<%=sellway%>  </p>
  <p>土地级别： <%=landList.get(0).getLandLevel()%> </p>
  <p>开发楼盘：<%=landList.get(0).getLandExploit()%></p>
</div>
</div>


<div id="secondinfo">
<p>基本信息</p>
<table style="position:absolute; left:25px; top:30px;width:875px;border:1px solid #F0F0F0">
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;" >
		<td width="100px">出让方式</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=sellway %></td>
		<td width="100px">拍卖时间</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getAuctionTime() %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px" >区域</td>
		<td width="337.5px"bgcolor="#FFFFFF"><%=regionstring %></td>
		<td width="100px" >土地位置</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getAddress() %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">土地用途</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landusage %></td>
		<td width="100px">土地使用权性质</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landposs %></td>
	</tr>
	<tr >
		<td width="100px">土地级别</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getLandLevel() %></td>
		<td width="100px">土地开发程度</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getLandExploit() %></td>
	</tr>
</table>
</div>
<div id="typephoto">
<div class="tabList" id="tabList1">
<ul class="tabBox">
    <li class="tabOption tabOn"><h4><a href="javascript:void(0);" title="单击，跳转到所有[日志]列表"><span>土地图</span></a></h4>
      <div class="tabContentBox">
      <div class="img-scroll">
			    <span class="prev">上一张</span>  
			    <div class="img-list">
			        <ul class="image_ul">
			            <%if(!landPhotoList.isEmpty()) {
			   				 for(int i =0;i<landPhotoList.size();i++){ %>
			                  <li class="image_ul image_li"><a rel="example_group" href="picupload/land/<%=landPhotoList.get(i) %>" title="Lorem ipsum dolor sit amet"><img style="width:250px;height:250px;" src="picupload/land/<%=landPhotoList.get(i) %>"></a></li><%} %>   
					    	<%}else{ %>
					    <li class="image_ul image_li">无图片 </li>
					   <%} %>
			        </ul>
			    </div>
				<span class="next">下一张</span>
			</div>
      </div> 
    </li>
    <li class="tabOption"><h4><a href="javascript:void(0);" title="单击，跳转到所有[相册]列表"><span>位置图</span></a></h4>
      <div class="tabContentBox">
      <div class="img-scroll">
			    <span class="prev">上一张</span>  
			    <div class="img-list1">
			        <ul class="image_ul">
			            <%if(!landLocationList.isEmpty()) {
			   				 for(int i =0;i<landLocationList.size();i++){ %>
			            <li class="image_ul image_li"><img style="width:250px;height:250px;" src="picupload/land/<%=landLocationList.get(i) %>"></li><%} %>
					     
					    	<%}else{ %>
					    <li class="image_ul image_li">无图片 </li>
					   <%} %>
			        </ul>
			    </div>
				<span class="next">下一张</span>
			</div>
      </div>
    </li>
  </ul>
  </div>
<script type="text/javascript">
 function DY_scroll(wraper,prev,next,img,speed,or)
 { 
  var wraper = $(wraper);
  var prev = $(prev);
  var next = $(next);
  var img = $(img).find('ul');
  var w = img.find('li').outerWidth(true);
  var s = speed;
  next.click(function()
       {
        img.animate({'margin-left':-w},function()
                  {
                   img.find('li').eq(0).appendTo(img);
                   img.css({'margin-left':0});
                   });
        });
  prev.click(function()
       {
        img.find('li:last').prependTo(img);
        img.css({'margin-left':-w});
        img.animate({'margin-left':0});
        });
  if (or == true)
  {
   ad = setInterval(function() { next.click();},s*1000);
   wraper.hover(function(){clearInterval(ad);},function(){ad = setInterval(function() { next.click();},s*1000);});

  }
 }
 DY_scroll('.img-scroll','.prev','.next','.img-list',3,false);// true为自动播放，不加此参数或false就默认不自动
</script>
</div>
<div id="map_detail"></div>
<div id="map_around"></div>

<div id="threeinfo">
<p>土地信息</p>
<table style="position:absolute; left:25px; top:30px;width:875px;border:1px solid #F0F0F0">
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;" >
		<td width="100px">建筑限高</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getHeightLimit() %></td>
		<td width="100px">容积率</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getPlotRatio() %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px" >建筑密度</td>
		<td width="337.5px"bgcolor="#FFFFFF"><%=landList.get(0).getBuildingDensity() %></td>
		<td width="100px" >绿化率</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getGreeningRatio() %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">出让年限</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getSellYear() %></td>
		<td width="100px">规划建筑面积</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getPlanArea() %></td>
	</tr>
	<tr >
		<td width="100px">起始楼面价</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getInitialPrice() %></td>
		<td width="100px">成交楼面价</td>
		<td width="337.5px" bgcolor="#FFFFFF"><%=landList.get(0).getBuilddealPrice() %></td>
	</tr>
</table>
</div>  
<div id="fourinfo">
<p>信息</p>
<table style="position:absolute; left:25px; top:30px;width:875px;border:1px solid #F0F0F0">
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;" >
		<td width="100px">溢价率</td>
		<td width="800px" bgcolor="#FFFFFF"><%=landList.get(0).getPremiumRate() %></td>
		
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px" >竞得人</td>
		<td width="800px"bgcolor="#FFFFFF"><%=landList.get(0).getBuyer() %></td>
		
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">出让公告</td>
		<td width="800px" bgcolor="#FFFFFF"><%=landList.get(0).getSellAnnounce() %></td>
	</tr>
	<tr >
		<td width="100px">成交公告</td>
		<td width="800px" bgcolor="#FFFFFF"><%=landList.get(0).getDealAnnounce() %></td>
		
	</tr>
	<tr >
		<td width="100px">土地情况简介</td>
		<td width="800px" bgcolor="#FFFFFF"><%=landList.get(0).getLandIntr() %></td>
		
	</tr>
	<tr >
		<td width="100px">项目情况介绍</td>
		<td width="800px" bgcolor="#FFFFFF"><%=landList.get(0).getProjectIntro() %></td>
		
	</tr>
</table>
</div>
<div style="display:none">
 <%Mapconvert mapconvert = new Mapconvert();
  mapconvert.Convert_BD09_To_GCJ02(landList.get(0).getLatitude(),landList.get(0).getLongitude());%>
<h6 id="baidulng"><%=landList.get(0).getLongitude() %></h6><h6 id="baidulat"><%= landList.get(0).getLatitude()%></h6>
<h6 id="blng"><%=mapconvert.getLng() %></h6><h6 id="blat"><%=mapconvert.getLat()%></h6> 
<h6 id="landname"><%=landList.get(0).getLandName() %></h6>
</div>
</div>
</body>

<script type="text/javascript">
function buidmap(){
 //获取房产坐标
  var baidulng = document.getElementById("baidulng").innerHTML;
  var baidulat = document.getElementById("baidulat").innerHTML;
  var blng = document.getElementById("blng").innerHTML;
  var blat = document.getElementById("blat").innerHTML;
  
  var titlename = document.getElementById("landname").innerHTML;
  var buildaddress = document.getElementById("centerinfo1").innerHTML;
 // 百度地图API功能
 var map = new BMap.Map("map_detail");         // 创建Map实例
 var point = new BMap.Point(baidulng, baidulat);
 map.centerAndZoom(point, 15);
 map.addControl(new BMap.NavigationControl()); //添加平移缩放控件
 map.addControl(new BMap.ScaleControl());  //添加放大、缩小控件
 map.enableScrollWheelZoom();//允许鼠标滑轮操作 
 
 var myIcon = new BMap.Icon("images/manage/02.png", new BMap.Size(30,30));
 var marker = new BMap.Marker(point,{icon:myIcon});  // 创建标注
 map.addOverlay(marker);
 
 var scontent = "<div><div heigth=50 id='infor-content'><font color=blue>"+titlename+
 "<br/>"+buildaddress+"<br/></div>"+
 "<div heigth=100 id='quanjing'><br/><br/><br/><br/></div>"+
 "</font></div><div id='ifquanjing'></div>";
var opts = {
width : 250,     // 信息窗口宽度
height: 150,     // 信息窗口高度
title : titlename, // 信息窗口标题
enableMessage:true,//设置允许信息窗发送短息
message:"亲耐滴，晚上一起吃个饭吧？戳下面的链接看下地址喔~"
};
var infoWindow = new BMap.InfoWindow(scontent,opts);

var center = new qq.maps.LatLng(blat,blng);
var panoService = new qq.maps.PanoramaService();
panoService.getPano(center, 1000, function(result) {
convertlnglat = result.svid;
//document.getElementById("r-result").innerHTML = result? result.svid : "此处无街景";
});
map.addEventListener("tilesloaded",function(){
map.openInfoWindow(infoWindow,point); //开启信息窗口	
pano = new qq.maps.Panorama(document.getElementById('quanjing'), {
"pano": convertlnglat,
disableMove: true,         //是否可以移动 
disableFullScreen: false,     //是否可以全屏 
disableCompass:true,          //罗盘显示状态
disableMove:true,             //移动箭头显示状态 
zoom:1,                       //放大级别 1-4
pov:{                         //与正北方方向的水平以及与地面夹角 
	heading:20,
	pitch:15
 }
});  
});

marker.addEventListener("click", function(){ 
this.openInfoWindow(infoWindow,point); //开启信息窗口	
pano = new qq.maps.Panorama(document.getElementById('quanjing'), {
"pano": convertlnglat,
disableMove: true,         //是否可以移动 
disableFullScreen: false,     //是否可以全屏 
disableCompass:true,          //罗盘显示状态
disableMove:true,             //移动箭头显示状态 
zoom:1,                       //放大级别 1-4
pov:{                         //与正北方方向的水平以及与地面夹角 
	heading:20,
	pitch:15
}
});  
});
}



</script>

</html>