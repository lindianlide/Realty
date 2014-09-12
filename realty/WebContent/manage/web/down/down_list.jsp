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
<title>Insert title here</title>
 <base href="<%=basePath%>">
<link href="css/manstyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
</head>
<script type="text/javascript">
function fileupload(){
	 if($("#downfile").val()==""){
		alert("上传文件不能为空!");
		return false;
	} 
	var file = $("#downfile").val();
	var pos=file.lastIndexOf("\\");
	var fileName=file.substring(pos+1);  
	var category=document.getElementById('category').value;//可以得到value	
	$.ajaxFileUpload({
			
			url:"FileServlet?flag=1&category="+category,
			contentType:"multipart/x-www-form-urlencoded; text/xml;charset=utf-8",
			secureuri:false,
			cache: false,//防止缓存
			fileElementId:'downfile',
			dataType: 'text/xml',			
			success: function (data) {
			    document.getElementById("downspan").innerHTML = fileName;
				alert(fileName);
			},error: function (data, status, e){
				alert("fail");
			}
		}
	);
}
</script>
<body>
<form name="form1" method="post" action="">
  <table width="738">
    <tr>
      <td><div align="center">上文文件</div></td>
    </tr>
    <tr>
      <td>选择类别：
        <select name="category"  id="category" size="1">
        <option value="0"> 收费标准</option>
        <option value="1"> 培训资料</option>
        <option value="2"> 考试资料</option>
        <option value="3"> 评估杂谈</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>选择上传文件： <span  id="downspan" ></span> 
      <input type="file" name="downfile" id="downfile" value="this.val()"/>
      <input type="button" name="fileLoad" id="fileLoad" value="上传" onClick="fileupload()"/>
      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
  </table>
</form>
</body>
</html>