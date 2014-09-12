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

int houseId =Integer.parseInt(request.getParameter("houseId"));
SecondAction building=new SecondAction();
RegionAction region=new RegionAction();
BuildingUsageAction usage=new BuildingUsageAction();

BuildingStructureAction structure= new BuildingStructureAction();
BuildingDecorateAction decorate=new BuildingDecorateAction();
List<Secondhouse> buildingList=building.serachsecond(houseId,memrole);
String buildUsage =building.secondusageSearch(buildingList.get(0).getUsageId());
String priceType =building.pricetypeSearch(buildingList.get(0).getPricetypeId());
String taxType =building.taxtypeSearch(buildingList.get(0).getTaxtypeId());
List sedecoragatePhotoList=building.secondPhoto(houseId,"sedecorate_photo");
List seTypeList =building.secondPhoto(houseId, "setype_photo");
String regionstring=region.regionSearch(buildingList.get(0).getRegionId());
String usageString =usage.buildingusageSearch(buildingList.get(0).getUsageId());

String structureString = structure.buildingstructureSearch(buildingList.get(0).getStructureId());
String decorateString = decorate.buildingdecorateSearch(buildingList.get(0).getDecorateId()); 

%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="pragma" content="no-cache" />
 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PhvZF9yCpEwS4FSljdGm7f7A"></script>
 <script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp&key=d84d6d83e0e51e481e50454ccbe8986b"></script>
 <%@include file="/website/inc/head.inc"%>
 <link rel="stylesheet" href="/realty/css/theme-responsive.css">
  
 <link rel="stylesheet" href="/realty/css/buildinfo.css"> 
 
 <link href="css/lightbox.css" rel="stylesheet" type="text/css" />
 <link href="css/album.css" rel="stylesheet" type="text/css" />
 <script src="js/album.js" type="text/javascript"></script>
 <script src="js/lightbox.js" type="text/javascript"></script>
 
</head>
<body onload="buidmap()">
<%@include file="/website/inc/header.inc"%>
<div id="background">
<div id="headinfo">
	<div id="titleinfo1"><%=buildingList.get(0).getHouseName() %></div>
	<div id="titleinfo2">小区所属行政区：：<%=regionstring %></div>
	<div id="titleinfo3">商圈/学区：</div>
</div>
<div id="basicinfo">
<div id="imageinfo">
  <div id="album">
    <div id="pic"> <a href="img/2006614212228979.jpg" rel="lightbox" id="ShowLightBox"><img src="img/2006614212228979.jpg" alt="点击查看完全尺寸" id="placeholder" /></a> </div>
    <div id="thumbs">
      <ul>
         <%if(!sedecoragatePhotoList.isEmpty()) {%>
    <div id="pic"> <a href="picupload/building/<%=sedecoragatePhotoList.get(0)%>" rel="lightbox" id="ShowLightBox"><img src="picupload/building/<%=sedecoragatePhotoList.get(0)%>" alt="点击查看完全尺寸" id="placeholder" /></a> </div>
    <div id="thumbs">
      <ul>
      <%for(int i=0;i<sedecoragatePhotoList.size();i++){ %>
        <li><a onclick="return showPic(this);" href="picupload/building/<%=sedecoragatePhotoList.get(i)%>" title=""><img src="picupload/building/<%=sedecoragatePhotoList.get(i) %>" alt=" " /></a></li><%} %>
        
      </ul>
    </div><%}else{ %>
    <div id="pic">无图片 </div>
   <%} %>
      </ul>
    </div>
  </div>
</div>
<div id="centerinfo1">小区地址： <%=buildingList.get(0).getPropertyAdress()%></div>
<div id="centerinfo2">房屋用途： <%=buildUsage%>   </div>
<div id="centerinfo3">房屋面积：<%=buildingList.get(0).getBuildingArea() %>  </div>
<div id="centerinfo4">
  <p>房屋单价：<%=buildingList.get(0).getExchangePrice()%>元/平方米 </p>
  <p>所在楼层/总层数：<%=buildingList.get(0).getFloorSaid()%>/<%=buildingList.get(0).getFloorTotle() %> </p>
  <p>朝向：<%=buildingList.get(0).getOrientation() %></p>
  <p>装修情况：：<%=decorateString %></p>
</div>
</div>

 
<div id="secondinfo">
<p>房屋情况</p>
<table style="position:absolute; left:25px; top:30px;width:875px;border:1px solid #F0F0F0">
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;" >
		<td width="100px">建筑类型</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
		<td width="100px">开发商</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">建筑结构</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=structureString %></td>
		<td width="100px" >建成年代</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getBuildingTime() %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">土地使用年限</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	   <td width="100px">建筑密度</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px" >装修情况</td>
		<td width="337.5px" bgcolor="#FFFFF"></td>
	    <td width="100px" >朝向</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getOrientation() %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">物业公司</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getPropertyName() %></td>
	    <td width="100px" >户型结构</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getHouseType() %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">名义层/总层</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getFloorSaid() %>/<%=buildingList.get(0).getFloorTotle() %></td>
	    <td width="100px" >物业费</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">价格类型</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	    <td width="100px" >实际层/总层</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getFloorActual()%>/<%=buildingList.get(0).getFloorTotle() %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">交易时间</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getExchangeTime()%></td>
	    <td width="100px" >本小区历史数据</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	</tr>
</table>
</div>
<div id="typephoto">

<div class="img-scroll">
    <span class="prev">上一张</span>  
    <div class="img-list">
        <ul class="image_ul">
            <%if(!seTypeList.isEmpty()) {
    for(int i =0;i<seTypeList.size();i++){ %>
            <li class="image_ul image_li"><img style="width:270px;height:270px;" src="picupload/building/<%=seTypeList.get(i) %>"></li><%} %>
     
    <%}else{ %>
    <li class="image_ul image_li">无图片 </li>
   <%} %>
           
            <!-- <li class="image_ul image_li"><img style="width:263px;height:300px;" src="./img/meinv.jpg"></li>
            <li class="image_ul image_li"><img style="width:260px;height:300px;" src="./img/mm.jpg"></li>
            <li class="image_ul image_li"><img style="width:263px;height:300px;" src="./img/慢慢.jpg"></li>
            <li class="image_ul image_li"><img style="width:263px;height:300px;" src="./img/美食杰-糖糖.jpg"></li>
            <li class="image_ul image_li"><img style="width:263px;height:300px;" src="./img/未命名44.jpg"></li> -->
        </ul>
    </div>
	<span class="next">下一张</span>
</div>

</div>

<div id="map">
	
</div> 
<div id="threeinfo">
<p>物业信息</p>
<table style="position:absolute; left:25px; top:30px;width:875px;border:1px solid #F0F0F0">
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;" >
		<td width="100px">物业公司</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getPropertyName() %></td>
		<td width="100px">物业管理费</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px" >车位价格</td><!-- 缺少字段 -->
		<td width="337.5px"bgcolor="#FFFFF"></td>
		<td width="100px" >车位管理费</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	</tr>
	
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">供水</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	    <td width="100px" >供电</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">供气</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	    <td width="100px" >供暖</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
	    <td width="100px" >通讯</td><!-- 缺少字段 -->
		<td width="337.5px" bgcolor="#FFFFF"></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">小区内部设施</td>
		<td width="775.5px" bgcolor="#FFFFF"></td>   
	</tr>
</table>
</div>  
<div id="fourinfo">
<p>周边配套</p>
<table style="position:absolute; left:25px; top:30px;width:875px;border:1px solid #F0F0F0">
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;" >
		<td width="100px">商业设施</td><!-- 缺少字段 -->
		<td width="800px" bgcolor="#FFFFF"></td>
		
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px" >教育</td><!-- 缺少字段 -->
		<td width="800px"bgcolor="#FFFFF"></td>
		
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">医疗</td><!-- 缺少字段 -->
		<td width="800px" bgcolor="#FFFFF"></td>
	</tr>
	<tr >
		<td width="100px">银行</td><!-- 缺少字段 -->
		<td width="800px" bgcolor="#FFFFF"></td>
		
	</tr>
	<tr >
		<td width="100px">公共交通</td><!-- 缺少字段 -->
		<td width="800px" bgcolor="#FFFFF"></td>
		
	</tr>
	<tr >
		<td width="100px">其他</td><!-- 缺少字段 -->
		<td width="800px" bgcolor="#FFFFF"></td>
		
	</tr>
</table>
</div>
<div style="display:none">
<%Mapconvert mapconvert = new Mapconvert();
  mapconvert.Convert_BD09_To_GCJ02(buildingList.get(0).getLatitude(),buildingList.get(0).getLongitude());%>
<h6 id="baidulng"><%=buildingList.get(0).getLongitude() %></h6><h6 id="baidulat"><%= buildingList.get(0).getLatitude()%></h6>
<h6 id="blng"><%=mapconvert.getLng() %></h6><h6 id="blat"><%=mapconvert.getLat()%></h6> 

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
	  
	  var titlename = document.getElementById("titleinfo1").innerHTML;
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
	 
	var myKeys = "小区";
	var distance = 5000;
	local = new BMap.LocalSearch(point, {
	  renderOptions: {
		  map: map,
	     autoViewport: false,
	     selectFirstResult: false,
	     panel: "map_around"
	  },
	  pageCapacity: 8
	});
	local.searchNearby(myKeys,point,distance);
	 
	}
</script>

</html>