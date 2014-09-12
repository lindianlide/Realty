<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.realty.base.action.*,com.realty.base.model.*,java.util.*" pageEncoding="UTF-8"%>
<%
ManagerAction manageraction=new ManagerAction();
List<Manager> manageList=manageraction.managerList();
String manrole=null;
String password=null;
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
<link href="css/manstyle.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" rev="stylesheet" href="./css/web.css" type="text/css" media="all" />
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
<form name="form1" method="post" action="">
<table width="100%" height="40" border="0" style="border-right:0px ;border-bottom:0px ;">
  <tr>
      <th colspan="2"><div align="center" class="STYLE1"> 管理人员</div></th>
    </tr>
</table>
  <table  width="738" cellpadding=0 cellspacing=0 >
    <tr>
      <td><div align="center">用户名</div></td>
      <td><div align="center">密码</div></td>
      <td><div align="center">角色</div></td>
      <td><div align="center">操作</div></td>
    </tr>
    <%for(int i=0;i<manageList.size();i++){
    if(manageList.get(i).getManrole().equals("00"))
  		 { manrole="超级管理员";
  		 password=manageList.get(i).getPassword();
  		 }
    else if(manageList.get(i).getManrole().equals("01"))
   		 { manrole="一般管理员";
   	       password=manageList.get(i).getPassword();
   		 }
    else if(manageList.get(i).getManrole().equals("02"))
	    {
    	   manrole="录入员";
    	   password=manageList.get(i).getPassword();
	    }
    %>
    <tr>
      <td><%=manageList.get(i).getName()%></td>
      <td><%=password%></td>
      <td><%=manrole%></td>
       <td bgcolor="#FFFFFF"><a href="manage/user/user_update.jsp?manId=<%=manageList.get(i).getManId()%>" >修改 </a>   <a href="ManageServlet?flag=4&manId=<%=manageList.get(i).getManId() %>">删除</a></td>
    </tr>
    <%} %>
  </table>
</form>
</body>
</html>