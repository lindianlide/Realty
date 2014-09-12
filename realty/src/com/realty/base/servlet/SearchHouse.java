package com.realty.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.realty.base.action.SecondAction;
import com.realty.base.model.Secondhouse;
import com.realty.base.model.SedecoratePhoto;


@WebServlet("/SearchHouse")
public class SearchHouse extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6718459279038940315L;
	
	 public SearchHouse() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 閼奉亜濮╅悽鐔稿灇閻ㄥ嫭鏌熷▔鏇炵摠閺嶏拷
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 閼奉亜濮╅悽鐔稿灇閻ㄥ嫭鏌熷▔鏇炵摠閺嶏拷	
		
		req.setCharacterEncoding("utf-8");
		 resp.setHeader("Cache-Control", "no-store");  
		 resp.setHeader("Pragma", "no-cache");  
		 resp.setDateHeader("Expires", 0); 
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
	
		String flag=req.getParameter("flag");
		String bname= req.getParameter("bname"); 
		if(flag.equals("3")){

			//String[] searchchar1 = request.getParameterValues("searchChar");  
			String searchcharg = req.getParameterValues("searchChar")[0].trim();
			 String[] searchchars = searchcharg.split(",");
			  int[] searchchar = { 0, 0, 0, 0};
			  //String to int
			  for (int i = 0; i < searchchars.length; i++) {
				  searchchar[i] = Integer.parseInt(searchchars[i]);
			    }
			  SecondAction secondaction=new SecondAction();
			  int count=secondaction.secondCount(searchchar[0], searchchar[1], searchchar[2],bname);
			  int pageSize=10;
			  int index=0;
			  if(count%pageSize==0&&count!=0)
			   index=count/pageSize;
			  else {
			  	index=count/pageSize+1;
			  	}
			  String pageNos=req.getParameter("pageNo");	
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
			
				List<Secondhouse> result=secondaction.secondSearch(searchchar[0], searchchar[1], searchchar[2],bname,pageNo,pageSize);
		      	if(result.size()>0){
		      		out.println("<table width='742'>");
		      		for(int i=0;i<result.size();i++){
		      		 List SecondPhotoList=secondaction.secondPhoto(result.get(i).getHouseId(),"setype_photo");
      				 if(!SecondPhotoList.isEmpty()){
		      	out.println("<tr height='150'>"
		      				+"<td width='150'><img style='width:150px;height:170px;' alt='' src='picupload/second/"+SecondPhotoList.get(0)+"'></td>"
		      			   + "<td><a href='website/secondbuilding/sebuildingintro.jsp?houseId="+result.get(i).getHouseId()+"' <span>"+result.get(i).getHouseName()+"</span> </a> "
		      			   + "<span>"+result.get(i).getRegionId()+"</span>"
		      			   + "<span>"+result.get(i).getUsageId()+"</span>"
		      			   + "<td><span>"+result.get(i).getExchangeTotle()+"</span></td>"
		      			   
		      			   +"</tr>");
		      	}else{
		      		out.println("<tr height='150'>"
		      				+"<td width='150'>无图片</td>"
		      			   + "<td><a href='website/secondbuilding/sebuildingintro.jsp?houseId="+result.get(i).getHouseId()+"' <span>"+result.get(i).getHouseName()+"</span> </a> "
		      			   + "<span>"+result.get(i).getRegionId()+"</span>"
		      			   + "<span>"+result.get(i).getUsageId()+"</span>"
		      			   + "<td><span>"+result.get(i).getExchangeTotle()+"</span></td>"
		      			   +"</tr>");
		      	}
		      		}
		      	out.println("<tr>"
      			 		+" <td colspan='5' >"
      			 		+" <table style='border:0px;'  width='100%' class='right-font08'>");
       out.println("<tr>");
       out.println("<td style='border:0px;' width='50%'>共 <span class='right-text09'>"+index+"</span> 页 | 第 <span class='right-text09'>"+pageNo+"</span> 页</td>");
       out.println(" <td style='border:0px;' width='48%' align='right'>[<a href='website/secondbuilding/sersebuilding.jsp?pageNo=1&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>首页</a> | <a href='website/secondbuilding/sersebuilding.jsp?pageNo="+pageNo1+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>上一页</a> | <a href='website/secondbuilding/sersebuilding.jsp?pageNo="+pageNo2+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>下一页</a> | <a href='website/secondbuilding/sersebuilding.jsp?pageNo="+index+"&searchchar[0]="+searchchar[0]+"&searchchar[1]="+searchchar[1]+"&searchchar[2]="+searchchar[2]+"' class='right-font08'>末页</a>] 转至：</td>");
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
	}
	/*public void destroy(){
		  try { 
			  statement.close();
			  db.close(); 
		  }catch (SQLException e) {} 

	}*/
}
