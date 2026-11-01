package PalindromoRecursivo;

public class palindromo {
	
	public static boolean esPalindromo (String texto) {
		//Caso base: texto es null
		if(texto == null || texto.length() <= 1) {
			return true;
		}
		
		//Eliminar espacios y poner en minúscula
		texto = texto.toLowerCase();
		
		//Comprobar extremos
		char primero = texto.charAt(0);
		char ultimo = texto.charAt(texto.length()-1);
		
		if(primero != ultimo) {
			return false;
		}
		
		//Caso recursivo: llamar con la subcadena interior
		return esPalindromo(texto.substring(1, texto.length()-1));

	}
	
	public static void main(String[] args) {
		String s1 = "Hola me llamo Pepa ";
		String s2 = "sorberecerebros";
		String s3 = "OirasoraraRosario";
		
		System.out.println(esPalindromo(s1));
		System.out.println(esPalindromo(s2));
		System.out.println(esPalindromo(s3));
	}
}
