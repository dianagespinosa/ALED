package condicion.carrera;

public class EjemploCarrera { //es otra hebra
	
	public static void main(String[] args) throws InterruptedException {
		
		Contador c = new Contador();
		Thread i1 = new Incrementador(c);
		Thread i2 = new Incrementador(c);
		
		i1.start(); //arranca la hebra
		i2.start();
		
		System.out.println(i1 == i2);
		
		i1.join(); //espera a que la hebra acabe
		i2.join();
		
		System.out.println(c.getValor());
	}

}
