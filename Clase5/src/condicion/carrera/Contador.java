package condicion.carrera;

public class Contador { //recurso compartido: va a guardar un valor(int)
	//vamos a intenetar que dos hebras(Thread 1 y 2) accedan a el e intenten modificarlo
	
	private int valor = 0;
	
	public void incrementar() {
		valor++;
	}
	
	public int getValor() {
		return this.valor;
	}

	
}
