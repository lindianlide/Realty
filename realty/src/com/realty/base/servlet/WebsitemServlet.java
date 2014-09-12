package com.realty.base.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.realty.base.action.WebsiteAction;
import com.realty.base.model.Culture;
import com.realty.base.model.Law;
import com.realty.base.model.Macro;
import com.realty.base.model.Micro;
import com.realty.base.model.News;
import com.realty.base.model.Project;
import com.realty.base.model.Research;

/**
 * Servlet implementation class WebsitemServlet
 */
@WebServlet("/WebsitemServlet")
public class WebsitemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebsitemServlet() {
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
		String flag=request.getParameter("flag");

		if(flag.equals("1")){
		String contents=request.getParameter("content");
		String title=request.getParameter("housetitle");
		String procategoryId1=request.getParameter("procategoryId");
		int procategoryId=Integer.parseInt(procategoryId1);
		int browses=0;
		String proFile=null;
		Date date=null;
		String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			 date = sdf.parse(datetime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebsiteAction website=new WebsiteAction();
		boolean result=website.projectAdd(title, procategoryId, date, browses, contents, proFile);
		if(result)
		response.sendRedirect("manage/web/project/project_list.jsp?procategoryId="+procategoryId);
		 else{
				JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
				response.sendRedirect("manage/web/project/project_add.jsp?procategoryId="+procategoryId);
			 }	
		}
		if(flag.equals("2")){
			
		String projectId1=request.getParameter("projectId");
		int projectId=Integer.parseInt(projectId1);
		String contents=request.getParameter("content");
		String title=request.getParameter("housetitle");
		String procategoryId1=request.getParameter("procategoryId");
		int procategoryId=Integer.parseInt(procategoryId1);
		int browses=0;
		String proFile=null;
		WebsiteAction website=new WebsiteAction();
		website.projectUpdate(projectId,title,browses,contents, proFile);
		response.sendRedirect("manage/web/project/project_list.jsp?procategoryId="+procategoryId);
		}
		if(flag.equals("3")){
			String procategoryId1=request.getParameter("procategoryId");
			int procategoryId=Integer.parseInt(procategoryId1);
			String projectId1=request.getParameter("projectId");
			int projectId=Integer.parseInt(projectId1);
			WebsiteAction website=new WebsiteAction();
			website.projectDel(projectId);
			response.sendRedirect("manage/web/project/project_list.jsp?procategoryId="+procategoryId);

			}
	if(flag.equals("4")){
			
			String title=request.getParameter("searchtitle");
			WebsiteAction website=new WebsiteAction();
			List<Project> searchlist=website.projectSearch(title);
			request.getSession().setAttribute("prosearchlist", searchlist);
			response.sendRedirect("manage/web/project/projectsearch_list.jsp");
			}
	
	if(flag.equals("5")){
		String contents=request.getParameter("content");
		String title=request.getParameter("newstitle");
		String newscategoryId1=request.getParameter("newscategoryId");
		int newscategoryId=Integer.parseInt(newscategoryId1);
		int browses=0;
		String newsFile=null;
		Date date=null;
		String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			 date = sdf.parse(datetime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebsiteAction website=new WebsiteAction();
		boolean result=website.newsAdd(title, newscategoryId, date, browses, contents, newsFile);
		if(result)
		response.sendRedirect("manage/web/news/news_list.jsp?newscategoryId="+newscategoryId);
		 else{
				JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
				response.sendRedirect("manage/web/news/news_add.jsp?newscategoryId="+newscategoryId);
			 }	
		}
	if(flag.equals("6")){
		
	String newsId1=request.getParameter("newsId");
	int newsId=Integer.parseInt(newsId1);
	String contents=request.getParameter("content");
	String title=request.getParameter("newstitle");
	String newscategoryId1=request.getParameter("newscategoryId");
	int newscategoryId=Integer.parseInt(newscategoryId1);
	int browses=0;
	String proFile=null;
	WebsiteAction website=new WebsiteAction();
	website.newsUpdate(newsId,title,browses,contents, proFile);
	response.sendRedirect("manage/web/news/news_list.jsp?newscategoryId="+newscategoryId);
	}
	if(flag.equals("7")){
		String newscategoryId1=request.getParameter("newscategoryId");
		int newscategoryId=Integer.parseInt(newscategoryId1);
		String newsId1=request.getParameter("newsId");
		int newsId=Integer.parseInt(newsId1);
		WebsiteAction website=new WebsiteAction();
		website.newsDel(newsId);
		response.sendRedirect("manage/web/news/news_list.jsp?newscategoryId="+newscategoryId);
		}
		if(flag.equals("8")){
				
				String title=request.getParameter("searchtitle");
				WebsiteAction website=new WebsiteAction();
				List<News> searchlist=website.newsSearch(title);
				request.getSession().setAttribute("newssearchlist", searchlist);
				response.sendRedirect("manage/web/news/newssearch_list.jsp");
				}
		if(flag.equals("9")){
			String contents=request.getParameter("content");
			String title=request.getParameter("researchtitle");
			String reschcategoryId1=request.getParameter("reschcategoryId");
			int reschcategoryId=Integer.parseInt(reschcategoryId1);
			int browses=0;
			String researchFile=null;
			Date date=null;
			String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				 date = sdf.parse(datetime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebsiteAction website=new WebsiteAction();
			boolean result=website.researchAdd(title, reschcategoryId, date, browses, contents, researchFile);
			if(result)
			response.sendRedirect("manage/web/research/research_list.jsp?reschcategoryId="+reschcategoryId);
			 else{
					JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
					response.sendRedirect("manage/web/research/research_add.jsp?reschcategoryId="+reschcategoryId);
				 }	
			}
		if(flag.equals("10")){
			
		String researchId1=request.getParameter("researchId");
		int researchId=Integer.parseInt(researchId1);
		String contents=request.getParameter("content");
		String title=request.getParameter("researchtitle");
		String reschcategoryId1=request.getParameter("reschcategoryId");
		int reschcategoryId=Integer.parseInt(reschcategoryId1);
		int browses=0;
		String proFile=null;
		WebsiteAction website=new WebsiteAction();
		website.researchUpdate(researchId,title,browses,contents, proFile);
		response.sendRedirect("manage/web/research/research_list.jsp?reschcategoryId="+reschcategoryId);
		}
		if(flag.equals("11")){
			String reschcategoryId1=request.getParameter("reschcategoryId");
			int reschcategoryId=Integer.parseInt(reschcategoryId1);
			String researchId1=request.getParameter("researchId");
			int researchId=Integer.parseInt(researchId1);
			WebsiteAction website=new WebsiteAction();
			website.researchDel(researchId);
			response.sendRedirect("manage/web/research/research_list.jsp?reschcategoryId="+reschcategoryId);
			}
		if(flag.equals("12")){
			
			String title=request.getParameter("searchtitle");
			WebsiteAction website=new WebsiteAction();
			List<Research> searchlist=website.researchSearch(title);
			request.getSession().setAttribute("researchsearchlist", searchlist);
			response.sendRedirect("manage/web/research/researchsearch_list.jsp");
			}
		if(flag.equals("13")){
			String contents=request.getParameter("content");
			String title=request.getParameter("culturetitle");
			String culcategoryId1=request.getParameter("culcategoryId");
			int culcategoryId=Integer.parseInt(culcategoryId1);
			int browses=0;
			String culFile=null;
			Date date=null;
			String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				 date = sdf.parse(datetime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebsiteAction website=new WebsiteAction();
			boolean result=website.cultureAdd(title, culcategoryId, date, browses, contents, culFile);
			if(result)
			response.sendRedirect("manage/web/culture/culture_list.jsp?culcategoryId="+culcategoryId);
			 else{
					JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
					response.sendRedirect("manage/web/culture/culture_add.jsp?culcategoryId="+culcategoryId);
				 }	
			}
		if(flag.equals("14")){
			
			String cultureId1=request.getParameter("cultureId");
			int cultureId=Integer.parseInt(cultureId1);
			String contents=request.getParameter("content");
			String title=request.getParameter("culturetitle");
			String culcategoryId1=request.getParameter("culcategoryId");
			int culcategoryId=Integer.parseInt(culcategoryId1);
			int browses=0;
			String culFile=null;
			WebsiteAction website=new WebsiteAction();
			website.cultureUpdate(cultureId, title, browses, contents, culFile);
			response.sendRedirect("manage/web/culture/culture_list.jsp?culcategoryId="+culcategoryId);
			}
			if(flag.equals("15")){
				String culcategoryId1=request.getParameter("culcategoryId");
				int culcategoryId=Integer.parseInt(culcategoryId1);
				String cultureId1=request.getParameter("cultureId");
				int cultureId=Integer.parseInt(cultureId1);
				WebsiteAction website=new WebsiteAction();
				website.cultureDel(cultureId);
				response.sendRedirect("manage/web/culture/culture_list.jsp?culcategoryId="+culcategoryId);
				}
		if(flag.equals("16")){
				
				String title=request.getParameter("searchtitle");
				WebsiteAction website=new WebsiteAction();
				List<Culture> searchlist=website.cultureSearch(title);
				request.getSession().setAttribute("culsearchlist", searchlist);
				response.sendRedirect("manage/web/culture/culturesearch_list.jsp");
				}
		
		if(flag.equals("17")){
			String contents=request.getParameter("content");
			String title=request.getParameter("lawtitle");
			String keyword=request.getParameter("lawkeyword");
			String lawcategoryId1=request.getParameter("lawcategoryId");
			int lawcategoryId=Integer.parseInt(lawcategoryId1);
			int browses=0;
			String lawFile=null;
			Date date=null;
			String company=null;
			String summary=null;
			String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				 date = sdf.parse(datetime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebsiteAction website=new WebsiteAction();
			boolean result=website.lawAdd(title, lawcategoryId, date, browses, contents, lawFile, company, keyword, summary);
			if(result)
			response.sendRedirect("manage/web/law/law_list.jsp?lawcategoryId="+lawcategoryId);
			 else{
					JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
					response.sendRedirect("manage/web/law/law_add.jsp?lawcategoryId="+lawcategoryId);
				 }	
			}
		if(flag.equals("18")){
			
			String lawId1=request.getParameter("lawId");
			int lawId=Integer.parseInt(lawId1);
			String contents=request.getParameter("content");
			String title=request.getParameter("lawtitle");
			String keyword=request.getParameter("lawkeyword");
			String lawcategoryId1=request.getParameter("lawcategoryId");
			int lawcategoryId=Integer.parseInt(lawcategoryId1);
			int browses=0;
			String lawFile=null;
			String company=null;
			String summary=null;
			WebsiteAction website=new WebsiteAction();
			website.lawUpdate(lawId, title, browses, contents, lawFile, company, keyword, summary);
			response.sendRedirect("manage/web/law/law_list.jsp?lawcategoryId="+lawcategoryId);
			}
			if(flag.equals("19")){
				String lawcategoryId1=request.getParameter("lawcategoryId");
				int lawcategoryId=Integer.parseInt(lawcategoryId1);
				String lawId1=request.getParameter("lawId");
				int lawId=Integer.parseInt(lawId1);
				WebsiteAction website=new WebsiteAction();
				website.lawDel(lawId);
				response.sendRedirect("manage/web/law/law_list.jsp?lawcategoryId="+lawcategoryId);
				}
		if(flag.equals("20")){
				
				String title=request.getParameter("searchtitle");
				WebsiteAction website=new WebsiteAction();
				List<Law> searchlist=website.lawSearch(title);
				request.getSession().setAttribute("lawsearchlist", searchlist);
				response.sendRedirect("manage/web/law/lawsearch_list.jsp");
				}
		if(flag.equals("21")){
			String contents=request.getParameter("content");
			String title=request.getParameter("macrotitle");
			String macrocategoryId1=request.getParameter("macrocategoryId");
			int macrocategoryId=Integer.parseInt(macrocategoryId1);
			int browses=0;
			String macroFile=null;
			Date date=null;
			String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				 date = sdf.parse(datetime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebsiteAction website=new WebsiteAction();
			boolean result=website.macroAdd(title, macrocategoryId, date, browses, contents, macroFile);
			if(result)
			response.sendRedirect("manage/web/macro/macro_list.jsp?macrocategoryId="+macrocategoryId);
			 else{
					JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
					response.sendRedirect("manage/web/macro/macro_add.jsp?macrocategoryId="+macrocategoryId);
				 }	
			}
		if(flag.equals("22")){
			
		String macroId1=request.getParameter("macroId");
		int macroId=Integer.parseInt(macroId1);
		String contents=request.getParameter("content");
		String title=request.getParameter("macrotitle");
		String macrocategoryId1=request.getParameter("macrocategoryId");
		int macrocategoryId=Integer.parseInt(macrocategoryId1);
		int browses=0;
		String proFile=null;
		WebsiteAction website=new WebsiteAction();
		website.macroUpdate(macroId,title,browses,contents, proFile);
		response.sendRedirect("manage/web/macro/macro_list.jsp?macrocategoryId="+macrocategoryId);
		}
		if(flag.equals("23")){
			String macrocategoryId1=request.getParameter("macrocategoryId");
			int macrocategoryId=Integer.parseInt(macrocategoryId1);
			String macroId1=request.getParameter("macroId");
			int macroId=Integer.parseInt(macroId1);
			WebsiteAction website=new WebsiteAction();
			website.macroDel(macroId);
			response.sendRedirect("manage/web/macro/macro_list.jsp?macrocategoryId="+macrocategoryId);
			}
			if(flag.equals("24")){
					
					String title=request.getParameter("searchtitle");
					WebsiteAction website=new WebsiteAction();
					List<Macro> searchlist=website.macroSearch(title);
					request.getSession().setAttribute("macrosearchlist", searchlist);
					response.sendRedirect("manage/web/macro/macrosearch_list.jsp");
					}
			if(flag.equals("25")){
				String contents=request.getParameter("content");
				String title=request.getParameter("microtitle");
				String microcategoryId1=request.getParameter("microcategoryId");
				int microcategoryId=Integer.parseInt(microcategoryId1);
				int browses=0;
				String microFile=null;
				Date date=null;
				String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					 date = sdf.parse(datetime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				WebsiteAction website=new WebsiteAction();
				boolean result=website.microAdd(title, microcategoryId, date, browses, contents, microFile);
				if(result)
				response.sendRedirect("manage/web/micro/micro_list.jsp?microcategoryId="+microcategoryId);
				 else{
						JOptionPane.showMessageDialog(null, "增加失败!", "标题",JOptionPane.WARNING_MESSAGE);  
						response.sendRedirect("manage/web/micro/micro_add.jsp?microcategoryId="+microcategoryId);
					 }	
				}
			if(flag.equals("26")){
				
			String microId1=request.getParameter("microId");
			int microId=Integer.parseInt(microId1);
			String contents=request.getParameter("content");
			String title=request.getParameter("microtitle");
			String microcategoryId1=request.getParameter("microcategoryId");
			int microcategoryId=Integer.parseInt(microcategoryId1);
			int browses=0;
			String proFile=null;
			WebsiteAction website=new WebsiteAction();
			website.microUpdate(microId,title,browses,contents, proFile);
			response.sendRedirect("manage/web/micro/micro_list.jsp?microcategoryId="+microcategoryId);
			}
			if(flag.equals("27")){
				String microcategoryId1=request.getParameter("microcategoryId");
				int microcategoryId=Integer.parseInt(microcategoryId1);
				String microId1=request.getParameter("microId");
				int microId=Integer.parseInt(microId1);
				WebsiteAction website=new WebsiteAction();
				website.microDel(microId);
				response.sendRedirect("manage/web/micro/micro_list.jsp?microcategoryId="+microcategoryId);
				}
			if(flag.equals("28")){
					String title=request.getParameter("searchtitle");
					WebsiteAction website=new WebsiteAction();
					List<Micro> searchlist=website.microSearch(title);
					request.getSession().setAttribute("microsearchlist", searchlist);
					response.sendRedirect("manage/web/micro/microsearch_list.jsp");
					}
		}

}
