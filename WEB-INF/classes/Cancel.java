import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Cancel extends HttpServlet 
{

  
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
            
           response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
           HttpSession session = request.getSession(false);
       if(session!=null)
       {
       
           Enumeration attributeNames = session.getAttributeNames();
           String uname = attributeNames.nextElement().toString();
           String value = session.getAttribute(uname).toString();
           String TripId = attributeNames.nextElement().toString();
           String tid = session.getAttribute(TripId).toString();
       
          // String tid=(String)request.getAttribute("TripId");
          
           //out.println("Trip"+tid);
        
           TravelMeshDAO tmDAO=new TravelMeshDAO();
           boolean check=tmDAO.Cancel(uname,tid);

       if(check==true)
       {
             session.removeAttribute("TripId");
             RequestDispatcher rd = request.getRequestDispatcher("/Trips");
	     rd.include(request,response);
       }
      else
      {
        response.sendError(202,"SC CANCEL_ERROR");
      }
    }
else
{
  response.sendError(202,"SC SESSION_ERROR");
}
}


}
