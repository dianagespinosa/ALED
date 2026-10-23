package productorconsumidor;

public class Buffer { //la palabra synchronyzed funciona como un cerrojo para bloquear las instancias y separar
	
	private int dato = -1;
	private boolean lleno = false;
	
	//Hebra productora -> P
	public synchronized boolean guardar(int dato) {
		if(!lleno) { //si no está lleno entonces guardo
		this.dato = dato;
		this.lleno = true;
		System.out.println("Guardado valor: " + dato);
		return true;
		}
		return false;
	}
	
	//Hebra consumidora -> C
	public synchronized int sacar() {
		if(lleno) {
			this.lleno = false;
			System.out.println("Sacado valor:" + dato);
			return dato;
		}
		return -1; //Si está vacío devolvemos un valor inválido
	}

}
