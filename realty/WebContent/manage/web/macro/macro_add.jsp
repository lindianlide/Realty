<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%   
String macrocategoryId1=request.getParameter("macrocategoryId");
int macrocategoryId=Integer.parseInt(macrocategoryId1);
%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link href="css/manstyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form name="form1" method="post" action="WebsitemServlet?flag=21&macrocategoryId=<%=macrocategoryId%>">
  <table width="849">
    <tr>
      <td width="86">标题：</td>
      <td width="747"><input type="text" name="macrotitle" size="50"></td>
    </tr>
    <tr>
      <td colspan="2">内容：</br> 
      <ckeditor:editor editor="content" basePath="ckeditor/" value="Type here"></ckeditor:editor> 
      <!-- <textarea class="ckeditor" name="editor13"></textarea> --></td>
    </tr>
   <tr>
   <Th colspan="2" align="center" height="55" style="border-left:1px solid #000000;">
    <input type="Submit" name="Submit" value="保存" />　
   <input type="button" name="Submit2" value="返回" class="button" onClick="window.history.go(-1);"/>	
   </Th>	
     </tr>
    </table>		
</form>
<%-- <ckeditor:replace replace="editor1" basePath="ckeditor/" /> --%>
</body>
</html>