package ej09;

public class Ciudadano extends Thread{
	
	private Hacienda h;
	
	public Ciudadano(Hacienda h) {
		this.h = h;
	}
	
	@Override
	public void run() {
		//Espera en su ventanilla correspondiente a ser atendido
		if(Math.random() < 0.5) {
			h.esperarVentanilla1();
		} else {
			h.esperarVentanilla2();
		}
	}

}
