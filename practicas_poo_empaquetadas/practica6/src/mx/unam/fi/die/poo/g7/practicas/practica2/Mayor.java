package mx.unam.fi.die.poo.g7.practicas.practica2;

import java.util.Scanner;

/**
 * Clase que determina el numero de mayor magnitud entre diez enteros
 * ingresados por el usuario.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Mayor {

    /**
     * Constructor por defecto de la clase Mayor.
     */
    public Mayor() {
    }

    /**
     * Metodo principal que solicita diez numeros enteros, calcula el valor
     * absoluto de los negativos, encuentra el mayor y lo muestra por consola.
     *
     * @param args Argumentos de la linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cont = 0;
        int mayor =0;
        int num;

        while (cont < 10) {
            System.out.print("Ingresa un numero  ");
            num = sc.nextInt();
            if (num<0) {
                num=num*(-1);
            }
            if (num > mayor) {
                mayor = num;
            }

            cont++;
        }

        System.out.println("El numero mayor es: " + mayor);

        sc.close();
    }
}