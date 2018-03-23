/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.partialMockBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ppss.ejercicio4.excepciones.IsbnInvalidoException;
import ppss.ejercicio4.excepciones.JDBCException;
import ppss.ejercicio4.excepciones.SocioInvalidoException;

/**
 *
 * @author ppss
 */
public class ReservaMockTest {
    
    public ReservaMockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        reservaMock = EasyMock.partialMockBuilder(Reserva.class).addMockedMethods("compruebaPermisos","getFactoriaBOs").createMock();
        factoriaMock = EasyMock.createMock(FactoriaBOs.class);
        iOperacionMock = EasyMock.createMock(IOperacionBO.class);
    }
    
    @After
    public void tearDown() {
    }
    
    private Reserva reservaMock;
    private FactoriaBOs factoriaMock; 
    private String login, password, socio, resultadoEsperado, resultadoReal;
    private IOperacionBO iOperacionMock;
    
    
    @Test
    public void TestC1() {
        login = "xxxx";
        password = "xxxx"; 
        socio = "Pepe";
        String[] isbns = {"22222"};
        resultadoEsperado = "ERROR de permisos; ";
                
        EasyMock.expect(reservaMock.compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)).andReturn(false);
        
        EasyMock.replay(reservaMock);
        
        try{
            reservaMock.realizaReserva(login, password, socio, isbns);
        }catch (Exception e){
            assertEquals(resultadoEsperado, e.getMessage());
        }
        
        EasyMock.verify(reservaMock);
    }
    
    @Test
    public void TestC2() {
        login = "ppss";
        password = "ppss"; 
        socio = "Pepe";
        String[] isbns = {"22222","33333"};
        resultadoEsperado = "";
        
        
        EasyMock.expect(reservaMock.compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)).andReturn(true);
        EasyMock.expect(reservaMock.getFactoriaBOs()).andReturn(factoriaMock);
        
        EasyMock.expect(factoriaMock.getOperacionBO()).andReturn(iOperacionMock);
        
        EasyMock.replay(reservaMock);
        EasyMock.replay(factoriaMock);
        
        try{
            iOperacionMock.operacionReserva(socio, isbns[0]);
            iOperacionMock.operacionReserva(socio, isbns[1]);
            
            EasyMock.replay(iOperacionMock);
                
            reservaMock.realizaReserva(login, password, socio, isbns);

        }catch (Exception e){
            assertEquals(resultadoEsperado, e.getMessage());
        }
        
        EasyMock.verify(reservaMock);
        EasyMock.verify(factoriaMock);
        EasyMock.verify(iOperacionMock);
    }
    
    @Test
    public void TestC3() {
        login = "ppss";
        password = "ppss"; 
        socio = "Pepe";
        String[] isbns = {"11111"};
        resultadoEsperado = "ISBN invalido:11111; ";
        
        
        EasyMock.expect(reservaMock.compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)).andReturn(true);
        EasyMock.expect(reservaMock.getFactoriaBOs()).andReturn(factoriaMock);
        
        EasyMock.expect(factoriaMock.getOperacionBO()).andReturn(iOperacionMock);
        
        EasyMock.replay(reservaMock);
        EasyMock.replay(factoriaMock);
        
        try{
            iOperacionMock.operacionReserva(socio, isbns[0]);
            EasyMock.expectLastCall().andThrow(new IsbnInvalidoException());
            
            EasyMock.replay(iOperacionMock);
                
            reservaMock.realizaReserva(login, password, socio, isbns);

        }catch (Exception e){
            assertEquals(resultadoEsperado, e.getMessage());
        }
        
        EasyMock.verify(reservaMock);
        EasyMock.verify(factoriaMock);
        EasyMock.verify(iOperacionMock);
    }

    @Test
    public void TestC4() {
        login = "ppss";
        password = "ppss"; 
        socio = "Luis";
        String[] isbns = {"11111"};
        resultadoEsperado = "SOCIO invalido; ";
        
        
        EasyMock.expect(reservaMock.compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)).andReturn(true);
        EasyMock.expect(reservaMock.getFactoriaBOs()).andReturn(factoriaMock);
        
        EasyMock.expect(factoriaMock.getOperacionBO()).andReturn(iOperacionMock);
        
        EasyMock.replay(reservaMock);
        EasyMock.replay(factoriaMock);
        
        try{
            iOperacionMock.operacionReserva(socio, isbns[0]);
            EasyMock.expectLastCall().andThrow(new SocioInvalidoException());
            
            EasyMock.replay(iOperacionMock);
                
            reservaMock.realizaReserva(login, password, socio, isbns);

        }catch (Exception e){
            assertEquals(resultadoEsperado, e.getMessage());
        }
        
        EasyMock.verify(reservaMock);
        EasyMock.verify(factoriaMock);
        EasyMock.verify(iOperacionMock);
    }
    
    @Test
    public void TestC5() {
        login = "ppss";
        password = "ppss"; 
        socio = "Pepe";
        String[] isbns = {"11111"};
        resultadoEsperado = "CONEXION invalida; ";
        
        
        EasyMock.expect(reservaMock.compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)).andReturn(true);
        EasyMock.expect(reservaMock.getFactoriaBOs()).andReturn(factoriaMock);
        
        EasyMock.expect(factoriaMock.getOperacionBO()).andReturn(iOperacionMock);
        
        EasyMock.replay(reservaMock);
        EasyMock.replay(factoriaMock);
        
        try{
            iOperacionMock.operacionReserva(socio, isbns[0]);
            EasyMock.expectLastCall().andThrow(new JDBCException());
            
            EasyMock.replay(iOperacionMock);
                
            reservaMock.realizaReserva(login, password, socio, isbns);

        }catch (Exception e){
            assertEquals(resultadoEsperado, e.getMessage());
        }
        
        EasyMock.verify(reservaMock);
        EasyMock.verify(factoriaMock);
        EasyMock.verify(iOperacionMock);
    }
    
}
