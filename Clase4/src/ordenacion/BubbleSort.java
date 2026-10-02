package ordenacion;

import java.util.Arrays;

public class BubbleSort {
	
	public static int[] ordenar(int[] arr) {
		
		//no necesitaríamos la última pasada, ya que al llegar a la última ya estrá ordenada por defecto
		//el bucle se ejecuta n veces
		for(int pasada = 0; pasada < arr.length; pasada++) {
			boolean changed = false;
			//el bucle se ejecuta n-1 veces, porque sin el -1 como al comparar estamos sumando 1 y se nos saldría el índice del array
			for(int i = 0; i < arr.length-1; i++) {
				if(arr[i] > arr[i+1]) {
					//creamos variable auxiliar para cambiar valor de posición
					int tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					changed = true;
				}
			}
			if(!changed) { //equivaldría a (changed == false)
				System.out.println("Pasada nº: " + (pasada + 1));
				break;
			}
			System.out.println("Pasada nº: " + (pasada + 1));
		}
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(ordenar(new int[] {6, 2, 4, 9, -10})));
		System.out.println(Arrays.toString(ordenar(new int[] {2, 1, 3, 4, 5})));
	}

}
