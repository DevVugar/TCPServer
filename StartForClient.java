/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class StartForClient {

    public static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IP:");
        String ip = sc.nextLine();

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter port:");
        int port = sc2.nextInt();

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter file name you want to send:");
        String fileLocation = sc3.nextLine();

        try {
            Socket socket = new Socket(ip, port);
            OutputStream o = socket.getOutputStream();
            DataOutputStream d = new DataOutputStream(o);
            byte[] bytes = readByte(fileLocation);

            d.writeInt(bytes.length);
            d.write(bytes); 
            socket.close();

            System.out.println("Message was sent");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readByte(String fileName) throws IOException {
        File f = new File(fileName);
        byte[] bytes = new byte[(int) f.length()]; 
        FileInputStream fis = new FileInputStream(f);
        fis.read(bytes);
        return bytes;
    }
}
