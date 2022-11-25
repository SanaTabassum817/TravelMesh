import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Debitcard extends HttpServlet 
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
  
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
    
       
          String name=request.getParameter("name");
          String cardno=request.getParameter("cardno");
          String baddress=request.getParameter("billaddress");
          String cvc=request.getParameter("cvc");
          String edate=request.getParameter("expirydate");
          String payment=request.getParameter("payment");
      
          TravelMeshDAO tmDAO=new TravelMeshDAO();
          boolean check=tmDAO.Debitcard(uname,tripid, name, cardno, cvc,edate, payment, baddress);
          
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
