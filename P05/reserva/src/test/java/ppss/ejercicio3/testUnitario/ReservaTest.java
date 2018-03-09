/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio3.testUnitario;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ppss.ejercicio3.IOperacionBO;
import ppss.ejercicio3.OperationBOFactory;
import ppss.ejercicio3.Reserva;
import static org.junit.Assert.*;
import ppss.ejercicio3.excepciones.ReservaException;

/**
 *
 * @author ppss
 */
public class ReservaTest {
    
    public ReservaTest() {
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

   
    //String resultadoEsperado = "ERROR de permisos; ";
    /**
     * Test of realizaReserva method, of class Reserva.
     */
    @Test
    public void testC1() throws Exception { 
        Exception resultadoEsperado = new ReservaException("ERROR de permisos; ");
        try {
            String login = "xxxx"; 
            String password = "xxxx";
            String user = "Luis";
            String[] isbns = {"11111"};
            
            
            TestableReserva sut = new TestableReserva();
            sut.setCompruebaPermisos(false);

            IOperacionBO operacionStub = new OperacionStub(resultadoEsperado); 
            OperationBOFactory.setServicio(operacionStub);

            sut.realizaReserva(login, password, login, isbns);
            
        }catch (Exception resultadoReal) {           
            assertEquals(resultadoEsperado.getMessage(), resultadoReal.getMessage());
        } 
    }
    
    @Test
    public void testC2() throws Exception {
        try {
            String login = "ppss"; 
            String password = "ppss";
            String user = "Luis";
            String[] isbns = {"11111","22222"};
            
            
            TestableReserva sut = new TestableReserva();
            sut.setCompruebaPermisos(true);

            IOperacionBO operacionStub = new OperacionStub(null); 
            OperationBOFactory.setServicio(operacionStub);

            sut.realizaReserva(login, password, login, isbns);
            
        }catch (Exception resultadoReal) {           
            
        } 
    }
    @Test
    public void testC3() throws Exception {
        Exception resultadoEsperado = new ReservaException("ISBN invalido:33333; ");
        try {
            String login = "ppss"; 
            String password = "ppss";
            String user = "Luis";
            String[] isbns = {"33333"};
            
            
            TestableReserva sut = new TestableReserva();
            sut.setCompruebaPermisos(true);

            IOperacionBO operacionStub = new OperacionStub(resultadoEsperado); 
            OperationBOFactory.setServicio(operacionStub);

            sut.realizaReserva(login, password, login, isbns);
            
        }catch (Exception resultadoReal) {           
            assertEquals(resultadoEsperado.getMessage(), resultadoReal.getMessage());
        } 
    }
    @Test
    public void testC4() throws Exception {
        Exception resultadoEsperado = new ReservaException("SOCIO invalido; ");
        try {
            String login = "ppss"; 
            String password = "ppss";
            String user = "Pepe";
            String[] isbns = {"11111"};
            
            
            TestableReserva sut = new TestableReserva();
            sut.setCompruebaPermisos(true);

            IOperacionBO operacionStub = new OperacionStub(resultadoEsperado); 
            OperationBOFactory.setServicio(operacionStub);

            sut.realizaReserva(login, password, login, isbns);
            
        }catch (Exception resultadoReal) {           
            assertEquals(resultadoEsperado.getMessage(), resultadoReal.getMessage());
        } 
    }
    @Test
    public void testC5() throws Exception {
        Exception resultadoEsperado = new ReservaException("CONEXION invalida; ");
        try {
            String login = "ppss"; 
            String password = "ppss";
            String user = "Luis";
            String[] isbns = {"11111"};
            
            
            TestableReserva sut = new TestableReserva();
            sut.setCompruebaPermisos(true);

            IOperacionBO operacionStub = new OperacionStub(resultadoEsperado); 
            OperationBOFactory.setServicio(operacionStub);

            sut.realizaReserva(login, password, login, isbns);
            
        }catch (Exception resultadoReal) {           
            assertEquals(resultadoEsperado, resultadoReal);
        } 
    }
    
}
