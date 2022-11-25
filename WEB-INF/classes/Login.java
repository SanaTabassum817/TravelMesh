import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Login extends HttpServlet 
{

  
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();

       HttpSession session = request.getSession();     //creation of session
       session.setMaxInactiveInterval(2*24*60*60);     //timings

       String uname=request.getParameter("username");
       String password=request.getParameter("password");
 
       session.setAttribute(uname, password);            // set attributes
 
       TravelMeshDAO tmDAO=new TravelMeshDAO();

       boolean check=tmDAO.Login(uname,password);
   
          if(check==true)
           {
            
              RequestDispatcher rd = request.getRequestDispatcher("/Home.html");
	      rd.include(request,response);

           }
           else
           {
                
                RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
	        rd.include(request,response);
           }


  }

}
