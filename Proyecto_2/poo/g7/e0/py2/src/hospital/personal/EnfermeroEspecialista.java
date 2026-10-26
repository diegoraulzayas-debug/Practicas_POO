package hospital.personal;

import hospital.pacientes.Paciente;

/**
 * Representa a un Enfermero Especialista en un área clínica determinada.
 * Atributo propio mutable: certificacionAvanzada (con getter y setter).
 * Brinda cuidados intensivos y monitoreo de pacientes especializados.
 * 
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public class EnfermeroEspecialista extends Enfermero {
    private String certificacionAvanzada;

    /**
     * Construye un enfermero especialista con su certificación clínica.
     * 
     * @param nombre Nombre del enfermero especialista.
     * @param cedula Cédula profesional.
     * @param especialidad Especialidad clínica asignada (ej. CARDIOLOGIA, PEDIATRIA, URGENCIAS).
     * @param certificacionAvanzada Certificación técnica o acreditación clínica avanzada.
     */
    public EnfermeroEspecialista(String nombre, String cedula, String especialidad, String certificacionAvanzada) {
        super(nombre, cedula, especialidad);
        setCertificacionAvanzada(certificacionAvanzada);
    }

    /**
     * Obtiene la certificación avanzada acreditada por el enfermero especialista.
     * 
     * @return Nombre de la certificación clínica.
     */
    public String getCertificacionAvanzada() {
        return this.certificacionAvanzada;
    }

    /**
     * Actualiza la certificación avanzada del enfermero especialista.
     * 
     * @param certificacionAvanzada Nueva certificación o acreditación técnica.
     */
    public void setCertificacionAvanzada(String certificacionAvanzada) {
        if (certificacionAvanzada == null || certificacionAvanzada.trim().isEmpty()) {
            this.certificacionAvanzada = "Soporte Vital Avanzado (ACLS)";
        } else {
            this.certificacionAvanzada = certificacionAvanzada.trim();
        }
    }

    /**
     * Valida si el enfermero especialista puede atender al paciente.
     * Requiere que la especialidad del enfermero coincida con la requerida por el paciente.
     * 
     * @param paciente Paciente a evaluar.
     * @return true si la especialidad del paciente coincide con la del enfermero, false de lo contrario.
     */
    @Override
    public boolean puedeAtender(Paciente paciente) {
        if (paciente == null) return false;
        return getEspecialidad().equalsIgnoreCase(paciente.getEspecialidad());
    }

    /**
     * Administra cuidados especializados de enfermería registrando la certificación activa.
     * 
     * @param paciente Paciente receptor de los cuidados de enfermería.
     */
    @Override
    public void darTratamiento(Paciente paciente) {
        super.darTratamiento(paciente);
        System.out.println("  [Cuidados Especializados de Enfermería en " + getEspecialidad() + "]");
        System.out.println("  Certificación activa: " + this.certificacionAvanzada 
                + ". Monitoreo de bomba de infusión y parámetros críticos.");
    }

    /**
     * Ejecuta un protocolo de monitoreo intensivo continuo en pacientes de especialidad.
     * 
     * @param paciente Paciente bajo monitoreo continuo.
     */
    public void monitoreoIntensivo(Paciente paciente) {
        if (paciente == null) return;
        System.out.println("Enfermero especialista " + getNombre() + " realiza protocolo de monitoreo avanzado a " 
                + paciente.getNombre() + " en el área de " + getEspecialidad() + ".");
    }

    /**
     * Retorna la denominación del cargo junto con su especialidad.
     * 
     * @return Cadena que indica el cargo (ej. "Enfermero Especialista en PEDIATRIA").
     */
    @Override
    public String getCargo() {
        return "Enfermero Especialista en " + getEspecialidad();
    }
}
