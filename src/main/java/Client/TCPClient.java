package Client;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Util.FileUtility;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import lombok.SneakyThrows;

/**
 *
 * @author user
 */
public class TCPClient {
    @SneakyThrows
    public static void main(String[] args)  {
          
          Socket socket =new Socket("192.168.1.105", 6789);
          OutputStream outputStream =socket.getOutputStream();
          DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        
         // byte [] bytes =FileUtility.readBytes("C:\\Users\\user\\OneDrive\\Documents\\NetBeansProjects\\Server.rar");
        byte [] bytes =FileUtility.readBytes("C:\\Users\\user\\Downloads\\dragon.png");
          dataOutputStream.writeInt(bytes.length);
          dataOutputStream.write(bytes);
          socket.close();  
          
          
          
    }
   

}