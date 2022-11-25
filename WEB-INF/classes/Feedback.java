import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Feedback extends HttpServlet 
{
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
 
       HttpSession session = request.getSession(false);
       if(session!=null)
       {
           Enumeration attributeNames = session.getAttributeNames();
           String uname = attributeNames.nextElement().toString();
           String value = session.getAttribute(uname).toString();
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
    
       String name=request.getParameter("name");
       String email=request.getParameter("email");
       String phoneno=request.getParameter("phoneno");
       String subject=request.getParameter("subject");
       String msg=request.getParameter("message");

    
       TravelMeshDAO tmDAO=new TravelMeshDAO();
       boolean check=tmDAO.Feedback(uname, name, email, phoneno, subject, msg);
   
     if(check==true)
     {
      
        RequestDispatcher rd = request.getRequestDispatcher("/Forward");
	rd.include(request,response);	
     }
     else
     {	
       response.sendError(202,"SC ACCEPTED");
     }
}
}

}
