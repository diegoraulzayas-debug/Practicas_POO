package mx.unam.fi.die.poo.g7.practicas.practica12;

/**
 * VISTA (MVC): Única clase encargada de mostrar la información de la simulación
 * del restaurante en pantalla (consola).
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class VistaRestaurante {

    /**
     * Constructor por defecto de la vista del restaurante.
     */
    public VistaRestaurante() {
    }

    /**
     * Muestra en consola cuando un cliente llega al restaurante.
     *
     * @param idCliente Identificador del cliente que llegó.
     */
    // Muestra cuando un cliente llega al restaurante
    public synchronized void mostrarLlegadaCliente(int idCliente) {
        System.out.println("Cliente " + idCliente + " llegó al restaurante.");
    }

    /**
     * Muestra en consola cuando un cliente registra un nuevo pedido.
     *
     * @param pedido Objeto {@link Pedido} realizado por el cliente.
     */
    // Muestra cuando un cliente registra un nuevo pedido
    public synchronized void mostrarPedidoRealizado(Pedido pedido) {
        System.out.println("Cliente " + pedido.getCliente() + " realizó un pedido: " + pedido.getPlatillo());
    }

    /**
     * Muestra en consola cuando un mesero toma un pedido de la cola compartida.
     *
     * @param nombreMesero Nombre del mesero que atiende el pedido.
     * @param pedido Objeto {@link Pedido} tomado de la cola.
     */
    // Muestra cuando un mesero toma un pedido de la cola
    public synchronized void mostrarPedidoTomado(String nombreMesero, Pedido pedido) {
        System.out.println(nombreMesero + " tomó el pedido del Cliente "
                + pedido.getCliente() + ": " + pedido.getPlatillo());
    }

    /**
     * Muestra en consola cuando la cocina comienza a preparar un platillo.
     *
     * @param pedido Objeto {@link Pedido} en preparación.
     */
    // Muestra cuando la cocina está preparando un platillo
    public synchronized void mostrarPreparacionCocina(Pedido pedido) {
        System.out.println("Cocina preparando " + pedido.getPlatillo()
                + " del Cliente " + pedido.getCliente() + "...");
    }

    /**
     * Muestra en consola cuando la cocina termina de preparar el platillo y es entregado.
     *
     * @param nombreMesero Nombre del mesero que atendió el pedido.
     * @param pedido Objeto {@link Pedido} finalizado.
     */
    // Muestra cuando la cocina termina el platillo y el mesero lo entrega
    public synchronized void mostrarPedidoTerminado(String nombreMesero, Pedido pedido) {
        System.out.println("Cocina terminó " + pedido.getPlatillo()
                + " del Cliente " + pedido.getCliente() + " (atendido por " + nombreMesero + ")");
    }

    /**
     * Muestra un mensaje en consola cuando un hilo es interrumpido.
     */
    // Muestra un mensaje de error si un hilo se interrumpe
    public synchronized void mostrarErrorHilo() {
        System.out.println("Hilo interrumpido...");
    }
}
