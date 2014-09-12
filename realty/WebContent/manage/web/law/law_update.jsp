<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.WebsiteAction,java.util.List,com.realty.base.model.*,java.text.SimpleDateFormat;" %>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<%
String law_id1=(String)request.getParameter("law_id");
int law_id=Integer.parseInt(law_id1);
String lawcategoryId1=(String)request.getParameter("lawcategoryId");
int lawcategoryId=Integer.parseInt(lawcategoryId1);
WebsiteAction website=new WebsiteAction();
List<Law> list=website.lawList(lawcategoryId);
int j=0;
for(int i=0;i<list.size();i++){
	if(list.get(i).getLawId()==law_id)	
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
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
</head>
<script type="text/javascript">
function fileupload(){
	 if($("#lawfile").val()==""){
		alert("上传文件不能为空!");
		return false;
	} 
	var file = $("#lawfile").val();
	var pos=file.lastIndexOf("\\");
	var fileName=file.substring(pos+1);  
	$.ajaxFileUpload({
			
			url:"FileServlet?flag=4&lawId=<%=law_id%>",
			contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
			secureuri:false,
			cache: false,//防止缓存
			fileElementId:'lawfile',
			dataType: 'text/xml',			
			success: function (data) {
			    document.getElementById("lawspan").innerHTML = fileName;
				alert(fileName);
			},error: function (data, status, e){
				alert("fail");
			}
		}
	);
}
</script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>

<body>

<form name="form1" method="post" action="WebsitemServlet?flag=18&lawcategoryId=<%=lawcategoryId%>&lawId=<%=list.get(j).getLawId()%>">
  <table width="849">
    <tr>
      <td width="86">标题：</td>
      <td width="747"><input type="text" name="lawtitle" size="50" value="<%=list.get(j).getName()%>"></td>
    </tr>
    <tr>
      <td>上传文件： </td>
      <td><span  id="lawspan"></span> 
 	   <input type="file" name="lawfile" id="lawfile" value="this.val()"/>
       <input type="button" name="fileLoad" id="fileLoad" value="上传" onClick="fileupload()"/>
	  </td>
    </tr>
    <tr>
      <td colspan="2">内容：</br> 
     <textarea id="TextArea1" name="content" cols="20" rows="2" class="ckeditor" > <%=list.get(j).getContents()%> </textarea>	  </td>
    </tr>
   <tr>
   <Th colspan="2" align="center" height="55" style="border-left:1px solid #000000;">
    <input type="Submit" name="Submit" value="保存" />　
   <input type="button" name="Submit2" value="返回" class="button" onClick="window.history.go(-1);"/>   </Th>	
     </tr>
    </table>		
</form>
</body>
</html>