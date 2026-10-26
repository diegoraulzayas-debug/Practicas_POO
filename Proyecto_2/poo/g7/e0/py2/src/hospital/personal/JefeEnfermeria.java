package hospital.personal;

import hospital.pacientes.Paciente;

/**
 * Representa al Jefe de Enfermería del hospital.
 * Atributos propios mutables: turnoSupervision y pisoAsignado (getters y setters).
 * Funciones adicionales de liderazgo: supervisión de guardias clínicas, auditoría de protocolos
 * y gestión disciplinaria/administrativa de actas levantadas contra el personal de enfermería.
 * 
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public class JefeEnfermeria extends Enfermero {
    private String turnoSupervision; // MATUTINO, VESPERTINO, NOCTURNO
    private int pisoAsignado;

    /**
     * Construye al Jefe de Enfermería asignando turno de guardia y piso de responsabilidad.
     * Asigna automáticamente la especialidad "GENERAL".
     * 
     * @param nombre Nombre del jefe de enfermería.
     * @param cedula Cédula profesional.
     * @param turnoSupervision Turno de guardia a cargo (MATUTINO, VESPERTINO, NOCTURNO).
     * @param pisoAsignado Piso del hospital asignado para supervisión.
     */
    public JefeEnfermeria(String nombre, String cedula, String turnoSupervision, int pisoAsignado) {
        super(nombre, cedula, "GENERAL");
        setTurnoSupervision(turnoSupervision);
        setPisoAsignado(pisoAsignado);
    }

    /**
     * Obtiene el turno de supervisión activo de la jefatura.
     * 
     * @return Turno en mayúsculas (MATUTINO, VESPERTINO o NOCTURNO).
     */
    public String getTurnoSupervision() {
        return this.turnoSupervision;
    }

    /**
     * Establece o actualiza el turno de supervisión de la jefatura.
     * 
     * @param turnoSupervision Turno de supervisión a asignar.
     */
    public void setTurnoSupervision(String turnoSupervision) {
        if (turnoSupervision == null || turnoSupervision.trim().isEmpty()) {
            this.turnoSupervision = "MATUTINO";
        } else {
            this.turnoSupervision = turnoSupervision.trim().toUpperCase();
        }
    }

    /**
     * Obtiene el número de piso clínico bajo la supervisión del jefe de enfermería.
     * 
     * @return Número de piso hospitalario.
     */
    public int getPisoAsignado() {
        return this.pisoAsignado;
    }

    /**
     * Establece el piso asignado, garantizando que sea al menos el piso 1.
     * 
     * @param pisoAsignado Número de piso a asignar.
     */
    public void setPisoAsignado(int pisoAsignado) {
        if (pisoAsignado < 1) {
            this.pisoAsignado = 1;
        } else {
            this.pisoAsignado = pisoAsignado;
        }
    }

    /**
     * Evalúa si el jefe de enfermería puede atender al paciente.
     * Debido a su rango superior y formación integral, puede atender a cualquier paciente del hospital.
     * 
     * @param paciente Paciente a evaluar.
     * @return true si el paciente no es nulo.
     */
    @Override
    public boolean puedeAtender(Paciente paciente) {
        return paciente != null;
    }

    /**
     * Realiza una consulta y supervisión de validación del plan de cuidados de enfermería.
     * 
     * @param paciente Paciente evaluado bajo supervisión de jefatura.
     */
    @Override
    public void darConsulta(Paciente paciente) {
        super.darConsulta(paciente);
        System.out.println(
                "  [Supervisión de Jefatura - Piso " + this.pisoAsignado + ", Turno " + this.turnoSupervision + "]");
        System.out.println("  Jefe/a " + getNombre() + " valida el plan de cuidados integrales de enfermería.");
    }

    /**
     * Función adicional de coordinación y supervisión de guardia clínica:
     * Audita el estado de cada enfermero, pacientes asignados y cumplimiento de protocolos.
     * 
     * @param enfermeros Arreglo de enfermeros bajo supervisión.
     * @param totalEnfermeros Número de enfermeros activos en el turno.
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
     * 
     * @param acta Acta administrativa a procesar.
     * @param destino Área u órgano institucional al que se turna (ej. "RECURSOS HUMANOS", "COMITÉ DE ÉTICA").
     * @param resolucion Dictamen o conclusión formal de la jefatura.
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

    /**
     * Retorna la denominación del cargo junto con el piso y turno asignados.
     * 
     * @return Cadena que describe el cargo de jefatura.
     */
    @Override
    public String getCargo() {
        return "Jefe de Enfermería (Piso " + this.pisoAsignado + " - Turno " + this.turnoSupervision + ")";
    }
}
