package hospital.pacientes;

import hospital.sistema.Sistema;

/**
 * Clase abstracta base que modela a un Paciente del sistema hospitalario.
 * Encapsulamiento estricto:
 * - Atributos inmutables como 'nombre' son private final (solo getter, sin setter).
 * - Atributos mutables como 'tratamiento', 'estaEnConsulta' y 'estaEnTratamiento' tienen getters y setters validados.
 * - 'especialidad' cuenta con getter y setter (permite derivación por médico general).
 * 
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public abstract class Paciente {
    private final String nombre; // Inmutable: el nombre legal del paciente no cambia una vez admitido
    private String especialidad;
    private String tratamiento;
    private boolean estaEnConsulta;
    private boolean estaEnTratamiento;

    /**
     * Constructor base para inicializar un paciente con su nombre y especialidad requerida.
     * 
     * @param nombre Nombre del paciente (inmutable tras construcción).
     * @param especialidad Especialidad médica requerida o asignada.
     */
    public Paciente(String nombre, String especialidad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "PACIENTE_SIN_NOMBRE";
        } else {
            this.nombre = nombre.trim();
        }
        setEspecialidad(especialidad);
        this.tratamiento = "Sin tratamiento asignado";
        this.estaEnConsulta = false;
        this.estaEnTratamiento = false;
    }

    /**
     * Obtiene el nombre del paciente.
     * 
     * @return Nombre del paciente (inmutable).
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la especialidad médica asignada o requerida por el paciente.
     * 
     * @return Especialidad en mayúsculas.
     */
    public String getEspecialidad() {
        return this.especialidad;
    }

    /**
     * Asigna o actualiza la especialidad médica requerida por el paciente.
     * 
     * @param especialidad Nombre de la especialidad clínica requerida.
     */
    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            this.especialidad = "GENERAL";
        } else {
            this.especialidad = especialidad.trim().toUpperCase();
        }
    }

    /**
     * Obtiene la prescripción o tratamiento médico asignado actualmente al paciente.
     * 
     * @return Cadena con la indicación del tratamiento.
     */
    public String getTratamiento() {
        return this.tratamiento;
    }

    /**
     * Asigna una prescripción o indicación de tratamiento al paciente.
     * 
     * @param tratamiento Descripción del tratamiento administrado.
     */
    public void setTratamiento(String tratamiento) {
        if (tratamiento == null || tratamiento.trim().isEmpty()) {
            this.tratamiento = "Sin tratamiento asignado";
        } else {
            this.tratamiento = tratamiento.trim();
        }
    }

    /**
     * Indica si el paciente se encuentra actualmente en consulta médica activa.
     * 
     * @return true si está en consulta, false en caso contrario.
     */
    public boolean isEstaEnConsulta() {
        return this.estaEnConsulta;
    }

    /**
     * Modifica el estado de consulta médica activa del paciente.
     * 
     * @param estaEnConsulta true para marcar en consulta, false para liberar.
     */
    public void setEstaEnConsulta(boolean estaEnConsulta) {
        this.estaEnConsulta = estaEnConsulta;
    }

    /**
     * Indica si el paciente se encuentra bajo tratamiento o cuidado activo.
     * 
     * @return true si está en tratamiento, false en caso contrario.
     */
    public boolean isEstaEnTratamiento() {
        return this.estaEnTratamiento;
    }

    /**
     * Modifica el estado de tratamiento activo del paciente.
     * 
     * @param estaEnTratamiento true si está en tratamiento, false en caso contrario.
     */
    public void setEstaEnTratamiento(boolean estaEnTratamiento) {
        this.estaEnTratamiento = estaEnTratamiento;
    }

    /**
     * Registra al paciente en el sistema hospitalario central.
     * 
     * @param sistema Instancia central del hospital donde se registra el paciente.
     */
    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarPaciente(this);
        } else {
            System.out.println("Error: Sistema no válido para registrar paciente.");
        }
    }

    /**
     * Solicita una consulta médica dentro del sistema hospitalario de forma polimórfica.
     * 
     * @param sistema Instancia del sistema hospitalario donde se solicita la atención.
     */
    public abstract void solicitarConsulta(Sistema sistema);

    /**
     * Devuelve una descripción detallada de la condición clínica del paciente.
     * 
     * @return Cadena que representa el tipo y condición específica del paciente.
     */
    public abstract String obtenerTipoCondicion();

    /**
     * Muestra en consola el estado actual, diagnóstico y tratamiento prescrito al paciente.
     */
    public void verTratamiento() {
        System.out.println("\n--- Estado y Tratamiento del Paciente ---");
        System.out.println("Paciente: " + this.nombre + " (" + obtenerTipoCondicion() + ")");
        System.out.println("Especialidad requerida: " + this.especialidad);
        if (this.estaEnConsulta) {
            System.out.println("Estado: En consulta médica activa.");
        } else if (this.estaEnTratamiento) {
            System.out.println("Estado: En tratamiento.");
            System.out.println("Indicación / Medicamento: " + this.tratamiento);
        } else {
            System.out.println("Estado: En espera de atención médica.");
        }
    }

    /**
     * Retorna una representación textual concisa del paciente.
     * 
     * @return Cadena con el nombre, tipo de condición y especialidad.
     */
    @Override
    public String toString() {
        return this.nombre + " [" + obtenerTipoCondicion() + " - " + this.especialidad + "]";
    }
}
