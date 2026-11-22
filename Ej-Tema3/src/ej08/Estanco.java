package ej08;

public class Estanco {
	
	private int ingrediente = -1; //Vale 0 -> tabaco; 1 -> papel; 2 -> cerilla; -1 -> mesa vacía
	private boolean fumando = false;
	
	public synchronized void ponerIngrediente(int ingredienteQuePone) {
		try {
		while(ingrediente != -1 || fumando) {
			System.out.println("...Estanquero espera.");
			wait();
		}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		ingrediente = ingredienteQuePone;
		System.out.println(">>>Estanquero ha repuesto (Ingrediente que pone: " + ingredienteQuePone + ").");
		notifyAll();
	}
	
	public synchronized int cogerIngredientes(int idFumador) {
		try {
		while(ingrediente == -1 || ingrediente == idFumador) {
			System.out.println("...Fumador-" + idFumador + " espera.");
			wait();
		}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		int cogido = ingrediente;
		ingrediente = -1;
		fumando = true;
		System.out.println(">>>Fumador-" + idFumador + " coge ingredientes.");
		notifyAll();
		
		return cogido;
	}
	
	public synchronized void terminarDeFumar(int idFumador) {
		fumando = false;
		System.out.println("<<<Fumador-" + idFumador + " termina de fumar.");
		notifyAll();
	}
	
	public synchronized void darIngrediente(int idFumador, int ingredienteCogido) {
		int compa = 3-idFumador-ingredienteCogido;
		System.out.println("Fumador-" + idFumador + " pide el ingrediente a Fumador-" + compa);
		
		
	}

}
