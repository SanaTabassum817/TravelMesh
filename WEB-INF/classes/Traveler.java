import java.io.*;
import java.sql.*;
import java.util.*;
public class Traveler
{
   String username;
   String firstname;
   String lastname;
   String password;
   String email;
   int phoneno;
   
   public Traveler(String u,String f,String l,String p,String e,int ph)
   {
     username=u;
     firstname=f;
     lastname=l;
     password=p;
     email=e;
     phoneno=ph;
   }
}