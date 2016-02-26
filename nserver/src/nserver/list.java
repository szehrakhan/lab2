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
public class list {
    
     String arr[];
     
     data head=null;
     
     
      private data getLastNode() {
        if (head == null) {
            return null;
        }
        data tmpNode = head;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
        }
        return tmpNode;
    }
     
     
     
     void enter_note(String n,String msg){
    
         if(head == null){
           head = new data(n,msg);
           return;
        }
        data tmpNode = head;
        while (tmpNode != null) {
            if (tmpNode.name==n){
                arr[tmpNode.index]=msg;
            tmpNode.index++;
            return;
            }
            tmpNode = tmpNode.next;
        }
         
         
      data lastNode = getLastNode();
        if (lastNode == null) {
            head = new data(n,msg);
        } else {
            lastNode.next = new data(n,msg);
           }
        
        
        
         
    //c
    //index++;
    
  }
    
    
     
     }
     
     

