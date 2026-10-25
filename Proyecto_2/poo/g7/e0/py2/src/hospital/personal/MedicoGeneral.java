package hospital.personal;

import hospital.pacientes.Paciente;
import hospital.pacientes.PacienteGeneral;

/**
 * Representa a un Médico General de atención primaria.
 * Atributo propio mutable: consultorioAsignado (con getter y setter).
 */
public class MedicoGeneral extends Medico {
    private String consultorioAsignado;

    public MedicoGeneral(String nombre, String cedula, String consultorioAsignado) {
        super(nombre, cedula, "GENERAL");
        setConsultorioAsignado(consultorioAsignado);
    }

    public String getConsultorioAsignado() {
        return this.consultorioAsignado;
    }

    public void setConsultorioAsignado(String consultorioAsignado) {
        if (consultorioAsignado == null || consultorioAsignado.trim().isEmpty()) {
            this.consultorioAsignado = "Consultorio 1 - Planta Baja";
        } else {
            this.consultorioAsignado = consultorioAsignado.trim();
        }
    }

    @Override
    public boolean puedeAtender(Paciente paciente) {
        if (paciente == null) return false;
        return paciente.getEspecialidad().equalsIgnoreCase("GENERAL");
    }

    @Override
    public void darConsulta(Paciente paciente) {
        super.darConsulta(paciente);
        System.out.println("  [Atención Primaria en " + this.consultorioAsignado + "] El Dr./Dra. " 
                + getNombre() + " realiza revisión general de signos vitales e historial clínico básico.");
    }

    public void derivarAEspecialista(Paciente paciente, String especialidadRequerida) {
        if (paciente == null) return;
        System.out.println("El Médico General " + getNombre() + " emite orden de interconsulta para " 
                + paciente.getNombre() + " hacia la especialidad: " + especialidadRequerida);
        paciente.setEspecialidad(especialidadRequerida);
    }

    @Override
    public String getTipoMedico() {
        return "Médico General";
    }
}
