package complejidad;

public class busquedaBinaria {
	
	public static int busquedaBinaria(int[] arr, int valor) {
		
		int izq = 0;
		int dch = arr.length-1;
		int pos = (dch-izq)/2;
		
		while(izq <= dch) {
			if(arr[pos] == valor) {
				return pos;
			}else if(arr[pos] > valor) {
				//Busco izquierda
				dch = pos-1; //se deplaza el límite superior
				pos = izq + ((dch-izq)/2);
			}else {
				//Busco derecha
				izq = pos+1; //se desplaza el límite inferior
				pos = izq + ((dch-izq)/2); //sumamos izq para actualizar la posición del intervalo posible
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,8,9,12,14};
		System.out.println(busquedaBinaria(arr,8));
	}

}
