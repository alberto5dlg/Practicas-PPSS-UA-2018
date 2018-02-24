/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import java.util.Arrays;
import java.util.Collection;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author ppss
 */
@RunWith(Parameterized.class)
public class TestMatriculaConParametros {
    
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

    @Parameterized.Parameters(name = "C{index}: calculaMatricula(edad: {0},familiaNumerosa: {1},repetidor: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {19, false, true, 2000.00f},
            {68, false, true, 250.00f},
            {19, true, true, 250.00f},
            {19, false, false, 500.00f},
            {61, false, false, 400.00f}
        });
    }
    
    Matricula mat = new Matricula();
    private int edad; 
    private boolean familiaNumerosa, repetidor; 
    private float resultadoEsperado; 
    
    public TestMatriculaConParametros(int edad, boolean familiaNumerosa, boolean repetidor, float resultadoEsperado) {
        this.edad = edad; 
        this.familiaNumerosa = familiaNumerosa; 
        this.repetidor = repetidor; 
        this.resultadoEsperado = resultadoEsperado; 
    }
    
    @Test
    public void testCalculaTasa() {
        assertEquals(resultadoEsperado, mat.calculaTasaMatricula(edad, familiaNumerosa, repetidor), 0.00f);
    }
    
}
