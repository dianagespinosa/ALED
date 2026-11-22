package ej03;

public class HebraLectora extends Thread{
	
	private final RecursoCompartido recurso;
	private final String nombre;
	private final Prioridad p;
	
	public HebraLectora(RecursoCompartido recurso, String nombre, Prioridad p){
		this.recurso = recurso;
		this.nombre = nombre;
		this.p = p;
	}
	
	@Override
	public void run() {
		try { //Intenta leer el recurso
			recurso.leer(nombre,p);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
