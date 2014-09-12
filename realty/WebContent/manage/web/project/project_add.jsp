<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%   
String procategoryId1=request.getParameter("procategoryId");
int procategoryId=Integer.parseInt(procategoryId1);
%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link href="css/manstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
</head>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script language="JavaScript" type="text/javascript">

function submit1(){ 
	if($("#locationphoto").val()==""){
		alert("确定不上传附件？");
	}
	document.form1.action="WebsitemServlet?flag=1&procategoryId=<%=procategoryId%>";
	document.form1.submit();
	}
	
function fileupload1(){
		if($("#locationphoto").val()==""){
			alert("上传文件不能为空!");
			return false;
		}
		//var f = document.getElementById("myfilePath");
		// alert(f.value);
		var file = $("#locationphoto").val();
		var pos=file.lastIndexOf("\\");
		var fileName=file.substring(pos+1);  
		
		$.ajaxFileUpload({
				
				url:"",
				contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
				secureuri:false,
				cache: false,//防止缓存
				fileElementId:'locationphoto',
				dataType: 'text/xml',			
				success: function (data) {
				    document.getElementById("locationspan").innerHTML = fileName;
					alert(fileName);
				},error: function (data, status, e){
					alert("fail");
				}
			}
		);
	}
	

</script>
<body>
<form name="form1" method="post" action="WebsitemServlet?flag=1&procategoryId=<%=procategoryId%>">
  <table width="849">
    <tr>
      <td width="86">标题：</td>
      <td width="747"><input type="text" name="housetitle" size="50"></td>
    </tr>
    <tr>
      <td colspan="2">内容：</br> 
       <textarea id="editer1" name="content" cols="20" rows="2" class="ckeditor" > </textarea>
       </td>
    </tr>
      <tr>
      <!-- <td colspan="2">楼盘位置图：
       <span  id="locationspan" ></span> 
      <input type="file" name="locationphoto" id="locationphoto" value="this.val()"/>
      <input type="button" name="fileLoad1" id="fileLoad1" value="上传" onClick="fileupload1()"/>
      </td>
    </tr》 -->
   <tr>
   <Th colspan="2" align="center" height="55" style="border-left:1px solid #000000;">
    <input type="submit" name="Submit" onClick="submit1()" value="保存" />　
   <input type="button" name="Submit2" value="返回" class="button" onClick="window.history.go(-1);"/>	
   </Th>	
     </tr>
    </table>		
</form>
</body>
</html>