<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>企业信息管理系统</title>

<style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}

</style>
</head>

<frameset rows="98,*,5" frameborder="no" border="0" framespacing="0">
  <frame src="./manage/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
 <frameset cols="168,*"  frameborder="no" border="0" framespacing="0">
  <frame src="./manage/left.jsp" style="border-top: 0;border-bottom: 0;border-left:thick solid rgb(24,115,170);border-right:medium solid rgb(24,115,170)" marginwidth="5" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" />
  <frame src="./manage/middle.jsp" style="border-right:thick solid rgb(24,115,170)" name="middleFrame" id="middleFrame" scrolling="no" />
</frameset>

  <frame src="./manage/down.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>