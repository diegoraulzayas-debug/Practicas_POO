package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Estructura de datos sincronizada que representa el búfer o cola compartida de pedidos
 * en el restaurante bajo el patrón Productor-Consumidor.
 * <p>
 * Los métodos de inserción y retiro son sincronizados con el monitor intrínseco
 * de la instancia (bloqueo a nivel de método mediante {@code synchronized}),
 * garantizando la consistencia y ausencia de condiciones de carrera (race conditions)
 * entre los hilos de clientes (productores) y meseros (consumidores).
 * </p>
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class ColaPedidos {

    /** Cola interna de pedidos basada en FIFO (First-In, First-Out). */
    private Queue<Pedido> pedidos = new LinkedList<>();

    /**
     * Constructor por defecto de la cola sincronizada de pedidos.
     */
    public ColaPedidos() {
    }

    /**
     * Agrega un pedido a la cola compartida de manera sincronizada y segura para hilos.
     *
     * @param pedido Instancia de {@link Pedido} emitido por un cliente que ingresa a la cola.
     */
    public synchronized void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    /**
     * Extrae y retira el siguiente pedido disponible al frente de la cola de manera sincronizada.
     *
     * @return El siguiente objeto {@link Pedido} en la cola FIFO, o {@code null} si la cola está vacía.
     */
    public synchronized Pedido tomarPedido() {
        return pedidos.poll();
    }
}
