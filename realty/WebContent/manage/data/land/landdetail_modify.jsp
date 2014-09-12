<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.List,java.util.Map"%>
<%
String landId1=request.getParameter("landId");
int landId=Integer.parseInt(landId1);
LandAction landaction=new LandAction();
String formName=null;
Land landList=landaction.findById(landId);
RegionAction region=new RegionAction();
List<Region> regionList=region.regionList();
List<LandSellway> LSWList=landaction.sellwayList();
List<LandUsage> LUList=landaction.landusageList();

int regionId=landList.getRegionId();
String landsellway=landList.getLandSellway().getSellwayName();
int landsellwayId=landList.getLandSellway().getSellwayId();


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
#addusage {
left: 6px;
top: 9px;
height: 30px;
width: 60px;
position: absolute;
}
#usage {
}
#usage1 {
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
function Check(){
	
	var address=document.getElementById("address").value;
	 if(address==""){
		 alert("土地位置不能为空！");
    	 return false;
	 }
	 return true;
	
}
</script>
<script language="JavaScript" type="text/javascript">
var landphotoph=0;
var locationph=0;
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
		$.ajaxFileUpload({
				
				url:"PictureServlet?category=3&flag=1&landId="+<%=landId%>,
				contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
				secureuri:false,
				cache: false,//防止缓存
				fileElementId:'locationphoto',
				dataType: 'text/xml',			
				success: function (data) {
				    document.getElementById("locationspan"+locationph).innerHTML = fileName;
					alert(fileName);
				},error: function (data, status, e){
					alert("fail");
				}
			}
		);
	}
	function fileupload2(){
		if($("#landphoto").val()==""){
			alert("上传文件不能为空!");
			return false;
		}
		//var f = document.getElementById("myfilePath");
		// alert(f.value);
		var file = $("#landphoto").val();
		var pos=file.lastIndexOf("\\");
		var fileName=file.substring(pos+1);  
		var suffixindex=file.lastIndexOf(".");
		var suffix=file.substring(suffixindex+1);  
		if(suffix!="jpg"&&suffix!="bmp"&&suffix!="gif"&&suffix!="png"&&suffix!="JPG"&&suffix!="BMP"&&suffix!="GIF"&&suffix!="PNG"){
			alert("上传文件类型不正确!");
			return false;
		}
		landphotoph++;
		$.ajaxFileUpload({
				
				url:"PictureServlet?category=3&flag=2&landId="+<%=landId%>,
				contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
				secureuri:false,
				cache: false,//防止缓存
				fileElementId:'landphoto',
				dataType: 'text/xml',			
				success: function (data) {
				    document.getElementById("landphotospan"+landphotoph).innerHTML = fileName;
					alert(fileName);
				},error: function (data, status, e){
					alert("fail");
				}
			}
		);
	}
	
	function fileupload3(){ 
		if($("#sellAnnounce").val()==""){
			alert("上传文件不能为空!");
			return false;
		}
		var file = $("#sellAnnounce").val();
		var pos=file.lastIndexOf("\\");
		var fileName=file.substring(pos+1);  
		$.ajaxFileUpload({
				
				url:"FileServlet?flag=5&landId="+<%=landId%>,
				contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
				secureuri:false,
				cache: false,//防止缓存
				fileElementId:'sellAnnounce',
				dataType: 'text/xml',			
				success: function (data) {
				    document.getElementById("sellAnnouncespan").innerHTML = fileName;
					alert(fileName);
				},error: function (data, status, e){
					alert("fail");
				}
			}
		);
	}
	
	function fileupload4(){
		if($("#dealAnnounce").val()==""){
			alert("上传文件不能为空!");
			return false;
		}
		var file = $("#dealAnnounce").val();
		var pos=file.lastIndexOf("\\");
		var fileName=file.substring(pos+1);  
		$.ajaxFileUpload({
				
				url:"FileServlet?flag=5&landId="+<%=landId%>,
				contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
				secureuri:false,
				cache: false,//防止缓存
				fileElementId:'dealAnnounce',
				dataType: 'text/xml',			
				success: function (data) {
				    document.getElementById("dealAnnouncespan").innerHTML = fileName;
					alert(fileName);
				},error: function (data, status, e){
					alert("fail");
				}
			}
		);
	}
</script>
<body>
<form id="form1" name="form1" method="post"  action="LandServlet?flag=2&landId=<%=landId%>">

  <table width="663" height="686" cellpadding=0 cellspacing=0 align="center">
   <tr>
      <td colspan="2"><span class="notnull">*</span>土地位置：
        <input name="address" id="address" type="text" size="40" value="<%=landList.getAddress()%>"/></td>
    </tr>
     <tr>
      <td>地块编号：
        <input name="landNumber" id="landNumber" type="text" size="20" value="<%=landList.getLandNumber()%>"/></td>
        <td>土地区域：
        <select name="regionId" size="1" onBlur="addarea(this.value)" >
         <option value="<%=regionList.get(regionId).getRegionId()%>"><%= regionList.get(regionId).getRegionName()%></option>
        <%for(int j=1;j<regionList.size();j++){ %>
          <option value="<%=regionList.get(j).getRegionId()%>"><%= regionList.get(j).getRegionName()%></option>
		<% }%>
        </select>      </td>
    </tr>
     <tr>
      <td>出让公告日期：
        <span title="日期格式为：yyyy-mm-dd"><input name="announceTime" type="text" size="20" value="<%=landList.getAnnounceTime()%>" onblur="Checkdate(this.value);" placeholder="日期格式为：yyyy-mm-dd"/> </span> </td>
      <td>成交日期：
       <span title="日期格式为：yyyy-mm-dd"> <input name="zpgTime" type="text" size="20" value="<%=landList.getZpgTime()%>" onblur="Checkdate(this.value);" placeholder="日期格式为：yyyy-mm-dd"/> </span>  </td>
    </tr>
     <tr>
      <td>土地总面积：
        <input name="landAllarea" type="text" size="20" value="<%=landList.getLandAllarea()%>"/>m<sup>2</sup> </td>
      <td>规划总建筑面积：
        <input name="planAllarea" type="text" size="20" value="<%=landList.getPlanAllarea()%>"/>m<sup>2</sup></td>
    </tr>
     <tr>
      <td height="30" colspan="2">容积率：
      <input name="plotRatio" type="text" size="10" value="<%=landList.getPlotRatio()%>"/>
      建筑密度：
      <input name="buildingDensity" type="text" size="10" value="<%=landList.getBuildingDensity()%>"/>
      绿化率：
      <input name="greeningRatio" type="text" size="10"  value="<%=landList.getGreeningRatio()%>"/></td>
    </tr>
    
     <tr>
      <td>出让楼面总地价：
       <!--  <input name="initialPriceTol" type="text" size="20" />元/m<sup>2</sup> -->
        <input name="initialPriceTol" value="<%=landList.getInitialPrice()%>"  onBlur="this.value=parseInt(this.value);if (isNaN(this.value) || this.value<0){alert('请保留整数');this.focus();};" placeholder="请保留整数"/>
      	     元/m<sup>2</sup> </td>
      <td>成交楼面总地价：
        <!-- <input name="dealPriceTol" type="text" size="20" /> -->
        <input name="dealPriceTol"  value="<%=landList.getBuilddealPrice()%>"  onBlur="this.value=parseInt(this.value);if (isNaN(this.value) || this.value<0){alert('请保留整数');this.focus();};" placeholder="请保留整数"/>
        	元/m<sup>2</sup></td>
    </tr>
    
    <tr>
      <td width="325">取得方式：
         <select name="landSellway" size="1">
         <option value="<%=landsellwayId%>"><%= landsellway%></option>
            <%for(int i=0;i<LSWList.size();i++){ %>
            <option value="<%=LSWList.get(i).getSellwayId()%>"><%= LSWList.get(i).getSellwayName()%></option>
            <% }%>
        </select></td>
      <td width="325">成交总价：
         <span title="保留四位小数"><input name="dealTotle" type="text" size="20" value="<%=landList.getDealTotle()%>" placeholder="保留四位小数"/></span>万元</td>
    </tr>
    <tr>
      <td colspan="2">竞得单位：
        <input name="buyer" id="buyer" type="text" size="40" value="<%=landList.getBuyer()%>"/></td>
    </tr>
     <tr>
      <td colspan="2">出让公告编号：
        <input name="sellAnnonumber" type="text" size="40" value="<%=landList.getSellAnnonumber()%>"/> </td>
    </tr>    
    <tr>
      <td colspan="2">出让公告文件：
       <span  id="sellAnnouncespan" ></span> 
      <input type="file" name="sellAnnounce" id="sellAnnounce" value="this.val()"/>
      <input type="button" name="fileLoad3" id="fileLoad3" value="上传" onClick="fileupload3()"/> </td>
     </tr>
    <tr>
      <td colspan="2">成交公告编号：
        <input name="dealAnnonumber" type="text" size="40" value="<%=landList.getDealAnnonumber()%>"/> </td>
    </tr> 
    <tr>
      <td colspan="2">成交公告文件：
       <span  id="dealAnnouncespan" ></span> 
      <input type="file" name="dealAnnounce" id="dealAnnounce" value="this.val()"/>
      <input type="button" name="fileLoad4" id="fileLoad4" value="上传" onClick="fileupload4()"/> </td>
    </tr>
    <tr>
      <td height="30" colspan="2">宗地位置图：
       <span  id="locationspan1" ></span> 
       <span  id="locationspan2" ></span> 
       <span  id="locationspan3" ></span> 
       <span  id="locationspan4" ></span> 
       <input type="file" name="locationphoto" id="locationphoto" value="this.val()"/>
      <input type="button" name="fileLoad1" id="fileLoad1" value="上传" onClick="fileupload1()"/>      </td>
    </tr>
    <tr>
      <td height="30" colspan="2">宗地照片：
       <span  id="landphotospan1" ></span> 
        <span  id="landphotospan2" ></span> 
         <span  id="landphotospan3" ></span> 
          <span  id="landphotospan4" ></span> 
          <span  id="landphotospan5" ></span> 
        <span  id="landphotospan6" ></span> 
         <span  id="landphotospan7" ></span> 
          <span  id="landphotospan8" ></span> 
          <span  id="landphotospan9" ></span> 
          <span  id="landphotospan10" ></span> 
          
       <input type="file" name="landphoto" id="landphoto" value="this.val()"/>
      <input type="button" name="fileLoad2" id="fileLoad2" value="上传" onClick="fileupload2()"/>      </td>
    </tr>
    <tr>
      <td colspan="2">土地情况简介：
        <input name="landIntr" type="text" size="80" value="<%=landList.getLandIntr()%>"/> </td>
    </tr> 
    <tr>
      <td colspan="2">项目情况介绍：
        <span title="对小区总楼栋个数，以及不同建筑形态的楼栋数、层数、价格及小区均价等情况做详细的说明。"><input name="projectIntro" type="text" size="80" value="<%=landList.getProjectIntro()%>" placeholder="对小区总楼栋个数，以及不同建筑形态的楼栋数、层数、价格及小区均价等情况做详细的说明。"/> </span></td>
    </tr> 
    <tr>
      <td height="30">经度：
      <input name="longitude" id="longitude" type="text" size="20"  value="<%=landList.getLongitude()%>"/></td>
      <td height="30">纬度：
      <input name="latitude" id="latitude" type="text" size="20"  value="<%=landList.getLatitude()%>"/></td>
    </tr>
    <tr>
      <td height="30">信息录入人：
        <input name="entryName" type="text" size="15" value="<%=landList.getEntryName()%>" /></td>
     <td height="30">  录入时间：
      <input name="entryTime" type="text" size="20" value="<%=landList.getEnrtyTime()%>"/></td>
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
       <input name="remarks" type="text" size="50" value="<%=landList.getRemarks()%>"/></td>
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