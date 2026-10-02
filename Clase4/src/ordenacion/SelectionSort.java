package ordenacion;

import java.util.Arrays;

public class SelectionSort {
	
	public static int[] ordenar(int[] arr) {
		for(int pos=0; pos < arr.length; pos++) {
			int posMin = pos;
			
			//segundo bucle para ir comparando la carta en la que estoy con las que hay detrás
			for(int i=pos+1; i < arr.length; i++){
				if(arr[i] < arr[posMin]) {
					posMin = i;
				}
			}
			//cuando termino de recorrer el array creo una variable auxiliar para guardar un valor
			int tmp = arr[pos];
			arr[pos] = arr[posMin];
			arr[posMin] = tmp;
			}
		
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(ordenar(new int[] {6, 2, 4, 9, -10})));
	}
}
