package complejidad;

public class busquedaLineal {
	
	public static int busquedaLineal(int[] arr, int valor) {
		for(int i=0; i < arr.length; i++) {
			if(arr[i] == valor) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 7, 9, 2, 0, 13};
		System.out.println(busquedaLineal(arr,100));
	}

}
