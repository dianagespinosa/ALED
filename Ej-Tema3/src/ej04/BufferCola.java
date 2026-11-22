package ej04;

import java.util.LinkedList;
import java.util.Queue;

public class BufferCola {
	
	//Recurso compartido
	private final int TAMANIO = 10;
	private int[] buffer = new int[TAMANIO];
	
	//Punteros para gestionar el buffer como una cola circular
	private int entrada = 0;
	private int salida = 0;
	private int cantidad = 0;
	
	//Listas de espera
	private Queue<Thread> esperaProductores = new LinkedList<>();
	private Queue<Thread> esperaConsumidores = new LinkedList<>();
	
	//PRODUCCIÓN
	public synchronized void producir(int dato) {
		Thread yo = Thread.currentThread();
		esperaProductores.add(yo); //Se añade a la cola de productores
		
		try {
		//Condición de espera:
		//1. El buffer está lleno
		//2. No soy el primero en la cola de productores
		while(esperaProductores.peek() != yo || cantidad == TAMANIO) {
				wait();
		}
		//Sección Crítica: insertar dato
		esperaProductores.poll(); //Sale de la cola de espera
		buffer[entrada] = dato;
		entrada = (entrada + 1) % TAMANIO; //Para que el índice de entrada esté siempre entre 0 y 9
		cantidad++;
		
		System.out.println(">>>Productor inserta: " + dato + " (Datos en buffer: " + cantidad + ")");
		
		//Notificar a todos para que el siguiente productor o consumidor evalúe su condición
		notifyAll();
		
			} catch (InterruptedException e) {
				esperaProductores.remove(yo);
				notifyAll();
			}
		}
	
	//CONSUMICIÓN´
	public synchronized int consumir() throws InterruptedException {
		Thread yo = Thread.currentThread();
		esperaConsumidores.add(yo);
		
		try {
		//Condición de espera:
		//1. El buffer está vacío
		//2. No soy el primero en la cola de consumidores
		while(esperaConsumidores.peek() != yo || cantidad == 0) {
				wait();
		}
		
		//Sección Crítica: extraer dato
		esperaConsumidores.poll(); //Sale de la cola de espera
		int dato = buffer[salida];
		salida = (salida + 1) % TAMANIO;
		cantidad--;
		
		System.out.println("<<<Consumidor extrae: " + dato + " (Datos en buffer: " + cantidad + ")");
		
		//Notificar a todos para que el siguiente productor o consumidor evalúe su condición
		notifyAll();
		return dato;
		
			} catch (InterruptedException e) {
				esperaConsumidores.remove(yo);
				notifyAll();
				throw e;
			}
	}
	
	
		
		
	}

