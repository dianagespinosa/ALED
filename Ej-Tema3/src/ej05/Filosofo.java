package ej05;

public class Filosofo extends Thread{
	
	private final MesaFilosofos mesa;
	private final int id; //numeramos del 0 al 4
	
	public Filosofo(MesaFilosofos mesa, int id) {
		this.mesa = mesa;
		this.id = id;
	}
	
	private void pensar() {
		try {
			System.out.println("Filósofo-" + id + " está pensando...");
			Thread.sleep((long)(Math.random()*1000));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	
	private void comer() {
		try {
			System.out.println("Filósofo-" + id + " está comiendo.");
			Thread.sleep((long)(Math.random()*1000));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	@Override
	public void run() {
		while(true) {
		//1. Pensar
		pensar();
		//2. Pide permiso para coger los tenedores
		mesa.cogerTenedores(id);
		//3. Come
		comer();
		//4. Termina y suelta tenedores
		mesa.soltarTenedores(id);
	}
	}

}
