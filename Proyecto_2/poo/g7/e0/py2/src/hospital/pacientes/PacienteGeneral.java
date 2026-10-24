package hospital.pacientes;

import hospital.sistema.Sistema;

/**
 * Representa a un paciente de consulta externa o medicina general.
 * Atributo propio mutable: motivoConsulta (con getter y setter).
 */
public class PacienteGeneral extends Paciente {
    private String motivoConsulta;

    public PacienteGeneral(String nombre, String motivoConsulta) {
        super(nombre, "GENERAL");
        setMotivoConsulta(motivoConsulta);
    }

    public String getMotivoConsulta() {
        return this.motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        if (motivoConsulta == null || motivoConsulta.trim().isEmpty()) {
            this.motivoConsulta = "Consulta médica general de rutina";
        } else {
            this.motivoConsulta = motivoConsulta.trim();
        }
    }

    @Override
    public void solicitarConsulta(Sistema sistema) {
        if (sistema != null) {
            System.out.println("El paciente general " + getNombre() + " solicita turno de medicina general por: " + this.motivoConsulta);
            sistema.asignarPacienteAutomatico(this);
        }
    }

    @Override
    public String obtenerTipoCondicion() {
        return "Paciente General (Motivo: " + this.motivoConsulta + ")";
    }

    public void actualizarMotivo(String nuevoMotivo) {
        setMotivoConsulta(nuevoMotivo);
        System.out.println("Motivo de consulta general actualizado para " + getNombre() + ": " + this.motivoConsulta);
    }
}
