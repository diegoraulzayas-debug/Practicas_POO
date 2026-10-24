package hospital.personal;

import hospital.pacientes.Paciente;

/**
 * Representa al Jefe de Enfermería del hospital.
 * Atributos propios mutables: turnoSupervision y pisoAsignado (getters y
 * setters).
 * Función adicional: supervisión, auditoría y coordinación de turnos y personal
 * de enfermería.
 */
public class JefeEnfermeria extends Enfermero {
    private String turnoSupervision; // MATUTINO, VESPERTINO, NOCTURNO
    private int pisoAsignado;

    public JefeEnfermeria(String nombre, String cedula, String turnoSupervision, int pisoAsignado) {
        super(nombre, cedula, "GENERAL");
        setTurnoSupervision(turnoSupervision);
        setPisoAsignado(pisoAsignado);
    }

    public String getTurnoSupervision() {
        return this.turnoSupervision;
    }

    public void setTurnoSupervision(String turnoSupervision) {
        if (turnoSupervision == null || turnoSupervision.trim().isEmpty()) {
            this.turnoSupervision = "MATUTINO";
        } else {
            this.turnoSupervision = turnoSupervision.trim().toUpperCase();
        }
    }

    public int getPisoAsignado() {
        return this.pisoAsignado;
    }

    public void setPisoAsignado(int pisoAsignado) {
        if (pisoAsignado < 1) {
            this.pisoAsignado = 1;
        } else {
            this.pisoAsignado = pisoAsignado;
        }
    }

    @Override
    public boolean puedeAtender(Paciente paciente) {
        return paciente != null;
    }

    @Override
    public void darConsulta(Paciente paciente) {
        super.darConsulta(paciente);
        System.out.println(
                "  [Supervisión de Jefatura - Piso " + this.pisoAsignado + ", Turno " + this.turnoSupervision + "]");
        System.out.println("  Jefe/a " + getNombre() + " valida el plan de cuidados integrales de enfermería.");
    }

    /**
     * Función adicional de coordinación y supervisión de guardia clínica:
     * Audita el estado de cada enfermero, pacientes asignados y cumplimiento de
     * protocolos.
     */
    public void supervisarGuardia(Enfermero[] enfermeros, int totalEnfermeros) {
        System.out.println("\n=== REPORTE DE SUPERVISIÓN DE JEFATURA DE ENFERMERÍA ===");
        System.out.println("Jefe/a a cargo: " + getNombre() + " | Piso: " + this.pisoAsignado + " | Turno: "
                + this.turnoSupervision);
        System.out.println("Personal de enfermería bajo supervisión: " + totalEnfermeros);
        for (int i = 0; i < totalEnfermeros; i++) {
            if (enfermeros[i] != null) {
                System.out.println("  - " + enfermeros[i].getNombre() + " (" + enfermeros[i].getCargo()
                        + ") -> Pacientes asignados: " + enfermeros[i].getNoPacientes() + "/"
                        + Enfermero.MAX_PACIENTES);
            }
        }
        System.out.println("Auditoría de protocolos de enfermería concluida exitosamente.\n");
    }

    /**
     * Función disciplinaria y administrativa de la Jefatura:
     * Revisa un acta administrativa levantada contra personal de enfermería
     * y la canaliza a Recursos Humanos o Comité de Ética con una resolución.
     */
    public void gestionarActaAdministrativa(hospital.sistema.ActaAdministrativa acta, String destino,
            String resolucion) {
        if (acta == null) {
            System.out.println("Error: El acta a gestionar no es válida.");
            return;
        }
        acta.procesarPorJefatura(destino, resolucion);
        System.out.println("\n[JEFATURA DE ENFERMERÍA - DICTAMEN OFICIAL]");
        System.out.println("Jefe/a " + getNombre() + " (Turno " + this.turnoSupervision + ", Piso " + this.pisoAsignado
                + ") procesó el acta Folio ACTA-" + acta.getFolio());
        System.out.println("Personal involucrado: "
                + (acta.getEnfermeroReportado() != null ? acta.getEnfermeroReportado().getNombre() : "N/A"));
        System.out.println(
                "Cédula: " + (acta.getEnfermeroReportado() != null ? acta.getEnfermeroReportado().getCedula() : "N/A"));
        System.out.println("Canalizado con oficio a: " + acta.getCanalizadoA());
        System.out.println("Dictamen: " + acta.getResolucionJefatura());
        System.out.println("El expediente queda asentado formalmente.\n");
    }

    @Override
    public String getCargo() {
        return "Jefe de Enfermería (Piso " + this.pisoAsignado + " - Turno " + this.turnoSupervision + ")";
    }
}
