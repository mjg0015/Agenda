package ubu.lsi.dms.agenda.test;

import static org.junit.Assert.*;


import org.junit.Test;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.TipoContacto;
import ubu.lsi.dms.agenda.persistencia.FachadaBin;

public class TestBin {

	// Voy a crear un método para probar
	FachadaBin fachadaBinaria = new FachadaBin();

	@Test
	public void testAddContacto() {

		Contacto contacto1 = new Contacto(1, "Oscar", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));
		Contacto contacto2 = new Contacto(2, "Oscar", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));
		Contacto contacto3 = new Contacto(3, "Oscar", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));
		Contacto contacto4 = new Contacto(4, "Oscar", "Pereiro", "don",
				"C/ sin nombre", "Burgos", "Burgos", "09006",
				"Castilla y leon", "España", "apple", "Jefe", "660660550",
				"+34", "555", "343343", "es majo", null, new TipoContacto(1,
						"tipo"));
		
		fachadaBinaria.addContacto(contacto1);
		//Contacto contacto11 = fachadaBinaria.getContacto(1);
		//assertTrue(contacto1.equals(contacto11));
	}

}
