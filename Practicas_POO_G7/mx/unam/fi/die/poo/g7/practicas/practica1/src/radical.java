package mx.unam.fi.die.poo.g7.practicas.practica1;

import java.util.Scanner;

/**
 * Realiza el cálculo de la raíz de un número.
 */
public class radical {
	/**
	 * Solicita datos para calcular la raíz mediante un arreglo de cadenas de tipo String y realiza la operación sin devolver un valor.
	 */
	public static void main(String[] args) {
		
		Scanner open = new Scanner(System.in);
		double radicando;
		double answer; 
		int root; 
		
		System.out.println("Pasame tu primer numero (radicando): ");
		radicando = open.nextDouble();
		System.out.print("pasame el segundo valor, o sea indice: ");
		root = open.nextInt();
		
		answer = Math.pow(radicando, 1.0/root);
		System.out.println("su valor de raiz calculado es: " + answer);
		open.close();
	}
}