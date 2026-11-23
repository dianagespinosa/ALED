package ej10;

public class Main {
	
	public static void main(String[] args) {
		//Variables
		int vehiculos = 30;
		
		//Creamos puente 
		Puente puenteTalavera = new Puente();
		
		//Creamos e inicializamos hebras vehiculo
		for(int i=0; i < vehiculos; i++) {
			int peso = 1000+(int)(Math.random()*4000);
			boolean ambulancia = false;
			if(peso >= 4500) {
				ambulancia  = true;
			}
			Vehiculo v = new Vehiculo(puenteTalavera,peso, ambulancia);
			v.start();
		}
	}

}
