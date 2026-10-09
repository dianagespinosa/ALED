package bst;

public class BST { //Árbol completo que nos permitirá guardar elementos
	              //y buscar si nuestro árbol contirne algún elem
	
	Nodo raiz;
	
	//guardar
	public void guardar(int valor) {
		if(raiz == null) { //si esto se ha cumplido es que no había raíz
			raiz = new Nodo(valor);
			return;
		}
		
		Nodo actual = raiz;
		
		while(actual != null) {	
		if(valor == actual.valor) {
			return;
		}else if(valor < raiz.valor) {
			//Sé que está hacia la izquierda
			if(actual.izquierda == null) { //si no tien hijo crea un nuevo hijo a la izquierda guardando el valor
				actual.izquierda = new Nodo(valor);
				return;
		}
			actual = actual.izquierda; //muevo y actualizo mi puntero
		}else {
			//Sé que está hacia la derecha
			if(actual.derecha == null) {
				actual.derecha = new Nodo(valor);
				return;
		}
			actual = actual.derecha; //muevo y actualizo mi puntero
		}
		}
	}
	
	//contains
	public boolean contains(int valor) {
//		if(raiz == null) { //si esto se ha cumplido es que mi elemento no está en la estructura
//			return false;
//		} //sobra en este caso
		
		Nodo actual = raiz;
		
		while(actual != null) {	
		if(valor == actual.valor) {
			return true;
		}else if(valor < raiz.valor) {
			//Si está, entonces estará hacia la izquierda
			if(actual.izquierda == null) { //si no tien hijo crea un nuevo hijo a la izquierda guardando el valor
				actual.izquierda = new Nodo(valor);
				return false;
		}
			actual = actual.izquierda; //muevo y actualizo mi puntero
		}else {
			//Si está, entonces estará hacia la derecha
			if(actual.derecha == null) {
				actual.derecha = new Nodo(valor);
				return false;
		}
			actual = actual.derecha; //muevo y actualizo mi puntero
		}
		}
		return false; //da igual porque no se va a llegar a ejecutar
	}
	
	
	public static void main(String[] args) {
		BST tree = new BST();
		tree.guardar(7);
		tree.guardar(4);
		tree.guardar(9);
		tree.guardar(1);
		tree.guardar(5);
		tree.guardar(8);
		tree.guardar(15);
		
		System.out.println(tree.contains(1));
		
		//bst.raiz.izquierda.derecha;
		//mi bst tiene una raiz, mi raiz tiene un nod y mi nodo tiene uno a la izquierda y así sucesivamente
	}

}
 