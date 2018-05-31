/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ppss
 */
public class MultipathExampleTest {
    
    public MultipathExampleTest() {
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

    //Con este test conseguimos cobertura de lineas 100% 
    @Test
    public void testC1() {
        int a = 6;
        int b = 6;
        int c = 0; 
        MultipathExample test = new MultipathExample(); 
        
        int rEsperado = 12; 
        
        int rReal = test.multiPath(a, b, c);
        Assert.assertEquals(rEsperado, rReal);
    }
    
    @Test
    public void testC2() {
        int a = 2;
        int b = 2; 
        int c = 0; 
        MultipathExample test = new MultipathExample(); 
        
        int rEsperado = 0; 
        
        int rReal = test.multiPath(a, b, c);
        Assert.assertEquals(rEsperado, rReal);
    }
    
}
