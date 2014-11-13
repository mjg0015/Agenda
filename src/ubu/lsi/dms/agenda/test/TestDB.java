package ubu.lsi.dms.agenda.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.hsqldb.jdbc.JDBCDataSource;
import org.junit.Test;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FabricaBD;
import ubu.lsi.dms.agenda.persistencia.FabricaPersistencia;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

/**
 * Clase con tests para la comprobación del funcionamiento de la persistencia en
 * la base de datos.
 * 
 * @author Mario Juez
 * @author Álvaro Vázquez
 *
 */
public class TestDB {

	/**
	 * Logger
	 */
	private Logger logger = Logger.getLogger("ubu.lsi.dms.agenda.test");

	/**
	 * Ejecución de los scripts necesarios para configurar el estado inicial de
	 * la base de datos.
	 */
	private void ejecutaScripts() {
		BufferedReader brCreacion = null;
		BufferedReader brCarga = null;
		String scriptCreacion = "";
		String scriptCarga = "";
		Connection conn = getConnection();
		Statement st = null;
		try {

			brCreacion = new BufferedReader(new FileReader(
					"res/ScriptCreacionAgenda"));
			brCarga = new BufferedReader(new FileReader("res/ScriptCargaDatos"));
			String l;

			while ((l = brCreacion.readLine()) != null) {
				scriptCreacion += l + "\n";
			}

			while ((l = brCarga.readLine()) != null) {
				scriptCarga += l + "\n";
			}
			st = conn.createStatement();
			st.execute(scriptCreacion);
			st.execute(scriptCarga);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Obtiene la conexión a la base de datos.
	 * 
	 * @return Conexión a la base de datos.
	 */
	private Connection getConnection() {

		JDBCDataSource ds = new JDBCDataSource();
		Connection conn = null;

		Properties propiedadesBD = new Properties();

		try {
			FileInputStream ficheroPropiedadesBD = new FileInputStream(
					"propiedades_bd.ini");
			propiedadesBD.load(ficheroPropiedadesBD);
			// Cierre del fichero
			ficheroPropiedadesBD.close();

			ds.setDatabaseName(propiedadesBD.getProperty("bd"));
			ds.setUser(propiedadesBD.getProperty("usuario"));
			ds.setPassword(propiedadesBD.getProperty("contrasena"));

			// Obtención de la conexión
			conn = ds.getConnection();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return conn;
	}

	@Test
	public void testGetContactos() {

		ejecutaScripts();

		logger.info("-- testGetContactos --");

		FabricaPersistencia fabricaBD = FabricaBD.getInstance();
		FachadaPersistente fachadaBD = fabricaBD.crearFachadaPersistente();

		List<Contacto> contactos = fachadaBD.getContactos();

		for (Contacto c : contactos) {
			System.out.println(c.toString());
		}

		assert contactos.size() == 10;
		
	}

	@Test
	public void testGetContactosPorApellido() {

		ejecutaScripts();

		logger.info("-- testGetContactosPorApellido --");

		FabricaPersistencia fabricaBD = FabricaBD.getInstance();
		FachadaPersistente fachadaBD = fabricaBD.crearFachadaPersistente();

		List<Contacto> contactos = fachadaBD.getContactos("Apellidos001");

		for (Contacto c : contactos) {
			System.out.println(c.toString());
		}

		assert contactos.size() == 1;
	}

	@Test
	public void testGetLlamadas() {

		ejecutaScripts();

		logger.info("-- testGetLlamadas --");

		FabricaPersistencia fabricaBD = FabricaBD.getInstance();
		FachadaPersistente fachadaBD = fabricaBD.crearFachadaPersistente();

		List<Llamada> llamadas = fachadaBD.getLlamadas();

		for (Llamada ll : llamadas) {
			System.out.println(ll.toString());
		}

		assert llamadas.size() == 10;

	}

	@Test
	public void testGetLlamadasPorContacto() {

		ejecutaScripts();

		logger.info("-- testGetLlamadasPorContacto --");

		FabricaPersistencia fabricaBD = FabricaBD.getInstance();
		FachadaPersistente fachadaBD = fabricaBD.crearFachadaPersistente();

		List<Contacto> contactos = fachadaBD.getContactos();
		List<Llamada> llamadas = fachadaBD.getLlamadas(contactos.get(0));

		for (Llamada ll : llamadas) {
			System.out.println(ll.toString());
		}

		assert llamadas.size() == 5;

	}

	@Test
	public void testInsertContacto() {

		ejecutaScripts();

		FabricaPersistencia fabricaBD = FabricaBD.getInstance();
		FachadaPersistente fachadaBD = fabricaBD.crearFachadaPersistente();

		Contacto contacto11 = new Contacto(11, "Oscar", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));

		assert fachadaBD.insertContacto(contacto11);

		List<Contacto> contactos = fachadaBD.getContactos();

		assert contacto11.equals(contactos.get(10));

	}

	@Test
	public void testInsertLlamada() {

		ejecutaScripts();

		FabricaPersistencia fabricaBD = FabricaBD.getInstance();
		FachadaPersistente fachadaBD = fabricaBD.crearFachadaPersistente();

		Contacto contacto1 = new Contacto(1, "Oscar", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));

		Llamada llamada11 = new Llamada(11, contacto1, "2014-10-18 01:00:00",
				"asunto", null);

		assert fachadaBD.insertLlamada(llamada11);

	}

	@Test
	public void testInsertTipoContacto() {

		ejecutaScripts();

		FabricaPersistencia fabricaBD = FabricaBD.getInstance();
		FachadaPersistente fachadaBD = fabricaBD.crearFachadaPersistente();

		TipoContacto tipoContacto11 = new TipoContacto(11, "tipo011");

		assert fachadaBD.insertTipoContacto(tipoContacto11);

	}

	@Test
	public void testUpdateContacto() {

		ejecutaScripts();

		logger.info("-- testUpdateContacto --");

		FabricaPersistencia fabricaBD = FabricaBD.getInstance();
		FachadaPersistente fachadaBD = fabricaBD.crearFachadaPersistente();

		List<Contacto> contactos = fachadaBD.getContactos();
		Contacto contacto = contactos.get(0);
		contacto.setApellidos("García");

		assert fachadaBD.updateContacto(contacto.getIdContacto(), contacto);

		contactos = fachadaBD.getContactos();
		Contacto contacto_nuevo = contactos.get(0);

		assert contacto_nuevo.getApellidos() == "García";

	}

	@Test
	public void testUpdateLlamada() {

		ejecutaScripts();

		logger.info("-- testUpdateLlamada --");

		FabricaPersistencia fabricaBD = FabricaBD.getInstance();
		FachadaPersistente fachadaBD = fabricaBD.crearFachadaPersistente();

		List<Llamada> llamadas = fachadaBD.getLlamadas();
		Llamada llamada = llamadas.get(0);
		llamada.setAsunto("pendiente");

		assert fachadaBD.updateLlamada(llamada.getIdLlamada(), llamada);

		llamadas = fachadaBD.getLlamadas();
		Llamada llamada_nueva = llamadas.get(0);

		System.out.println(llamada_nueva.toString());

		assert llamada_nueva.getAsunto() == "pendiente";

	}

	@Test
	public void testUpdateTipoContacto() {

		ejecutaScripts();

		logger.info("-- testUpdateTipoContacto --");

		FabricaPersistencia fabricaBD = FabricaBD.getInstance();
		FachadaPersistente fachadaBD = fabricaBD.crearFachadaPersistente();

		List<TipoContacto> tiposContacto = fachadaBD.getTiposContacto();
		TipoContacto tipoContacto = tiposContacto.get(0);
		tipoContacto.setTipoContacto("NuevoTipo001");

		assert fachadaBD.updateTipoContacto(tipoContacto.getIdTipoContacto(),
				tipoContacto);

		tiposContacto = fachadaBD.getTiposContacto();
		TipoContacto tipoContacto_nuevo = tiposContacto.get(0);

		System.out.println(tipoContacto_nuevo.toString());

		assert tipoContacto_nuevo.getTipoContacto() == "NuevoTipo001";

	}

}
