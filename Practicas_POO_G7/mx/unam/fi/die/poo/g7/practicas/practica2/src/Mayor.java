package mx.unam.fi.die.poo.g7.practicas.practica2;

import java.util.Scanner;

/**
 * Determina el número mayor de una serie ingresada.
 */
public class Mayor {
    /**
     * Solicita números y determina el mayor mediante un arreglo de cadenas de tipo String y realiza la operación sin devolver un valor.
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