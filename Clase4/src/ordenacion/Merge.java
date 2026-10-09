package ordenacion;

import java.util.Arrays;

public class Merge { //Objetivo: unir dos arrays manteniendo el orden
	//ejemplo: arr1 = {1,3,6,8} ; arr2 = {2,4,5,7} --> res = {1,2,3,4,5,6,7,8}
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] res = new int[arr1.length + arr2.length];
		
		int pos1 = 0;
		int pos2 = 0;
		
		int posRes = 0;
		
		// NO VALE (while(posRes < res.length) {) porque nos daría u out of bound exception
		while(pos1 < arr1.length && pos2 < arr2.length) { //evitamos no salirnos de ninguno de los arrays
			
			if(arr1[pos1] <= arr2[pos2]) { //comparamos los elementos de ambos arrays
				res[posRes] = arr1[pos1]; //añado a res el valor más pequeño, en este caso el del arr1
				pos1++;
				posRes++;
			}else {
			res[posRes] = arr2[pos2]; //añado a res el valor más pequeño, en este caso el del arr2
			pos2++;
			posRes++;
			}
		}
		
		//se pueden quedar elementos que no se han recorrido
		//falta uno por recorrer...¿cuál?
		
		while(pos1 < arr1.length) {
			res[posRes] = arr1[pos1];
			pos1++;
			posRes++;
		}
		
		while(pos2 < arr2.length) {
			res[posRes] = arr2[pos2];
			pos2++;
			posRes++;
		}
		
		//res está lleno
		return res;
	}
	
	public static int[] dividirPrimeraMitad(int[] arr){
		int[] res = new int[arr.length/2];
		
		for(int i=0; i < arr.length/2; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	public static int[] dividirSegundaMitad(int[] arr){
		int[] res = new int[arr.length-(arr.length/2)];
		int posRes = 0;
		
		for(int i = arr.length/2; i < arr.length; i++) {
			res[posRes] = arr[i];
			posRes++;
		}
		return res;
	}
	
	public static int[] mergeSort(int[] arr){//Objetivo: ordenar un array apoyándonos en el método merge
		//para ello dividimos el array hasta obtener arrays que estén ordenados
		//y llamamos al método merge para que los una manteniendo el orden
		if(arr.length <= 1) {
			return arr;
		}
		
		int[] izq = dividirPrimeraMitad(arr);
		int[] dch = dividirSegundaMitad(arr);
		
		//llamada recursiva
		izq = mergeSort(izq); //lo que me está viniendo por la izq
		dch = mergeSort(dch); //lo que me está viniendo por la dch
		
		//ahora tengo que juntar los arrays
		return merge(izq, dch);
		
	}
	
	public static void main(String[] args) {
		// System.out.println(Arrays.toString(merge(new int[] {1,3,6,8}, new int[] {2,4,5,7})));
		System.out.println(Arrays.toString(mergeSort(new int [] {5,2,4,3,6,1,9,7})));
	}
	
	//ESTE MÉTODO ES MEJOR QUE EL SELECTIVESORT Y BUBBLESORT: 
	//

}

