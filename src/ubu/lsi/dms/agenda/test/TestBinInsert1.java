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
public class TestBinInsert1 {

	FabricaPersistencia fabricaBin = FabricaBin.getInstance();
	FachadaPersistente fachadaBinaria = fabricaBin.crearFachadaPersistente();

	/**
	 * En este test conprobamos si 4 contactos que creamos se insertan en un
	 * archivo.dat y comparamos lo que se obtiene del archivo.dat y una lista
	 * creada con esos datos
	 * 
	 */

	@Test
	public void testInsertContacto() {

		List<Contacto> listaContactosTest = new ArrayList<Contacto>();

		Contacto contacto1 = new Contacto(1, "Andres", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));

		Contacto contacto2 = new Contacto(2, "Benito", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));

		Contacto contacto3 = new Contacto(3, "Carlos", "Roldan", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));

		Contacto contacto4 = new Contacto(4, "Daniel", "Ramiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));

		listaContactosTest.add(contacto1);
		listaContactosTest.add(contacto2);
		listaContactosTest.add(contacto3);
		listaContactosTest.add(contacto4);

		fachadaBinaria.insertContacto(contacto1);
		fachadaBinaria.insertContacto(contacto2);
		fachadaBinaria.insertContacto(contacto3);
		fachadaBinaria.insertContacto(contacto4);

		List<Contacto> listaContactosBin = new ArrayList<Contacto>();

		listaContactosBin = fachadaBinaria.getContactos();
		System.out.println("Insertar contactos ");
		System.out.println("Lista contactos del archivo bin");

		System.out.println(listaContactosBin.toString());

		assertTrue(listaContactosBin.toString().equals(
				listaContactosTest.toString()));

	}

	/**
	 * Este Test comprueba que insertar llamadas funciona de la manera correcta
	 * y queda permanentemente.
	 * 
	 */

	@Test
	public void testInsertLlamada() {

		List<Llamada> listaLlamadasTest = new ArrayList<Llamada>();
		Contacto contacto1 = new Contacto(1, "Andres", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));

		Contacto contacto2 = new Contacto(2, "Benito", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));

		Llamada llamada1 = new Llamada(1, contacto1, "22-04-2015",
				"arreglando bugs", "tranquilamente");
		Llamada llamada2 = new Llamada(2, contacto2, "23-04-2015",
				"arreglando bugs", "tranquilamente");
		Llamada llamada3 = new Llamada(3, contacto1, "24-04-2015",
				"arreglando bugs", "tranquilamente");
		Llamada llamada4 = new Llamada(4, contacto1, "25-04-2015",
				"arreglando bugs", "tranquilamente");

		listaLlamadasTest.add(llamada1);
		listaLlamadasTest.add(llamada2);
		listaLlamadasTest.add(llamada3);
		listaLlamadasTest.add(llamada4);

		fachadaBinaria.insertLlamada(llamada1);
		fachadaBinaria.insertLlamada(llamada2);
		fachadaBinaria.insertLlamada(llamada3);
		fachadaBinaria.insertLlamada(llamada4);

		List<Llamada> listaLlamadasBin = new ArrayList<Llamada>();
		listaLlamadasBin = fachadaBinaria.getLlamadas();

		assertTrue(listaLlamadasBin.toString().equals(
				listaLlamadasTest.toString()));

	}

	@Test
	public void testInsertTipoContacto() {

		List<TipoContacto> listaTipoContactoTest = new ArrayList<TipoContacto>();
		TipoContacto tipoContacto1 = new TipoContacto(1, "Coleguis");
		TipoContacto tipoContacto2 = new TipoContacto(2, "Uni");
		TipoContacto tipoContacto3 = new TipoContacto(3, "Pueblo");
		TipoContacto tipoContacto4 = new TipoContacto(4, "Trabajo");

		listaTipoContactoTest.add(tipoContacto1);
		listaTipoContactoTest.add(tipoContacto2);
		listaTipoContactoTest.add(tipoContacto3);
		listaTipoContactoTest.add(tipoContacto4);

		fachadaBinaria.insertTipoContacto(tipoContacto1);
		fachadaBinaria.insertTipoContacto(tipoContacto2);
		fachadaBinaria.insertTipoContacto(tipoContacto3);
		fachadaBinaria.insertTipoContacto(tipoContacto4);

		List<TipoContacto> listaTipoContactoBin = new ArrayList<TipoContacto>();
		listaTipoContactoBin = fachadaBinaria.getTiposContacto();

		assertTrue(listaTipoContactoBin.toString().equals(
				listaTipoContactoTest.toString()));

	}

}
