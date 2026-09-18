package ej302;

public class main {
	
	public static void main(String[] args) {
		int[] datos = {8,45,68,9,3,109,39};
		int num1 = 3;
		int num2 = 39;
		int num3 = 54;
		System.out.println("El número " + num1 + " se encuentra en la posición: " + buscarValor(num1,datos));
		System.out.println("El número " + num2 + " se encuentra en la posición: " + buscarValor(num2,datos));
		System.out.println("El número " + num3 + " se encuentra en la posición: " + buscarValor(num3,datos));
	}
	
	private static int buscarValor(int n,int[] arr) {
		int posicion = -1;
		for(int i=0; i < arr.length; i++) {
			if(n == arr[i]) {
				posicion = i;
			}
		}
		return posicion;
	}

}
