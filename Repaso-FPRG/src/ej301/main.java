package ej301;

public class main {
	public static void main(String[] args) {
		float[] datos = { 1.5f, 2.5f, 3.0f, -1.0f, 4.25f };
		float total = sumar(datos);
		System.out.println("Suma: " + total);
	}

	private static float sumar(float[] datos) {
		if (datos == null) {
			return 0;
		}
		float suma = 0;
		for (int i = 0; i < datos.length; i++) {
			suma += datos[i];
		}
		return suma;
	}

}
