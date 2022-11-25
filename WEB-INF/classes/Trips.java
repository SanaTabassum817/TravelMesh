import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;


public class Trips extends HttpServlet 
{

  
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {

        HttpSession session = request.getSession(false);
       if(session!=null)
       {
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();

         Enumeration attributeNames = session.getAttributeNames();
         String uname = attributeNames.nextElement().toString();
         String value = session.getAttribute(uname).toString();

        TravelMeshDAO tmDAO=new TravelMeshDAO();
        ArrayList bookedtrips = tmDAO.Trips(uname);
        
    
       int count=1;
       int i=0;
   
      out.println("<html><head><title>Trips</title></head><body bgcolor=#ceeeee>");
      out.println("<p>After cancelling your trip,contact us through email travelmesh@gmail.com for your return payment.</p>");
      out.println("<h2>Booked Trips</h2>");
      out.println("<table border=1><tr><th>Trip No</th><th>Trip Id</th><th>First Name</th><th>Last Name</th><th>Address</th><th>Email</th><th>Phoneno</th><th>Seats</th><th>Trip Place</th><th>Pick&Drop</th><th>Departure</th><th>Arrival</th><th>Price</th><th>Cancel</th></tr>");
     while(i<bookedtrips.size())
     {
         BookedTrips bt=(BookedTrips)bookedtrips.get(i);
         if(bt.tid.equals("LH01"))
     {
     
     
      out.println("<tr><td>"+count+"</td><td>"+bt.tid+"</td><td>"+bt.firstname+"</td><td>"+bt.lastname+"</td><td>"+bt.address+"</td><td>"+bt.email+"</td><td>"+bt.phoneno+"</td><td>"+bt.seats+"</td><td>"+bt.loc+"</td><td>Raiwind City Near PGC</td><td>3-jan-2022 , 8:30 am</td><td> 3-jan-2022 , 6:00 pm</td><td> Rs 4000</td><td><FORM ACTION=\"Cancel\" METHOD=POST><INPUT TYPE=submit VALUE=\" Cancel \"></FORM> </td></tr>");
      session.setAttribute("TripId",bt.tid); 
      request.setAttribute("TripId",bt.tid);
      count++;

     }
      if(bt.tid.equals("IB02"))
     {
     
       
      out.println("<tr><td>"+count+"</td><td>"+bt.tid+"</td><td>"+bt.firstname+"</td><td>"+bt.lastname+"</td><td>"+bt.address+"</td><td>"+bt.email+"</td><td>"+bt.phoneno+"</td><td>"+bt.seats+"</td><td>"+bt.loc+"</td><td>Dewoo terminal thokr</td><td>5-jan-2022 , 9:00 pm</td><td> 6-jan-2022 , 11:00 pm</td><td> Rs 5000</td><td><FORM ACTION=\"Cancel\" METHOD=POST><INPUT TYPE=submit  VALUE=\" Cancel \"></FORM> </td></tr>");
      session.setAttribute("TripId",bt.tid); 
      request.setAttribute("TripId",bt.tid);
    
      count++;

     }
  if(bt.tid.equals("CT03"))
     {
 
      out.println("<tr><td>"+count+"</td><td>"+bt.tid+"</td><td>"+bt.firstname+"</td><td>"+bt.lastname+"</td><td>"+bt.address+"</td><td>"+bt.email+"</td><td>"+bt.phoneno+"</td><td>"+bt.seats+"</td><td>"+bt.loc+"</td><td>Dewoo terminal thokr</td><td>6-jan-2022 , 9:00 pm</td><td> 8-jan-2022 , 11:00 pm</td><td> Rs 8000</td><td><FORM ACTION=\"Cancel\" METHOD=POST><INPUT TYPE=submit VALUE=\" Cancel \"></FORM> </td></tr>");
      session.setAttribute("TripId",bt.tid); 
      request.setAttribute("TripId",bt.tid);
      count++;

     }
  if(bt.tid.equals("ST04"))
     {
      
      out.println("<tr><td>"+count+"</td><td>"+bt.tid+"</td><td>"+bt.firstname+"</td><td>"+bt.lastname+"</td><td>"+bt.address+"</td><td>"+bt.email+"</td><td>"+bt.phoneno+"</td><td>"+bt.seats+"</td><td>"+bt.loc+"</td><td>Dewoo terminal thokr</td><td>10-jan-2022 , 9:00 pm</td><td> 12-jan-2022 , 11:00 pm</td><td> Rs 7500</td><td><FORM ACTION=\"Cancel\" METHOD=POST><INPUT TYPE=submit VALUE=\" Cancel \"></FORM> </td></tr>");
      session.setAttribute("TripId",bt.tid); 
      request.setAttribute("TripId",bt.tid);
      count++;

     }
  if(bt.tid.equals("MU05"))
     {
    
      out.println("<tr><td>"+count+"</td><td>"+bt.tid+"</td><td>"+bt.firstname+"</td><td>"+bt.lastname+"</td><td>"+bt.address+"</td><td>"+bt.email+"</td><td>"+bt.phoneno+"</td><td>"+bt.seats+"</td><td>"+bt.loc+"</td><td>Dewoo terminal thokr</td><td> 11-jan-2022 , 8:30 pm</td><td> 13-jan-2022 , 6:00 pm</td><td> Rs 4500</td><td><FORM ACTION=\"Cancel\" METHOD=POST><INPUT TYPE=submit VALUE=\" Cancel \"></FORM> </td></tr>");
      session.setAttribute("TripId",bt.tid); 
      request.setAttribute("TripId",bt.tid);
    
      count++;

     }
  if(bt.tid.equals("NK06"))
     {
     

      out.println("<tr><td>"+count+"</td><td>"+bt.tid+"</td><td>"+bt.firstname+"</td><td>"+bt.lastname+"</td><td>"+bt.address+"</td><td>"+bt.email+"</td><td>"+bt.phoneno+"</td><td>"+bt.seats+"</td><td>"+bt.loc+"</td><td>Dewoo terminal thokr</td><td> 11-jan-2022 , 9:00 pm</td><td>13-jan-2022 , 11:00 pm</td><td> Rs 5000</td><td><FORM ACTION=\"Cancel\" METHOD=POST><INPUT TYPE=submit VALUE=\" Cancel \"></FORM> </td></tr>");
      session.setAttribute("TripId",bt.tid); 
       request.setAttribute("TripId",bt.tid);
      
    
      count++;

     }
  if(bt.tid.equals("SK07"))
     {
       
      out.println("<tr><td>"+count+"</td><td>"+bt.tid+"</td><td>"+bt.firstname+"</td><td>"+bt.lastname+"</td><td>"+bt.address+"</td><td>"+bt.email+"</td><td>"+bt.phoneno+"</td><td>"+bt.seats+"</td><td>"+bt.loc+"</td><td>Dewoo terminal thokr</td><td> 13-jan-2022 , 9:00 pm</td><td>15-jan-2022 , 11:00 pm</td><td> Rs 8000</td><td><FORM ACTION=\"Cancel\" METHOD=POST><INPUT TYPE=submit VALUE=\" Cancel \"></FORM> </td></tr>");
      session.setAttribute("TripId",bt.tid); 
     request.setAttribute("TripId",bt.tid);
     
 
      count++;

     }
  if(bt.tid.equals("HU08"))
     {
      
      out.println("<tr><td>"+count+"</td><td>"+bt.tid+"</td><td>"+bt.firstname+"</td><td>"+bt.lastname+"</td><td>"+bt.address+"</td><td>"+bt.email+"</td><td>"+bt.phoneno+"</td><td>"+bt.seats+"</td><td>"+bt.loc+"</td><td>Dewoo terminal thokr</td><td> 10-jan-2022 , 9:00 pm</td><td>12-jan-2022 , 11:00 pm</td><td> Rs 7500</td><td><FORM ACTION=\"Cancel\" METHOD=POST><INPUT TYPE=submit VALUE=\" Cancel \"></FORM> </td></tr>");
      session.setAttribute("TripId",bt.tid); 
      request.setAttribute("TripId",bt.tid);
      count++;

     }
     i++;
     }
  out.println("</table></body></html>");
     
 }
  }

}
