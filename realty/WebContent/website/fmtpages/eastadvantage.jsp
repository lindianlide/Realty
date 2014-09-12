<%@page import="com.realty.base.model.Project"%>
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
	 if(name=="bj"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p>青岛市东部土地房地产评估咨询有限公司始创于1996年,前身为青岛市高科技工业园房地产评估事务所，原隶属于崂山区国土资源与房屋管理局， 2001年脱钩改制，自改制以来一直与各区国土资源和房屋管理局、规划局、城乡建设委员会、拆迁局等政府部门保持良好的合作关系。现为中国土地估价师协会会员单位，山东省土地估价师协会常务理事单位。通过招标方式入围青岛市国土资源和房屋管理局《青岛市土地评估承办单位招标》土地评估机构。并入围青岛市 人民政府国有资产监督管理委员会土地评估备选机构。经青岛市建设委员会考核，入选《青岛市城市房屋拆迁评估机构名录》。</p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
     }  
	 if(name=="zz"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p>从公司成立至今一直具备房地产价格评估机构资格、土地评估估价中介机构、房产测绘资质三重资质，具备国土资源部颁发认证的在全国范围内从事土地评估业务的土地评估中介机构注册证书（注册号：A201137020），具备建设部颁发认证的房地产评估二级资质（证书编号：证书编号：鲁评022012），具备国家测绘地理信息局制发的测绘资质证书（等级及编号：丁测资字37002100），可同时为客户提供土地、房地产评估、房产测绘服务。</p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
     }  
	 if(name=="kh"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p>已在青岛市房地产行政主管部门及崂山区、城阳区等区市、黄岛开发区、青岛经济技术开发区保税区、胶州市、即墨市、胶南市、平度市房产、土地行政主管部门备案，入围青岛市国土资源和房屋管理局《青岛市土地评估承办单位招标》土地评估机构，入选《青岛市城市房屋拆迁评估机构名录》，并入围青岛市人民政府国有资产监督管理委员会土地评估备选机构，与政府机构及相关工作人员建立良好的信任与合作关系，熟悉相关机构的办事流程和要求。广泛开展抵押评估业务，获得建设、工商、农业、招商、恒丰、兴业、民生、上海浦东发展、深发展银行青岛分行、中国银行山东省分行、青岛华丰农村合作银行、青岛城阳农村合作银行等多家金融机构推荐入围资格，熟悉贷款审批程序，为客户提供抵押评估及贷款咨询服务，并可协助客户选择贷款银行。</p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
     }  
	 if(name=="js"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p>6月29日青岛市规划局对市北区青岛中央商务区A－3－19、A－3－21、A－3－22地块进行公示。该三地块为辽阳西路、绍兴路、吴兴路、海州路围合区域，规划用地总店地面积约3.51公顷。规划在西北和东南角各布置一栋商业、办公建筑，往后四排为南北通透的高层住宅，共2栋商业楼和8栋住宅楼，住宅部分为912户。公示时间为2011年6月29日-2011年7月1日，有意见可反馈至市规划局政务网站及公示现场意见箱。</p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
     }  
	 if(name=="fw"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p> 公司严格执行“专业、真诚、高效”的服务理念，通过公示的服务（热线）电话、网站、信箱，接受客户的服务咨询、使用意见反馈、投诉等事务。我司已建立成熟完善的《售后服务管理制度》，建立规范的客户跟踪服务以及客户回访制度，注重客户满意度评价，每项业务完成后，我们的客户服务人员会与客户进行回访，得到服务满意度的反馈以及我们在服务上有待改进的方面，并根据客户意见及时进行改进和完善。</p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
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
			<li><a href="eastadvantage.jsp?earth=bj">背景优势</a></li>	
			<li><a href="eastadvantage.jsp?earth=zz">资质优势</a></li>	
			<li><a href="eastadvantage.jsp?earth=kh">客户优势</a></li>		
			<li><a href="eastadvantage.jsp?earth=js">技术优势</a></li>
			<li><a href="eastadvantage.jsp?earth=fw">服务优势</a></li>
			</ul>
	</div>
	  <div id="panelfo-in3">
	  <font color="blue">东部优势：</font><br/>
	  <blockquote> <span id ="abcde">
	 	青岛市东部土地房地产评估咨询有限公司始创于1996年,前身为青岛市高科技工业园房地产评估事务所，原隶属于崂山区国土资源与房屋管理局， 2001年脱钩改制，自改制以来一直与各区国土资源和房屋管理局、规划局、城乡建设委员会、拆迁局等政府部门保持良好的合作关系。现为中国土地估价师协会会员单位，山东省土地估价师协会常务理事单位。通过招标方式入围青岛市国土资源和房屋管理局《青岛市土地评估承办单位招标》土地评估机构。并入围青岛市 人民政府国有资产监督管理委员会土地评估备选机构。经青岛市建设委员会考核，入选《青岛市城市房屋拆迁评估机构名录》。
	  </span>
		  </blockquote> 
	  </div>
              
   </body>
</html>