package recursividad;

public class Backtracking {
	
	private static String matrizToString(int[][] arr) {
		String resultado = "";
		
		for(int[] fila : arr) {
			for(int valor : fila) {
				resultado += valor + " ";
			}
			resultado += "\n";
		}
		return resultado;
	}
	
	public static boolean camino(int[][] mapa, int fila, int columna, boolean[][] visitado) {
		
		System.out.println("Intento: (" + fila +", " + columna + ")");
		
		//Casos base (cuando se para, caso final)
		//Fuera de límites
		if(fila < 0 || fila >= mapa.length || columna < 0 || columna >= mapa[0].length) {
			return false;
		}
		
		//Choco
		if(mapa[fila][columna] == 1) {
			return false;
		}
		
		//Visitado
		if(visitado[fila][columna] == true) {
			return false;
		}
		
		//Salida
		if(fila == mapa.length-1 && columna == mapa[0].length-1) {
			return true;
		}
		
		//Backtracking
		//PRUEBO
		mapa[fila][columna] = 2;
		
		//EXPLORO
		if(camino(mapa, fila+1, columna, visitado) || camino(mapa,fila-1,columna, visitado) 
				|| camino(mapa,fila, columna+1, visitado) || camino(mapa,fila,columna-1, visitado)) {
		return true;	
		}
		
		//VUELVO
		mapa[fila][columna] = 0;
		
		return false;
	}
				
	public static void main(String[] args) {
		int[][] mapa = {
				{0,0,1,0},
				{1,0,0,0},
				{0,0,1,1},
				{0,0,0,0}
		};
		
		boolean[][] visitado = {
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false},
		};
		
		System.out.print(matrizToString(mapa)); //tipo primitivo y referencia
		System.out.println(camino(mapa,0,0, visitado));
		}
	}

