package com.realty.base.servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.realty.base.model.*;
import com.realty.base.utils.JsonDateValueProcessor;
import com.realty.base.utils.QueryUtils;
import com.realty.base.action.BuildingAction;
import com.realty.base.action.BuildingUsageAction;
import com.realty.base.dao.BuildingDao;
import com.realty.base.dao.impl.BuildingDaoImpl;
import com.oreilly.servlet.MultipartRequest;  

/**
 * Servlet implementation class BuildingServlet
 */
@WebServlet("/BuildingServlet")
public class BuildingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingServlet() {
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
		
		String buildingName=null;String buildingAlias=null;int regionId=0;String propertyAdress=null;
		 String propertyName=null;int usageId=0;int buildtimeId=0;String developers=null;Double floorArea=0.0;
		 Double buildingArea=0.0;int structureId=0;String formId=null;String plotRatio=null;Date landuseTime=null;
		 String buildingDensity=null;String greeningRate=null;BigDecimal parkingRatio=null;int decorateId=0;Date openTime=null;
		 String propertyService=null;Double initialPrice=0.0;Double averagePrice=0.0;Double perPrice=0.0;
		 Double totalPrice=0.0;String locationphoto=null;int landId=0;int buildintroId=0;Double longitude=0.0;
		 Double latitude=0.0;int entryId=1;String entryName=null;Date entryTime=null;String auditName=null;
		 Date auditTime=null;int status=0;String remarks=null;
			String buildtimeOne=null;String buildtimeTwo=null;String buildtimeThree=null;String buildtimeOther=null;
			String buildingtimeFinish=null;String buildRegion=null;String projectFeature=null;
			int zipCode=0;String buildingStruc=null;String buildingType=null;Double propertyFee=0.0;
			String proWorkaddress=null;String proPhone=null;String proOtherinfor=null;String propertyRight=null;
			String buildingintro=null;String editer=null;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 try {
					landuseTime = sdf.parse("0001-01-01");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			 try {
				 openTime = sdf.parse("0001-01-01");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   int floorId=0; int buildingId=0; String address=null;
			String buildingEast=null; String buildingWest=null;
			String buildingSouth=null; String buildingNorth=null;
			String landLevel=null; String neighborhood=null;
			String buildingInfor=null; String nearRoad=null;
			String publicTransport=null; String commercialFacility=null;
			String financingNstitution=null; String school=null;
			String hospital=null; String other=null;
			String internalFacility=null; String electricityFacility=null;
			String parkFacility=null; String propertyManagement=null;
			String environment=null; Date collectTime=null;	int buildNum=0; String floors=null; int cells=0; String networks=null;
			int onehouses=0;
			 String waterSupply=null;
			 String electricitySupply=null;
			 String heatSupply=null;
			 String gas=null;
			 String communications=null;
			 String elevato=null;
			 String security=null;
			 String hygienism=null;
			 String parking=null;
			 String communityEnter=null;
			int unitNum=0;int houseNum=0;
			 Double houseArea=null; String present=null;int floorTotle=0;
			 int floorSaid=0;int floorActual=0;String houseType=null;
			 String orientation=null;Double exchangePrice=null;Double exchangeTotle=null;Date exchangeTime=null;

		 
		 PrintWriter out = response.getWriter();
		
		String flag=request.getParameter("flag");
		if(flag.equals("1")){
			
			 buildingName=request.getParameter("buildingName");
			 buildingAlias=request.getParameter("buildingAlias");
			 String regionId1=request.getParameter("regionId");
			 regionId = Integer.parseInt(regionId1); 
			 propertyAdress=request.getParameter("propertyAdress");
			 propertyName=request.getParameter("propertyName");
			 String usageId1=request.getParameter("usageId");
			 usageId = Integer.parseInt(usageId1);
			 developers=request.getParameter("developers");

			 String floorArea1=request.getParameter("floorArea");
			 if(floorArea1.equals(""))
				 floorArea=0.0;
				 else
			 floorArea = Double.parseDouble(floorArea1);
			
			 String buildingArea1=request.getParameter("buildingArea");
			 if(buildingArea1.equals(""))
				 buildingArea=0.0;
			 else
			 buildingArea = Double.parseDouble(buildingArea1);
			 
			 String structureId1=request.getParameter("structureId");
			 structureId = Integer.parseInt(structureId1);
			 formId=request.getParameter("formId");
			
			 String decorateId1=request.getParameter("decorateId");
			 decorateId = Integer.parseInt(decorateId1);
			 
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
				
				
			  BuildingAction buildingaction=new BuildingAction();
			 boolean outcome=buildingaction.buildingAdd(buildingName, buildingAlias, regionId, propertyAdress, propertyName, usageId, buildtimeId, developers, floorArea, buildingArea, structureId, formId, plotRatio, landuseTime, buildingDensity, greeningRate, parkingRatio, decorateId, openTime, propertyService, initialPrice, averagePrice, perPrice, totalPrice, locationphoto, landId, buildintroId, longitude, latitude, entryId, entryName, entryTime, auditName, auditTime, status, remarks);
			if(outcome){
				 int i=buildingaction.buildingList().size()-1;
				 int BuildingId=buildingaction.buildingList().get(i).getBuildingId();
				 
				  buildingaction.buildingintroAdd(BuildingId, buildingName, address, buildingEast, buildingWest, buildingSouth, buildingNorth, landLevel, neighborhood, buildingInfor, nearRoad, publicTransport, commercialFacility, financingNstitution, school, hospital, other, internalFacility, electricityFacility, parkFacility, propertyManagement, environment, collectTime, entryName, entryTime, auditName, auditTime, status, remarks, buildNum, floors, cells, networks, onehouses);
				  int j=buildingaction.buildingintroList().size()-1;
				  //buildintroId=buildingaction.buildingList().get(i).getBuildintroId();
				  buildintroId=buildingaction.buildingintroList().get(j).getBuildintroId();
				/* 
				 Map<String, Object> map = new HashMap<String, Object>();map.put("BuildingId", BuildingId);
				 map.put("usageId",usageId);
				 map.put("regionId", regionId);
				 map.put("decorateId", decorateId);
				 map.put("structureId",structureId);
				 map.put("formId", formId);
				 request.getSession().setAttribute("map", map);
				 JSONObject jo = JSONObject.fromObject(map);
				 System.out.println("map->json:" + jo.toString());

				 request.getSession().setAttribute("BuildingIdadd", BuildingId);*/
				 
/*				 request.getSession().setAttribute("usageId", usageId);
				 request.getSession().setAttribute("regionId", regionId);
				 request.getSession().setAttribute("decorateId", decorateId);
				 request.getSession().setAttribute("structureId", structureId);
				 request.getSession().setAttribute("formId", formId);*/
				 
				 //JOptionPane.showMessageDialog(null, "增加成功！");  
				// out.print("<script> alert(\"增加成功!\"); </script>");
				 //response.sendRedirect("./manage/data/building_modify.jsp");
				 response.sendRedirect("./manage/data/building_modify.jsp?buildintroId="+buildintroId+"&buildingId="+BuildingId+"");
			 }
			 else{
				 out.print("<script> alert(\"增加失败!\"); </script>");
				 //JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
				response.sendRedirect("./manage/data/building_add.jsp");
			 }
		}
	
		if(flag.equals("2")){
			
			 buildingName=request.getParameter("buildingName");
			 buildingAlias=request.getParameter("buildingAlias");
			 String regionId1=request.getParameter("regionId");
			 regionId = Integer.parseInt(regionId1); 
			 propertyAdress=request.getParameter("propertyAdress");
			 propertyName=request.getParameter("propertyName");
			 String usageId1=request.getParameter("usageId");
			 usageId = Integer.parseInt(usageId1);
			 developers=request.getParameter("developers");

			 String floorArea1=request.getParameter("floorArea");	
			 if(floorArea1.equals("null"))
				 floorArea=0.0;
			 else
			 floorArea = Double.parseDouble(floorArea1);

			 String buildingArea1=request.getParameter("buildingArea");
			 if(floorArea1.equals("null"))
				 floorArea=0.0;
			 else
			 buildingArea = Double.parseDouble(buildingArea1);
			 
			 String structureId1=request.getParameter("structureId");
			 structureId = Integer.parseInt(structureId1);
			 formId=request.getParameter("formId");
			
			 String decorateId1=request.getParameter("decorateId");
			 decorateId = Integer.parseInt(decorateId1);
			 entryName=request.getParameter("entryName");
			 String entryTime1=request.getParameter("entryTime");
			 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					entryTime = sdf1.parse(entryTime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			 String buildingId1=request.getParameter("buildingId");
			  buildingId = Integer.parseInt(buildingId1);
			 
			 plotRatio=request.getParameter("plotRatio");
			 String landuseTime1=request.getParameter("landuseTime");
			 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			 if(landuseTime1.equals("null")||landuseTime1.equals(""))
				 try {
						landuseTime = sdf2.parse("0001-01-01");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 else{
				try {
					landuseTime = sdf2.parse(landuseTime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			buildingDensity=request.getParameter("buildingDensity");
			greeningRate=request.getParameter("greeningRate");
			String parkingRatio1=request.getParameter("parkingRatio");
			if(parkingRatio1.equals("")||parkingRatio1.equals("null"))
				parkingRatio=null;
			else
		    parkingRatio=new BigDecimal(parkingRatio1);//string转BigDecimal
		    
		    String openTime1=request.getParameter("openTime");
		    if(openTime1.equals("")||openTime1.equals("null"))
		    	 try {
		    		 openTime = sdf2.parse("0001-01-01");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    else{
				try {
					openTime = sdf2.parse(openTime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
			propertyService=request.getParameter("propertyService");
			
			String initialPrice1=request.getParameter("initialPrice");
			if(initialPrice1.equals("")||initialPrice1.equals("null"))
				initialPrice=0.0;
			else
			initialPrice = Double.parseDouble(initialPrice1);
			String averagePrice1=request.getParameter("averagePrice");
			if(averagePrice1.equals("")||averagePrice1.equals("null"))
				averagePrice=0.0;
			else
			averagePrice = Double.parseDouble(averagePrice1);
			String perPrice1=request.getParameter("perPrice");
			if(perPrice1.equals("")||perPrice1.equals("null"))
				perPrice=0.0;
			else
			perPrice = Double.parseDouble(perPrice1);
			String totalPrice1=request.getParameter("totalPrice");
			if(totalPrice1.equals("")||totalPrice1.equals("null"))
				totalPrice=0.0;
			else
			totalPrice = Double.parseDouble(totalPrice1);
			
			String longitude1=request.getParameter("longitude");
			if(longitude1.equals("")||longitude1.equals("null"))
				longitude=0.0;
			else
				longitude = Double.parseDouble(longitude1);
			
			String latitude1=request.getParameter("latitude");
			if(latitude1.equals("")||latitude1.equals("null"))
				latitude=0.0;
			else
				latitude = Double.parseDouble(latitude1);
			
			String status1=request.getParameter("status");
			 status=Integer.parseInt(status1);
			 if(status==1){
				 auditName= (String)request.getSession().getAttribute("managername");
				// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				 //auditTime=df.format(new Date());// new Date()为获取当前系统时间
				    Calendar c = Calendar.getInstance();
				    auditTime = c.getTime();
			 }
			 String zipCodes=request.getParameter("zipCode");
			 if(zipCodes.equals("")||zipCodes.equals("null"))
				 zipCode=0;
				else
					zipCode = Integer.parseInt(zipCodes);
			 String propertyFees=request.getParameter("propertyFee");
			 if(propertyFees.equals("")||propertyFees.equals("null"))
				 propertyFee=0.0;
				else
					propertyFee = Double.parseDouble(propertyFees);
				
			 buildingtimeFinish=request.getParameter("buildingtimeFinish");
			 projectFeature=request.getParameter("projectFeature");
			 proWorkaddress=request.getParameter("proWorkaddress");
			 proPhone=request.getParameter("proPhone");
			 proOtherinfor=request.getParameter("proOtherinfor");

		    remarks=request.getParameter("remarks");

		    
			BuildingAction buildingaction=new BuildingAction();
			 boolean outcome=buildingaction.buildingUpdate(buildingId,buildingName, buildingAlias, regionId, propertyAdress, propertyName, usageId, buildtimeId, developers, floorArea, buildingArea, structureId, formId, plotRatio, landuseTime, buildingDensity, greeningRate, parkingRatio, decorateId, openTime, propertyService, initialPrice, averagePrice, perPrice, totalPrice, locationphoto, landId, buildintroId, longitude, latitude, entryId, entryName, entryTime, auditName, auditTime, status, remarks,
					 buildtimeOne,buildtimeTwo,buildtimeThree,buildtimeOther,
						buildingtimeFinish,buildRegion,projectFeature,
						zipCode,buildingStruc,buildingType,propertyFee,
						proWorkaddress,proPhone,proOtherinfor,propertyRight,
						buildingintro,editer);
			 if(outcome){
				// JOptionPane.showMessageDialog(null, "修改成功！"); 
				 //response.getWriter().print("<script> alert(\"修改成功!\"); </script>");
				 //response.sendRedirect("./manage/data/building_add.jsp");
				 response.sendRedirect("./manage/data/building_detail.jsp?buildingId="+buildingId+"");
			 }
			 else{
				 //response.getWriter().print("<script> alert(\"增加失败!\"); </script>");
			 JOptionPane.showMessageDialog(null, "修改失败!", "标题",JOptionPane.WARNING_MESSAGE);  
			 response.sendRedirect("./manage/data/building_modify.jsp");
			 }
		}
		/*if(flag.equals("3")){
			 buildingName=request.getParameter("buildingName");
			//buildingName="裕龙大厦";
			BuildingAction buildingaction=new BuildingAction();
			 List<Building> list=buildingaction.buildingSearch(buildingName);
			 request.getSession().setAttribute("buildingId",list.get(0).getBuildingId() );
			 //System.out.println(list.get(0).getBuildingName());
			    out.println("<response>");
				out.println("<result>" + list.get(0).getBuildingName()+ "</result>");
				out.println("<result>" + list.get(0).getPropertyAdress()+ "</result>");
				out.println("<result>" + list.get(0).getDevelopers()+ "</result>");
				out.println("<result>" + list.get(0).getAveragePrice()+ "</result>");
				out.println("</response>");
			
				out.close();
		}*/
		if(flag.equals("3")){
			//String[] searchchar1 = request.getParameterValues("searchChar");  
			String searchcharg = request.getParameterValues("searchChar")[0].trim();
			 String[] searchchars = searchcharg.split(",");
			  int[] searchchar = { 0, 0, 0, 0};
			  //String to int
			  for (int i = 0; i < searchchars.length; i++) {
				  searchchar[i] = Integer.parseInt(searchchars[i]);
			    }
			  BuildingAction buildingaction=new BuildingAction();
			  int count=buildingaction.buildingCount(searchchar[0], searchchar[1], searchchar[2],null);
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
			
				List<Building> result=buildingaction.buildingSearch(searchchar[0], searchchar[1], searchchar[2],null,pageNo,pageSize);
				List<BuildingIntro> buildintroList=buildingaction.buildingintroList();
				//List<Floor> buildinfloorList=buildingaction.floorList();
				int introid=0;
				//int floorid=0;
		      	if(result.size()>0){
		      	out.println("<table width='742' cellpadding=0 cellspacing=0>");
		       	out.println("<tr>"
		      			   + "<td>楼盘名</td>"
		      			   + "<td>开盘时间</td>"
		      			   + "<td>占地面积</td>"
		      			   + "<td>价格</td>"
		      			   + "<td>操作</td>");
		      			 out.println("</tr>");
		      	for(int i=0;i<result.size();i++){
		      		 for(int j=0;j<buildintroList.size();j++){
							if(buildintroList.get(j).getBuildingId()==result.get(i).getBuildingId()){
								{
									introid=buildintroList.get(j).getBuildintroId();
									 break;
									}
							}
						}
		      		/*for(int n=0;n<buildinfloorList.size();n++){
						if(buildinfloorList.get(n).getBuildingId()==result.get(i).getBuildingId()){
							{
								floorid=buildinfloorList.get(n).getFloorId();
								 break;
								}
						}
				}*/
		      	out.println("<tr>"
		      			   + "<td><a href='manage/data/building_details.jsp?buildingId="+result.get(i).getBuildingId()+"' <span>"+result.get(i).getBuildingName()+"</span> </a> </td>"
		      			   + "<td><span>"+result.get(i).getOpenTime()+"</span></td>"
		      			   + "<td><span>"+result.get(i).getFloorArea()+"</span></td>"
		      			   + "<td><span>"+result.get(i).getAveragePrice()+"</span></td>"
		      			   + "<td><a href='BuildingServlet?flag=4&buildintroId="+introid+"&buildingId="+result.get(i).getBuildingId()+"' onclick='return del_sure()'><span>删除</span></a>  <a href='manage/data/building_modify.jsp?buildintroId="+introid+"&buildingId="+result.get(i).getBuildingId()+"'<span>修改</span></a></td>"
		      			   +"</tr>");
		      	}
		      	out.println("<tr>"
      			 		+" <td colspan='5' >"
      			 		+" <table style='border:0px;'  width='100%' class='right-font08'>");
       out.println("<tr>");
       out.println("<td style='border:0px;' width='50%'>共 <span class='right-text09'>"+index+"</span> 页 | 第 <span class='right-text09'>"+pageNo+"</span> 页</td>");
       out.println(" <td style='border:0px;' width='48%' align='right'>[<a href='manage/data/building_manages.jsp?pageNo=1&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>首页</a> | <a href='manage/data/building_manages.jsp?pageNo="+pageNo1+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>上一页</a> | <a href='manage/data/building_manages.jsp?pageNo="+pageNo2+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>下一页</a> | <a href='manage/data/building_manages.jsp?pageNo="+index+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>末页</a>] 转至：</td>");
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
		if(flag.equals("4")){
			 buildingId=Integer.parseInt(request.getParameter("buildingId"));		 
			// buildintroId=Integer.parseInt(request.getParameter("buildintroId"));
			// floorId=Integer.parseInt(request.getParameter("floorId"));
			 
			BuildingAction buildingaction=new BuildingAction();
			/*if(buildintroId!=0){
			buildingaction.buildingintroDel(buildintroId);}
			
			if(buildingId!=0){
			buildingaction.floorDel(buildingId);}*/
			
			buildingaction.buildingintroDel(buildingId);
			buildingaction.floorDel(buildingId);
			boolean outcome=buildingaction.buildingDel(buildingId);
			if(outcome){

		    response.sendRedirect("./manage/data/building_manage.jsp");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "该信息不能删除!", "标题",JOptionPane.WARNING_MESSAGE); 
			    response.sendRedirect("./manage/data/building_manage.jsp");
			}
		}
		if(flag.equals("5")){
			
			 String buildintroId1=request.getParameter("buildintroId");
			 buildintroId=Integer.parseInt(buildintroId1); 
			 String buildingIdintro=request.getParameter("buildingId");
			 buildingId=Integer.parseInt(buildingIdintro);
			 buildingName=request.getParameter("buildingName");
			 address=request.getParameter("address");
			 buildingEast=request.getParameter("buildingEast");
			 buildingWest=request.getParameter("buildingWest");
			 buildingSouth=request.getParameter("buildingSouth");
			 buildingNorth=request.getParameter("buildingNorth");
			 landLevel=request.getParameter("landLevel");
			 neighborhood=request.getParameter("neighborhood");
			 buildingInfor=request.getParameter("buildingInfor");
			 nearRoad=request.getParameter("nearRoad");
			 publicTransport=request.getParameter("publicTransport");
			 commercialFacility=request.getParameter("commercialFacility");
			 financingNstitution=request.getParameter("financingNstitution");
			 school=request.getParameter("school");
			 hospital=request.getParameter("hospital");
			 other=request.getParameter("other");
			 internalFacility=request.getParameter("internalFacility");
			 electricityFacility=request.getParameter("electricityFacility");
			 parkFacility=request.getParameter("parkFacility");
			 propertyManagement=request.getParameter("propertyManagement");
			 environment=request.getParameter("environment");
			 String collectTime1=request.getParameter("collectTime");
			 SimpleDateFormat sdfc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 if(collectTime1.equals("")||collectTime1.equals("null"))
				 collectTime=null;
			 else{
				try {
					collectTime = sdfc.parse(collectTime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 entryName=request.getParameter("entryName");
			 String entryTime1=request.getParameter("entryTime");
			 SimpleDateFormat sdfe = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					entryTime = sdfe.parse(entryTime1);
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

			  BuildingAction buildingaction=new BuildingAction();
			 boolean outcome=buildingaction.buildingintroUpdate(buildintroId,buildingId, buildingName, address, buildingEast, buildingWest, buildingSouth, buildingNorth, landLevel, neighborhood, buildingInfor, nearRoad, publicTransport, commercialFacility, financingNstitution, school, hospital, other, internalFacility, electricityFacility, parkFacility, propertyManagement, environment, collectTime, entryName, entryTime, auditName, auditTime, status, remarks, buildNum, floors, cells, networks, onehouses);
					 if(outcome){
				 int i=buildingaction.buildingList().size()-1;
				 int BuildingId=buildingaction.buildingList().get(i).getBuildingId();

				 request.getSession().setAttribute("BuildingId", BuildingId);
				 
				 //JOptionPane.showMessageDialog(null, "增加成功！");  
				 //response.sendRedirect("./manage/data/buildingaround_modify.jsp?BuildingIdadd="+buildingId+"");
				 response.sendRedirect("./manage/data/buildingaround_detail.jsp?buildingId="+buildingId+"");
			 }
			 else{
				// response.getWriter().print("<script> alert(\"增加失败!\"); </script>");
				 JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
				response.sendRedirect("./manage/data/building_add.jsp");
			 }
		}
		
		if(flag.equals("6")){
			 String buildingId1=request.getParameter("buildingId");
			 buildingId = Integer.parseInt(buildingId1); 
			 String buildNum1=request.getParameter("buildNum");
			 if(buildNum1.equals("")||buildNum1.equals("null"))
				 buildNum=0;
				 else
			 buildNum = Integer.parseInt(buildNum1); 
			 String unitNum1=request.getParameter("unitNum");
			 if(unitNum1.equals("")||unitNum1.equals("null"))
				 unitNum=0;
				 else
			 unitNum = Integer.parseInt(unitNum1); 
			 
			 String houseNum1=request.getParameter("houseNum");
			 if(houseNum1.equals("")||houseNum1.equals("null"))
				 houseNum=0;
				 else
			 houseNum = Integer.parseInt(houseNum1); 
			 String houseArea1=request.getParameter("houseArea");
			 if(houseArea1.equals("")||houseArea1.equals("null"))
				 houseArea=null;
				 else
			 houseArea = Double.parseDouble(houseArea1); 
			 present=request.getParameter("present");
			 String decorateId2=request.getParameter("decorateId");
			 if(decorateId2.equals("")||decorateId2.equals("null"))
				 decorateId=0;
				 else
			 decorateId = Integer.parseInt(decorateId2); 
			 String floorTotle1=request.getParameter("floorTotle");
			 if(floorTotle1.equals("")||floorTotle1.equals("null"))
				 floorTotle=0;
				 else
			 floorTotle = Integer.parseInt(floorTotle1); 
			 String floorSaid1=request.getParameter("floorSaid");
			 if(floorSaid1.equals("")||floorSaid1.equals("null"))
				 floorSaid=0;
				 else
			 floorSaid = Integer.parseInt(floorSaid1); 
			 
			 String floorActual1=request.getParameter("floorActual");
			 if(floorActual1.equals("")||floorActual1.equals("null"))
				 floorActual=0;
				 else
			 floorActual = Integer.parseInt(floorActual1); 
			 
			 String usageId1=request.getParameter("usageId");
			 if(usageId1.equals("")||usageId1.equals("null"))
				 usageId=0;
				 else
			 usageId = Integer.parseInt(usageId1); 
			 
			 houseType=request.getParameter("houseType");
			 
			 orientation=request.getParameter("orientation");

			 String exchangePrice1=request.getParameter("exchangePrice");
			 if(exchangePrice1.equals("")||exchangePrice1.equals("null"))
				 exchangePrice=null;
				 else
					 exchangePrice = Double.parseDouble(exchangePrice1);
			 
			 String exchangeTotle1=request.getParameter("exchangeTotle");
			 if(exchangeTotle1.equals("")||exchangeTotle1.equals("null"))
				 exchangeTotle=null;
				 else
					 exchangeTotle = Double.parseDouble(exchangeTotle1);
			 
			 String exchangeTime1=request.getParameter("exchangeTime");
			 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 if(exchangeTime1.equals("")||exchangeTime1.equals("null"))
				 exchangeTime=null;
			else
			{
				try {
					exchangeTime = sdf1.parse(exchangeTime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				remarks=request.getParameter("remarks");
				
			  BuildingAction buildingaction=new BuildingAction();
			 boolean outcome=buildingaction.floorAdd(buildingId, buildNum, unitNum, houseNum, houseArea, present, decorateId, floorTotle, floorSaid, floorActual, usageId, houseType, orientation, exchangePrice, exchangeTotle, exchangeTime, remarks);
			if(outcome){
				// JOptionPane.showMessageDialog(null, "增加成功！");  
				 //response.getWriter().print("<script> alert(\"增加成功!\"); </script>");
				 //response.sendRedirect("./manage/data/building_modify.jsp");
				 response.sendRedirect("./manage/data/buildingfloor_list.jsp?buildingId="+buildingId+"");
			 }
			 else{
				// response.getWriter().print("<script> alert(\"增加失败!\"); </script>");
				 JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
				response.sendRedirect("./manage/data/buildingfloor_add.jsp");
			 }
		}
		if(flag.equals("7")){
			buildingId=Integer.parseInt(request.getParameter("buildingId"));	
			floorId=Integer.parseInt(request.getParameter("floorId"));		 
			BuildingAction buildingaction=new BuildingAction();
			boolean outcome=buildingaction.floorDel(buildingId);
			if(outcome){
				response.sendRedirect("./manage/data/buildingfloor_list.jsp?buildingId="+buildingId+"");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "该信息不能删除!", "标题",JOptionPane.WARNING_MESSAGE); 
			    response.sendRedirect("./manage/data/buildingfloor_list.jsp?buildingId="+buildingId+"");
			}
		}
		if(flag.equals("8")){
			 String floorId1=request.getParameter("floorId");
			 floorId = Integer.parseInt(floorId1); 
			 String buildingId1=request.getParameter("buildingId");
			 buildingId = Integer.parseInt(buildingId1); 
			 String buildNum1=request.getParameter("buildNum");
			 if(buildNum1.equals("")||buildNum1.equals("null"))
				 buildNum=0;
				 else
			 buildNum = Integer.parseInt(buildNum1); 
			 String unitNum1=request.getParameter("unitNum");
			 if(unitNum1.equals("")||unitNum1.equals("null"))
				 unitNum=0;
				 else
			 unitNum = Integer.parseInt(unitNum1); 
			 
			 String houseNum1=request.getParameter("houseNum");
			 if(houseNum1.equals("")||houseNum1.equals("null"))
				 houseNum=0;
				 else
			 houseNum = Integer.parseInt(houseNum1); 
			 String houseArea1=request.getParameter("houseArea");
			 if(houseArea1.equals("")||houseArea1.equals("null"))
				 houseArea=null;
				 else
			 houseArea = Double.parseDouble(houseArea1); 
			 present=request.getParameter("present");
			 String decorateId2=request.getParameter("decorateId");
			 if(decorateId2.equals("")||decorateId2.equals("null"))
				 decorateId=0;
				 else
			 decorateId = Integer.parseInt(decorateId2); 
			 String floorTotle1=request.getParameter("floorTotle");
			 if(floorTotle1.equals("")||floorTotle1.equals("null"))
				 floorTotle=0;
				 else
			 floorTotle = Integer.parseInt(floorTotle1); 
			 String floorSaid1=request.getParameter("floorSaid");
			 if(floorSaid1.equals("")||floorSaid1.equals("null"))
				 floorSaid=0;
				 else
			 floorSaid = Integer.parseInt(floorSaid1); 
			 
			 String floorActual1=request.getParameter("floorActual");
			 if(floorActual1.equals("")||floorActual1.equals("null"))
				 floorActual=0;
				 else
			 floorActual = Integer.parseInt(floorActual1); 
			 
			 String usageId1=request.getParameter("usageId");
			 if(usageId1.equals("")||usageId1.equals("null"))
				 usageId=0;
				 else
			 usageId = Integer.parseInt(usageId1); 
			 
			 houseType=request.getParameter("houseType");
			 
			 orientation=request.getParameter("orientation");

			 String exchangePrice1=request.getParameter("exchangePrice");
			 if(exchangePrice1.equals("")||exchangePrice1.equals("null"))
				 exchangePrice=null;
				 else
					 exchangePrice = Double.parseDouble(exchangePrice1);
			 
			 String exchangeTotle1=request.getParameter("exchangeTotle");
			 if(exchangeTotle1.equals("")||exchangeTotle1.equals("null"))
				 exchangeTotle=null;
				 else
					 exchangeTotle = Double.parseDouble(exchangeTotle1);
			 
			 String exchangeTime1=request.getParameter("exchangeTime");
			 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					exchangeTime = sdf1.parse(exchangeTime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				remarks=request.getParameter("remarks");
				
			  BuildingAction buildingaction=new BuildingAction();
			 boolean outcome=buildingaction.floorUpdate(floorId,buildingId, buildNum, unitNum, houseNum, houseArea, present, decorateId, floorTotle, floorSaid, floorActual, usageId, houseType, orientation, exchangePrice, exchangeTotle, exchangeTime, remarks);
			if(outcome){
				 //JOptionPane.showMessageDialog(null, "修改成功！");  
				 //response.getWriter().print("<script> alert(\"增加成功!\"); </script>");
				 //response.sendRedirect("./manage/data/building_modify.jsp");
				 response.sendRedirect("./manage/data/buildingfloor_list.jsp?buildingId="+buildingId+"");
			 }
			 else{
				// response.getWriter().print("<script> alert(\"增加失败!\"); </script>");
				 JOptionPane.showMessageDialog(null, "修改失败!", "标题",JOptionPane.WARNING_MESSAGE);  
				response.sendRedirect("./manage/data/buildingfloor_add.jsp");
			 }
		}
		
		if(flag.equals("9")){
			 
			 String buildingId1=request.getParameter("buildingId");
			  buildingId = Integer.parseInt(buildingId1);
			  
			  waterSupply=request.getParameter("waterSupply");
			  electricitySupply=request.getParameter("electricitySupply");
			  heatSupply=request.getParameter("heatSupply");
			  gas=request.getParameter("gas");
			  communications=request.getParameter("communications");
			  elevato=request.getParameter("elevato");		 
			  security=request.getParameter("security");
			  hygienism=request.getParameter("hygienism");
			  parking=request.getParameter("parking");
			  communityEnter=request.getParameter("communityEnter");
			 BuildingAction buildingaction=new BuildingAction();
			 boolean outcome=buildingaction.buildingUpdate(buildingId,  waterSupply, electricitySupply, heatSupply, 
						gas, communications, elevato, security, hygienism, parking, communityEnter);
			 if(outcome){
				// JOptionPane.showMessageDialog(null, "修改成功！"); 
				 //response.getWriter().print("<script> alert(\"修改成功!\"); </script>");
				 //response.sendRedirect("./manage/data/building_add.jsp");
				 response.sendRedirect("./manage/data/buildingmatch_detail.jsp?buildingId="+buildingId+"");
			 }
			 else{
				 //response.getWriter().print("<script> alert(\"增加失败!\"); </script>");
			 JOptionPane.showMessageDialog(null, "修改失败!", "标题",JOptionPane.WARNING_MESSAGE);  
			 response.sendRedirect("./manage/data/buildingmatch_modify.jsp");
			 }
		}
	}
	}
