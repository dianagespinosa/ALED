package productorconsumidor;

public class Buffer {
	
	private int dato = -1;
	private boolean lleno = false;
	
	public synchronized boolean guardar(int dato) {
		if(!lleno) { //si no está lleno entonces guardo
		this.dato = dato;
		this.lleno = true;
		System.out.println("Guardado valor: " + dato);
		return true;
		}
		return false;
	}
	
	public synchronized int sacar() {
		if(lleno) {
			this.lleno = false;
			System.out.println("Sacado valor:" + dato);
			return dato;
		}
		return -1;
	}

}
