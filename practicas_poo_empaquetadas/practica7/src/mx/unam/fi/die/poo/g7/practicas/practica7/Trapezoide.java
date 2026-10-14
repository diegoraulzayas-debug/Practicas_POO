package mx.unam.fi.die.poo.g7.practicas.practica7;

/**
 * Representa un trapezoide que hereda de la clase {@link Cuadrilatero}.
 * Proporciona el calculo del area a partir de la longitud de sus bases y su altura.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Trapezoide extends Cuadrilatero {

    // Atributos
    /** Area calculada del trapezoide. */
    private double area;

    /**
     * Construye un nuevo objeto Trapezoide con los cuatro vertices indicados.
     *
     * @param punto1 Primer vertice inferior izquierdo.
     * @param punto2 Segundo vertice inferior derecho.
     * @param punto3 Tercer vertice superior derecho.
     * @param punto4 Cuarto vertice superior izquierdo.
     */
    public Trapezoide(Punto punto1, Punto punto2, Punto punto3, Punto punto4) {
        super(punto1, punto2, punto3, punto4);
    }

    /**
     * Calcula y retorna el area del trapezoide utilizando las longitudes
     * de su base mayor, base menor y altura.
     *
     * @return El area del trapezoide como un valor double.
     */
    public double calcularArea() {
        double baseM = getVertice2().getX() - getVertice1().getX();
        double basem = getVertice3().getX() - getVertice4().getX();
        double altura = getVertice4().getY() - getVertice1().getY();

        if (baseM < 0)
            baseM = -baseM;
        if (basem < 0)
            basem = -basem;
        if (altura < 0)
            altura = -altura;

        this.area = ((baseM + basem) * altura) / 2.0;
        return this.area;
    }
}
