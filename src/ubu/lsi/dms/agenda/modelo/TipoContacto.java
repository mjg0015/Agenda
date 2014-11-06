package ubu.lsi.dms.agenda.modelo;

import java.io.Serializable;

/**
 * Clase de entidad con la información de TipodeContacto
 * 
 * @author Carlos López
 *
 */
@SuppressWarnings("serial")
public class TipoContacto implements Serializable {
	private int idTipoContacto;
	private String TipoContacto;

	public TipoContacto(int idTipoContacto, String tipoContacto) {
		super();
		this.idTipoContacto = idTipoContacto;
		TipoContacto = tipoContacto;
	}

	public int getIdTipoContacto() {
		return idTipoContacto;
	}

	public String getTipoContacto() {
		return TipoContacto;
	}

	public void setIdTipoContacto(int idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		TipoContacto = tipoContacto;
	}

	@Override
	public String toString() {
		return "TipoContacto [idTipoContacto=" + idTipoContacto
				+ ", TipoContacto=" + TipoContacto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoContacto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoContacto other = (TipoContacto) obj;
		if (idTipoContacto != other.idTipoContacto)
			return false;
		return true;
	}
	
	

}
