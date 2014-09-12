<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,com.realty.base.dao.impl.*,com.realty.base.dao.*,java.util.List,java.util.Map"%>
<%
String houseId1=request.getParameter("houseId");
int houseId=Integer.parseInt(houseId1);
SecondAction secondaction=new SecondAction();
List<Secondhouse> secondList=secondaction.secondList();
int i=0;
int id=0;
String formName=null;
for(int j=0;j<secondList.size();j++){
	if(secondList.get(j).getHouseId()==houseId){
		{
			id=j;
			 break;
			}
	}
}
int regionId=secondList.get(id).getRegionId();
int usageId=secondList.get(id).getUsageId();
int structureId=secondList.get(id).getStructureId();
int decorateId=secondList.get(id).getDecorateId();

BuildingDecorateAction BD=new BuildingDecorateAction();
List<BuildingDecorate> BDList=BD.buildingdecorateList();

RegionAction region=new RegionAction();
List<Region> regionList=region.regionList();

SecondDao SU=new SecondDaoImpl();
List<FloorUsage> SUList=SU.secondusageList();
List<PriceType> PTList=SU.pricetypeList();
List<TaxType> TTList=SU.taxtypeList();

BuildingStructureAction BS=new BuildingStructureAction();
List<BuildingStructure> BSList=BS.buildingstructureList();
%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PhvZF9yCpEwS4FSljdGm7f7A"></script>
<link href="css/manstyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<style type="text/css">
.moveBar {
 position: absolute;
 width: 400px;
 height: 400px;
 border: solid 1px #000;
}
#banner {
 background: #52CCCC;
 cursor: move;
}
#content{
 width: 400px;
 height: 380px;
 overflow: hidden;
}
</style>
</head>
<script language="JavaScript" type="text/javascript">
var typephotoph=0;
var decoratephotoph=0;
function fileupload1(){
	if($("#typephoto").val()==""){
		alert("上传文件不能为空!");
		return false;
	}
	//var f = document.getElementById("myfilePath");
	// alert(f.value);
	var file = $("#typephoto").val();
	var pos=file.lastIndexOf("\\");
	var fileName=file.substring(pos+1);  
	var suffixindex=file.lastIndexOf(".");
	var suffix=file.substring(suffixindex+1);  
	if(suffix!="jpg"&&suffix!="bmp"&&suffix!="gif"&&suffix!="png"){
		alert("上传文件类型不正确!");
		return false;
	}
	typephotoph++;
	$.ajaxFileUpload({
			
			url:"PictureServlet?category=2&flag=1&houseId="+<%=houseId%>,
			contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
			secureuri:false,
			cache: false,//防止缓存
			fileElementId:'typephoto',
			dataType: 'text/xml',			
			success: function (data) {
			    document.getElementById("typephoto"+typephotoph).innerHTML = fileName;
				alert(fileName);
			},error: function (data, status, e){
				alert("fail");
			}
		}
	);
}
function fileupload2(){
	if($("#decoratephoto").val()==""){
		alert("上传文件不能为空!");
		return false;
	}
	//var f = document.getElementById("myfilePath");
	// alert(f.value);
	var file = $("#decoratephoto").val();
	var pos=file.lastIndexOf("\\");
	var fileName=file.substring(pos+1);  
	var suffixindex=file.lastIndexOf(".");
	var suffix=file.substring(suffixindex+1);  
	if(suffix!="jpg"&&suffix!="bmp"&&suffix!="gif"&&suffix!="png"){
		alert("上传文件类型不正确!");
		return false;
	}
	decoratephotoph++;
	$.ajaxFileUpload({
			
			url:"PictureServlet?category=2&flag=2&houseId="+<%=houseId%>,
			contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
			secureuri:false,
			cache: false,//防止缓存
			fileElementId:'decoratephoto',
			dataType: 'text/xml',			
			success: function (data) {
			    document.getElementById("decoratephoto"+decoratephotoph).innerHTML = fileName;
				alert(fileName);
			},error: function (data, status, e){
				alert("fail");
			}
		}
	);
}
</script>
<body>
<div id="r-result"></div>
<form id="form1" name="form1" method="post"  action="SecondServlet?flag=2&houseId=<%=houseId%>">
<table width="663" height="686" cellpadding=0 cellspacing=0 align="center">
 <tr>
      <td colspan="2">二手房名字：
        <input name="houseName" type="text" size="20" value="<%=secondList.get(id).getHouseName()%>"/></td>
    </tr>
  <tr>
      <td width="330">物业所在区域：
       <select name="regionId" size="1" onblur="addarea(this.value)">
         <option value="<%=regionList.get(regionId).getRegionId()%>"><%= regionList.get(regionId).getRegionName()%></option>
        <%for(i=1;i<regionList.size();i++){ %>
          <option value="<%=regionList.get(i).getRegionId()%>"><%= regionList.get(i).getRegionName()%></option>
		<% }%>
        </select></td>
      <td width="333">物业地址：
        <input name="propertyAdress" type="text" size="20" value="<%=secondList.get(id).getPropertyAdress()%>"/></td>
    </tr>
    <tr>
      <td>物业名称：      
        <input name="propertyName" type="text" size="20" value="<%=secondList.get(id).getPropertyName()%>" /></td>
      <td>房屋用途：
        <select name="usageId" size="1">
        <option value="<%=SUList.get(usageId).getUsageId()%>"><%=SUList.get(usageId).getUsageName()%></option>
        <%for(i=1;i<SUList.size();i++){ %>
          <option value="<%=SUList.get(i).getUsageId()%>"><%=SUList.get(i).getUsageName()%></option>
          <%} %>
        </select></td>
    </tr>
    <tr>
      <td>建筑结构：
       <select name="structureId" size="1">
          <option value="<%=BSList.get(structureId).getStructureId()%>"><%=BSList.get(structureId).getStructureName()%></option>
        <%for(i=1;i<BSList.size();i++){ %>
         <option value="<%=BSList.get(i).getStructureId()%>"><%=BSList.get(i).getStructureName()%></option>
		<%} %>
        </select></td>
      <td>赠送面积：
        <input name="present" type="text" size="15" value="<%=secondList.get(id).getPresent()%>" /></td>
    </tr>
    <tr>
      <td>装修情况：
        <select name="decorateId" size="1">
       <option value="<%=BDList.get(decorateId).getDecorateId()%>"><%=BDList.get(decorateId).getDecorateName() %></option>
      <%for(i=1;i<BDList.size();i++){ %>
        <option value="<%=BDList.get(i).getDecorateId()%>"><%=BDList.get(i).getDecorateName() %></option>
        <%} %>
      </select></td>
      <td>建成年代：
        <input name="buildingTime" type="text" size="15" value="<%=secondList.get(id).getBuildingTime()%>"/></td>
    </tr>
    <tr>
      <td>总层数：
        <input name="floorTotle" type="text" size="15" value="<%=secondList.get(id).getFloorTotle()%>"/></td>
       <td>所在名义层 ：
         <input name="floorSaid" type="text" size="20" value="<%=secondList.get(id).getFloorSaid()%>" /></td>
    </tr>
    <tr>
      <td>所在实际层 ：
        <input name="floorActual" type="text" size="20" value="<%=secondList.get(id).getFloorActual()%>" /></td>
      <td>得房率：
        <input name="roomRate" type="text" size="20" value="<%=secondList.get(id).getRoomRate()%>" /></td>
    </tr>
    <tr>
      <td>户型：
        <input name="houseType" type="text" size="20" value="<%=secondList.get(id).getHouseType()%>" /></td>
      <td>单户朝向：
        <input name="orientation" type="text" size="20" value="<%=secondList.get(id).getOrientation()%>" /></td>
    </tr>
    <tr>
      <td width="330" >交易时间：
      <input name="exchangeTime" type="text" size="20" value="<%=secondList.get(id).getExchangeTime()%>" /></td>
      <td width="333">建筑面积：
      <input name="buildingArea" type="text" size="20" value="<%=secondList.get(id).getBuildingArea()%>"/></td>
    </tr>
    <tr>
      <td>交易单价：
        <input name="exchangePrice" type="text" size="20" value="<%=secondList.get(id).getExchangePrice()%>" /></td>
      <td>交易总价：
      <input name="exchangeTotle" type="text" size="20" value="<%=secondList.get(id).getExchangeTotle()%>" /></td>
    </tr>
    <tr>
      <td>价格类型：
        <select name="pricetypeId" size="1">
            <%for(i=0;i<PTList.size();i++){ %>
            <option value="<%=PTList.get(i).getPricetypeId()%>"><%=PTList.get(i).getPricetypeName()%></option>
            <%} %>
        </select></td>
      <td>税费承担方式 ：
        <select name="taxtypeId" size="1">
            <%for(i=0;i<TTList.size();i++){ %>
            <option value="<%=TTList.get(i).getTaxtypeId()%>"><%=TTList.get(i).getTaxtypeName()%></option>
            <%} %>
        </select></td>
    </tr>
    <tr>
      <td>税费合计：
      <input name="taxTotle" type="text" size="20" value="<%=secondList.get(id).getTaxTotle()%>"/></td>
      <td>卖方税费：
      <input name="taxSeller" type="text" size="20" value="<%=secondList.get(id).getTaxSeller()%>" /></td>
    </tr>
    <tr>
      <td>买方税费：
      <input name="taxBuyer" type="text" size="20" value="<%=secondList.get(id).getTaxBuyer()%>" /></td>
      <td>二手房上架时间：
      <input name="saleTime" type="text" size="20" value="<%=secondList.get(id).getSaleTime()%>" /></td>
    </tr>
    <tr>
      <td colspan="2">实例简介：      
      <input name="introduction" type="text" size="20" value="<%=secondList.get(id).getIntroduction()%>"/></td>
    </tr>
    
     <tr>
      <td height="30" colspan="2">户型图：
      <span  id="typephoto1" ></span>
     <span  id="typephoto2" ></span>
      <span  id="typephoto3" ></span>
     <span  id="typephoto4" ></span>
      <input type="file" name="typephoto" id="typephoto" value="this.val()"/>
      <input type="button" name="fileLoad1" id="fileLoad1" value="上传" onClick="fileupload1()"/>
      </td>
    </tr>
        <tr>
      <td height="30" colspan="2">装修图：
        <span  id="decoratephoto1" ></span>
		<span  id="decoratephoto2" ></span>
		<span  id="decoratephoto3" ></span>
		<span  id="decoratephoto4" ></span>
      <input type="file" name="decoratephoto" id="decoratephoto" value="this.val()"/>
      <input type="button" name="fileLoad2" id="fileLoad2" value="上传" onClick="fileupload2()"/>
      </td>
    </tr>
     
    <tr>
      <td>经度：
      <input name="longitude" id="longitude" type="text" size="20"  value="<%=secondList.get(id).getLongitude()%>"/></td>
      <td>纬度：
      <input name="latitude" id="latitude" type="text" size="20"  value="<%=secondList.get(id).getLatitude()%>"/></td>
    </tr>
    <tr>
      <td>信息录入人：
        <input name="entryName" type="text" size="15" value="<%=secondList.get(id).getEntryName()%>" /></td>
     <td>  录入时间：
      <input name="entryTime" type="text" size="20" value="<%=secondList.get(id).getEntryTime()%>" /></td>
    </tr>
    <tr>
      <!-- <td>提交人：
      <input name="auditName" type="text" size="20" />提交时间：
      <input name="auditTime" type="text" size="20" /> -->
    <td colspan="2">   状态标记：
      <select name="status" size="1">
       <option value="0">录入</option>
        <option value="1">提交</option>
      </select></td>
    </tr>
    <tr>
      <td colspan="2">备注：
      <input name="remarks" type="text" size="50" value="<%=secondList.get(id).getRemarks()%>" /></td>
    </tr>
    <tr>
      <td height="40"><div align="center">
        <input type="submit" name="Submit" value="保存" />
      </div></td>
      <td>
        <div align="center">
          <input type="reset" name="Submit2" value="重置" />
        </div></td>
    </tr>
  </table>
  <div id="l-map"></div>
</form>
<!-- 浮动百度地图 -->
<div style="padding-left: 160px; padding-top: 0px;">
  <div class="moveBar">
    <div id="banner">获取百度经纬度</div>
    <div class="content" id="content"></div>
  </div>
</div> 
<script>
 jQuery(document).ready(
   function () {
     $('#banner').mousedown(
     function (event) {
         var isMove = true;
         var abs_x = event.pageX - $('div.moveBar').offset().left;
         var abs_y = event.pageY - $('div.moveBar').offset().top;
         $(document).mousemove(function (event) {
            if (isMove) {
               var obj = $('div.moveBar');
               obj.css({'left':event.pageX - abs_x, 'top':event.pageY - abs_y});
            }
         }).mouseup(
         function () {
             isMove = false;
         });
      }
    );
  }
);
</script>
</body>
<script type="text/javascript">
 // 百度地图API功能
 var map = new BMap.Map("content");         // 创建Map实例
 map.centerAndZoom(new BMap.Point(120.438398, 36.144194), 12);
 map.addControl(new BMap.NavigationControl()); //添加平移缩放控件
 map.addControl(new BMap.ScaleControl());  //添加放大、缩小控件
 map.enableScrollWheelZoom();//允许鼠标滑轮操作 
 
 map.addEventListener("click" , showpoint);
 function showpoint(e){
	     map.removeEventListener("click", showpoint);    //取消地图监听 
		 point = new BMap.Point(e.point.lng,e.point.lat);
		 marker1 = new BMap.Marker(point);
		//var myIcon = new BMap.Icon("image/aa.gif", new BMap.Size(100,50));
		// var marker = new BMap.Marker(point,{icon:myIcon});  // 创建标注
		 var marker = new BMap.Marker(point);
		 marker.enableDragging();  //激活标志的拖拽功能
		 map.addOverlay(marker);	
		 marker.addEventListener("dragging", function(e){
			// document.getElementById("r-result").innerHTML = "经度："+e.point.lng+"<br/>维度："+e.point.lat;
			 document.getElementById("longitude").value=e.point.lng;
			 document.getElementById("latitude").value=e.point.lat;
		 });		
 } 
</script>
<script type="text/javascript">
 function addarea(areavalue){
	 var point2;//
	 if(areavalue==0){
		 point2=new BMap.Point(120.47433,36.115276);
	 }else if(areavalue==1){
		 point2=new BMap.Point(120.419426,36.080281);
	 }else if(areavalue==2){
		 point2=new BMap.Point(120.380906,36.093814);
	 }else if(areavalue==3){
		 point2=new BMap.Point(120.47433,36.115276);
	 }else if(areavalue==4){
		 point2=new BMap.Point(120.440123,36.151189);
	 }else if(areavalue==5){
		 point2=new BMap.Point(120.404478,36.313287);
	 }else if(areavalue==6){
		 point2=new BMap.Point(120.204695,35.965152);
	 }else if(areavalue==7){
		 point2=new BMap.Point(120.454783,36.393976);
	 }else if(areavalue==8){
		 point2=new BMap.Point(120.041419,36.270699);
	 }else if(areavalue==9){
		 point2=new BMap.Point(120.024746,35.877699);
	 }else if(areavalue==10){
		 point2=new BMap.Point(119.971279,36.794768);
	 }else if(areavalue==11){
		 point2=new BMap.Point(120.527797,36.89458);
	 }
	 map.centerAndZoom(point2, 14);	 
 }
</script>
</html>