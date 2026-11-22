package ej06;

public class Cocinero extends Thread{
	
	Marmita m;
	
	public Cocinero(Marmita m) {
		this.m = m;
	}
	
	@Override
	public void run() {
		while(true) {
			m.rellenar();
			try {
				Thread.sleep((long)(Math.random()*500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
