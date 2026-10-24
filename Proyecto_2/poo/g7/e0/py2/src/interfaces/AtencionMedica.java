package interfaces;

import hospital.pacientes.Paciente;

/**
 * Interfaz que define las operaciones fundamentales de atención médica
 * que debe brindar cualquier profesional clínico (Médicos y Enfermeros).
 * Empaquetada como módulo/JAR para promover alta cohesión y bajo acoplamiento.
 */
public interface AtencionMedica {
    
    /**
     * Proporciona atención o consulta inicial al paciente.
     * @param paciente Paciente que recibe la atención.
     */
    void darConsulta(Paciente paciente);

    /**
     * Administra o prescribe el tratamiento correspondiente al paciente.
     * @param paciente Paciente receptor del tratamiento.
     */
    void darTratamiento(Paciente paciente);

    /**
     * Administra o prescribe el tratamiento con una indicación médica específica.
     * @param paciente Paciente receptor del tratamiento.
     * @param indicacion Indicación detallada o medicamento recetado.
     */
    void darTratamiento(Paciente paciente, String indicacion);
}
