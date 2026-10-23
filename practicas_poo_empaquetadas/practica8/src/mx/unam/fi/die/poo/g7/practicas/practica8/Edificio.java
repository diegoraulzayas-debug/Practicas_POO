package mx.unam.fi.die.poo.g7.practicas.practica8;

/**
 * Modela una edificacion para calcular su impacto ambiental en emisiones de carbono
 * a traves del consumo energetico por metro cuadrado de superficie.
 * Implementa la interfaz {@link HuellaCarbono}.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Edificio implements HuellaCarbono {

    // Atributos
    /** Superficie total construida del edificio expresada en metros cuadrados (m²). */
    private double metrosCuadrados;

    /** Cantidad de pisos o niveles de la edificacion. */
    private int numeroPisos;

    /** Consumo electrico anualizado por metro cuadrado expresado en kWh/m². */
    private double consumoKwhPorMetro;

    /**
     * Construye un nuevo objeto Edificio con su dimension superficial, niveles y factor de consumo.
     *
     * @param metrosCuadrados Superficie total en metros cuadrados.
     * @param numeroPisos Numero total de niveles de la estructura.
     * @param consumoKwhPorMetro Consumo electrico por metro cuadrado al anio (kWh/m²).
     */
    public Edificio(double metrosCuadrados, int numeroPisos, double consumoKwhPorMetro) {
        this.metrosCuadrados = metrosCuadrados;
        this.numeroPisos = numeroPisos;
        this.consumoKwhPorMetro = consumoKwhPorMetro;
    }

    /**
     * Obtiene el area total construida en metros cuadrados.
     *
     * @return Superficie en metros cuadrados.
     */
    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    /**
     * Obtiene el numero de pisos de la edificacion.
     *
     * @return Cantidad de niveles del edificio.
     */
    public int getNumeroPisos() {
        return numeroPisos;
    }

    /**
     * Obtiene la tasa de consumo de energia electrica por metro cuadrado.
     *
     * @return Consumo en kWh/m².
     */
    public double getConsumoKwhPorMetro() {
        return consumoKwhPorMetro;
    }

    /**
     * Comportamiento exclusivo: Calcula el area promedio construida por cada piso.
     *
     * @return Superficie promedio por nivel en metros cuadrados.
     */
    public double calcularAreaPromedioPorPiso() {
        return metrosCuadrados / numeroPisos;
    }

    /**
     * Calcula la huella de carbono multiplicando la energia electrica total consumida
     * (area * consumo unitario) por el factor de emision promedio de la red electrica
     * (0.45 kg CO2e por kWh).
     *
     * @return Emisiones totales anuales del edificio en kg CO2e.
     */
    @Override
    public double getHuellaCarbono() {
        // Consumo total de energía = m2 * kWh/m2
        // Factor de emisión eléctrica promedio: 0.45 kg CO2e por kWh
        double consumoTotalKwh = metrosCuadrados * consumoKwhPorMetro;
        return consumoTotalKwh * 0.45;
    }

    /**
     * Devuelve una representacion en texto con las caracteristicas principales del edificio.
     *
     * @return Cadena que detalla numero de pisos, area total y consumo especifico.
     */
    @Override
    public String toString() {
        return "Edificio -> Pisos: " + numeroPisos +
                ", Área total: " + metrosCuadrados + " m²" +
                ", Consumo: " + consumoKwhPorMetro + " kWh/m²";
    }
}