import java.util.LinkedList;
import java.util.Queue;

// MODELO: Administra la cola compartida de pedidos de forma sincronizada
public class ColaPedidos {

    // Cola donde se guardan los pedidos en orden de llegada
    private Queue<Pedido> pedidos = new LinkedList<>();

    // Método sincronizado para agregar un pedido a la cola
    public synchronized void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Método sincronizado para tomar el siguiente pedido de la cola
    public synchronized Pedido tomarPedido() {
        return pedidos.poll();
    }
}
