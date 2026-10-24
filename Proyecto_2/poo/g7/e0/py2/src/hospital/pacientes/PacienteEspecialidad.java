package hospital.pacientes;

import hospital.sistema.Sistema;

/**
 * Representa a un paciente que requiere atención médica especializada.
 * Atributos propios mutables: nivelUrgencia (triaje) y diagnosticoPrevio.
 */
public class PacienteEspecialidad extends Paciente {
    private int nivelUrgencia; // 1 (Baja) a 5 (Crítica)
    private String diagnosticoPrevio;

    public PacienteEspecialidad(String nombre, String especialidad, int nivelUrgencia, String diagnosticoPrevio) {
        super(nombre, especialidad);
        setNivelUrgencia(nivelUrgencia);
        setDiagnosticoPrevio(diagnosticoPrevio);
    }

    public int getNivelUrgencia() {
        return this.nivelUrgencia;
    }

    public void setNivelUrgencia(int nivelUrgencia) {
        if (nivelUrgencia < 1) {
            this.nivelUrgencia = 1;
        } else if (nivelUrgencia > 5) {
            this.nivelUrgencia = 5;
        } else {
            this.nivelUrgencia = nivelUrgencia;
        }
    }

    public String getDiagnosticoPrevio() {
        return this.diagnosticoPrevio;
    }

    public void setDiagnosticoPrevio(String diagnosticoPrevio) {
        if (diagnosticoPrevio == null || diagnosticoPrevio.trim().isEmpty()) {
            this.diagnosticoPrevio = "Sin diagnóstico preliminar";
        } else {
            this.diagnosticoPrevio = diagnosticoPrevio.trim();
        }
    }

    @Override
    public void solicitarConsulta(Sistema sistema) {
        if (sistema != null) {
            System.out.println("El paciente de especialidad " + getNombre() + " [Prioridad " + this.nivelUrgencia 
                    + "/5] solicita especialista en " + getEspecialidad() + " por diagnóstico: " + this.diagnosticoPrevio);
            sistema.asignarPacienteAutomatico(this);
        }
    }

    @Override
    public String obtenerTipoCondicion() {
        return "Especialidad: " + getEspecialidad() + " (Prioridad " + this.nivelUrgencia + "/5 - " + this.diagnosticoPrevio + ")";
    }

    public void actualizarTriage(int nuevoNivel, String observacion) {
        setNivelUrgencia(nuevoNivel);
        System.out.println("Triaje de urgencia actualizado para " + getNombre() + " a nivel " + this.nivelUrgencia + ". Obs: " + observacion);
    }
}
