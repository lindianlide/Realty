package com.realty.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.realty.base.action.BuildingAction;
import com.realty.base.model.Building;
import com.realty.base.model.BuildingPhoto;

/**
 * Servlet implementation class NewBuildServlet
 */
@WebServlet("/NewBuildServlet")
public class NewBuildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBuildServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		/*String bname=request.getParameter("bname");
		System.out.println(bname);*/
		String flag=request.getParameter("flag");
		String bname= request.getParameter("bname"); 
		
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
			  int count=buildingaction.buildingCount(searchchar[0], searchchar[1], searchchar[2],bname);
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
			
				List<Building> result=buildingaction.buildingSearch(searchchar[0], searchchar[1], searchchar[2],bname,pageNo,pageSize);
		      	if(result.size()>0){
		      		out.println("<table width='799px'>");
		      		for(int i=0;i<result.size();i++){
		      		 List BuildingPhotoList=buildingaction.buildingPhoto(result.get(i).getBuildingId(),"building_photo");
      				 if(!BuildingPhotoList.isEmpty()){
		      	out.println("<tr height='150'>"
		      				+"<td width='150'><img style='width:150px;height:170px;' alt='' src='picupload/building/"+BuildingPhotoList.get(0)+"'></td>"
		      			   + "<td><a href='website/building/buildingintro.jsp?buildId="+result.get(i).getBuildingId()+"' <span>"+result.get(i).getBuildingName()+"</span> </a> "
		      			   + "<span>"+result.get(i).getRegionId()+"</span>"
		      			   + "<span>"+result.get(i).getUsageId()+"</span>"
		      			   + "<td><span>"+result.get(i).getAveragePrice()+"</span></td>"
		      			   
		      			   +"</tr>");
		      	}else{
		      		out.println("<tr height='150'>"
		      				+"<td width='150'>无图片</td>"
		      			   + "<td><a href='website/building/buildingintro.jsp?buildId="+result.get(i).getBuildingId()+"' <span>"+result.get(i).getBuildingName()+"</span> </a> "
		      			   + "<span>"+result.get(i).getRegionId()+"</span>"
		      			   + "<span>"+result.get(i).getUsageId()+"</span>"
		      			   + "<td><span>"+result.get(i).getAveragePrice()+"</span></td>"
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
		      	}
		      	/*out.println("<table width='663' height='516'  align='center'>"
   +"<tr> <td width='289'>楼盘名：<span>"+result.get(0).getBuildingName()+"</span></td>"
     +" <td width='358'>楼盘别名：<span><%=buildingList.get(j).getBuildingAlias()%></span></td> </tr>"
    +"<tr><td>物业所在区域：<span><%=buildingList.get(j).getRegionId()%></span></td><td>物业地址： </td></tr>"
    +" <tr><td>物业名称：</td><td>楼盘用途：</tr>"
    +" <tr><td>建筑年代：</td><td>开发商：</td></tr>"
    +" <tr><td>占地面积：</td><td>建筑面积：</td> </tr>"
    +"<tr><td>建筑结构：   </td><td>建筑形态：</td></tr>"
    +" <tr> <td colspan='3'>容积率：</td></tr>"
    +" <tr><td colspan='2'>绿化率： 车位配比： 交房装修情况：</td></tr>"
    +" <tr><td>开盘时间：</td><td>物业服务：</td></tr>"
    +" <tr><td>开盘价格（起价）：</td><td>开盘价格（均价）：</td></tr>"
    +" <tr><td>房屋单价：</td><td>房屋总价：</td></tr>"
    +" <tr> <td valign='middle' colspan='2'>楼盘位置图：<%=photolist.get(0)%> <img src='<%=photolist.get(0)%>'/>"
    		+ "<span name='locationphoto' id='locationphoto' ></span> </td></tr>"
    +" <tr><td>经度：</td><td>纬度：</td></tr>"
    +" <tr><td colspan='2'>信息录入人：录入时间：</td></tr>"
    +" <tr><td colspan='2'>提交人： 提交时间：状态标记：</td></tr>"
    +" <tr> <td colspan='2'>备注：</td></tr>"
    		+"</table>");*/
		      	else{
			      	out.println("<table width='742'>"
			      	+"<tr>"
					+" <td> <span>没有相应信息 </span></td>"
					+"</tr>"
					+"</table>");
					out.close();

		      	}
	
		}
	

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("=================");
	}
}

