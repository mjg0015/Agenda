/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author David López Santamaría
 * @author Álvaro Pérez Delgado
 * @version 1.0
 */
public class FachadaBin implements FachadaPersistente {
	static FachadaBin fachadaBin = null;
	static final String RUTA_ARCHIVO_CONTACTO = "./binarios/contactos.dat";
	static final String RUTA_ARCHIVO_LLAMADAS = "./binarios/llamadas.dat";
	static final String RUTA_ARCHIVO_TIPOS = "./binarios/tipos.dat";
	private Logger logger = Logger.getLogger("ubu.lsi.dms.agenda.persistencia");

	@Override
	public boolean insertContacto(Contacto contacto) {
		File archivo = new File(RUTA_ARCHIVO_CONTACTO);
		//Creamos una lista en la que guardaremos todos los contactos
		List<Contacto> listaAuxiliar = new ArrayList<Contacto>();
		try {
			if (archivo.exists()) {
				// si existe el archivo recuperamos los contactos que tiene
				listaAuxiliar = this.getContactos();
			}
			// añadimos a la lista(o bien vacia o bien con los datos del .dat),
			// el contacto que nos pasan
			listaAuxiliar.add(contacto);
			// utilizamos el metodo que inserta en un fichero una lista en
			// la ruta que digamos
			insertAll(listaAuxiliar, RUTA_ARCHIVO_CONTACTO);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean insertLlamada(Llamada llamada) {
		File archivo = new File(RUTA_ARCHIVO_LLAMADAS);
		//Creamos una lista en la que guardaremos todos los contactos
		List<Llamada> listaAuxiliar = new ArrayList<Llamada>();
		try {
			if (archivo.exists()) {
				listaAuxiliar = this.getLlamadas();
			}
			listaAuxiliar.add(llamada);
			// utilizamos el metodo que inserta en un fichero toda la lista en
			// la ruta que digamos
			insertAll(listaAuxiliar, RUTA_ARCHIVO_LLAMADAS);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean insertTipoContacto(TipoContacto tipoContacto) {
		File archivo = new File(RUTA_ARCHIVO_TIPOS);
		List<TipoContacto> listaAuxiliar = new ArrayList<TipoContacto>();
		try {
			if (archivo.exists()) {
				listaAuxiliar = this.getTiposContacto();

			}
			listaAuxiliar.add(tipoContacto);

			// utilizamos el metodo que inserta en un fichero toda la lista en
			// la ruta que digamos
			insertAll(listaAuxiliar, RUTA_ARCHIVO_TIPOS);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Contacto> getContactos() {
		File archivo = new File(RUTA_ARCHIVO_CONTACTO);
		List<Contacto> listaContactos = new ArrayList<Contacto>();
		Contacto contacto = null;

		try (ObjectInputStream entrada = new ObjectInputStream(
				new FileInputStream(archivo));) {
			if (archivo.exists()) {
				contacto = (Contacto) entrada.readObject();
				listaContactos.add(contacto);
				while (contacto != null) {
					contacto = (Contacto) entrada.readObject();
					listaContactos.add(contacto);
				}
			}
		} catch (EOFException e1) {
			System.out.println("Fin de fichero");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return listaContactos;
	}

	@Override
	public List<Contacto> getContactos(String apellido) {
		File archivo = new File(RUTA_ARCHIVO_CONTACTO);
		List<Contacto> listaContactos = new ArrayList<Contacto>();
		Contacto contacto = null;

		try (ObjectInputStream entrada = new ObjectInputStream(
				new FileInputStream(archivo));) {
			if (archivo.exists()) {
				contacto = (Contacto) entrada.readObject();
				if (apellido.equals(contacto.getApellidos())) {
					listaContactos.add(contacto);
				}
				while (contacto != null) {
					contacto = (Contacto) entrada.readObject();
					if (apellido.equals(contacto.getApellidos())) {
						listaContactos.add(contacto);
					}
				}
			}
		} catch (EOFException e1) {
			System.out.println("Fin de fichero");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return listaContactos;
	}

	@Override
	public List<Llamada> getLlamadas() {
		File archivo = new File(RUTA_ARCHIVO_LLAMADAS);
		List<Llamada> listaContactos = new ArrayList<Llamada>();
		Llamada llamada = null;

		try (ObjectInputStream entrada = new ObjectInputStream(
				new FileInputStream(archivo));) {
			if (archivo.exists()) {
				llamada = (Llamada) entrada.readObject();
				listaContactos.add(llamada);
				while (llamada != null) {
					llamada = (Llamada) entrada.readObject();
					listaContactos.add(llamada);
				}
			}
		} catch (EOFException e1) {
			System.out.println("Fin de fichero");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return listaContactos;
	}

	@Override
	public List<Llamada> getLlamadas(Contacto contacto) {
		List<Llamada> listaLlamadas = new ArrayList<Llamada>();
		List<Llamada> listaLlamadasContacto = new ArrayList<Llamada>();

		Llamada llamada = null;

		listaLlamadas=this.getLlamadas();
		
		for(Llamada c : listaLlamadas){
			llamada=c;
			if (llamada.getContacto().equals(contacto)){
				listaLlamadasContacto.add(llamada);
			}
		}
		System.out.println(listaLlamadasContacto);
		return listaLlamadasContacto;
	}

	@Override
	public List<TipoContacto> getTiposContacto() {
		File archivo = new File(RUTA_ARCHIVO_TIPOS);
		List<TipoContacto> listaTiposContactos = new ArrayList<TipoContacto>();
		TipoContacto tipoContacto = null;

		try (ObjectInputStream entrada = new ObjectInputStream(
				new FileInputStream(archivo));) {
			if (archivo.exists()) {
				tipoContacto = (TipoContacto) entrada.readObject();
				listaTiposContactos.add(tipoContacto);
				while (tipoContacto != null) {
					tipoContacto = (TipoContacto) entrada.readObject();
					listaTiposContactos.add(tipoContacto);
				}
			}
		} catch (EOFException e1) {
			System.out.println("Fin de fichero");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return listaTiposContactos;
	}

	@Override
	public boolean updateContacto(int id, Contacto contacto) {
		List<Contacto> listaTemporal = new ArrayList<Contacto>();
		listaTemporal = getContactos();
		listaTemporal.add(id, contacto);
		listaTemporal.remove(id + 1);

		insertAll(listaTemporal, RUTA_ARCHIVO_CONTACTO);

		return true;
	}

	@Override
	public boolean updateLlamada(int id, Llamada llamada) {
		List<Llamada> listaTemporal = new ArrayList<Llamada>();
		listaTemporal = getLlamadas();
		listaTemporal.add(id, llamada);
		listaTemporal.remove(id + 1);

		insertAll(listaTemporal, RUTA_ARCHIVO_LLAMADAS);

		return true;
	}

	@Override
	public boolean updateTipoContacto(int id, TipoContacto tipoContacto) {
		List<TipoContacto> listaTemporal = new ArrayList<TipoContacto>();
		listaTemporal = getTiposContacto();
		listaTemporal.add(id, tipoContacto);
		listaTemporal.remove(id + 1);

		insertAll(listaTemporal, RUTA_ARCHIVO_TIPOS);

		return true;
	}

	/**
	 * Constructor Singleton de la clase
	 * 
	 * @return fachadaBin
	 */
	public static FachadaBin getInstance() {
		if (fachadaBin == null) {
			fachadaBin = new FachadaBin();
		}
		return fachadaBin;
	}

	/**
	 * Este metodo añade a un archivo .dat el contenido de una lista
	 * 
	 * @param lista
	 * @param RUTA_ARCHIVO
	 */
	public <E> void insertAll(List<E> lista, String RUTA_ARCHIVO) {

		File archivo = new File(RUTA_ARCHIVO);

		try (ObjectOutputStream salida = new ObjectOutputStream(
				new FileOutputStream(archivo));) {
			for (E c : lista) {
				salida.writeObject(c);
			}
		} catch (IOException e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
		}
	}

}
