package mx.unam.fi.die.poo.g7.practicas.practica12;

/**
 * MODELO (MVC): Representa los datos de un pedido realizado por un cliente en el restaurante.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Pedido {

    // Atributos encapsulados del pedido
    /** Identificador del cliente que realiza el pedido. */
    private int cliente;

    /** Nombre del platillo solicitado. */
    private String platillo;

    /**
     * Constructor que inicializa el pedido con el cliente y el platillo.
     *
     * @param cliente Identificador del cliente.
     * @param platillo Nombre del platillo.
     */
    // Constructor para asignar el cliente y el platillo solicitado
    public Pedido(int cliente, String platillo) {
        this.cliente = cliente;
        this.platillo = platillo;
    }

    // Getters para consultar los datos del pedido
    /**
     * Devuelve el identificador del cliente.
     *
     * @return Identificador del cliente.
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * Devuelve el platillo solicitado.
     *
     * @return Nombre del platillo.
     */
    public String getPlatillo() {
        return platillo;
    }
}
