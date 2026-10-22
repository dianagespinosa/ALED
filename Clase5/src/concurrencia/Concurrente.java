package concurrencia;

public class Concurrente {
	
	public static void main(String[] args) {
		Thread a = new TareaA();
		Thread b = new TareaB();
		
		a.run(); //NO run
		b.run();
	}

}
