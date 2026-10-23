package productorconsumidor;

public class SensorProductor extends Thread { //es una hebra
	
	Buffer b;
	
	public SensorProductor(Buffer b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			b.guardar(i);
		}
	}

}
