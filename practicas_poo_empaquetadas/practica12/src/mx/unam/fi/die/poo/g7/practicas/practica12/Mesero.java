package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.Random;

/**
 * Representa a un mesero que toma pedidos del Modelo ({@link ColaPedidos}),
 * simula su preparación en cocina y actualiza la Vista ({@link VistaRestaurante})
 * en un hilo de ejecución.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Mesero implements Runnable {

    // Atributos del diagrama + referencia a la Vista (MVC)
    /** Nombre del mesero. */
    private String nombre;

    /** Cola compartida de donde el mesero toma los pedidos (Modelo). */
    private ColaPedidos cola;

    /** Vista encargada de mostrar los eventos de atención y cocina. */
    private VistaRestaurante vista;

    /**
     * Constructor que inicializa al mesero con su nombre y la cola compartida.
     *
     * @param nombre Nombre del mesero.
     * @param cola   Cola compartida de pedidos (Modelo).
     */
    public Mesero(String nombre, ColaPedidos cola) {
        this(nombre, cola, new VistaRestaurante());
    }

    /**
     * Constructor que inicializa al mesero con su nombre, la cola compartida y la vista.
     *
     * @param nombre Nombre del mesero.
     * @param cola Cola compartida de pedidos (Modelo).
     * @param vista Vista del restaurante para mostrar mensajes.
     */
    // Constructor del mesero
    public Mesero(String nombre, ColaPedidos cola, VistaRestaurante vista) {
        this.nombre = nombre;
        this.cola = cola;
        this.vista = vista;
    }

    /**
     * Ejecuta el hilo del mesero para tomar pedidos del Modelo, simular
     * su preparación en la cocina y actualizar la Vista.
     */
    // Tarea concurrente del mesero y preparación en cocina
    public void run() {
        Random rand = new Random();
        int atendidos = 0;

        // Cada mesero atiende 2 pedidos de la cola compartida
        while (atendidos < 2) {
            // Consulta al Modelo para tomar el siguiente pedido
            Pedido pedido = cola.tomarPedido();

            if (pedido != null) {
                // Actualiza la Vista indicando que el mesero tomó el pedido y cocina lo prepara
                vista.mostrarPedidoTomado(nombre, pedido);
                vista.mostrarPreparacionCocina(pedido);

                // Simula el tiempo de preparación en la cocina
                try {
                    Thread.sleep(rand.nextInt(500));
                } catch (InterruptedException e) {
                    vista.mostrarErrorHilo();
                }

                // Actualiza la Vista indicando que el platillo terminó de prepararse
                vista.mostrarPedidoTerminado(nombre, pedido);
                atendidos++;
            } else {
                // Si la cola aún está vacía, esperamos un momento antes de volver a revisar
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    vista.mostrarErrorHilo();
                }
            }
        }
    }
}
