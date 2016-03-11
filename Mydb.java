/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydb;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author szehra.bscs13seecs
 */
public class Mydb {
// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CSV_INFO cs=new CSV_INFO();
        
        BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    
    
    
        
        Connection conn = null;
        PreparedStatement prep_statement = null;


   Statement stmt = null;
   try{
     
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql="DROP DATABASE IF EXISTS INFO";
      stmt.executeUpdate(sql);
      sql = "CREATE DATABASE INFO";
      stmt.executeUpdate(sql);
      sql="USE INFO";
      stmt.executeUpdate(sql);
      //sql="CREATE TABLE COUNTRY_INFO";
      //stmt.executeUpdate(sql);
      sql="CREATE TABLE COUNTRY_INFO " +
                   "(LOCid INTEGER not NULL AUTO_INCREMENT, " +
                   " COUNTRY VARCHAR(10), " + 
                   " REGION VARCHAR(10), " + 
                   " CITY VARCHAR(10), " + 
                   " POSTAL_CODE VARCHAR(10), " +
                   " LATITUDE DOUBLE not NULL, " +
                   " LONGITUTE DOUBLE not NULL, " +
              
                   " PRIMARY KEY ( LOCid ))"; 
      stmt.executeUpdate(sql);
      
      sql="Insert into COUNTRY_INFO(LOCid,COUNTRY,REGION,CITY,POSTAL_CODE,LATITUDE,LONGITUTE) values(?,?,?,?,?,?,?)";
      prep_statement = conn.prepareStatement(sql);
       String info[]={"","","","","","","","","",""};
      int count=0;
      try{ 
    br = new BufferedReader(new FileReader("E:\\GeoLiteCity-Location.csv"));
        
    while((line = br.readLine()) != null){
        //  line=line.replaceAll(",,", ",***,");
           String[] b = line.split(cvsSplitBy);
           
           
            int i=1;
            for (String element : b) {
                if (element==null || element.length()==0) {
info[count]="NULL";
count++;
                    //System.out.println("empty element at position " + i);
                }
                else
                {
info[count]=element;  
count++;
//System.out.println(element);
                }
                i++;
                count=0;
                
                prep_statement.setInt(1, 0);  
            prep_statement.setString(2, info[1]); 
            prep_statement.setString(3, info[2]);
            prep_statement.setString(4, info[3]);
            prep_statement.setString(5, info[4]);
            prep_statement.setString(6, info[5]);
            prep_statement.setString(7, info[6]);
            
            
            int rows = prep_statement.executeUpdate();
                
                
            }
    

           // prep_statement.setString(8, info[4]);
            //prep_statement.setString(3, info[4]);
            
    /*while ((line = br.readLine()) != null) {

                // use comma as separator
            String[] country = line.split(cvsSplitBy);

            cs.locid = parseInt(country[0]);
                        cs.country = (country[1]);
                        cs.region=(country[2]);
                                cs.city=(country[3]);
                                        cs.postel_code=(country[4]);
                        cs.lati = parseDouble(country[5]);
                        cs.longi = parseDouble(country[6]);
                        //cs.metro_code=(country[7]);
                       // cs.area_code=(country[8]);
                        
                        
               }*/
    }
      }
         catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
        catch(IOException e){
  e.printStackTrace();
}
    
      
      
      
      
      /*ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         int age = rs.getInt("age");
         String first = rs.getString("first");
         String last = rs.getString("last");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", Age: " + age);
         System.out.print(", First: " + first);
         System.out.println(", Last: " + last);
      }*/
      //STEP 6: Clean-up environment
      //rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
        // TODO code application logic here
    }
    
}
