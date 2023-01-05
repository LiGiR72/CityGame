package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws IOException {
        int port = 80;
        String host = "localhost";
        Scanner scanner = new Scanner(System.in);
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println(in.readLine());
            String input = scanner.nextLine();
            out.println(input);
            System.out.println(in.readLine());
        }
    }
}
