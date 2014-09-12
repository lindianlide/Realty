<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
    String manroles=(String)session.getAttribute("manrole"); 
    int manrole=Integer.parseInt(manroles);
 	String managername=(String)session.getAttribute("managername"); 
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<link href="../css/frame.css" rel="stylesheet" type="text/css" />
</head>
<script language="javascript">  
var infos=0;
function info(num){
	for(var i=0;i<3;i++){
	 document.getElementById(i).style.color="black";
	}
	 switch(num){
	  case 0: infos=0;
	  break;
	  case 1: infos=1;
	  break;
	  case 2: infos=2;
	  break;
	 }
	 document.getElementById(infos).style.color="blue";
}
function framesetReload(){  
	window.location.reload(); 
	window.parent.frames["leftFrame"].location.reload(); 
	window.parent.frames["middleFrame"].location.reload();  
	//window.parent.frames["bottomFrame"].location.reload();
}  
</script>

<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="70" background="../images/manage/home/main_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" height="24" background="../images/manage/home/main_03.gif">&nbsp;</td>
            <td width="505" background="../images/manage/home/main_04.gif">&nbsp;</td>
            <td>&nbsp;</td>
            <td width="21"><img src="../images/manage/home/main_07.gif" width="21" height="24"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="38"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" height="38" background="../images/manage/home/main_09.gif">&nbsp;</td>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="77%" height="25" valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="50" height="19"><div align="center">
                    <a href="./main.jsp" target="_parent"> <img src="../images/manage/home/main_12.gif" width="49" height="19"></a>
                   
                    </div></td>
                    
                    <td width="50"><div align="center">
                     <input type="image" src="../images/manage/home/main_14.gif" onclick="window.history.go(-1);" />
                    </div></td>
                   
                    <td width="50"><div align="center">
                   <input type="image" src="../images/manage/home/main_16.gif" onclick="window.history.go(1);" />
                    </div></td>
                    <td width="50"><div align="center">
                   <input type="image" src="../images/manage/home/main_18.gif"  onclick="framesetReload();" />
                    </div></td>
                   
                    <td width="50"><div align="center">
                   	<a href="login.jsp?clearsession=true" target="_parent"> <img src="../images/manage/home/main_20.gif" width="48" height="19"> </a>
                    </div></td>
                    
                    <td width="26"><div align="center"><img src="../images/manage/home/main_21.gif" width="26" height="19"></div></td>
                    <td>&nbsp;</td>
                  </tr>
                </table></td>
                <td width="220" valign="bottom"  nowrap="nowrap"><div  align="right"><span class="STYLE1">■ 今天是：<span id="time" class="STYLE2"></span> </span></div></td>
              </tr>
            </table></td>
            <td width="21"><img src="../images/manage/home/main_11.gif" width="21" height="38"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="8" style=" line-height:8px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" background="../images/manage/home/main_29.gif" style=" line-height:8px;">&nbsp;</td>
            <td width="505" background="../images/manage/home/main_30.gif" style=" line-height:8px;">&nbsp;</td>
            <td style=" line-height:8px;">&nbsp;</td>
            <td width="21" style=" line-height:8px;"><img src="../images/manage/home/main_31.gif" width="21" height="8"></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="28" background="../images/manage/home/main_36.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="177" height="28" background="../images/manage/home/main_32.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="20%"  height="22">&nbsp;</td>
            <td width="59%" valign="bottom"><div align="center" class="STYLE1">当前用户：<%=managername%></div></td>
            <td width="21%">&nbsp;</td>
          </tr>
        </table></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="65" height="28"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="23" valign="bottom"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr> 
                    <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(../images/manage/home/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"> <div align="center" class="STYLE3">业务中心</div></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
            <td width="3"><img src="../images/manage/home/main_34.gif" width="3" height="28"></td>
            <td width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(../images/manage/home/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><div align="center" class="STYLE3">
               	<a id="0" href="data/left_data.jsp" onClick="info(0)" target="leftFrame"> 数据管理</a>
                </div></td>
              </tr>
            </table></td>
            <td id="10" width="3"><img src="../images/manage/home/main_34.gif" width="3" height="28"></td>
            <td id="11" width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
             <!--  <tr id="webmanage" style="display:block"> -->
             <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(../images/manage/home/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><div align="center" class="STYLE3">
                		<a id="1" href="web/left_web.jsp" onClick="info(1)" target="leftFrame"> 网站管理</a>
                </div></td>
              </tr>
            </table></td>
            <td id="12" width="3"><img src="../images/manage/home/main_34.gif" width="3" height="28"></td>
            <td id="13" width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <!-- <tr id="usermanage" style="display:block"> -->
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(../images/manage/home/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><div align="center" class="STYLE3">
                	<a id="2" href="user/left_user.jsp" onClick="info(2)" target="leftFrame"> 用户管理</a> 
                </div></td>
              </tr>
            </table></td>
            <td id="14" width="3"><img src="../images/manage/home/main_34.gif" width="3" height="28"></td>
            <td id="15" width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(../images/manage/home/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><div align="center" class="STYLE3">     </div></td>
              </tr>
            </table></td>
            <td id="16" width="3"><img src="../images/manage/home/main_34.gif" width="3" height="28"></td>
            <td id="17" width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(../images/manage/home/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><div align="center" class="STYLE3">    </div></td>
              </tr>
            </table></td>
            <td width="3"><img src="../images/manage/home/main_34.gif" width="3" height="28"></td>
            <td width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(../images/manage/home/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><div align="center" class="STYLE3">    </div></td>
              </tr>
            </table></td>
            <td width="3"><img src="../images/manage/home/main_34.gif" width="3" height="28"></td>
            <td width="63"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(../images/manage/home/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><div align="center" class="STYLE3">   </div></td>
              </tr>
            </table></td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td width="21"><img src="../images/manage/home/main_37.gif" width="21" height="28"></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
<%-- <script>
var web=document.getElementById("webmanage");
var user=document.getElementById("usermanage");
var name="<%=manrole%>";
if(name!="00")
{ 
	web.style.display="none";
	user.style.display="none";
	}
</script> --%>
<script type="text/javascript">
 var today = new Date(); //新建一个Date对象
  var date = today.getDate();//查询当月日期
  var day = today.getDay();//查询当前星期几
  var month = today.getMonth()+1;//查询月份
  var year = today.getFullYear();//查询年份  
  var hour=today.getHours();
  var morning="";
 /* if ( hour<12) morning="上午好";
 if ( hour>=12&&hour<=18) morning="下午好";
 if ( hour>18) morning="晚上好"; */
  var week="";                               
  if (day==0) week='星期日';
  if (day==1) week='星期一';
  if (day==2) week='星期二';
  if (day==3) week='星期三';
  if (day==4) week='星期四';
  if (day==5) week='星期五';
  if (day==6) week='星期六';
  var time=(year+"年"+month+"月"+date+"日 "+week+" "+morning);
  document.getElementById("time").innerHTML = time;
   if(<%=manrole%>==02){
  for(var k=10;k<18;k++)
  document.getElementById(k).style.display= "none"; 
  } 
   else if(<%=manrole%>==01){
	   for(var b=12;b<18;b++)
		   document.getElementById(b).style.display= "none"; 
		   } 
   
</script>
</html>
