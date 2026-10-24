package hospital.personal;

import hospital.pacientes.Paciente;
import hospital.pacientes.PacienteEspecialidad;

/**
 * Representa a un Médico Especialista.
 * Atributos propios mutables: aniosExperiencia y subespecialidad (getters y setters).
 */
public class MedicoEspecialista extends Medico {
    private int aniosExperiencia;
    private String subespecialidad;

    public MedicoEspecialista(String nombre, String cedula, String especialidad, int aniosExperiencia, String subespecialidad) {
        super(nombre, cedula, especialidad);
        setAniosExperiencia(aniosExperiencia);
        setSubespecialidad(subespecialidad);
    }

    public int getAniosExperiencia() {
        return this.aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        if (aniosExperiencia < 0) {
            this.aniosExperiencia = 0;
        } else {
            this.aniosExperiencia = aniosExperiencia;
        }
    }

    public String getSubespecialidad() {
        return this.subespecialidad;
    }

    public void setSubespecialidad(String subespecialidad) {
        if (subespecialidad == null || subespecialidad.trim().isEmpty()) {
            this.subespecialidad = "General de área";
        } else {
            this.subespecialidad = subespecialidad.trim();
        }
    }

    @Override
    public boolean puedeAtender(Paciente paciente) {
        if (paciente == null) return false;
        return getEspecialidad().equalsIgnoreCase(paciente.getEspecialidad());
    }

    @Override
    public void darConsulta(Paciente paciente) {
        super.darConsulta(paciente);
        System.out.println("  [Consulta de Alta Especialidad en " + getEspecialidad() + " (" + this.subespecialidad + ")]");
        System.out.println("  Dr./Dra. " + getNombre() + " (" + this.aniosExperiencia 
                + " años de exp.) realiza evaluación diagnóstica avanzada.");
        if (paciente instanceof PacienteEspecialidad) {
            PacienteEspecialidad pe = (PacienteEspecialidad) paciente;
            System.out.println("  Revisando caso con urgencia nivel " + pe.getNivelUrgencia() 
                    + "/5 y diagnóstico previo: " + pe.getDiagnosticoPrevio());
        }
    }

    @Override
    public void darTratamiento(Paciente paciente, String indicacion) {
        super.darTratamiento(paciente, "[Protocolo Especializado " + getEspecialidad() + "] " + indicacion);
    }

    public void emitirDictamenEspecializado(Paciente paciente, String procedimiento) {
        if (paciente == null) return;
        System.out.println("DICTAMEN MÉDICO ESPECIALIZADO (" + getEspecialidad() + "):");
        System.out.println("El especialista " + getNombre() + " autoriza procedimiento: " + procedimiento 
                + " para el paciente " + paciente.getNombre());
    }

    @Override
    public String getTipoMedico() {
        return "Médico Especialista en " + getEspecialidad();
    }
}
