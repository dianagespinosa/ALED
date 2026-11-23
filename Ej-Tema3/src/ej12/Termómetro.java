package ej12;

public class Termómetro extends Thread{
	
	private final GestorMuseo gestor;
	
	public Termómetro(GestorMuseo gestor) {
		this.gestor = gestor;
	}
	
	@Override
	public void run() {
		while(true) {
			int temperatura = (int)(Math.random()*45);
			gestor.notificarTemperatura(temperatura);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	}

}
