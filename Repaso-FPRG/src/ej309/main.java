package ej309;

public class main {
	
	public static void main(String[] args) {
		char[] original = {'r','o','m','a'};
		char[] invertida = invertir(original);
		for(int i=0; i < original.length; i++) {
			System.out.print(original[i]);
		}
		System.out.print(" al revés es: ");
		for(int j=0; j < invertida.length; j++) {
			System.out.print(invertida[j]);
		}
		System.out.print(" (la misma ruina)");
		
	}
	
	private static char[] invertir(char[] original) {
		if(original == null) {
			return new char[0];
		}
		char[] resultado = new char[original.length];
		for(int i=0; i < resultado.length; i++) {
			resultado[i] = original[original.length-(i+1)];
		}
		return resultado;
	}

}
