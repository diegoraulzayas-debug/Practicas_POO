package hospital.personal;

import hospital.pacientes.Paciente;

/**
 * Representa a un Enfermero Especialista.
 * Atributo propio mutable: certificacionAvanzada (con getter y setter).
 */
public class EnfermeroEspecialista extends Enfermero {
    private String certificacionAvanzada;

    public EnfermeroEspecialista(String nombre, String cedula, String especialidad, String certificacionAvanzada) {
        super(nombre, cedula, especialidad);
        setCertificacionAvanzada(certificacionAvanzada);
    }

    public String getCertificacionAvanzada() {
        return this.certificacionAvanzada;
    }

    public void setCertificacionAvanzada(String certificacionAvanzada) {
        if (certificacionAvanzada == null || certificacionAvanzada.trim().isEmpty()) {
            this.certificacionAvanzada = "Soporte Vital Avanzado (ACLS)";
        } else {
            this.certificacionAvanzada = certificacionAvanzada.trim();
        }
    }

    @Override
    public boolean puedeAtender(Paciente paciente) {
        if (paciente == null) return false;
        return getEspecialidad().equalsIgnoreCase(paciente.getEspecialidad());
    }

    @Override
    public void darTratamiento(Paciente paciente) {
        super.darTratamiento(paciente);
        System.out.println("  [Cuidados Especializados de Enfermería en " + getEspecialidad() + "]");
        System.out.println("  Certificación activa: " + this.certificacionAvanzada 
                + ". Monitoreo de bomba de infusión y parámetros críticos.");
    }

    public void monitoreoIntensivo(Paciente paciente) {
        if (paciente == null) return;
        System.out.println("Enfermero especialista " + getNombre() + " realiza protocolo de monitoreo avanzado a " 
                + paciente.getNombre() + " en el área de " + getEspecialidad() + ".");
    }

    @Override
    public String getCargo() {
        return "Enfermero Especialista en " + getEspecialidad();
    }
}
