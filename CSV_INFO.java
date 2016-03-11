/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydb;

/**
 *
 * @author szehra.bscs13seecs
 */
public class CSV_INFO {
    
    
     public int   locid;
 public String country;
 String region;
 String city;
 String postel_code;
    public double lati;
    public double longi;
    String metro_code;
    String area_code;
            
    void CSV_INFO(){
  locid = 0;
 country= "";
 lati= 0;
 longi=0;
    region="";
    city="";
    postel_code="";
    metro_code="";
    area_code="";
    
            
}
}