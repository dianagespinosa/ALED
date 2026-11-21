package ej02;

import ej01.RecursoCompartido;

public class HebraEscritora extends Thread {
	
	private final RecursoCompartido recurso1;
	private final RecursoCompartido recurso2;
	private final String nombre;
	
	public HebraEscritora(RecursoCompartido recurso1,RecursoCompartido recurso2, String nombre) {
		this.recurso1 = recurso1;
		this.recurso2 = recurso2;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		try { //Intenta escribir en UNO de los recursos
			if(Math.random() < 0.5) {
				recurso1.escribir(nombre + "(R1)");
			}else {
				recurso2.escribir(nombre + "(R2)");
			}
			//Intenta escribir en el recurso
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
