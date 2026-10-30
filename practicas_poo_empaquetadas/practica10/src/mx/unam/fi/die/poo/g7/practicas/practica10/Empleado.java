package mx.unam.fi.die.poo.g7.practicas.practica10;

/**
 * Modela a un empleado del sistema hospitalario con validaciones defensivas
 * de límites y tipos de datos durante su instanciación en el constructor.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0.0, POO UNAM FI 2026
 */
public class Empleado {

    // Atributos
    /** Nombre completo del empleado. */
    private String nombre;

    /** Rol desempeñado en el hospital (uso esperado: "MEDICO" o "ENFERMERO"). */
    private String rol;              // Uso esperado: "MEDICO" o "ENFERMERO"

    /** Número identificador único del empleado (ej. Cédula o NSS, estrictamente numérico). */
    private int numeroIdentificador; // Ej. Cédula/NSS: debe ser estrictamente numérico

    /** Cantidad de horas mensuales asignadas al empleado (rango válido de 1 a 80 horas). */
    private int horasAsignadas;      // Debe respetar el límite permitido (1 a 80 hrs/mes)

    /**
     * Construye un nuevo objeto {@code Empleado} aplicando validaciones defensivas
     * sobre los límites de horas, el rol permitido y el formato numérico del identificador.
     *
     * @param nombre Nombre completo del empleado a registrar.
     * @param rol Rol asignado dentro del sistema ("MEDICO" o "ENFERMERO").
     * @param textoIdentificador Cadena de texto que representa el identificador numérico del empleado.
     * @param horasAsignadas Número de horas mensuales asignadas (debe estar en el rango cerrado [1 - 80]).
     * @throws IndexOutOfBoundsException Si {@code horasAsignadas} está fuera del rango permitido [1 - 80].
     * @throws IllegalArgumentException Si el {@code rol} no es compatible o si {@code textoIdentificador} no es numérico.
     * @throws Exception Si ocurre algún error general durante la validación en la construcción.
     */
    public Empleado(String nombre, String rol, String textoIdentificador, int horasAsignadas) 
            throws Exception {
        
        System.out.println("[Constructor Empleado] Validando datos para: " + nombre);

        // 1. Error de límite (IndexOutOfBoundsException)
        if (horasAsignadas < 1 || horasAsignadas > 80) {
            throw new IndexOutOfBoundsException(
                "Límite excedido: las horas (" + horasAsignadas + ") deben estar en el rango [1 - 80]."
            );
        }

        // 2. Error por tipo incompatible conforme al uso previsto
        // Si no es un rol habilitado para este sistema hospitalario/médico
        if (!rol.equalsIgnoreCase("MEDICO") && !rol.equalsIgnoreCase("ENFERMERO")) {
            throw new IllegalArgumentException(
                "Rol no admitido: '" + rol + "'. Se esperaba uso específico para 'MEDICO' o 'ENFERMERO'."
            );
        }

        // 3. Error por recibir texto cuando se requería una representación numérica
        // (Ej. mandar letras en lugar de dígitos para el número de empleado o seguro social)
        try {
            this.numeroIdentificador = Integer.parseInt(textoIdentificador);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "Tipo de dato no conforme: el identificador de " + rol + " debe ser numérico. Se recibió: '" 
                + textoIdentificador + "'", e
            );
        }

        // Si pasa todas las pruebas, se asigna el estado del objeto
        this.nombre = nombre;
        this.rol = rol.toUpperCase();
        this.horasAsignadas = horasAsignadas;
        System.out.println("[Constructor Empleado] Objeto instanciado correctamente.");
    }

    /**
     * Obtiene el nombre completo del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene el rol profesional del empleado en el hospital ("MEDICO" o "ENFERMERO").
     *
     * @return El rol asignado al empleado en mayúsculas.
     */
    public String getRol() {
        return this.rol;
    }

    /**
     * Obtiene el número identificador único asignado al empleado.
     *
     * @return El número identificador numérico.
     */
    public int getNumeroIdentificador() {
        return this.numeroIdentificador;
    }

    /**
     * Obtiene la cantidad de horas mensuales asignadas al empleado.
     *
     * @return Las horas de trabajo mensuales asignadas (entre 1 y 80).
     */
    public int getHorasAsignadas() {
        return this.horasAsignadas;
    }

    /**
     * Genera una representación textual con los datos principales del empleado,
     * incluyendo su rol, nombre, identificador numérico y horas asignadas.
     *
     * @return Cadena formateada con la información del empleado.
     */
    @Override
    public String toString() {
        return "Empleado [" + rol + "] " + nombre + " | ID: " + numeroIdentificador + " | Horas: " + horasAsignadas;
    }
}
