/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio2;

/**
 *
 * @author ppss
 */
public class CalendarioStub extends Calendario {
    
    int resultado; 
    
    public void setResultado(int resultado) {
        this.resultado = resultado; 
    }
    
    @Override
    public int getHoraActual() {
        return resultado; 
    }
    
}
