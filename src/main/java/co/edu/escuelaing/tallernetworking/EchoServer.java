package co.edu.escuelaing.tallernetworking;

import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Esperando conexión");
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {

            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        System.out.println("Conectado");
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            if ("Bye".equals(inputLine)) {
                break;
            }

            System.out.println(
                    "Cuadrado: " + inputLine
            );
            try {
                Double num = Double.parseDouble(inputLine);
                outputLine = "Respuesta " + Math.pow(num, 2);
            } catch (NumberFormatException nfe) {
                outputLine = "Debe ingresar numeros";
            }

            out.println(outputLine);

        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
