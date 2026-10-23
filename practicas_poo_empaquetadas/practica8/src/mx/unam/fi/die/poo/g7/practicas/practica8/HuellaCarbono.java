package mx.unam.fi.die.poo.g7.practicas.practica8;

/**
 * Interfaz que define el contrato comun para cualquier objeto o entidad
 * que genere emisiones de carbono y requiera calcular su huella ecologica.
 * Permite el tratamiento polimorfico de clases no relacionadas por herencia
 * (como Edificio, Auto y Bicicleta).
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public interface HuellaCarbono {

    /**
     * Calcula y devuelve la huella de carbono emitida por la entidad en kilogramos
     * de dioxido de carbono equivalente (kg CO2e).
     *
     * @return Huella de carbono calculada en kg CO2e.
     */
    double getHuellaCarbono();
}