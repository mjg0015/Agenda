/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.util.List;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author alumno
 *
 */
public class FachadaBD implements FachadaPersistente {

	@Override
	public boolean addContacto(Contacto contacto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addLlamada(Llamada llamada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTipoContacto(TipoContacto tipoContacto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Contacto> getContactos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contacto> getContactos(String apellido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Llamada> getLlamadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Llamada> getLlamadas(Contacto contacto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoContacto> getTiposContacto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateContacto(Contacto contacto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLlamada(Llamada llamada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTipoContacto(TipoContacto tipoContacto) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
