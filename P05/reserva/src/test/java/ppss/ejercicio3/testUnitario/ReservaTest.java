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

    
    private ArrayList<String> socios = new ArrayList<>(Arrays.asList("Luis")); 
    private ArrayList<String> isbns = new ArrayList<>(Arrays.asList("11111","22222")); 
    
    @Test
    public void testC1() throws Exception { 
        TestableReserva sut = new TestableReserva(); 
        sut.setCompruebaPermisos(false);
        
        IOperacionBO stub = new OperacionStub(true, socios,isbns);
        OperationBOFactory.setServicio(stub);
        try{
            sut.realizaReserva("xxxx", "xxxx", "Luis", Arrays.asList("11111"));
        } catch (Exception ex){
            assertEquals(ex.getMessage(), "ERROR de permisos; "); 
        }   
    }
}
