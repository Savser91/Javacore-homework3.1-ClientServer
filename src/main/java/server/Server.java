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
            out.printf("Hi! Please, enter your name\n");
            final String name = in.readLine();
            System.out.printf("Client's name: %s\n", name);
            out.printf("Welcome, %s. Are you child? (yes/no)\n", name);
            String answerYesOrNow = in.readLine();
            switch (answerYesOrNow) {
                case "yes":
                    out.printf("Welcome to the kids area, %s! Let's play!\n", name);
                    break;
                case "no":
                    out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!\n", name);
                    break;
                default:
                    break;
            }
            serverSocket.close();
        }
    }
}
