/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.easymock.EasyMock;
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
public class ListadosMockTest {
    
    public ListadosMockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stmMock = EasyMock.createMock(Statement.class);
        conMock = EasyMock.createMock(Connection.class);
        rsMock = EasyMock.createMock(ResultSet.class);
    }
    
    @After
    public void tearDown() {
    }

    private String resultadoEsperado, resultadoReal;
    private Statement stmMock; 
    private Connection conMock; 
    private String tableName = "alumnos";
    private String query = "SELECT apellido1, apellido2, nombre FROM " + tableName;
    private ResultSet rsMock; 
    
    
    
    @Test
    public void TestC1() throws Exception {
        
        resultadoEsperado = "Garcia, Planelles, Jorge\nPérez, Verdú, Carmen\n";
        
        EasyMock.expect(conMock.createStatement()).andReturn(stmMock);
        EasyMock.expect(stmMock.executeQuery(query)).andReturn(rsMock);
        
        EasyMock.expect(rsMock.next()).andReturn(true).times(1).andReturn(true).times(1).andReturn(false).times(1);
        EasyMock.expect(rsMock.getString("apellido1")).andReturn("Garcia").times(1).andReturn("Pérez").times(1);
        EasyMock.expect(rsMock.getString("apellido2")).andReturn("Planelles").times(1).andReturn("Verdú").times(1);
        EasyMock.expect(rsMock.getString("nombre")).andReturn("Jorge").times(1).andReturn("Carmen").times(1);
        
        EasyMock.replay(conMock);
        EasyMock.replay(stmMock);
        EasyMock.replay(rsMock);
        
        Listados listados = new Listados(); 
        resultadoReal = listados.porApellidos(conMock, tableName);
        
        assertEquals(resultadoEsperado, resultadoReal);
        
        EasyMock.verify(conMock);
        EasyMock.verify(stmMock);
        EasyMock.verify(rsMock);
        
    }
    
    @Test
    public void TestC2() throws Exception {
        
        SQLException resultEsperado = new SQLException(); 
        
        EasyMock.expect(conMock.createStatement()).andReturn(stmMock);
        EasyMock.expect(stmMock.executeQuery(query)).andReturn(rsMock);
        
        EasyMock.expect(rsMock.next()).andThrow(new SQLException()).times(1);
        
        EasyMock.replay(conMock);
        EasyMock.replay(stmMock);
        EasyMock.replay(rsMock);
        
        Listados listados = new Listados(); 
        try{
            resultadoReal = listados.porApellidos(conMock, tableName);
        } catch (SQLException e) {
            assertTrue(true);
        }
        
        EasyMock.verify(conMock);
        EasyMock.verify(stmMock);
        EasyMock.verify(rsMock);
        
    }
    
}
