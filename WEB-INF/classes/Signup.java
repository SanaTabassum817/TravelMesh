import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Signup extends HttpServlet 
{
  

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
    
       String uname=request.getParameter("username");
       String firstname=request.getParameter("firstname");
       String lastname=request.getParameter("lastname");
       String password=request.getParameter("password");
       String email=request.getParameter("email");
      int phoneno=Integer.parseInt(request.getParameter("phoneno"));

       HttpSession session = request.getSession();     //creation of session
       session.setMaxInactiveInterval(2*24*60*60);     //timings
       session.setAttribute(uname, password);            // set attributes

       Traveler tlr=new Traveler(uname,firstname,lastname,password,email,phoneno);
       TravelMeshDAO tmDAO=new TravelMeshDAO();

       boolean check=tmDAO.Signup(tlr);
    
       if(check==true)
       {
                RequestDispatcher rd = request.getRequestDispatcher("/Home.html");
	        rd.include(request,response);
       }
       else
       {
                RequestDispatcher rd = request.getRequestDispatcher("/Signup.html");
	        rd.include(request,response);
       }
 
       


  

  }

}
