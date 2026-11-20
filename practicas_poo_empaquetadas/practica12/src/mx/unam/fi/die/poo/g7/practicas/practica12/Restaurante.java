package mx.unam.fi.die.poo.g7.practicas.practica12;

/**
 * Clase controladora principal (Driver) que configura y orquesta la simulación
 * concurrente del restaurante utilizando hilos de ejecución independientes.
 * <p>
 * Instancia la cola compartida de pedidos, crea 4 tareas de clientes productores y 2
 * tareas de meseros consumidores, asignándolas a objetos {@link Thread} e iniciando
 * su concurrencia mediante {@link Thread#start()}.
 * </p>
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Restaurante {

    /**
     * Constructor por defecto de la clase de prueba controladora {@link Restaurante}.
     */
    public Restaurante() {
    }

    /**
     * Punto de entrada principal a la aplicación.
     * <p>
     * Inicializa los recursos compartidos, crea los hilos de clientes y meseros,
     * y lanza la ejecución asíncrona concurrente.
     * </p>
     *
     * @param args Argumentos recibidos desde la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // 1. Crear la cola compartida de pedidos (controla el orden de atención)
        ColaPedidos cola = new ColaPedidos();

        // 2. Crear los hilos para los clientes que llegan al restaurante
        Thread c1 = new Thread(new Cliente(1, cola));
        Thread c2 = new Thread(new Cliente(2, cola));
        Thread c3 = new Thread(new Cliente(3, cola));
        Thread c4 = new Thread(new Cliente(4, cola));

        // 3. Crear los hilos para los meseros que atenderán los pedidos
        Thread m1 = new Thread(new Mesero("Mesero 1", cola));
        Thread m2 = new Thread(new Mesero("Mesero 2", cola));

        // 4. Iniciar los hilos de los clientes y meseros de forma concurrente
        c1.start();
        c2.start();
        c3.start();
        c4.start();

        m1.start();
        m2.start();
    }
}
