package CambioJusto;

public class cambio {
	
	//Cuantas formas distintas se puede sumar la cantidad objetivo con monedas de 1,2 y 5
	public static int contarFormasCambio(int objetivo, int[] monedas) {
		//monedas es un array de tamaño 3 que contiene:
		//pos0: nº de monedas de 1
		//pos1: nº de monedas de 2
		//pos2: nº de monedas de 5
		
		int[] valores = {1, 2, 5};
		
		// Sin un recuento por cada tipo de moneda no se puede calcular nada
		if(monedas == null || monedas.length < valores.length) {
			return 0;
		}
		
		return contarAux(objetivo, monedas, valores, valores.length - 1);
	}
		
		//Para evitar contar permutaciones (ej: 1+2 y 2+1) como distintas, usamos un
		//método auxiliar que impone un orden en el uso de monedas
	
		private static int contarAux(int objetivo, int[] cantidades, int[] valores, int indiceMoneda) {

		//Casos base
		if(objetivo == 0) {
			return 1; //Solución encontrada, ya tenemos 1 forma
		}
		if(objetivo < 0) {
			return 0; //Se ha pasado
		}
		if(indiceMoneda < 0) { //No tiene de esa moneda
			return 0;
		}
		
		int valorActual = valores[indiceMoneda]; //Guardamos la moneda con la que vamos a trabajar
		int cantidadDisponible = cantidades[indiceMoneda]; //Guardamos cantidad de esa moneda
		int formas = 0;
		
		//Probamos a usar desde 0 a cantidadDiponible monedas de este valor
		for(int i = 0; i <= cantidadDisponible; i++) {
			int sumaActual = i*valorActual;
			
			//Si nos pasamos dejamos de sumar (optimización)
			if(sumaActual > objetivo) {
				break;
				
			}
			
			//Llamada recursiva con el objetivo restante y pasando al siguiente tipo de moneda
			//Pasamos cantidades tal cual porque vamos a trabajar con otro tipo de moneda
			
			formas += contarAux(objetivo-sumaActual, cantidades, valores, indiceMoneda -1);
			}
		
		return formas;
		}

}
