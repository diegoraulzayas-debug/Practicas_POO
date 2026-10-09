package mx.unam.fi.die.poo.g7.practicas.practica4;

import java.util.Scanner;

/**
 * Prueba la funcionalidad del analizador de palabras.
 */
public class Main {

    /**
     * Inicia la ejecución del programa mediante un arreglo de cadenas de tipo String y realiza la operación sin devolver un valor.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Ingrese una oracion:");
        String oracion = scanner.nextLine();

        analizadorPalabras analizador = new analizadorPalabras(oracion);

        analizador.contarPalabras();

        int duplicados = analizador.obtenerNumerosDuplicados();

        System.out.println("\nNumero de palabras duplicadas: " + duplicados);

        System.out.println("\nPalabras duplicadas ordenadas:");
        analizador.mostrarDuplicados(true);

        scanner.close();
    }
}

