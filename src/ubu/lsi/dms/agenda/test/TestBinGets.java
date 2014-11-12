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
public class TestBinGets {

	FabricaPersistencia fabricaBin = FabricaBin.getInstance();
	FachadaPersistente fachadaBinaria = fabricaBin.crearFachadaPersistente();

	/**
	 * Coprobamos si pasando un apellido nos devuelve todos los contactos que
	 * coincidan con ese apellido
	 * 
	 */
	@Test
	public void testGetContactosPorApellido() {

		List<Contacto> listaContantoTrue = new ArrayList<Contacto>();
		List<Contacto> listaContantoPrueba = null;

		String apellido = new String("Pereiro");
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
		listaContantoTrue.add(contacto1);
		listaContantoTrue.add(contacto2);

		listaContantoPrueba = fachadaBinaria.getContactos(apellido);

		System.out.println("Prueba");
		System.out.println(listaContantoPrueba.toString());
		System.out.println("Verdadero");
		System.out.println(listaContantoTrue.toString());

		assertTrue(listaContantoPrueba.toString().equals(
				listaContantoTrue.toString()));

	}

	/**
	 * Este test comprueba que te devuelve las llamadas que tienen un
	 * determinado contacto
	 */
	@Test
	public void testGetLlamadas() {
		List<Llamada> testLlamadas = null;
		List<Llamada> testLlamadasTrue = new ArrayList<Llamada>();

		Contacto contacto2 = new Contacto(2, "Benito", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));
		Llamada llamada2 = new Llamada(2, contacto2, "23-04-2015",
				"arreglando bugs", "tranquilamente");
		testLlamadasTrue.add(llamada2);
		testLlamadas = fachadaBinaria.getLlamadas(contacto2);

		assertTrue(testLlamadasTrue.equals(testLlamadas));

	}

}
