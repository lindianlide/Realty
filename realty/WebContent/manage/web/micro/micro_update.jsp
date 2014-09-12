<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.WebsiteAction,java.util.List,com.realty.base.model.*,java.text.SimpleDateFormat;" %>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<%
String micro_id1=(String)request.getParameter("microId");
int micro_id=Integer.parseInt(micro_id1);
String microcategoryId1=(String)request.getParameter("microcategoryId");
int microcategoryId=Integer.parseInt(microcategoryId1);
WebsiteAction website=new WebsiteAction();
List<Micro> list=website.microList(microcategoryId);
int j=0;
for(int i=0;i<list.size();i++){
	if(list.get(i).getMicroId()==micro_id)	
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

<form name="form1" method="post" action="WebsitemServlet?flag=26&microcategoryId=<%=microcategoryId%>&microId=<%=list.get(j).getMicroId()%>">
  <table width="849">
    <tr>
      <td width="86">标题：</td>
      <td width="747"><input type="text" name="microtitle" size="50" value="<%=list.get(j).getName()%>"></td>
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