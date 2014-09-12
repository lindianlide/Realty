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
import com.realty.base.action.SecondAction;
import com.realty.base.model.Building;
import com.realty.base.model.Secondhouse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
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
		
		String houseName=null; int regionId=0;
		String propertyAdress=null; String propertyName=null;
		int usageId=0; Date exchangeTime=null; Double buildingArea=null;
		int structureId=0; String present=null; Double exchangePrice=null;
		Double exchangeTotle=null; int pricetypeId=0; int taxtypeId=0;
		Double taxTotle=null; Double taxSeller=null; Double taxBuyer=null;
		int decorateId=0; String buildingTime=null;
		String floorTotle=null; int floorSaid=0; int floorActual=0;
		String roomRate=null; String houseType=null;
		String orientation=null; String otherfile=null;
		String introduction=null; Double longitude=null; Double latitude=null;
		String saleTime=null; int entryId=1; String entryName=null;
		Date entryTime=null; String auditName=null; Date auditTime=null;
		int status=0; String remarks=null;

		 PrintWriter out = response.getWriter();
		
		String flag=request.getParameter("flag");
		if(flag.equals("1")){
			
			houseName=request.getParameter("houseName");
			 String regionId1=request.getParameter("regionId");
			 regionId = Integer.parseInt(regionId1); 
			 propertyAdress=request.getParameter("propertyAdress");
			 propertyName=request.getParameter("propertyName");
			 String usageId1=request.getParameter("usageId");
			 usageId = Integer.parseInt(usageId1);
			 String structureId1=request.getParameter("structureId");
			 structureId = Integer.parseInt(structureId1);
			 present=request.getParameter("present");
			 String decorateId1=request.getParameter("decorateId");
			 decorateId = Integer.parseInt(decorateId1);
			 buildingTime=request.getParameter("buildingTime");
			 floorTotle=request.getParameter("floorTotle");
			/* String floorTotle1=request.getParameter("floorTotle");
			 if(floorTotle1.equals(""))
				 floorTotle1="0";
			else
				floorTotle = Integer.parseInt(floorTotle1);*/
			 
			 
			 
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
			 
			 roomRate=request.getParameter("roomRate");
			 houseType=request.getParameter("houseType");
			 orientation=request.getParameter("orientation");
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
				SecondAction secondaction=new SecondAction();
			 boolean outcome=secondaction.secondAdd(houseName, regionId, propertyAdress, propertyName, usageId, exchangeTime, buildingArea, structureId, present, exchangePrice, exchangeTotle, pricetypeId, taxtypeId, taxTotle, taxSeller, taxBuyer, decorateId, buildingTime, floorTotle, floorSaid, floorActual, roomRate, houseType, orientation, otherfile, introduction, longitude, latitude, saleTime, entryId, entryName, entryTime, auditName, auditTime, status, remarks);
			if(outcome){
				 int i=secondaction.secondList().size()-1;
				 int houseId=secondaction.secondList().get(i).getHouseId();
				 
				 //JOptionPane.showMessageDialog(null, "增加成功！");  
				 //response.getWriter().print("<script> alert(\"增加成功!\"); </script>");
				 response.sendRedirect("./manage/data/second/second_modify.jsp?houseId="+houseId+"");
			 }
			 else{
				// response.getWriter().print("<script> alert(\"增加失败!\"); </script>");
				 JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
				response.sendRedirect("./manage/data/second/second_add.jsp");
			 }
		}
			
		  if(flag.equals("2")){
				 String houseId1=request.getParameter("houseId");
				 int houseId = Integer.parseInt(houseId1);
				 houseName=request.getParameter("houseName");
				 String regionId1=request.getParameter("regionId");
				 regionId = Integer.parseInt(regionId1); 
				 propertyAdress=request.getParameter("propertyAdress");
				 propertyName=request.getParameter("propertyName");
				 String usageId1=request.getParameter("usageId");
				 usageId = Integer.parseInt(usageId1);
				 String exchangeTime1=request.getParameter("exchangeTime");
				 if(exchangeTime1.equals("")||exchangeTime1.equals("null"))
					 exchangeTime=null;
				 else
					 {SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					try {
						exchangeTime = sdf1.parse(exchangeTime1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 }
				 String buildingArea1=request.getParameter("buildingArea");
				 if(buildingArea1.equals("")||buildingArea1.equals("null"))
					 buildingArea=null;
				 else
				 buildingArea = Double.parseDouble(buildingArea1); 
				 String structureId1=request.getParameter("structureId");
				 structureId = Integer.parseInt(structureId1);
				 present=request.getParameter("present");
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
				 
				 String pricetypeId1=request.getParameter("pricetypeId");
				 pricetypeId = Integer.parseInt(pricetypeId1);
				 
				 String taxtypeId1=request.getParameter("taxtypeId");
				 taxtypeId = Integer.parseInt(taxtypeId1);
				 
				 String taxTotle1=request.getParameter("taxTotle");
				 if(taxTotle1.equals("")||taxTotle1.equals("null"))
					 taxTotle=null;
				 else
					 taxTotle = Double.parseDouble(taxTotle1); 
				 
				 String taxSeller1=request.getParameter("taxSeller");
				 if(taxSeller1.equals("")||taxSeller1.equals("null"))
					 taxSeller=null;
				 else
					 taxSeller = Double.parseDouble(taxSeller1);
				 
				 String taxBuyer1=request.getParameter("taxBuyer");
				 if(taxBuyer1.equals("")||taxBuyer1.equals("null"))
					 taxBuyer=null;
				 else
					 taxBuyer = Double.parseDouble(taxBuyer1);
				 
				 String decorateId1=request.getParameter("decorateId");
				 decorateId = Integer.parseInt(decorateId1);
				 buildingTime=request.getParameter("buildingTime");
				 floorTotle=request.getParameter("floorTotle");
				/* String floorTotle1=request.getParameter("floorTotle");
				 if(floorTotle1.equals(""))
					 floorTotle1="0";
				else
					floorTotle = Integer.parseInt(floorTotle1);*/
				 
				 
				 
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
				 
				 roomRate=request.getParameter("roomRate");
				 houseType=request.getParameter("houseType");
				 orientation=request.getParameter("orientation");
				 //String otherfile 未加上
				 introduction=request.getParameter("introduction");
				 
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
					saleTime=request.getParameter("saleTime");
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
			SecondAction secondaction=new SecondAction();
			 boolean outcome=secondaction.secondUpdate(houseId,houseName, regionId, propertyAdress, propertyName, usageId, exchangeTime, buildingArea, structureId, present, exchangePrice, exchangeTotle, pricetypeId, taxtypeId, taxTotle, taxSeller, taxBuyer, decorateId, buildingTime, floorTotle, floorSaid, floorActual, roomRate, houseType, orientation, otherfile, introduction, longitude, latitude, saleTime, entryId, entryName, entryTime, auditName, auditTime, status, remarks);
			 if(outcome){
				 //JOptionPane.showMessageDialog(null, "增加成功！"); 
				 //response.getWriter().print("<script> alert(\"修改成功!\"); </script>");
				 response.sendRedirect("./manage/data/second/second_add.jsp");
			 }
			 else{
				 //response.getWriter().print("<script> alert(\"增加失败!\"); </script>");
			 JOptionPane.showMessageDialog(null, "修改失败!", "标题",JOptionPane.WARNING_MESSAGE);  
			 response.sendRedirect("./manage/data/second/second_modify.jsp");
			 }
		}
		  
		if(flag.equals("3")){
			//String[] searchchar1 = request.getParameterValues("searchChar");  
			String searchcharg = request.getParameterValues("searchChar")[0].trim();
			 String[] searchchars = searchcharg.split(",");
			  int[] searchchar = { 0, 0, 0, 0};
			  //String to int
			  for (int i = 0; i < searchchars.length; i++) {
				  searchchar[i] = Integer.parseInt(searchchars[i]);
			    }
			  SecondAction secondaction=new SecondAction();
			  int count=secondaction.secondCount(searchchar[0], searchchar[1], searchchar[2],null);
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
			
				List<Secondhouse> result=secondaction.secondSearch(searchchar[0], searchchar[1], searchchar[2],null,pageNo,pageSize);
			
		      	if(result.size()>0){
		      	out.println("<table width='742' cellpadding=0 cellspacing=0>");
		       	out.println("<tr>"
		      			   + "<td>二手房名</td>"
		      			   + "<td>区域</td>"
		      			   + "<td>户型</td>"
		      			   + "<td>价格</td>"
		      			   + "<td>操作</td>");
		      			 out.println("</tr>");
		      	for(int i=0;i<result.size();i++){
		      	out.println("<tr>"
		      			   + "<td><a href='manage/data/second/second_detail.jsp?houseId="+result.get(i).getHouseId()+"' <span>"+result.get(i).getHouseName()+"</span> </a> </td>"
		      			   + "<td><span>"+result.get(i).getRegionId()+"</span></td>"
		      			   + "<td><span>"+result.get(i).getUsageId()+"</span></td>"
		      			   + "<td><span>"+result.get(i).getExchangePrice()+"</span></td>"
		      			   + "<td><a href='SecondServlet?flag=4&houseId="+result.get(i).getHouseId()+"' onclick='return del_sure()'><span>删除</span></a>  <a href='manage/data/second/second_modify.jsp?houseId="+result.get(i).getHouseId()+"'<span>修改</span></a></td>"
		      			   +"</tr>");
		      	}
		      	out.println("<tr>"
     			 		+" <td colspan='5' >"
     			 		+" <table style='border:0px;'  width='100%' class='right-font08'>");
      out.println("<tr>");
      out.println("<td style='border:0px;' width='50%'>共 <span class='right-text09'>"+index+"</span> 页 | 第 <span class='right-text09'>"+pageNo+"</span> 页</td>");
      out.println(" <td style='border:0px;' width='48%' align='right'>[<a href='manage/data/second/second_manages.jsp?pageNo=1&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>首页</a> | <a href='manage/data/second/second_manages.jsp?pageNo="+pageNo1+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>上一页</a> | <a href='manage/data/second/second_manages.jsp?pageNo="+pageNo2+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>下一页</a> | <a href='manage/data/second/second_manages.jsp?pageNo="+index+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>末页</a>] 转至：</td>");
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
			int houseId=Integer.parseInt(request.getParameter("houseId"));
			SecondAction secondaction=new SecondAction();
			boolean outcome=secondaction.secondDel(houseId);
			if(outcome)
		    response.sendRedirect("./manage/data/second/second_manage.jsp");
			else
			{
				JOptionPane.showMessageDialog(null, "该信息不能删除!", "标题",JOptionPane.WARNING_MESSAGE); 
			    response.sendRedirect("./manage/data/second/second_manage.jsp");
			}
		}
		
	}

}
