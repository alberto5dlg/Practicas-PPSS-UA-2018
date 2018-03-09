/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

/**
 *
 * @author ppss
 */
public class OperationBOFactory {
    
    private static IOperacionBO servicio = null; 
    
    public static  IOperacionBO create() {
        if(servicio != null)
            return servicio; 
        else 
            return new Operacion(); 
    }
    
    public static void setServicio (IOperacionBO opr) {
        servicio = opr; 
    }
    
}
