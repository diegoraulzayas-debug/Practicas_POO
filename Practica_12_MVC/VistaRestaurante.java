// VISTA: Única clase encargada de mostrar la información en pantalla (consola)
public class VistaRestaurante {

    // Muestra cuando un cliente llega al restaurante
    public synchronized void mostrarLlegadaCliente(int idCliente) {
        System.out.println("Cliente " + idCliente + " llegó al restaurante.");
    }

    // Muestra cuando un cliente registra un nuevo pedido
    public synchronized void mostrarPedidoRealizado(Pedido pedido) {
        System.out.println("Cliente " + pedido.getCliente() + " realizó un pedido: " + pedido.getPlatillo());
    }

    // Muestra cuando un mesero toma un pedido de la cola
    public synchronized void mostrarPedidoTomado(String nombreMesero, Pedido pedido) {
        System.out.println(nombreMesero + " tomó el pedido del Cliente "
                + pedido.getCliente() + ": " + pedido.getPlatillo());
    }

    // Muestra cuando la cocina está preparando un platillo
    public synchronized void mostrarPreparacionCocina(Pedido pedido) {
        System.out.println("Cocina preparando " + pedido.getPlatillo()
                + " del Cliente " + pedido.getCliente() + "...");
    }

    // Muestra cuando la cocina termina el platillo y el mesero lo entrega
    public synchronized void mostrarPedidoTerminado(String nombreMesero, Pedido pedido) {
        System.out.println("Cocina terminó " + pedido.getPlatillo()
                + " del Cliente " + pedido.getCliente() + " (atendido por " + nombreMesero + ")");
    }

    // Muestra un mensaje de error si un hilo se interrumpe
    public synchronized void mostrarErrorHilo() {
        System.out.println("Hilo interrumpido...");
    }
}
