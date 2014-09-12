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
	 if(name=="db"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p align='center'>一级市场</p><p>青岛市东部土地房地产评估咨询有限公司（原青岛市高科技工业园房地产评估事务所）创建于1996年，原隶属于崂山区国土资源与房屋管理局， 2001年脱钩改制，目前已拥有国土资源部颁发认证的可在全国范围内从事土地估价的资质、建设部颁发认证的房地产评估二级资质、国家测绘地理信息局制发的测绘资质证书（等级及编号：丁测资字37002100）、青岛市城乡建设委员会颁发的青岛市城市房屋拆迁承办资质，由中国注册土地估价师、中国注册房地产估价师、中国注册房地产经纪人、土地登记代理人等多名专业人士组成。</p> <p>公司目前为中国土地估价师协会会员单位、山东省土地估价师协会常务理事单位、青岛市拆迁估价协会常务理事单位、青岛市房地产经纪机构行业协会理事单位（行业协会自律公约签约单位）、2012年度青岛市房地产中介机构星级评定五星级单位、青岛市建设委员会公布的2011年度青岛市国有土地上房屋征收评估机构、2012-2014年度崂山区房屋征收（搬迁）类房地产评估机构、房屋征收（搬迁）承办机构。</p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
     }  
	 if(name=="qy"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p align='center'>二级市场</p><p>东部价值观：决不为一时的利益损失我们永久的信誉;勤勤恳恳工作，踏踏实实赚钱</p><p>东部服务观： 专业、真诚、高效</p><p>东部人才观： 给员工提供广阔的发展平台、良好的薪金待遇、完善的培训教育体系及快乐的工作氛围</p><p>东部发展观： 做知名的专业性、综合性房地产估价与投资咨询机构</p><p>东部经营理念： 以人才和技术为基础，提供超值可信的服务</p><p>估价师执业理念： 独立、诚信、创新</p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
     }  
	 if(name=="pg"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p align='center'>房地产评估</p><p align='center'><img  src='/realty/images/website/yyzz.jpg'></p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
     }  
	 if(name=="ch"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p align='center'>土地代理</p><p>6月29日青岛市规划局对市北区青岛中央商务区A－3－19、A－3－21、A－3－22地块进行公示。该三地块为辽阳西路、绍兴路、吴兴路、海州路围合区域，规划用地总店地面积约3.51公顷。规划在西北和东南角各布置一栋商业、办公建筑，往后四排为南北通透的高层住宅，共2栋商业楼和8栋住宅楼，住宅部分为912户。公示时间为2011年6月29日-2011年7月1日，有意见可反馈至市规划局政务网站及公示现场意见箱。</p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
     }  
	 if(name=="zz"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p align='center'>可行性研究</p><p> 公司严格执行“专业、真诚、高效”的服务理念，通过公示的服务（热线）电话、网站、信箱，接受客户的服务咨询、使用意见反馈、投诉等事务。我司已建立成熟完善的《售后服务管理制度》，建立规范的客户跟踪服务以及客户回访制度，注重客户满意度评价，每项业务完成后，我们的客户服务人员会与客户进行回访，得到服务满意度的反馈以及我们在服务上有待改进的方面，并根据客户意见及时进行改进和完善。</p>";
 	            namestr.innerHTML = aerthstr;
 	         }   
 	     };
     }  
	 if(name=="fc"){
    	 document.onreadystatechange = function () {   
 	        if(document.readyState=="complete") {          
 	        	var namestr = document.getElementById("abcde");   	           
 	            var aerthstr = "<p align='center'>房产测绘</p><p> 公司严格执行“专业、真诚、高效”的服务理念，通过公示的服务（热线）电话、网站、信箱，接受客户的服务咨询、使用意见反馈、投诉等事务。我司已建立成熟完善的《售后服务管理制度》，建立规范的客户跟踪服务以及客户回访制度，注重客户满意度评价，每项业务完成后，我们的客户服务人员会与客户进行回访，得到服务满意度的反馈以及我们在服务上有待改进的方面，并根据客户意见及时进行改进和完善。</p>";
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
			<li><a href="businessline.jsp?earth=db">一级市场</a></li>	
			<li><a href="businessline.jsp?earth=qy">二级市场</a></li>	
			<li><a href="businessline.jsp?earth=pg">房地产评估</a></li>		
			<li><a href="businessline.jsp?earth=ch">土地代理</a></li>
			<li><a href="businessline.jsp?earth=zz">可行性研究</a></li>
			<li><a href="businessline.jsp?earth=fc">房产测绘</a></li>
			</ul>
	</div>
	  <div id="panelfo-in3">
	  <font color="blue">业务范围：</font><br/>
	  <blockquote> <span id ="abcde">
	  
	 	青岛市东部土地房地产评估咨询有限公司始创于1996年,前身为青岛市高科技工业园房地产评估事务所，原隶属于崂山区国土资源与房屋管理局， 2001年脱钩改制，自改制以来一直与各区国土资源和房屋管理局、规划局、城乡建设委员会、拆迁局等政府部门保持良好的合作关系。现为中国土地估价师协会会员单位，山东省土地估价师协会常务理事单位。通过招标方式入围青岛市国土资源和房屋管理局《青岛市土地评估承办单位招标》土地评估机构。并入围青岛市 人民政府国有资产监督管理委员会土地评估备选机构。经青岛市建设委员会考核，入选《青岛市城市房屋拆迁评估机构名录》。
	  </span>
		  </blockquote> 
	  </div>
              
   </body>
</html>