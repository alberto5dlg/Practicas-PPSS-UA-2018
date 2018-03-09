/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

import ppss.ejercicio3.excepciones.IsbnInvalidoException;
import ppss.ejercicio3.excepciones.JDBCException;
import ppss.ejercicio3.excepciones.SocioInvalidoException;

/**
 *
 * @author ppss
 */
public interface IOperacionBO {
    
    public void operacionReserva(String socio, String isbn) throws IsbnInvalidoException, JDBCException, SocioInvalidoException; 
    
}
