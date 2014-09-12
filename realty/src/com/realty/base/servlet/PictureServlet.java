package com.realty.base.servlet;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realty.base.action.BuildingAction;
import com.realty.base.action.LandAction;
import com.realty.base.action.SecondAction;
import com.realty.base.dao.BuildingDao;
import com.realty.base.dao.impl.BuildingDaoImpl;
import com.realty.base.utils.ImageUtils;


/**
 * Servlet implementation class PictureServlet
 */
@WebServlet("/PictureServlet")
public class PictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PictureServlet() {
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
		 response.setContentType("text/xml");//是xml
	        response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			/*String filepath =this.getServletContext().getRealPath("/");	
			filepath=filepath+"picture\\";*/
			//String filepath ="E:/pic/";
			String filename = null;
			String name=null;
			String filepath=null;
			String category=request.getParameter("category");
	if(category.equals("1")){
			 filepath=this.getServletConfig().getServletContext().getInitParameter("buildingupload");
			ServletInputStream in = request.getInputStream();
			byte[] buf = new byte[4048];
			int len = in.readLine(buf, 0, buf.length);
			String f = new String(buf, 0, len - 1); 
			while ((len = in.readLine(buf, 0, buf.length)) != -1) {
				filename = new String(buf, 0, len,"utf-8");//解决编码问题
			    int j = filename.lastIndexOf("\"");
			    int s = filename.indexOf("filename");
			    name=filename.substring(s+10,j); 
			    filename = name;
			   // System.out.println("filename="+filename);
			int maxId=0;
			BuildingAction bulidingaction=new BuildingAction();
			String flag=request.getParameter("flag");
			String buildingId1=request.getParameter("buildingId");
			int buildingId=Integer.parseInt(buildingId1);
			if(flag.equals("1")){
				bulidingaction.locationphotoAdd(buildingId, null);
				maxId=bulidingaction.getMaxId("building_locationphoto");
				String locationPhoto="press"+maxId+filename;
				bulidingaction.locationphotoUpdate(maxId,buildingId, locationPhoto);
			}
			if(flag.equals("2")){
				bulidingaction.buildingphotoAdd(buildingId, null);
				maxId=bulidingaction.getMaxId("building_photo");
				String buildingPhoto="press"+maxId+filename;
				bulidingaction.buildingphotoUpdate(maxId,buildingId, buildingPhoto);
			}
			if(flag.equals("3")){
				bulidingaction.typephotoAdd(buildingId, null);
				maxId=bulidingaction.getMaxId("building_typephoto");
				String typePhoto="press"+maxId+filename;
				bulidingaction.typephotoUpdate(maxId,buildingId, typePhoto);
			}
			if(flag.equals("4")){
				bulidingaction.planphotoAdd(buildingId, null);
				maxId=bulidingaction.getMaxId("building_planphoto");
				//String planPhoto="scale"+maxId+filename;
				String planPhoto="press"+maxId+filename;
				bulidingaction.planphotoUpdate(maxId,buildingId, planPhoto);
			}
				 
			    DataOutputStream fileStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filepath+ maxId+filename)));
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
			String srcImageFile=filepath+ maxId+filename;
			//ImageUtils.scale(srcImageFile, filepath+"scale"+maxId+filename);
			//ImageUtils.pressText(filepath+"scale"+maxId+filename, filepath+"press"+maxId+filename);
			ImageUtils.pressText(srcImageFile, filepath+"press"+maxId+filename);
			}
			PrintWriter out=response.getWriter();
			String result = filename ;
			out.print(result);
			out.close();
			in.close();
				}
			
	if(category.equals("2")){
				 filepath=this.getServletConfig().getServletContext().getInitParameter("secondupload");
				ServletInputStream in = request.getInputStream();
				byte[] buf = new byte[4048];
				int len = in.readLine(buf, 0, buf.length);
				String f = new String(buf, 0, len - 1); 
				while ((len = in.readLine(buf, 0, buf.length)) != -1) {
					filename = new String(buf, 0, len,"utf-8");//解决编码问题
				    int j = filename.lastIndexOf("\"");
				    int s = filename.indexOf("filename");
				    name=filename.substring(s+10,j); 
				    filename = name;
				   // System.out.println("filename="+filename);
				int maxId=0;
				SecondAction secondaction=new SecondAction();
				String flag=request.getParameter("flag");
				String houseId1=request.getParameter("houseId");
				int houseId=Integer.parseInt(houseId1);
				if(flag.equals("1")){
					secondaction.typephotoAdd(houseId, null);
					maxId=secondaction.getMaxId("setype_photo");
					String typephotopath="press"+maxId+filename;
					secondaction.typephotoUpdate(maxId, houseId, typephotopath);
				}
				if(flag.equals("2")){
					secondaction.decoratephotoAdd(houseId, null);
					maxId=secondaction.getMaxId("sedecorate_photo");
					String decoratephotopath="press"+maxId+filename;
					secondaction.decoratephotoUpdate(maxId, houseId, decoratephotopath);
				}
					 
				    DataOutputStream fileStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filepath+ maxId+filename)));
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
				String srcImageFile=filepath+ maxId+filename;
				//ImageUtils.scale(srcImageFile, filepath+"scale"+maxId+filename);
				ImageUtils.pressText(srcImageFile, filepath+"press"+maxId+filename);
				}
				PrintWriter out=response.getWriter();
				String result = filename ;
				out.print(result);
				out.close();
				in.close();
					}
			
	if(category.equals("3")){
				 filepath=this.getServletConfig().getServletContext().getInitParameter("landupload");
				ServletInputStream in = request.getInputStream();
				byte[] buf = new byte[4048];
				int len = in.readLine(buf, 0, buf.length);
				String f = new String(buf, 0, len - 1); 
				while ((len = in.readLine(buf, 0, buf.length)) != -1) {
					filename = new String(buf, 0, len,"utf-8");//解决编码问题
				    int j = filename.lastIndexOf("\"");
				    int s = filename.indexOf("filename");
				    name=filename.substring(s+10,j); 
				    filename = name;
				   // System.out.println("filename="+filename);
				int maxId=0;
				LandAction landaction=new LandAction();
				String flag=request.getParameter("flag");
				String landId1=request.getParameter("landId");
				int landId=Integer.parseInt(landId1);
				if(flag.equals("1")){
					landaction.landlocationphotoAdd(landId,null);
					maxId=landaction.getMaxId("land_location");
					String locationpath="press"+maxId+filename;
					landaction.landlocationUpdate(maxId, landId, locationpath);
				}
				if(flag.equals("2")){
					landaction.landphotoAdd(landId,null);
					maxId=landaction.getMaxId("land_photo");
					String landphotopath="press"+maxId+filename;
					landaction.landphotoUpdate(maxId, landId, landphotopath);
				}
					 
				    DataOutputStream fileStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filepath+ maxId+filename)));
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
				String srcImageFile=filepath+ maxId+filename;
				//ImageUtils.scale(srcImageFile, filepath+"scale"+maxId+filename);
				ImageUtils.pressText(srcImageFile, filepath+"press"+maxId+filename);
				}
				PrintWriter out=response.getWriter();
				String result = filename ;
				out.print(result);
				out.close();
				in.close();
					}
		}
}
	
