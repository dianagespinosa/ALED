package ordenacion;

public class Alumno implements Comparable<Alumno> {
	
	String nombre;
	double nota;
	
	//Constructor del objeto Alumno
	public Alumno(String nombre, double nota) {
		this.nombre = nombre;
		this.nota = nota;
	}
	
	//aplicamos el BubbleSort(ordenar arrays)a un caso real
	public static Alumno[] ordenar(Alumno[] arr) {
		
		for(int pasada = 0; pasada < arr.length; pasada++) {
			boolean changed = false;
			
			for(int i = 0; i < arr.length-1; i++) {
				if(arr[i] > arr[i+1]) {
					
					Alumno tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					changed = true;
				}
			}
			if(!changed) {
				System.out.println("Pasada nº: " + (pasada + 1));
				break;
			}
			System.out.println("Pasada nº: " + (pasada + 1));
		}
		return arr;
	}
	
	@Override
	public int compareTo(Alumno o) {
		return Double.compare(this.nota, o.nota);

		//quien me ha llamado tiene un nombre y ese lo puedo comparar con otro nombre que alguien me pase como parámetro
		//return this.nombre.compareTo(o.nombre); 
		
	}
	
	public static void main(String[] args) {
		
		String a = "Ana";
		String c = "Carlos";
		
		System.out.println(a.compareTo(c));
		
		System.out.println(Double.compare(11.0, 11.0));
		
		Alumno ana = new Alumno("Ana", 9.0);
		Alumno carlos = new Alumno("Carlos", 8.75);
		
		Alumno[] alumnos = {carlos, ana};
	}

}
