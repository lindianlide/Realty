<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.List;"%>

<%
 	String membername=(String)session.getAttribute("membername"); 
 %>
<%
LandAction land=new LandAction();
List<Land> landList=land.findAll();

int pageSize=10;
int index=0;
int count=landList.size();
if(count%pageSize==0)
 index=count/pageSize;
else {
	index=count/pageSize+1;
	}
String pageNos=request.getParameter("pageNo");	
if(pageNos==null){
	pageNos="1";
}
int pageNo=Integer.parseInt(pageNos);
if(pageNo<1){
	pageNo=1;
	}else if(pageNo>index){
		pageNo=index;
	}

List<Land> pagelist=land.findAllpage(pageNo, pageSize);
String sellway= land.sellwaySearch(pagelist.get(0).getLandSellway().getSellwayId());
String landusage =land.landusageSearch(pagelist.get(0).getLandUsage().getUsageId());
String landposs= land.landpossSearch(pagelist.get(0).getLandPoss().getLandpossId());

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
 <link rel="stylesheet" rev="stylesheet" href="./css/webstyle.css" type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href="./css/web.css" type="text/css" media="all" />
<%@include file="/website/inc/head.inc"%>
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
function passpageNo(){ 
 	var gopageNo = document.getElementById("gopageNo").value; 	
	document.form.action="website/land/serland.jsp?pageNo="+gopageNo;
	document.form.submit();}
var req;
var searchChar = new Array();
for(var i=0;i<3;i++){
	searchChar[i]=0;
}

/* function search(){
	var bname=document.getElementById("searchbuilding").value;
	alert(bname);
	 form.action="NewBuildServlet?flag=1&bname="+bname;
	document.getElementById("form").submit(); 
} */
function bb(num,con){
	 var bname=document.getElementById("searchbuilding").value;
	 switch(num){
	  case 0: searchChar[0]=con;
	  break;
	  case 1: searchChar[1]=con;
	  break;
	  case 2: searchChar[2]=con;
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
	 
	 var url = "LandServlet";
			createXmlHttpRequest();
			xmlHttp.open("POST", url, true);
			xmlHttp.onreadystatechange = handleStateChange;//回调
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;text/xml;charset=utf-8"); //text/xml;charset=utf-8：解决汉字封装json问题
			xmlHttp.send("searchChar="+searchChar+"&bname="+bname+"&flag=11");		
}
</script>
 <style type="text/css">
 #search {
	position:absolute;
	width:800px;
	height:130px;
	z-index:1;
	left: 250px;
	top: 150px;
	font-size:14px;
	margin:0 auto;
	background: #eee;
	}
  #content{
	position:absolute;
	width:800px;
	height:500px;
	z-index:2;
	left: 250px;
	top: 297px;
	/*border: 1px solid #000;*/  
	}
	#tdtitle{
	position:relative;
	width:300px;
	height:30px;
	left: 10px;
	top: 10px;
	color:#0000CD;
	font-size:20px;
	}
	#tdtxt1{
	position:relative;
	width:300px;
	height:15px;
	left: 10px;
	margin-top: 10px;
	color:#000;
	font-size:10px;
	}
	#tdtxt2{
	position:relative;
	width:300px;
	height:15px;
	left: 10px;
	margin-top: 5px;
	color:#000;
	font-size:10px;
	}
	#tdtxt3{
	position:relative;
	width:300px;
	height:15px;
	left: 10px;
	margin-top: 5px;
	color:#000;
	font-size:10px;
	}
	#tdtxt4{
	position:relative;
	width:300px;
	height:15px;
	left: 10px;
	margin-top: 5px;
	color:#000;
	font-size:10px;
	}
 </style>
</head>

<body>
<form method="post" id="form" action="">
<%@include file="/website/inc/header.inc"%>
	<div id="search">
  <blockquote>
    <p>区域：
	<a id="00" href="javascript:void(0);" onclick="bb(0,00)">全部</a> &nbsp;
	<a id="01" href="javascript:void(0);" onclick="bb(0,01)">市南</a> &nbsp;
	<a id="02" href="javascript:void(0);" onclick="bb(0,02)">市北</a> &nbsp;
	<a id="03" href="javascript:void(0);" onclick="bb(0,03)">李沧</a> &nbsp;
	<a id="04" href="javascript:void(0);" onclick="bb(0,04)">崂山</a>&nbsp;
	<a id="05" href="javascript:void(0);" onclick="bb(0,05)">城阳</a> &nbsp;
	<a id="06" href="javascript:void(0);" onclick="bb(0,06)">黄岛</a> &nbsp;
	<a id="07" href="javascript:void(0);" onclick="bb(0,07)">即墨市</a> &nbsp;
	<a id="08" href="javascript:void(0);" onclick="bb(0,08)">胶州市</a> &nbsp;
	<a id="09" href="javascript:void(0);" onclick="bb(0,09)">胶南市</a> &nbsp;
	<a id="010" href="javascript:void(0);" onclick="bb(0,10)">平度市</a> &nbsp;
	<a id="011" href="javascript:void(0);" onclick="bb(0,11)">莱西市</a>&nbsp;
	<a id="012" href="javascript:void(0);" onclick="bb(0,12)">其他</a></p>
	<p>户型：
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
	   <a id="24" href="javascript:void(0);" onclick="bb(2,4)">12000以上</a> 
	   <input name="searchbuilding" id="searchbuilding" class="textfield" type="text" size="20" /> 
		<input type="button" name="searchs" id="searchs" value="搜索" onclick="bb(3,0)"/>
	   </p>
	   
	   
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

					<table width="742">
	      			   <%for(int i=0;i<pagelist.size();i++){ 
	      				 List landPhotoList=land.landPhoto(pagelist.get(i).getLandId(),"land_photo");
	      				String aString =null;
	      				String bString =null;
	      				 if(!landPhotoList.isEmpty()){%>
		      			   <tr height="150">
		      			   	<td  width="150"><img style="height:120px;width: 120px;"src="picupload/land/<%=landPhotoList.get(0)%>"></td>
		      			   	<%}else{%>
		      			   	<tr height="150">
		      					<td  width="150">无图</td>
		      				 <% }%>
		      			    <td><div id="tdtitle"><a href="website/land/landintro.jsp?landId=<%=pagelist.get(i).getLandId()%>"> <%=pagelist.get(i).getLandName()%></a></div>
		      			    <div id ="tdtxt1">地址：<%=pagelist.get(i).getAddress()%> </div>
		      			    <div id ="tdtxt2">土地用途：<%=landusage%></div>
		      			    <div id ="tdtxt2">土地出让方式：<%=sellway %>：</div>
		      			    <div id ="tdtxt3">土地面积：<%=pagelist.get(i).getLandArea()%>平方米</div>
		      			    
		      			    <td><div><%=pagelist.get(i).getLanddealPrice() %></div></td>
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
                <td style="border:0px;" width="48%" align="right">[<a href="website/land/seland.jsp?pageNo=1" class="right-font08">首页</a> | <a href="website/land/seland.jsp?pageNo=<%=pageNo-1%>" class="right-font08">上一页</a> | <a href="website/land/seland.jsp?pageNo=<%=pageNo+1%>" class="right-font08">下一页</a> | <a href="website/land/seland.jsp?pageNo=<%=index%>" class="right-font08">末页</a>] 转至：</td>
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