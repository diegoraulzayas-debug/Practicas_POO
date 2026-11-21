package mx.unam.fi.die.poo.g7.practicas.practica12;

/**
 * CONTROLADOR (MVC): Conecta el Modelo ({@link ColaPedidos}) con la Vista ({@link VistaRestaurante})
 * y coordina la ejecución concurrente de los hilos de {@link Cliente} y {@link Mesero}.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class ControladorRestaurante {

    // Referencias al Modelo y a la Vista
    /** Referencia a la cola compartida de pedidos (Modelo). */
    private ColaPedidos cola;

    /** Referencia a la vista encargada de la salida en consola (Vista). */
    private VistaRestaurante vista;

    /**
     * Constructor que asocia el Modelo y la Vista al Controlador.
     *
     * @param cola Cola compartida de pedidos (Modelo).
     * @param vista Vista del restaurante (Vista).
     */
    // Constructor del controlador
    public ControladorRestaurante(ColaPedidos cola, VistaRestaurante vista) {
        this.cola = cola;
        this.vista = vista;
    }

    /**
     * Crea e inicia los hilos concurrentes de los clientes y los meseros.
     */
    // Crea e inicia los hilos de clientes y meseros
    public void iniciarSimulacion() {
        // Hilos de los clientes
        Thread c1 = new Thread(new Cliente(1, cola, vista));
        Thread c2 = new Thread(new Cliente(2, cola, vista));
        Thread c3 = new Thread(new Cliente(3, cola, vista));
        Thread c4 = new Thread(new Cliente(4, cola, vista));

        // Hilos de los meseros
        Thread m1 = new Thread(new Mesero("Mesero 1", cola, vista));
        Thread m2 = new Thread(new Mesero("Mesero 2", cola, vista));

        // Iniciar todos los hilos de forma concurrente
        c1.start();
        c2.start();
        c3.start();
        c4.start();

        m1.start();
        m2.start();
    }
}
