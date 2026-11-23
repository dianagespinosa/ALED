package ej12;

import java.util.LinkedList;
import java.util.Queue;

public class GestorMuseo {
	
	private final int condicionesNormales = 50; //personas que pueden pasar
	private final int superaTemp = 35; //personas que pueden pasar
	private final int tempMax = 30;
	
	private int capMax = condicionesNormales;
	private int numPersonas = 0;
	
	Queue<Integer> colaPersonas = new LinkedList<>();
	Queue<Integer> colaPersonasJubiladas = new LinkedList<>();
	
	public synchronized void entrarSala(int id) {
		colaPersonas.add(id);
		//Deberá esperar para entrar si:
		//1. numPersonas >= capMax
		//2. No es su turno en la cola
		//3. Hay jubiladas esperando
		try {
		while(numPersonas >= capMax || colaPersonas.peek() != id || !colaPersonasJubiladas.isEmpty()) {
			System.out.println("...Persona-" + id + " espera.");
			wait();
		}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		//Bloque común si entran en sala
		colaPersonas.poll();
		numPersonas++;
		System.out.println(">>>Persona-" + id + " entra al museo.");
		notifyAll();
	}
	
	public synchronized void entrarSalaJubilado(int id) {
		colaPersonasJubiladas.add(id);
		//Deberá esperar para entrar si:
		//1. numPersonas >= capMax
		//2. No es su turno en la cola
		try {
		while(numPersonas >= capMax || colaPersonasJubiladas.peek() != id) {
			System.out.println("...Jubilado-" + id + " espera.");
			wait();
		}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		//Bloque común si entra en sala
		colaPersonasJubiladas.poll();
		numPersonas++;
		System.out.println(">>>Jubilado-" + id + " entra al museo.");
		notifyAll();
	}
	
	public synchronized void salirSala(int id) {
		numPersonas--;
		System.out.println("<<<Persona/Jubilado-" + id + " sale del museo.");
		notifyAll();
	}
	
	public synchronized void notificarTemperatura(int temperatura) {
		if(temperatura > tempMax) {
			capMax = superaTemp;
		}else {
			capMax = condicionesNormales;
			notifyAll();
		}
	}

}
