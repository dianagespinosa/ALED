package ej12;

public class Main {
	
	public static void main(String[] args) {
	//Variables
	int personas = 70;
	
	//Creamos Gestor de Museo
	GestorMuseo gestor = new GestorMuseo();
	
	//Creamos hebra termómetro
		Termómetro termo = new Termómetro(gestor);
		termo.setDaemon(true);
		termo.start();
		
	//Creamos hebras personas
	for(int i = 0; i < personas; i++) {
		Persona p;
		if(Math.random()> 0.5) {
			p = new Persona(gestor, i);
		}else {
			p = new PersonaJubilada(gestor, i);
		}
		p.start();
	}
	
	}
}
