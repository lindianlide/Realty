<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,com.realty.base.dao.impl.*,java.util.List;"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<%
String landId1=request.getParameter("landId");
int landId=Integer.parseInt(landId1);

LandzpgAction landzpgaction=new LandzpgAction();
List<LandMutiusage> landzpg=landzpgaction.landzpgsearch(landId);

int zpgnums=landzpg.size();
LandAction landaction=new LandAction();

LandallotAction landallotaction=new LandallotAction();
List<LandAllot> landallot=landallotaction.landallotsearch(landId);
int allotnums=landallot.size();

Land landList=landaction.findById(landId);
RegionAction region=new RegionAction();
List<Region> regionList=region.regionList();

int regionId=landList.getRegionId();
String landsellway=landList.getLandSellway().getSellwayName();
/*String regionName=null;
regionName=regionaction.regionSearch(landList.get(id).getRegionId());

String usageName=null;
usageName=landaction.landusageSearch(landList.get(id).getlandusageId());

String sellwayName=null;
sellwayName=landaction.sellwaySearch(landList.get(id).getlandsellwayId());

String possName=null;
possName=landaction.landpossSearch(landList.get(id).getlandpossId());

*/

String landphotopath=null;
String locationpath=null;
String landphoto ="land_photo";
String locationphoto="land_location";
List landphotoList=landaction.landPhoto(landId, landphoto);
int landphotosize=landphotoList.size();
if(landphotosize==0)
	landphotopath="000.jpg";	


List locationList=landaction.landPhoto(landId, locationphoto);
int locationsize=locationList.size();
if(locationsize==0)
	locationpath="000.jpg";	

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
	top: 250px;
}
</style>
</head>
<body style="overflow: auto;">
<form id="form1" name="form1" method="post" ENCTYPE="multipart/form-data" action="BuildingServlet?flag=1">
 
 <table width="150%" cellpadding=0 cellspacing=0 >
  <tr>
    <td>土地用途</td>
    <td>土地面积</td>
    <td>规划建筑面积</td>
    <td>土地级别</td>
    <td>出让年限</td>
    <td>楼面地价</td>
    <td>成交楼面地价</td>
  </tr>
  <%for(int m=0;m<zpgnums;m++){
String usageName=null;
usageName=landaction.landusageSearch(landzpg.get(m).getLandusageId());%>
  <tr>
    <td><%=usageName%></td>
    <td><%=landzpg.get(m).getLandArea()%></td>
    <td><%=landzpg.get(m).getPlanArea()%></td>
    <td><%=landzpg.get(m).getLandLevel()%></td>
    <td><%=landzpg.get(m).getUseyear()%></td>
    <td><%=landzpg.get(m).getInitialPrice()%></td>
    <td><%=landzpg.get(m).getDealPrice()%></td>
 </tr>
	<% } %> 
</table>
 
 </br>
 <table width="150%" cellpadding=0 cellspacing=0 >
  <tr>
    <td>土地用途</td>
    <td>土地面积</td>
    <td>规划建筑面积</td>
    <td>套数</td>
  </tr>
  <%for(int m=0;m<allotnums;m++){
String usageName=null;
usageName=landaction.landusageSearch(landallot.get(m).getLandusageId());%>
  <tr>
    <td><%=usageName%></td>
    <td><%=landallot.get(m).getLandArea()%></td>
    <td><%=landallot.get(m).getPlanArea()%></td>
    <td><%=landallot.get(m).getHousenum()%></td>
  </tr>
	<% } %> 
</table>
 </br>
  <table width="663" height="686" cellpadding=0 cellspacing=0 align="center">
   <tr>
      <td colspan="2"><span class="notnull">*</span>土地位置：
       <span> <%=landList.getAddress()%></span></td>
    </tr>
     <tr>
      <td>地块编号：<span> <%=landList.getLandNumber()%></span></td>
        <td>土地区域：<span> <%= regionList.get(regionId).getRegionName()%></span>
         </td>
    </tr>
     <tr>
      <td>出让公告日期：<span> <%=landList.getAnnounceTime()%></span> </td>
      <td>成交日期：<span> <%=landList.getZpgTime()%></span></td>
    </tr>
     <tr>
      <td>土地总面积：<span> <%=landList.getLandAllarea()%></span>m<sup>2</sup> </td>
      <td>规划总建筑面积：<span> <%=landList.getPlanAllarea()%></span>m<sup>2</sup></td>
    </tr>
     <tr>
      <td>出让楼面总地价：
      <% double intialPriceTol=0;
     	 intialPriceTol=landList.getInitialPrice();%>
       <span> <%=intialPriceTol%></span></td>
      <td>成交楼面总地价：
      <% double dealPriceTol=0;
     	 dealPriceTol=landList.getBuilddealPrice();%>
        <span><%=dealPriceTol%> </span></td>
    </tr>
   <tr>
         <%
	     String landNature=null;
	     if(landList.getAllotFlag()==1) 
	     	{
    	 	 landNature="出让、划拨";
     		}
             else
        	landNature="出让";
         %>
      <td>土地所有权性质：<span> <%=landNature%></span> </td>
     <%double premiumRate=0;
     if(intialPriceTol!=0)
    	 premiumRate=(dealPriceTol-intialPriceTol)/intialPriceTol;%>
      <td>溢价率：<span> <%=premiumRate%></span></td>
    </tr>
     <tr>
      <td height="30" colspan="2">容积率：<span> <%=landList.getPlotRatio()%></span>
      建筑密度：<span> <%=landList.getBuildingDensity()%></span>
      绿化率：<span> <%=landList.getGreeningRatio()%></span></td>
    </tr>
    <tr>
      <td width="325">取得方式：<span> <%= landsellway%></span></td>
      <td width="325">成交总价：<span> <%=landList.getDealTotle()%></span></td>
    </tr>
    <tr>
      <td colspan="2">竞得单位：<span> <%=landList.getBuyer()%></span></td>
    </tr>
     <tr>
      <td colspan="2">出让公告编号：<span> <%=landList.getSellAnnonumber()%></span> </td>
    </tr>    
    <tr>
    <%
    String filepath=this.getServletConfig().getServletContext().getInitParameter("landfileupload");
    %>
      <td colspan="2">出让公告文件：<span><%= filepath%><%=landList.getSellAnnounce()%></span>
        </td>
     </tr>
    <tr>
      <td colspan="2">成交公告编号：<span> <%=landList.getDealAnnonumber()%></span> </td>
    </tr> 
    <tr>
      <td colspan="2">成交公告文件：<span> <%= filepath%><%=landList.getDealAnnounce()%></span></td>
    </tr>
    <tr>
      <td style="font-size:15px;font-weight:800;" align="center" colspan="2"><a href="manage/data/land/photo_location.jsp?landId=<%=landId%>"><font color="blue">宗地位置图</font></a> </td>
    </tr>
    <tr>
      <td  style="font-size:15px;font-weight:800;" align="center" colspan="2"><a href="manage/data/land/photo_land.jsp?landId=<%=landId%>"><font color="blue">宗地照片 </font></a> </td>
    </tr>
  <tr>
      <td colspan="2">土地情况简介：<span><%=landList.getLandIntr()%></span></td>
    </tr> 
    <tr>
      <td colspan="2">项目情况介绍：<span><%=landList.getProjectIntro()%></span> </td>
    </tr> 
    <tr>
      <td height="30" >经度：<span id="lngcontent"> <%=landList.getLongitude()%></span></td>
      <td height="30">纬度：<span id="latcontent"> <%=landList.getLatitude()%></span></td>
    </tr>
    <tr>
      <td height="30">信息录入人：<span> <%=landList.getEntryName()%></span></td>
     <td height="30">  录入时间：<span> <%=landList.getEnrtyTime()%></span></td>
    </tr>
    <tr>
      <!-- <td height="30">提交人：
      <input name="auditName" type="text" size="20" />提交时间：
      <input name="auditTime" type="text" size="20" /> -->
    <td height="30" colspan="2">   状态标记：<span> <%=landList.getStatus()%></span>
      </td>
    </tr>
    <tr>
      <td height="30" colspan="2">备注： <span><%=landList.getRemarks()%></span></td>
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