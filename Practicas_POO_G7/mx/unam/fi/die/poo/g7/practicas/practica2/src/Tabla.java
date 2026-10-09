package mx.unam.fi.die.poo.g7.practicas.practica2;

/**
 * Genera e imprime una tabla de múltiplos.
 */
public class Tabla {
    /**
     * Genera la tabla mediante un arreglo de cadenas de tipo String y realiza la operación sin devolver un valor.
     */
    public static void main(String[] args) {
        System.out.println("n\t10*n\t100*n\t1000*n");
        
        for (int n = 1; n < 6; n++) {
            System.out.println(n + "\t" + (n * 10) + "\t" + (n * 100) + "\t" + (n * 1000));
        }
    }
}