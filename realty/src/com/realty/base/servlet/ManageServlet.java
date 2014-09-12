package com.realty.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.realty.base.action.ManagerAction;

/**
 * Servlet implementation class ManageLogin
 */
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageServlet() {
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
	    //PrintWriter out = response.getWriter();
		String flag=request.getParameter("flag");
		if(flag.equals("1")){
		String managername=request.getParameter("managername");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		session.setAttribute("uid", ",dbpg.");
		
		 ManagerAction manageraction=new ManagerAction();
		 for(int i=0;i<manageraction.managerList().size();i++){
			 if(manageraction.managerList().get(i).getName().equals(managername)){
				 String manrole=manageraction.managerList().get(i).getManrole();
				 session.setAttribute("manrole", manrole);
			 }
		 }
		 if(manageraction.managerLogin(managername, password))
			// response.sendRedirect("./manage/index.jsp");
		 {	 
			 session.setAttribute("managername", managername);
			 request.getRequestDispatcher("./manage/main.jsp").forward(request,response);
		 }
		 else
		 { 
			 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "用户名或密码错误", "登录提示", JOptionPane.ERROR_MESSAGE);
		 // response.sendRedirect("./manage/login.jsp");
			 request.getRequestDispatcher("./manage/login.jsp").forward(request,response);
		 }
		}
		if(flag.equals("2")){
			String manrole=request.getParameter("manrole");
			String managename=request.getParameter("managename");
			String managepwd=request.getParameter("managepwd");
			ManagerAction manageraction=new ManagerAction();
			manageraction.addManager(managename, managepwd, manrole);
			response.sendRedirect("./manage/user/user_list.jsp");
		}
		if(flag.equals("3")){
			String manId1=request.getParameter("manId");
			int manId=Integer.parseInt(manId1);
			String manrole=request.getParameter("manrole");
			String managename=request.getParameter("managename");
			String managepwd=request.getParameter("managepwd");
			ManagerAction manageraction=new ManagerAction();
			manageraction.updateManager(manId,managename, managepwd, manrole);
			response.sendRedirect("./manage/user/user_list.jsp");
		}
		if(flag.equals("4")){
			String manId1=request.getParameter("manId");
			int manId=Integer.parseInt(manId1);
			ManagerAction manageraction=new ManagerAction();
			manageraction.delManager(manId);
			response.sendRedirect("./manage/user/user_list.jsp");
			
		}
	}
	
	
}
