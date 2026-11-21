import java.util.Random;

// Hilo de Cliente: genera pedidos en el Modelo y actualiza la Vista
public class Cliente implements Runnable {

    // Atributos del diagrama + referencia a la Vista (MVC)
    private int id;
    private ColaPedidos cola;
    private VistaRestaurante vista;

    // Constructor del cliente
    public Cliente(int id, ColaPedidos cola, VistaRestaurante vista) {
        this.id = id;
        this.cola = cola;
        this.vista = vista;
    }

    // Tarea concurrente del cliente
    public void run() {
        Random rand = new Random();
        String[] platillos = {"Tacos", "Enchiladas", "Pozole", "Hamburguesa"};

        // Se notifica a la Vista que el cliente llegó
        vista.mostrarLlegadaCliente(id);

        // Simula el tiempo para elegir un platillo
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
