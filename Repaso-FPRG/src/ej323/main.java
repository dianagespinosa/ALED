package ej323;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		
	}
	
	private static int[][] leerMatriz(Scanner teclado){
		System.out.print("Filas: ");
		int filas = teclado.nextInt();
		System.out.print("Columnas: ");
		int columnas = teclado.nextInt();
		
		int matriz[][] = new int[filas][columnas];
		for(int i=0; i < filas; i++) {
			for(int j=0; j < columnas; j++) {
				System.out.print("Valor [" + i +"] [" + j + "]: ");
				matriz[i][j] = teclado.nextInt();
			}
		}
		return matriz;
	}
	
	// Para multiplicar A x B, columnas de A deben coincidir con filas de B.
	private static boolean sonCompatibles(int[][] matrizA, int[][] matrizB) {
		boolean compatible = false;
		return compatible;
	}
	
	private static int[][] multiplicar(int[][] matrizA, int[][] matrizB){
		int[][] AxB = new int[matrizA.length][matrizB.length];
		return AxB;
	}
	
	private static void mostrar(int[][] matriz) {
		return;
	}

}
