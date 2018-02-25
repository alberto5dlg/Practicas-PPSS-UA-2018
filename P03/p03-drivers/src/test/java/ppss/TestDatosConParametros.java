/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
public class TestDatosConParametros {
    
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

    @Parameterized.Parameters(name = "C{index})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {Arrays.asList(3), new Tramo(0,0)},
            {Arrays.asList(100,100,100,100), new Tramo(0,3)},
            {Arrays.asList(120,140,180,180,180), new Tramo(2,2)},
            {Arrays.asList(-1), new Tramo(0,0)},
            {Arrays.asList(-1,-1,-1,-1), new Tramo(0,3)},
            {Arrays.asList(120,140,-10-10-10), new Tramo(2,2)}
        });
    }
    
    private Datos datos = new Datos(); 
    private ArrayList<Integer> listaLectura = new ArrayList<Integer>();
    private Tramo resultadoEsperado, resultadoReal; 
    
    public TestDatosConParametros(ArrayList<Integer> listaLectura, Tramo resultadoEsperado) {
        this.listaLectura = listaLectura; 
        this.resultadoEsperado = resultadoEsperado;
    }
   
    @Test
    public void testCalculaTasa() {
        resultadoReal = datos.buscarTramoLlanoMasLargo(listaLectura);
        assertTrue(resultadoEsperado.equals(resultadoReal));
    }
}
