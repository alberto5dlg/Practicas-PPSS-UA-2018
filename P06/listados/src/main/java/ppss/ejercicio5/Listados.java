/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ppss
 */
public class Listados {
    
    public String porApellidos(Connection con, String tableName) throws SQLException {
        Statement stm = con.createStatement(); 
        
        ResultSet rs = stm.executeQuery("SELECT apellido1, apellido2, nombre FROM " + tableName); 
        String result =""; 
        
        while(rs.next()) {
            String ap1 = rs.getString("apellido1");
            String ap2 = rs.getString("apellido2");
            String nom = rs.getString("nombre");
            
            result += ap1 + ", " + ap2 + ", " + nom  + "\n";
        }
        
        return result; 
    }
    
}
