package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 80;
        String word = "???";
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    System.out.println("Подключено");
                    out.println(word);
                    out.flush();
                    String input = in.readLine();
                    if (word.equals("???")) {
                        word = input;
                        out.println("OK");
                        continue;
                    }
                    if (word.toLowerCase().toCharArray()[word.length() - 1] != input.toLowerCase().toCharArray()[0]) {
                        out.println("NotOK");
                        continue;
                    }
                    word = input;
                    out.println("OK");
                }
            }
        } catch (IOException e) {
            System.out.println("Сервер не смог");
            e.printStackTrace();
        }
    }
}