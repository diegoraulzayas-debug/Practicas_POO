package mx.unam.fi.die.poo.g7.practicas.practica8;

/**
 * Modela un automovil para el calculo de emisiones de dioxido de carbono derivadas
 * del consumo de combustible al recorrer una determinada distancia.
 * Implementa la interfaz {@link HuellaCarbono}.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Auto implements HuellaCarbono {

    // Atributos
    /** Distancia total recorrida por el automovil expresada en kilometros. */
    private double kilometrosRecorridos;

    /** Rendimiento del combustible del automovil expresado en kilometros por litro (km/l). */
    private double rendimientoKmLitro;

    /**
     * Construye un nuevo objeto Auto inicializando sus parametros de uso y rendimiento.
     *
     * @param kilometrosRecorridos Distancia en kilometros que el vehiculo ha recorrido.
     * @param rendimientoKmLitro Rendimiento de combustible del vehiculo en kilometros por litro.
     */
    public Auto(double kilometrosRecorridos, double rendimientoKmLitro) {
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.rendimientoKmLitro = rendimientoKmLitro;
    }

    /**
     * Obtiene la cantidad de kilometros recorridos por el automovil.
     *
     * @return Distancia recorrida en kilometros.
     */
    public double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    /**
     * Obtiene el rendimiento de combustible en kilometros por litro.
     *
     * @return Rendimiento de combustible en km/l.
     */
    public double getRendimientoKmLitro() {
        return rendimientoKmLitro;
    }

    /**
     * Comportamiento exclusivo: Calcula el total de litros de combustible consumidos
     * con base en los kilometros recorridos y el rendimiento por litro.
     *
     * @return Volumen total de combustible consumido en litros.
     */
    public double calcularLitrosConsumidos() {
        return kilometrosRecorridos / rendimientoKmLitro;
    }

    /**
     * Calcula la huella de carbono del automovil multiplicando los litros de gasolina
     * consumidos por el factor de emision estandar (2.31 kg CO2 por litro).
     *
     * @return Emisiones totales generadas en kg CO2e.
     */
    @Override
    public double getHuellaCarbono() {
        // Litros consumidos * factor de emisión por litro de gasolina (2.31 kg CO2/L)
        return calcularLitrosConsumidos() * 2.31;
    }

    /**
     * Genera una representacion textual con los datos principales del automovil,
     * incluyendo el recorrido, rendimiento y volumen de combustible consumido.
     *
     * @return Cadena formateada con la informacion del automovil.
     */
    @Override
    public String toString() {
        return "Auto -> Recorrido: " + kilometrosRecorridos + " km" +
                ", Rendimiento: " + rendimientoKmLitro + " km/l" +
                ", Gasolina consumida: " + String.format("%.2f", calcularLitrosConsumidos()) + " L";
    }
}