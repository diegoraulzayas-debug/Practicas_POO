package hospital.sistema;

import hospital.pacientes.Paciente;
import hospital.personal.Enfermero;

/**
 * Representa un acta administrativa o reporte de mala praxis / conducta
 * levantado por un paciente hacia un enfermero, gestionado y resuelto por la Jefatura de Enfermería.
 * Cada acta cuenta con un folio correlativo único autoincremental.
 * 
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public class ActaAdministrativa {
    private static int contadorFolios = 1000;

    private final int folio;
    private final Paciente pacienteAfectado;
    private final Enfermero enfermeroReportado;
    private final String fechaHora;
    private final String motivo;
    private final String descripcionHechos;
    private String resolucionJefatura;
    private String canalizadoA; // "RECURSOS HUMANOS", "COMITÉ DE ÉTICA", etc.
    private boolean procesada;

    /**
     * Construye un acta administrativa con los datos del incidente y asigna un folio correlativo único.
     * 
     * @param pacienteAfectado Paciente denunciante o afectado por el hecho.
     * @param enfermeroReportado Profesional de enfermería contra quien se levanta el acta.
     * @param fechaHora Fecha y hora del incidente reportado.
     * @param motivo Motivo general de la queja o reporte disciplinario.
     * @param descripcionHechos Narrativa detallada de los hechos ocurridos.
     */
    public ActaAdministrativa(Paciente pacienteAfectado, Enfermero enfermeroReportado, 
                              String fechaHora, String motivo, String descripcionHechos) {
        contadorFolios++;
        this.folio = contadorFolios;
        this.pacienteAfectado = pacienteAfectado;
        this.enfermeroReportado = enfermeroReportado;
        this.fechaHora = (fechaHora == null || fechaHora.trim().isEmpty()) ? "FECHA_NO_ESPECIFICADA" : fechaHora.trim();
        this.motivo = (motivo == null || motivo.trim().isEmpty()) ? "MALA PRAXIS / QUEJA GENERAL" : motivo.trim().toUpperCase();
        this.descripcionHechos = (descripcionHechos == null || descripcionHechos.trim().isEmpty()) ? "Sin descripción detallada de los hechos." : descripcionHechos.trim();
        this.resolucionJefatura = "PENDIENTE DE REVISIÓN";
        this.canalizadoA = "PENDIENTE";
        this.procesada = false;
    }

    /**
     * Obtiene el folio único consecutivo del acta administrativa.
     * 
     * @return Número de folio oficial.
     */
    public int getFolio() {
        return this.folio;
    }

    /**
     * Obtiene el paciente que levantó la queja o resultó afectado.
     * 
     * @return Referencia al objeto Paciente denunciante.
     */
    public Paciente getPacienteAfectado() {
        return this.pacienteAfectado;
    }

    /**
     * Obtiene el enfermero reportado en el acta.
     * 
     * @return Referencia al objeto Enfermero reportado.
     */
    public Enfermero getEnfermeroReportado() {
        return this.enfermeroReportado;
    }

    /**
     * Obtiene la fecha y hora de registro del incidente.
     * 
     * @return Cadena con fecha y hora.
     */
    public String getFechaHora() {
        return this.fechaHora;
    }

    /**
     * Obtiene el motivo general o causa del reporte.
     * 
     * @return Motivo en mayúsculas.
     */
    public String getMotivo() {
        return this.motivo;
    }

    /**
     * Obtiene la descripción detallada de los hechos acontecidos.
     * 
     * @return Texto con la narrativa del incidente.
     */
    public String getDescripcionHechos() {
        return this.descripcionHechos;
    }

    /**
     * Obtiene la resolución o dictamen asentado por la jefatura de enfermería.
     * 
     * @return Resolución oficial.
     */
    public String getResolucionJefatura() {
        return this.resolucionJefatura;
    }

    /**
     * Obtiene el órgano o departamento al que fue turnada el acta.
     * 
     * @return Destino formal (ej. "RECURSOS HUMANOS", "COMITÉ DE ÉTICA").
     */
    public String getCanalizadoA() {
        return this.canalizadoA;
    }

    /**
     * Indica si el acta ya fue revisada y procesada por la Jefatura de Enfermería.
     * 
     * @return true si ya fue procesada, false si permanece pendiente.
     */
    public boolean isProcesada() {
        return this.procesada;
    }

    /**
     * Procesa formalmente el acta administrativa asignando destino y dictamen de jefatura.
     * 
     * @param destino Departamento institucional al que se remite el expediente.
     * @param resolucion Dictamen y medidas acordadas por la jefatura.
     */
    public void procesarPorJefatura(String destino, String resolucion) {
        if (destino == null || destino.trim().isEmpty()) {
            this.canalizadoA = "RECURSOS HUMANOS";
        } else {
            this.canalizadoA = destino.trim().toUpperCase();
        }

        if (resolucion == null || resolucion.trim().isEmpty()) {
            this.resolucionJefatura = "Acta turnada formalmente para investigación y deslinde de responsabilidades.";
        } else {
            this.resolucionJefatura = resolucion.trim();
        }
        this.procesada = true;
    }

    /**
     * Imprime en consola un reporte formal con el desglose completo del acta administrativa.
     */
    public void mostrarDetalleActa() {
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("            ACTA ADMINISTRATIVA HOSPITALARIA               ");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Folio: ACTA-" + this.folio + " | Fecha/Hora: " + this.fechaHora);
        System.out.println("Paciente Denunciante: " + (this.pacienteAfectado != null ? this.pacienteAfectado.getNombre() : "N/A"));
        if (this.enfermeroReportado != null) {
            System.out.println("Personal Reportado:   " + this.enfermeroReportado.getNombre() 
                    + " (" + this.enfermeroReportado.getCargo() + ")");
            System.out.println("Cédula Profesional:   " + this.enfermeroReportado.getCedula());
            System.out.println("Especialidad:         " + this.enfermeroReportado.getEspecialidad());
        } else {
            System.out.println("Personal Reportado:   NO ESPECIFICADO");
        }
        System.out.println("Motivo del reporte:   " + this.motivo);
        System.out.println("Descripción Hechos:   " + this.descripcionHechos);
        System.out.println("Estado del trámite:   " + (this.procesada ? "PROCESADA POR JEFATURA" : "PENDIENTE DE REVISIÓN"));
        if (this.procesada) {
            System.out.println("Canalizado a:         " + this.canalizadoA);
            System.out.println("Dictamen de Jefatura: " + this.resolucionJefatura);
        }
        System.out.println("-----------------------------------------------------------");
    }
}
