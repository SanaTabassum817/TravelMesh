import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;


public class Jazzcash extends HttpServlet 
{
  

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
  
       HttpSession session = request.getSession(false);
       if(session!=null)
       {
           Enumeration attributeNames = session.getAttributeNames();
           String uname = attributeNames.nextElement().toString();
           String value = session.getAttribute(uname).toString();
           String TripId = attributeNames.nextElement().toString();
           String tripid = session.getAttribute(TripId).toString();
       
           String payment=request.getParameter("payment");
           
      
  
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
    
       
       String tid=request.getParameter("tid");
       String owner=request.getParameter("owner");
      
       TravelMeshDAO tmDAO=new TravelMeshDAO();
       boolean check=tmDAO.Jazzcash( uname, tripid,owner,tid,payment);
      
       if(check==true)
       {
          RequestDispatcher rd = request.getRequestDispatcher("/Trips");
	  rd.include(request,response);

       }
       else
       {
          RequestDispatcher rd = request.getRequestDispatcher("/Payment.html");
	  rd.include(request,response);
       }
   
   
  }
}

}
