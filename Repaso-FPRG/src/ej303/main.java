package ej303;

public class main {
	
	private static final int TAMANIO = 300;
	private static final int MODULO = 16;
	
	public static void main(String[] args) {
		int[] datos = generar();
		for(int i=0; i < datos.length; i++) {
			System.out.print(datos[i] + " ");
		}
		System.out.println();
	}
	
	private static int[] generar () {
		int[] datos = new int[TAMANIO];
		for(int i=0; i < datos.length; i++) {
			datos[i] = i % MODULO;
		}
		return datos;
	}
}
