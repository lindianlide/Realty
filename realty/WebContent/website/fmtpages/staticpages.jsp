<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
 	String membername=(String)session.getAttribute("membername"); 
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
     
     var req;
     var urlstr = urlArgs();
     var name = urlstr.earth;
     if(name=="aa"){ 	
    	 document.onreadystatechange = function () {   
    	        if(document.readyState=="complete") {          
    	            // alert('ok');
    	             var namestr = document.getElementById("abcde");
    	             var allstr = "<table>";
    	             for(var i=0; i<6 ;i++){
    	            	 allstr=allstr + "<tr><td>" + i +".<a href='eastadvantage.jsp?earth=bb'>土地政策</a>" + "-------------------------------------" + i + "</td></tr>";
    	             }	    	           
    	             allstr+="</table>";
    	             namestr.innerHTML = allstr;
    	         }   
    	     };
     }
     if(name=="bb"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p>6月29日青岛市规划局对市北区青岛中央商务区A－3－19、A－3－21、A－3－22地块进行公示。该三地块为辽阳西路、绍兴路、吴兴路、海州路围合区域，规划用地总店地面积约3.51公顷。规划在西北和东南角各布置一栋商业、办公建筑，往后四排为南北通透的高层住宅，共2栋商业楼和8栋住宅楼，住宅部分为912户。公示时间为2011年6月29日-2011年7月1日，有意见可反馈至市规划局政务网站及公示现场意见箱。</p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
     }
/*      function earthcontent(){
    	 var namestr = document.getElementById("abcde");   	           
         var aerthstr = "asdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
         namestr.innerHTML = aerthstr;
     } */
     
     function altrcontent(){
    	 var namestr = document.getElementById("abcde");
         var allstr = "<table>";
         for(var i=0; i<6 ;i++){
        	 allstr=allstr + "<tr><td>" + i +".土地政策" + "-------------------------------------" + i + "</td></tr>";
         }	    	           
         allstr+="</table>";
         namestr.innerHTML = allstr;
     }
     function urlArgs(){ 
    	 var args = {}; 
    	 var query = location.search.substring(1); 
    	 var pairs = query.split('&'); 
    	 for(var i = 0; i < pairs.length; i++){ 
    	 var pos = pairs[i].indexOf('='); 
    	 if(pos == -1) continue; 
    	 var name = pairs[i].substring(0,pos); 
    	 var value = pairs[i].substring(pos + 1); 
    	 value = decodeURIComponent(value); 
    	 args[name] = value; 
    	 } 
    	 return args; 
     }
    </script>    
 </head>
<body>

         <!-- Header Start -->
<%@include file="/website/inc/header.inc"%>
<div class="marqueeSized">  </div> 
	<div id="panelfo-in2" >
	  <ul class="lmenu">
		<li class="level1">
			<a href="#none">土地政策</a>
			<ul class="level2">
				<li><a href="staticpages.jsp?earth=aa">土地政策--01</a></li>
				<li><a href="#" onclick="altrcontent()">土地政策--02</a></li>
				<li><a href="#none">土地政策--03</a></li>
				<li><a href="#none">土地政策--04</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none">新房政策</a>
			<ul class="level2">
				<li><a href="#none">新房政策--01</a></li>
				<li><a href="#none">新房政策--02</a></li>
				<li><a href="#none">新房政策--03</a></li>
				<li><a href="#none">新房政策--04</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none">二手房政策</a>
			<ul class="level2">
				<li><a href="#none">二手房政策--01</a></li>
				<li><a href="#none">二手房政策--02</a></li>
				<li><a href="#none">二手房政策--03</a></li>
				<li><a href="#none">二手房政策--04</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none">其他政策</a>
			<ul class="level2">
				<li><a href="#none">其他政策--01</a></li>
				<li><a href="#none">其他政策--02</a></li>
				<li><a href="#none">其他政策--03</a></li>
				<li><a href="#none">其他政策--04</a></li>
			</ul>
		</li>
	  </ul>
	</div>
	  <div id="panelfo-in3">
	  <font color="blue">最新政策：</font><br/>
	  <blockquote><span id="abcde"></span></blockquote> 
	  </div>
              
   </body>
</html>