package palindromo;

public class Palindromo {
	
	//OPCIÓN 1
	public static boolean isPalindromo(String s) {
		if(s.length() <= 1) {
			System.out.println("La frase tiene que tener los caracteres > 1");
			return false;
		}
		
		int inicio=0;
		int fin=s.length();
		
		while(fin< inicio) {
			if(s.charAt(inicio) == ' ') {
				inicio++;
				continue;
			}
			if(s.charAt(fin) == ' ') {
				fin--;
				continue;
			}
			
			if(s.charAt(inicio) != s.charAt(fin)) {
				return false;
			}
			inicio++;
			fin--;
		}
		return true;
		
	}
	
	
	//OPCIÓN 2
	public static boolean isPalindromoMalo(String s) {
		if(s.length() <= 1) {
			System.out.println("La frase tiene que tener los caracteres > 1");
			return false;
		}
		
		s=s.toLowerCase();
		
		String sentenceClean = "";
		for(int i=0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				continue;
			}
			sentenceClean += s.charAt(i);
		}
		for(int i=0; i < sentenceClean.length(); i++) {
			for(int j=0; j < sentenceClean.length(); j++) {
				if(i + j == sentenceClean.length()-1) {
					if(sentenceClean.charAt(i) != sentenceClean.charAt(j)) {
					return false;	
					}
				}
			}
		}
		return true;
	}

}
