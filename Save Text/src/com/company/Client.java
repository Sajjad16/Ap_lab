package com.company;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * The type Client.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Client {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("Connected to server.");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Write your message:");
                String msg = scanner.nextLine();
                dataOutputStream.writeUTF(msg);
                System.out.println("SENT: " + msg);
                if (msg.equals("over")) {
                    break;
                }
                String read = dataInputStream.readUTF();
                System.out.println("RECV: " + read);
            }
            System.out.println("All messages sent.\nClosing ... ");
            dataInputStream.close();
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        System.out.println("done.");
    }

}