package ordenacion;

import java.util.Arrays;
import java.util.Comparator;

public class Alumno implements Comparable<Alumno> { //esta clase puede comparar
	
	String nombre;
	double nota;
	
	//Constructor del objeto Alumno
	public Alumno(String nombre, double nota) {
		this.nombre = nombre;
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
	//aplicamos el BubbleSort(ordenar arrays) a un caso real
	public static Alumno[] ordenar(Alumno[] arr, Comparator comparador) {
		
		for(int pasada = 0; pasada < arr.length; pasada++) {
			boolean changed = false;
			
			for(int i = 0; i < arr.length-1; i++) {
				if(comparador.compare(arr[i], arr[i+1]) > 0) { //si mi elemento es mayor que el elemento siguiente
					
					Alumno tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					changed = true;
				}
			}
			if(!changed) {
				//System.out.println("Pasada nº: " + (pasada + 1));
				break;
			}
			//System.out.println("Pasada nº: " + (pasada + 1));
		}
		return arr;
	}
	
	@Override
	public int compareTo(Alumno o) {
		//return Double.compare(this.nota,o.nota);
		//quien me ha llamado tiene un nombre y ese lo puedo comparar con otro nombre que alguien me pase como parámetro
		//return this.nombre.compareTo(o.nombre); 
		int c = Double.compare(this.nota, o.nota);
		if(c != 0) {
			return c;
		}else {
			return this.nombre.compareTo(o.nombre);
		}
	}
	
	public static void main(String[] args) {
		
		//String a = "Miguel";
		//String c = "Carlos";
		
		//System.out.println(a.compareTo(c));
		
		//System.out.println(Double.compare(11.0, 11.0));
		
		Alumno ana = new Alumno("Ana", 9.0);
		Alumno carlos = new Alumno("Carlos", 8.75);
		Alumno alejandra = new Alumno("Alejandra", 7.5);
		
		Alumno[] alumnos = {carlos, ana, alejandra};
		
		//System.out.println(Arrays.toString(ordenar(alumnos)));
		System.out.println(Arrays.toString(alumnos));
		
		Arrays.sort(alumnos);
		System.out.println(Arrays.toString(alumnos));
		
		//Comparator<Alumno> porNombre = new ComparadorPorNombre();
		//System.out.println(Arrays.toString(ordenar(alumnos,porNombre)));
		
		//Comparator<Alumno> porNota = new ComparadorPorNota();
		//System.out.println(Arrays.toString(ordenar(alumnos,porNota)));
		
		//Comparator<Alumno> porNombre2 = (a,b) -> a.nombre.compareTo(b.nombre);
	}

}
