package ppss;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.log4j.BasicConfigurator;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;



public class CustomerFactoryIT {
  
  private CustomerFactory _customerFactory;  //Objeto de la clase que vamos a probar 
  
  public static final String TABLE_CUSTOMER = "customer";

  private IDatabaseTester databaseTester; //Objeto con el que conectarse a la bbdd durante la ejecucion de las pruebas

@BeforeClass
  public static void only_once() {
//    Para evitar el mensaje   
//    Running ppss.dbunitexample.TestDBUnit
//    log4j:WARN No appenders could be found for logger (org.dbunit.assertion.SimpleAssert).
//    log4j:WARN Please initialize the log4j system properly.  
    BasicConfigurator.configure();
    
  }
  @Before
  public void setUp() throws Exception {
      //Inicializamos la conexion con la base de datos indicando el driver necesarion, la url de conexion a la bbdd y los 
      //datos de usuario y password para conectarse 
    databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
        		"jdbc:mysql://localhost:3306/DBUNIT?useSSL=false", "root", "ppss");
      
    DataFileLoader loader = new FlatXmlDataFileLoader();
    IDataSet dataSet = loader.load("/customer-init.xml");	 
      //Contiene los datos que se van a introducir en la base de datos para las pruebas 
    databaseTester.setDataSet(dataSet);
    //Insertamos el contenido en la base de datos de la variable dataSet
    databaseTester.onSetup();
    //obtenemos una instancia de la clase a probar 
    _customerFactory = CustomerFactory.getInstance();
  }
	
  @Test
  public void testInsert() throws Exception {
    Customer customer = _customerFactory.create(1,"John", "Smith");
    customer.setStreet("1 Main Street");
    customer.setCity("Anycity");
    //Metodo que vamos a probar 
    _customerFactory.insert(customer);
    //recuperamos la conexion de la base de datos 
    IDatabaseConnection connection = databaseTester.getConnection();
    
    // configuramos la conexión como de tipo mysql
    // para evitar el mensaje: 
    // WARN org.dbunit.dataset.AbstractTableMetaData - Potential problem found: 
    //      The configured data type factory 'class org.dbunit.dataset.datatype.DefaultDataTypeFactory' 
    //      might cause problems with the current database 'MySQL' (e.g. some datatypes may not be supported properly). 
    //      ...
    DatabaseConfig dbconfig = connection.getConfig();
    dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());
	        
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("customer");

    DataFileLoader loader = new FlatXmlDataFileLoader();
    IDataSet expectedDataSet = loader.load("/customer-expected.xml");
      
    ITable expectedTable = expectedDataSet.getTable("customer");

    Assertion.assertEquals(expectedTable, actualTable);

   }
	 
  @Test
  public void testDelete() throws Exception {
    Customer customer = _customerFactory.create(1,"John", "Smith");
    customer.setStreet("1 Main Street");
    customer.setCity("Anycity");
    _customerFactory.insert(customer);

    _customerFactory.delete(customer);

    IDatabaseConnection connection = databaseTester.getConnection();
    
    // configuramos la conexión como de tipo mysql
    DatabaseConfig dbconfig = connection.getConfig();
    dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());
      
    IDataSet databaseDataSet = connection.createDataSet();
    int rowCount = databaseDataSet.getTable("customer").getRowCount();
	        
    Assert.assertEquals(0, rowCount);
  }
  
  @Test
  public void testUpdate() throws Exception {
    Customer customer = _customerFactory.create(1,"John", "Smith");
    customer.setStreet("1 Main Street");
    customer.setCity("Anycity");
    _customerFactory.insert(customer);
    
    Customer updateCustomer = _customerFactory.create(1, "John", "Smith");
    updateCustomer.setStreet("Other Street");
    updateCustomer.setCity("NewCity");
    _customerFactory.update(updateCustomer);
    
    IDatabaseConnection connection = databaseTester.getConnection();
    
    DatabaseConfig dbconfig = connection.getConfig();
    dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());
	        
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("customer");

    DataFileLoader loader = new FlatXmlDataFileLoader();
    IDataSet expectedDataSet = loader.load("/customer-expected-update.xml");
      
    ITable expectedTable = expectedDataSet.getTable("customer");

    Assertion.assertEquals(expectedTable, actualTable);
  }
  
   @Test
  public void testRetrieve() throws Exception {
    Customer customer = _customerFactory.create(1,"John", "Smith");
    customer.setStreet("1 Main Street");
    customer.setCity("Anycity");
    _customerFactory.insert(customer);

    Customer resultadoReal = _customerFactory.retrieve(1);
    
    IDatabaseConnection connection = databaseTester.getConnection();
    
    DatabaseConfig dbconfig = connection.getConfig();
    dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());
	        
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("customer");

    DataFileLoader loader = new FlatXmlDataFileLoader();
    IDataSet expectedDataSet = loader.load("/customer-expected-update.xml");
      
    ITable expectedTable = expectedDataSet.getTable("customer");

    Assert.assertEquals(customer, resultadoReal);
  }
  

}

/*
DIFERENCIA ENTRE DATASETA Y TABLE
--  El dataset es un conjunto de datos(coleccion de tablas) que contiene todos los datos existentes en la base de datos 
mientras que un objeto table solo representa una tabla de la base de datos. 

--Los dataset se utilizan para comprobar el estado de la base de datos a nivel global antes y despues de ejecutar las pruebas, mientas
-- que las tablas se utilizan para probar tablas obtenidas con las tablas esperadas.  
*/