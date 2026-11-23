package ej12;

public class PersonaJubilada extends Persona{

	public PersonaJubilada(GestorMuseo gestor, int id) {
		super(gestor, id);
	}
	
	@Override
	public void run() {
		gestor.entrarSalaJubilado(id);
		visitarMuseo();
		gestor.salirSala(id);
	}

}
