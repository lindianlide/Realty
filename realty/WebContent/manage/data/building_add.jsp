<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.*,java.text.*"%>
<%
String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
String managername=(String)session.getAttribute("managername");
BuildingDecorateAction BD=new BuildingDecorateAction();
List<BuildingDecorate> BDList=BD.buildingdecorateList();

BuildingFormAction BF=new BuildingFormAction();
List<BuildingForm> BFList=BF.buildingformList();

RegionAction region=new RegionAction();
List<Region> regionList=region.regionList();

BuildingUsageAction BU=new BuildingUsageAction();
List<BuildingUsage> BUList=BU.buildingusageList();

BuildingStructureAction BS=new BuildingStructureAction();
List<BuildingStructure> BSList=BS.buildingstructureList();
int i=0; 
%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加管理员</title>
<base href="<%=basePath%>">
<link href="css/manstyle.css" type="text/css" rel="stylesheet">
<style type="text/css">
<!--
.STYLE1 {
	font-size: 22px;
	font-family: "宋体";
}
#Layer1 {
	margin-left: auto;
	margin-right: auto;
	width:663px;
	height:340px;
	z-index:1;
	left: 4px;
	top: 15px;
}
#div1 {
display:inline;
width: 76px;
height: 18px;
border: 1px solid red;
position: relative;
background-color: black;
left: 30px;
top: 0px;
}
-->
</style>
<script type="text/javascript">
   function  Check(){
	       var buildingName = document.getElementById("buildingName").value;
	       if(buildingName==null||buildingName==""){
	   	     alert("楼盘名不能为空！");
	      	 return false;
	      	 }
	  	 return true;
   }
</script>
</head>
<body>
<form id="form1" name="form1" method="post" onsubmit="return Check()" action="BuildingServlet?flag=1">
<div id="Layer1">
<table width="100%" height="40" border="0" style="border-right:0px ;border-bottom:0px ;">
  <tr>
      <th colspan="2"><div align="center" class="STYLE1"> 基本信息</div></th>
    </tr>
</table>
  <table width="100%" height="300" cellpadding=0 cellspacing=0  >
    <tr>
      <td width="325"><span class="notnull">*</span>楼盘名：
        <input name="buildingName" id="buildingName"  type="text" size="20" onblur="Check();"/>
        </td>
      <td width="325">楼盘别名：
        <input name="buildingAlias" type="text" size="20" /></td>
    </tr>
    <tr>
      <td>物业所在区域：
        <select name="regionId" size="1">
            <%for(i=0;i<regionList.size();i++){ %>
            <option value="<%=regionList.get(i).getRegionId()%>"><%= regionList.get(i).getRegionName()%></option>
            <% }%>
        </select>      </td>
      <td>物业地址：
        <input name="propertyAdress" type="text" size="30" /></td>
    </tr>
    <tr>
      <td>物业名称：
        <input name="propertyName" type="text" size="20" /></td>
      <td>楼盘用途：
        <select name="usageId" size="1">
            <%for(i=0;i<BUList.size();i++){ %>
            <option value="<%=BUList.get(i).getUsageId()%>"><%=BUList.get(i).getUsageName()%></option>
            <%} %>
        </select></td>
    </tr>
    <tr>
      <td>开发商：
        <input name="developers" type="text" size="20" /></td>
      <td>占地面积：
        <input name="floorArea" type="text" size="15" value=""/>m<sup>2</sup></td>
    </tr>
    <tr>
      <td>建筑面积：
        <input name="buildingArea" type="text" size="15" value=""/>m<sup>2</sup></td>
       <td>建筑结构：
        <select name="structureId" size="1">
        <%for(i=0;i<BSList.size();i++){ %>
         <option value="<%=BSList.get(i).getStructureId()%>"><%=BSList.get(i).getStructureName()%></option>
		<%} %>
        </select></td>
    </tr>
    <tr>
     <td height="30">建筑形态：
        <select name="formId" size="1">
        <%for(i=0;i<BFList.size();i++){ %>
        <option value="<%=BFList.get(i).getFormId()%>"><%=BFList.get(i).getFormName()%></option>
        <%} %>
        </select></td>
      <td>交房装修情况：
        <select name="decorateId" size="1">
          <%for(i=0;i<BDList.size();i++){ %>
          <option value="<%=BDList.get(i).getDecorateId()%>"><%=BDList.get(i).getDecorateName() %></option>
          <%} %>
        </select></td>
    </tr>
     
      <tr>
      <td>信息录入人：
       <input name="entryName" type="text" size="15" value="<%=managername%>"/></td>
      <td> 录入时间：
       <input name="entryTime" type="text" size="15" value="<%=datetime%>"/></td>
    </tr>
   <!-- <tr>
      <td colspan="2">提交人：
        <input name="auditName" type="text" size="20" />
        提交时间：
        <input name="auditTime" type="text" size="20" />
        状态标记：
        <select name="status" size="1">
          <option value="1">录入</option>
          <option value="2">提交</option>
        </select></td>
    </tr>  -->
    <tr>
      <td colspan="2">备注：
        <input name="remarks" type="text" size="50" /></td>
    </tr>
    <tr>
      <td height="40"><div align="center">
          <input type="submit" name="Submit" value="保存" />
      </div></td>
      <td height="30"><div align="center">
          <input type="reset" name="Submit2" value="重置" />
      </div></td>
    </tr>
  </table>
</div>
</form>
</body>

</html>
