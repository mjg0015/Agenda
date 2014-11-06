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
import java.util.logging.Logger;

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
    private Logger logger = Logger.getLogger("ubu.lsi.dms.agenda.persistencia");
    
	
	@Override
	public boolean addContacto(Contacto contacto) {
		 try {
			fos = new FileOutputStream("/binarios/contactos.dat");
			salida = new ObjectOutputStream(fos);
			salida.writeObject(contacto);
			return true;			
		} catch (FileNotFoundException e1) {
			logger.severe(e1.getMessage());
			e1.printStackTrace();
			return false;	
		}
         catch (IOException e) {
        	 logger.severe(e.getMessage());
			e.printStackTrace();
			return false;	
		}
		 finally{
			 try{
				 if(fos!=null) 
					 fos.close();
				 if(salida!=null)
					 salida.close(); 
			 }
			 catch(IOException e){
				 System.out.println(e.getMessage());
			 }
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
			 logger.severe(e1.getMessage());
			e1.printStackTrace();
			return false;	
		}
        catch (IOException e) {
        	 logger.severe(e.getMessage());
			e.printStackTrace();
			return false;	
		}
		 finally{
			 try{
				 if(fos!=null) 
					 fos.close();
				 if(salida!=null)
					 salida.close(); 
			 }
			 catch(IOException e){
				 logger.severe(e.getMessage());
			 }
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
			 logger.severe(e1.getMessage());
			e1.printStackTrace();
			return false;	
		}
        catch (IOException e) {
        	 logger.severe(e.getMessage());
			e.printStackTrace();
			return false;	
		}
		 finally{
			 try{
				 if(fos!=null) 
					 fos.close();
				 if(salida!=null)
					 salida.close(); 
			 }
			 catch(IOException e){
				 logger.severe(e.getMessage());
			 }
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
			while(contacto!= null){
				contacto = (Contacto) entrada.readObject();
				listaContactos.add(contacto);
			}
		}
		catch (ClassNotFoundException e) {
			 logger.severe(e.getMessage());
				e.printStackTrace();
		} catch (FileNotFoundException e) {
			 logger.severe(e.getMessage());
			e.printStackTrace();
		}
        catch (IOException e) {
        	 logger.severe(e.getMessage());
			e.printStackTrace();
		}
		 finally{
			 try{
				 if(fis!=null) 
					 fis.close();
				 if(entrada!=null)
					 entrada.close(); 
			 }
			 catch(IOException e){
				 logger.severe(e.getMessage());
			 }
		 }	
		return listaContactos;
	}

	@Override
	public List<Contacto> getContactos(String apellido) {
		//TODO
		List<Contacto> listaContactos = new ArrayList<Contacto>();
		Contacto contacto = null;
		try {
			fis = new FileInputStream("/ficheros/personas.dat");
			entrada = new ObjectInputStream(fis);
			contacto = (Contacto) entrada.readObject();
			if(apellido.equals(contacto.getApellidos())){
				listaContactos.add(contacto);
			}
			while(contacto!= null){
				contacto = (Contacto) entrada.readObject();
				if(apellido.equals(contacto.getApellidos())){
					listaContactos.add(contacto);
				}
			}
		}
		catch (ClassNotFoundException e) {
			 logger.severe(e.getMessage());
				e.printStackTrace();
		} catch (FileNotFoundException e) {
			 logger.severe(e.getMessage());
			e.printStackTrace();
		}
        catch (IOException e) {
        	 logger.severe(e.getMessage());
			e.printStackTrace();
		}
		 finally{
			 try{
				 if(fis!=null) 
					 fis.close();
				 if(entrada!=null)
					 entrada.close(); 
			 }
			 catch(IOException e){
				 logger.severe(e.getMessage());
			 }
		 }	
		return listaContactos;
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
		List<TipoContacto> listaTipos = new ArrayList<TipoContacto>();
		TipoContacto tipo = null;
		try {
			fis = new FileInputStream("/ficheros/personas.dat");
			entrada = new ObjectInputStream(fis);
			tipo = (TipoContacto) entrada.readObject();
			listaTipos.add(tipo);
			while(tipo!= null){
				tipo = (TipoContacto) entrada.readObject();
				listaTipos.add(tipo);
			}
		}
		catch (ClassNotFoundException e) {
			 logger.severe(e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			 logger.severe(e.getMessage());
			e.printStackTrace();
		}
        catch (IOException e) {
        	 logger.severe(e.getMessage());
			e.printStackTrace();
		}
		 finally{
			 try{
				 if(fis!=null) 
					 fis.close();
				 if(entrada!=null)
					 entrada.close(); 
			 }
			 catch(IOException e){
				 logger.severe(e.getMessage());
			 }
		 }
		return listaTipos;
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
