package com.realty.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import net.sf.json.JSONObject;

import com.realty.base.action.BuildingAction;
import com.realty.base.action.LandAction;
import com.realty.base.action.LandallotAction;
import com.realty.base.action.LandzpgAction;
import com.realty.base.model.Building;
import com.realty.base.model.Land;
import com.realty.base.model.LandAllot;
import com.realty.base.model.LandMutiusage;
import com.realty.base.model.LandPoss;
import com.realty.base.model.LandSellway;
import com.realty.base.model.LandUsage;


/**
 * Servlet implementation class LandServlet
 */
@WebServlet("/LandServlet")
public class LandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		 response.setHeader("Cache-Control", "no-store");  
		 response.setHeader("Pragma", "no-cache");  
		 response.setDateHeader("Expires", 0); 
		response.setContentType("text/html;charset=UTF-8");//解决乱码问题,没有这句，回调函数的内容可能乱码
		
		 int landId=0;String landName=null;int landpossId=0; int landsellwayId=0;int landusageId=0;Date auctionTime=null;
		 Integer regionId=null;String address=null; String landLevel=null;String landExploit=null;String heightLimit=null;
		 Double landArea=null;String plotRatio=null; String buildingDensity=null;String greeningRatio=null;
		 Integer sellYear=null;Double planArea=null;Double initialPrice=null;Double builddealPrice=null;
		 Double landdealPrice=null;Double dealTotle=null;String premiumRate=null;String buyer=null;
		 Date dealDate=null;String sellAnnounce=null;String dealAnnounce=null;String landmap=null;
		 String landIntr=null;String projectIntro=null;Double longitude=null;Double latitude=null;
		 Integer entryId=null;String entryName=null;Date entryTime=null;String auditName=null;
		 Date auditTime=null;Integer status=null;String remarks=null;
		 String landNumber=null; Date announceTime=null; Date zpgTime=null;Double landAllarea=null;
		 Double planAllarea=null;String dealAnnonumber=null;String sellAnnonumber=null;int allotFlag=1;
			 int useyear=0;
			 Double dealPrice=null; String select_else=null;
		 PrintWriter out = response.getWriter();
		
		String flag=request.getParameter("flag");
		
		String bname= request.getParameter("bname"); 
		/*
		 * 土地添加
		 * */
		if(flag.equals("1")){
			
			 address=request.getParameter("address");
			 landNumber=request.getParameter("landNumber");
			 String regionId1=request.getParameter("regionId");
			 regionId = Integer.parseInt(regionId1); 
			
			 String announceTime1=request.getParameter("announceTime");
			 if(announceTime1.equals("")||announceTime1.equals("null"))
				 announceTime=null;
			 else{
				 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				try {
					announceTime = sdf1.parse(announceTime1);
					} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				 }
			 String zpgTime1=request.getParameter("zpgTime");
			 if(zpgTime1.equals("")||zpgTime1.equals("null"))
				 zpgTime=null;
			 else{
				 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				try {
					zpgTime = sdf1.parse(zpgTime1);
					} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				 }
			 String landAllarea1=request.getParameter("landAllarea");
			 if(landAllarea1.equals("")||landAllarea1.equals("null"))
				 landAllarea=null;
			 else landAllarea = Double.parseDouble(landAllarea1);
			 
			 String planAllarea1=request.getParameter("planAllarea");
			 if(planAllarea1.equals("")||planAllarea1.equals("null"))
				 planAllarea=null;
			 else planAllarea = Double.parseDouble(planAllarea1);
			 
			 plotRatio=request.getParameter("plotRatio");
			  buildingDensity=request.getParameter("buildingDensity");
			  greeningRatio=request.getParameter("greeningRatio");

			 String landSellway1=request.getParameter("landSellway");
			 landsellwayId = Integer.parseInt(landSellway1); 
			
			 
			 String dealTotle1=request.getParameter("dealTotle");
			 if(dealTotle1.equals("")||dealTotle1.equals("null"))
				 dealTotle=null;
			 else dealTotle =  Double.parseDouble(dealTotle1);
			 buyer=request.getParameter("buyer");
			 String allotFlag1=request.getParameter("allotFlag");
			 allotFlag = Integer.parseInt(allotFlag1); 
			 
			 entryName=request.getParameter("entryName");
			 String entryTime1=request.getParameter("entryTime");
			 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					entryTime = sdf1.parse(entryTime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				remarks=request.getParameter("remarks");
				LandAction landaction=new LandAction();
				Land land1=new Land();
				land1.setAddress(address);
				land1.setLandNumber(landNumber);
				land1.setRegionId(regionId);
				land1.setAnnounceTime(announceTime);
				land1.setZpgTime(zpgTime);
				land1.setLandAllarea(landAllarea);
				land1.setPlanAllarea(planAllarea);
				land1.setPlotRatio(plotRatio);
				land1.setBuildingDensity(buildingDensity);
				land1.setGreeningRatio(greeningRatio);
				
				LandSellway landsellway=new LandSellway();
				landsellway.setSellwayId(landsellwayId);
				land1.setLandSellway(landsellway);
				land1.setDealTotle(dealTotle);
				land1.setBuyer(buyer);
				land1.setAllotFlag(allotFlag);
				land1.setEntryName(entryName);
				land1.setEnrtyTime(entryTime);
				land1.setRemarks(remarks);
				
			     Land landsave=landaction.save(land1);
			     landId=landsave.getLandId();
				// int i=landaction.landList().size()-1;
				// landId=landaction.landList().get(i).getLandId();
				 
				 //JOptionPane.showMessageDialog(null, "增加成功！");  
				 //response.getWriter().print("<script> alert(\"增加成功!\"); </script>");
				 response.sendRedirect("./manage/data/land/land_modify.jsp?landId="+landId+"");
			/* }
			 else{
				// response.getWriter().print("<script> alert(\"增加失败!\"); </script>");
				 JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
				response.sendRedirect("./manage/data/land/land_add.jsp");
			 }
			 */
		}
		
		/*
		 * 土地修改
		 * */
		  if(flag.equals("2")){
			  
			  	int initialPriceTol=0;int dealPriceTol=0;
				 String landId1=request.getParameter("landId");
				  landId = Integer.parseInt(landId1);
				  address=request.getParameter("address");
					 landNumber=request.getParameter("landNumber");
					 String regionId1=request.getParameter("regionId");
					 regionId = Integer.parseInt(regionId1); 
					
					 String announceTime1=request.getParameter("announceTime");
					 if(announceTime1.equals("")||announceTime1.equals("null"))
						 announceTime=null;
					 else{
						 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
						try {
							announceTime = sdf1.parse(announceTime1);
							} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							}
						 }
					 String zpgTime1=request.getParameter("zpgTime");
					 if(zpgTime1.equals("")||zpgTime1.equals("null"))
						 zpgTime=null;
					 else{
						 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
						try {
							zpgTime = sdf1.parse(zpgTime1);
							} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							}
						 }
					 String landAllarea1=request.getParameter("landAllarea");
					 if(landAllarea1.equals("")||landAllarea1.equals("null"))
						 landAllarea=null;
					 else landAllarea = Double.parseDouble(landAllarea1);
					 
					 String planAllarea1=request.getParameter("planAllarea");
					 if(planAllarea1.equals("")||planAllarea1.equals("null"))
						 planAllarea=null;
					 else planAllarea = Double.parseDouble(planAllarea1);
					 
					 plotRatio=request.getParameter("plotRatio");
					  buildingDensity=request.getParameter("buildingDensity");
					  greeningRatio=request.getParameter("greeningRatio");

					  String initialPriceTol1=request.getParameter("initialPriceTol");
					  if(initialPriceTol1.equals("")||initialPriceTol1.equals("null"))
						  initialPriceTol=0;
						else
							{initialPriceTol=Integer.parseInt(initialPriceTol1);}

					  String dealPriceTol1=request.getParameter("dealPriceTol");	
					  if(dealPriceTol1.equals("")||dealPriceTol1.equals("null"))  
						  dealPriceTol=0;
						else
							{dealPriceTol=Integer.parseInt(dealPriceTol1);}
					  
					 String landSellway1=request.getParameter("landSellway");
					 landsellwayId = Integer.parseInt(landSellway1); 
					
					 
					 String dealTotle1=request.getParameter("dealTotle");
					 if(dealTotle1.equals("")||dealTotle1.equals("null"))
						 dealTotle=null;
					 else dealTotle =  Double.parseDouble(dealTotle1);
					 buyer=request.getParameter("buyer");
					 sellAnnonumber=request.getParameter("sellAnnonumber");
					 dealAnnonumber=request.getParameter("dealAnnonumber");
					 projectIntro=request.getParameter("projectIntro");
					 landIntr=request.getParameter("landIntr");
				
				 String longitude1=request.getParameter("longitude");
					if(longitude1.equals("")||longitude1.equals("null"))
						longitude=null;
					else
						longitude = Double.parseDouble(longitude1);
					
					String latitude1=request.getParameter("latitude");
					if(latitude1.equals("")||latitude1.equals("null"))
						latitude=null;
					else
						latitude = Double.parseDouble(latitude1);
					 //Integer entryId,未加上
				 entryName=request.getParameter("entryName");
				 String entryTime1=request.getParameter("entryTime");
				 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					try {
						entryTime = sdf2.parse(entryTime1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 
			String status1=request.getParameter("status");
			 status=Integer.parseInt(status1);
			 if(status==1){
				 auditName= (String)request.getSession().getAttribute("managername");
				// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				 //auditTime=df.format(new Date());// new Date()为获取当前系统时间
				    Calendar c = Calendar.getInstance();
				    auditTime = c.getTime();
			 }
		    remarks=request.getParameter("remarks");
		    LandAction landaction=new LandAction();
		    Land land2=new Land();
		    land2.setLandId(landId);
			land2.setLandName(landName);
			LandPoss landposs=new LandPoss();
			landposs.setLandpossId(landpossId);
			land2.setLandPoss(landposs);
			
			LandSellway landsellway=new LandSellway();
			landsellway.setSellwayId(landsellwayId);
			land2.setLandSellway(landsellway);
			
			/*LandUsage landusage=new LandUsage();
			landusage.setUsageId(landusageId);
			land2.setLandUsage(landusage);*/
			land2.setAuctionTime(auctionTime);land2.setRegionId(regionId);
			land2.setAddress(address);land2.setLandLevel(landLevel);land2.setLandExploit(landExploit);
			land2.setHeightLimit(heightLimit);land2.setLandArea(landArea);land2.setPlotRatio(plotRatio);
			land2.setBuildingDensity(buildingDensity);land2.setGreeningRatio(greeningRatio);
			
			land2.setSellYear(sellYear);land2.setPlanArea(planArea);
			land2.setInitialPrice(initialPriceTol);land2.setBuilddealPrice(dealPriceTol);
			land2.setLanddealPrice(landdealPrice);land2.setDealTotle(dealTotle);
			land2.setPremiumRate(premiumRate);land2.setBuyer(buyer);land2.setDealDate(dealDate);
			land2.setSellAnnounce(sellAnnounce);land2.setDealAnnounce(dealAnnounce);land2.setLandmap(landmap);
			land2.setLandIntr(landIntr);land2.setProjectIntro(projectIntro);
			land2.setLongitude(longitude);land2.setLatitude(latitude);land2.setEntryId(entryId);
			land2.setEntryName(entryName);land2.setEnrtyTime(entryTime);land2.setAuditName(auditName);
			land2.setAuditTime(auditTime);land2.setStatus(status);land2.setRemarks(remarks);
			land2.setDealAnnonumber(dealAnnonumber);land2.setSellAnnonumber(sellAnnonumber);
			land2.setLandNumber(landNumber);land2.setAnnounceTime(announceTime);land2.setZpgTime(zpgTime);
			land2.setLandAllarea(landAllarea);land2.setPlanAllarea(planAllarea);land2.setAllotFlag(allotFlag);
			  
			landaction.update(land2);
			
				 //JOptionPane.showMessageDialog(null, "修改成功！"); 
				 //response.getWriter().print("<script> alert(\"修改成功!\"); </script>");
				 response.sendRedirect("./manage/data/land/landmain_detail.jsp?landId="+landId+"");
				 
			/* else{
				 //response.getWriter().print("<script> alert(\"增加失败!\"); </script>");
			 JOptionPane.showMessageDialog(null, "修改失败!", "标题",JOptionPane.WARNING_MESSAGE);  
			 response.sendRedirect("./manage/data/land/land_modify.jsp");
			 }*/
		}
		  /*
		   * 土地删除
		   * */
		  if(flag.equals("3")){
				landId=Integer.parseInt(request.getParameter("landId"));
				Land landdel=new Land();
				landdel.setLandId(landId);
				LandAction landaction=new LandAction();
				
				landaction.delete(landdel);
				
			    response.sendRedirect("./manage/data/land/land_manage.jsp");
				/*else
				{
					JOptionPane.showMessageDialog(null, "该信息不能删除!", "标题",JOptionPane.WARNING_MESSAGE); 
				    response.sendRedirect("./manage/data/land/land_manage.jsp");
				}*/
			}
		  /*
		   * 土地导航
		   * 	*/  
		if(flag.equals("4")){
			//String[] searchchar1 = request.getParameterValues("searchChar");  
			String searchcharg = request.getParameterValues("searchChar")[0].trim();
			 String[] searchchars = searchcharg.split(",");
			  int[] searchchar = { 0, 0, 0, 0};
			  //String to int
			  for (int i = 0; i < searchchars.length; i++) {
				  searchchar[i] = Integer.parseInt(searchchars[i]);
			    }
			  LandAction landaction=new LandAction();
			  int count=landaction.landCount(searchchar[0], searchchar[1], searchchar[2],null);
			  int pageSize=10;
			  int index=0;
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
			  int pageNo1=pageNo-1;
			  int pageNo2=pageNo+1;
			
				List<Land> result=landaction.landSearch(searchchar[0], searchchar[1], searchchar[2],null,pageNo,pageSize);
			
		      	if(result.size()>0){
		      	out.println("<table width='742' cellpadding=0 cellspacing=0>");
		       	out.println("<tr>"
		      			   + "<td>土地名</td>"
		      			   + "<td>区域</td>"
		      			   + "<td>土地用途</td>"
		      			   + "<td>成交价格</td>"
		      			   + "<td>操作</td>");
		      			 out.println("</tr>");
		      	for(int i=0;i<result.size();i++){
		      		String landAddress=result.get(i).getAddress();
      				if(landAddress!=null){
	      			 	  if(landAddress.length()>20)
	      				{landAddress=landAddress.substring(0,20)+"...";}  
      				}
		      	out.println("<tr>"
		      			   + "<td><a href='manage/data/land/land_detail.jsp?landId="+result.get(i).getLandId()+"' <span>"+landAddress+"</span> </a> </td>"
		      			   + "<td><span>"+result.get(i).getAnnounceTime()+"</span></td>"
		      			   + "<td><span>"+result.get(i).getZpgTime()+"</span></td>"
		      			   + "<td><span>"+result.get(i).getBuyer()+"</span></td>"
		      			   + "<td><a href='LandServlet?flag=3&landId="+result.get(i).getLandId()+" ' onclick='return del_sure()' ><span>删除</span></a>  <a href='manage/data/land/land_modify.jsp?landId="+result.get(i).getLandId()+"'<span>修改</span></a></td>"
		      			   +"</tr>");
		      	}
		      	out.println("<tr>"
    			 		+" <td colspan='5' >"
    			 		+" <table style='border:0px;'  width='100%' class='right-font08'>");
     out.println("<tr>");
     out.println("<td style='border:0px;' width='50%'>共 <span class='right-text09'>"+index+"</span> 页 | 第 <span class='right-text09'>"+pageNo+"</span> 页</td>");
     out.println(" <td style='border:0px;' width='48%' align='right'>[<a href='manage/data/land/land_manages.jsp?pageNo=1&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>首页</a> | <a href='manage/data/land/land_manages.jsp?pageNo="+pageNo1+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>上一页</a> | <a href='manage/data/land/land_manages.jsp?pageNo="+pageNo2+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>下一页</a> | <a href='manage/data/land/land_manages.jsp?pageNo="+index+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>末页</a>] 转至：</td>");
     out.println("<td style='border:0px;' width='2%'>"
    	                +"<table style='border:0px;' width='29'>"
    	                    +"<tr>"
    	                     +" <td style='border:0px;' width='1%'><input id='gopageNo' type='text' class='textfield' size='1' /></td>"
    	                      +"<td style='border:0px;' width='87%'><input name='pagego' type='button' class='right-button06' onclick='passpageNo()' />"
    	                     +" </td>"
    	                    +"</tr>"
    	               +" </table></td>"
    	             +" </tr>"
    	         +" </table></td>"
    	       +" </tr>");
		      	out.println("</table>");
		      				out.close();
		      	}
		      	
		      	else{
			      	out.println("<table width='742'>"
			      	+"<tr>"
					+" <td> <span>没有相应信息 </span></td>"
					+"</tr>"
					+"</table>");
					out.close();

		      	}
	
		}
		/*
		
		if(flag.equals("11")){
			//String[] searchchar1 = request.getParameterValues("searchChar");  
			String searchcharg = request.getParameterValues("searchChar")[0].trim();
			 String[] searchchars = searchcharg.split(",");
			  int[] searchchar = { 0, 0, 0, 0};
			  //String to int
			  for (int i = 0; i < searchchars.length; i++) {
				  searchchar[i] = Integer.parseInt(searchchars[i]);
			    }
			  LandAction landaction=new LandAction();
			  
			  int count=landaction.landCount(searchchar[0], searchchar[1], searchchar[2],bname);
			  int pageSize=10;
			  int index=0;
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
			  int pageNo1=pageNo-1;
			  int pageNo2=pageNo+1;
			
				List<Land> result=landaction.landSearch(searchchar[0], searchchar[1], searchchar[2],bname,pageNo,pageSize);
		      	if(result.size()>0){
		      		out.println("<table width='799px'>");
		      		for(int i=0;i<result.size();i++){
		      		 List landPhotoList=landaction.landPhoto(result.get(i).getLandId(),"land_photo");
      				 if(!landPhotoList.isEmpty()){
		      	out.println("<tr height='150'>"
		      				+"<td width='150'><img style='width:150px;height:170px;' alt='' src='picupload/land/"+landPhotoList.get(0)+"'></td>"
		      			   + "<td><a href='website/land/landintro.jsp?landId="+result.get(i).getLandId()+"' <span>"+result.get(i).getLandName()+"</span> </a> "
		      			   + "<span>"+result.get(i).getRegionId()+"</span>"
		      			   
		      			   + "<td><span>"+result.get(i).getLanddealPrice()+"</span></td>"
		      			   
		      			   +"</tr>");
		      	}else{
		      		out.println("<tr height='150'>"
		      				+"<td width='150'>无图片</td>"
		      			   + "<td><a href='website/land/landintro.jsp?landId="+result.get(i).getLandId()+"' <span>"+result.get(i).getLandName()+"</span> </a> "
		      			   + "<span>"+result.get(i).getRegionId()+"</span>"
		      			  
		      			   + "<td><span>"+result.get(i).getLanddealPrice()+"</span></td>"
		      			   +"</tr>");
		      	}
		      		}
		      	out.println("<tr style='border-left:0px;border-right:0px;border-down:0px;'>"
      			 		+" <td colspan='5' >"
      			 		+" <table style='border:0px;'  width='100%' class='right-font08'>");
       out.println("<tr>");
       out.println("<td style='border:0px;' width='50%'>共 <span class='right-text09'>"+index+"</span> 页 | 第 <span class='right-text09'>"+pageNo+"</span> 页</td>");
       out.println(" <td style='border:0px;' width='48%' align='right'>[<a href='website/building/serbuilding.jsp?pageNo=1&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>首页</a> | <a href='manage/data/serbuilding.jsp?pageNo="+pageNo1+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>上一页</a> | <a href='website/building/serbuilding.jsp?pageNo="+pageNo2+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>下一页</a> | <a href='website/building/serbuilding.jsp?pageNo="+index+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>末页</a>] 转至：</td>");
       out.println("<td style='border:0px;' width='2%'>"
      	                +"<table style='border:0px;' width='29'>"
      	                    +"<tr>"
      	                     +" <td style='border:0px;' width='1%'><input id='gopageNo' type='text' class='textfield' size='1' /></td>"
      	                      +"<td style='border:0px;' width='87%'><input name='pagego' type='button' class='right-button06' onclick='passpageNo()' />"
      	                     +" </td>"
      	                    +"</tr>"
      	               +" </table></td>"
      	             +" </tr>"
      	         +" </table></td>"
      	       +" </tr>");
		      	out.println("</table>");
		      				out.close();
		      	}
		      	}*/
		
		  /*
		   * 土地招拍挂添加
		   * */
		  if(flag.equals("5")){
			  	
				landId=Integer.parseInt(request.getParameter("landId"));
				LandzpgAction landzpgaction=new LandzpgAction();
				  landusageId=Integer.parseInt(request.getParameter("landusageId"));
				  if(landusageId==4)
				  {
					 select_else=request.getParameter("select_else"); 
						LandAction landaction=new LandAction();
						landaction.landusageAdd(0, select_else);
						landusageId=landaction.getMaxId("land_usage");
				  }
				  String landArea1=request.getParameter("landArea");
				  if(landArea1.equals("")||landArea1.equals("null"))
					  landArea=0.0;
					else
				  landArea=Double.parseDouble(landArea1);
				  
				  String planArea1=request.getParameter("planArea");	
				  if(planArea1.equals("")||planArea1.equals("null"))
					  planArea=0.0;
					else
				  planArea=Double.parseDouble(planArea1);
				  
				  landLevel=request.getParameter("landLevel");
				  String useyear1=request.getParameter("useyear");
				  if(useyear1.equals("")||useyear1.equals("null"))
					  useyear=0;
					else
				  useyear=Integer.parseInt(useyear1);

				  String initialPrice1=request.getParameter("initialPrice");
				  if(initialPrice1.equals("")||initialPrice1.equals("null"))
					  initialPrice=0.0;
					else
				  initialPrice=Double.parseDouble(initialPrice1);

				  String dealPrice1=request.getParameter("dealPrice");	
				  if(dealPrice1.equals("")||dealPrice1.equals("null"))
					  dealPrice=0.0;
					else
				  dealPrice=Double.parseDouble(dealPrice1);
				  
				  remarks=request.getParameter("remarks");	
					LandMutiusage landzpg=new LandMutiusage();
					landzpg.setLandId(landId);
					landzpg.setLandusageId(landusageId);
					landzpg.setLandArea(landArea);
					landzpg.setPlanArea(planArea);
					landzpg.setLandLevel(landLevel);
					landzpg.setUseyear(useyear);
					landzpg.setInitialPrice(initialPrice);
					landzpg.setDealPrice(dealPrice);
					landzpg.setRamarks(remarks);
				landzpgaction.save(landzpg);
				
			    response.sendRedirect("./manage/data/land/landzpg_list.jsp?landId="+landId+"");
				/*else
				{
					JOptionPane.showMessageDialog(null, "该信息不能删除!", "标题",JOptionPane.WARNING_MESSAGE); 
				    response.sendRedirect("./manage/data/land/land_manage.jsp");
				}*/
			}
		  /*
		   * 土地招拍挂删除
		   * */
		  if(flag.equals("6")){
			  int mutiusageId=Integer.parseInt(request.getParameter("mutiusageId"));
				landId=Integer.parseInt(request.getParameter("landId"));
				LandzpgAction landzpgaction=new LandzpgAction();
				 
					LandMutiusage landzpgdel=new LandMutiusage();
					landzpgdel.setMutiusageId(mutiusageId);
					landzpgdel.setLandId(landId);
				landzpgaction.delete(landzpgdel);
				
			    response.sendRedirect("./manage/data/land/landzpg_list.jsp?landId="+landId+"");
		  }
		  /*
		   * 土地招拍挂修改
		   * */
		  if(flag.equals("7")){
			  int mutiusageId=Integer.parseInt(request.getParameter("mutiusageId"));
				landId=Integer.parseInt(request.getParameter("landId"));
				landusageId=Integer.parseInt(request.getParameter("landusageId"));
				if(landusageId==4)
				  {
						select_else=request.getParameter("select_else"); 
						LandAction landaction=new LandAction();
						landaction.landusageAdd(0, select_else);
						landusageId=landaction.getMaxId("land_usage");
				  }
				  String landArea1=request.getParameter("landArea");
				  if(landArea1.equals("")||landArea1.equals("null"))
					  landArea=0.0;
					else
				  landArea=Double.parseDouble(landArea1);
				  
				  String planArea1=request.getParameter("planArea");	
				  if(planArea1.equals("")||planArea1.equals("null"))
					  planArea=0.0;
					else
				  planArea=Double.parseDouble(planArea1);
				  
				  landLevel=request.getParameter("landLevel");
				  String useyear1=request.getParameter("useyear");
				  if(useyear1.equals("")||useyear1.equals("null"))
					  useyear=0;
					else
				  useyear=Integer.parseInt(useyear1);

				  String initialPrice1=request.getParameter("initialPrice");
				  if(initialPrice1.equals("")||initialPrice1.equals("null"))
					  initialPrice=0.0;
					else
				  initialPrice=Double.parseDouble(initialPrice1);

				  String dealPrice1=request.getParameter("dealPrice");	
				  if(dealPrice1.equals("")||dealPrice1.equals("null"))
					  dealPrice=0.0;
					else
				  dealPrice=Double.parseDouble(dealPrice1);
				  
				  remarks=request.getParameter("remarks");	
				LandzpgAction landzpgaction=new LandzpgAction();
				 
					LandMutiusage landzpgmod=new LandMutiusage();
					landzpgmod.setMutiusageId(mutiusageId);
					landzpgmod.setLandId(landId);
					landzpgmod.setLandusageId(landusageId);
					landzpgmod.setLandArea(landArea);
					landzpgmod.setPlanArea(planArea);
					landzpgmod.setLandLevel(landLevel);
					landzpgmod.setUseyear(useyear);
					landzpgmod.setInitialPrice(initialPrice);
					landzpgmod.setDealPrice(dealPrice);
					landzpgmod.setRamarks(remarks);
				landzpgaction.update(landzpgmod);
				
			    response.sendRedirect("./manage/data/land/landzpg_list.jsp?landId="+landId+"");
		  }
		  /*
		   * 土地划拨添加
		   * */
		  if(flag.equals("10")){
				landId=Integer.parseInt(request.getParameter("landId"));
				LandallotAction landallotaction=new LandallotAction();
				  landusageId=Integer.parseInt(request.getParameter("landusageId"));
				  if(landusageId==4)
				  {
						select_else=request.getParameter("select_else"); 
						LandAction landaction=new LandAction();
						landaction.landusageAdd(0, select_else);
						landusageId=landaction.getMaxId("land_usage");
				  }
				  String landArea1=request.getParameter("landArea");
				  if(landArea1.equals("")||landArea1.equals("null"))
					  landArea=0.0;
					else
				  landArea=Double.parseDouble(landArea1);
				  
				  String planArea1=request.getParameter("planArea");	
				  if(planArea1.equals("")||planArea1.equals("null"))
					  planArea=0.0;
					else
				  planArea=Double.parseDouble(planArea1);
				  int houseNum=0;
				  String houseNum1=request.getParameter("houseNum");
				  if(houseNum1.equals("")||houseNum1.equals("null"))
					  houseNum=0;
					else
				   houseNum=Integer.parseInt(houseNum1);
  
				  remarks=request.getParameter("remarks");	
				  LandAllot landallotadd=new LandAllot();
				  landallotadd.setLandId(landId);
				  landallotadd.setLandusageId(landusageId);
				  landallotadd.setLandArea(landArea);
				  landallotadd.setPlanArea(planArea);
				  landallotadd.setHousenum(houseNum);
					landallotadd.setRemarks(remarks);
					landallotaction.save(landallotadd);
				
			    response.sendRedirect("./manage/data/land/landallot_list.jsp?landId="+landId+"");
				/*else
				{
					JOptionPane.showMessageDialog(null, "该信息不能删除!", "标题",JOptionPane.WARNING_MESSAGE); 
				    response.sendRedirect("./manage/data/land/land_manage.jsp");
				}*/
			}
		  /*
		   * 土地划拨删除
		   * */
		  if(flag.equals("11")){
			  int landallotId=Integer.parseInt(request.getParameter("landallotId"));
				landId=Integer.parseInt(request.getParameter("landId"));
				LandallotAction landallotaction=new LandallotAction();
				 
				LandAllot landallotdel=new LandAllot();
					landallotdel.setLandallotId(landallotId);
					landallotdel.setLandId(landId);
				landallotaction.delete(landallotdel);
				
			    response.sendRedirect("./manage/data/land/landallot_list.jsp?landId="+landId+"");
		  }
		  /*
		   * 土地划拨修改
		   * */
		  if(flag.equals("12")){
			  int landallotId=Integer.parseInt(request.getParameter("landallotId"));
				landId=Integer.parseInt(request.getParameter("landId"));
				landusageId=Integer.parseInt(request.getParameter("landusageId"));
				if(landusageId==4)
				  {
						select_else=request.getParameter("select_else"); 
						LandAction landaction=new LandAction();
						landaction.landusageAdd(0, select_else);
						landusageId=landaction.getMaxId("land_usage");
				  }
				  String landArea1=request.getParameter("landArea");
				  if(landArea1.equals("")||landArea1.equals("null"))
					  landArea=0.0;
					else
				  landArea=Double.parseDouble(landArea1);
				  
				  String planArea1=request.getParameter("planArea");	
				  if(planArea1.equals("")||planArea1.equals("null"))
					  planArea=0.0;
					else
				  planArea=Double.parseDouble(planArea1);
				  int houseNum=0;
				  String houseNum1=request.getParameter("houseNum");
				  if(houseNum1.equals("")||houseNum1.equals("null"))
					  houseNum=0;
					else
				   houseNum=Integer.parseInt(houseNum1);
				  
				  remarks=request.getParameter("remarks");	
				LandallotAction landallotaction=new LandallotAction();
				 
				LandAllot landallotmod=new LandAllot();
					landallotmod.setLandallotId(landallotId);
					landallotmod.setLandId(landId);
					landallotmod.setLandusageId(landusageId);
					landallotmod.setLandArea(landArea);
					landallotmod.setPlanArea(planArea);
					landallotmod.setHousenum(houseNum);

					landallotmod.setRemarks(remarks);
				landallotaction.update(landallotmod);
				
			    response.sendRedirect("./manage/data/land/landallot_list.jsp?landId="+landId+"");
		  }
	}
	
	}
