package deadlock;

public class Banco {
	
	public void transferir(Cuenta origen, Cuenta destino, int cantidad) {
		
		Cuenta primera;
		Cuenta segunda;
		
		if(origen.id < destino.id) {
			primera = origen;
			segunda = destino;
		} else {
			primera = destino;
			segunda = origen;
		}
		
		synchronized(primera) { //El synchronized actúa como cerrojo, nadie entra hasta que se libere
			synchronized (segunda) {
		if(origen.saldo >= cantidad) {
			origen.saldo -= cantidad;
			destino.saldo += cantidad;
		}
		else {
			System.out.println("Saldo insuficiente en la cuenta. Operación no permitida");
		}
		}
		}
	}
}
