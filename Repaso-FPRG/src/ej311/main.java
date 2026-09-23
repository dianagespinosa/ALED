package ej311;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Introduzca números enteros (0 para terminar)");
		
		int maximo = Integer.MIN_VALUE;
		int minimo = Integer.MAX_VALUE;
		long suma = 0;
		int contador = 0;
		
		boolean hayNumero = false;
		
		while(true) {
			System.out.print("Número: ");
			int numero = sc.nextInt();
			contador++;
			suma += numero;
			
			hayNumero = true;
			
			if(numero == 0) {
				break;
			}
			
			if(numero < minimo) {
				minimo = numero;
			}
			if(numero > maximo) {
				maximo = numero;
			}	
		}
		
		sc.close();
		double media = (double)suma/contador;
		System.out.println("Media: " + media);
		System.out.println("Máximo: " + maximo);
		System.out.println("Minimo: " + minimo);
		}
		
	}
	
