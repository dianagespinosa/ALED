package ej05;

public class MesaFilosofos {
	
	private final int TAMANIO = 5;
	private boolean[] tenedores = new boolean[TAMANIO];
	
	//Synchronized porque solo lo puede hacer una hebra (no varias simultáneamente)
	public synchronized void cogerTenedores(int id) {
		int izq = (id + 1) % TAMANIO; //Mantener íondice entre 0 y 4 (circular)
		
		//Comprueba que ambos tenedores estén libres
		try {
		while(tenedores[id] || tenedores[izq]) {
			System.out.println("...Filósofo-" + id + " espera.");
			wait();
		}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//Si están ambos libres los ocupamos
			tenedores[id] = true;
			tenedores[izq] = true;
			System.out.println(">>>Filósofo-" + id + " empieza a comer.");
		}
	
	
	//Synchronized porque solo lo puede hacer una hebra (no varias simultáneamente)
	public synchronized void soltarTenedores(int id) {
		int izq = (id + 1) % TAMANIO; //Mantener índice entre 0 y 4 (circular)
		
		//Liberamos tenedores
		tenedores[id] = false;
		tenedores[izq] = false;
		
		//Notificamos al resto que están esperando
		notifyAll();
		System.out.println("<<<Filósofo-" + id + " termina de comer.");
	}
	}
