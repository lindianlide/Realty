<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,com.realty.base.dao.impl.*,java.text.SimpleDateFormat,java.util.List;"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<%
BuildingAction buildingaction=new BuildingAction();
//List<Building> buildingList=buildingaction.buildingList();


String buildingId=request.getParameter("buildingId");
int j=0;
int id=Integer.parseInt(buildingId);

/* for(int i=0;i<buildingList.size();i++){
	if(buildingList.get(i).getBuildingId()==id)	
	{ j=i;
	  break;
		}	
} */
List<Building> buildingList=buildingaction.buildingList(id);
String landuseTimes="";
String opentimes="";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
landuseTimes=sdf.format(buildingList.get(j).getLanduseTime());
if(landuseTimes.equals("0001-01-01")){
	landuseTimes="";
}

landuseTimes=sdf.format(buildingList.get(j).getOpenTime());
if(opentimes.equals("0001-01-01")){
	opentimes="";
}
RegionAction regionaction=new RegionAction();
String regionName=null;
regionName=regionaction.regionSearch(buildingList.get(j).getRegionId());
BuildingUsageAction buildingusageaction=new BuildingUsageAction();
String usageName=null;
usageName=buildingusageaction.buildingusageSearch(buildingList.get(j).getUsageId());

BuildingStructureAction structureaction=new BuildingStructureAction();
String structureName=null;
structureName=structureaction.buildingstructureSearch(buildingList.get(j).getStructureId());

BuildingFormAction formaction=new BuildingFormAction();
String formName=null;
formName=formaction.buildingformSearch(buildingList.get(j).getFormId());

BuildingDecorateAction decorateaction=new BuildingDecorateAction();
String decorateName=null;
decorateName=decorateaction.buildingdecorateSearch(buildingList.get(j).getDecorateId());

int buildingphId=110;
String locationpath=null;
String buildingppath=null;
String planpath=null;
String typepath=null;
String locationPhoto="building_locationphoto";
String buildingPhoto="building_photo";
String planPhoto="building_planphoto";
String typePhoto="building_typephoto";
List locationList=buildingaction.buildingPhoto(id,locationPhoto);
int locationsize=locationList.size();
if(locationsize==0)
	locationpath="000.jpg";	

List buildingpList=buildingaction.buildingPhoto(id,buildingPhoto);
int buildingsize=buildingpList.size();
if(buildingsize==0)
	buildingppath="000.jpg";	

List planList=buildingaction.buildingPhoto(id,planPhoto);
int plansize=planList.size();
if(plansize==0)
	planpath="000.jpg";	

List typeList=buildingaction.buildingPhoto(id,typePhoto);
int typesize=typeList.size();
if(typesize==0)
	typepath="000.jpg";	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PhvZF9yCpEwS4FSljdGm7f7A"></script>
<title>Insert title here</title>
<base href="<%=basePath%>">
<link rel="stylesheet" rev="stylesheet" href="./css/manstyle.css" type="text/css" media="all" />
<style type="text/css">
table{border-right:1px solid #000000;border-bottom:1px solid#000000;}
td{border-top:1px solid #000000;border-left:1px solid #000000;}
#Layer1 {
	position:absolute;
	width:450px;
	height:400px;
	z-index:1;
	left: 750px;
	top: 150px;
}
</style>
</head>
<body>
<form id="form1" name="form1" method="post" ENCTYPE="multipart/form-data" action="BuildingServlet?flag=1">
  <table width="663" height="516"  cellpadding=0 cellspacing=0 align="center">
    <tr>
      <td width="289">楼盘名：
       <span><%=buildingList.get(j).getBuildingName()%></span></td>
      <td width="358">楼盘别名：
         <span><%=buildingList.get(j).getBuildingAlias()%></span></td>
    </tr>
    <tr>
      <td>物业所在区域：
         <span><%=regionName%></span></td>
      <td>物业地址： <span><%=buildingList.get(j).getPropertyAdress()%></span>
      </td>
    </tr>
    <tr>
      <td>物业办公电话：
      <span><%=buildingList.get(j).getProPhone()%></span></td>
      <td>物业费：
      <span><%=buildingList.get(j).getPropertyFee()%></span></td>
    </tr>
    <tr>
      <td>附加信息：
      <span><%=buildingList.get(j).getProOtherinfor()%></span></td>
      <td>物业办公地点：
     <span><%=buildingList.get(j).getProWorkaddress()%></span></td>
    </tr>
    
    <tr>
      <td>物业名称： <span><%=buildingList.get(j).getPropertyName()%></span>
     </td>
      <td>楼盘用途： <span><%=usageName%></span>
    </tr>
    <tr>
      <td>项目特色：
      <span><%=buildingList.get(j).getProjectFeature()%></span></td>
      <td>邮编：
     <span><%=buildingList.get(j).getZipCode()%></span></td>
    </tr>
    <tr>
      <td>竣工时间： <span><%=buildingList.get(j).getBuildingtimeFinish()%></span>
      </td>
      <td>开发商： <span><%=buildingList.get(j).getDevelopers()%></span>
     </td>
    </tr>
    <tr>
      <td>占地面积： <span><%=buildingList.get(j).getFloorArea()%>m<sup>2</span>
     </td>
      <td>建筑面积： <span><%=buildingList.get(j).getBuildingArea()%>m<sup>2</span>
      </td>
    </tr>
    <tr>
      <td>建筑结构： <span><%=structureName%></span>
      </td>
      <td>建筑形态： <span><%=formName%></span>
      </td>
    </tr>
    <tr>
      <td colspan="3">容积率： <span><%=buildingList.get(j).getPlotRatio()%></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <span> 土地使用年限：<%=landuseTimes%></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		       <span> 建筑密度：<%=buildingList.get(j).getBuildingDensity()%></span>
       </td>
    </tr>
    <tr>
      <td colspan="3">绿化率： <span><%=buildingList.get(j).getGreeningRate()%></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     
      车位配比： <span><%=buildingList.get(j).getParkingRatio()%></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

      交房装修情况： <span><%=decorateName%></span>
     </td>
    </tr>
    <tr>
      <td>开盘时间： <span><%=opentimes%>元</span>
      </td>
      <td>物业服务： <span><%=buildingList.get(j).getPropertyService()%></span>
     </td>
    </tr>
    <tr>
      <td>开盘价格（起价）： <span><%=buildingList.get(j).getInitialPrice()%>元</span>
     </td>
      <td>开盘价格（均价）： <span><%=buildingList.get(j).getAveragePrice()%>元</span>
     </td>
    </tr>
    <tr>
      <td>房屋单价： <span><%=buildingList.get(j).getPerPrice()%>元</span>
     </td>
      <td>房屋总价： <span><%=buildingList.get(j).getTotalPrice()%>元</span>
    </td>
    </tr>
    <tr>
       <td style="font-size:15px;font-weight:800;" align="center" colspan="2"><a href="manage/data/photo_buildlocation.jsp?buildingId=<%=buildingId%>"><font color="blue">楼盘位置图</font></a>      
      </td>
    </tr>
        <tr>
       <td style="font-size:15px;font-weight:800;" align="center" colspan="2"><a href="manage/data/photo_building.jsp?buildingId=<%=buildingId%>"><font color="blue">楼盘照片</font></a>      
      </td>
    </tr>
    <tr>
             <td style="font-size:15px;font-weight:800;" align="center" colspan="2"><a href="manage/data/photo_buildtype.jsp?buildingId=<%=buildingId%>"><font color="blue">户型图</font></a>      
      </td>
    </tr>
        <tr>
             <td style="font-size:15px;font-weight:800;" align="center" colspan="2"><a href="manage/data/photo_buildplan.jsp?buildingId=<%=buildingId%>"><font color="blue">平面图</font></a>      
      </td>
    </tr>
    <tr>
      <td>经度： <span id="lngcontent"><%=buildingList.get(j).getLongitude()%></span>
     </td>
      <td>纬度： <span id="latcontent"><%=buildingList.get(j).getLatitude()%></span>
     </td>
    </tr>
    <tr>
      <td>信息录入人： <span><%=buildingList.get(j).getEntryName()%></span></td>     
      <td>录入时间： <span><%=buildingList.get(j).getEntryTime()%></span></td>
    </tr>
    <tr>
      <td colspan="2">提交人： <span><%=buildingList.get(j).getAuditName()%></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     提交时间： <span><%=buildingList.get(j).getAuditTime()%></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     
      状态标记： <span><%=buildingList.get(j).getStatus()%></span>
      </td>
    </tr>
    <tr>
      <td colspan="2">备注： <span><%=buildingList.get(j).getRemarks()%></span>
      </td>
    </tr>
    
  </table>
  <div id="Layer1"></div>
</form>
</body>
<script type="text/javascript">
var map = new BMap.Map("Layer1");
map.centerAndZoom(new BMap.Point(120.438398, 36.144194), 12);
map.addControl(new BMap.NavigationControl()); //添加平移缩放控件
map.addControl(new BMap.ScaleControl());  //添加放大、缩小控件
map.enableScrollWheelZoom();//允许鼠标滑轮操作

var lng = document.getElementById("lngcontent").innerHTML;
var lat = document.getElementById("latcontent").innerHTML;

var point =new BMap.Point(lng , lat);
map.centerAndZoom(point, 15);
var myIcon = new BMap.Icon("images/manage/02.png", new BMap.Size(30,30));
var marker = new BMap.Marker(point,{icon:myIcon});  // 创建标注
map.addOverlay(marker);
marker.setTitle("<%=buildingList.get(j).getBuildingName()%>");
 
</script>
</html>