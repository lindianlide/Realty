package com.realty.base.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.realty.base.action.MemberAction;
import com.realty.base.model.Member;

/**
 * Servlet implementation class WebLogin
 */
@WebServlet("/WebLogin")
public class WebLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebLogin() {
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
		System.out.println("23424");
		String membername=request.getParameter("membername");
		String memberpwd=request.getParameter("memberpwd");
		
		HttpSession session=request.getSession();
		
		 MemberAction member=new MemberAction();
		/*for(int i=0;i<memberAction.memberList().size();i++){
			 if(memberAction.memberList().get(i).getName().equals(membername)){
				 //String manrole=memberAction.memberList().get(i).getManrole();
				 //session.setAttribute("manrole", memrole);
			 }
		 }*/
		if(member.memberLogin(membername, memberpwd)){	
			
			List<Member> list = member.findn(membername);
			String memrole =Integer.toHexString(list.get(0).getMemrole());
			session.setAttribute("memrole", memrole);
			//System.out.println(list.get(0).getMemrole());
			session.setAttribute("membername", membername);	
			//System.out.print(membername);
			request.getRequestDispatcher("./website/home.jsp").forward(request,response);
			
		 }
		
		 else
		 { 
			// JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "用户名或密码错误", "登录提示", JOptionPane.ERROR_MESSAGE);
			// response.sendRedirect("./manage/login.jsp");
			 request.getRequestDispatcher("./website/login.jsp").forward(request,response);
		 }
	}

}

