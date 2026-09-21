package ej306;

public class main {
	
	public static void main(String[] args) {
		float[][] matriz = {
				{ 1.0f, 5.5f, 3.2f },
				{ 8.1f, 2.0f, 4.4f },
				{ -1.0f, -5.0f, -3.0f },
				{}
		};
		
		float[] maximos = maximosPorFila(matriz);
		for(int i=0; i < matriz.length; i++ ) {
			System.out.println("Máximo de la fila " + i + ": " + maximos[i]);
		}
		
	}
	
	private static float[] maximosPorFila(float[][] matriz) {
		if(matriz == null) {
			return new float[0];
		}
		float[] maximos = new float[matriz.length];
		for(int fila=0; fila < matriz.length; fila++) {
			maximos[fila] = maximoFila(matriz[fila]);
		}
		return maximos;
	}
	
	private static float maximoFila(float[] fila) {
		if(fila == null || fila.length == 0) {
			return Float.NaN;	
		}
		float maximo = fila[0];
		for(int col=1; col < fila.length; col++) {
			if(fila[col] > maximo) {
				maximo = fila[col];
			}
		}
		return maximo;
	}
}

