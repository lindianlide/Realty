package com.realty.base.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceException;

import com.realty.base.dao.MemberDao;
import com.realty.base.dao.impl.MemberDaoImpl;
import com.realty.base.model.Member;



/**
 * Servlet implementation class MailBackServlet
 */
@WebServlet("/MailBackServlet")
public class MailBackServlet extends HttpServlet {    
    private static final long serialVersionUID = 1L;    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
            doPost(request, response);
    }    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {  
    	String registerID = request.getParameter("registerId"); 
    	String email=request.getParameter("email");
    	System.out.print(registerID);
    	System.out.print(email);
        if(registerID == null){ 
        	       
            request.getRequestDispatcher("./website/home.jsp").forward(request,response);    
            return ;    
        }  
        
        MemberDao mm =new MemberDaoImpl();
        List<Member> list=mm.find(email);
        
 
        if(list!=null) {  
            //验证用户激活状态  
            if(list.get(0).getMemrole()==0) { 
                ///没激活
               // Date currentTime = new Date();//获取当前时间  
                //验证链接是否过期 
                //currentTime.before(list.get(0).getCreateTime());
               // if(currentTime.before(user.getLastActivateTime())) {  
                    //验证激活码是否正确  
                    if(registerID.equals(list.get(0).getRegisterId())) {  
                        //激活成功， //并更新用户的激活状态，为已激活 
                        System.out.println("==sq==="+list.get(0).getMemrole());
                        list.get(0).setMemrole(1);;//把状态改为激活
                        mm.update(email);
                        System.out.println("==sh==="+list.get(0).getMemrole());
                        
                        //mm.update(email,list.get(0).getMemberId());
                        request.getRequestDispatcher("./website/login/registerSuccess.jsp").forward(request,response);
                       
                        
                    } else {  
                       throw new ServiceException("激活码不正确");  
                    }  
               // } else { throw new ServiceException("激活码已过期！");  
               // }  
            } else {
               throw new ServiceException("邮箱已激活，请登录！");  
            }  
        } else {
            throw new ServiceException("该邮箱未注册（邮箱地址不存在）！");  
        }  
        
      //  request.getRequestDispatcher("/registSuccess.jsp").forward(request,response);
           
    }    
    
}    
