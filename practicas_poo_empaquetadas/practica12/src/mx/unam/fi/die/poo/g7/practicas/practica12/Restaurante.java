package mx.unam.fi.die.poo.g7.practicas.practica12;

public class Restaurante {
    public static void main(String[] args) {
        ColaPedidos cola = new ColaPedidos();

        Thread c1 = new Thread(new Cliente(1, cola));
        Thread c2 = new Thread(new Cliente(2, cola));
        Thread c3 = new Thread(new Cliente(3, cola));
        Thread c4 = new Thread(new Cliente(4, cola));

        Thread m1 = new Thread(new Mesero("Mesero 1", cola));
        Thread m2 = new Thread(new Mesero("Mesero 2", cola));

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        m1.start();
        m2.start();
    }
}
