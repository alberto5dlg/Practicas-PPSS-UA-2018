/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.matriculacion.dao;

import java.util.Calendar;
import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ppss.matriculacion.to.AlumnoTO;

/**
 *
 * @author ppss
 */
public class IAlumnoDAOIT {
  
    public static final String TABLE_CUSTOMER = "matriculacion";

    private IDatabaseTester databaseTester; 
    private Calendar cal = Calendar.getInstance();
    private IAlumnoDAO alumnoFactory =  new FactoriaDAO().getAlumnoDAO();
    
    public IAlumnoDAOIT() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
        		"jdbc:mysql://localhost:3306/matriculacion?useSSL=false", "root", "ppss");
      
    DataFileLoader loader = new FlatXmlDataFileLoader();
    IDataSet dataSet = loader.load("/tabla2.xml");	 
      //Contiene los datos que se van a introducir en la base de datos para las pruebas 
    databaseTester.setDataSet(dataSet);
    //Insertamos el contenido en la base de datos de la variable dataSet
    databaseTester.onSetup();
    //obtenemos una instancia de la clase a probar 
    }
    
    @After
    public void tearDown() {
    }
    
    private AlumnoTO createAlumno(String nombre, String nif, String direccion,String email)
    {
        AlumnoTO p = new AlumnoTO();
        p.setNif(nif);
        p.setNombre(nombre);
        p.setDireccion(direccion);
        p.setEmail(email);
        p.setFechaNacimiento(cal.getTime());
        return p;
    }
    private void setFecha(int anyo)
    {
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, anyo);
        cal.set(Calendar.MONTH, 1);        
        cal.set(Calendar.DATE, 22);
    }

    @Test
    public void testA1() throws Exception {
        setFecha(1985);
        AlumnoTO p = createAlumno("Elena Aguirre Juarez", "33333333C", "", "");
        
        try {
            alumnoFactory.addAlumno(p);
        } catch (Exception e){
            fail();
        }
        
        IDatabaseConnection connection = databaseTester.getConnection();
        DatabaseConfig dbconfig = connection.getConfig();
        dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());

        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("alumnos");

        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/tabla3.xml");

        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, actualTable);
    }
    
    @Test
    public void testA2() throws Exception {
        setFecha(1982);
        AlumnoTO p = createAlumno("Alfonso Ramirez Ruiz", "11111111A", "", "");
        
        try {
            alumnoFactory.addAlumno(p);
            fail();
        } catch (DAOException dao){
            assertTrue(true); 
        }
    }
    
    @Test
    public void testA3() {
        setFecha(1982);
        AlumnoTO p = createAlumno(null, "44444444D", "", "");
        
        try {
            alumnoFactory.addAlumno(p);
            fail();
        } catch (DAOException dao){
            assertTrue(true); 
        }
    }
    
    @Test
    public void testA4() {
        setFecha(1982);
        AlumnoTO p = null;
        
        try {
            alumnoFactory.addAlumno(p);
            fail();
        } catch (DAOException dao){
            assertTrue(true); 
        }
    }
    
    @Test
    public void testA5() {
        setFecha(1982);
        AlumnoTO p = createAlumno("Pedro Garcia Lopez", null, "", "");
        
        try {
            alumnoFactory.addAlumno(p);
            fail();
        } catch (DAOException dao){
            assertTrue(true); 
        }
    }
    
    @Test
    public void testB1() throws Exception {
        String nif = "11111111A";
        
        try{
            alumnoFactory.delAlumno(nif);
        }catch (Exception e){
            fail();
        }
        IDatabaseConnection connection = databaseTester.getConnection();
        DatabaseConfig dbconfig = connection.getConfig();
        dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());

        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("alumnos");

        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/tabla4.xml");

        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, actualTable);
    }
    
    @Test
    public void testB2() throws Exception {
        String nif = "33333333C";
        try {
            alumnoFactory.delAlumno(nif);
            fail();
        } catch (DAOException dao){
            assertTrue(true); 
        }
    }
    
}
