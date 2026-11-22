package ej07;

public class Fumador extends Thread{
	
	private Estanco e;
	private int id;
	
	public Fumador(Estanco e, int id) {
		this.e = e;
		this.id = id;
	}
	
	public void fumar() {
		try {
			Thread.sleep((long) (Math.random()*500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
		@Override
		public void run() {
			while(true) {
			//Intenta coger ingredientes
			e.cogerIngredientes(id);
			//Fuma
			fumar();
			//Termina de fumar y avisa al estanquero para que reponga
			e.terminarDeFumar();
			}
		}
	}

