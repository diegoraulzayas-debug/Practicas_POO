import java.util.Scanner;

public class radical {
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