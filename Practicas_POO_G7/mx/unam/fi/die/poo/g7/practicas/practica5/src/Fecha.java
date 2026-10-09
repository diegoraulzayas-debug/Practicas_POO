package mx.unam.fi.die.poo.g7.practicas.practica5;

/**
 * Administra los componentes de una fecha en el calendario.
 */
public class Fecha {

    // Atributos
    private int dia;
    private int mes;
    private int anio;

    // Constructor
    /**
     * Inicializa los valores temporales mediante tres valores numéricos de tipo int.
     */
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Getters
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    // Setters
    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    // Metodo para mostrar la fecha
    /**
     * Imprime los componentes de la fecha en formato establecido y realiza la operación sin devolver un valor.
     */
    public void mostrarFecha() {
        System.out.println(dia + "/" + mes + "/" + anio);
    }
}
