package ej03;

public class RecursoCompartido {
	
	//Recurso compartido
		private Integer entero = null;
		
		private int numLectores = 0;
		private boolean escribiendo = false;
		
		// Contadores de hebras esperando por prioridad
	    // Indices: 0=BAJA, 1=MEDIA, 2=ALTA (coincide con el ordinal del Enum)
		private int[] lectoresEsperando = {0,0,0};
		private int[] escritoresEsperando = {0,0,0};
		
		//LECTURA con prioridad
		
		public void leer(String nombreLector, Prioridad p) throws InterruptedException {
			// 1. Adquirir permiso de lectura
			this.accesoLectura(nombreLector, p);
			// 2. Acción de lectura (Fuera de sincronización) 
			Integer valorLeido = this.entero; // Se lee la referencia al objeto
			System.out.println("!!!Lector " + nombreLector +" (" + p + ") está leyendo. Valor = " + valorLeido);
			// Espera hasta 500 ms
			Thread.sleep((long) (Math.random()*500));
			// 3. Liberar permiso de lectura
			this.terminaLectura(nombreLector, p);
		}
		
		private synchronized void accesoLectura(String nombreLector, Prioridad p) throws InterruptedException {
			// Registrar que estamos esperando
			lectoresEsperando[p.ordinal()]++;
			
			try {
			// CONDICIÓN DE ESPERA:
            // 1. Si alguien está escribiendo
            // 2. Si el entero es null (no inicializado)
            // 3. PRIORIDAD: Si hay ESCRITORES de MAYOR prioridad esperando
			while(escribiendo || this.entero == null || hayEscritoresMayorPrioridad(p)) {
				System.out.println("...Lector " + nombreLector + " (" + p + ") espera.");
				wait();
			} // Ya no estamos esperando (o hemos entrado o ha saltado excepción)
			}finally {
				lectoresEsperando[p.ordinal()]--;
			}
			numLectores++;
			System.out.println(">>>Lector " + nombreLector + " (" + p + ") entra.");
		}
		
		private synchronized void terminaLectura(String nombreLector, Prioridad p) throws InterruptedException {
			numLectores--;
			if(numLectores == 0) {
				notifyAll();
			}
			System.out.println("<<<Lector " + nombreLector +" (" + p + ") ha terminado de leer.");
		}
		
		//ESCRITURA con prioridad
		
		public void escribir(String nombreEscritor, Prioridad p) throws InterruptedException {
			// 1. Adquirir permiso de escritura
			this.accesoEscritura(nombreEscritor, p);
			// 2. Acción de escritura
			// El entero se genera aleatoriamente
			this.entero = (int) (Math.random()*10001);
			System.out.println("!!!Escritor " + nombreEscritor +" (" + p + ") escribe nuevo valor " + this.entero);
			// Espera hasta 500 ms
			Thread.sleep((long) (Math.random()*500));
			// 3. Liberar permiso de escritura
			this.terminaEscritura(nombreEscritor, p);
		}
		
		private synchronized void accesoEscritura(String nombreEscritor, Prioridad p) throws InterruptedException {
			// Registrar que estamos esperando
			escritoresEsperando[p.ordinal()]++;
			
			try {
				// CONDICIÓN DE ESPERA:
	            // 1. Si hay lectores dentro
	            // 2. Si hay otro escritor dentro
	            // 3. PRIORIDAD A: Si hay CUALQUIER hebra (L o E) de MAYOR prioridad esperando
	            // 4. PRIORIDAD B: Si hay LECTORES de MI MISMA prioridad (Los lectores ganan empates)
			while(escribiendo || numLectores > 0 || hayAlguienMayorPrioridad(p) || lectoresEsperando[p.ordinal()] > 0) {
				System.out.println("...Escritor " + nombreEscritor + " (" + p + ") espera para escribir.");
				wait();
			} // Ya no estamos esperando (o hemos entrado o ha saltado excepción)
		}finally {
			escritoresEsperando[p.ordinal()]--;
		}
			escribiendo = true;
			System.out.println(">>>Escritor " + nombreEscritor +" (" + p + ") ha empezado a escribir.");
		}
		
		private synchronized void terminaEscritura(String nombreEscritor, Prioridad p) {
			escribiendo = false;
			notifyAll();
			System.out.println("<<<Escritor " + nombreEscritor + " (" + p + ") ha terminado de escribir.");
		}
		
	    // --- Métodos auxiliares de prioridad ---

	    // Devuelve true si hay algún escritor con prioridad estricta mayor que 'p'
		private boolean hayEscritoresMayorPrioridad(Prioridad p) {
			for(int i = p.ordinal()+1; i < 3; i++) {
				if(escritoresEsperando[i] > 0) {
					return true;
				}
			}
			return false;
		}
		
		// Devuelve true si hay cualquier hebra (L o E) con prioridad estricta mayor que 'p'
		private boolean hayAlguienMayorPrioridad(Prioridad p) {
			for(int i = p.ordinal()+1; i < 3; i++) {
				if(escritoresEsperando[i] > 0 || lectoresEsperando[i] > 0) {
					return true;
				}
			}
			return false;
		}


}
