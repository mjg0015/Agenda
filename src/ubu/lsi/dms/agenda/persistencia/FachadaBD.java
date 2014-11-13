/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.hsqldb.jdbc.JDBCDataSource;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * Fachada que implementa la persistencia de la agenda en la base de datos.
 * 
 * @author Mario Juez
 * @author Álvaro Vázquez
 *
 */
public class FachadaBD implements FachadaPersistente {

	/**
	 * Instancia de la fachada.
	 */
	private static FachadaBD fachadaBD = null;
	
	/**
	 * Propiedades de conexión a la base de datos.
	 */
	private Properties propiedadesBD;
	
	/**
	 * Conexión a la base de datos.
	 */
	private Connection conn;

	/**
	 * Logger.
	 */
	private Logger logger = Logger.getLogger("ubu.lsi.dms.agenda.persistencia");
	
	/**
	 * Constructor privado que lee las propiedades de la conexión a la base de
	 * datos y obtiene la conexión.
	 */
	private FachadaBD() {

		propiedadesBD = new Properties();

		try {
			FileInputStream ficheroPropiedadesBD = new FileInputStream(
					"propiedades_bd.ini");
			propiedadesBD.load(ficheroPropiedadesBD);
			// Cierre del fichero
			ficheroPropiedadesBD.close();

			// Obtención de la conexión
			conn = getConnection();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Obtiene la conexión a la base de datos.
	 * 
	 * @return Conexión a la base de datos.
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		JDBCDataSource ds = new JDBCDataSource();
		ds.setDatabaseName(propiedadesBD.getProperty("bd"));
		ds.setUser(propiedadesBD.getProperty("usuario"));
		ds.setPassword(propiedadesBD.getProperty("contrasena"));
		// Obtener conexión
		return ds.getConnection();
	}

	@Override
	public List<Contacto> getContactos() {

		List<Contacto> contactos = new ArrayList<Contacto>();

		Statement stmt = null;
		String query = "SELECT IdContacto,Nombre,"
				+ "Apellidos,Estimado,Direccion,Ciudad,Prov,CodPostal,Region,"
				+ "Pais,NombreCompania,Cargo,TelefonoTrabajo,ExtensionTrabajo,"
				+ "TelefonoMovil,NumFax,NomCorreoElectronico,IdTipoContacto,Notas "
				+ "FROM Contactos";

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				int idContacto = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				String estimado = rs.getString(4);
				String direccion = rs.getString(5);
				String ciudad = rs.getString(6);
				String prov = rs.getString(7);
				String codPostal = rs.getString(8);
				String region = rs.getString(9);
				String pais = rs.getString(10);
				String nombreCompania = rs.getString(11);
				String cargo = rs.getString(12);
				String telefonoTrabajo = rs.getString(13);
				String extensionTrabajo = rs.getString(14);
				String telefonoMovil = rs.getString(15);
				String numFax = rs.getString(16);
				String nomCorreoElectronico = rs.getString(17);
				int idTipoContacto = rs.getInt(18);
				String notas = rs.getString(19);

				// Obtención del objeto TipoContacto a partir de su id
				List<TipoContacto> tiposContacto = getTiposContacto();
				int indiceTipoContacto = tiposContacto
						.indexOf(new TipoContacto(idTipoContacto, ""));
				TipoContacto tipoContacto = tiposContacto
						.get(indiceTipoContacto);

				Contacto contacto = new Contacto(idContacto, nombre, apellidos,
						estimado, direccion, ciudad, prov, codPostal, region,
						pais, nombreCompania, cargo, telefonoTrabajo,
						extensionTrabajo, telefonoMovil, numFax,
						nomCorreoElectronico, notas, tipoContacto);

				contactos.add(contacto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contactos;

	}

	@Override
	public List<Contacto> getContactos(String apellido) {

		List<Contacto> contactos = new ArrayList<Contacto>();

		PreparedStatement pstmt = null;
		String query = "SELECT IdContacto,Nombre,"
				+ "Apellidos,Estimado,Direccion,Ciudad,Prov,CodPostal,Region,"
				+ "Pais,NombreCompania,Cargo,TelefonoTrabajo,ExtensionTrabajo,"
				+ "TelefonoMovil,NumFax,NomCorreoElectronico,IdTipoContacto,Notas "
				+ "FROM Contactos WHERE Apellidos=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, apellido);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int idContacto = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				String estimado = rs.getString(4);
				String direccion = rs.getString(5);
				String ciudad = rs.getString(6);
				String prov = rs.getString(7);
				String codPostal = rs.getString(8);
				String region = rs.getString(9);
				String pais = rs.getString(10);
				String nombreCompania = rs.getString(11);
				String cargo = rs.getString(12);
				String telefonoTrabajo = rs.getString(13);
				String extensionTrabajo = rs.getString(14);
				String telefonoMovil = rs.getString(15);
				String numFax = rs.getString(16);
				String nomCorreoElectronico = rs.getString(17);
				int idTipoContacto = rs.getInt(18);
				String notas = rs.getString(19);

				// Obtención del objeto TipoContacto a partir de su id
				List<TipoContacto> tiposContacto = getTiposContacto();
				int indiceTipoContacto = tiposContacto
						.indexOf(new TipoContacto(idTipoContacto, ""));
				TipoContacto tipoContacto = tiposContacto
						.get(indiceTipoContacto);

				Contacto contacto = new Contacto(idContacto, nombre, apellidos,
						estimado, direccion, ciudad, prov, codPostal, region,
						pais, nombreCompania, cargo, telefonoTrabajo,
						extensionTrabajo, telefonoMovil, numFax,
						nomCorreoElectronico, notas, tipoContacto);

				contactos.add(contacto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contactos;

	}

	@Override
	public List<Llamada> getLlamadas() {

		List<Llamada> llamadas = new ArrayList<Llamada>();

		Statement stmt = null;
		String query = "SELECT IdLlamada,IdContacto,FechaLlamada,"
				+ "Asunto,Notas FROM Llamadas";

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				int idLlamada = rs.getInt(1);
				int idContacto = rs.getInt(2);
				String fechaLlamada = rs.getString(3);
				String asunto = rs.getString(4);
				String notas = rs.getString(5);

				// Obtención del objeto Contacto a partir de su id
				List<Contacto> contactos = getContactos();
				int indiceContacto = contactos.indexOf(new Contacto(idContacto,
						null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null));
				Contacto contacto = contactos.get(indiceContacto);

				Llamada llamada = new Llamada(idLlamada, contacto,
						fechaLlamada, asunto, notas);

				llamadas.add(llamada);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return llamadas;

	}

	@Override
	public List<Llamada> getLlamadas(Contacto contacto) {

		List<Llamada> llamadas = new ArrayList<Llamada>();

		PreparedStatement pstmt = null;
		String query = "SELECT IdLlamada,FechaLlamada,"
				+ "Asunto,Notas FROM Llamadas WHERE IdContacto=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, contacto.getIdContacto());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int idLlamada = rs.getInt(1);
				String fechaLlamada = rs.getString(2);
				String asunto = rs.getString(3);
				String notas = rs.getString(4);

				Llamada llamada = new Llamada(idLlamada, contacto,
						fechaLlamada, asunto, notas);

				llamadas.add(llamada);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return llamadas;

	}

	@Override
	public List<TipoContacto> getTiposContacto() {

		List<TipoContacto> tiposContacto = new ArrayList<TipoContacto>();

		Statement stmt = null;
		String query = "SELECT IdTipoContacto,TipoContacto FROM Tiposdecontacto";

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				int idTipoContacto = rs.getInt(1);
				String tipo = rs.getString(2);
				TipoContacto tipoContacto = new TipoContacto(idTipoContacto,
						tipo);
				tiposContacto.add(tipoContacto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tiposContacto;

	}

	@Override
	public boolean insertContacto(Contacto contacto) {

		PreparedStatement pstmt = null;

		int idContacto = contacto.getIdContacto();
		String nombre = contacto.getNombre();
		String apellidos = contacto.getApellidos();
		String estimado = contacto.getEstimado();
		String direccion = contacto.getDireccion();
		String ciudad = contacto.getCiudad();
		String prov = contacto.getProv();
		String codPostal = contacto.getCodPostal();
		String region = contacto.getRegion();
		String pais = contacto.getPais();
		String nombreCompania = contacto.getNombreCompania();
		String cargo = contacto.getCargo();
		String telefonoTrabajo = contacto.getTelefonoTrabajo();
		String extensionTrabajo = contacto.getExtensionTrabajo();
		String telefonoMovil = contacto.getTelefonoMovil();
		String numFax = contacto.getNumFax();
		String nomCorreoElectronico = contacto.getNomCorreoElectronico();
		int idTipoContacto = contacto.getTipoContacto().getIdTipoContacto();
		String notas = contacto.getNotas();

		String query = "INSERT INTO  Contactos (IdContacto,Nombre,"
				+ "Apellidos,Estimado,Direccion,Ciudad,Prov,CodPostal,Region,"
				+ "Pais,NombreCompania,Cargo,TelefonoTrabajo,ExtensionTrabajo,"
				+ "TelefonoMovil,NumFax,NomCorreoElectronico,IdTipoContacto,Notas) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idContacto);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellidos);
			pstmt.setString(4, estimado);
			pstmt.setString(5, direccion);
			pstmt.setString(6, ciudad);
			pstmt.setString(7, prov);
			pstmt.setString(8, codPostal);
			pstmt.setString(9, region);
			pstmt.setString(10, pais);
			pstmt.setString(11, nombreCompania);
			pstmt.setString(12, cargo);
			pstmt.setString(13, telefonoTrabajo);
			pstmt.setString(14, extensionTrabajo);
			pstmt.setString(15, telefonoMovil);
			pstmt.setString(16, numFax);
			pstmt.setString(17, nomCorreoElectronico);
			pstmt.setInt(18, idTipoContacto);
			pstmt.setString(19, notas);

			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			logger.severe(e.getMessage());
			return false;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.warning(e.getMessage());
				}
			}
		}

	}

	@Override
	public boolean insertLlamada(Llamada llamada) {

		PreparedStatement pstmt = null;

		int idLlamada = llamada.getIdLlamada();
		int idContacto = llamada.getContacto().getIdContacto();
		String fechaLlamada = llamada.getFechaLlamada();
		String asunto = llamada.getAsunto();
		String notas = llamada.getNotas();

		String query = "INSERT INTO  Llamadas (IdLlamada,IdContacto,"
				+ "FechaLlamada,Asunto,Notas) VALUES(?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idLlamada);
			pstmt.setInt(2, idContacto);
			pstmt.setString(3, fechaLlamada);
			pstmt.setString(4, asunto);
			pstmt.setString(5, notas);

			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			logger.severe(e.getMessage());
			return false;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.warning(e.getMessage());
				}
			}
		}

	}

	@Override
	public boolean insertTipoContacto(TipoContacto tipoContacto) {

		PreparedStatement pstmt = null;

		int idTipoContacto = tipoContacto.getIdTipoContacto();
		String tipo = tipoContacto.getTipoContacto();

		String query = "INSERT INTO  Tiposdecontacto (IdTipoContacto,TipoContacto) "
				+ "VALUES(?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idTipoContacto);
			pstmt.setString(2, tipo);

			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			logger.severe(e.getMessage());
			return false;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.warning(e.getMessage());
				}
			}
		}
	}

	@Override
	public boolean updateContacto(int id, Contacto contacto) {

		PreparedStatement pstmt = null;

		int idContacto = contacto.getIdContacto();
		String nombre = contacto.getNombre();
		String apellidos = contacto.getApellidos();
		String estimado = contacto.getEstimado();
		String direccion = contacto.getDireccion();
		String ciudad = contacto.getCiudad();
		String prov = contacto.getProv();
		String codPostal = contacto.getCodPostal();
		String region = contacto.getRegion();
		String pais = contacto.getPais();
		String nombreCompania = contacto.getNombreCompania();
		String cargo = contacto.getCargo();
		String telefonoTrabajo = contacto.getTelefonoTrabajo();
		String extensionTrabajo = contacto.getExtensionTrabajo();
		String telefonoMovil = contacto.getTelefonoMovil();
		String numFax = contacto.getNumFax();
		String nomCorreoElectronico = contacto.getNomCorreoElectronico();
		int idTipoContacto = contacto.getTipoContacto().getIdTipoContacto();
		String notas = contacto.getNotas();

		String query = "UPDATE Contactos SET Nombre=?,"
				+ "Apellidos=?,Estimado=?,Direccion=?,Ciudad=?,Prov=?,CodPostal=?,Region=?,"
				+ "Pais=?,NombreCompania=?,Cargo=?,TelefonoTrabajo=?,ExtensionTrabajo=?,"
				+ "TelefonoMovil=?,NumFax=?,NomCorreoElectronico=?,IdTipoContacto=?,Notas=? "
				+ "WHERE IdContacto=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nombre);
			pstmt.setString(2, apellidos);
			pstmt.setString(3, estimado);
			pstmt.setString(4, direccion);
			pstmt.setString(5, ciudad);
			pstmt.setString(6, prov);
			pstmt.setString(7, codPostal);
			pstmt.setString(8, region);
			pstmt.setString(9, pais);
			pstmt.setString(10, nombreCompania);
			pstmt.setString(11, cargo);
			pstmt.setString(12, telefonoTrabajo);
			pstmt.setString(13, extensionTrabajo);
			pstmt.setString(14, telefonoMovil);
			pstmt.setString(15, numFax);
			pstmt.setString(16, nomCorreoElectronico);
			pstmt.setInt(17, idTipoContacto);
			pstmt.setString(18, notas);
			pstmt.setInt(19, idContacto);

			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe(e.getMessage());
			return false;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.warning(e.getMessage());
				}
			}
		}

	}

	@Override
	public boolean updateLlamada(int id, Llamada llamada) {

		PreparedStatement pstmt = null;

		int idLlamada = llamada.getIdLlamada();
		int idContacto = llamada.getContacto().getIdContacto();
		String fechaLlamada = llamada.getFechaLlamada();
		String asunto = llamada.getAsunto();
		String notas = llamada.getNotas();

		String query = "UPDATE Llamadas SET IdContacto=?,"
				+ "FechaLlamada=?,Asunto=?,Notas=? WHERE IdLlamada=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idContacto);
			pstmt.setString(2, fechaLlamada);
			pstmt.setString(3, asunto);
			pstmt.setString(4, notas);
			pstmt.setInt(5, idLlamada);

			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			logger.severe(e.getMessage());
			return false;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.warning(e.getMessage());
				}
			}
		}

	}

	@Override
	public boolean updateTipoContacto(int id, TipoContacto tipoContacto) {

		PreparedStatement pstmt = null;

		int idTipoContacto = tipoContacto.getIdTipoContacto();
		String tipo = tipoContacto.getTipoContacto();

		String query = "UPDATE Tiposdecontacto SET TipoContacto=? WHERE IdTipoContacto=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tipo);
			pstmt.setInt(2, idTipoContacto);

			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			logger.severe(e.getMessage());
			return false;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.warning(e.getMessage());
				}
			}
		}

	}
	
	/**
	 * Uso de patrón de diseño singleton.
	 * 
	 * @return instancia única de la clase.
	 */
	public static FachadaBD getInstance() {
		if (fachadaBD == null) {
			fachadaBD = new FachadaBD();
			return fachadaBD;
		}

		return fachadaBD;
	}
	
	/**
	 * Cierra la conexión y destruye la instancia del objeto.
	 * 
	 * @throws Throwable
	 */
	@Override
	protected void finalize() throws Throwable {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.finalize();
		}
	}

}
