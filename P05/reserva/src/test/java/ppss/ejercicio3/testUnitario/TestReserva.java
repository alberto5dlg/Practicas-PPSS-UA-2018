/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3.testUnitario;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ppss.ejercicio3.OperationBOFactory;

/**
 *
 * @author ppss
 */
public class TestReserva {
    
    public TestReserva() {
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

    private ArrayList<String> socios = new ArrayList<>(Arrays.asList("Luis")); 
    private ArrayList<String> isbns = new ArrayList<>(Arrays.asList("11111","22222")); 
    private String resultadoEsperado;
    private boolean accesoBD;
    
    @Test
    public void testC1() throws Exception { 
        resultadoEsperado = "ERROR de permisos; ";
        accesoBD = true;
        String[] isbnPrueba = {"11111"};
        
        TestableReserva sut = new TestableReserva(); 
        sut.setCompruebaPermisos(false);
        
        OperacionStub stub = new OperacionStub();
        stub.setOperacionStub(accesoBD, socios, isbns);
        OperationBOFactory.setServicio(stub);
        
        try{
            sut.realizaReserva("xxxx", "xxxx", "Luis", isbnPrueba);
        } catch (Exception ex){
            assertEquals(resultadoEsperado, ex.getMessage()); 
        }   
    }
    
    @Test
    public void testC2() throws Exception { 
        //resultadoEsperado = "ERROR de permisos; ";
        accesoBD = true;
        String[] isbnPrueba = {"11111","22222"};
        
        TestableReserva sut = new TestableReserva(); 
        sut.setCompruebaPermisos(true);
        
        OperacionStub stub = new OperacionStub();
        stub.setOperacionStub(accesoBD, socios, isbns);
        OperationBOFactory.setServicio(stub);
        
        try{
            sut.realizaReserva("ppss", "ppss", "Luis", isbnPrueba);
        } catch (Exception ex){
            fail();
        }  
        assertTrue(true);
    }
    
    @Test
    public void testC3() throws Exception { 
        resultadoEsperado = "ISBN invalido:33333; ";
        accesoBD = true;
        String[] isbnPrueba = {"33333"};
        
        TestableReserva sut = new TestableReserva(); 
        sut.setCompruebaPermisos(true);
        
        OperacionStub stub = new OperacionStub();
        stub.setOperacionStub(accesoBD, socios, isbns);
        OperationBOFactory.setServicio(stub);
        
        try{
            sut.realizaReserva("ppss", "ppss", "Luis", isbnPrueba);
        } catch (Exception ex){
            assertEquals(resultadoEsperado, ex.getMessage()); 
        }   
    }
    
    @Test
    public void testC4() throws Exception { 
        resultadoEsperado = "SOCIO invalido; ";
        accesoBD = true;
        String[] isbnPrueba = {"11111"};
        
        TestableReserva sut = new TestableReserva(); 
        sut.setCompruebaPermisos(true);
        
        OperacionStub stub = new OperacionStub();
        stub.setOperacionStub(accesoBD, socios, isbns);
        OperationBOFactory.setServicio(stub);
        
        try{
            sut.realizaReserva("ppss", "ppss", "Pepe", isbnPrueba);
        } catch (Exception ex){
            assertEquals(resultadoEsperado, ex.getMessage()); 
        }   
    }
    
    @Test
    public void testC5() throws Exception { 
        resultadoEsperado = "CONEXION invalida; ";
        accesoBD = false;
        String[] isbnPrueba = {"11111"};
        
        TestableReserva sut = new TestableReserva(); 
        sut.setCompruebaPermisos(true);
        
        OperacionStub stub = new OperacionStub();
        stub.setOperacionStub(accesoBD, socios, isbns);
        OperationBOFactory.setServicio(stub);
        
        try{
            sut.realizaReserva("ppss", "ppss", "Luis", isbnPrueba);
        } catch (Exception ex){
            assertEquals(resultadoEsperado, ex.getMessage()); 
        }   
    }
    
}
