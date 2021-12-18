package server;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException{
        while (true) {
            ServerSocket serverSocket = new ServerSocket(65500);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.printf("New connection accepted. Port: %d\n", clientSocket.getPort());
            final String name = in.readLine();
            out.println(String.format("Hi, %s, your port is %d", name, clientSocket.getPort()));
            serverSocket.close();
        }
    }
}
