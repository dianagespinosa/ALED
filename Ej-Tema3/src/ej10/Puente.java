package ej10;

public class Puente {
	
	private final int capVehiculos = 10;
	private final int capPeso = 15000; //en Kg
	
	private int vehiculosEnPuente = 0;
	private int pesoEnPuente = 0;
	private int ambulanciasEsperando = 0;
	
	public synchronized void entrarPuente(int peso, boolean ambulancia) {
		if(ambulancia) {
			ambulanciasEsperando++;
		}
		//El vehículo deberá esperar si:
		//1. El puente super la capacidad de Vehículos
		//2. El puente supera la capacidad de peso
		//3. El vehiculo no es ambulancia y hay ambulancias
		try {
			while(vehiculosEnPuente >= capVehiculos || peso + pesoEnPuente > capPeso || !ambulancia && ambulanciasEsperando > 0) {
				System.out.println("El vehículo que pesa " + peso + "kg debe esperar");
				wait();
			}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		//Bloque común
		if(ambulancia) {
			ambulanciasEsperando--;
			notifyAll();
		}
		vehiculosEnPuente++;
		pesoEnPuente += peso;
		System.out.println("El vehículo que pesa " + peso + "kg ha entrado al puente");
	}
	
	public synchronized void salirPuente(int peso) {
		vehiculosEnPuente--;
		pesoEnPuente -= peso;
		System.out.println("El vehículo que pesa " + peso + "kg ha salido del puente");
		notifyAll();
	}

}
