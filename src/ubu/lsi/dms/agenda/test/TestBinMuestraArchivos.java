package ubu.lsi.dms.agenda.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import ubu.lsi.dms.agenda.persistencia.FabricaBin;
import ubu.lsi.dms.agenda.persistencia.FabricaPersistencia;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

/**
 * 
 * @author David López Santamaría
 * @author Álvaro Pérez Delgado
 *
 */
public class TestBinMuestraArchivos {

	FabricaPersistencia fabricaBin = FabricaBin.getInstance();
	FachadaPersistente fachadaBinaria = fabricaBin.crearFachadaPersistente();

	/**
	 * Este test sirve unicamente para saber que hay dentro de los ficheros
	 * 
	 */
	@Test
	public void muestraArchivos() {
		List<?> listaArchivos;
		listaArchivos = fachadaBinaria.getContactos();
		System.out.println("Archivo de contactos");
		System.out.println(listaArchivos);
		listaArchivos = fachadaBinaria.getLlamadas();
		System.out.println("Archivo de llamadas");
		System.out.println(listaArchivos);
		listaArchivos = fachadaBinaria.getTiposContacto();
		System.out.println("Archivo de tipos contacto");
		System.out.println(listaArchivos);

		assertTrue(null == null);
	}
}
