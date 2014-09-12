<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.*,java.text.*"%>
<%
String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
String managername=(String)session.getAttribute("managername");

LandAction landaction=new LandAction();

List<LandSellway> LSWList=landaction.sellwayList();

RegionAction region=new RegionAction();
List<Region> regionList=region.regionList(); 

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
-->
</style>
</head>
<script language="JavaScript" type="text/javascript">
function Checkdate(dateinput) {
            var ret = true;
            var a=/^(1[0-9][0-9][0-9]|2[0-9][0-9][0-9])(\-)(0[1-9]|1[0-2])(\-)(0[1-9]|[1-2][0-9]|3[0-1])$/;
            //var dateinput=document.getElementById("announceTime").value;
            if(dateinput=="")
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
<body>
<form id="form1" name="form1" method="post" onsubmit="return Check()" action="LandServlet?flag=1">
<div id="Layer1">
<table width="100%" height="40" border="0" style="border-right:0px ;border-bottom:0px ;">
  <tr>
      <th colspan="2"><div align="center" class="STYLE1"> 土地基本信息</div></th>
    </tr>
</table>
  <table width="100%" height="300" >
    <tr>
      <td colspan="2"><span class="notnull">*</span>土地位置：
        <input name="address" id="address" type="text" size="40" /></td>
    </tr>
     <tr>
      	<td>地块编号：
        <input name="landNumber" id="landNumber" type="text" size="20" /></td>
        <td>土地区域：
        <select name="regionId" size="1">
            <%for(int j=0;j<regionList.size();j++){ %>
            <option value="<%=regionList.get(j).getRegionId()%>"><%= regionList.get(j).getRegionName()%></option>
            <% }%>
        </select>      </td>
    </tr>
     <tr>
      <td>出让公告日期：
        <span title="日期格式为：yyyy-mm-dd"><input id="announceTime" name="announceTime" type="text" size="20" onblur="Checkdate(this.value);" placeholder="日期格式为：yyyy-mm-dd"/> </span></td>
      <td>成交日期：
       <span title="日期格式为：yyyy-mm-dd"> <input id="zpgTime" name="zpgTime" type="text" size="20" onblur="Checkdate(this.value);" placeholder="日期格式为：yyyy-mm-dd"/> </span></td>
    </tr>
     <tr>
      <td>土地总面积：
        <input name="landAllarea" type="text" size="20" />m<sup>2</sup> </td>
      <td>规划总建筑面积：
        <input name="planAllarea" type="text" size="20"/>m<sup>2</sup></td>
    </tr>
     <tr>
      <td height="30" colspan="2">容积率：
      <input name="plotRatio" type="text" size="10" />
      建筑密度：
      <input name="buildingDensity" type="text" size="10" />
      绿化率：
      <input name="greeningRatio" type="text" size="10"  /></td>
    </tr>
    <tr>
      <td width="325">取得方式：
         <select name="landSellway" size="1">
            <%for(int i=0;i<LSWList.size();i++){ %>
            <option value="<%=LSWList.get(i).getSellwayId()%>"><%= LSWList.get(i).getSellwayName()%></option>
            <% }%>
        </select></td>
      <td width="325">成交总价：
   <span title="保留四位小数"><input name="dealTotle" type="text" size="20" placeholder="保留四位小数"/>万元</span></td>
    </tr>
    <tr>
    	<td width="325">有无划拨：
         <select name="allotFlag" size="1">
            <option value="1"> 有</option>
            <option value="0"> 无</option>
        </select></td>
      <td>竞得单位：
        <input name="buyer" id="buyer" type="text" size="20" /></td>
    </tr>
       
      <tr>
      <td>信息录入人：
       <input name="entryName" type="text" size="15" value="<%=managername%>" /></td>
      <td> 录入时间：
       <input name="entryTime" type="text" size="15" value="<%=datetime%>" /></td>
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
