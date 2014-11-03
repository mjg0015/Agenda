/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * @author alumno
 *
 */
public class FachadaBin implements FachadaPersistente {
	//lectura
	FileInputStream fis = null;
    ObjectInputStream entrada = null;
	//escritura
	FileOutputStream fos = null;
    ObjectOutputStream salida = null;
    
	
	@Override
	public boolean addContacto(Contacto contacto) {
		 try {
			fos = new FileOutputStream("/binarios/contactos.dat");
			salida = new ObjectOutputStream(fos);
			salida.writeObject(contacto);
			return true;			
		} catch (FileNotFoundException e1) {
			System.err.println("No se encuentra el archivo para guardar");
			e1.printStackTrace();
			return false;	
		}
         catch (IOException e) {
        	 System.err.println("Error entrada salida.");
			e.printStackTrace();
			return false;	
		}
		 	
	}

	@Override
	public boolean addLlamada(Llamada llamada) {
		 try {
			fos = new FileOutputStream("/binarios/llamadas.dat");
			salida = new ObjectOutputStream(fos);
			salida.writeObject(llamada);
			return true;			
		} catch (FileNotFoundException e1) {
			System.err.println("No se encuentra el archivo para guardar");
			e1.printStackTrace();
			return false;	
		}
        catch (IOException e) {
       	 System.err.println("Error entrada salida.");
			e.printStackTrace();
			return false;	
		}
	}

	@Override
	public boolean addTipoContacto(TipoContacto tipoContacto) {
		 try {
			fos = new FileOutputStream("/binarios/tipoContactos.dat");
			salida = new ObjectOutputStream(fos);
			salida.writeObject(tipoContacto);
			return true;			
		} catch (FileNotFoundException e1) {
			System.err.println("No se encuentra el archivo para guardar");
			e1.printStackTrace();
			return false;	
		}
        catch (IOException e) {
       	 System.err.println("Error entrada salida.");
			e.printStackTrace();
			return false;	
		}
	}

	@Override
	public List<Contacto> getContactos() {
		List<Contacto> listaContactos = new ArrayList<Contacto>();
		Contacto contacto = null;
		try {
			fis = new FileInputStream("/ficheros/personas.dat");
			entrada = new ObjectInputStream(fis);
			contacto = (Contacto) entrada.readObject();
			listaContactos.add(contacto);
		}
		catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaContactos;
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
