package mx.unam.fi.die.poo.g7.practicas.practica12;

public class Pedido {
    private int cliente;
    private String platillo;

    public Pedido(int cliente, String platillo) {
        this.cliente = cliente;
        this.platillo = platillo;
    }

    public int getCliente() {
        return cliente;
    }

    public String getPlatillo() {
        return platillo;
    }
}
