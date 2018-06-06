//src/test/java

public class ITTestDBUnit {
	public Alumno _alumno; 
	private IDatabaseTester databaseTester; 

	@Before
	public void setup(){
		databaseTester = new JdbcDatabaseTester("cadena de conexion"); 
		DataFileLoader loader = new FlatXmlDataFileLoader(); 
		IDataSet dataset = loader.load("initdb.xml"); 
		databaseTester.setDataSet(dataset); 
		databaseTester.onSetup();
	}

	@testpublic void TestC1() {
		Alumno newAlu = new Alumno("nombre", "direccion", "id");
		_alumno.addAlumno(newAlu);

		IDatabaseConnection connection = databaseTester.getConnection(); 
		IDataSet realDataset = connection.createDataset(); 
		ITable realTable = realDataset.getTable("alumnos"); 

		DataFileLoader loader = new FlatXmlDataFileLoader(); 
		IDataSet expDataset = loader.load("exp-data.xml"); 
		ITable expTable = expDataset.getTable("alumnos"); 

		Assertion.assertEquals(expTable, realTable); 
	}
}