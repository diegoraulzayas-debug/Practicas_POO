package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.Random;

/**
 * Representa a un mesero dentro del restaurante, modelado como una tarea concurrente
 * que implementa la interfaz {@link Runnable}.
 * <p>
 * El mesero actúa como consumidor en la arquitectura: monitorea la cola compartida
 * de comandas, extrae pedidos disponibles, simula el tiempo de preparación en cocina
 * y realiza el despacho correspondiente hasta alcanzar su cuota de servicio asignada.
 * </p>
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Mesero implements Runnable {

    /** Nombre o identificador descriptivo del mesero. */
    private String nombre;

    /** Referencia a la cola compartida de pedidos desde donde el mesero consume comandas. */
    private ColaPedidos cola;

    /**
     * Constructor que asigna el nombre del mesero y la cola compartida de pedidos.
     *
     * @param nombre Nombre o identificador asignado al mesero.
     * @param cola   Cola sincronizada de pedidos del restaurante.
     */
    public Mesero(String nombre, ColaPedidos cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

    /**
     * Ejecuta el hilo de trabajo del mesero para consumir pedidos de la cola compartida
     * y simular la preparación y entrega en cocina.
     * <p>
     * Cada mesero atiende una cuota predeterminada de 2 pedidos. Si la cola se encuentra vacía,
     * realiza una espera activa controlada (100 ms) antes de reintentar la extracción.
     * </p>
     */
    @Override
    public void run() {
        Random rand = new Random();
        int atendidos = 0;

        while (atendidos < 2) {
            Pedido pedido = cola.tomarPedido();

            if (pedido != null) {
                System.out.println(nombre + " tomó el pedido del Cliente "
                        + pedido.getCliente() + ": " + pedido.getPlatillo());
                System.out.println("Cocina preparando " + pedido.getPlatillo()
                        + " del Cliente " + pedido.getCliente() + "...");

                try {
                    Thread.sleep(rand.nextInt(500));
                } catch (InterruptedException e) {
                    System.out.println("Hilo de " + nombre + " interrumpido: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }

                System.out.println("Cocina terminó " + pedido.getPlatillo()
                        + " del Cliente " + pedido.getCliente() + " (atendido por " + nombre + ")");
                atendidos++;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Hilo de " + nombre + " en espera interrumpido: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
