package ej01;

public class HebraLectora extends Thread{
	
	private final RecursoCompartido recurso;
	private final String nombre;
	
	public HebraLectora(RecursoCompartido recurso, String nombre){
		this.recurso = recurso;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		try { //Intenta leer el recurso
			recurso.leer(nombre);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
