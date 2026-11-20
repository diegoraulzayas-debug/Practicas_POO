package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.Random;

/**
 * Representa a un mesero que toma pedidos de la cola compartida y los envía a
 * cocina
 * en un hilo de ejecución.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel
 *         Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Mesero implements Runnable {

    /** Nombre del mesero. */
    private String nombre;

    /** Cola compartida de donde el mesero toma los pedidos. */
    private ColaPedidos cola;

    /**
     * Constructor que inicializa al mesero con su nombre y la cola compartida.
     *
     * @param nombre Nombre del mesero.
     * @param cola   Cola compartida de pedidos.
     */
    public Mesero(String nombre, ColaPedidos cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

    /**
     * Ejecuta el hilo del mesero para tomar pedidos de la cola y simular
     * su preparación en la cocina.
     */
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
                    System.out.println("Hilo interrumpido...");
                }

                System.out.println("Cocina terminó " + pedido.getPlatillo()
                        + " del Cliente " + pedido.getCliente() + " (atendido por " + nombre + ")");
                atendidos++;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido...");
                }
            }
        }
    }
}
