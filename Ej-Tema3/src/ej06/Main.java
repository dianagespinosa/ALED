package ej06;

public class Main {
	
	public static void main(String[] args) {
		//Variables
		int canibales = 25;
		
		//Creamos recurso compartido al que accederán las hebras
		Marmita m = new Marmita();
		
		//Creamos e inicializamos hebras canibales
		for(int i=0; i < canibales; i++) {
			Canibal cani = new Canibal(m, "Canibal-" + i);
			cani.start();
		}
		
		//Creamos e inicializamos hebra cocinero
		Cocinero coci = new Cocinero(m);
		coci.setDaemon(true);
		coci.start();
	}

}
