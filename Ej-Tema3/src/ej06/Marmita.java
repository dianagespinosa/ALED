package ej06;

public class Marmita {
	
	private final int n = 10;
	private int raciones = n;
	private boolean cocineroAvisado = false;
	
	public synchronized void comer(String nombreCanibal) {
		//Se pueden dar tres situaciuones:
		//1. La marmita está vacía y el cocinero no ha sido avisado
		//2. La marmita está vacía y el cocinero ya ha sido avisado
		//3. La marmita está llena
		
		if (raciones == 0 && !cocineroAvisado) {
			cocineroAvisado = true; //Marca bandera de que ha avisado
			System.out.println("!!! " + nombreCanibal + " ve la marmita vacía y avisa al cocinero.");
			notifyAll(); //Avisa al cocinero
			
			try {
			while(raciones == 0) { //Espera a que el cocinero rellene
					wait();
				}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			//El cocinero ya terminó: libero el bloqueo de prioridad para los demás
			cocineroAvisado = false;
			
		} else {
			try {
			while(raciones == 0 || cocineroAvisado) {
				System.out.println("..." + nombreCanibal + " espera.");
					wait();
			}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
		}
			//Sección común: comer
			raciones--;
			System.out.println(">>>" + nombreCanibal + " come.");
			notifyAll();
		}
		
		public synchronized void rellenar() {
			try {
			while(!cocineroAvisado) {
					wait();
			}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			raciones = n;
			System.out.println("El cocinero rellena la marmita con " + n + " raciones.");
			notifyAll();
		}

}
