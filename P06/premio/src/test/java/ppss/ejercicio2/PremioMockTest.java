/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio2;

import org.easymock.EasyMock;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.partialMockBuilder;
import static org.easymock.EasyMock.replay;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.easymock.MockType;
import ppss.ejercicio2.excepciones.ClienteWebServiceException;

/**
 *
 * @author ppss
 */
public class PremioMockTest {
    
    public PremioMockTest() {
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
    public void TestC1() throws ClienteWebServiceException{
        Premio testObject = new Premio(); 
        String resultEsperado = "Premiado con entrada final Champions";

        ClienteWebService mock = EasyMock.createMock(ClienteWebService.class); 
        EasyMock.expect(mock.obtenerPremio()).andReturn("entrada final Champions");
        EasyMock.replay(mock);
        
        testObject = partialMockBuilder(Premio.class).addMockedMethods("generaNumero").createMock();
        EasyMock.expect(testObject.generaNumero()).andReturn(0.07f);
        EasyMock.replay(testObject);
        testObject.cliente = mock; 
        
        assertEquals(resultEsperado, testObject.compruebaPremio());
        
        EasyMock.verify(testObject);
        EasyMock.verify(mock);
    }
    
    @Test
    public void TestC2() throws ClienteWebServiceException{
        Premio testObject = new Premio(); 
        String resultEsperado = "No se ha podido obtener el premio";

        ClienteWebService mock = EasyMock.createMock(ClienteWebService.class); 
        EasyMock.expect(mock.obtenerPremio()).andThrow(new ClienteWebServiceException());
        EasyMock.replay(mock);
        
        testObject = partialMockBuilder(Premio.class).addMockedMethods("generaNumero").createMock();
        EasyMock.expect(testObject.generaNumero()).andReturn(0.03f);
        EasyMock.replay(testObject);
        testObject.cliente = mock; 
        
        assertEquals(resultEsperado, testObject.compruebaPremio());
        
        EasyMock.verify(testObject);
        EasyMock.verify(mock);
    }
    
}
