<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,com.realty.base.dao.impl.*,java.util.List;"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<%
SecondAction secondaction=new SecondAction();
List<Secondhouse> secondList=secondaction.secondList();
String houseId1=request.getParameter("houseId");
int houseId=Integer.parseInt(houseId1);
int id=0;
for(int i=0;i<secondList.size();i++){
	if(secondList.get(i).getHouseId()==houseId)	
	{ id=i;
	  break;
		}	
}
RegionAction regionaction=new RegionAction();
String regionName=null;
regionName=regionaction.regionSearch(secondList.get(id).getRegionId());

BuildingStructureAction structureaction=new BuildingStructureAction();
String structureName=null;
structureName=structureaction.buildingstructureSearch(secondList.get(id).getStructureId());

BuildingDecorateAction decorateaction=new BuildingDecorateAction();
String decorateName=null;
decorateName=decorateaction.buildingdecorateSearch(secondList.get(id).getDecorateId());

String usageName=null;
usageName=secondaction.secondusageSearch(secondList.get(id).getUsageId());

String pricetypeName=null;
pricetypeName=secondaction.pricetypeSearch(secondList.get(id).getPricetypeId());

String taxtypeName=null;
taxtypeName=secondaction.taxtypeSearch(secondList.get(id).getTaxtypeId());
String typepath=null;
String decoratepath=null;
String typephoto ="setype_photo";
String decoratephoto="sedecorate_photo";
List typeList=secondaction.secondPhoto(houseId, typephoto);
int typesize=typeList.size();
if(typesize==0)
	typepath="000.jpg";	


List decorateList=secondaction.secondPhoto(houseId, decoratephoto);
int decoratesize=decorateList.size();
if(decoratesize==0)
	decoratepath="000.jpg";	

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
  <table width="663" height="686" cellpadding=0 cellspacing=0 align="center">
 <tr>
      <td colspan="2">二手房名字：
         <span><%=secondList.get(id).getHouseName()%></span> </td>
    </tr>
  <tr>
      <td width="330">物业所在区域： <span><%=regionName%></span> </td>
      <td width="333">物业地址：
        <span><%=secondList.get(id).getPropertyAdress()%></span> </td>
    </tr>
    <tr>
      <td>物业名称：      
        <span><%=secondList.get(id).getPropertyName()%></span> </td>
      <td>房屋用途：
       <span><%=usageName%></span> </td>
        
    </tr>
    <tr>
      <td>建筑结构：
       <span><%=structureName%></span> </td>
      
      <td>赠送面积： <span><%=secondList.get(id).getPresent()%></span> </td>
    </tr>
    <tr>
      <td>装修情况： <span><%=decorateName%></span> </td>
       
      <td>建成年代： <span><%=secondList.get(id).getBuildingTime()%></span> </td>
    </tr>
    <tr>
      <td>总层数： <span><%=secondList.get(id).getFloorTotle()%></span> </td>
       <td>所在名义层 ： <span><%=secondList.get(id).getFloorSaid()%></span> </td>
    </tr>
    <tr>
      <td>所在实际层 ： <span><%=secondList.get(id).getFloorActual()%></span> </td>
      <td>得房率： <span><%=secondList.get(id).getRoomRate()%></span> </td>
    </tr>
    <tr>
      <td>户型： <span><%=secondList.get(id).getHouseType()%></span> </td>
      <td>单户朝向： <span><%=secondList.get(id).getOrientation()%></span> </td>
    </tr>
    <tr>
      <td width="330" >交易时间： <span><%=secondList.get(id).getExchangeTime()%></span> </td>
      <td width="333">建筑面积： <span><%=secondList.get(id).getBuildingArea()%></span> </td>
    </tr>
    <tr>
      <td>交易单价： <span><%=secondList.get(id).getExchangePrice()%>元</span> </td>
      <td>交易总价： <span><%=secondList.get(id).getExchangeTotle()%>元</span> </td>
    </tr>
    <tr>
      <td>价格类型： <span><%=pricetypeName%></span> </td>
        
      <td>税费承担方式 ： <span><%=taxtypeName%></span> </td>
        
    </tr>
    <tr>
      <td>税费合计： <span><%=secondList.get(id).getTaxTotle()%></span> </td>
      <td>卖方税费： <span><%=secondList.get(id).getTaxSeller()%></span> </td>
    </tr>
    <tr>
      <td>买方税费： <span><%=secondList.get(id).getTaxBuyer()%></span> </td>
      <td>二手房上架时间： <span><%=secondList.get(id).getSaleTime()%></span> </td>
    </tr>
    <tr>
      <td colspan="2">实例简介：       <span><%=secondList.get(id).getIntroduction()%></span> </td>
    </tr>
    
     <tr>
      <td height="30" colspan="2">户型图：    
      <%
      if(typesize!=0)
      for(int k=0;k<typesize;k++)
      {
      %>
      <img style="width:200px;height:250px;" src="/realty/picupload/second/<%=(String)typeList.get(k)%>"/>
      <%}
      %>
      </td>
    </tr>
        <tr>
      <td height="30" colspan="2">装修图：       
       <%
      if(decoratesize!=0)
      for(int k=0;k<decoratesize;k++)
      {
      %>
      <img style="width:200px;height:250px;" src="/realty/picupload/second/<%=(String)decorateList.get(k)%>"/>
      <%}
      %>
      </td>
    </tr>
     
    <tr>
      <td>经度： <span id="lngcontent"><%=secondList.get(id).getLongitude()%></span> </td>
      <td>纬度： <span id="latcontent"><%=secondList.get(id).getLatitude()%></span> </td>
    </tr>
    <tr>
      <td>信息录入人： <span><%=secondList.get(id).getEntryName()%></span> </td>
     <td>  录入时间： <span><%=secondList.get(id).getEntryTime()%></span> </td>
    </tr>
    <tr>
      <!-- <td>提交人：
      <input name="auditName" type="text" size="20" />提交时间：
      <input name="auditTime" type="text" size="20" /> -->
    <td colspan="2">   状态标记： <span><%=secondList.get(id).getStatus()%></span> </td>
    </tr>
    <tr>
      <td colspan="2">备注： <span><%=secondList.get(id).getRemarks()%></span> </td>
    </tr>
  </table>
  <div id="Layer1"></div>
</form>
</body>
<script type="text/javascript">
var map = new BMap.Map("Layer1");

var lng = document.getElementById("lngcontent").innerHTML;
var lat = document.getElementById("latcontent").innerHTML;

var point =new BMap.Point(lng , lat);
map.centerAndZoom(point, 15);
var myIcon = new BMap.Icon("images/manage/02.png", new BMap.Size(30,30));
var marker = new BMap.Marker(point,{icon:myIcon});  // 创建标注
map.addOverlay(marker);
marker.setTitle("新鑫花园 ");
 
</script>
</html>