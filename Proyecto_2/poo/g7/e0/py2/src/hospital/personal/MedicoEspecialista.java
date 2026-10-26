package hospital.personal;

import hospital.pacientes.Paciente;
import hospital.pacientes.PacienteEspecialidad;

/**
 * Representa a un Médico Especialista de alta especialidad en el hospital.
 * Atributos propios mutables: aniosExperiencia y subespecialidad (getters y setters).
 * Permite emitir dictámenes médicos especializados y atender patologías complejas.
 * 
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public class MedicoEspecialista extends Medico {
    private int aniosExperiencia;
    private String subespecialidad;

    /**
     * Construye un médico especialista con experiencia clínica y subespecialidad.
     * 
     * @param nombre Nombre del médico especialista.
     * @param cedula Cédula profesional.
     * @param especialidad Especialidad médica principal (ej. CARDIOLOGIA, CIRUGIA, PEDIATRIA).
     * @param aniosExperiencia Años de práctica clínica especializada.
     * @param subespecialidad Subespecialidad o área de profundización.
     */
    public MedicoEspecialista(String nombre, String cedula, String especialidad, int aniosExperiencia, String subespecialidad) {
        super(nombre, cedula, especialidad);
        setAniosExperiencia(aniosExperiencia);
        setSubespecialidad(subespecialidad);
    }

    /**
     * Obtiene los años de experiencia clínica del médico especialista.
     * 
     * @return Años de experiencia en la especialidad.
     */
    public int getAniosExperiencia() {
        return this.aniosExperiencia;
    }

    /**
     * Establece los años de experiencia clínica, garantizando valores no negativos.
     * 
     * @param aniosExperiencia Años de experiencia a asignar.
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        if (aniosExperiencia < 0) {
            this.aniosExperiencia = 0;
        } else {
            this.aniosExperiencia = aniosExperiencia;
        }
    }

    /**
     * Obtiene el área de subespecialidad del médico especialista.
     * 
     * @return Subespecialidad médica.
     */
    public String getSubespecialidad() {
        return this.subespecialidad;
    }

    /**
     * Asigna o actualiza la subespecialidad del médico.
     * 
     * @param subespecialidad Nombre de la subespecialidad.
     */
    public void setSubespecialidad(String subespecialidad) {
        if (subespecialidad == null || subespecialidad.trim().isEmpty()) {
            this.subespecialidad = "General de área";
        } else {
            this.subespecialidad = subespecialidad.trim();
        }
    }

    /**
     * Valida si el especialista está facultado para atender al paciente.
     * Verifica que la especialidad requerida por el paciente coincida exactamente con la del especialista.
     * 
     * @param paciente Paciente a evaluar.
     * @return true si las especialidades coinciden, false en caso contrario.
     */
    @Override
    public boolean puedeAtender(Paciente paciente) {
        if (paciente == null) return false;
        return getEspecialidad().equalsIgnoreCase(paciente.getEspecialidad());
    }

    /**
     * Realiza una consulta médica de alta especialidad evaluando el triaje y diagnósticos previos.
     * 
     * @param paciente Paciente evaluado en consulta especializada.
     */
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

    /**
     * Prescribe un tratamiento bajo protocolo clínico de alta especialidad.
     * 
     * @param paciente Paciente receptor del tratamiento.
     * @param indicacion Prescripción especializada detallada.
     */
    @Override
    public void darTratamiento(Paciente paciente, String indicacion) {
        super.darTratamiento(paciente, "[Protocolo Especializado " + getEspecialidad() + "] " + indicacion);
    }

    /**
     * Emite un dictamen formal autorizando o prescribiendo un procedimiento quirúrgico o terapéutico especializado.
     * 
     * @param paciente Paciente sujeto del procedimiento.
     * @param procedimiento Descripción del procedimiento clínico autorizado.
     */
    public void emitirDictamenEspecializado(Paciente paciente, String procedimiento) {
        if (paciente == null) return;
        System.out.println("DICTAMEN MÉDICO ESPECIALIZADO (" + getEspecialidad() + "):");
        System.out.println("El especialista " + getNombre() + " autoriza procedimiento: " + procedimiento 
                + " para el paciente " + paciente.getNombre());
    }

    /**
     * Retorna la denominación del cargo junto con la especialidad.
     * 
     * @return Cadena que indica el tipo y especialidad (ej. "Médico Especialista en CARDIOLOGIA").
     */
    @Override
    public String getTipoMedico() {
        return "Médico Especialista en " + getEspecialidad();
    }
}
