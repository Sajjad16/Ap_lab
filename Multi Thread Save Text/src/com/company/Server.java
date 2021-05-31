package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * The type Server.
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
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            int counter = 1;
            System.out.println("Server started.\nWaiting for a client ... ");
            while (true) {
                try {
                    executorService.execute(new Handler(serverSocket.accept(), counter));
                    System.out.println("client" + counter + " accepted!");
                    counter++;
                    if (counter > 3) {
                        executorService.shutdown();
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("done.\nClosing server ... ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done.");
    }
}