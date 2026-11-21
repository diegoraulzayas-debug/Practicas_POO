package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.Random;

/**
 * Representa a un cliente que realiza un pedido en un hilo de ejecución,
 * actualizando el Modelo ({@link ColaPedidos}) y notificando a la Vista
 * ({@link VistaRestaurante}).
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel
 *         Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Cliente implements Runnable {

    // Atributos del diagrama + referencia a la Vista (MVC)
    /** Identificador del cliente. */
    private int id;

    /** Cola compartida donde el cliente registra su pedido (Modelo). */
    private ColaPedidos cola;

    /** Vista encargada de mostrar los eventos del cliente en pantalla. */
    private VistaRestaurante vista;

    /**
     * Constructor que inicializa al cliente con su id, la cola compartida y la
     * vista.
     *
     * @param id    Identificador del cliente.
     * @param cola  Cola compartida de pedidos (Modelo).
     * @param vista Vista del restaurante para mostrar mensajes.
     */
    // Constructor del cliente
    public Cliente(int id, ColaPedidos cola, VistaRestaurante vista) {
        this.id = id;
        this.cola = cola;
        this.vista = vista;
    }

    /**
     * Ejecuta el hilo del cliente para realizar un pedido, agregarlo al Modelo
     * y actualizar la Vista.
     */
    // Tarea concurrente del cliente
    public void run() {
        Random rand = new Random();
        String[] platillos = { "Tacos", "Enchiladas", "Pozole", "Hamburguesa" };

        // Se notifica a la Vista que el cliente llegó
        vista.mostrarLlegadaCliente(id);

        // Simula el tiempo que tarda el cliente en decidir su pedido
        try {
            Thread.sleep(rand.nextInt(500));
        } catch (InterruptedException e) {
            vista.mostrarErrorHilo();
        }

        // Crea el pedido en el Modelo y lo agrega a la cola compartida
        String platillo = platillos[rand.nextInt(platillos.length)];
        Pedido pedido = new Pedido(id, platillo);
        cola.agregarPedido(pedido);

        // Se notifica a la Vista que el pedido fue realizado
        vista.mostrarPedidoRealizado(pedido);
    }
}
