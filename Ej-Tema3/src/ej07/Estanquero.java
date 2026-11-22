package ej07;

public class Estanquero extends Thread{
	
	Estanco e;
	
	public Estanquero(Estanco e) {
		this.e = e;
	}
	
	@Override
	public void run() {
		//Repone ingredientes continuamente
		while(true) {
			int ingrediente = (int)(Math.random()*3);
			e.ponerIngredientes(ingrediente);
		}
	}

}
