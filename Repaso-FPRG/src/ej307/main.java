package ej307;

public class main {
	
	public static void main(String[] args) {
		int[] arr = {8,54,21,2,46};
		int[] resultado = copiaYmultiplica(2,arr);
		for(int i=0; i < resultado.length; i++) {
			System.out.print(resultado[i]+ " ");
		}
		System.out.println();
		}
	
	private static int[] copiaYmultiplica(int n, int[] arr) {
		if(arr == null) {
			return new int[0];
		}
		int[] resultado = new int[arr.length];
		for(int i=0; i < arr.length; i++) {
			resultado[i] = arr[i]*n;
		}
		return resultado;
	}

}
