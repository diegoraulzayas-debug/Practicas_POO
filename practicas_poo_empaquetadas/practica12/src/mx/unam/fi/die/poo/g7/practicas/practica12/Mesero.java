package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.Random;

public class Mesero implements Runnable {
    private String nombre;
    private ColaPedidos cola;

    public Mesero(String nombre, ColaPedidos cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

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
