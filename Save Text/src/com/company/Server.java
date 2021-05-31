package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * The type Server.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Server {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started.\nWaiting for a client ... ");
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client accepted!");
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                StringBuilder msg = new StringBuilder();
                while (true) {
                    String read = dataInputStream.readUTF();
                    System.out.println("RECV: " + read);
                    if (read.equals("over")) {
                        break;
                    }
                    msg.append(read);
                    dataOutputStream.writeUTF(msg.toString());
                    System.out.println("SENT: " + msg);
                }
                System.out.println("All messages sent.\nClosing client ... ");
                dataOutputStream.close();
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("done.\nClosing server ... ");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done.");
    }
}