package ej03;

public class Main {
	
	//Configuración del número de hebras
			private static final int NUM_LECTORAS = 300;
			private static final int RATIO_LECTORAS_ESCRITORAS = 10;
			
			public static void main(String[] args) {
				// Recurso compartido (monitor)
				RecursoCompartido recurso = new RecursoCompartido();
				Prioridad[] prioridades = Prioridad.values();

				System.out.println("Iniciando: " + NUM_LECTORAS + " lectoras y " +
									NUM_LECTORAS / RATIO_LECTORAS_ESCRITORAS + " escritoras.");
				try {
					// Crear y arrancar hebras
					for (int i = 0; i < NUM_LECTORAS; i++) {
						Prioridad pLectora = prioridades[(int) (Math.random()*prioridades.length)];
						Thread t1 = new HebraLectora(recurso, "L" + i, pLectora);
						t1.start();
						// 1 escritora por cada N lectoras
						if (i % RATIO_LECTORAS_ESCRITORAS == 0) {
							Prioridad pEscritora = prioridades[(int) (Math.random()*prioridades.length)];
							Thread t2 = new HebraEscritora(recurso, "E" + i, pEscritora);
							t2.start();
						}
						// Esperar hasta 500 ms entre creación de hebras.
						Thread.sleep((long) (Math.random() * 500));
					}
				} catch (InterruptedException e) {}
			}

}
