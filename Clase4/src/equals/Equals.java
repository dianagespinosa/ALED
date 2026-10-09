package equals;

public class Equals {
	
	public static void main(String[] args) {
		int a = 5;
		int b = 5;
		// char / double / float / long...
		
		String s1 = "Hola";
		String s2 = "Hola";
		
		//System.out.println(s1.equals(s2)); //podemos poner también s1 == s2
		
		//Double / Integer / Long
		Integer i1 = 1; //hay un num en el que antes de ese todo los elem se consideran iguales
		Integer i2 = 1;
		
		System.out.println(i1 == i2);
	}

}
