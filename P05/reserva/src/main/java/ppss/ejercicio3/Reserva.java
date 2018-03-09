/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;


import ppss.ejercicio3.excepciones.IsbnInvalidoException;
import ppss.ejercicio3.excepciones.JDBCException;
import ppss.ejercicio3.excepciones.ReservaException;
import ppss.ejercicio3.excepciones.SocioInvalidoException;

import java.util.ArrayList;

public class Reserva {
    
  public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {
     throw new UnsupportedOperationException("Not yet implemented");
  }
  
    public void realizaReserva(String login, String password, String socio, String [] isbns) throws Exception {
        ArrayList<String> errores = new ArrayList<>();
        if(!compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)) {
            errores.add("ERROR de permisos");
        }
        else {
            
            //IOperacionBO io = new Operacion();
            //Refactorizamos la linea anterior comentada por esta con la factoria creada 
            IOperacionBO io = OperationBOFactory.create(); 
            try {
                for(String isbn: isbns) {
                try {
                    io.operacionReserva(socio, isbn);
                } 
                catch (IsbnInvalidoException iie) {
                    errores.add("ISBN invalido" + ":" +  isbn);
                }
             }
          } 
          catch (SocioInvalidoException sie) {
            errores.add("SOCIO invalido");
          } 
          catch (JDBCException je) {
            errores.add("CONEXION invalida");
          } 
        }

        if (errores.size() > 0) {
            String mensajeError = "";
            for(String error: errores) {
                mensajeError += error + "; ";
            }
            throw new ReservaException(mensajeError);
        }
    } 
}