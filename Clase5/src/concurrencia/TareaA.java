package concurrencia;

public class TareaA extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i < 10;i++) {
			System.out.println("A: " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
