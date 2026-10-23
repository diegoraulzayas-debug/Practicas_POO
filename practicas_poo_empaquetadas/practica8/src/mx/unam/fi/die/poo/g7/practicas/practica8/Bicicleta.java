package mx.unam.fi.die.poo.g7.practicas.practica8;

/**
 * Modela una bicicleta para el calculo de emisiones indirectas de dioxido de carbono
 * derivadas de la amortizacion de manufactura y materiales de fabricacion del cuadro
 * por distancia recorrida.
 * Implementa la interfaz {@link HuellaCarbono}.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Bicicleta implements HuellaCarbono {

    // Atributos
    /** Distancia total recorrida por la bicicleta en kilometros. */
    private double kilometrosRecorridos;

    /** Material con el que esta construido el cuadro (ej. "Aluminio", "Acero", "Fibra de carbono"). */
    private String materialFabricacion;

    /**
     * Construye un nuevo objeto Bicicleta con su kilometraje y material de fabricacion.
     *
     * @param kilometrosRecorridos Distancia en kilometros recorridos en la bicicleta.
     * @param materialFabricacion Material empleado en la elaboracion del cuadro.
     */
    public Bicicleta(double kilometrosRecorridos, String materialFabricacion) {
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.materialFabricacion = materialFabricacion;
    }

    /**
     * Obtiene los kilometros recorridos en la bicicleta.
     *
     * @return Distancia en kilometros.
     */
    public double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    /**
     * Obtiene el tipo de material de fabricacion del cuadro de la bicicleta.
     *
     * @return Nombre del material del cuadro.
     */
    public String getMaterialFabricacion() {
        return materialFabricacion;
    }

    /**
     * Comportamiento exclusivo: Simula el ajuste de presion de neumaticos de acuerdo
     * al cuadro y proposito urbano de la bicicleta.
     */
    public void ajustarPresionNeumaticos() {
        System.out.println("Presión ajustada para uso urbano con cuadro de " + materialFabricacion + ".");
    }

    /**
     * Calcula la huella de carbono de la bicicleta mediante la huella de manufactura
     * amortizada por kilometro de acuerdo con el material del cuadro (Fibra de carbono,
     * Aluminio o Acero).
     *
     * @return Huella de carbono calculada en kg CO2e.
     */
    @Override
    public double getHuellaCarbono() {
        // La huella de una bicicleta viene de la manufactura amortizada por km de uso
        // Se asigna un factor estimado en kg CO2e por km según el material del cuadro
        double factorEmisionPorKm;

        switch (materialFabricacion.toLowerCase()) {
            case "fibra de carbono":
                factorEmisionPorKm = 0.015;
                break;
            case "aluminio":
                factorEmisionPorKm = 0.008;
                break;
            case "acero":
            default:
                factorEmisionPorKm = 0.005;
                break;
        }

        return kilometrosRecorridos * factorEmisionPorKm;
    }

    /**
     * Devuelve una representacion en texto con las caracteristicas de la bicicleta.
     *
     * @return Cadena con los datos del material del cuadro y recorrido.
     */
    @Override
    public String toString() {
        return "Bicicleta -> Material del cuadro: " + materialFabricacion + 
               ", Recorrido: " + kilometrosRecorridos + " km";
    }
}