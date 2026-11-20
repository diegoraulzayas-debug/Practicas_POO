package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.Random;

/**
 * Representa a un cliente que realiza un pedido en un hilo de ejecución.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel
 *         Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Cliente implements Runnable {

    /** Identificador del cliente. */
    private int id;

    /** Cola compartida donde el cliente registra su pedido. */
    private ColaPedidos cola;

    /**
     * Constructor que inicializa al cliente con su id y la cola compartida.
     *
     * @param id   Identificador del cliente.
     * @param cola Cola compartida de pedidos.
     */
    public Cliente(int id, ColaPedidos cola) {
        this.id = id;
        this.cola = cola;
    }

    /**
     * Ejecuta el hilo del cliente para realizar un pedido y agregarlo a la cola.
     */
    public void run() {
        Random rand = new Random();
        String[] platillos = { "Tacos", "Enchiladas", "Pozole", "Hamburguesa" };

        System.out.println("Cliente " + id + " llegó al restaurante.");

        try {
            Thread.sleep(rand.nextInt(500));
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido...");
        }

        String platillo = platillos[rand.nextInt(platillos.length)];
        Pedido pedido = new Pedido(id, platillo);
        cola.agregarPedido(pedido);
        System.out.println("Cliente " + id + " realizó un pedido: " + platillo);
    }
}
