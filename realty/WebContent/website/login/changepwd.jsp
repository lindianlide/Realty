<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.*"%>
<%
 	String membername=(String)session.getAttribute("membername"); 
	MemberAction memberAction = new MemberAction();
	List<Member> list =memberAction.findn(membername);
 %>
  <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
    <%@include file="/website/inc/head.inc"%>
      <script type="text/javascript">
function checkname(){
var div = document.getElementById("div1");
div.innerHTML = "";
var name1 = document.form1.membername.value;
if (name1 == "") {
div.innerHTML = "姓名不能为空！";
//document.form1.membername.focus();//锁定
return false;
}
if (name1.length < 4 || name1.length > 16) {
div.innerHTML = "姓名输入的长度4-16个字符！";
document.form1.membername.select();
return false;
}
var charname1 = membername.toLowerCase();
for (var i = 0; i < name1.length; i++) {
var charname = charname1.charAt(i);
if (!(charname >= 0 && charname <= 9) && (!(charname >= 'a' && charname <= 'z')) && (charname != '_')) {
div.innerHTML = "姓名包含非法字母，只能包含字母，数字，和下划线";
document.form1.membername.select();
return false;
}
}
return true;

}

function checkpassword(){
var div = document.getElementById("div2");
div.innerHTML = "";
var password = document.form1.memberpwd.value;
if (password == "") {
div.innerHTML = "密码不位空！";
//document.form1.memberpwd.focus();
return false;
}
if (password.length < 4 || password.length > 12) {
div.innerHTML = "密码长度4-12位";
document.form1.memberpwd.select();
return false;
}
return true;
}

function checkrepassword(){
var div = document.getElementById("div3");
div.innerHTML = "";
var password = document.form1.memberpwd.value;
var repass = document.form1.memberpwd2.value;
if (repass == "") {
div.innerHTML = "密码不位空！";
//document.form1.memberpwd2.focus();
return false;
}
if (password != repass) {
div.innerHTML = "输入密码和确认密码长度不一致";
document.form1.memberpwd2.select();
return false;
}
return true;
}

function checkEmail(){
var div = document.getElementById("div4");
div.innerHTML = "";
var email = document.form1.email.value;
var sw = email.indexOf("@", 0);
var sw1 = email.indexOf(".", 0);
var tt = sw1 - sw;
if (email.length == 0) {
div.innerHTML = "电子邮件不能位空";
//document.form1.email.focus();
return false;
}
if (email.indexOf("@", 0) == -1) {
div.innerHTML = "电子邮件格式不正确，必须包含@符号！";
document.form1.email.select();
return false;
}
if (email.indexOf(".", 0) == -1) {
div.innerHTML = "电子邮件格式不正确，必须包含.符号!";
document.form1.email.select();
return false;
}
if (tt == 1) {
div.innerHTML = "邮件格式不对。@和.不可以挨着！";
document.form1.email.select();
return false;
}
if (sw > sw1) {
div.innerHTML = "电子邮件格式不正确，@符号必须在.之前";
document.form1.email.select();
return false;
}
else {
return true;
}

return ture;
}

function check(){
if (checkname() && checkpassword() && checkrepassword() && checkEmail()) {
return true;
}
else {
return false;
}
}
</script> 
   </head>
   <body class="home">
      <%@include file="/website/inc/header.inc"%>
         <!-- Header End --> 
         <!-- Content Start -->
         <div id="">
            <div id="panel-register">
     <form id=form1 name="form1" method="post" action="MemberAdd?flag=3" onsubmit="check()" >
<table>
<tr>
<td>
用户名：
</td>
<td>
<input id="membername" type="text" name="membername" value = "<%=list.get(0).getName() %>" onblur="checkname()">
<div id="div1" style="display:inline">
</div>
</td>
</tr>
<tr>
<td>
密码：
</td>
<td>
<input id="memberpwd" type="password" name="memberpwd" onblur="checkpassword()">
<div id="div2" style="display:inline">
</div>
</td>
</tr>
<tr>
<td>
确认密码：
</td>
<td>
<input id="memberpwd2" type="password" name="memberpwd2" onblur="checkrepassword()">
<div id="div3" style="display:inline">
</div>
</td>
</tr>
<tr>
<td>
电子邮件地址：
</td>
<td>
<input id="email" type="text" name="email" value = "<%=list.get(0).getEMail()%>" onblur="">
<div id="div4" style="display:inline">
</div>
</td>
</tr>

<tr>
<td>
密码保护问题：
</td>
<td>
<input id="question" type="text" name="question" value = "<%=list.get(0).getQuerstion() %>" onblur="">
<div id="div5" style="display:inline">
</div>
</td>
</tr>
<tr>
<td>
密码保护问题答案：
</td>
<td>
<input id="answer" type="text" name="answer" value = "<%=list.get(0).getAnswer()%>" onblur="">
<div id="div5" style="display:inline">
</div>
</td>
</tr>
<tr align="center">
<td align="center">
<input type="submit" value="提交" name="tect6"><input type="reset" value="重置" name="text7">
</td>
</tr>
</table>
</form> 
            </div>
 
                
		</div>
            
</div>
   <!-- Scroll To Top --> 
         
      <!-- The Scripts -->
      <script src="/realty/js/website/jquery.min.js"></script>
      <script src="/realty/js/website/bootstrap.js"></script>
      <script src="/realty/js/website/jquery.parallax.js"></script> 
      <script src="/realty/js/website/revolution-slider/js/jquery.themepunch.revolution.min.js"></script>
      <script src="/realty/js/website/jquery.prettyPhoto.js"></script>
      <script src="/realty/js/website/jquery.sticky.js"></script>
      <script src="/realty/js/website/jflickrfeed.js"></script>
      <script src="/realty/js/website/imagesloaded.pkgd.min.js"></script>
      <script src="/realty/js/website/spectrum.js"></script>
      <script src="/realty/js/website/custom.js"></script>
   
</body>
</html>