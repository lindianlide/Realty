package com.realty.base.servlet;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realty.base.action.BuildingAction;
import com.realty.base.action.LandAction;
import com.realty.base.dao.impl.WebsiteDaoImpl;
import com.realty.base.model.Building;
import com.realty.base.model.Down;
import com.realty.base.model.Land;
import com.realty.base.utils.ImageUtils;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
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
		        response.setHeader("Cache-Control", "no-cache");
				response.setCharacterEncoding("UTF-8");
				request.setCharacterEncoding("utf-8");
				 response.setDateHeader("Expires", 0); 
				response.setContentType("text/html;charset=UTF-8");//解决乱码问题,没有这句，回调函数的内容可能乱码
				 PrintWriter out = response.getWriter();
				String flag=request.getParameter("flag");
				/*
				 * action类未写完整
				 * */
			if(flag.equals("1")){
				 ServletInputStream in = request.getInputStream();
				 
				 //String  filepath=this.getServletConfig().getServletContext().getRealPath("/files");
				  //filePath = request.getServletPath();
				// System.out.println(filePath);
				 String filepath=this.getServletConfig().getServletContext().getInitParameter("fileupload");
				//String filepath ="E:/file/";					
					String names = "";
					String fname="";
					String tname="";
					int maxId=0;
				byte[] buf = new byte[2048];
				int len = in.readLine(buf, 0, buf.length);
				String f = new String(buf, 0, len - 1); 
				while ((len = in.readLine(buf, 0, buf.length)) != -1) {
					names = new String(buf, 0, len,"utf-8");//解决编码问题,内容文件流
					//System.out.println(names);
				    int j = names.lastIndexOf("\"");
				    int k = names.lastIndexOf(".");
				    int s = names.indexOf("filename");
				    fname=names.substring(s+10,j); 
				   // System.out.println("j=="+j+"k==="+k+"s=="+s);
				    tname=names.substring(s+10,k); 
				   // System.out.println("fname=="+fname);
				   // System.out.println("tname=="+tname);
				String category=request.getParameter("category");
				int downcategoryId=Integer.parseInt(category);
				BuildingAction bulidingaction=new BuildingAction();
				WebsiteDaoImpl we=new WebsiteDaoImpl();
				String title=null;
				title=tname;
				Date date=null;
				String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					 date = sdf.parse(datetime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int downs=1;
				maxId=bulidingaction.getMaxId("down");
				String downFile=maxId+fname;
				we.downAdd(title, downcategoryId, date, downs, downFile);
				//System.out.println(filepath+maxId+fname);
				 DataOutputStream fileStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filepath+maxId+fname)));
				    len = in.readLine(buf, 0, buf.length); 
				    len = in.readLine(buf, 0, buf.length); 
				    while ((len = in.readLine(buf, 0, buf.length)) != -1) {
				        String tempf = new String(buf, 0, len - 1);
				        if (tempf.equals(f) || tempf.equals(f + "--")) {
				            break;    
				        }
				        else{
				        	 fileStream.write(buf, 0, len); // 写入
				        }
				    }
				fileStream.close();
				}
			    out=response.getWriter();
				String result = fname ;
				out.print(result);
				out.close();
				in.close();
			}
			if(flag.equals("2")){
				String searchcharg = request.getParameterValues("searchChar")[0].trim();
				 String[] searchchars = searchcharg.split(",");
				  int[] searchchar = { 0, 0, 0, 0};
				  //String to int
				  for (int i = 0; i < searchchars.length; i++) {
					  searchchar[i] = Integer.parseInt(searchchars[i]);
				    }
				  int category=searchchar[0];
				  WebsiteDaoImpl we=new WebsiteDaoImpl();
				  List<Down> result=we.downList(searchchar[0]);
				  int pageSize=5;
				  int index=0;
				  int count=result.size();
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
				  List<Down> pagelist=we.downList(pageNo, pageSize, category);
			      	if(result.size()>0){
			      	out.println("<table width='742'>");
			       	out.println("<tr style='font-size: 16px;font-weight:bold;'>"
			      			   + "<td>文件名</td>"
			      			   + "<td>上传时间</td>"
			      			   + "<td>文件位置</td>"
			      			   + "<td>操作</td>");
			      			 out.println("</tr>");
			      	for(int i=0;i<pagelist.size();i++){
			      	out.println("<tr>"
			      			   + "<td><span>"+pagelist.get(i).getTitle()+"</span></td>"
			      			   + "<td><span>"+pagelist.get(i).getDate()+"</span></td>"
			      			   + "<td><span>"+pagelist.get(i).getDownFile()+"</span></td>"
			      			   + "<td><a href='FileServlet?flag=3&downId="+pagelist.get(i).getDownId()+"&category="+category+"&pageNo="+pageNo+"'<span>删除</span></a></td>");
			      	out.println("</tr>");
			      	}
			    	out.println("<tr>"
			      			 		+" <td colspan='4' >"
			      			 		+" <table style='border:0px;'  width='100%' class='right-font08'>");
			       out.println("<tr>");
			       out.println("<td style='border:0px;' width='50%'>共 <span class='right-text09'>"+index+"</span> 页 | 第 <span class='right-text09'>"+pageNo+"</span> 页</td>");
			       out.println(" <td style='border:0px;' width='48%' align='right'>[<a href='manage/web/down/down_manages.jsp?pageNo=1&category="+searchchar[0]+"' class='right-font08'>首页</a> | <a href='manage/web/down/down_manages.jsp?category="+searchchar[0]+"&pageNo="+pageNo1+"' class='right-font08'>上一页</a> | <a href='manage/web/down/down_manages.jsp?category="+searchchar[0]+"&pageNo="+pageNo2+"' class='right-font08'>下一页</a> | <a href='manage/web/down/down_manages.jsp?pageNo="+index+"&category="+searchchar[0]+"' class='right-font08'>末页</a>] 转至：</td>");
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
			if(flag.equals("3")){
				WebsiteDaoImpl we=new WebsiteDaoImpl();
				String downIds=request.getParameter("downId");
				String categorys=request.getParameter("category");
				String pageNos=request.getParameter("pageNo");
				int pageNo=Integer.parseInt(pageNos);
				int category=Integer.parseInt(categorys);
				int downId=Integer.parseInt(downIds);
				we.downDel(downId);
				response.sendRedirect("manage/web/down/down_manages.jsp?pageNo="+pageNo+"&category="+category);
			}	   
			if(flag.equals("4")){
				 ServletInputStream in = request.getInputStream();
				 String filepath=this.getServletConfig().getServletContext().getInitParameter("fileupload");				
					String names = "";
					String fname="";
					String tname="";
				byte[] buf = new byte[2048];
				int len = in.readLine(buf, 0, buf.length);
				String f = new String(buf, 0, len - 1); 
				while ((len = in.readLine(buf, 0, buf.length)) != -1) {
					names = new String(buf, 0, len,"utf-8");//解决编码问题,内容文件流
				    int j = names.lastIndexOf("\"");
				    int k = names.lastIndexOf(".");
				    int s = names.indexOf("filename");
				    fname=names.substring(s+10,j); 
				    tname=names.substring(s+10,k); 
				String lawId1=request.getParameter("lawId");
				int lawId=Integer.parseInt(lawId1);
				
				WebsiteDaoImpl we1=new WebsiteDaoImpl();
				we1.lawUpdate(lawId, fname);
				
				 DataOutputStream fileStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filepath+fname)));
				    len = in.readLine(buf, 0, buf.length); 
				    len = in.readLine(buf, 0, buf.length); 
				    while ((len = in.readLine(buf, 0, buf.length)) != -1) {
				        String tempf = new String(buf, 0, len - 1);
				        if (tempf.equals(f) || tempf.equals(f + "--")) {
				            break;    
				        }
				        else{
				        	 fileStream.write(buf, 0, len); // 写入
				        }
				    }
				fileStream.close();
				}
			    out=response.getWriter();
				String result = fname ;
				out.print(result);
				out.close();
				in.close();
			}
			
			if(flag.equals("5")){
				 ServletInputStream in = request.getInputStream();
				 String filepath=this.getServletConfig().getServletContext().getInitParameter("landfileupload");
					String names = "";
					String fname="";
					String tname="";
					int maxId=0;
				byte[] buf = new byte[2048];
				int len = in.readLine(buf, 0, buf.length);
				String f = new String(buf, 0, len - 1); 
				while ((len = in.readLine(buf, 0, buf.length)) != -1) {
					names = new String(buf, 0, len,"utf-8");//解决编码问题,内容文件流
					//System.out.println(names);
				    int j = names.lastIndexOf("\"");
				    int k = names.lastIndexOf(".");
				    int s = names.indexOf("filename");
				    fname=names.substring(s+10,j); 
				   // System.out.println("j=="+j+"k==="+k+"s=="+s);
				    tname=names.substring(s+10,k); 
				   // System.out.println("fname=="+fname);
				   // System.out.println("tname=="+tname);
				String landIds=request.getParameter("landId");
				int landId=Integer.parseInt(landIds);
				String title=null;
				title=landId+tname;
			    LandAction landaction=new LandAction();
			    landaction.landsellUpdate(landId,title);
			/*	String title=null;
				title=tname;
				Date date=null;
				String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					 date = sdf.parse(datetime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
*/
				//System.out.println(filepath+maxId+fname);
				 DataOutputStream fileStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filepath+title)));
				    len = in.readLine(buf, 0, buf.length); 
				   // len = in.readLine(buf, 0, buf.length); 
				    while ((len = in.readLine(buf, 0, buf.length)) != -1) {
				        String tempf = new String(buf, 0, len - 1);
				        if (tempf.equals(f) || tempf.equals(f + "--")) {
				            break;    
				        }
				        else{
				        	 fileStream.write(buf, 0, len); // 写入
				        }
				    }
				fileStream.close();
				}
			    out=response.getWriter();
				String result = fname ;
				out.print(result);
				out.close();
				in.close();
			}
	}

}
