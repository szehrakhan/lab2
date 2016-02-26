/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nserver;

/**
 *
 * @author szehra.bscs13seecs
 */
public class data {
    
    
    String name;
    int index; 
   data next;
    String arr[];
    public data(String user_name,String msg){
        
       index=1;
        name=user_name;
arr[0]=msg;
        next=null;
}
    
    
    
}
