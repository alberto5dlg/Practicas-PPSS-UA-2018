/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3.testUnitario;

import java.util.ArrayList;
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
    private boolean dbAcceso; 
    ArrayList<String> socios = new ArrayList<>(); 
    ArrayList<String> isbns = new ArrayList<>(); 
    
    @Override 
    public void operacionReserva(String socio, String isbn) throws IsbnInvalidoException, JDBCException, SocioInvalidoException {
        
        if (!dbAcceso)
            throw new JDBCException(); 
        else if(!socios.contains(socio))
            throw new SocioInvalidoException(); 
        else if(!isbns.contains(isbn))
            throw new IsbnInvalidoException(); 
    }
    
    public OperacionStub(boolean dbAcceso, ArrayList<String> socios, ArrayList<String> isbns) {
        this.socios = socios;
        this.dbAcceso = dbAcceso; 
        this.isbns = isbns; 
    }
    
}
