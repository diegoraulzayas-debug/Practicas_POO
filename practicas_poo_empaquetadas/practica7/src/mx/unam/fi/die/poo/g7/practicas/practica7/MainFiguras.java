package mx.unam.fi.die.poo.g7.practicas.practica7;

/**
 * Clase principal de prueba para la jerarquia de cuadrilateros.
 * Crea instancias de {@link Trapezoide}, {@link Paralelogramo},
 * {@link Rectangulo} y {@link Cuadrado}, e imprime en consola
 * el area calculada para cada una de ellas.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class MainFiguras {

    /**
     * Constructor por defecto de la clase MainFiguras.
     */
    public MainFiguras() {
    }

    /**
     * Metodo principal de ejecucion que inicializa los vertices de cada figura,
     * instancia los objetos correspondientes y muestra el calculo de sus areas.
     *
     * @param args Argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Punto t1 = new Punto(0, 0);
        Punto t2 = new Punto(8, 0);
        Punto t3 = new Punto(6, 4);
        Punto t4 = new Punto(2, 4);
        Trapezoide trapezoide = new Trapezoide(t1, t2, t3, t4);

        Punto p1 = new Punto(0, 0);
        Punto p2 = new Punto(6, 0);
        Punto p3 = new Punto(8, 4);
        Punto p4 = new Punto(2, 4);
        Paralelogramo paralelogramo = new Paralelogramo(p1, p2, p3, p4);

        Punto r1 = new Punto(0, 0);
        Punto r2 = new Punto(6, 0);
        Punto r3 = new Punto(6, 4);
        Punto r4 = new Punto(0, 4);
        Rectangulo rectangulo = new Rectangulo(r1, r2, r3, r4);

        Punto c1 = new Punto(0, 0);
        Punto c2 = new Punto(5, 0);
        Punto c3 = new Punto(5, 5);
        Punto c4 = new Punto(0, 5);
        Cuadrado cuadrado = new Cuadrado(c1, c2, c3, c4);

        System.out.println("Area del Trapezoide: " + trapezoide.calcularArea());
        System.out.println("Area del Paralelogramo: " + paralelogramo.calcularArea());
        System.out.println("Area del Rectangulo: " + rectangulo.calcularArea());
        System.out.println("Area del Cuadrado: " + cuadrado.CalcularArea());
    }
}
