/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;
import org.easymock.MockType;

/**
 *
 * @author ppss
 */
public class GestorLlamadasMockTest {
    
    public GestorLlamadasMockTest() {
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

   private GestorLlamadas gestor ; 
   
   @Test
   public void testC1() {
       double resultadoEsperado = 457.6f;
       
       Calendario mock = EasyMock.createMock(Calendario.class);
       EasyMock.expect(mock.getHoraActual()).andReturn(10);
       EasyMock.replay(mock);
       
       gestor = partialMockBuilder(GestorLlamadas.class).addMockedMethods("getCalendario").createMock();
       expect(gestor.getCalendario()).andReturn(mock);
       replay(gestor);
       
       assertEquals(gestor.calculaConsumo(22), resultadoEsperado, 0.01f);
       EasyMock.verify(mock);
       verify(gestor);   
   }
   
    
   @Test
   public void testC2() {
       double resultadoEsperado = 136.5f;
       
       Calendario mock = EasyMock.createMock(Calendario.class);
       EasyMock.expect(mock.getHoraActual()).andReturn(21);
       EasyMock.replay(mock);
       
       gestor = partialMockBuilder(GestorLlamadas.class).addMockedMethods("getCalendario").createMock();
       expect(gestor.getCalendario()).andReturn(mock);
       replay(gestor);
       
       assertEquals(gestor.calculaConsumo(13), resultadoEsperado, 0.01f);
       EasyMock.verify(mock);
       verify(gestor);   
   }
    
}
