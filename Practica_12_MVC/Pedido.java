// MODELO: Representa los datos de un pedido dentro del restaurante
public class Pedido {

    // Atributos del pedido
    private int cliente;
    private String platillo;

    // Constructor que inicializa el cliente y el platillo
    public Pedido(int cliente, String platillo) {
        this.cliente = cliente;
        this.platillo = platillo;
    }

    // Devuelve el identificador del cliente
    public int getCliente() {
        return cliente;
    }

    // Devuelve el nombre del platillo
    public String getPlatillo() {
        return platillo;
    }
}
