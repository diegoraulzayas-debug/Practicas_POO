package mx.unam.fi.die.poo.g7.practicas.practica4;

import java.util.Scanner;

public class Main {

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

