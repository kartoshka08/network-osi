package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client {
    public static final Integer LOCALHOST_PORT = 8083;
    public static void main(String[] args) throws IOException{
        String localhost = "netology.ru";
        int port = LOCALHOST_PORT;
        try (Socket clientSocket = new Socket(localhost, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println("GET / HTTP/1.1\n" +
                    "Host: netology.ru\n\n\n");
            String resp = in.readLine();
            System.out.println(resp);
        }
        InetAddress inetAddress = InetAddress.getByName(localhost);
        System.out.println(localhost + ", ip address: " + inetAddress.getHostAddress());
    }

}
