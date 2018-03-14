/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;

/**
 *
 * @author ppss
 */
public class GestorLlamadas {
    
    static double TARIFA_NOCTURNA = 10.5;
    static double TARIFA_DIURNA = 20.8;
    
    public Calendario getCalendario() {
        Calendario c = new Calendario(); 
        return c;
    }

    public double calculaConsumo(int minutos){
        Calendario c = getCalendario();
        int hora = c.getHoraActual();
        
        if(hora < 8 || hora > 20) 
            return minutos * TARIFA_NOCTURNA;
        else 
            return minutos * TARIFA_DIURNA;            
    }
    
}
