package mx.unam.fi.die.poo.g7.practicas.practica7;

/**
 * Representa un paralelogramo que hereda de {@link Trapezoide}.
 * Sobrescribe el calculo del area aplicando la formula base por altura.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Paralelogramo extends Trapezoide {

    /**
     * Construye un nuevo objeto Paralelogramo con los cuatro vertices dados.
     *
     * @param punto1 Primer vertice.
     * @param punto2 Segundo vertice.
     * @param punto3 Tercer vertice.
     * @param punto4 Cuarto vertice.
     */
    public Paralelogramo(Punto punto1, Punto punto2, Punto punto3, Punto punto4) {
        super(punto1, punto2, punto3, punto4);
    }

    /**
     * Calcula y retorna el area del paralelogramo (base * altura).
     *
     * @return El area del paralelogramo como un valor double.
     */
    @Override
    public double calcularArea() {
        double base = getVertice2().getX() - getVertice1().getX();
        double altura = getVertice4().getY() - getVertice1().getY();

        if (base < 0)
            base = -base;
        if (altura < 0)
            altura = -altura;

        return base * altura;
    }
}
