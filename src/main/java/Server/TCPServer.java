package Server;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

import Util.FileUtility;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.SneakyThrows;

/**
 *
 * @author user
 */
public class TCPServer {

    public static void main(String[] args) throws Exception {
        readAsByte();
    }

    @SneakyThrows
    public static void readAsByte() {
        ServerSocket ourFirstServerSocket = new ServerSocket(6789);
        while (true) {
            System.out.println("Yeni socket ucun gozlenilir");
            Socket connection = ourFirstServerSocket.accept();
            System.out.println("Yeni musteri geldi");

            DataInputStream dataStream = new DataInputStream(connection.getInputStream());

            System.out.println("Musteri mesaj gonderdi");
            byte[] array = readMessage(dataStream);

            FileUtility.writeBytes(array, "C:\\-----Workspace-----\\elave\\TCPServerr.rar");
            //FileUtility.writeBytes(array,"C:\\-----Workspace-----\\elave\\dragonn.png");
            System.out.println("************************************");
        }
    }

    @SneakyThrows
    public static byte[] readMessage(DataInputStream din) {
        int msgLen = din.readInt();
        byte[] msg = new byte[msgLen];
        din.readFully(msg);
        return msg;

    }

    //*******************************************************************************************************
    //*******************************************************************************************************
    
    
    
    
    
    //Connection with browser
    
    @SneakyThrows
    public static void readAsByte2() {

        System.out.println("Yeni socket ucun gozlenilir");
        ServerSocket ourFirstServerSocket = new ServerSocket(6789);
        while (true) {

            Socket connection = ourFirstServerSocket.accept();

            DataInputStream dataStream = new DataInputStream(connection.getInputStream());

            String result = readReguest(dataStream);
            System.out.println(result);

            OutputStream outPutSream = connection.getOutputStream();
            DataOutputStream dataoutputSteam = new DataOutputStream(outPutSream);

            writeResponse(dataoutputSteam, "I am working");

            connection.close();

        }
    }

    @SneakyThrows
    public static void writeResponse(OutputStream out, String s) {
        String response = "HTTP/1.1 200 OK\r\n"
                + "Server: YarServer/2009-09-09\r\n"
                + "Content-Type: text/html/r/n"
                + "Content-Lenght: " + s.length() + "\r\n"
                + "Connection: close\r\n\r\n";

        String result = response + s;
        out.write(result.getBytes());
        out.flush();
    }

    private static String readReguest(InputStream sin) throws IOException {
        InputStreamReader isr = new InputStreamReader(sin);
        BufferedReader reader = new BufferedReader(isr);
        String msg = "";
        while (true) {
            String s = reader.readLine();
            if (s == null || s.trim().length() == 0) {
                break;
            } else {
                msg = msg + s + "\r\n";
            }
        }
        return msg;
    }
    
    
    

    //*******************************************************************************************************
    //*******************************************************************************************************
    
    
    
    
    
    
    
    
    @SneakyThrows
    public static void readAsString() {
        ServerSocket ourFirstServerSocket = new ServerSocket(6789);
        while (true) {
            System.out.println("Yeni socket ucun gozlenilir");
            Socket connection = ourFirstServerSocket.accept();
            System.out.println("Yeni musteri geldi");

            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bufferReader = new BufferedReader(reader);

            String messageFromClient = bufferReader.readLine();
            System.out.println("Musteriden gelen mesaj: " + messageFromClient);

        }
    }

}
