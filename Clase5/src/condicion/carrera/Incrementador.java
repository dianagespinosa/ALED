package condicion.carrera;

public class Incrementador extends Thread { //es una nueva hebra
	
	Contador c;
	
	public Incrementador(Contador c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100000; i++) {
			c.incrementar();
		}
	}

}
