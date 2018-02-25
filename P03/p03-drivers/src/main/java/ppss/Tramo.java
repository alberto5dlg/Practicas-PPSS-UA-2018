/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

/**
 *
 * @author ppss
 */
public class Tramo {
    
    private int longitud, duracion; 
    
    public Tramo(){
        this.longitud = 0; 
        this.duracion = 0; 
    }
    
    public Tramo(int longitud, int duracion) {
        this.longitud = longitud; 
        this.duracion = duracion; 
    }
    
    public int getLongitud() {return longitud;}
    public int getDuracion() {return duracion;}
    
    public void setLongitud(int longitud) {this.longitud = longitud;}
    public void setDuracion(int duracion) {this.duracion = duracion;}   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.longitud;
        hash = 13 * hash + this.duracion;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tramo other = (Tramo) obj;
        if (this.longitud != other.longitud) {
            return false;
        }
        if (this.duracion != other.duracion) {
            return false;
        }
        return true;
    }
   
    
    
}
