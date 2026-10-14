package PaginaWeb;

import java.util.ArrayList;
import java.util.List;

public class ElementoHTML {
	
	private String tag; //Ejemplo: "div", "p", "img"
	private List<ElementoHTML> hijos;
	
	public ElementoHTML(String tag) {
		this.tag = tag;
		this.hijos = new ArrayList<ElementoHTML>();
	}
	
	public String getTag() {
		return this.tag;
	}
	
	public List<ElementoHTML> getHijos(){
		return this.hijos;
	}
	
	public void addHijos(ElementoHTML hijo) {
		this.hijos.add(hijo);
	}
	
	public static int contarEtiquetas(ElementoHTML elemento, String tagBuscado) {
		
		//Caso base: elemento o etiqueta vacío
		if(elemento == null || tagBuscado == null) {
			return 0;
		}
		
		int contador = 0;
		
		//Comprobar si el elemento actual coincide 
		if(tagBuscado.equals(elemento.getTag())) {
			contador = 1;
		}
		
		//Caso Recursivo: ir comprobando en cada elemento hijo si tiene el tag buscado
		if(elemento.getHijos() != null) {
			for(ElementoHTML hijo: elemento.getHijos()) {
				contador += contarEtiquetas(hijo, tagBuscado);
			}
		}
		return contador;
	}

}
