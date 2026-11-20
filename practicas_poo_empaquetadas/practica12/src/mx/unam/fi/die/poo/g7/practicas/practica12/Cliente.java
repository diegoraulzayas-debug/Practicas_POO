package mx.unam.fi.die.poo.g7.practicas.practica12;

import java.util.Random;

public class Cliente implements Runnable {
    private int id;
    private ColaPedidos cola;

    public Cliente(int id, ColaPedidos cola) {
        this.id = id;
        this.cola = cola;
    }

    public void run() {
        Random rand = new Random();
        String[] platillos = {"Tacos", "Enchiladas", "Pozole", "Hamburguesa"};

        System.out.println("Cliente " + id + " llegó al restaurante.");

        try {
            Thread.sleep(rand.nextInt(500));
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido...");
        }

        String platillo = platillos[rand.nextInt(platillos.length)];
        Pedido pedido = new Pedido(id, platillo);
        cola.agregarPedido(pedido);
        System.out.println("Cliente " + id + " realizó un pedido: " + platillo);
    }
}
