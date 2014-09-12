<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.List,java.util.Map"%>
<%
String buildingId1=request.getParameter("buildingId");
int buildingId=Integer.parseInt(buildingId1);
BuildingAction build=new BuildingAction();
int i=0;
int id=0;
String formName=null;
List<Building> buildList=build.buildingList(buildingId);

String formId=buildList.get(id).getFormId();
int regionId=buildList.get(id).getRegionId();
int usageId=buildList.get(id).getUsageId();
int structureId=buildList.get(id).getStructureId();
int decorateId=buildList.get(id).getDecorateId();
BuildingDecorateAction BD=new BuildingDecorateAction();
List<BuildingDecorate> BDList=BD.buildingdecorateList();

BuildingFormAction BF=new BuildingFormAction();
List<BuildingForm> BFList=BF.buildingformList();
for(int j=0;j<BFList.size();j++){
	//System.out.println(BFList.get(j).getFormId());
	if(BFList.get(j).getFormId().equals(formId)){
	    formName=BFList.get(j).getFormName();
		break;
	}
}
RegionAction region=new RegionAction();
List<Region> regionList=region.regionList();

BuildingUsageAction BU=new BuildingUsageAction();
List<BuildingUsage> BUList=BU.buildingusageList();

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
<!-- <script src="http://www.codefans.net/ajaxjs/jquery-1.9.1.min.js" type="text/javascript"></script>
 -->
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
function Checkdate(dateinput) {
    var ret = true;
    var a=/^(1[0-9][0-9][0-9]|2[0-9][0-9][0-9])(\-)(0[1-9]|1[0-2])(\-)(0[1-9]|[1-2][0-9]|3[0-1])$/;
    //var dateinput=document.getElementById("announceTime").value;
    if(dateinput==""||dateinput=="null")
    	 return ret;
    else{    
        if (!a.test(dateinput)) {
            alert("请输入正确的日期");
            return false;
        }
    }
    return ret;
}
    var locationph=0;
    var buildph=0;
    var typeph=0;
    var planph=0;
	function fileupload1(){
		if($("#locationphoto").val()==""){
			alert("上传文件不能为空!");
			return false;
		}
		//var f = document.getElementById("myfilePath");
		// alert(f.value);
		var file = $("#locationphoto").val();
		var pos=file.lastIndexOf("\\");
		var fileName=file.substring(pos+1);  
		var suffixindex=file.lastIndexOf(".");
		var suffix=file.substring(suffixindex+1);  
		if(suffix!="jpg"&&suffix!="bmp"&&suffix!="gif"&&suffix!="png"){
			alert("上传文件类型不正确!");
			return false;
		}
		locationph++;
		if(locationph>1)
		{alert("只能上传一张位置图！");
		return false;
		}
		$.ajaxFileUpload({
				
				url:"PictureServlet?category=1&flag=1&buildingId="+<%=buildingId%>,
				contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
				secureuri:false,
				cache: false,//防止缓存
				fileElementId:'locationphoto',
				dataType: 'text/xml',			
				success: function (data) {
				    document.getElementById("locationspan").innerHTML = fileName;
					alert(fileName+"上传成功！");
				},error: function (data, status, e){
					alert("fail");
				}
			}
		);
	}
	function fileupload2(){
		if($("#buildingphoto").val()==""){
			alert("上传文件不能为空!");
			return false;
		}
		//var f = document.getElementById("myfilePath");
		// alert(f.value);
		var file = $("#buildingphoto").val();
		var pos=file.lastIndexOf("\\");
		var fileName=file.substring(pos+1);  
		var suffixindex=file.lastIndexOf(".");
		var suffix=file.substring(suffixindex+1);  
		if(suffix!="jpg"&&suffix!="bmp"&&suffix!="gif"&&suffix!="png"){
			alert("上传文件类型不正确!");
			return false;
		}
		buildph++;
		if(buildph>20)
		{alert("最多上传20张楼盘图！");
		return false;
		}
		$.ajaxFileUpload({
				
				url:"PictureServlet?category=1&flag=2&buildingId="+<%=buildingId%>,
				contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
				secureuri:false,
				cache: false,//防止缓存
				fileElementId:'buildingphoto',
				dataType: 'text/xml',			
				success: function (data) {
				    document.getElementById("buildingspan"+buildph).innerHTML = fileName;
					alert(fileName+"上传成功！");
				},error: function (data, status, e){
					alert("fail");
				}
			}
		);
	}
	function fileupload3(){
		if($("#typePhoto").val()==""){
			alert("上传文件不能为空!");
			return false;
		}
		//var f = document.getElementById("myfilePath");
		// alert(f.value);
		var file = $("#typePhoto").val();
		var pos=file.lastIndexOf("\\");
		var fileName=file.substring(pos+1);  
		var suffixindex=file.lastIndexOf(".");
		var suffix=file.substring(suffixindex+1);  
		if(suffix!="jpg"&&suffix!="bmp"&&suffix!="gif"&&suffix!="png"){
			alert("上传文件类型不正确!");
			return false;
		}
		typeph++;
		if(typeph>20)
			{alert("最多上传20张户型图！");
			return false;
			}
		$.ajaxFileUpload({
				
				url:"PictureServlet?category=1&flag=3&buildingId="+<%=buildingId%>,
				contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
				secureuri:false,
				cache: false,//防止缓存
				fileElementId:'typePhoto',
				dataType: 'text/xml',			
				success: function (data) {
				    document.getElementById("typespan"+typeph).innerHTML = fileName;
					alert(fileName+"上传成功！");
				},error: function (data, status, e){
					alert("fail");
				}
			}
		);
	}
	function fileupload4(){
		if($("#planPhoto").val()==""){
			alert("上传文件不能为空!");
			return false;
		}
		//var f = document.getElementById("myfilePath");
		// alert(f.value);
		var file = $("#planPhoto").val();
		var pos=file.lastIndexOf("\\");
		var fileName=file.substring(pos+1);  
		var suffixindex=file.lastIndexOf(".");
		var suffix=file.substring(suffixindex+1);  
		if(suffix!="jpg"&&suffix!="bmp"&&suffix!="gif"&&suffix!="png"){
			alert("上传文件类型不正确!");
			return false;
		}
		planph++;
		if(planph>4)
		{alert("最多上传4张平面图！");
		return false;
		}
		$.ajaxFileUpload({
				
				url:"PictureServlet?category=1&flag=4&buildingId="+<%=buildingId%>,
				contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
				secureuri:false,
				cache: false,//防止缓存
				fileElementId:'planPhoto',
				dataType: 'text/xml',			
				success: function (data) {
				    document.getElementById("planspan"+planph).innerHTML = fileName;
					alert(fileName+"上传成功！");
				},error: function (data, status, e){
					alert("fail");
				}
			}
		);
	}
</script>
<body>
<form id="form1" name="form1" method="post"  action="BuildingServlet?flag=2&buildingId=<%=buildingId%>">
  <table width="663" height="750"  align="center">
    <tr>
      <td width="289" height="30" >楼盘名：
        <input name="buildingName" type="text" size="20" value="<%=buildList.get(id).getBuildingName()%>" /></td>
      <td width="358" height="30">楼盘别名：
        <input name="buildingAlias" type="text" size="20" value="<%=buildList.get(id).getBuildingAlias()%>"/></td>
    </tr>
    <tr>
      <td height="30">物业所在区域：
        <select name="regionId" size="1" onBlur="addarea(this.value)" >
         <option value="<%=regionList.get(regionId).getRegionId()%>"><%= regionList.get(regionId).getRegionName()%></option>
        <%for(i=1;i<regionList.size();i++){ %>
          <option value="<%=regionList.get(i).getRegionId()%>"><%= regionList.get(i).getRegionName()%></option>
		<% }%>
        </select>      </td>
      <td height="30">物业地址：
      <input name="propertyAdress" type="text" size="30" value="<%=buildList.get(id).getPropertyAdress()%>"/></td>
    </tr>
    <tr>
      <td height="30">物业办公电话：
      <input name="proPhone" type="text" size="20" value="<%=buildList.get(id).getProPhone()%>"/></td>
      <td height="30">物业费：
      <input name="propertyFee" type="text" size="20" value="<%=buildList.get(id).getPropertyFee()%>"/></td>
    </tr>
    <tr>
      <td height="30">附加信息：
      <input name="proOtherinfor" type="text" size="20" value="<%=buildList.get(id).getProOtherinfor()%>"/></td>
      <td height="30">物业办公地点：
      <input name="proWorkaddress" type="text" size="20" value="<%=buildList.get(id).getProWorkaddress()%>"/></td>
    </tr>
    <tr>
      <td height="30">物业名称：
      <input name="propertyName" type="text" size="20" value="<%=buildList.get(id).getPropertyName()%>"/></td>
      <td height="30">楼盘用途：
        <select name="usageId" size="1">
        <option value="<%=BUList.get(usageId).getUsageId()%>"><%=BUList.get(usageId).getUsageName()%></option>
        <%for(i=1;i<BUList.size();i++){ %>
          <option value="<%=BUList.get(i).getUsageId()%>"><%=BUList.get(i).getUsageName()%></option>
          <%} %>
        </select></td>
    </tr>
    <tr>
      <td height="30">项目特色：
      <input name="projectFeature" type="text" size="20" value="<%=buildList.get(id).getProjectFeature()%>"/></td>
      <td height="30">邮编：
      <input name="zipCode" type="text" size="20" value="<%=buildList.get(id).getZipCode()%>"/></td>
    </tr>
    <tr>
      <td height="30">竣工时间：
        <span title="日期格式为：yyyy-mm-dd"> <input name="buildingtimeFinish" type="text" size="20" value="<%=buildList.get(id).getBuildingtimeFinish()%>" onblur="Checkdate(this.value);" placeholder="日期格式为：yyyy-mm-dd"/> </span></td>
      <td height="30">开发商：
      <input name="developers" type="text" size="20" value="<%=buildList.get(id).getDevelopers()%>" /></td>
    </tr>
    <tr>
      <td height="30">占地面积：
      <input name="floorArea" type="text" size="20" value="<%=buildList.get(id).getFloorArea()%>" />m<sup>2</sup></td>
      <td height="30">建筑面积：
      <input name="buildingArea" type="text" size="20" value="<%=buildList.get(id).getBuildingArea()%>" />m<sup>2</sup></td>
    </tr>
    <tr>
      <td height="30">建筑结构：
        <select name="structureId" size="1">
          <option value="<%=BSList.get(structureId).getStructureId()%>"><%=BSList.get(structureId).getStructureName()%></option>
        <%for(i=1;i<BSList.size();i++){ %>
         <option value="<%=BSList.get(i).getStructureId()%>"><%=BSList.get(i).getStructureName()%></option>
		<%} %>
        </select></td>
      <td height="30">建筑形态：
        <select name="formId" size="1">
        <option value="<%=formId%>"><%=formName%></option>
        <%for(i=1;i<BFList.size();i++){ %>
        <option value="<%=BFList.get(i).getFormId()%>"><%=BFList.get(i).getFormName()%></option>
        <%} %>
        </select></td>
    </tr>
    <tr>
      <td height="30" colspan="3">容积率：
        <input name="plotRatio" type="text" size="15"  value="<%=buildList.get(id).getPlotRatio()%>" />
      产权年限：
      <input name="landuseTime" type="text" size="15"  value="<%=buildList.get(id).getLanduseTime()%>"/>      
       建筑密度：
      <input name="buildingDensity" type="text" size="15"  value="<%=buildList.get(id).getBuildingDensity()%>"/></td>
    </tr>
    <tr>
      <td height="30" colspan="2">绿化率：
      <input name="greeningRate" type="text" size="15"  value="<%=buildList.get(id).getGreeningRate()%>"/>
      车位配比：
      1:<input name="parkingRatio" type="text" size="15"  value="<%=buildList.get(id).getParkingRatio()%>"/>
      交房装修情况：
      <select name="decorateId" size="1">
       <option value="<%=BDList.get(decorateId).getDecorateId()%>"><%=BDList.get(decorateId).getDecorateName() %></option>
      <%for(i=1;i<BDList.size();i++){ %>
        <option value="<%=BDList.get(i).getDecorateId()%>"><%=BDList.get(i).getDecorateName() %></option>
        <%} %>
      </select></td>
    </tr>
    <tr>
      <td height="30">开盘时间：
       <span title="日期格式为：yyyy-mm-dd"> <input name="openTime" type="text" size="20"  value="<%=buildList.get(id).getOpenTime()%>" onblur="Checkdate(this.value);" placeholder="日期格式为：yyyy-mm-dd"/> </span></td>
      <td height="30">物业服务：
      <input name="propertyService" type="text" size="30"  value="<%=buildList.get(id).getPropertyService()%>"/></td>
    </tr>
    <tr>
      <td height="30">开盘价格（起价）：
      <input name="initialPrice" type="text" size="15"  value="<%=buildList.get(id).getInitialPrice()%>"/>元</td>
      <td height="30">开盘价格（均价）：
      <input name="averagePrice" type="text" size="15"  value="<%=buildList.get(id).getAveragePrice()%>"/>元</td>
    </tr>
    <tr>
      <td height="30">房屋单价：
      <input name="perPrice" type="text" size="15"  value="<%=buildList.get(id).getPerPrice()%>"/>元</td>
      <td height="30">房屋总价：
      <input name="totalPrice" type="text" size="15"  value="<%=buildList.get(id).getTotalPrice()%>"/>元</td>
    </tr>
    <tr>
      <td height="30" colspan="2">楼盘位置图：
       <span  id="locationspan" ></span> 
      <input type="file" name="locationphoto" id="locationphoto" value="this.val()"/>
      <input type="button" name="fileLoad1" id="fileLoad1" value="上传" onClick="fileupload1()"/>      </td>
    </tr>
     <tr>
      <td height="30" colspan="2">楼盘照片：
      <span  id="buildingspan1" ></span>
     <span  id="buildingspan2" ></span>
      <span  id="buildingspan3" ></span>
     <span  id="buildingspan4" ></span>
      <span  id="buildingspan5" ></span>
     <span  id="buildingspan6" ></span>
      <span  id="buildingspan7" ></span>
     <span  id="buildingspan8" ></span>
      <span  id="buildingspan9" ></span>
     <span  id="buildingspan10" ></span>
      <span  id="buildingspan11" ></span>
     <span  id="buildingspan12" ></span>
      <span  id="buildingspan13" ></span>
     <span  id="buildingspan14" ></span>
      <span  id="buildingspan15" ></span>
     <span  id="buildingspan16" ></span>
      <span  id="buildingspan17" ></span>
     <span  id="buildingspan18" ></span>
      <span  id="buildingspan19" ></span>
     <span  id="buildingspan20" ></span>
      <input type="file" name="buildingphoto" id="buildingphoto" value="this.val()"/>
      <input type="button" name="fileLoad2" id="fileLoad2" value="上传" onClick="fileupload2()"/>      </td>
    </tr>
        <tr>
      <td height="30" colspan="2">楼盘户型图：
        <span  id="typespan1" ></span>
		<span  id="typespan2" ></span>
		<span  id="typespan3" ></span>
		<span  id="typespan4" ></span>
        <span  id="typespan5" ></span>
		<span  id="typespan6" ></span>
		<span  id="typespan7" ></span>
		<span  id="typespan8" ></span>
		<span  id="typespan9" ></span>
		<span  id="typespan10" ></span>
		<span  id="typespan11" ></span>
		<span  id="typespan12" ></span>
        <span  id="typespan13" ></span>
		<span  id="typespan14" ></span>
		<span  id="typespan15" ></span>
		<span  id="typespan16" ></span>
		<span  id="typespan17" ></span>
		<span  id="typespan18" ></span>
		<span  id="typespan19" ></span>
		<span  id="typespan20" ></span>
      <input type="file" name="typePhoto" id="typePhoto" value="this.val()"/>
      <input type="button" name="fileLoad3" id="fileLoad3" value="上传" onClick="fileupload3()"/>      </td>
    </tr>
            <tr>
      <td height="30" colspan="2">楼盘平面图：
      <span  id="planspan1" ></span>
      <span  id="planspan2" ></span>
      <span  id="planspan3" ></span>
      <span  id="planspan4" ></span>
      <input type="file" name="planPhoto" id="planPhoto" value="this.val()"/>
      <input type="button" name="fileLoad4" id="fileLoad4" value="上传" onClick="fileupload4()"/>      </td>
    </tr> 
    <tr>
      <td height="30">经度：
      <input name="longitude" id="longitude"  type="text" size="20"  value="<%=buildList.get(id).getLongitude()%>"/></td>
      <td height="30">纬度：
      <input name="latitude" id="latitude"  type="text" size="20"  value="<%=buildList.get(id).getLatitude()%>"/></td>
    </tr>
    <tr>
      <td height="30">信息录入人：
        <input name="entryName" type="text" size="15" value="<%=buildList.get(id).getEntryName()%>" /></td>
     <td height="30">  录入时间：
      <input name="entryTime" type="text" size="20" value="<%=buildList.get(id).getEntryTime()%>"/></td>
    </tr>
    <tr>
      <!-- <td height="30">提交人：
      <input name="auditName" type="text" size="20" />提交时间：
      <input name="auditTime" type="text" size="20" /> -->
    <td height="30" colspan="2">   状态标记：
      <select name="status" size="1">
       <option value="0">录入</option>
        <option value="1">提交</option>
      </select></td>
    </tr>
    <tr>
      <td height="30" colspan="2">备注：
      <input name="remarks" type="text" size="50" value="<%=buildList.get(id).getRemarks()%>"/></td>
    </tr>
    <tr>
      <td height="40"><div align="center">
        <input type="submit" name="Submit" value="保存" />
      </div></td>
      <td height="30">
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