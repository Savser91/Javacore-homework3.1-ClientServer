package client;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 65500;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String resp = in.readLine();
            System.out.println(resp);
            out.println("Host: " + host);
            resp = in.readLine();
            System.out.println(resp);
            String[] strings = new String[] {"yes", "no"};
            Random random = new Random();
            out.println(strings[random.nextInt(2)]);
            resp = in.readLine();
            System.out.println(resp);
        }
    }
}
