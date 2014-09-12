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
<link href="css/frame.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE3 {
	font-size: 12px;
	color: #033d61;
}
-->
</style>
<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #ffffff; POSITION: relative; TOP: 2px 
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #FFCC00; POSITION: relative; TOP: 2px
}

</style>
<!-- 
<script>
var he=document.body.clientHeight-105;
document.write("<div id=tt style=height:"+he+";overflow:hidden>");
</script>
 -->
<script>
var infos=0;
function info(num){
	//for(var i=0;i<25;i++){
	for(var i=0;i<17;i++){
	 document.getElementById(i).style.color="black";
	}
	 switch(num){
	  case 0: infos=0;
	  break;
	  case 1: infos=1;
	  break;
	  case 2: infos=2;
	  break;
	  case 3: infos=3;
	  break;
	  case 4: infos=4;
	  break;
	  case 5: infos=5;
	  break;
	  case 6: infos=6;
	  break;
	  case 7: infos=7;
	  break;
	  case 8: infos=8;
	  break;
	  case 9: infos=9;
	  break;
	  case 10: infos=10;
	  break;
	  case 11: infos=11;
	  break;
	  case 12: infos=12;
	  break;
	  case 13: infos=13;
	  break;
	  case 14: infos=14;
	  break;
	  case 15: infos=15;
	  break;
	  case 16: infos=16;
	  break;
	  /* case 17: infos=17;
	  break;
	  case 18: infos=18;
	  break;
	  case 19: infos=19;
	  break;
	  case 20: infos=20;
	  break;
	  case 21: infos=21;
	  break;
	  case 22: infos=22;
	  break;
	  case 23: infos=23;
	  break;
	  case 24: infos=24;
	  break; */
	 }
	 document.getElementById(infos).style.color="blue";
}
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
imgmenu = eval("imgmenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
imgmenu.background="images/manage/home/main_47.gif";
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
imgmenu.background="images/manage/home/main_48.gif";
}
}

</script>
</head>
<body>

<table width="165" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="28" background="images/manage/home/main_40.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="19%">&nbsp;</td>
        <td width="81%" height="20"><span class="STYLE1">管理菜单</span></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">

          <tr>
            <td height="23" background="images/manage/home/main_47.gif" id="imgmenu1" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(1)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="18%">&nbsp;</td>
                <td width="82%" class="STYLE1">重要项目管理</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td background="images/manage/home/main_51.gif" id="submenu1">
			 <div class="sec_menu" >  
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="16%" height="25"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                    <td width="84%" height="23">
                    <table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                          <a id="0" href="manage/web/project/project_list.jsp?procategoryId=0" onClick="info(0)" target="middleFrame">住宅</a>
                          </span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                    <td height="23">
                    <table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
						<a id="1" href="manage/web/project/project_list.jsp?procategoryId=1" onClick="info(1)" target="middleFrame">商业</a>
						</span></td>
                        </tr>
                    </table></td>
                  </tr>
                  
                   <tr>
                    <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                    <td height="23">
                    <table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
             				<a id="2" href="manage/web/project/project_list.jsp?procategoryId=2" onClick="info(2)" target="middleFrame">工业</a>
                          </span></td>
                        </tr>
                    </table></td>
                  </tr>
                  
                   <tr>
                    <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                    <td height="23">
                    <table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                        	<a id="3" href="manage/web/project/project_list.jsp?procategoryId=3" onClick="info(3)" target="middleFrame">其他</a>
                          </span></td>
                        </tr>
                    </table></td>
                  </tr>
                  
                </table></td>
              </tr>
              <tr>
                <td height="5"><img src="images/manage/home/main_52.gif" width="151" height="5" /></td>
              </tr>
            </table></div></td>
          </tr>
          
        </table></td>
      </tr>
      
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/manage/home/main_47.gif" id="imgmenu2" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(2)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">新闻动态管理</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td background="images/manage/home/main_51.gif" id="submenu2" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23">
                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                               	<a id="4" href="manage/web/news/news_list.jsp?newscategoryId=0" onClick="info(4)" target="middleFrame">市场动态</a>
                                </span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                        	<a id="5" href="manage/web/news/news_list.jsp?newscategoryId=1" onClick="info(5)" target="middleFrame">政策信息</a>      
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                          <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
	                               	<a id="6" href="manage/web/news/news_list.jsp?newscategoryId=2" onClick="info(6)" target="middleFrame">土地资讯     </a>      
	                                
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                          <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
	                                 <a id="7" href="manage/web/news/news_list.jsp?newscategoryId=3" onClick="info(7)" target="middleFrame">公司动态 </a>      
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                        
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"><img src="images/manage/home/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table>         
        </td>
      </tr>
      
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/manage/home/main_47.gif" id="imgmenu3" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(3)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">研究发布管理</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td background="images/manage/home/main_51.gif" id="submenu3" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                                   <a id="8" href="manage/web/research/research_list.jsp?reschcategoryId=0" onClick="info(8)" target="middleFrame">市场报告 </a>      
                                
                                </span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                                   <a id="9" href="manage/web/research/research_list.jsp?reschcategoryId=1" onClick="info(9)" target="middleFrame">课题研究	</a>      
                                </span></td>
                              </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"><img src="images/manage/home/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table></td>
      </tr>
      
       <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/manage/home/main_47.gif" id="imgmenu4" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(4)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">下载中心管理</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td background="images/manage/home/main_51.gif" id="submenu4" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23">
                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                                 <a id="10" href="manage/web/down/down_list.jsp" onClick="info(10)" target="middleFrame">上传文件 </a>      
                                </span></td>
                              </tr>
                          </table></td>
                        </tr>
         
                        <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
	                                 <a id="11" href="manage/web/down/down_manage.jsp" onClick="info(11)" target="middleFrame">上传文件管理 </a>      
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>


                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"><img src="images/manage/home/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table>         
        </td>
      </tr>
      
      
        <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/manage/home/main_47.gif" id="imgmenu5" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(5)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">企业文化管理</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td background="images/manage/home/main_51.gif" id="submenu5" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23">
                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                                 <a id="12" href="manage/web/culture/culture_list.jsp?culcategoryId=0" onClick="info(12)" target="middleFrame">企业文化中心</a>      
                                </span></td>
                              </tr>
                          </table></td>
                        </tr> 


                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"><img src="images/manage/home/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table>         
        </td>
      </tr>
      
       <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/manage/home/main_47.gif" id="imgmenu6" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(6)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">政策法规管理</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td background="images/manage/home/main_51.gif" id="submenu6" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23">
                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                               	<a id="13" href="manage/web/law/law_list.jsp?lawcategoryId=0" onClick="info(13)" target="middleFrame">国家</a>
                                </span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                        	<a id="14" href="manage/web/law/law_list.jsp?lawcategoryId=1" onClick="info(14)" target="middleFrame">山东省</a>      
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                          <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
	                               	<a id="15" href="manage/web/law/law_list.jsp?lawcategoryId=2" onClick="info(15)" target="middleFrame">青岛市   </a>      
	                                
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                          <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
	                                 <a id="16" href="manage/web/law/law_list.jsp?lawcategoryId=3" onClick="info(16)" target="middleFrame">其他</a>      
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>                      
                        
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"><img src="images/manage/home/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table>         
        </td>
      </tr>
      
      
                            
      <!--   <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/manage/home/main_47.gif" id="imgmenu7" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(7)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">宏观数据管理</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td background="images/manage/home/main_51.gif" id="submenu7" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23">
                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                               	<a id="17" href="manage/web/macro/macro_list.jsp?macrocategoryId=0" onClick="info(17)" target="middleFrame">国际</a>
                                </span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                        	<a id="18" href="manage/web/macro/macro_list.jsp?macrocategoryId=1" onClick="info(18)" target="middleFrame">国家</a>      
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                          <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
	                               	<a id="19" href="manage/web/macro/macro_list.jsp?macrocategoryId=2" onClick="info(19)" target="middleFrame">山东     </a>      
	                                
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                                            
                        
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"><img src="images/manage/home/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table>         
        </td>
      </tr>
      
      
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/manage/home/main_47.gif" id="imgmenu8" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(8)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">微观数据管理</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td background="images/manage/home/main_51.gif" id="submenu8" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23">
                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                               	<a id="20" href="manage/web/micro/micro_list.jsp?microcategoryId=0" onClick="info(20)" target="middleFrame">整体经济数据</a>
                                </span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                        	<a id="21" href="manage/web/micro/micro_list.jsp?microcategoryId=1" onClick="info(21)" target="middleFrame">区市建设</a>      
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                          <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
	                               	<a id="22" href="manage/web/micro/micro_list.jsp?microcategoryId=2" onClick="info(22)" target="middleFrame">城市规划     </a>      
	                                
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                           
                           <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                        	<a id="23" href="manage/web/micro/micro_list.jsp?microcategoryId=1" onClick="info(23)" target="middleFrame">服务业</a>      
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                        <tr>
                          <td height="23"><div align="center"><img src="images/manage/home/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">
                        	<a id="24" href="manage/web/micro/micro_list.jsp?microcategoryId=1" onClick="info(24)" target="middleFrame">农业</a>      
	                                </span></td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>                 
                        
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"><img src="images/manage/home/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table>         
        </td>
      </tr> 
       -->
      
    </table></td>
  </tr>
  <tr>
    <td height="18" background="images/manage/home/main_58.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="18" valign="bottom"><div align="center" class="STYLE3"></div></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>