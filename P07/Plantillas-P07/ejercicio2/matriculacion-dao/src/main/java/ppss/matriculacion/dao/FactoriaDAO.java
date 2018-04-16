package ppss.matriculacion.dao;

/**
 * La clase <code>GestorDAO</code> se utilizar� como factor�a de los objetos de acceso
 * a datos de la aplicaci�n. 
 *
 */
public class FactoriaDAO {
	/**
	 * Devuelve al DAO para acceder a los datos de los alumnos.
	 * @return DAO que da acceso a los alumnos.
	 */
	public IAlumnoDAO getAlumnoDAO() {
		return new JDBCAlumnoDAO();
	}	

	/**
	 * Devuelve al DAO para acceder a los datos de las asignaturas.
	 * @return DAO que da acceso a las asignaturas.
	 */
	public IAsignaturaDAO getAsignaturaDAO() {
		return new JDBCAsignaturaDAO();
	}	

	/**
	 * Devuelve al DAO para acceder a los datos de matriculaci�n.
	 * @return DAO que da acceso a las matriculaciones.
	 */
	public IMatriculaDAO getMatriculaDAO() {
		return new JDBCMatriculaDAO();
	}	
}
