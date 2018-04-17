package ppss.matriculacion.dao;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;


public class DatabaseExport {
   public static void main(String[] args) throws Exception
    {
        // Conexion a la BD
        Class.forName("com.mysql.jdbc.Driver");
        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/matriculacion", "root", "ppss");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        // Exporta DTD
        FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("src/test/resources/matriculacion.dtd"));

        // Exporta base de datos completa
        IDataSet fullDataSet = connection.createDataSet();
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("src/test/resources/dataset.xml"));
    } 
}
