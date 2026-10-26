package hospital.personal;

import hospital.pacientes.Paciente;
import hospital.pacientes.PacienteGeneral;

/**
 * Representa a un Médico General de atención primaria en el hospital.
 * Atributo propio mutable: consultorioAsignado (con getter y setter).
 * Permite la derivación de pacientes hacia médicos especialistas.
 * 
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public class MedicoGeneral extends Medico {
    private String consultorioAsignado;

    /**
     * Construye un médico general asignando automáticamente la especialidad "GENERAL".
     * 
     * @param nombre Nombre del médico general.
     * @param cedula Cédula profesional.
     * @param consultorioAsignado Consultorio físico donde atiende (ej. "Consultorio 1 - Planta Baja").
     */
    public MedicoGeneral(String nombre, String cedula, String consultorioAsignado) {
        super(nombre, cedula, "GENERAL");
        setConsultorioAsignado(consultorioAsignado);
    }

    /**
     * Obtiene el consultorio físico asignado al médico general.
     * 
     * @return Nombre o código del consultorio asignado.
     */
    public String getConsultorioAsignado() {
        return this.consultorioAsignado;
    }

    /**
     * Asigna o actualiza el consultorio de atención del médico general.
     * 
     * @param consultorioAsignado Nuevo consultorio asignado.
     */
    public void setConsultorioAsignado(String consultorioAsignado) {
        if (consultorioAsignado == null || consultorioAsignado.trim().isEmpty()) {
            this.consultorioAsignado = "Consultorio 1 - Planta Baja";
        } else {
            this.consultorioAsignado = consultorioAsignado.trim();
        }
    }

    /**
     * Valida si el médico general puede atender al paciente dado.
     * Un médico general puede atender a pacientes cuya especialidad requerida sea "GENERAL".
     * 
     * @param paciente Paciente a evaluar.
     * @return true si el paciente requiere atención general, false de lo contrario.
     */
    @Override
    public boolean puedeAtender(Paciente paciente) {
        if (paciente == null) return false;
        return paciente.getEspecialidad().equalsIgnoreCase("GENERAL");
    }

    /**
     * Realiza la consulta clínica de atención primaria en su consultorio asignado.
     * 
     * @param paciente Paciente atendido.
     */
    @Override
    public void darConsulta(Paciente paciente) {
        super.darConsulta(paciente);
        System.out.println("  [Atención Primaria en " + this.consultorioAsignado + "] El Dr./Dra. " 
                + getNombre() + " realiza revisión general de signos vitales e historial clínico básico.");
    }

    /**
     * Emite una orden formal de interconsulta y deriva al paciente hacia un médico especialista.
     * 
     * @param paciente Paciente que requiere derivación.
     * @param especialidadRequerida Especialidad médica a la que se canaliza el paciente.
     */
    public void derivarAEspecialista(Paciente paciente, String especialidadRequerida) {
        if (paciente == null) return;
        System.out.println("El Médico General " + getNombre() + " emite orden de interconsulta para " 
                + paciente.getNombre() + " hacia la especialidad: " + especialidadRequerida);
        paciente.setEspecialidad(especialidadRequerida);
    }

    /**
     * Retorna la denominación del cargo.
     * 
     * @return Cadena "Médico General".
     */
    @Override
    public String getTipoMedico() {
        return "Médico General";
    }
}
