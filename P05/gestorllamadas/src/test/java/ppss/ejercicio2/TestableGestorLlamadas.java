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
public class TestableGestorLlamadas extends GestorLlamadas {
   
    private Calendario cal; 
    
    @Override
    public Calendario getCalendario() {
        return cal;
    }
    
    public void setCalendario (Calendario cal) {
        this.cal = cal;
    }
    
}
