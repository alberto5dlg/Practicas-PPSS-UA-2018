/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;

import java.util.Calendar;

/**
 *
 * @author ppss
 */
public class TestableGestorLlamadas extends GestorLlamadas {
    
    private int resultado; 
    
    @Override
    public int getHoraActual() {return this.resultado;}
    
    public void setHora (int resultado) {this.resultado = resultado;}
    
}
