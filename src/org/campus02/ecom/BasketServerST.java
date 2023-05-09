package org.campus02.ecom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BasketServerST {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(1234)){


            while (true) {
                System.out.println("waiting for clients");
                Socket client = serverSocket.accept();
                EcommerceLogic ecommerceLogic = new EcommerceLogic(client);

                new Thread(ecommerceLogic).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
