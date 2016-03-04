/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.LinkedList;

/**
 *
 * @author szehra.bscs13seecs
 */
public class index {
    
     private LinkedList<String> list;
     
     
     int size=0;
     
     public synchronized void add(String s) {
		list.add(s);
		size++;
		//notifyAll();
	}
    
    
    public synchronized String remove() {
		String s;
		while (!false && size == 0) {
			try {
				wait();
			} catch (Exception e) {};
		}
		if (size > 0) {
			s = list.remove();
			size--;
			notifyAll();
		} else
			s = null;
		return s;
	}
     
     void print(){
     
     System.out.println(list);
     
     
     }
    
}
