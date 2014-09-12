<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.WebsiteAction,java.util.List,com.realty.base.model.*,java.text.SimpleDateFormat;" %>

<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<%
String project_id1=(String)request.getParameter("project_id");
int project_id=Integer.parseInt(project_id1);
String procategoryId1=(String)request.getParameter("procategoryId");
int procategoryId=Integer.parseInt(procategoryId1);
WebsiteAction website=new WebsiteAction();
List<Project> list=website.projectList(procategoryId);
int j=0;
for(int i=0;i<list.size();i++){
	if(list.get(i).getProjectId()==project_id)	
	{ j=i;
	  break;
		}	
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link href="css/manstyle.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>

<body>
<form name="form1" method="post" action="WebsitemServlet?flag=2&procategoryId=<%=procategoryId%>&projectId=<%=list.get(j).getProjectId()%>">
  <table width="849">
    <tr>
      <td width="86">标题：</td>
      <td width="747"><input type="text" name="housetitle" size="50" value="<%=list.get(j).getTitle()%>"></td>
    </tr>
    <tr>
      <td colspan="2">内容：</br> 
     <textarea id="TextArea1" name="content" cols="20" rows="2" class="ckeditor" > <%=list.get(j).getContents()%> </textarea>
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