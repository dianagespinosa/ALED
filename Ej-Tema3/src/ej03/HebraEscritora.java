package ej03;

public class HebraEscritora extends Thread{
	
	private final RecursoCompartido recurso;
	private final String nombre;
	private final Prioridad p;
	
	public HebraEscritora(RecursoCompartido recurso, String nombre, Prioridad p) {
		this.recurso = recurso;
		this.nombre = nombre;
		this.p = p;
	}
	
	@Override
	public void run() {
		try { //Intenta escribir en el recurso
			recurso.escribir(nombre,p);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
