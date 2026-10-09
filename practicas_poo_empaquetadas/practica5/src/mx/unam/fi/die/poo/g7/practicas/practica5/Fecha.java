package mx.unam.fi.die.poo.g7.practicas.practica5;

public class Fecha {

    // Atributos
    private int dia;
    private int mes;
    private int anio;

    // Constructor
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
    public void mostrarFecha() {
        System.out.println(dia + "/" + mes + "/" + anio);
    }
}
