package concurrencia;

public class Concurrente {
	
	public static void main(String[] args) throws InterruptedException{
		Runnable tareaA = new TareaA();
		Runnable tareaB = new TareaB();
		
		Thread a = new Thread(tareaA);
		Thread b = new Thread(tareaB);
		
		a.start(); //NO run
		b.start();
		
		//a.interrupt();
		//b.interrupt();
		
		//Thread.sleep(10000); //10s (está en ms)
		
		a.join();
		b.join();
		
		System.out.println("Trabajo terminado.");
	}

}
