package mx.unam.fi.die.poo.g7.practicas.practica5;

import java.util.Scanner;

/**
 * Clase de prueba para la clase {@link Fecha}.
 * Solicita los datos de una fecha al usuario, muestra la fecha original,
 * permite modificar los valores de dia, mes y ano mediante setters y muestra la fecha modificada.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class MainFecha {

    /**
     * Constructor por defecto de la clase MainFecha.
     */
    public MainFecha() {
    }

    /**
     * Metodo principal que interactua con el usuario para crear una instancia
     * de {@link Fecha}, mostrarla, actualizar sus atributos y volver a mostrarla.
     *
     * @param args Argumentos de la linea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Ingresar fecha
        System.out.println("Ingrese el dia:");
        int dia = entrada.nextInt();

        System.out.println("Ingrese el mes:");
        int mes = entrada.nextInt();

        System.out.println("Ingrese el ano:");
        int anio = entrada.nextInt();

        // Crear un objeto Fecha
        Fecha fecha1 = new Fecha(dia, mes, anio);

        // Mostrar fecha
        System.out.println("Fecha ingresada:");
        fecha1.mostrarFecha();

        // Modificar la fecha
        System.out.println("\nIngrese el nuevo dia:");
        fecha1.setDia(entrada.nextInt());

        System.out.println("Ingrese el nuevo mes:");
        fecha1.setMes(entrada.nextInt());

        System.out.println("Ingrese el nuevo ano:");
        fecha1.setAnio(entrada.nextInt());

        // Mostrar fecha modificada
        System.out.println("\nFecha modificada:");
        fecha1.mostrarFecha();

        entrada.close();
    }
}
