package ej07;

public class Estanco {
	
	private int falta = -1; //Vale 0 -> tabaco; 1 -> papel; 2 -> cerilla; -1 -> mesa vacía
	private boolean fumando = false;
	
	public synchronized void ponerIngredientes(int ingredienteQueFalta) {
		try {
		while(falta != -1 || fumando) {
			System.out.println("...Estanquero espera.");
			wait();
		}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		falta = ingredienteQueFalta;
		System.out.println(">>>Estanquero ha repuesto (Ingrediente que falta: " + ingredienteQueFalta + ").");
		notifyAll();
	}
	
	public synchronized void cogerIngredientes(int idFumador) {
		try {
		while(falta != idFumador) {
			System.out.println("...Fumador-" + idFumador + " espera.");
			wait();
		}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		falta = -1;
		fumando = true;
		System.out.println(">>>Fumador-" + idFumador + " coge ingredientes.");
		notifyAll();
	}
	
	public synchronized void terminarDeFumar() {
		fumando = false;
		System.out.println("<<<Fumador-" + Thread.currentThread().getName() + " termina de fumar.");
		notifyAll();
	}

}
