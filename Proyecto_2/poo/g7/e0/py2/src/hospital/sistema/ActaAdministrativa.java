package hospital.sistema;

import hospital.pacientes.Paciente;
import hospital.personal.Enfermero;

/**
 * Representa un acta administrativa o reporte de mala praxis / conducta
 * levantado por un paciente hacia un enfermero, gestionado por la Jefatura de Enfermería.
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

    public int getFolio() {
        return this.folio;
    }

    public Paciente getPacienteAfectado() {
        return this.pacienteAfectado;
    }

    public Enfermero getEnfermeroReportado() {
        return this.enfermeroReportado;
    }

    public String getFechaHora() {
        return this.fechaHora;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public String getDescripcionHechos() {
        return this.descripcionHechos;
    }

    public String getResolucionJefatura() {
        return this.resolucionJefatura;
    }

    public String getCanalizadoA() {
        return this.canalizadoA;
    }

    public boolean isProcesada() {
        return this.procesada;
    }

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
