package mx.unam.fi.die.poo.g7.practicas.practica5;

/**
 * Representa una fecha con dia, mes y ano, proporcionando metodos
 * de acceso, modificacion y visualizacion en formato dia/mes/ano.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Fecha {

    // Atributos
    private int dia;
    private int mes;
    private int anio;

    /**
     * Construye una nueva instancia de Fecha con los valores indicados.
     *
     * @param dia Dia del mes.
     * @param mes Mes del ano.
     * @param anio Ano calendario.
     */
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     * Obtiene el dia de la fecha.
     *
     * @return El dia.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Obtiene el mes de la fecha.
     *
     * @return El mes.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Obtiene el ano de la fecha.
     *
     * @return El ano.
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Establece el dia de la fecha.
     *
     * @param dia Nuevo dia.
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Establece el mes de la fecha.
     *
     * @param mes Nuevo mes.
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Establece el ano de la fecha.
     *
     * @param anio Nuevo ano.
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Muestra la fecha en consola con el formato {@code dia/mes/anio}.
     */
    public void mostrarFecha() {
        System.out.println(dia + "/" + mes + "/" + anio);
    }
}
