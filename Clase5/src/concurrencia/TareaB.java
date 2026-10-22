package concurrencia;

public class TareaB implements Runnable { //otra manera:extends Thread 

	@Override
	public void run() {
		for(int i = 0; i < 10;i++) {
			System.out.println("B: " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return; //termino la hebra, la paro
			}
		}
		}
}
