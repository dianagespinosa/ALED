package SistemaArchivos;

public class Archivo {
	
	//Representa un archivo con un tamaño específico
	private String nombre;
	private double PesoMB; //Tamaño en Megabytes
	
	public Archivo(String nombre, double peso) {
		this.nombre = nombre;
		this.PesoMB = peso;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getPesoMB() {
		return this.PesoMB;
	}
	
}
