package com.cibertec;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    private static final int PORT = 13;

    public Server(){  //Server es alguien que escucha algun tipo de comunicacion 
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("1 >> Server started on port " + PORT);

            while (true) { //Esto es para hacer un bucle infinito para que puede 
                System.out.println("2 >> Waiting for client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("3 >> New client connected: " + clientSocket.getInetAddress().getHostAddress());

                System.out.println(" 4 >> Client Complete");

                clientSocket.close();
                System.out.println("5 >>  Client disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Creamos esto para ejecutarlo    //Tener en cuenta que primero se ejecuta el server
    public static void main(String[] args) {
        new Server();
    }

}