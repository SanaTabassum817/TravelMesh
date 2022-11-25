import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Forward extends HttpServlet 
{

  
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
        HttpSession session = request.getSession(false);
       if(session!=null)
       {
          

           response.setContentType("text/html");

          PrintWriter out = response.getWriter();

    try
    {
             RequestDispatcher rd = request.getRequestDispatcher("/Home.html");
	      rd.forward(request,response);

   }  
 catch(Exception e)
    {
      out.println(e);
    }

  }}

}
