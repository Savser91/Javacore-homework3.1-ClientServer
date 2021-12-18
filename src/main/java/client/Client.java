package client;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 65500;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Host: " + host);
            String resp = in.readLine();
            System.out.println(resp);
        }
    }
}
