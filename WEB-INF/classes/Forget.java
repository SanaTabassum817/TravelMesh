import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Forget extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String uname=request.getParameter("username");
    String email=request.getParameter("email");
    String pass=request.getParameter("password");


    TravelMeshDAO tmDAO=new TravelMeshDAO();
    boolean check=tmDAO.Forget(uname, pass, email);
   
     if(check==true)
     {
        RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
	rd.include(request,response);	
     }
     else
     {	
       response.sendError(202,"SC ACCEPTED");
     }

  
    

  }

}
