package CadenaSuministros;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Pieza> getComponenetes(){
		return this.componenetes;
	}
	
	public void addComponenetes(Pieza p) {
		this.componenetes.add(p);
	}
	
	public static boolean contieneDefectos(Pieza piezaPrincipal) {
		
		//Caso base: pieza principal nula
		if(piezaPrincipal == null) {
			return false;
		}
		
		
	}

}
