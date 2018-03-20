/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio2;

import java.util.Random;
import ppss.ejercicio2.excepciones.ClienteWebServiceException;

/**
 *
 * @author ppss
 */
public class Premio {
    
    private static final float PROBABILIDAD_PREMIO = 0.1f;
    
    public Random generador = new Random(System.currentTimeMillis());
    
    public ClienteWebService cliente = new ClienteWebService(); 
    
    public String compruebaPremio() {
        
        if(generaNumero() < PROBABILIDAD_PREMIO){
            try {
                String premio = cliente.obtenerPremio();
                return "Premiado con " + premio;
            } catch (ClienteWebServiceException e) {
                return "No se ha podido obtener el premio"; 
            } 
        } else {
            return "Sin premio"; 
        } 
    }
    
    public float generaNumero() {
        return generador.nextFloat();
    }
    
}
