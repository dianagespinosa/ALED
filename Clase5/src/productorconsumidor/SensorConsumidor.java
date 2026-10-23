package productorconsumidor;

public class SensorConsumidor extends Thread{
	
	Buffer b;
	
	public SensorConsumidor(Buffer b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			int valor = b.sacar();
			
			//Espera activa hasta que retorne un valor válido
			while(valor == -1) {
				valor = b.sacar();
			}
		}
	}

}
