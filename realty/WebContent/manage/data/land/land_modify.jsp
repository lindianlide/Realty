<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
String landId1=request.getParameter("landId");
int landId=Integer.parseInt(landId1);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/tab.js"></script>
<link href="css/tab.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
</head>
<body style="scrollbar-base-color:red">
<form id="form2" name="form2" method="post" >
<div id="container" style="container_style">
<div id="li_area" class="li_area_styleland">
    <ul id="ul_area" class="ul_area_style">
        <li class="listli">基本信息</li>
        <li >招拍挂部分</li>
        <li >划拨部分</li>    
    </ul>
</div>
<div id="tab_area" class="tab_area_styleland">
     <iframe name="landone" id="landone"  class="content_area" src="manage/data/land/landdetail_modify.jsp?landId=<%=landId %>" frameborder="0" >
    </iframe>
   <iframe  name="landtwo" id="landtwo" src="manage/data/land/landzpg_list.jsp?landId=<%=landId %>" frameborder="0" >
    </iframe>
    <iframe  name="landthree" id="landthree" src="manage/data/land/landallot_list.jsp?landId=<%=landId %>" frameborder="0" >
    </iframe> 
</div>
</div>

</form>
</body>
</html>