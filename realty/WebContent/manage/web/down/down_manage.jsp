<%@ page language="java" import="com.realty.base.dao.impl.*,com.realty.base.model.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 WebsiteDaoImpl we=new WebsiteDaoImpl();
int category=0;
List<Down> downList=we.downList(category);
int pageSize=5;
int index=0;
int count=downList.size();
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
List<Down> pagelist=we.downList(pageNo, pageSize, category);
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
</head>
<link rel="stylesheet" rev="stylesheet" href="./css/manstyle.css" type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href="./css/web.css" type="text/css" media="all" />
 <style type="text/css">
 #search {
	position:absolute;
	width:742px;
	height:50px;
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
	top: 70px;
	/*border: 1px solid #000;*/  
	}
 </style>
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
		document.form.action="manage/web/down/down_manage.jsp?pageNo="+gopageNo;
		document.form.submit();
	}
var req;
var searchChar = new Array();
for(var i=0;i<1;i++){
	searchChar[i]=0;
}
function bb(num,con){
	 switch(num){
	  case 0: searchChar[0]=con;
	  break;
	 }
	 for(var i=0;i<4;i++){
		 var category1 = "0" + i;
		 document.getElementById(category1).style.color="black";
	 }
	
	 var category="0"+searchChar[0];
	 document.getElementById(category).style.color="red";
	 
			var url = "FileServlet";
			createXmlHttpRequest();
			xmlHttp.open("POST", url, true);
			xmlHttp.onreadystatechange = handleStateChange;//回调
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;text/xml;charset=utf-8"); //text/xml;charset=utf-8：解决汉字封装json问题
			xmlHttp.send("searchChar="+searchChar+"&flag=2");		
}
</script>
<body  style="overflow-x:hidden">
<form name="form" id="form" method="post" action="">
<div id="search">
    <p>分类：
	<a id="00" href="javascript:void(0);" onclick="bb(0,00)">收费标准</a> &nbsp;
	<a id="01" href="javascript:void(0);" onclick="bb(0,01)">培训资料</a> &nbsp;
	<a id="02" href="javascript:void(0);" onclick="bb(0,02)">考试资料</a> &nbsp;
	<a id="03" href="javascript:void(0);" onclick="bb(0,03)">评估杂谈</a></p>
</div>
<div id="content" class="content">
					<table width="742">
		      		   <tr style="font-size: 16px;font-weight:bold;">
	      			    <td>文件名</td>
	      			    <td>上传时间</td>
	      			    <td>文件位置</td>
	      			    <td>操作</td>
	      			   </tr>
	      			   <%for(int i=0;i<pagelist.size();i++){ %>
		      			   <tr>
		      			    <td><span><%=pagelist.get(i).getTitle() %></span></td>
		      			    <td><span><%=pagelist.get(i).getDate() %></span></td>
		      			    <%
		      			  String filepath=this.getServletConfig().getServletContext().getInitParameter("fileupload");
		      			    %>
		      			    <td><span><%=filepath%><%=pagelist.get(i).getDownFile() %></span></td>
		      			    <td><a href="FileServlet?flag=3&downId=<%= pagelist.get(i).getDownId()%>&category=<%=category%>&pageNo=<%=pageNo%>"><span>删除</span></a></td>
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
                <td style="border:0px;" width="48%" align="right">[<a href="manage/web/down/down_manage.jsp?pageNo=1" class="right-font08">首页</a> | <a href="manage/web/down/down_manage.jsp?pageNo=<%=pageNo-1%>" class="right-font08">上一页</a> | <a href="manage/web/down/down_manage.jsp?pageNo=<%=pageNo+1%>" class="right-font08">下一页</a> | <a href="manage/web/down/down_manage.jsp?pageNo=<%=index%>" class="right-font08">末页</a>] 转至：</td>
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
</script>
</html>