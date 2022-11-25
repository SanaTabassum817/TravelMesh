import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;


public class Booking extends HttpServlet 
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
    
       
       String firstname=request.getParameter("firstname");
       String lastname=request.getParameter("lastname");
       String address=request.getParameter("address");
       String email=request.getParameter("email");
       String phoneno=request.getParameter("phoneno");
       int seats=Integer.parseInt(request.getParameter("seats"));
       String loc=request.getParameter("location");
       String tid=request.getParameter("tripid");
       session.setAttribute("TripId", tid); 
      
    
        RequestDispatcher rd = request.getRequestDispatcher("/Payment.html");
	rd.include(request,response);

       TravelMeshDAO tmDAO=new TravelMeshDAO();
       tmDAO.Booking(firstname,lastname,address,email,phoneno,seats,loc,tid,uname);
     

 

    }
}

}
