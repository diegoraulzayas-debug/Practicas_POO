public class Empleado {

    // Atributos
    private String nombre;
    private String apellido;
    private double salarioMensual;

    // Constructor
    public Empleado(String nombre, String apellido, double salarioMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salarioMensual = validarSalario(salarioMensual);
    }

    // Método para validar salario
    public double validarSalario(double salario) {
        if (salario < 0) {
            return 0;
        }
        return salario;
    }

    // Métodos modificadores
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

    // Métodos de acceso
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
    public double salarioAnual() {
        return salarioMensual * 12;
    }

    // Aumento del 10%
    public void aumentarSalario() {
        salarioMensual = salarioMensual * 1.10;
    }
}