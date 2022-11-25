import java.io.*;
import java.sql.*;
import java.util.*;
public class BookedTrips
{
 
   String firstname;
   String lastname;
   String address;
   String email;
   String phoneno;
   int seats;
   String loc;
   String tid;

  BookedTrips()
  {
     firstname="";
     lastname="";
     address="";
     email="";
     phoneno="";
     seats=0;
     loc="";
     tid="";
  }
   
   public BookedTrips(String f,String l,String a,String e,String ph,int s,String loct,String td)
   {
    
     firstname=f;
     lastname=l;
     address=a;
     email=e;
     phoneno=ph;
     seats=s;
     loc=loct;
     tid=td;
     
   }
}