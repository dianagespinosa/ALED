package ej10;

public class Vehiculo extends Thread{
	
	private Puente p;
	private final int peso;
	private final boolean ambulancia;
	
	public Vehiculo (Puente p, int peso, boolean ambulancia) {
		this.p = p;
		this.peso = peso;
		this.ambulancia = ambulancia;
	}
	
	private void cruzarPuente(){
		try {
			System.out.println("El vehiculo que pesa " + peso + "kg está cruzando el puente");
			Thread.sleep(500);
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	@Override
	public void run() {
		//Vehiculo llega al puente y mira a ver si puede entrar
		p.entrarPuente(peso, ambulancia);
		//Vehiculo cruza el puente
		cruzarPuente();
		//Vehiculo sale del puente y notifica al resto de que ha salido
		p.salirPuente(peso);
	}

}
