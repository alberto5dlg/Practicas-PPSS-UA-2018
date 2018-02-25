/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ppss
 */
public class TestDatosSinParametros {
    
    public TestDatosSinParametros() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    private Datos datos = new Datos(); 
    private ArrayList<Integer> listaLectura = new ArrayList<Integer>();
    private Tramo resultadoEsperado;
    private Tramo resultadoReal; 
    
    @Test
    public void TestC1A() {
        listaLectura = new ArrayList<>(Arrays.asList(3));
        resultadoEsperado = new Tramo(0,0);
        
        resultadoReal = datos.buscarTramoLlanoMasLargo(listaLectura);
        assertTrue(resultadoEsperado.equals(resultadoReal)); 
    }
    
    @Test
    public void TestC2A() {
        listaLectura = new ArrayList<>(Arrays.asList(100,100,100,100));
        resultadoEsperado = new Tramo(0,3);
        
        resultadoReal = datos.buscarTramoLlanoMasLargo(listaLectura);
        assertTrue(resultadoEsperado.equals(resultadoReal)); 
    }
    
    @Test
    public void TestC3A() {
        listaLectura = new ArrayList<>(Arrays.asList(120,140,180,180,180));
        resultadoEsperado = new Tramo(2,2);
        
        resultadoReal = datos.buscarTramoLlanoMasLargo(listaLectura);
        assertTrue(resultadoEsperado.equals(resultadoReal)); 
    }
    
    @Test
    public void TestC1B() {
        listaLectura = new ArrayList<>(Arrays.asList(-1));
        resultadoEsperado = new Tramo(0,0);
        
        resultadoReal = datos.buscarTramoLlanoMasLargo(listaLectura);
        assertTrue(resultadoEsperado.equals(resultadoReal)); 
    }
    
    @Test
    public void TestC2B() {
        listaLectura = new ArrayList<>(Arrays.asList(-1,-1,-1,-1));
        resultadoEsperado = new Tramo(0,3);
        
        resultadoReal = datos.buscarTramoLlanoMasLargo(listaLectura);
        assertTrue(resultadoEsperado.equals(resultadoReal)); 
    }
    
    @Test
    public void TestC3B() {
        listaLectura = new ArrayList<>(Arrays.asList(120,140,-10,-10,-10));
        resultadoEsperado = new Tramo(2,2);
        
        resultadoReal = datos.buscarTramoLlanoMasLargo(listaLectura);
        assertTrue(resultadoEsperado.equals(resultadoReal)); 
    }
}
