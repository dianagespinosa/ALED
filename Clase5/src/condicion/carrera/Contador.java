package condicion.carrera;

public class Contador { //recurso compartido: va a guardar un valor(int)
	//vamos a intenetar que dos hebras(Thread 1 y 2) accedan a el e intenten modificarlo
	
	private int valor = 0;
	
	public void incrementar() { //parámretro: Object cerrojo
		//Cálculo costoso
		
		synchronized(this) { //en vez de this pondríamos cerrojo
		valor++; //Región crítica -> Debo aplicar exclusión mutua (excluirlos mutuamente una hebra y una a otra)
		}
		
		//int tmp = valor; -> Leyendo el valor
		//tmp = tmp + 1; -> Calculando el nuevo valor
		//valor = tmp; -> Actualizando el valor
		//Operación no atómica -> Condición de carrera
	}
	
	public int getValor() {
		return this.valor;
	}

	
}
