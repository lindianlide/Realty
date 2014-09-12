<%@ page contentType="text/html;charset=GBK"%>
<% 
     String filePath =request.getParameter("filePath");    
     String fileName = request.getParameter("fileName");  
     System.out.println(filePath);
     System.out.print(fileName);
    if(fileName!=null&&filePath!=null){    
         response.setContentType("application/x-download");  
         response.addHeader("Content-Disposition","attachment;filename=" + java.net.URLEncoder.encode(fileName,"UTF-8"));    
         try{  
             out.clear();  
             out=pageContext.pushBody();  
         }catch(Throwable e){ 
              e.printStackTrace();  
       }  
      try{  
         RequestDispatcher dis = application.getRequestDispatcher(filePath); 
              dis.forward(request,response);  
   }catch(Throwable e){  
    e.printStackTrace();  
     }finally{  
    response.flushBuffer();  
   }  
   }  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ÏÂÔØ³É¹¦
</body>
</html>