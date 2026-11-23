package ej09;

public class Main {
	
	public static void main(String[] args) {
		//Variables
		int ciudadanos = 30;
		
		//Creamos la hacienda donde interactuan las hebras
		Hacienda h = new Hacienda();
		
		//Creamos e inicializamos las hebras ciudadano
		for(int i =0; i < ciudadanos; i++) {
			Ciudadano c = new Ciudadano(h);
			c.start();
		}
		
		//Creamos funcionario
		Funcionario andres = new Funcionario(h);
		andres.setDaemon(true);
		andres.start();
	}

}
