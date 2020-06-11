package co.edu.escuelaing.tallernetworking;

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
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            while (true) {
                clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                String inputLine, outputLine;
                String[] recurso = null;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.contains("GET")) {
                        recurso = inputLine.split(" ");
                        
                        break;
                    }

                }
                Reader r = new Reader();
                recurso[1] = recurso[1].substring(1);
                BufferedReader br = r.read(recurso[1]);
                if (br != null) {
                    if (recurso[1].contains("html")) {
                        String archivo = r.toHtml(br);
                        outputLine = "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: text/html\r\n"
                                + "\r\n"
                                + "<!DOCTYPE html>" + archivo;
                    } else if (recurso[1].contains("jpg") || recurso[1].contains("jpeg") || recurso[1].contains("png")) {
                        String imagen = r.readImagen(recurso[1]);
                        
                        outputLine = "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: text/html\r\n"
                                + "\r\n"
                                + "<!DOCTYPE html>"
                                + "<html>"
                                + "<head>"
                                + "<meta charset=\"UTF-8\">"
                                + "<title>Imagen</title>\n" + "</head>"
                                + "<body>"
                                + "<img src="+"data:image/jpeg;base64,"+imagen+">"
                                + "</body>"
                                + "</html>";
                    } else {
                        String archivo = r.toHtml(br);
                        outputLine = "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: text/html\r\n"
                                + "\r\n"
                                + "<!DOCTYPE html>"
                                + "<html>"
                                + "<head>"
                                + "<meta charset=\"UTF-8\">"
                                + "<title>archivo</title>\n" + "</head>"
                                + "<body>"
                                + archivo
                                + "</body>"
                                + "</html>";
                    }

                } else {
                    outputLine = ("No encontrado");
                }
                out.println(outputLine);
                out.close();
                in.close();
            }

        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
    }
}
