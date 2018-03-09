/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3.testUnitario;

import ppss.ejercicio3.Reserva;
import ppss.ejercicio3.Usuario;

/**
 *
 * @author ppss
 */
public class TestableReserva  extends Reserva {
    
    private boolean reserva; 
    
    @Override
    public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {
        return reserva; 
    }
    
    public void setCompruebaPermisos(boolean permiso) {
        reserva = permiso;
    }
    
    
}
