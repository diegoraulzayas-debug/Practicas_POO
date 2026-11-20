package mx.unam.fi.die.poo.g7.practicas.practica12;

/**
 * Representa un pedido o comanda emitido por un cliente en el restaurante.
 * <p>
 * Modela la unidad de información intercambiada entre productores ({@link Cliente})
 * y consumidores ({@link Mesero}) a través del búfer compartido ({@link ColaPedidos}).
 * </p>
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Pedido {

    /** Identificador numérico del cliente que emitió la comanda. */
    private int cliente;

    /** Nombre o descripción del platillo solicitado en el restaurante. */
    private String platillo;

    /**
     * Constructor que inicializa el pedido con el identificador del cliente y el platillo seleccionado.
     *
     * @param cliente  Identificador del cliente solicitante.
     * @param platillo Nombre del platillo solicitado.
     */
    public Pedido(int cliente, String platillo) {
        this.cliente = cliente;
        this.platillo = platillo;
    }

    /**
     * Obtiene el identificador del cliente que realizó este pedido.
     *
     * @return Identificador entero del cliente.
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * Obtiene la denominación del platillo solicitado.
     *
     * @return Cadena que representa el nombre del platillo.
     */
    public String getPlatillo() {
        return platillo;
    }
}
