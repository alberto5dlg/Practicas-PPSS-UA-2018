/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

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
public class MatriculaTest {
    
    public MatriculaTest() {
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
    
    Matricula mat = new Matricula();
    private int edad;
    private boolean familiaNumerosa;
    private boolean repetidor;
    private float resultadoEsperado, resultadoReal;
    
    @Test
    public void testC1(){
        edad = 19;
        familiaNumerosa = false; 
        repetidor = true;
        resultadoEsperado = 2000.00f;
        
        resultadoReal = mat.calculaTasaMatricula(edad, familiaNumerosa, repetidor);
        assertEquals(resultadoEsperado,resultadoReal,0.00f);
    }
    
    @Test
    public void testC2() {
        edad = 68;
        familiaNumerosa = false;
        repetidor = true;
        resultadoEsperado = 250.00f;
        
        resultadoReal = mat.calculaTasaMatricula(edad, familiaNumerosa, repetidor);
        assertEquals(resultadoEsperado,resultadoReal,0.00f);
    }
    
    @Test
    public void testC3() {
        edad = 19;
        familiaNumerosa = true;
        repetidor = true;
        resultadoEsperado = 250.00f;
        
        resultadoReal = mat.calculaTasaMatricula(edad, familiaNumerosa, repetidor);
        assertEquals(resultadoEsperado,resultadoReal,0.00f);
    }
    
    @Test
    public void testC4() {
        edad = 19;
        familiaNumerosa = false;
        repetidor = false;
        resultadoEsperado = 500.00f;
        
        resultadoReal = mat.calculaTasaMatricula(edad, familiaNumerosa, repetidor);
        assertEquals(resultadoEsperado,resultadoReal,0.00f);
    }
    
    @Test
    public void testC5() {
        edad = 61;
        familiaNumerosa = false;
        repetidor = false;
        resultadoEsperado = 400.00f;
        
        resultadoReal = mat.calculaTasaMatricula(edad, familiaNumerosa, repetidor);
        assertEquals(resultadoEsperado,resultadoReal,0.00f);
    }
 
}
