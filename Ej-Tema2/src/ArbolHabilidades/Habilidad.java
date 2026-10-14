package ArbolHabilidades;

import java.util.ArrayList;
import java.util.List;

public class Habilidad {
	
	private String id;
	private int costePuntos; //Coste para desbloquear esta habilidad
	private List<Habilidad> desbloqueables; //Habilidades que dependen de esta
	
	public Habilidad(String id, int costePuntos) {
		this.id = id;
		this.costePuntos = costePuntos;
		this.desbloqueables = new ArrayList<Habilidad>();
	}
	public int getCoste() {
		return this.costePuntos;
	}
	
	public List<Habilidad> getDesbloqueables(){
		return this.desbloqueables;
	}
	
	public void addDesbloqueable(Habilidad h) {
		this.desbloqueables.add(h);
	}
	
	public static int costeRamaCompleta(Habilidad raiz) {
		
		//Caso base: no desciende de ella ninguna habilidad
		if(raiz == null) {
			return 0;
		}
		
		//El los puntos incluyen el coste de la propia raiz
		int puntos = raiz.getCoste();
		
		//Caso recursivo: suma de todos los costes de las habilidades desbloqueables
		if(raiz.getDesbloqueables() != null) {
			for(Habilidad des: raiz.getDesbloqueables()) {
				puntos += costeRamaCompleta(des);
			}
		}
		return puntos;
	}
	
	public static void main(String[] args) {
		Habilidad h1 = new Habilidad("N1", 10);
		Habilidad h12 = new Habilidad("N1", 20);
		Habilidad h13 = new Habilidad("N1", 30);
		Habilidad h123 = new Habilidad("N1", 40);
		Habilidad h2 = new Habilidad("N1", 50);
		Habilidad h21 = new Habilidad("N1", 60);
		Habilidad raiz = new Habilidad("N1", 100);
		
		h1.addDesbloqueable(h12);
		h1.addDesbloqueable(h13);
		h12.addDesbloqueable(h123);
		h2.addDesbloqueable(h21);
		raiz.addDesbloqueable(h1);
		raiz.addDesbloqueable(h2);
		
		System.out.println(costeRamaCompleta(h1));
		System.out.println(costeRamaCompleta(h2));
		System.out.println(costeRamaCompleta(h12));
		System.out.println(costeRamaCompleta(h13));
		System.out.println(costeRamaCompleta(raiz));
	}

}
