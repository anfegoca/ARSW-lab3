package co.edu.escuelaing.tallernetworking;

import co.edu.escuelaing.tallernetworking.model.Interprete;
import java.net.*;
import java.io.*;

public class HttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        
        try {
            System.out.println("Listo para recibir ...");
            while (true) {
                Socket clientSocket;
                clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                String recurso;
                while ((inputLine = in.readLine()) != null) {
                    
                    if (inputLine.contains("GET")) {
                        recurso = inputLine.split(" ")[1];
                        recurso = recurso.substring(1);
                        System.out.println(recurso);
                        Interprete.getInstance().recursoToString(recurso, clientSocket);
                    }
                    if(!in.ready()){
                         break;
                    }
                }
                in.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
    }
}
