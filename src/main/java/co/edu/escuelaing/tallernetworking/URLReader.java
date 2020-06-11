package co.edu.escuelaing.tallernetworking;

import java.net.*;

public class URLReader {

    public static void main(String[] args) throws Exception {

        try {
            URL google = new URL("http://www.google.com:80/index.html?name=juan&?color=red/#hola");
            
            System.out.println("Protocol= "+google.getProtocol());
            System.out.println("Authority= "+google.getAuthority());
            System.out.println("Host= "+google.getHost());
            System.out.println("Port= "+google.getPort());
            System.out.println("Path= "+google.getPath());
            System.out.println("Query= "+google.getQuery());
            System.out.println("File= "+google.getFile());
            System.out.println("Ref= "+google.getRef());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
