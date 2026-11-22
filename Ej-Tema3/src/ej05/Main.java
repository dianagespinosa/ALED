package ej05;

public class Main {
	
	public static void main(String[] args) {

	//Creamos mesa de filósofos
	MesaFilosofos mesa = new MesaFilosofos();
	
	//Creamos hebras filósofos
	for(int i=0; i < 5; i++) {
		Filosofo f = new Filosofo(mesa, i);
		f.start();
	}
	}
}
