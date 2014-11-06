package ubu.lsi.dms.agenda.modelo;

import java.io.Serializable;

/**
 * Clase de entidad con la información de Contactos
 * 
 * @author Carlos López
 *
 */
@SuppressWarnings("serial")
public class Contacto implements Serializable {
	private int idContacto;

	private String nombre, apellidos, estimado, direccion, ciudad, prov,
			codPostal, region, pais, nombreCompania, cargo, telefonoTrabajo,
			extensionTrabajo, telefonoMovil, numFax, nomCorreoElectronico,
			notas;

	private TipoContacto tipoContacto;

	public Contacto(int idContacto, String nombre, String apellidos,
			String estimado, String direccion, String ciudad, String prov,
			String codPostal, String region, String pais,
			String nombreCompania, String cargo, String telefonoTrabajo,
			String extensionTrabajo, String telefonoMovil, String numFax,
			String nomCorreoElectronico, String notas, TipoContacto tipoContacto) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.estimado = estimado;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.prov = prov;
		this.codPostal = codPostal;
		this.region = region;
		this.pais = pais;
		this.nombreCompania = nombreCompania;
		this.cargo = cargo;
		this.telefonoTrabajo = telefonoTrabajo;
		this.extensionTrabajo = extensionTrabajo;
		this.telefonoMovil = telefonoMovil;
		this.numFax = numFax;
		this.nomCorreoElectronico = nomCorreoElectronico;
		this.notas = notas;
		this.tipoContacto = tipoContacto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (idContacto != other.idContacto)
			return false;
		return true;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getCargo() {
		return cargo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getEstimado() {
		return estimado;
	}

	public String getExtensionTrabajo() {
		return extensionTrabajo;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public String getNomCorreoElectronico() {
		return nomCorreoElectronico;
	}

	public String getNotas() {
		return notas;
	}

	public String getNumFax() {
		return numFax;
	}

	public String getPais() {
		return pais;
	}

	public String getProv() {
		return prov;
	}

	public String getRegion() {
		return region;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public String getTelefonoTrabajo() {
		return telefonoTrabajo;
	}

	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idContacto;
		return result;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setEstimado(String estimado) {
		this.estimado = estimado;
	}

	public void setExtensionTrabajo(String extensionTrabajo) {
		this.extensionTrabajo = extensionTrabajo;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public void setNomCorreoElectronico(String nomCorreoElectronico) {
		this.nomCorreoElectronico = nomCorreoElectronico;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public void setNumFax(String numFax) {
		this.numFax = numFax;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public void setTelefonoTrabajo(String telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", estimado=" + estimado
				+ ", direccion=" + direccion + ", ciudad=" + ciudad + ", prov="
				+ prov + ", codPostal=" + codPostal + ", region=" + region
				+ ", pais=" + pais + ", nombreCompania=" + nombreCompania
				+ ", cargo=" + cargo + ", telefonoTrabajo=" + telefonoTrabajo
				+ ", extensionTrabajo=" + extensionTrabajo + ", telefonoMovil="
				+ telefonoMovil + ", numFax=" + numFax
				+ ", nomCorreoElectronico=" + nomCorreoElectronico + ", notas="
				+ notas + ", tipoContacto=" + tipoContacto + "]";
	}

}
