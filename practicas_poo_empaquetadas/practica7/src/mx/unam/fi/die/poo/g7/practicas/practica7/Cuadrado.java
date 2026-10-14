package mx.unam.fi.die.poo.g7.practicas.practica7;

/**
 * Representa un cuadrado que hereda de {@link Rectangulo}.
 * Figura geometrica regular con cuatro lados y angulos iguales.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Cuadrado extends Rectangulo {

    /**
     * Construye un nuevo objeto Cuadrado con los cuatro vertices indicados.
     *
     * @param punto1 Primer vertice del cuadrado.
     * @param punto2 Segundo vertice del cuadrado.
     * @param punto3 Tercer vertice del cuadrado.
     * @param punto4 Cuarto vertice del cuadrado.
     */
    public Cuadrado(Punto punto1, Punto punto2, Punto punto3, Punto punto4) {
        super(punto1, punto2, punto3, punto4);
    }

    /**
     * Calcula y retorna el area del cuadrado (lado * lado).
     *
     * @return El area del cuadrado como un valor double.
     */
    public double CalcularArea() {
        double lado = getVertice2().getX() - getVertice1().getX();

        if (lado < 0) lado = -lado;

        return lado * lado;
    }

    /**
     * Sobrescribe el metodo polimorfico calcularArea de {@link Rectangulo}.
     * Delega la llamada a {@link #CalcularArea()} para garantizar la correcta interoperabilidad en la jerarquia.
     *
     * @return El area calculada del cuadrado como un valor double.
     */
    @Override
    public double calcularArea() {
        return CalcularArea();
    }
}
