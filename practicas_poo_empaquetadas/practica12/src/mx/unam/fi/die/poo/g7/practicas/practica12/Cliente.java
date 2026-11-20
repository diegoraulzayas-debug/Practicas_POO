package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.Random;

/**
 * Representa a un cliente dentro de la simulación del restaurante, modelado
 * como una tarea concurrente que implementa la interfaz {@link Runnable}.
 * <p>
 * Cada cliente posee un identificador numérico único y una referencia a la cola
 * compartida de pedidos. En su ejecución, simula el tiempo de decisión,
 * elige un platillo aleatorio de la carta, construye una comanda ({@link Pedido})
 * y la encola de forma segura en la estructura sincronizada del restaurante.
 * </p>
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Cliente implements Runnable {

    /** Identificador numérico único asignado al cliente. */
    private int id;

    /** Referencia a la cola compartida donde el cliente registra su pedido de forma concurrente. */
    private ColaPedidos cola;

    /**
     * Constructor que inicializa al cliente con su identificador y la cola compartida.
     *
     * @param id   Identificador numérico asignado al cliente (debe ser positivo).
     * @param cola Cola sincronizada de pedidos compartida en el restaurante.
     */
    public Cliente(int id, ColaPedidos cola) {
        this.id = id;
        this.cola = cola;
    }

    /**
     * Ejecuta el hilo del cliente para seleccionar un platillo y registrar su pedido en la cola compartida.
     * <p>
     * El proceso simula la deliberación del cliente mediante una pausa pseudoaleatoria,
     * selecciona un platillo disponible en el menú, genera un objeto {@link Pedido}
     * y lo agrega a la cola compartida.
     * </p>
     */
    @Override
    public void run() {
        Random rand = new Random();
        String[] platillos = {"Tacos", "Enchiladas", "Pozole", "Hamburguesa"};

        System.out.println("Cliente " + id + " llegó al restaurante.");

        try {
            Thread.sleep(rand.nextInt(500));
        } catch (InterruptedException e) {
            System.out.println("Hilo del Cliente " + id + " interrumpido: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        String platillo = platillos[rand.nextInt(platillos.length)];
        Pedido pedido = new Pedido(id, platillo);
        cola.agregarPedido(pedido);
        System.out.println("Cliente " + id + " realizó un pedido: " + platillo);
    }
}
