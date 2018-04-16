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
  
  private CustomerFactory _customerFactory;
  
  public static final String TABLE_CUSTOMER = "customer";

  private IDatabaseTester databaseTester;

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
    databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
        		"jdbc:mysql://localhost:3306/ESQUEMA_BASE_DE_DATOS?useSSL=false", "login", "password");
      
    DataFileLoader loader = new FlatXmlDataFileLoader();
    IDataSet dataSet = loader.load("/customer-init.xml");	 
      
    databaseTester.setDataSet(dataSet);

    databaseTester.onSetup();

    _customerFactory = CustomerFactory.getInstance();
  }
	
  @Test
  public void testInsert() throws Exception {
    Customer customer = _customerFactory.create(1,"John", "Smith");
    customer.setStreet("1 Main Street");
    customer.setCity("Anycity");
	        
    _customerFactory.insert(customer);

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

}
