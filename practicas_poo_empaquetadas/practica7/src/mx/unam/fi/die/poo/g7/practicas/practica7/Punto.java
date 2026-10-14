package mx.unam.fi.die.poo.g7.practicas.practica7;

/**
 * Representa un punto bidimensional en el plano cartesiano mediante
 * sus coordenadas x e y.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Punto {

    // Atributos
    /** Coordenada en el eje X. */
    private double x;
    /** Coordenada en el eje Y. */
    private double y;

    /**
     * Construye un nuevo objeto Punto con las coordenadas especificadas.
     *
     * @param x Coordenada en el eje X.
     * @param y Coordenada en el eje Y.
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene la coordenada en el eje X del punto.
     *
     * @return El valor de la coordenada X.
     */
    public double getX() {
        return x;
    }

    /**
     * Obtiene la coordenada en el eje Y del punto.
     *
     * @return El valor de la coordenada Y.
     */
    public double getY() {
        return y;
    }
}
