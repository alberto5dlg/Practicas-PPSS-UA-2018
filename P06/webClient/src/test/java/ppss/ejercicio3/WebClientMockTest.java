/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.partialMockBuilder;
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
public class WebClientMockTest {
    
    public WebClientMockTest() {
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

    
    private WebClient webCliMock;
    private HttpURLConnection conectMock;
    private String resultadoEsperado, resultadoReal; 
    
    @Test
    public void TestC1() throws MalformedURLException, IOException {
        URL url = new URL("http://www.google.es");
        resultadoEsperado = "Se puede abrir la conexion";
        
        webCliMock = partialMockBuilder(WebClient.class).addMockedMethods("createHttpURLConnection").createMock();
        conectMock = EasyMock.createMock(HttpURLConnection.class);
        InputStream is = new ByteArrayInputStream("Se puede abrir la conexion".getBytes());
        
        EasyMock.expect(conectMock.getInputStream()).andReturn(is);
        EasyMock.expect(webCliMock.createHttpURLConnection(url)).andReturn(conectMock);
        
        EasyMock.replay(webCliMock);
        EasyMock.replay(conectMock);
        
        resultadoReal = webCliMock.getContent(url);
       
        assertEquals(resultadoEsperado,resultadoReal);
        EasyMock.verify(webCliMock);
        EasyMock.verify(conectMock);
    }
    
     @Test
    public void TestC2() throws MalformedURLException, IOException {
        URL url = new URL("http://www.google.es");
        
        webCliMock = partialMockBuilder(WebClient.class).addMockedMethods("createHttpURLConnection").createMock();
        conectMock = EasyMock.createMock(HttpURLConnection.class);
        //InputStream is = null;
        
        EasyMock.expect(conectMock.getInputStream()).andThrow(new IOException());
        EasyMock.expect(webCliMock.createHttpURLConnection(url)).andReturn(conectMock);
        
        EasyMock.replay(webCliMock);
        EasyMock.replay(conectMock);
        
        resultadoReal = webCliMock.getContent(url);
       
        assertEquals(null,resultadoReal);
        EasyMock.verify(webCliMock);
        EasyMock.verify(conectMock);
    }
    
}
