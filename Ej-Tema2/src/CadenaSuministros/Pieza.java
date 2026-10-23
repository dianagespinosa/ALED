package CadenaSuministros;

import java.util.ArrayList;
import java.util.List;

import ArbolHabilidades.Habilidad;

public class Pieza {
	
	private String nombre;
	private boolean esDefectuosa;
	private List<Pieza> componenetes; //Piezas necesarias para montar esta
	
	public Pieza(String nombre, boolean esDefectuosa) {
		this.nombre = nombre;
		this.esDefectuosa = esDefectuosa;
		this.componenetes = new ArrayList<Pieza>();
	}
	
	public boolean isDefectuoso(){
		return this.esDefectuosa;
	}
	
	public List<Pieza> getComponentes(){
		return this.componenetes;
	}
	
	public void addComponentes(Pieza p) {
		this.componenetes.add(p);
	}
	
	public static boolean contieneDefectos(Pieza piezaPrincipal) {
		
		//Caso base: pieza principal nula
		if(piezaPrincipal == null) {
			return false;
		}
		
		//Caso base: la pieza principal es defectuosa
		if(piezaPrincipal.esDefectuosa) {
			return true;
		}
		
		//Caso Recursivo: verificar componentes
		if(piezaPrincipal.getComponentes() != null) {
			for(Pieza componente : piezaPrincipal.getComponentes()) {
				if(contieneDefectos(componente)) {
					return true;
				}
			}
	}
		// Ni la pieza ni sus descendientes tienen defectos
		return false;
	}
	
	public static void main(String[] args) {
		Pieza p1 = new Pieza("Lavadora", false);
		Pieza p11 = new Pieza("Botón", false);
		Pieza p12 = new Pieza("Tornillo", true);
		Pieza p112 = new Pieza("Pulsador", false);
		
		p1.addComponentes(p11);
		p1.addComponentes(p12);
		p11.addComponentes(p112);
		
		System.out.println(contieneDefectos(p112));
		System.out.println(contieneDefectos(p11));
		System.out.println(contieneDefectos(p1));
	}
}
