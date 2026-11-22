package ej04;

public class Monitor {
	
	//Recurso compartido
	private final int TAMANIO = 10;
	private int[] buffer = new int[TAMANIO];
	
	private boolean editandoBuffer = false;
	
	//PRODUCCIÓN
	
	public void producir(String nombreProductor) {
		
	}
	
	private synchronized void accesoProducir(String nombreProductor) {
		while(editandobuffer || )
	}

}
