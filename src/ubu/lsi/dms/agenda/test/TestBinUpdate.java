package ubu.lsi.dms.agenda.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FabricaBin;
import ubu.lsi.dms.agenda.persistencia.FabricaPersistencia;
import ubu.lsi.dms.agenda.persistencia.FachadaPersistente;

/**
 * 
 * @author David López Santamaría
 * @author Álvaro Pérez Delgado
 *
 */
public class TestBinUpdate {

	FabricaPersistencia fabricaBin = FabricaBin.getInstance();
	FachadaPersistente fachadaBinaria = fabricaBin.crearFachadaPersistente();

	/**
	 * Coprobamos si un contacto se puede actualizar, es decir ser sustituido
	 * por otro a traves de id
	 * 
	 */
	@Test
	public void testUpdateContacto() {

		List<Contacto> listaContactosTest = new ArrayList<Contacto>();
		List<Contacto> listaContactosBinActulizado = new ArrayList<Contacto>();
		int index = 2;
		listaContactosTest = fachadaBinaria.getContactos();

		Contacto contactoActualizado = new Contacto(1, "Pepito", "Grillo",
				"don", "C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));

		listaContactosTest.add(index, contactoActualizado);
		listaContactosTest.remove(index + 1);

		fachadaBinaria.updateContacto(index, contactoActualizado);
		listaContactosBinActulizado = fachadaBinaria.getContactos();

		assertTrue(listaContactosBinActulizado.toString().equals(
				listaContactosTest.toString()));
	}

	/**
	 * Coprobamos si una llamada se puede actualizar, es decir ser sustituida
	 * por otra a traves de id
	 * 
	 */

	@Test
	public void testUpdateLlamada() {

		List<Llamada> listaLlamadasTest = new ArrayList<Llamada>();
		List<Llamada> listaLlamadasBinActualizado = new ArrayList<Llamada>();
		int index = 2;
		Contacto contacto1 = new Contacto(1, "Andres", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));

		listaLlamadasTest = fachadaBinaria.getLlamadas();

		Llamada llamadaActualizada = new Llamada(4, contacto1, "25-04-2015",
				"arreglando bugs por la tarde", "tranquilamente");

		listaLlamadasTest.add(index, llamadaActualizada);
		listaLlamadasTest.remove(index + 1);

		fachadaBinaria.updateLlamada(index, llamadaActualizada);
		listaLlamadasBinActualizado = fachadaBinaria.getLlamadas();

		assertTrue(listaLlamadasBinActualizado.toString().equals(
				listaLlamadasTest.toString()));
	}

	/**
	 * Coprobamos si un tipoContacto se puede actualizar, es decir ser
	 * sustituido por otro a traves de id
	 * 
	 */
	@Test
	public void testUpdateTipoContacto() {

		List<TipoContacto> listaTipoContactosTest = new ArrayList<TipoContacto>();
		List<TipoContacto> listaTipoContactosBinActualizado = new ArrayList<TipoContacto>();
		int index = 2;

		listaTipoContactosTest = fachadaBinaria.getTiposContacto();

		TipoContacto tipoContactoActualizado = new TipoContacto(2, "Familia");

		listaTipoContactosTest.add(index, tipoContactoActualizado);
		listaTipoContactosTest.remove(index + 1);

		fachadaBinaria.updateTipoContacto(index, tipoContactoActualizado);
		listaTipoContactosBinActualizado = fachadaBinaria.getTiposContacto();

		assertTrue(listaTipoContactosBinActualizado.toString().equals(
				listaTipoContactosTest.toString()));
	}

}
