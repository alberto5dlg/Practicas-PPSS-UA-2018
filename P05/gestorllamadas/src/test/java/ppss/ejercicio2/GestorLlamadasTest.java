/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio2;

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
    public void TestC1() throws UnsopportedOperationException {
        //Preparamos los datos de prueba 
        TestableGestorLlamadas sut = new TestableGestorLlamadas(); 
        CalendarioStub serviceStub = new CalendarioStub(); 
        serviceStub.setResultado(15);
        sut.setCalendario(serviceStub);
        
        double resultadoEsperado = 208.00f;
        double resultadoReal = sut.calculaConsumo(10);
        assertEquals(resultadoEsperado,resultadoReal,0.02f); 
    }
    
    @Test
    public void TestC2() throws UnsopportedOperationException {
        //Preparamos los datos de prueba 
        TestableGestorLlamadas sut = new TestableGestorLlamadas(); 
        CalendarioStub serviceStub = new CalendarioStub(); 
        serviceStub.setResultado(22);
        sut.setCalendario(serviceStub);
        
        double resultadoEsperado = 105.00f;
        double resultadoReal = sut.calculaConsumo(10);
        assertEquals(resultadoEsperado,resultadoReal,0.02f);
    }
    
}
