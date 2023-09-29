package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final Integer LOCALHOST_PORT = 8083;
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(LOCALHOST_PORT)){
            System.out.println("Server started");
            while (true){
                try(Socket clientSocket = serverSocket.accept(); // ждем подключения
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ){
                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                }
            }
        }
    }
}
