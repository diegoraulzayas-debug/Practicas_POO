// CONTROLADOR: Conecta el Modelo (ColaPedidos) con la Vista (VistaRestaurante)
// y coordina la ejecución concurrente de los hilos de Clientes y Meseros
public class ControladorRestaurante {

    // Referencias al Modelo y a la Vista
    private ColaPedidos cola;
    private VistaRestaurante vista;

    // Constructor del controlador
    public ControladorRestaurante(ColaPedidos cola, VistaRestaurante vista) {
        this.cola = cola;
        this.vista = vista;
    }

    // Crea e inicia los hilos de clientes y meseros
    public void iniciarSimulacion() {
        // Hilos de los clientes
        Thread c1 = new Thread(new Cliente(1, cola, vista));
        Thread c2 = new Thread(new Cliente(2, cola, vista));
        Thread c3 = new Thread(new Cliente(3, cola, vista));
        Thread c4 = new Thread(new Cliente(4, cola, vista));

        // Hilos de los meseros
        Thread m1 = new Thread(new Mesero("Mesero 1", cola, vista));
        Thread m2 = new Thread(new Mesero("Mesero 2", cola, vista));

        // Iniciar todos los hilos de forma concurrente
        c1.start();
        c2.start();
        c3.start();
        c4.start();

        m1.start();
        m2.start();
    }
}
