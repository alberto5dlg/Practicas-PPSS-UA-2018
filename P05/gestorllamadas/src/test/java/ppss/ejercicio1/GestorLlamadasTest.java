/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;

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
public class GestorLlamadasTest {
    
    public GestorLlamadasTest() {
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

   
    @Test
    public void TestcalculaConsumoC1() {
    
        double resultadoEsperado = 208.00f;
        TestableGestorLlamadas sut = new TestableGestorLlamadas();
        sut.setHora(15);
         
        double resultadoReal = sut.calculaConsumo(10);   
        assertEquals(resultadoEsperado, resultadoReal,0.02f);
    }
    
    @Test
    public void TestCalculaConsumoC2() {
        double resultadoEsperado = 105.00f;
        TestableGestorLlamadas sut = new TestableGestorLlamadas();
        sut.setHora(22);
        
        double resultadoReal = sut.calculaConsumo(10);
        assertEquals(resultadoEsperado,resultadoReal,0.02f);
    }
    
}
