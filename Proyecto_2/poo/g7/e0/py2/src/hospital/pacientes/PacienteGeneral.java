package hospital.pacientes;

import hospital.sistema.Sistema;

/**
 * Representa a un paciente de consulta externa o medicina general.
 * Atributo propio mutable: motivoConsulta (con getter y setter).
 * 
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public class PacienteGeneral extends Paciente {
    private String motivoConsulta;

    /**
     * Construye un paciente general con su nombre y motivo de consulta.
     * Asigna automáticamente la especialidad "GENERAL".
     * 
     * @param nombre Nombre del paciente.
     * @param motivoConsulta Razón o síntomas por los que acude a consulta general.
     */
    public PacienteGeneral(String nombre, String motivoConsulta) {
        super(nombre, "GENERAL");
        setMotivoConsulta(motivoConsulta);
    }

    /**
     * Obtiene el motivo de consulta registrado para el paciente.
     * 
     * @return Motivo o descripción de la visita médica.
     */
    public String getMotivoConsulta() {
        return this.motivoConsulta;
    }

    /**
     * Actualiza o valida el motivo de consulta del paciente general.
     * 
     * @param motivoConsulta Nueva descripción del motivo de consulta.
     */
    public void setMotivoConsulta(String motivoConsulta) {
        if (motivoConsulta == null || motivoConsulta.trim().isEmpty()) {
            this.motivoConsulta = "Consulta médica general de rutina";
        } else {
            this.motivoConsulta = motivoConsulta.trim();
        }
    }

    /**
     * Solicita turno de medicina general en el sistema hospitalario.
     * 
     * @param sistema Instancia central del hospital.
     */
    @Override
    public void solicitarConsulta(Sistema sistema) {
        if (sistema != null) {
            System.out.println("El paciente general " + getNombre() + " solicita turno de medicina general por: " + this.motivoConsulta);
            sistema.asignarPacienteAutomatico(this);
        }
    }

    /**
     * Devuelve la descripción de la condición particular del paciente general.
     * 
     * @return Cadena que indica que es paciente general junto con su motivo de consulta.
     */
    @Override
    public String obtenerTipoCondicion() {
        return "Paciente General (Motivo: " + this.motivoConsulta + ")";
    }

    /**
     * Modifica el motivo de consulta del paciente e imprime la confirmación.
     * 
     * @param nuevoMotivo Nuevo motivo o actualización del cuadro clínico básico.
     */
    public void actualizarMotivo(String nuevoMotivo) {
        setMotivoConsulta(nuevoMotivo);
        System.out.println("Motivo de consulta general actualizado para " + getNombre() + ": " + this.motivoConsulta);
    }
}
