package ej09;

public class Funcionario extends Thread{
	
	Hacienda h;
	
	public Funcionario(Hacienda h) {
		this.h = h;
	}
	
	@Override
	public void run() {
		while(true) {
			//Atiende a los ciudadanos
			h.atenderCiudadano();
		}
	}
	

}
