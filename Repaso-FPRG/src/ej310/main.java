package ej310;

public class main {
	
	public static void main(String[] args) {
		char[] datos = {'r','o','m','a'};
		System.out.print(new String(datos)+" al revés es ");
		invertir(datos);
		System.out.print(new String(datos));
	}
	
	private static void invertir(char[] arr) {
		if(arr == null) {
			return;
		}
		
		int izq = 0;
		int drcha = arr.length-1;
		while(izq < drcha) {
			char temporal = arr[izq];
			arr[izq] = arr[drcha];
			arr[drcha] = temporal;
			izq++;
			drcha--;
		}
		
	}

}
