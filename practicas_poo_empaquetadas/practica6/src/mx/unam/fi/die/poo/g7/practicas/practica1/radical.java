package mx.unam.fi.die.poo.g7.practicas.practica1;

import java.util.Scanner;

/**
 * Clase que calcula la raiz n-esima de un numero ingresado por el usuario.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class radical {

	/**
	 * Constructor por defecto de la clase radical.
	 */
	public radical() {
	}

	/**
	 * Metodo principal que solicita por consola un radicando y un indice
	 * para calcular y mostrar el resultado de la raiz correspondiente.
	 *
	 * @param args Argumentos de la linea de comandos (no utilizados).
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