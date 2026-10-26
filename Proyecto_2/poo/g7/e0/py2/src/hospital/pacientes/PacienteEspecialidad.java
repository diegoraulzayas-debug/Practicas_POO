package hospital.pacientes;

import hospital.sistema.Sistema;

/**
 * Representa a un paciente que requiere atención médica especializada.
 * Atributos propios mutables: nivelUrgencia (triaje 1-5) y diagnosticoPrevio.
 * 
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public class PacienteEspecialidad extends Paciente {
    private int nivelUrgencia; // 1 (Baja) a 5 (Crítica)
    private String diagnosticoPrevio;

    /**
     * Construye un paciente de especialidad con prioridad de triaje y diagnóstico previo.
     * 
     * @param nombre Nombre del paciente.
     * @param especialidad Especialidad requerida (ej. CARDIOLOGIA, PEDIATRIA, CIRUGIA).
     * @param nivelUrgencia Nivel de triaje del 1 (baja) al 5 (crítica).
     * @param diagnosticoPrevio Hipótesis diagnóstica o antecedente relevante.
     */
    public PacienteEspecialidad(String nombre, String especialidad, int nivelUrgencia, String diagnosticoPrevio) {
        super(nombre, especialidad);
        setNivelUrgencia(nivelUrgencia);
        setDiagnosticoPrevio(diagnosticoPrevio);
    }

    /**
     * Obtiene el nivel de urgencia o triaje asignado al paciente.
     * 
     * @return Entero entre 1 (urgencia baja) y 5 (emergencia crítica).
     */
    public int getNivelUrgencia() {
        return this.nivelUrgencia;
    }

    /**
     * Establece y acota el nivel de triaje entre los valores válidos 1 y 5.
     * 
     * @param nivelUrgencia Nivel de urgencia a asignar.
     */
    public void setNivelUrgencia(int nivelUrgencia) {
        if (nivelUrgencia < 1) {
            this.nivelUrgencia = 1;
        } else if (nivelUrgencia > 5) {
            this.nivelUrgencia = 5;
        } else {
            this.nivelUrgencia = nivelUrgencia;
        }
    }

    /**
     * Obtiene el diagnóstico preliminar o motivo especializado registrado.
     * 
     * @return Cadena con el diagnóstico previo.
     */
    public String getDiagnosticoPrevio() {
        return this.diagnosticoPrevio;
    }

    /**
     * Actualiza el diagnóstico previo del paciente de especialidad.
     * 
     * @param diagnosticoPrevio Nueva descripción diagnóstica preliminar.
     */
    public void setDiagnosticoPrevio(String diagnosticoPrevio) {
        if (diagnosticoPrevio == null || diagnosticoPrevio.trim().isEmpty()) {
            this.diagnosticoPrevio = "Sin diagnóstico preliminar";
        } else {
            this.diagnosticoPrevio = diagnosticoPrevio.trim();
        }
    }

    /**
     * Solicita la asignación de un especialista compatible en el sistema hospitalario.
     * 
     * @param sistema Instancia central del hospital.
     */
    @Override
    public void solicitarConsulta(Sistema sistema) {
        if (sistema != null) {
            System.out.println("El paciente de especialidad " + getNombre() + " [Prioridad " + this.nivelUrgencia 
                    + "/5] solicita especialista en " + getEspecialidad() + " por diagnóstico: " + this.diagnosticoPrevio);
            sistema.asignarPacienteAutomatico(this);
        }
    }

    /**
     * Devuelve una descripción detallada que incluye especialidad, nivel de urgencia y diagnóstico previo.
     * 
     * @return Cadena formateada con los datos clínicos específicos.
     */
    @Override
    public String obtenerTipoCondicion() {
        return "Especialidad: " + getEspecialidad() + " (Prioridad " + this.nivelUrgencia + "/5 - " + this.diagnosticoPrevio + ")";
    }

    /**
     * Actualiza el nivel de triaje clínico y registra una observación médica.
     * 
     * @param nuevoNivel Nuevo nivel de urgencia (1 a 5).
     * @param observacion Justificación clínica del cambio de triaje.
     */
    public void actualizarTriage(int nuevoNivel, String observacion) {
        setNivelUrgencia(nuevoNivel);
        System.out.println("Triaje de urgencia actualizado para " + getNombre() + " a nivel " + this.nivelUrgencia + ". Obs: " + observacion);
    }
}
