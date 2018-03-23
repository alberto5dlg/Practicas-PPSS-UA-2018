/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL; 

/**
 *
 * @author ppss
 */
public class WebClient {
    
    public String getContent(URL url) {
        StringBuilder content = new StringBuilder();
        
        try {
            HttpURLConnection connection = createHttpURLConnection(url);
            InputStream is = connection.getInputStream();
            
            byte[] buffer = new byte[2048];
            int count; 
            
            while(-1 != (count = is.read(buffer))){
                content.append(new String(buffer, 0, count));
            }
            
        }catch(IOException e) {
            return null; 
        }
        return content.toString();
    }
    
    protected HttpURLConnection createHttpURLConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
    
}
