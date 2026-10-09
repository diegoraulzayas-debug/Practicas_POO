package mx.unam.fi.die.poo.g7.practicas.practica2;

/**
 * Clase que genera e imprime una tabla de potencias de diez para los numeros del 1 al 5.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Tabla {

    /**
     * Constructor por defecto de la clase Tabla.
     */
    public Tabla() {
    }

    /**
     * Metodo principal que imprime una tabla con las columnas n, 10*n, 100*n y 1000*n
     * para valores de n del 1 al 5.
     *
     * @param args Argumentos de la linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("n\t10*n\t100*n\t1000*n");
        
        for (int n = 1; n < 6; n++) {
            System.out.println(n + "\t" + (n * 10) + "\t" + (n * 100) + "\t" + (n * 1000));
        }
    }
}