// CLASE PRINCIPAL: Ensambla el Modelo, la Vista y el Controlador (Patrón MVC)
public class Restaurante {

    public static void main(String[] args) {
        // 1. Crear el Modelo (cola compartida de pedidos)
        ColaPedidos cola = new ColaPedidos();

        // 2. Crear la Vista (encargada de toda la salida en consola)
        VistaRestaurante vista = new VistaRestaurante();

        // 3. Crear el Controlador (conecta el Modelo y la Vista con los hilos)
        ControladorRestaurante controlador = new ControladorRestaurante(cola, vista);

        // 4. Iniciar la simulación concurrente
        controlador.iniciarSimulacion();
    }
}
