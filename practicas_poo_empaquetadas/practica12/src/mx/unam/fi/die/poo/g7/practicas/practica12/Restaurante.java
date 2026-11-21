package mx.unam.fi.die.poo.g7.practicas.practica12;

/**
 * Clase principal que ensambla el Modelo ({@link ColaPedidos}), la Vista ({@link VistaRestaurante})
 * y el Controlador ({@link ControladorRestaurante}) para iniciar la simulación del restaurante con hilos.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Restaurante {

    /**
     * Constructor por defecto de la clase Restaurante.
     */
    public Restaurante() {
    }

    /**
     * Método principal que instancia el Modelo, la Vista y el Controlador (Patrón MVC)
     * e inicia la simulación concurrente del restaurante.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // 1. Crear el Modelo (cola compartida de pedidos)
        ColaPedidos cola = new ColaPedidos();

        // 2. Crear la Vista (encargada de toda la salida en consola)
        VistaRestaurante vista = new VistaRestaurante();

        // 3. Crear el Controlador (conecta el Modelo y la Vista con los hilos)
        ControladorRestaurante controlador = new ControladorRestaurante(cola, vista);

        // 4. Iniciar la simulación concurrente
        controlador.iniciarSimulacion();
    }
}
