package deadlock;

public class Banco {
	
	public void transferir(Cuenta origen, Cuenta destino, int cantidad) {
		synchronized(origen) { //El synchronized actúa como cerrojo, nadie entra hasta que se libere
			synchronized (destino) {
		if(origen.saldo >= cantidad) {
			origen.saldo -= cantidad;
			destino.saldo += cantidad;
		}
		else {
			System.out.println("Saldo insuficiente en la cuenta. Operación denegada");
		}
		}
		}
	}
}
