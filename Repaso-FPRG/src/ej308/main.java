package ej308;

public class main {
	
	public static void main(String[] args) {
		float[] arr = {1.2f,0.34f,-2.1f,3.9f,0};
		int contador = numerosNegativos(arr);
		System.out.println("El array tiene " + contador + " número/s negativo/s.");
	}
	
	
	private static int numerosNegativos(float[] arr) {
		if(arr == null) {
			return 0;
		}
		int contador=0;
		for(int i=0; i < arr.length; i++) {
			if(arr[i]<0) {
				contador += 1;
			}
		}
		return contador;
	}

}
