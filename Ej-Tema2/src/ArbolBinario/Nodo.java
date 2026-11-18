package ArbolBinario;

public class Nodo {
	
	int valor;
	Nodo izq;
	Nodo der;
	
	public Nodo(int valor, Nodo izq, Nodo der) {
		this.valor = valor;
		this.izq = izq;
		this.der = der;
	}

	public static boolean esBST(Nodo nodo) {
		return esBSTAux(nodo, null, null);
	}
	
	private static boolean esBSTAux(Nodo nodo, Nodo min, Nodo max) {
		//Caso base: Nodo vacío o sin hijos
		if(nodo == null) {
			return true;
		}
		
		//Bloque común: comprobar si el nodo actual es válido
		if(min != null) { //tiene un límite inferior
			if(nodo.valor <= min.valor) {
				return false;
			}
		}
		if(max != null) {
			if(nodo.valor >= max.valor) {
				return false;
			}
		}
		
		//LLamada recursiva: si el nodo actual es correcto comprobar los hijos
		return esBSTAux(nodo.izq,min,nodo) && esBSTAux(nodo.der,nodo,max);
	}
	
	public static void main(String[] args) {
		
		Nodo n1 = new Nodo(8,null, null);
		Nodo n2 = new Nodo(15, null, null);
		Nodo raiz = new Nodo(10,n1,n2);
		
		System.out.println("Caso 1: " + esBST(raiz));
		
		Nodo trampa = new Nodo(8, null, null);
		Nodo der = new Nodo(15, trampa, null);
		Nodo raizInvalida = new Nodo(10, null, der);
		
		System.out.println("Caso 2: " + esBST(raizInvalida));
	}

}
