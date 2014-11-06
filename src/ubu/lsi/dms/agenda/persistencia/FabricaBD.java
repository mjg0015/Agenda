/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

/**
 * @author alumno
 *
 */
public class FabricaBD implements FabricaPersistencia {
	
	private static FabricaBD fabricaBD = null;
	
	private FabricaBD(){
		
	}

	/* (non-Javadoc)
	 * @see ubu.lsi.dms.agenda.persistencia.FabricaPersistencia#crearFachadaPersistente()
	 */
	@Override
	public FachadaPersistente crearFachadaPersistente() {
		return FachadaBD.getInstance();
	}
	
	// Singleton
	public static FabricaBD getInstance(){
		if(fabricaBD == null){
			fabricaBD = new FabricaBD();
		}
		
		return fabricaBD;
	}

}
