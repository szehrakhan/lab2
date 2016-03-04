/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author szehra.bscs13seecs
 */
public class Lab4 {

    static Map<String, String> m1 = new HashMap<String, String>();
	static Map<String, String> m2 = new HashMap<String, String>();
        index list;
	static int i = 0;
        
        Lab4(){
		list = new index();
	

        
        }
        
         public void findFile() {
             String search = "saman.txt";
			String name="a";
			while ((name = list.remove()) != null) {
				File file = new File(name);
				String entries[] = file.list();
				if (entries == null)
					continue;
				for (String entry : entries) {
					if (entry.compareTo(".") == 0)
						continue;
					if (entry.compareTo("..") == 0)
						continue;
					search = search.toLowerCase();
					String temp = entry.toLowerCase();
					if (temp.compareTo(search) == 0){
						System.out.println("Found");
						String fn = name + "\\" + entry;
						System.out.println(fn);
					}
						
					//String fn = name + "\\" + entry;
					//System.out.println(fn);

				}
			}
		}
	
         
        
        
        
        
        public void processDirectory(String dir) {
		try{
			File file = new File(dir);
			if (file.isDirectory()) {
				String entries[] = file.list();
				if (entries == null)
					list.add(dir);

				for (String entry : entries) {
					String subdir;
					if (entry.compareTo(".") == 0)
						continue;
					if (entry.compareTo("..") == 0)
						continue;
					if (dir.endsWith("\\"))
						subdir = dir+entry;
					else
						subdir = dir+"\\"+entry;
					processDirectory(subdir);
				}
			}}catch(Exception e){}
	}
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Lab4  fc = new Lab4();

//System.out.println("Enter the directory name");
		String Directory_Name;
		//Directory_Name = in.nextLine();
		//  now place each directory into the list
		//System.out.println(Directory_Name);
		System.out.println("Enter the directory name1");
                fc.processDirectory("D://"); 
                System.out.println("Enter the directory name2");
                fc.list.print();
fc.findFile();
System.out.println("Enter the directory name3");


// TODO code application logic here
    }
    
}
