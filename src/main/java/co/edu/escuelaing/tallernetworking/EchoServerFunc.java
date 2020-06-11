package co.edu.escuelaing.tallernetworking;

import java.net.*;
import java.io.*;

public class EchoServerFunc {

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
        String inputLine, outputLine="No valida";
        String oper = "fun:cos";
        while ((inputLine = in.readLine()) != null) {
            if ("Bye".equals(inputLine)) {
                break;
            }
            System.out.println(
                    "operación: " + inputLine
            );
            try {
                Double num = Double.parseDouble(inputLine);
                switch (oper) {
                    case "fun:sin":
                        outputLine = "Respuesta " + Math.sin(num);
                        break;
                    case "fun:cos":
                        outputLine = "Respuesta " + Math.cos(num);
                        break;
                    case "fun:tan":
                        outputLine = "Respuesta " + Math.tan(num);
                        break;
                }
            } catch (NumberFormatException nfe) {
                oper=inputLine;
                outputLine = "Cambio a "+oper;
            }

            out.println(outputLine);

        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
