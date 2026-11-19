package FusiónListas;

public class NodoLista {
	
	int dato;
	NodoLista siguiente;
	
	public static NodoLista fusionarListas(NodoLista l1, NodoLista l2) {
		//Casos base: si una lista se acaba,
		//engancha directamente todo lo que queda de la otra lista
		
		if(l1 == null) {
			return l2; 	
		}
		
		if(l2 == null) {
			return l1;
		}
		
		//Caso recursivo: elige el nodo menor como cabeza actual,
		//conecta su siguiente con el resultado de fusionar el resto de nodos pendientes,
		//y devuelve ese nodo elegido.
		if(l1.dato < l2.dato) {
			l1.siguiente = fusionarListas(l1.siguiente, l2);
			return l1;
		}else {
			l2.siguiente = fusionarListas(l1, l2.siguiente);
			return l2;
		}
	}

}
