package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.LinkedList;
import java.util.Queue;

public class ColaPedidos {
    private Queue<Pedido> pedidos = new LinkedList<>();

    public synchronized void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public synchronized Pedido tomarPedido() {
        return pedidos.poll();
    }
}
