package ej12;

public class Persona extends Thread{
	
	protected final GestorMuseo gestor;
	protected final int id;
	
	public Persona(GestorMuseo gestor, int id) {
		this.gestor = gestor;
		this.id = id;
	}
	
	public void visitarMuseo() {
		System.out.println("!!!Persona-" + id + " visita el museo.");
		try {
		Thread.sleep(200+(long) (Math.random()*1000));
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	@Override
	public void run() {
		gestor.entrarSala(id);
		visitarMuseo();
		gestor.salirSala(id);
	}

}
