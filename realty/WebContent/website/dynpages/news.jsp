
<%@page import="com.realty.base.model.News"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.realty.base.action.WebsiteAction"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
 	String membername=(String)session.getAttribute("membername"); 
 %>
 <%
 String procategoryId1=request.getParameter("gory");
 if(procategoryId1==null)
	 procategoryId1="1";
 int procategoryId=Integer.parseInt(procategoryId1);
 WebsiteAction website=new WebsiteAction();
 int pageSize=2;
 int index=0;
 int count=website.newsList(procategoryId).size();
 if(count%pageSize==0&&count!=0)
  index=count/pageSize;
 else {
 	index=count/pageSize+1;
 	}
 String pageNos=request.getParameter("pageNo");	
 if(pageNos==null){
 	pageNos="1";
 }
 int pageNo=Integer.parseInt(pageNos);
 if(pageNo<1){
 	pageNo=1;
 	}else if(pageNo>index){
 		pageNo=index;
 	}
 List<News> pagelist=website.newsList(pageNo, pageSize,procategoryId);
 %>
 
  <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>


<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
      <meta charset="utf-8">
      <title>Pixma Responsive HTML5/CSS3 Template | FIFO THEMES</title>
      <meta name="description" content="Pixma Responsive HTML5/CSS3 Template from FIFOTHEMES.COM">
      <meta name="author" content="FIFOTHEMES.COM">
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Library CSS -->
      <link rel="stylesheet" href="/realty/css/bootstrap.css"> 
       <link rel="stylesheet" href="/realty/css/font-awesome.css"> 
      <link rel="stylesheet" href="/realty/css/superfish.css" media="screen"> 
      <link rel="stylesheet" href="/realty/css/index.css"> 
      <!-- Theme CSS -->
     <link rel="stylesheet" href="/realty/css/style.css">
      <!-- Responsive CSS -->
       <link rel="stylesheet" href="/realty/css/theme-responsive.css">
      <!-- Favicons -->
      <link rel="stylesheet" href="/realty/css/leftframe.css">
     <script src="http://www.codefans.net/ajaxjs/jquery-1.6.2.min.js"></script>
 <style type="text/css">
<!--

#Layer6 {
	position:relative;
	border-left:22px;
	margin-top:9px;
	width:800px;
	height:134px;
	background:#FAFAFA;
	border:1px solid #F2F2F2;
	z-index:1;
}
#Layer7 {
	position:absolute;
	left:8px;
	top:15px;
	width:780px;
	height:30px;
	border:1px solid #F2F2F2;
	z-index:1;
}
#Layer8 {
	position:absolute;
	left:600px;
	top:110px;
	width:200px;
	height:20px;
	border:1px solid #F2F2F2;
	z-index:2;
}
#Layer9 {
	position:absolute;
	left:9px;
	top:47px;
	width:780px;
	height:60px;
	border:1px solid #F2F2F2;
	z-index:3;
	
}
#Layer10 {
	position:absolute;
	left:700px;
	top:37px;
	width:38px;
	height:20px;
	border:1px solid #F2F2F2;
	z-index:1;
}
-->
</style>
     <script>
       $(document).ready(function(){
	     $(".level1 > a").click(function(){
		    $(this).addClass("current")  //给当前元素添加"current"样式
		    .next().show()  //下一个元素显示
		    .parent().siblings().children("a").removeClass("current")  //父元素的兄弟元素的子元素<a>移除"current"样式
		    .next().hide();  //它们的下一个元素隐藏
		    return false;
	    });
      });

    </script>
    
    <script type="text/javascript">
    
  

   
    </script>    
 </head>
<body>

         <!-- Header Start -->
<%@include file="/website/inc/header.inc"%>
<div class="marqueeSized">  </div> 
	<div id="panelfo-in2" >
	  <ul class="lmenu">
		<li style="margin-bottom:20px">
			<a href="news.jsp?earth=aa&&gory=0" style="font-size:20px;color:#000;background:#EBEBEB">市场动态</a>
			<!-- <ul class="level2">
				<li><a href="eastadvantage.jsp?earth=aa">土地政策--01</a></li>
				<li><a href="#" onclick="altrcontent()">土地政策--02</a></li>
				<li><a href="#none">土地政策--03</a></li>
				<li><a href="#none">土地政策--04</a></li>
			</ul> -->
		</li>
		<li style="margin-bottom:20px">
			<a href="news.jsp?earth=aa&&gory=1" style="font-size:20px;color:#000;background:#EBEBEB">政策信息</a>
			<!-- <ul class="level2">
				<li><a href="#none">新房政策--01</a></li>
				<li><a href="#none">新房政策--02</a></li>
				<li><a href="#none">新房政策--03</a></li>
				<li><a href="#none">新房政策--04</a></li>
			</ul> -->
		</li>
		<li style="margin-bottom:20px">
			<a href="news.jsp?earth=aa&&gory=2" style="font-size:20px;color:#000;background:#EBEBEB">土地咨询</a>
		<!-- 	<ul class="level2">
				<li><a href="#none">二手房政策--01</a></li>
				<li><a href="#none">二手房政策--02</a></li>
				<li><a href="#none">二手房政策--03</a></li>
				<li><a href="#none">二手房政策--04</a></li>
			</ul> -->
		</li>
		<li style="margin-bottom:20px">
			<a href="news.jsp?earth=aa&&gory=3" style="font-size:20px;color:#000;background:#EBEBEB">公司动态</a>
			<!-- <ul class="level2">
				<li><a href="#none">其他政策--01</a></li>
				<li><a href="#none">其他政策--02</a></li>
				<li><a href="#none">其他政策--03</a></li>
				<li><a href="#none">其他政策--04</a></li>
			</ul> -->
		</li>
	  </ul>
	</div>
	  <div id="panelfo-in3">
	  <font color="blue"></font><br/>
	  <blockquote> <span id ="abcde">
	  </span>
	 <% 
	  	 String names = (String)request.getParameter("earth");
	 
	 	if(names==null){
	 		names="aa";
	 	}
	 	if("aa".equals(names)){	  	 
		 for(int i=0;i<pagelist.size();i++)	
		 {%>
			 <%-- <tr align="center">
				    <td > <a href="projects.jsp?earth=bb&&projectid=<%=list.get(i).getProjectId()%>" ><%=list.get(i).getTitle()%></a></td> 
                  </tr> --%>
             
             <div id="Layer6">
  				<div id="Layer7"><a href="news.jsp?earth=bb&&newsid=<%=pagelist.get(i).getNewsId()%>" ><%=pagelist.get(i).getTitle()%></a></div>
  				<div id="Layer8"><%=pagelist.get(i).getDate()%></div>
  					<div id="Layer9">
    				<div id="Layer10"><a href="news.jsp?earth=bb&&newsid=<%=pagelist.get(i).getNewsId()%>" >详情</a></div>
    				</div>
  			</div>
  			 
		 <%}%>
		  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="images/manage/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09"><%=index%></span> 页 | 第 <span class="right-text09"><%=pageNo%></span> 页</td>
                <td width="48%" align="right">[<a href="../dynpages/news.jsp?earth=aa&gory=<%=procategoryId%>&pageNo=1" class="right-font08">首页</a> | <a href="../dynpages/news.jsp?earth=aa&gory=<%=procategoryId %>&pageNo=<%=pageNo-1%>" class="right-font08">上一页</a> | <a href="../dynpages/news.jsp?earth=aa&gory=<%=procategoryId %>&pageNo=<%=pageNo+1%>" class="right-font08">下一页</a> | <a href="../dynpages/news.jsp?earth=aa&gory=<%=procategoryId %>&pageNo=<%=index%>" class="right-font08">末页</a>] </td>
                <td width="2%"><table width="29" border="0" cellspacing="0" cellpadding="0">
                   <!--  <tr>
                      <td width="1%"><input id="gopageNo" type="text" class="textfield" size="1" /></td>
                      <td width="87%"><input name="pagego" type="button" class="right-button06" onclick="passpageNo()" />
                      </td>
                    </tr> -->
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table> 
		 <%}
		 if("bb".equals(names)){
		  	int newsId =Integer.parseInt(request.getParameter("newsid"));
		     System.out.println(newsId);
		     WebsiteAction weba = new WebsiteAction();
		    List<News> list2=weba.news(newsId);
		     %>
			 <div>
				   <div style="text-align:center;color:#000000"> <%=list2.get(0).getTitle()%></div>
                  <div style="float:right;color:#000000;margin:10px 10px">时间： <%=list2.get(0).getDate()%></div>
                 	
                   <div style="width:870px;color:#000000;margin:40px 10px"><%=list2.get(0).getContents()%></div>
                   </div>
		 <%
		     
			}
	     
	     %>
	  </blockquote>
	 
	  </div>
              
   </body>
</html>