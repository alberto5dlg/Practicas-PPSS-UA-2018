package ppss;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataArrayTest {
    
    //DataArray resultadoEsperado;
    //DataArray resultadoReal = new DataArray(); 
    int numero, resultadoEsperado, resultadoReal;
    DataArray arrayPrueba;
    
    @Test
    public void testAddC1() 
    {
        arrayPrueba = new DataArray();
        numero = 2; 
        resultadoEsperado = 1;
        arrayPrueba.add(numero); 
        resultadoReal = arrayPrueba.size(); 
        assertEquals(arrayPrueba.getColeccion()[0], numero);
        assertEquals(resultadoEsperado,resultadoReal); 
    }
    
    @Test
    public void testAddC2() 
    {
        int[] coleccion = {2,3};
        arrayPrueba = new DataArray(coleccion, 2);
        numero = 5; 
        resultadoEsperado = 3;
        arrayPrueba.add(numero); 
        resultadoReal = arrayPrueba.size(); 
        assertEquals(resultadoEsperado,resultadoReal); 
    }
    
    @Test
    public void testAddC3() 
    {
        int[] coleccion = {2,3,4,5,6,7,8,9,21,34};
        arrayPrueba = new DataArray(coleccion, 10);
        numero = 23; 
        resultadoEsperado = 10;
        arrayPrueba.add(numero); 
        resultadoReal = arrayPrueba.size(); 
        assertEquals(resultadoEsperado,resultadoReal); 
    }
    
    
     /*@Test
    public void testAddC1() 
    {
        numero = 2; 
        int[] coleccion = {2};
        resultadoEsperado = new DataArray(coleccion,1);
        resultadoReal.add(numero);
        
        assertEquals(resultadoEsperado,resultadoReal); 
    }*/
    
}
