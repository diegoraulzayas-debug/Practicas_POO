package mx.unam.fi.die.poo.g7.practicas.practica4;

import java.util.Scanner;

/**
 * Clase principal para la Practica 4.
 * Solicita una oracion al usuario, realiza el analisis de palabras duplicadas
 * y muestra los resultados tanto de forma cuantitativa como ordenada alfabeticamente.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Main {

    /**
     * Constructor por defecto de la clase Main.
     */
    public Main() {
    }

    /**
     * Metodo principal que ejecuta la interaccion con el usuario para ingresar una
     * oracion, delegar el analisis a {@link analizadorPalabras} y presentar las
     * palabras duplicadas ordenadas.
     *
     * @param args Argumentos de la linea de comandos (no utilizados).
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
