package mx.unam.fi.die.poo.g7.practicas.practica5;

/**
 * Representa a un empleado dentro de una organizacion con informacion de
 * nombre, apellido y salario mensual, permitiendo operaciones de calculo anual
 * y aplicacion de aumentos salariales.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Empleado {

    // Atributos
    private String nombre;
    private String apellido;
    private double salarioMensual;

    /**
     * Construye un nuevo objeto Empleado con los datos especificados.
     * Si el salario es negativo, se inicializa en 0 mediante validacion.
     *
     * @param nombre Nombre del empleado.
     * @param apellido Apellido del empleado.
     * @param salarioMensual Salario mensual inicial del empleado.
     */
    public Empleado(String nombre, String apellido, double salarioMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salarioMensual = validarSalario(salarioMensual);
    }

    /**
     * Valida que el salario no sea negativo.
     *
     * @param salario Monto salarial a verificar.
     * @return El salario original si es mayor o igual a 0, o 0 si es negativo.
     */
    public double validarSalario(double salario) {
        if (salario < 0) {
            return 0;
        }
        return salario;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre Nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el apellido del empleado.
     *
     * @param apellido Nuevo apellido del empleado.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Establece el salario mensual del empleado, actualizandolo solo si es mayor a cero.
     *
     * @param salarioMensual Nuevo salario mensual.
     */
    public void setSalarioMensual(double salarioMensual) {
        if (salarioMensual > 0) {
            this.salarioMensual = salarioMensual;
        }
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del empleado.
     *
     * @return El apellido del empleado.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el salario mensual del empleado.
     *
     * @return El salario mensual actual.
     */
    public double getSalarioMensual() {
        return salarioMensual;
    }

    /**
     * Calcula el salario anual correspondiente al empleado.
     *
     * @return El monto del salario anual (salario mensual multiplicado por 12).
     */
    public double salarioAnual() {
        return salarioMensual * 12;
    }

    /**
     * Aplica un aumento del 10% al salario mensual del empleado.
     */
    public void aumentarSalario() {
        salarioMensual = salarioMensual * 1.10;
    }
}