package mx.unam.fi.die.poo.g7.practicas.practica3;

import java.util.Scanner;

/**
 * Clase que determina si un numero entero de cinco digitos es palindromo (capicua).
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Palindromo {

    /**
     * Constructor por defecto de la clase Palindromo.
     */
    public Palindromo() {
    }

    /**
     * Metodo principal que solicita al usuario un numero de 5 digitos,
     * valida la cantidad de digitos y evalua si es palindromo.
     *
     * @param args Argumentos de la linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingresa un numero entero de 5 digitos:");
        int num = sc.nextInt();

        if (num<0) {
            num=num*(-1);
            
        }
        
        
        while (num < 10000 || num > 99999) {
            System.out.println("Error: el numero debe tener 5 digitos");
            System.out.println("Ingresa el nuevo numero:");
            num = sc.nextInt();
        }
        
      
        if (esPalindromo(num)) {
            System.out.println(num + " es un palindromo");
        } else {
            System.out.println(num + " no es un palindromo");
        }
        
        sc.close();
    }

    /**
     * Determina si un numero entero de cinco digitos es palindromo
     * comparando el primer digito con el ultimo, y el segundo con el penultimo.
     *
     * @param num Numero entero de 5 digitos a verificar.
     * @return {@code true} si el numero es palindromo; {@code false} en caso contrario.
     */
    public static boolean esPalindromo(int num) {
        
        if ((num / 10000 == num % 10) && ((num / 1000) % 10 == (num / 10) % 10)) {
            return true;
        } else {
            return false;
        }
    }
}