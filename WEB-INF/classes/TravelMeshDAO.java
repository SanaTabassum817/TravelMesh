import java.io.*;
import java.sql.*;
import java.util.*;

public class TravelMeshDAO
{
     String url;
     Connection con;
     Statement st;
    public TravelMeshDAO()   //constructor
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://127.0.0.1/travelmesh";
            con=DriverManager.getConnection(url, "root", "root");
            st=con.createStatement();
        }
        catch(Exception e)
        {
            //
        }
    }


   public boolean Signup(Traveler tlr)  throws IOException //Signup function
   {
       try
       {
           
           String query = "INSERT INTO signup(username,firstname,lastname,password,email,phoneno)VALUES('"+tlr.username+"','"+ tlr.firstname + "','"+ tlr.lastname + "','"+ tlr.password + "','" + tlr.email+ "','"+ tlr.phoneno + "') ";
           st=con.createStatement();           
           int rs = st.executeUpdate( query );
 
           if(rs==1)
           {
             st.close();
             con.close();
             return true;
           }
         st.close();
         con.close();
         
       }
       catch(Exception e)
       {
            System.out.println(e);
       }
       
       return false;
   }

   public boolean Login(String uname,String password)  throws  IOException   //Login function
   {
        try{
          
           String query="Select * from signup where username='"+uname+"' ";
           ResultSet rs = st.executeQuery( query );

          if(rs.next())
          {
              String pass=rs.getString("password");
              if(password.equals(pass))
              {
            
                 st.close();
                 con.close();
                 return true;
              }
            
          }
          st.close();
          con.close();
         }
       catch(Exception e)
       {
           System.out.println(e);
       }
      
       return false;

  }

 public void Booking(String firstname,String lastname,String address,String email,String phoneno,int seats,String loc,String tid,String uname)  throws IOException //Booking function
 {
       try
       {
           
          
       String query = "INSERT INTO booking(firstname,lastname,address,email,phoneno,seats,tripid,location,username)VALUES('"+ firstname + "','"+ lastname + "','"+ address + "','" + email+ "','"+ phoneno + "','"+seats+"','"+tid+"','"+loc+"','"+uname+"') ";
       int rs = st.executeUpdate( query );

        if(rs==1)
        {
             st.close();
             con.close();
            
        }
         st.close();
         con.close();
       
       }
       catch(Exception e)
       {
            System.out.println(e);
       }
       
 }


 public boolean Cancel(String uname,String tid)  throws  IOException //Cancel function
 {
       try
       {
           
          String query="DELETE  from booking where username='"+uname+"' And tripid='"+tid+"' ";
          int rs = st.executeUpdate( query );
        if(rs==1)
        {
             st.close();
             con.close();
             return true;
            
        }
         st.close();
         con.close();
         
       
       }
       catch(Exception e)
       {
             System.out.println(e);
       }
      return false;
       
   }


 public boolean Debitcard(String uname,String tripid,String name,String cardno,String cvc,String edate,String payment,String baddress)  throws IOException //Debitcard function
 {
       try
       {
           
       String query = "INSERT INTO debitcard(username,tripid,name,cardno,cvc,expirydate,payment,billingaddress)VALUES('"+ uname + "','"+ tripid + "','"+name + "','"+ cardno + "','"+ cvc + "','"+edate+"','" + payment+ "','" + baddress+ "') ";
       int rs = st.executeUpdate( query );

        if(rs==1)
        {
             st.close();
             con.close();
             return true;
        }
         st.close();
         con.close();
       
       }
       catch(Exception e)
       {
             System.out.println(e);
       }
       return false;
       
 }

 public boolean Feedback(String uname,String name,String email,String phoneno,String subject,String msg)  throws IOException //Feedback function
 {
       try
       {
    
       String query = "INSERT INTO feedback(username,name,email,phoneno,subject,message)VALUES('"+uname+"','"+ name + "','"+ email + "','"+ phoneno + "','" + subject+ "','"+ msg + "') ";
       int rs = st.executeUpdate( query );

        if(rs==1)
        {
             st.close();
             con.close();
             return true;
        }
         st.close();
         con.close();
       
       }
       catch(Exception e)
       {
            System.out.println(e);
       }
       return false;
       
 }

 public boolean Forget(String uname,String pass,String email)  throws IOException //Forget function
 {
       try
       {
    
       
       String search="UPDATE signup set password='"+pass+"' where username='"+uname+"' AND email='"+email+"' ";
       int up = st.executeUpdate( search );

        if(up==1)
        {
             st.close();
             con.close();
             return true;
        }
         st.close();
         con.close();
       
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
       return false;
       
 }

 public boolean Jazzcash(String uname,String tripid,String owner,String tid,String payment)  throws IOException //Jazzcash function
 {
       try
       {
    
       String query = "INSERT INTO jazzcash(username,tripid,owner,tid,payment)VALUES('"+ uname + "','"+ tripid + "','"+owner + "','"+ tid + "','"+payment+"') ";
       int rs = st.executeUpdate( query );
        if(rs==1)
        {
             st.close();
             con.close();
             return true;
        }
         st.close();
         con.close();
       
       }
       catch(Exception e)       
       {
             System.out.println(e);
       }
       return false;
       
 }

 public ArrayList Trips(String uname)  throws IOException //BookedTrips function
 {
       BookedTrips bt=null;
       ArrayList<BookedTrips> bookedtrips=new ArrayList<BookedTrips>();
       try
       {
    
        String query="Select * from booking where username='"+uname+"' ";
        ResultSet rs = st.executeQuery( query );
     
        while(rs.next())
        {
             
              String firstname=rs.getString("firstname");
              String lastname=rs.getString("lastname");
              String address=rs.getString("address");
              String email=rs.getString("email");
              String phoneno=rs.getString("phoneno");
              int seats=Integer.parseInt(rs.getString("seats"));
              String loc=rs.getString("location");
              String tid=rs.getString("tripid");
              bt=new BookedTrips(firstname,lastname,address,email,phoneno,seats,loc,tid);
              bookedtrips.add(bt);
      
        }
         st.close();
         con.close();
       
       }
       catch(Exception e)
       {
             System.out.println(e);
       }
       
       return bookedtrips;
       
 }








}