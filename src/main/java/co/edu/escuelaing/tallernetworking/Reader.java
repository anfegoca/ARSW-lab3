package co.edu.escuelaing.tallernetworking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 * Esta clase lee un archivo dado su url
 * @author Andres Gonzalez
 */
public class Reader {
    
    /**
     * Lee el archivo y retorna el BufferedReader correspondiente
     * @param url dirección del archivo
     * @return  BufferedReader del archivo
     */
    public BufferedReader read(String url){
        BufferedReader br;
        try {
            File file = new File (url);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            
        } catch (FileNotFoundException ex) {
            br=null;
        }
        return br;
    }
    public String toHtml(BufferedReader br){
        String res="";
        try {
            String line;
            
            while((line=br.readLine())!=null){
                res=res.concat(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public String readImagen(String url){
        try {
            byte[] fileContent = FileUtils.readFileToByteArray(new File(url));
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            return encodedString;
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}