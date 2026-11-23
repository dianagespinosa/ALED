package ej09;

import java.util.LinkedList;
import java.util.Queue;

public class Hacienda {
	
	//Indica si se está atendiendo en las ventanillas
	private boolean puedePasarV1 = false;
	private boolean puedePasarV2 = false;
	
	//Colas en cada ventanilla
	private Queue<Thread> esperaV1 = new LinkedList<>();
	private Queue<Thread> esperaV2 = new LinkedList<>();
	
	public synchronized void esperarVentanilla1() {
		Thread yo = Thread.currentThread();
		esperaV1.add(yo);
		if(esperaV1.size() + esperaV2.size() == 1) {
			notifyAll();
		}
		try {
		while(!puedePasarV1 || yo != esperaV1.peek()) {
			System.out.println("Ciudadano-" + yo.getName() + " espera en Ventanilla 1");
			wait();
		}
		}catch (InterruptedException e){
			Thread.currentThread().interrupt();	
		}
		esperaV1.poll();
		puedePasarV1 = false;
		System.out.println("Ciudadano-" + yo.getName() + " atendido en la Ventanilla 1.");
		notifyAll();
	}
	
	public synchronized void esperarVentanilla2() {
		Thread yo = Thread.currentThread();
		esperaV2.add(yo);
		if(esperaV1.size() + esperaV2.size() == 1) {
			notifyAll();
		}
		try {
		while(!puedePasarV2 || yo != esperaV2.peek()) {
			System.out.println("Ciudadano-" + yo.getName() + " espera en Ventanilla 2.");
			wait();
		}
		}catch (InterruptedException e){
			Thread.currentThread().interrupt();	
		}
		esperaV2.poll();
		puedePasarV2 = false;
		System.out.println("Ciudadano-" + yo.getName() + " atendido en la Ventanilla 2.");
		notifyAll();
	}
	
	public synchronized void atenderCiudadano() {
		try {
		while(esperaV1.isEmpty() && esperaV2.isEmpty() || puedePasarV1 || puedePasarV2) {
			System.out.println("Andrés está esperando al siguiente ciudadano.");
			wait();
		}
		}catch (InterruptedException e){
			Thread.currentThread().interrupt();
		}
		if(esperaV1.size() >= esperaV2.size()) {
			puedePasarV1 = true;
			notifyAll();
		} else {
			puedePasarV2 = true;
			notifyAll();
		}
		
	}

}
