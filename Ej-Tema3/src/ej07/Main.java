package ej07;

public class Main {
	
	public static void main(String[] args) {
		
	//Variables
	int fumadores = 3;
	
	//Creamos el estanco
	Estanco e = new Estanco();
	
	//Creamos hebras fumadoras y las inicializamos
	for(int i=0; i < fumadores; i++) {
		Fumador f = new Fumador(e, i);
		f.start();
	}
	
	//Creamos hebra estanquero y lo inicializamos
	Estanquero paco = new Estanquero(e);
	paco.start();
	
	}

}
