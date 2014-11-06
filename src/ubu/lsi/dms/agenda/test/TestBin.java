package ubu.lsi.dms.agenda.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;

import ubu.lsi.dms.agenda.modelo.Contacto;

import ubu.lsi.dms.agenda.modelo.TipoContacto;

import ubu.lsi.dms.agenda.persistencia.FachadaBin;

public class TestBin {

	// Voy a crear un método para probar

	FachadaBin fachadaBinaria = new FachadaBin();

	@Test
	public void testAddContacto() {

		List<Contacto> listaContactosTest = new ArrayList<Contacto>();

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

		listaContactosTest.add(contacto1);

		listaContactosTest.add(contacto2);

		listaContactosTest.add(contacto3);

		listaContactosTest.add(contacto4);

		fachadaBinaria.addContacto(contacto1);

		fachadaBinaria.addContacto(contacto2);

		fachadaBinaria.addContacto(contacto3);

		fachadaBinaria.addContacto(contacto4);

		List<Contacto> listaContactosBin = new ArrayList<Contacto>();

		listaContactosBin = fachadaBinaria.getContactos();

		assertTrue(listaContactosBin.equals(listaContactosTest));

	}

}