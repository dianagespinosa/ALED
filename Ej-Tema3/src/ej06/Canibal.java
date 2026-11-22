package ej06;

public class Canibal extends Thread{
	
	Marmita m;
	String nombre;
	
	public Canibal(Marmita m, String nombre) {
		this.m = m;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		int veces = 1 + (int)(Math.random()*4);
		for(int i=0; i <= veces; i++) {
		m.comer(nombre);
		try {
			Thread.sleep((long)(Math.random()*500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	

}
