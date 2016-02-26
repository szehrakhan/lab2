/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notes;
 import java.net.*;
import java.io.*;
/**
 *
 * @author szehra.bscs13seecs
 */
public class Notes {

    /**
     * @param args the command line arguments
     */
   


   public static void main(String [] args)
   {
      String serverName ="localhost";
      //int port = Integer.parseInt(args[1]);
      int port=1500;
      try
      {
        
          
          c_data obj=new c_data("saman","helo i am going mad");
          
         Socket client = new Socket(serverName, port);
         System.out.println("Just connected to " 
		 + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         ObjectOutputStream ooStream = new ObjectOutputStream(outToServer);
                ooStream.writeObject(obj); 
          ooStream.close();
         //DataOutputStream out = new DataOutputStream(outToServer);
         //out.writeUTF("Hello from "
           //           + client.getLocalSocketAddress());
         /*InputStream inFromServer = client.getInputStream();
         DataInputStream in =
                        new DataInputStream(inFromServer);
         System.out.println("Server says " + in.readUTF());*/
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
    

