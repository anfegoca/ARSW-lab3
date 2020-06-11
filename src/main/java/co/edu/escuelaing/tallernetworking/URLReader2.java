package co.edu.escuelaing.tallernetworking;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;


public class URLReader2 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese la pagina que desea consultar");
        String pagina = in.readLine();
        try {
            URL google = new URL(pagina);
            PrintWriter out = new PrintWriter(new FileWriter("resultado.html"));
            out.println("Protocol= "+google.getProtocol());
            out.println("Authority= "+google.getAuthority());
            out.println("Host= "+google.getHost());
            out.println("Port= "+google.getPort());
            out.println("Path= "+google.getPath());
            out.println("Query= "+google.getQuery());
            out.println("File= "+google.getFile());
            out.println("Ref= "+google.getRef());
            out.close();

        } catch (MalformedURLException e) {
            System.out.println("La pagina "+pagina+" no es correcta");
            e.printStackTrace();
        }
    }
}
