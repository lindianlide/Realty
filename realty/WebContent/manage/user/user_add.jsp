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
<title>Insert title here</title>
<link href="css/manstyle.css" type="text/css" rel="stylesheet">
<style type="text/css">
<!--
.STYLE1 {
	font-size: 22px;
	font-family: "宋体";
}
}
-->
</style>
</head>
<body>
<form name="form1" method="post" action="ManageServlet?flag=2">
<table width="100%" height="40" border="0" style="border-right:0px ;border-bottom:0px ;">
  <tr>
      <th colspan="2"><div align="center" class="STYLE1"> 分配权限</div></th>
    </tr>
</table>
  <table width="738" cellpadding=0 cellspacing=0 >
    <tr>
      <td>选择角色：&nbsp;&nbsp;
        <select name="manrole"  id="manrole" size="1">
         <option value="00"> 超级管理员</option>
        <option value="01"> 一般管理员</option>
        <option value="02"> 录入员</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>授予用户名： 
      <input type="text" name="managename" id="managename" />
      </td>
    </tr>
     <tr>
      <td>授予密码： &nbsp;&nbsp;
      <input type="text" name="managepwd" id="managepwd" />
      </td>
    </tr>
       <tr>
   <Th colspan="2" align="center" height="55" style="border-left:1px solid #000000;">
    <input type="Submit" name="Submit" value="保存" />　
   <input type="button" name="Submit2" value="返回" class="button" onClick="window.history.go(-1);"/>	
   </Th>	
     </tr>
  </table>
</form>
</body>
</html>