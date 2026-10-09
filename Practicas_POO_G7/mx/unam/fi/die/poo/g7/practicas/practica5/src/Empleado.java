package mx.unam.fi.die.poo.g7.practicas.practica5;

/**
 * Administra la información y el salario de un empleado.
 */
public class Empleado {

    // Atributos
    private String nombre;
    private String apellido;
    private double salarioMensual;

    // Constructor
    /**
     * Inicializa los datos del empleado mediante dos cadenas de tipo String y un valor decimal de tipo double.
     */
    public Empleado(String nombre, String apellido, double salarioMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salarioMensual = validarSalario(salarioMensual);
    }

    // Metodo para validar salario
    /**
     * Verifica la validez del salario mediante un valor decimal de tipo double y devuelve el salario validado de tipo double.
     */
    public double validarSalario(double salario) {
        if (salario < 0) {
            return 0;
        }
        return salario;
    }

    // Metodos modificadores
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSalarioMensual(double salarioMensual) {
        if (salarioMensual > 0) {
            this.salarioMensual = salarioMensual;
        }
    }

    // Metodos de acceso
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    // Calcular salario anual
    /**
     * Calcula el sueldo devengado durante el año y devuelve un valor de tipo double.
     */
    public double salarioAnual() {
        return salarioMensual * 12;
    }

    // Aumento del 10%
    /**
     * Aplica un incremento al sueldo base sin recibir datos y sin devolver un valor.
     */
    public void aumentarSalario() {
        salarioMensual = salarioMensual * 1.10;
    }
}