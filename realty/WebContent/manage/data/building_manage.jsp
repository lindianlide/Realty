<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.List;"%>

<%
BuildingAction building=new BuildingAction();
List<Building> buildingList=building.buildingList();
List<BuildingIntro> buildintroList=building.buildingintroList();
RegionAction regionaction=new RegionAction();
List<Region> regionList=regionaction.regionList();
//List<Floor> buildinfloorList=building.floorList();
int pageSize=10;
int index=0;
int introid=0;
int floorid=0;
int count=buildingList.size();
if(count%pageSize==0&&count!=0)
 index=count/pageSize;
else {
	index=count/pageSize+1;
	}
String pageNos=request.getParameter("pageNo");	
if(pageNos==null){
	pageNos="1";
}
if(pageNos==""){
	pageNos="1";
}
int pageNo=Integer.parseInt(pageNos);
if(pageNo<1){
	pageNo=1;
	}else if(pageNo>index){
		pageNo=index;
	}
List<Building> pagelist=building.buildingList(pageNo, pageSize);
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
<link rel="stylesheet" rev="stylesheet" href="./css/manstyle.css" type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href="./css/web.css" type="text/css" media="all" />

<title>Insert title here</title>
 <script type="text/javascript" src="js/jquery.js"></script>
 <script type="text/javascript">
 var xmlHttp;
		function createXmlHttpRequest() {
			if (window.ActiveXObject) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest();
			}
		}
		//回调
		function handleStateChange() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					parseResults();
				}
			}
		}
		//将后台返回的数据显示在层serverResponse中
		function parseResults() {
		     document.getElementById("content").innerHTML=xmlHttp.responseText;//将返回的请求文本Text写入指定的DIV中
		}
</script>
<script type="text/javascript">


function del_sure(){ 
var gnl=confirm("确定要删除吗?"); 
if (gnl==true){ 
return true; 
} 
else{ 
return false; 
} 
} 
function passpageNo(){ 
 	var gopageNo = document.getElementById("gopageNo").value; 	
	document.form.action="manage/data/building_manage.jsp?pageNo="+gopageNo;
	document.form.submit();
}
var req;
var searchChar = new Array();
for(var i=0;i<4;i++){
	searchChar[i]=0;
}
function bb(num,con){
	 switch(num){
	  case 0: searchChar[0]=con;
	  break;
	  case 1: searchChar[1]=con;
	  break;
	  case 2: searchChar[2]=con;
	  break;
	  case 3: searchChar[3]=con;
	  break;
	 }
	 for(var i=0;i<13;i++){
		 var region1 = "0" + i;
		 document.getElementById(region1).style.color="black";
	 }
	 for(var i=0;i<5;i++){
		 var type1 = "1" + i;
		 document.getElementById(type1).style.color="black";
	 }
	 for(var i=0;i<5;i++){
		 var price1 = "2" + i;
		 document.getElementById(price1).style.color="black";
	 }
	 var region="0"+searchChar[0];
	 document.getElementById(region).style.color="red";
	 var type="1"+searchChar[1];
	 document.getElementById(type).style.color="red";
	 var price="2"+searchChar[2];
	 document.getElementById(price).style.color="red";
	 
	 var url = "BuildingServlet";
			createXmlHttpRequest();
			xmlHttp.open("POST", url, true);
			xmlHttp.onreadystatechange = handleStateChange;//回调
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;text/xml;charset=utf-8"); //text/xml;charset=utf-8：解决汉字封装json问题
			xmlHttp.send("searchChar="+searchChar+"&flag=3");		
}
</script>
 <style type="text/css">
 #search {
	position:absolute;
	width:745px;
	height:120px;
	z-index:1;
	left: 85px;
	top: 11px;
	font-size:13px;
	margin:0 auto;
	background: #eee;
	}
  #content{
	position:absolute;
	width:940px;
	height:500px;
	z-index:2;
	left: 85px;
	top: 150px;
	/*border: 1px solid #000;*/  
	}
 </style>
</head>

<body class="home">
<form name="form" method="post" action="">
<div id="search">
  <blockquote>
    <p>区域：
	<a id="00" href="javascript:void(0);" onclick="bb(0,00)">全部</a> &nbsp;
	<% for(int k=1;k<regionList.size();k++){
		String k1="0"+k;
	%>
	<a id="<%=k1%>" href="javascript:void(0);" onclick="bb(0,<%=k%>)"><%=regionList.get(k).getRegionName()%></a> &nbsp;
	<%} %>
	</p>
	<!-- <a id="01" href="javascript:void(0);" onclick="bb(0,01)">市南</a> &nbsp;
	<a id="02" href="javascript:void(0);" onclick="bb(0,02)">市北</a> &nbsp;
	<a id="03" href="javascript:void(0);" onclick="bb(0,03)">崂山</a> &nbsp;
	<a id="04" href="javascript:void(0);" onclick="bb(0,04)">李沧</a>&nbsp;
	<a id="05" href="javascript:void(0);" onclick="bb(0,05)">城阳</a> &nbsp;
	<a id="06" href="javascript:void(0);" onclick="bb(0,06)">黄岛</a> &nbsp;
	<a id="07" href="javascript:void(0);" onclick="bb(0,07)">即墨市</a> &nbsp;
	<a id="08" href="javascript:void(0);" onclick="bb(0,08)">胶州市</a> &nbsp;
	<a id="09" href="javascript:void(0);" onclick="bb(0,09)">胶南市</a> &nbsp;
	<a id="010" href="javascript:void(0);" onclick="bb(0,10)">平度市</a> &nbsp;
	<a id="011" href="javascript:void(0);" onclick="bb(0,11)">莱西市</a>&nbsp;
	<a id="012" href="javascript:void(0);" onclick="bb(0,12)">其他</a></p> -->
	<p>用途：
	<a id="10" href="javascript:void(0);" onclick="bb(1,0)">全部</a> &nbsp;
	<a id="11" href="javascript:void(0);" onclick="bb(1,1)">住宅</a>&nbsp;
	 <a id="12" href="javascript:void(0);" onclick="bb(1,2)">商用</a>&nbsp;
	  <a id="13" href="javascript:void(0);" onclick="bb(1,3)">办公</a>&nbsp;
	   <a id="14" href="javascript:void(0);" onclick="bb(1,4)">其他</a></p>
    <p>价格：
	<a id="20" href="javascript:void(0);" onclick="bb(2,0)">全部</a>&nbsp; 
	<a id="21" href="javascript:void(0);" onclick="bb(2,1)">6000以下</a>&nbsp;
	 <a id="22" href="javascript:void(0);" onclick="bb(2,2)">6000--8000</a>&nbsp;
	  <a id="23" href="javascript:void(0);" onclick="bb(2,3)">8000--12000</a>&nbsp;
	   <a id="24" href="javascript:void(0);" onclick="bb(2,4)">12000以上</a></p>
<!--     <p>面积：
	<a href="javascript:void(0);" onclick="bb(3,0)">50以下</a> &nbsp;
	<a href="javascript:void(0);" onclick="bb(3,1)">50--70</a>&nbsp;
	<a href="javascript:void(0);" onclick="bb(3,2)">70--90</a> &nbsp;
	<a href="javascript:void(0);" onclick="bb(3,3)">90--110</a> &nbsp;
	<a href="javascript:void(0);" onclick="bb(3,4)">110--130</a> &nbsp;
	<a href="javascript:void(0);" onclick="bb(3,5)">130--150</a> &nbsp;
	<a href="javascript:void(0);" onclick="bb(3,6)">150以上</a></p> -->
  </blockquote>
</div>
<div id="content" class="content">
					<table width="742" cellpadding=0 cellspacing=0 >
		      		   <tr>
	      			    <td>楼盘名</td>
	      			    <td>开盘时间</td>
	      			    <td>占地面积</td>
	      			    <td>价格</td>
	      			    <td>操作</td>
	      			   </tr>
	      			   <%for(int i=0;i<pagelist.size();i++){ 
		      			   for(int j=0;j<buildintroList.size();j++){
					if(buildintroList.get(j).getBuildingId()==pagelist.get(i).getBuildingId()){
						{
							introid=buildintroList.get(j).getBuildintroId();
							 break;
							}
					}
/* 					for(int n=0;n<buildinfloorList.size();n++){
						if(buildinfloorList.get(n).getBuildingId()==pagelist.get(i).getBuildingId()){
							{
								floorid=buildinfloorList.get(n).getFloorId();
								 break;
								}
						}
				} */
		      			   }
	      			 %>	      			   
	      			 
	      			 <tr>
		      			    <td><a href="manage/data/building_details.jsp?buildingId=<%=pagelist.get(i).getBuildingId()%>"> <span><%=pagelist.get(i).getBuildingName()%></span></a></td>
		      			    <td><span><%=pagelist.get(i).getOpenTime() %></span></td>
		      			    <td><span><%=pagelist.get(i).getFloorArea() %></span></td>
		      			    <td><span><%=pagelist.get(i).getAveragePrice() %></span></td>
		      			    <td><a href="BuildingServlet?flag=4&buildintroId=<%=introid%>&buildingId=<%= pagelist.get(i).getBuildingId()%>"  onclick="return del_sure()"><span>删除</span></a>  <a href="manage/data/building_modify.jsp?buildintroId=<%=introid%>&buildingId=<%=pagelist.get(i).getBuildingId() %>"><span>修改</span></a></td>
		      			   </tr>
		      			   <%} %>
		      			    </table>
    <table style="border:0px;" width="650" height="40">
        <tr>
          <td style="border-left:0px; border-top:0px ;height:5px;" height="6"><img src="images/manage/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td style="border:0px;" height="20">
          <table style="border:0px;"  width="100%" class="right-font08">
              <tr>
                <td style="border:0px;" width="50%">共 <span class="right-text09"><%=index%></span> 页 | 第 <span class="right-text09"><%=pageNo%></span> 页</td>
                <td style="border:0px;" width="48%" align="right">[<a href="manage/data/building_manage.jsp?pageNo=1" class="right-font08">首页</a> | <a href="manage/data/building_manage.jsp?pageNo=<%=pageNo-1%>" class="right-font08">上一页</a> | <a href="manage/data/building_manage.jsp?pageNo=<%=pageNo+1%>" class="right-font08">下一页</a> | <a href="manage/data/building_manage.jsp?pageNo=<%=index%>" class="right-font08">末页</a>] 转至：</td>
                <td style="border:0px;" width="2%">
                <table style="border:0px;" width="29">
                    <tr>
                      <td style="border:0px;" width="1%"><input id="gopageNo" type="text" class="textfield" size="1" /></td>
                      <td style="border:0px;" width="87%"><input name="pagego" type="button" class="right-button06" onclick="passpageNo()" />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table>

</div>	
</form>
</body>
<script type="text/javascript">
document.getElementById("00").style.color="red";
document.getElementById("10").style.color="red";
document.getElementById("20").style.color="red";
</script>
</html>