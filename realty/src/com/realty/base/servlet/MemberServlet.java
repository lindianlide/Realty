package com.realty.base.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Date;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.apache.naming.java.javaURLContextFactory;
import com.realty.base.action.MemberAction;
import com.realty.base.dao.MemberDao;
import com.realty.base.dao.impl.MemberDaoImpl;
import com.realty.base.model.Member;
import com.realty.base.model.MyAuthenticator;
import com.realty.base.tools.MD5Util;

/**
 * Servlet implementation class MemberAdd
 */
@WebServlet("/MemberAdd")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
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
		String flag = request.getParameter("flag");
		String membername=request.getParameter("membername");
		System.out.print(membername);
		String memberpwd=request.getParameter("memberpwd");
		System.out.println(memberpwd);
		String email=request.getParameter("email");
		String question=request.getParameter("question");
		String answer = request.getParameter("answer");
		String registerId=MD5Util.encode2hex(email);
		
		MemberAction memberAction=new MemberAction();
		
		if(flag.equals("2"))//判断是否是邮箱找回密码
		{
			if(memberAction.find(email).get(0).getName().equals(membername))
			{
				System.out.print(membername);
				String userName = "cn147159@163.com";    
		        String password = "136063722380"; 
		        
		        String membernameq=memberAction.find(email).get(0).getName();
		        String memberpwdq=memberAction.find(email).get(0).getPassword();
		       
		            
		        Properties props = new Properties();    
		        props.setProperty("mail.smtp.host", "smtp.163.com");    
		        props.setProperty("mail.smtp.auth", "true"); 
		        
		        Authenticator authenticator = new MyAuthenticator(userName, password);    
	            
		        javax.mail.Session session = javax.mail.Session.getDefaultInstance(props,authenticator);    
		        session.setDebug(true);
		        
		        try{    
		            Address from = new InternetAddress(userName);    
		            Address to = new InternetAddress(email);    
		                
		            MimeMessage msg = new MimeMessage(session);    
		            msg.setFrom(from);    
		            msg.setSubject("测试");    
		            msg.setSentDate(new Date());    
		            msg.setContent("尊敬的" + membernameq + ":您的密码是" + memberpwdq + "。请登录后尽快修改密码谢谢", "text/html;charset=utf-8");    
		            msg.setRecipient(RecipientType.TO, to);    
		              
		           /* Transport transport = session.getTransport("smtp");  
		            transport.connect("smtp.163.com", userName, password);  
		            transport.sendMessage(msg,msg.getAllRecipients());  
		            transport.close();  */
		              
		            Transport.send(msg);    
		        } catch(MessagingException e){    
		            e.printStackTrace();    
		        }    
		         
				request.getRequestDispatcher("./website/login/sendMailSuccess.jsp").forward(request,response);
			}else {
				System.out.print("用户名和邮箱不一致");
				request.getRequestDispatcher("./website/login/.jsp").forward(request,response);
			}
			
			
		}else{
				/*HttpSession session=request.getSession();
		session.setAttribute("membername", membername);
		session.setAttribute("memberpwd", memberpwd);*/
		
		 
		/*for(int i=0;i<memberAction.memberList().size();i++){
			 if(memberAction.memberList().get(i).getName().equals(membername)){
				 //String manrole=memberAction.memberList().get(i).getManrole();
				 //session.setAttribute("manrole", manrole);
			 }
		 }*/
			if(flag.equals("1")&&memberAction.find(email).isEmpty()){
		
		if(memberAction.findn(membername).isEmpty()){
		if(memberAction.memberAdd(membername, memberpwd,email,question,answer,registerId))
			
		 {	
	        String userName = "cn147159@163.com";    
	        String password = "136063722380"; 
	        
	        String url = "http://localhost:8088/realty/MailBackServlet?registerId=" + registerId + "&email="+email;//待会用户点在邮箱中点击这个链接回到你的网站。    
            System.out.print(url);
	        HttpSession httpSession = request.getSession();    
	       // httpSession.setAttribute(registerId, membername);    
	        httpSession.setMaxInactiveInterval(600);    
	            
	        Properties props = new Properties();    
	        props.setProperty("mail.smtp.host", "smtp.163.com");    
	        props.setProperty("mail.smtp.auth", "true"); 
	        
	        Authenticator authenticator = new MyAuthenticator(userName, password);    
            
	        javax.mail.Session session = javax.mail.Session.getDefaultInstance(props,authenticator);    
	        session.setDebug(true);
	        
	        try{    
	            Address from = new InternetAddress(userName);    
	            Address to = new InternetAddress(email);    
	                
	            MimeMessage msg = new MimeMessage(session);    
	            msg.setFrom(from);    
	            msg.setSubject("测试");    
	            msg.setSentDate(new Date());    
	            msg.setContent("<a href='" + url + "'>点击" + url + "完成注册</a>", "text/html;charset=utf-8");    
	            msg.setRecipient(RecipientType.TO, to);    
	              
	           /* Transport transport = session.getTransport("smtp");  
	            transport.connect("smtp.163.com", userName, password);  
	            transport.sendMessage(msg,msg.getAllRecipients());  
	            transport.close();  */
	              
	            Transport.send(msg);    
	        } catch(MessagingException e){    
	            e.printStackTrace();    
	        }    
	         
			request.getRequestDispatcher("./website/login/sendMailSuccess.jsp").forward(request,response);
			
		 }
		
		 else
		 { 
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "注册失败", "注册提示", JOptionPane.ERROR_MESSAGE);
			// response.sendRedirect("./manage/login.jsp");
			 request.getRequestDispatcher("./website/register.jsp").forward(request,response);
		 }
	}else{
		System.out.print("用户名已存在");
	}
	}
	else{
		System.out.print("邮箱已经存在");
	}
	if(flag=="3"){
		
		}
	}
	}

}
