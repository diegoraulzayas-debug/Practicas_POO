import java.util.Random;

// Hilo de Mesero: consume pedidos del Modelo (ColaPedidos) y actualiza la Vista
public class Mesero implements Runnable {

    // Atributos del diagrama + referencia a la Vista (MVC)
    private String nombre;
    private ColaPedidos cola;
    private VistaRestaurante vista;

    // Constructor del mesero
    public Mesero(String nombre, ColaPedidos cola, VistaRestaurante vista) {
        this.nombre = nombre;
        this.cola = cola;
        this.vista = vista;
    }

    // Tarea concurrente del mesero y preparación en cocina
    public void run() {
        Random rand = new Random();
        int atendidos = 0;

        while (atendidos < 2) {
            // Consulta al Modelo para tomar el siguiente pedido
            Pedido pedido = cola.tomarPedido();

            if (pedido != null) {
                // Actualiza la Vista indicando que el mesero tomó el pedido y cocina lo prepara
                vista.mostrarPedidoTomado(nombre, pedido);
                vista.mostrarPreparacionCocina(pedido);

                // Simula el tiempo de preparación en la cocina
                try {
                    Thread.sleep(rand.nextInt(500));
                } catch (InterruptedException e) {
                    vista.mostrarErrorHilo();
                }

                // Actualiza la Vista indicando que el platillo terminó de prepararse
                vista.mostrarPedidoTerminado(nombre, pedido);
                atendidos++;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    vista.mostrarErrorHilo();
                }
            }
        }
    }
}
