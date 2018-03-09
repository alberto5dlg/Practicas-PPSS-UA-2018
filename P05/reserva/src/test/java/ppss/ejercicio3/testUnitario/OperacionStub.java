/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3.testUnitario;

import java.util.logging.Level;
import java.util.logging.Logger;
import ppss.ejercicio3.IOperacionBO;
import ppss.ejercicio3.excepciones.IsbnInvalidoException;
import ppss.ejercicio3.excepciones.JDBCException;
import ppss.ejercicio3.excepciones.SocioInvalidoException;

/**
 *
 * @author ppss
 */
public class OperacionStub implements IOperacionBO {
    private Exception excepcion; 
    
    @Override 
    public void operacionReserva(String socio, String isbn) throws IsbnInvalidoException, JDBCException, JDBCException, SocioInvalidoException {
        try { 
            throw excepcion;
        } catch (Exception ex) {
            Logger.getLogger(OperacionStub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public OperacionStub(Exception r) {this.excepcion = r;}
    
}
