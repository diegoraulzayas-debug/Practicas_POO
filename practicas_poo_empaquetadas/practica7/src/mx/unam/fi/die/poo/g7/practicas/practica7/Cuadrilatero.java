package mx.unam.fi.die.poo.g7.practicas.practica7;

/**
 * Representa una figura geometrica de cuatro lados (cuadrilatero) definida
 * por cuatro vertices en el plano cartesiano.
 * Sirve como clase base para figuras cuadrilateras mas especificas.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Cuadrilatero {

    // Atributos
    /** Primer vertice del cuadrilatero. */
    private Punto vertice1;
    /** Segundo vertice del cuadrilatero. */
    private Punto vertice2;
    /** Tercer vertice del cuadrilatero. */
    private Punto vertice3;
    /** Cuarto vertice del cuadrilatero. */
    private Punto vertice4;

    /**
     * Construye un nuevo objeto Cuadrilatero a partir de cuatro puntos que definen sus vertices.
     *
     * @param v1 Primer vertice del cuadrilatero.
     * @param v2 Segundo vertice del cuadrilatero.
     * @param v3 Tercer vertice del cuadrilatero.
     * @param v4 Cuarto vertice del cuadrilatero.
     */
    public Cuadrilatero(Punto v1, Punto v2, Punto v3, Punto v4) {
        this.vertice1 = v1;
        this.vertice2 = v2;
        this.vertice3 = v3;
        this.vertice4 = v4;
    }

    /**
     * Obtiene el primer vertice del cuadrilatero.
     *
     * @return El objeto {@link Punto} correspondiente al vertice 1.
     */
    public Punto getVertice1() {
        return vertice1;
    }

    /**
     * Obtiene el segundo vertice del cuadrilatero.
     *
     * @return El objeto {@link Punto} correspondiente al vertice 2.
     */
    public Punto getVertice2() {
        return vertice2;
    }

    /**
     * Obtiene el tercer vertice del cuadrilatero.
     *
     * @return El objeto {@link Punto} correspondiente al vertice 3.
     */
    public Punto getVertice3() {
        return vertice3;
    }

    /**
     * Obtiene el cuarto vertice del cuadrilatero.
     *
     * @return El objeto {@link Punto} correspondiente al vertice 4.
     */
    public Punto getVertice4() {
        return vertice4;
    }
}
