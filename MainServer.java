/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainServer {
    public static void main(String[] args) {
        try {
            openServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openServer() throws IOException {
        final int PORT = 6789;
        ServerSocket ourFirstServerSocket = new ServerSocket(PORT);

        while (true) {
            System.out.println("Waiting for a new socket connection...");
            Socket connection = ourFirstServerSocket.accept();
            System.out.println("New client connected.");

            DataInputStream dataStream = new DataInputStream(connection.getInputStream());
            System.out.println("Client sent a message.");

            byte[] array = readMessage(dataStream);
            writeBytes(array, "C:\\-----Workspace-----\\elave2\\new_p.jpg");
            System.out.println("File saved successfully.");
        }
    }

    public static byte[] readMessage(DataInputStream din) throws IOException {
        int msgLen = din.readInt();
        byte[] msg = new byte[msgLen];
        din.readFully(msg);
        return msg;
    }

    public static void writeBytes(byte[] data, String filename) throws IOException {
        Path filePath = Paths.get(filename);
        Files.write(filePath, data);
    }
}
