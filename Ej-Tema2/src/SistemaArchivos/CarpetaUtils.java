package SistemaArchivos;

public class CarpetaUtils {
	
	public static double calcularPesoTotal(Carpeta inicio) {
		
		//Caso base: si la carpeta no tiene archivos ni subcarpetas
		if(inicio == null) {
			return 0.0;
		}
		double pesoTotal = 0.0;
		
		//Sumar peso de archivos directos
		if(inicio.getArchivos() != null) {
		for(Archivo a: inicio.getArchivos()) {
			pesoTotal += a.getPesoMB();
		}
		}
		
		//Caso recursivo: sumar peso de subcarpetas
		if(inicio.getSubcarpetas() != null) {
		for(Carpeta sub: inicio.getSubcarpetas()) {
			pesoTotal += calcularPesoTotal(sub);
		}
		}
		
		return pesoTotal;
	}
	
	public static void main(String[] args) {
		Carpeta c1 = new Carpeta("UPM");
		Carpeta c2 = new Carpeta("ALED");
		Archivo a1 = new Archivo("Clase1", 10);
		Archivo a2 = new Archivo("Clase2", 5);
		Archivo a3 = new Archivo("Normativa", 100);
		Archivo a4 = new Archivo("Normativa", 56);
		c2.addArchivo(a1);;
		c2.addArchivo(a4);
		c2.addArchivo(a2);
		c1.addSubcarpeta(c2);
		c1.addArchivo(a3);
		
		System.out.println(calcularPesoTotal(c1));
	}
}
