package ej305;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		float[] datos = {(float) 1.2, 4, 99, 6,(float) 8.76, (float)0.18};
		System.out.println(calculoPromedio(datos));
	}
	
	private static float calculoPromedio(float[] arr) {
		float suma = 0;
		for(int i=0; i < arr.length; i++) {
			suma += arr[i];
		}
		float promedio = suma/arr.length;
		return promedio;
	}

}
