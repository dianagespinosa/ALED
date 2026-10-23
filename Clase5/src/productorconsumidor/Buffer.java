package productorconsumidor;

public class Buffer { //la palabra synchronyzed funciona como un cerrojo para bloquear las instancias y separar
	
	private int dato = -1;
	private boolean lleno = false;
	
	// Hebra productora -> P
	public synchronized void guardar(int dato) {
		while(lleno) {
			// Dormir/ parar
			try {
				wait(); // El wait libera el cerrojo
			} catch (InterruptedException e) {
				return;
			}
		}
		//si no está lleno entonces guardo
		this.dato = dato;
		this.lleno = true;
		System.out.println("Guardado valor: " + dato);
		notifyAll(); // Despierta una hebra, pero no sé cuál
	}
	
	// Hebra consumidora -> C
	public synchronized int sacar() {
		while(!lleno) {
			// Dormir/ pàrar
			try {
				wait(); // Mando mi hebra a parar hasta que pida despertarla
			} catch (InterruptedException e) {
				return -1; // Si está vacío devolvemos un valor inválido
			}
		}
			this.lleno = false;
			System.out.println("Sacado valor:" + dato);
			notifyAll();
			return dato;
	}
	//Hasta que no sale del método no se libera el cerrojo
 
}
