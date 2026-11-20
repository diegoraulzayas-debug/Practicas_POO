package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Cola compartida de pedidos controlada con métodos sincronizados.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel
 *         Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class ColaPedidos {

    /** Cola donde se almacenan los pedidos en orden de llegada. */
    private Queue<Pedido> pedidos = new LinkedList<>();

    /**
     * Constructor por defecto de la cola de pedidos.
     */
    public ColaPedidos() {
    }

    /**
     * Agrega un pedido a la cola compartida de manera sincronizada.
     *
     * @param pedido Pedido realizado por un cliente.
     */
    public synchronized void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    /**
     * Toma y retira el siguiente pedido disponible en la cola de manera
     * sincronizada.
     *
     * @return El siguiente {@link Pedido} en la cola, o {@code null} si está vacía.
     */
    public synchronized Pedido tomarPedido() {
        return pedidos.poll();
    }
}
