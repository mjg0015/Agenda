/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.util.List;

import ubu.lsi.dms.agenda.modelo.*;

/**
 * Interfaz de fachada que permite la persistencia de una aplicación que
 * gestiona los datos de una agenda.
 * 
 * @author mjg0015
 *
 */
public interface FachadaPersistente {

	/**
	 * Inserta un nuevo contacto en la agenda.
	 * 
	 * @param contacto
	 *            Contacto a insertar.
	 * @return si se ha insertado correctamente el contacto.
	 */
	public boolean insertContacto(Contacto contacto);

	/**
	 * Inserta una nueva llamada en la agenda.
	 * 
	 * @param llamada
	 *            Llamada a insertar.
	 * @return si se ha insertado correctamente la llamada.
	 */
	public boolean insertLlamada(Llamada llamada);

	/**
	 * Inserta un nuevo tipo de contacto en la agenda.
	 * 
	 * @param tipoContacto
	 *            Tipo de contacto a insertar.
	 * @return si se ha insertado correctamente el tipo de contacto.
	 */
	public boolean insertTipoContacto(TipoContacto tipoContacto);

	/**
	 * Obtiene todos los contactos.
	 * 
	 * @return Lista de contactos.
	 */
	public List<Contacto> getContactos();

	/**
	 * Obtiene todos los contactos filtrados por apellido.
	 * 
	 * @param apellido
	 *            Apellido como parámetro de filtro.
	 * @return Lista de contactos filtrados por apellido.
	 */
	public List<Contacto> getContactos(String apellido);

	/**
	 * Obtiene todas las llamadas.
	 * 
	 * @return Lista de llamadas.
	 */
	public List<Llamada> getLlamadas();

	/**
	 * Obtiene todas las llamadas filtradas por contacto.
	 * 
	 * @param contacto
	 *            Contacto como parámetro de filtro.
	 * @return Lista de llamadas filtradas por contacto.
	 */
	public List<Llamada> getLlamadas(Contacto contacto);

	/**
	 * Obtiene todos los tipos de contacto.
	 * 
	 * @return Lista de tipos de contacto.
	 */
	public List<TipoContacto> getTiposContacto();

	/**
	 * Actualiza un contacto en la agenda.
	 * 
	 * @param contacto
	 *            Contacto actualizado.
	 * @return si se ha actualizado correctamente el contacto.
	 */
	public boolean updateContacto(int id, Contacto contacto);

	/**
	 * Actualiza una llamada en la agenda.
	 * 
	 * @param llamada
	 *            Llamada actualizada.
	 * @return si se ha actualizado correctamente la llamada.
	 */
	public boolean updateLlamada(int id, Llamada llamada);

	/**
	 * Actualiza un tipo de contacto en la agenda.
	 * 
	 * @param tipoContacto
	 *            Tipo de contacto actualizado.
	 * @return si se ha actualizado correctamente el tipo de contacto.
	 */
	public boolean updateTipoContacto(int id, TipoContacto tipoContacto);

}
