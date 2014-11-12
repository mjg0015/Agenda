/**
 * 
 */
package ubu.lsi.dms.agenda.persistencia;

/**
 * @author alumno
 *
 */
public class FabricaBin implements FabricaPersistencia {
	private static FabricaBin fabricaBin = null;

	private FabricaBin (){
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ubu.lsi.dms.agenda.persistencia.FabricaPersistencia#crearFachadaPersistente
	 * ()
	 */
	@Override
	public FachadaPersistente crearFachadaPersistente() {
		return FachadaBin.getInstance();
	}
	public static FabricaBin getInstance(){
		if(fabricaBin == null){
			fabricaBin = new FabricaBin();
		}
		return fabricaBin;
	}
}
