<%@ page language="java"  import="java.util.List;" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
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
		//将后台返回的数据显示在层content中
		function parseResults() {
		     document.getElementById("content").innerHTML=xmlHttp.responseText;//将返回的请

求文本Text写入指定的DIV中
		}
</script>
<script type="text/javascript">
var req;
var searchChar = new Array();
for(var i=0;i<3;i++){
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
	 }
	 for(var i=0;i<13;i++){   ////解决选中字段显示颜色的问题
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
					"application/x-www-form-urlencoded;text/xml;charset=utf-8"); //text/xml;charset=utf-8：可以解决汉字封装json问题
			xmlHttp.send("searchChar="+searchChar+"&flag=3");		
}
</script>
 <style type="text/css">
 #search {
	position:absolute;
	width:742px;
	height:120px;
	z-index:1;
	left: 85px;
	top: 11px;
	font-size:14px;
	margin:0 auto;
	background: #eee;
	}
  #content{
	position:absolute;
	width:940px;
	height:500px;
	z-index:2;
	left: 85px;
	top: 170px;
	/*border: 1px solid #000;*/  
	}
 </style>
</head>

<body class="home">
<div id="search">
    <p>区域：
		<a id="00" href="javascript:void(0);" onclick="bb(0,00)">全部</a>
		<a id="01" href="javascript:void(0);" onclick="bb(0,01)">市南</a>
		<a id="02" href="javascript:void(0);" onclick="bb(0,02)">市北</a>
		<a id="03" href="javascript:void(0);" onclick="bb(0,03)">李沧</a>
		<a id="04" href="javascript:void(0);" onclick="bb(0,04)">崂山</a>
		<a id="05" href="javascript:void(0);" onclick="bb(0,05)">城阳</a>
		<a id="06" href="javascript:void(0);" onclick="bb(0,06)">黄岛</a>
		<a id="07" href="javascript:void(0);" onclick="bb(0,07)">即墨市</a>
		<a id="08" href="javascript:void(0);" onclick="bb(0,08)">胶州市</a>
		<a id="09" href="javascript:void(0);" onclick="bb(0,09)">胶南市</a>
		<a id="010" href="javascript:void(0);" onclick="bb(0,10)">平度市</a>
		<a id="011" href="javascript:void(0);" onclick="bb(0,11)">莱西市</a>
		<a id="012" href="javascript:void(0);" onclick="bb(0,12)">其他</a></p>
	<p>户型：
		<a id="10" href="javascript:void(0);" onclick="bb(1,0)">全部</a>
		<a id="11" href="javascript:void(0);" onclick="bb(1,1)">住宅</a>
		<a id="12" href="javascript:void(0);" onclick="bb(1,2)">商用</a>
	 	<a id="13" href="javascript:void(0);" onclick="bb(1,3)">办公</a>
	  	<a id="14" href="javascript:void(0);" onclick="bb(1,4)">其他</a></p>
    <p>价格：
		<a id="20" href="javascript:void(0);" onclick="bb(2,0)">全部</a>
		<a id="21" href="javascript:void(0);" onclick="bb(2,1)">6000以下</a>
	 	<a id="22" href="javascript:void(0);" onclick="bb(2,2)">6000--8000</a>
	 	<a id="23" href="javascript:void(0);" onclick="bb(2,3)">8000--12000</a>
	 	<a id="24" href="javascript:void(0);" onclick="bb(2,4)">12000以上</a></p>
 </div>
<div id="content" class="content">
				<table width="742">
		      		   <tr>
	      			    <td>楼盘名</td>
	      			    <td>区域</td>
	      			    <td>户型</td>
	      			    <td>价格</td>
	      			   </tr> 
		      		  </table>
    <table style="border:0px;" width="650" height="40">
        <tr>
          <td style="border-left:0px; border-top:0px ;height:5px;" height="6"><img src="images/manage/spacer.gif" width="1" height="1" /></td>
        </tr>
      </table>
</div>	
</body>
<script type="text/javascript">
document.getElementById("00").style.color="red";
document.getElementById("10").style.color="red";
document.getElementById("20").style.color="red";
</script>
</html>