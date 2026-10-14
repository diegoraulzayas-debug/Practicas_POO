package mx.unam.fi.die.poo.g7.practicas.practica7;

/**
 * Representa un rectangulo que hereda de {@link Paralelogramo}.
 * Sus lados opuestos son paralelos y forman angulos rectos.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Rectangulo extends Paralelogramo {

    /**
     * Construye un nuevo objeto Rectangulo con los cuatro vertices especificados.
     *
     * @param punto1 Primer vertice del rectangulo.
     * @param punto2 Segundo vertice del rectangulo.
     * @param punto3 Tercer vertice del rectangulo.
     * @param punto4 Cuarto vertice del rectangulo.
     */
    public Rectangulo(Punto punto1, Punto punto2, Punto punto3, Punto punto4) {
        super(punto1, punto2, punto3, punto4);
    }

    /**
     * Calcula y retorna el area del rectangulo utilizando la implementacion
     * de la superclase {@link Paralelogramo}.
     *
     * @return El area del rectangulo como un valor double.
     */
    @Override
    public double calcularArea() {
        return super.calcularArea();
    }
}
