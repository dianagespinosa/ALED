package ej205;

public class main {
	
	public static void main(String[] args) {
		
		int numero = 1;
		int resultado = 0;
		
		while(numero <= 10) {
			System.out.println("\nLa tabla de multiplicar del " + numero + " es:");
			for(int i = 0; i <= 10; i++) {
				resultado = numero*i;
				System.out.println(numero + "x" + i + "=" + resultado);
			}
			numero++;
			
		}
	}

}
