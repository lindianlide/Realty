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
BuildingStructureAction structure= new BuildingStructureAction();
BuildingDecorateAction decorate=new BuildingDecorateAction();
List<Secondhouse> buildingList=building.serachsecond(houseId,memrole);
String buildUsage =building.secondusageSearch(buildingList.get(0).getUsageId());
String priceType =building.pricetypeSearch(buildingList.get(0).getPricetypeId());
String taxType =building.taxtypeSearch(buildingList.get(0).getTaxtypeId());
List sedecoragatePhotoList=building.secondPhoto(houseId,"sedecorate_photo");
List seTypeList =building.secondPhoto(houseId, "setype_photo");
String structureString = structure.buildingstructureSearch(buildingList.get(0).getStructureId());
String decorateString = decorate.buildingdecorateSearch(buildingList.get(0).getDecorateId()); 
System.out.println(buildingList.get(0).getPropertyAdress() );
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="pragma" content="no-cache" />
 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PhvZF9yCpEwS4FSljdGm7f7A"></script>
 <script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp&key=d84d6d83e0e51e481e50454ccbe8986b"></script>
 <%@include file="/website/inc/head.inc"%>
 <link rel="stylesheet" href="/realty/css/theme-responsive.css">
  
 <link rel="stylesheet" href="/realty/css/buildinfo.css"> 
     <link href="css/navigationpic.css" rel="stylesheet" type="text/css" />
 <link href="css/lightbox.css" rel="stylesheet" type="text/css" />
 <link href="css/album.css" rel="stylesheet" type="text/css" />
 <script src="js/album.js" type="text/javascript"></script>
 <script src="js/lightbox.js" type="text/javascript"></script>
 
</head>
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
	<div id="titleinfo1"><%=buildingList.get(0).getHouseName() %></div>
	<div id="titleinfo2">房源编号：<%=buildingList.get(0).getHouseId() %></div>
</div>
<div id="basicinfo">
<div id="imageinfo">
 <div id="album">
  <%if(!sedecoragatePhotoList.isEmpty()) {%>
    <div id="pic"> <a href="picupload/second/<%=sedecoragatePhotoList.get(0)%>" rel="lightbox" id="ShowLightBox"><img src="picupload/second/<%=sedecoragatePhotoList.get(0)%>" alt="点击查看完全尺寸" id="placeholder" /></a> </div>
    <div id="thumbs">
      <ul>
      <%for(int i=0;i<sedecoragatePhotoList.size();i++){ %>
        <li><a onclick="return showPic(this);" href="picupload/second/<%=sedecoragatePhotoList.get(i)%>" title=""><img src="picupload/second/<%=sedecoragatePhotoList.get(i) %>" alt=" " /></a></li><%} %>
        
      </ul>
    </div><%}else{ %>
    <div id="pic">无图片 </div>
   <%} %>
  </div>
  </div>
<div id="centerinfo1">交易价格  <%=buildingList.get(0).getExchangePrice()%>元/平方米       总价:<%=buildingList.get(0).getExchangeTotle() %></div>
<div id="centerinfo2">房型 <%=buildingList.get(0).getHouseType() %>     建筑面积：<%=buildingList.get(0).getBuildingArea()%></div>
<div id="centerinfo3">楼层<%=buildingList.get(0).getFloorSaid()%>/<%=buildingList.get(0).getFloorTotle() %>    房屋用途：<%=buildUsage%></div>
<div id="centerinfo4">
  <p>物业名称：  <%=buildingList.get(0).getPropertyName()%> </p>
  <p id="buildaddress">物业地址：<%=buildingList.get(0).getPropertyAdress() %></p>
</div>
</div>

 
<div id="secondinfo">
<p>交易信息</p>
<table style="position:absolute; left:25px; top:30px;width:875px;border:1px solid #F0F0F0">
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;" >
		<td width="100px">交易单价</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getExchangePrice()%></td>
		<td width="100px">交易总价</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getExchangeTotle()%></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px" >价格类型</td>
		<td width="337.5px"bgcolor="#FFFFF"><%=priceType %></td>
		<td width="100px" >税费承担方式</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=taxType %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">卖方税费</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getTaxSeller() %></td>
		<td width="100px">买房税费</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getTaxBuyer() %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">交易时间</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getExchangeTime() %></td>
		<td width="100px">税费合计</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getTaxTotle() %></td>
	</tr>
</table>
</div>
<div id="typephoto">
<div class="tabList" id="tabList1">
<ul class="tabBox">
    <li class="tabOption tabOn"><h4><a href="javascript:void(0);" title="单击，跳转到所有[日志]列表"><span>装修图</span></a></h4>
      <div class="tabContentBox">
      <div class="img-scroll">
			    <span class="prev">上一张</span>  
			    <div class="img-list">
			        <ul class="image_ul">
			            <%if(!sedecoragatePhotoList.isEmpty()) {
			   				 for(int i =0;i<sedecoragatePhotoList.size();i++){ %>
			                  <li class="image_ul image_li"><a rel="example_group" href="picupload/second/<%=sedecoragatePhotoList.get(i) %>" title="Lorem ipsum dolor sit amet"><img style="width:250px;height:250px;" src="picupload/second/<%=sedecoragatePhotoList.get(i) %>"></a></li><%} %>   
					    	<%}else{ %>
					    <li class="image_ul image_li">无图片 </li>
					   <%} %>
			        </ul>
			    </div>
				<span class="next">下一张</span>
			</div>
      </div> 
    </li>
    <li class="tabOption"><h4><a href="javascript:void(0);" title="单击，跳转到所有[相册]列表"><span>户型图</span></a></h4>
      <div class="tabContentBox">
      <div class="img-scroll">
			    <span class="prev">上一张</span>  
			    <div class="img-list1">
			        <ul class="image_ul">
			            <%if(!seTypeList.isEmpty()) {
			   				 for(int i =0;i<seTypeList.size();i++){ %>
			            <li class="image_ul image_li"><img style="width:250px;height:250px;" src="picupload/second/<%=seTypeList.get(i) %>"></li><%} %>
					     
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
<p>基本信息</p>
<table style="position:absolute; left:25px; top:30px;width:875px;border:1px solid #F0F0F0">
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;" >
		<td width="100px">建筑面积</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getBuildingArea() %></td>
		<td width="100px">建筑结构</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=structureString%></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px" >赠送面积</td>
		<td width="337.5px"bgcolor="#FFFFF"><%=buildingList.get(0).getPresent() %></td>
		<td width="100px" >装修情况</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=decorateString %></td>
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px">建成年代</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getBuildingTime() %></td>
		<td width="100px">所在层数</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getFloorSaid()%>/<%=buildingList.get(0).getFloorTotle() %></td>
	</tr>
	<tr >
		<td width="100px">得房率</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getRoomRate() %></td>
		<td width="100px">单户朝向</td>
		<td width="337.5px" bgcolor="#FFFFF"><%=buildingList.get(0).getOrientation() %></td>
	</tr>
</table>
</div>  
<div id="fourinfo">
<p>简介</p>
<table style="position:absolute; left:25px; top:30px;width:875px;border:1px solid #F0F0F0">
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;" >
		<td width="100px">实例简介</td>
		<td width="800px" bgcolor="#FFFFF"><%=buildingList.get(0).getIntroduction() %></td>
		
	</tr>
	<tr style="height:30px;border-bottom:1px solid #F0F0F0;">
		<td width="100px" >其他</td>
		<td width="800px"bgcolor="#FFFFF"><%=buildingList.get(0).getOtherfile() %></td>
		
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
	  var buildaddress = document.getElementById("buildaddress").innerHTML;
	  
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