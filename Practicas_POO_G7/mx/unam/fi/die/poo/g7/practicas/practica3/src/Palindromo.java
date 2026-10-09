package mx.unam.fi.die.poo.g7.practicas.practica3;

import java.util.Scanner;

/**
 * Verifica matemáticamente condiciones de números palíndromos.
 */
public class Palindromo {

    /**
     * Solicita un número para comprobar si es palíndromo mediante un arreglo de cadenas de tipo String y realiza la operación sin devolver un valor.
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
     * Comprueba matemáticamente si una cifra es palíndromo mediante un entero de tipo int y devuelve un valor booleano de tipo boolean.
     */
    public static boolean esPalindromo(int num) {
        
        if ((num / 10000 == num % 10) && ((num / 1000) % 10 == (num / 10) % 10)) {
            return true;
        } else {
            return false;
        }
    }
}