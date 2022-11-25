import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Logout extends HttpServlet 
{

  
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();

       HttpSession session = request.getSession(false);     //creation of session
      
 
    
 

    try
    {
        session.invalidate();
          
       response.sendRedirect("Login.html");
           
        
   

    }
    catch(Exception e)
    {
      out.println(e);
    }

  }

}
