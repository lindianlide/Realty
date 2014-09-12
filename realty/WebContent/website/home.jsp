<%@page import="com.realty.base.model.*"%>
<%@page import="com.realty.base.action.WebsiteAction"%>

<%@ page import="java.util.List" %> 
<%@ page import="com.realty.base.model.Project" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
 	String membername=(String)session.getAttribute("membername"); 
	String memrole = (String)session.getAttribute("memrole");
	System.out.print(membername);
	System.out.print(memrole);
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
      
      <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
      <!--[if lt IE 9]>
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
      <script src="/realty/js/website/respond.min.js"></script>
      <![endif]-->
      
      
   
   </head>
   <body class="home">
<%@include file="/website/inc/header.inc"%>
            <!-- Main Header End -->
         </header>
         <!-- Header End --> 
         <!-- Content Start -->

            <!-- 大图查询部分-->
 <section style="position: relative; z-index: 100;">
	<div class=" marqueeSized">
		<div style="opacity: 1;">
			<div class="zss_marquee_image">
				<ul id="picWrap">
					<li class="pic_panel">
						<img src="/realty/images/website/1.jpg" alt="" /></li>
					
				</ul>
			</div>
		</div>
	</div>
	 <div class="homepageBox marqueeSized" style="border:none;"> 
		<div class="searchWrapper">
			<div class="homepageSearch">
				<div class="searchHeader">买房 卖房 租房 先查价 一房给你一个指导价</div>
				<div class="searchbar clearfix">
					<div class="input_search_wrapper">
						<label>
							<input id="key" type="text" value="输入楼盘名或地址，尝试全新地图找房模式" onfocus="if(this.value=='输入楼盘名或地址，尝试全新地图找房模式'){this.value='';$(this).css('color','#333')}" onblur="if(this.value==''){this.value='输入楼盘名或地址，尝试全新地图找房模式';$(this).css('color','#999')}" />
							<!-- <input type="hidden" value="qingdao" name="city" id="city" /> -->
						</label>
					</div>
					<input type="submit" id="search"  />
					<a href="/realty/website/building/serbuilding.jsp">查找</a>
					<!-- 下拉菜单推荐 -->
					<!-- <div id="suggestList" class="select_item cleaefix shadow1" style="display: none;"></div>
					<div id="suggestTemplate" style="display: none;">
						<dl class="" url="$Url">
							<dt class="clearfix"><span class="prj_name">
								<a href="$Url" title="$Tip$NameList" target="_blank" onclick="if(MapConfig.MapData.SearchID){visitUnit('$Tip$NameList','$Url');}">$Tip<span>$NameList</span><span title="$BatchTypeCode">$BatchType</span>
									<em class="icon_$Category"></em>
								</a></span>
								<span class="prj_qt"><cite>$RoomTotal套估价报告</cite></span>
							</dt>
							<dd class="clearfix">
								<span class="prj_adress">$OfficalAddr</span> <span class="prj_area"><a href="$RegionUrl">[$Region]</a> </span>
							</dd>
						</dl>
					</div>
				</div> -->
				
			</div>
		</div>
	</div>
	</div> 
</section>
                
            

 <div id="panel-all">
<div id="panel-in2">
<div height="200px">
<img alt="" src="../images/website/home/fbkj.png" width="300px"; height="200px";>
</div>
<div style="color:#000000;font-size:13px;">
由中国房产信息集团主持设计，历经11年的基础数据准备和理论研究积累，经多方专家论证及严密计算，让用户得到的报告更加权威专业。
</div>
</div>
<div id="panel-in3">
<div height="200px">
<img alt="" src="../images/website/home/jsqm.png" width="300px"; height="200px";>
</div>
<div style="color:#000000;font-size:13px;">用户仅需选出住宅地址，评估报告便可一键即得，手机体验、微博分享、下载、打印随时随地，估价从此变轻松。
</div>
</div>
<div id="panel-in4">
<div height="200px">
<img alt="" src="../images/website/home/qwzy.png" width="300px"; height="200px";>
</div>
<div style="color:#000000;font-size:13px;">时时监测新房和二手房的相关成交以及市场调研数据，通过专业计算，分析得出详实的价格变动趋势，定期发布全国重点城市的房价指数报告。 </div>
</div>
<div id="panel-in5">
<div style="background:url(../images/website/home/qlan.png);color:#007799">政策法规</div>

<div><%
WebsiteAction weba = new WebsiteAction();
	List<Law> list4 = weba.laws();
	for(int i=0;i<5&&i<list4.size();i++)
	{
		String lawString=list4.get(i).getName();
		if(lawString.length()>21)
			{lawString=lawString.substring(0,21)+"...";}
	%>
	<p><a href="dynpages/laws.jsp?earth=bb&&lawid=<%=list4.get(i).getLawId()%>" >  <%=lawString%></a></p>
	<%}
%></div></div>
<div id="panel-in6">
<div style="background:url(../images/website/home/qlan.png);color:#00688B">重要项目</div>
<div><%

	List<Project> list1 = weba.projects();
	for(int i=0;i<5&&i<list1.size();i++)
	{
		String projectString=list1.get(i).getTitle();
		if(projectString.length()>21)
			{projectString=projectString.substring(0,21)+"...";}
	%>
	<p><a href="dynpages/projects.jsp?earth=bb&&projectid=<%=list1.get(i).getProjectId()%>" ><%=projectString%></a></p>
	<%}
%></div></div>
<div id="panel-in7">
<div style="background:url(../images/website/home/qlan.png);color:#00688B">新闻动态</div>
<div><%
	
	List<News> list2 = weba.newsList(1);
	for(int i=0;i<5&&i<list2.size();i++)
	{
		String newsString=list2.get(i).getTitle();
		if(newsString.length()>21)
			{newsString=newsString.substring(0,21)+"...";}
	%>
	<p><a href="dynpages/news.jsp?earth=bb&&newsid=<%=list2.get(i).getNewsId()%>" ><%=newsString%></a></p>
	<%}
%></div></div>
 <div id="panel-in8">
<div style="background:url(../images/website/home/qlan.png);color:#00688B">研究发布</div>

<div><%

	List<Research> list5 = weba.researchList(1);
	for(int i=0;i<5&&i<list5.size();i++)
	{
	String rearchString=list5.get(i).getTitle();
		if(rearchString.length()>21)
			{rearchString=rearchString.substring(0,21)+"...";}
	%>
	<p><a href="dynpages/research.jsp?earth=bb&&researchid=<%=list5.get(i).getReschId()%>" ><%=rearchString%></a></p>
	<%}
%></div></div>
<div id="panel-in9">
<div style="background:url(../images/website/home/qlan.png);color:#00688B">企业文化</div>
<div><%

	List<Culture> list6 = weba.cultureList(1);
	for(int i=0;i<5&&i<list6.size();i++)
	{
	String culterString=list6.get(i).getTitle();
		if(culterString.length()>21)
			{culterString=culterString.substring(0,21)+"...";}
	%>
	<p><a href="dynpages/cultures.jsp?earth=bb&&cultureid=<%=list6.get(i).getCultureId()%>" ><%=culterString%></a></p>
	<%}
%></div></div>
<div id="panel-in10">
<div style="background:url(../images/website/home/qlan.png);color:#00688B">新闻动态</div>
<div><%
	
	List<News> list7 = weba.newsList(1);
	for(int i=0;i<5&&i<list2.size();i++)
	{
	String newsString=list2.get(i).getTitle();
		if(newsString.length()>21)
			{newsString=newsString.substring(0,21)+"...";}
	%>
	<p><a href="dynpages/news.jsp?earth=bb&&newsid=<%=list2.get(i).getNewsId()%>" ><%=newsString%></a></p>
	<%}
%></div></div>
 </div>  

 <div id="panel-in11" >
 <span style=" text-align:center;display:block;">
版权所有:青岛东部土地房地产评估咨询有限公司(2014-2015) All Rights Reserved </span>
 <span style="text-align:center;display:block;">
 地址:青岛市崂山区苗岭路19号裕龙大厦    电话（传真）:0532-88967556/88967558  邮箱:dongbu-901@163.com</span>
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