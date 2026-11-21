package ej02;

import ej01.RecursoCompartido;

public class HebraLectora extends Thread{
	
	private final RecursoCompartido recurso1;
	private final RecursoCompartido recurso2;
	private final String nombre;
	
	public HebraLectora(RecursoCompartido recurso1, RecursoCompartido recurso2, String nombre){
		this.recurso1 = recurso1;
		this.recurso2 = recurso2;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		try {
			if(Math.random() < 0.5) { //Intenta leer ambos recursos en un orden aleatorio
				recurso1.leer(nombre + "(R1)");
				recurso2.leer(nombre + "(R2)");
			}else {
				recurso2.leer(nombre + "(R2)");
				recurso1.leer(nombre + "(R1)");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
