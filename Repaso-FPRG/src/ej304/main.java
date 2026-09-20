package ej304;

public class main {
	
	private static final int TAMANIO = 300;
	private static final int MODULO = 16;
	
	public static void main(String[] args) {
		char[] datos = generar();
		for(int i=0; i < datos.length; i++) {
			System.out.print(datos[i] + " ");
		}
		System.out.println();
	}
	
	private static char[] generar() {
		char[] datos = new char[TAMANIO];
		for(int i=0; i < datos.length; i++) {
			datos[i] = Character.toUpperCase(Character.forDigit(i % MODULO, MODULO));
		} //convierte los números en caracteres, a partir del 9 pone letras porque son dos dígitos
		//el Uppercase convierte minúsculas en mayúsculas
		return datos;
	}
	

}
