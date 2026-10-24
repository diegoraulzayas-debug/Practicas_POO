package hospital.pacientes;

import hospital.sistema.Sistema;

/**
 * Clase abstracta base que modela a un Paciente del sistema hospitalario.
 * Encapsulamiento estricto:
 * - Atributos inmutables como 'nombre' son private final (solo getter, sin setter).
 * - Atributos mutables como 'tratamiento', 'estaEnConsulta' y 'estaEnTratamiento' tienen getters y setters validados.
 * - 'especialidad' cuenta con getter y setter (permite derivación por médico general).
 */
public abstract class Paciente {
    private final String nombre; // Inmutable: el nombre legal del paciente no cambia una vez admitido
    private String especialidad;
    private String tratamiento;
    private boolean estaEnConsulta;
    private boolean estaEnTratamiento;

    /**
     * Constructor base para inicializar un paciente.
     * @param nombre Nombre del paciente (inmutable tras construcción).
     * @param especialidad Especialidad requerida o asignada.
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

    // Solo Getter para nombre (Inmutable: sin setter)
    public String getNombre() {
        return this.nombre;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            this.especialidad = "GENERAL";
        } else {
            this.especialidad = especialidad.trim().toUpperCase();
        }
    }

    public String getTratamiento() {
        return this.tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        if (tratamiento == null || tratamiento.trim().isEmpty()) {
            this.tratamiento = "Sin tratamiento asignado";
        } else {
            this.tratamiento = tratamiento.trim();
        }
    }

    public boolean isEstaEnConsulta() {
        return this.estaEnConsulta;
    }

    public void setEstaEnConsulta(boolean estaEnConsulta) {
        this.estaEnConsulta = estaEnConsulta;
    }

    public boolean isEstaEnTratamiento() {
        return this.estaEnTratamiento;
    }

    public void setEstaEnTratamiento(boolean estaEnTratamiento) {
        this.estaEnTratamiento = estaEnTratamiento;
    }

    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarPaciente(this);
        } else {
            System.out.println("Error: Sistema no válido para registrar paciente.");
        }
    }

    public abstract void solicitarConsulta(Sistema sistema);

    public abstract String obtenerTipoCondicion();

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

    @Override
    public String toString() {
        return this.nombre + " [" + obtenerTipoCondicion() + " - " + this.especialidad + "]";
    }
}
