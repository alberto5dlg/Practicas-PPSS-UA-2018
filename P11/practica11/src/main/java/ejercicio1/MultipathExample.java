package ejercicio1;


public class MultipathExample {
    
    public int multiPath (int a, int b, int c) {
        
        if(a>5)
            c += a;
        
        if(b>5)
            c += b;
        
        return c; 
    }
}

//La complejidad ciclomatica del metodo multiPAth es 3 (Arcos = 6, nodos = 5) 
//CC = 6 -5 + 2 = 3