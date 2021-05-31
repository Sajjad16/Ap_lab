package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * The type Handler.
 */
public class Handler implements Runnable {

    private Socket socket;
    private int clientNumber;

    /**
     * Instantiates a new Handler.
     *
     * @param socket       the socket.
     * @param clientNumber the client number.
     */
    public Handler(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber;
    }

    @Override
    public void run() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())) {
            StringBuilder msg = new StringBuilder();
            while (true) {
                String read = dataInputStream.readUTF();
                System.out.println("RECV from " + clientNumber + ": " + read);
                if (read.equals("over")) {
                    break;
                }
                msg.append(read);
                dataOutputStream.writeUTF(msg.toString());
                System.out.println("SENT from " + clientNumber + ": " + msg);
            }
            System.out.println("All messages sent.\nClosing client " + clientNumber + "... ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
