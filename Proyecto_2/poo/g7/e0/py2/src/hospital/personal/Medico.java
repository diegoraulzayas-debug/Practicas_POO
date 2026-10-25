package hospital.personal;

import interfaces.AtencionMedica;
import hospital.pacientes.Paciente;
import hospital.sistema.Sistema;

/**
 * Clase abstracta base que representa a un Médico.
 * Encapsulamiento estricto:
 * - 'nombre' y 'cedula' son private final (inmutables, solo getter, sin setter).
 * - 'especialidad' es private final (la especialidad del médico es fija, solo getter).
 * - 'pacientesAsignados' y 'pacienteEnConsulta' son administrados por métodos clínicos.
 * - Implementa Merge Sort nativo O(n log n) sin bibliotecas externas.
 */
public abstract class Medico implements AtencionMedica {
    private final String nombre; // Inmutable tras contratación
    private final String cedula; // Inmutable (cédula profesional)
    private final String especialidad; // Inmutable: especialidad del médico
    private int noPacientes;
    private Paciente[] pacientesAsignados;
    private Paciente pacienteEnConsulta;

    public static final int MAX_PACIENTES = 10;

    public Medico(String nombre, String cedula, String especialidad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "MEDICO_DESCONOCIDO";
        } else {
            this.nombre = nombre.trim();
        }

        if (cedula == null || cedula.trim().isEmpty()) {
            this.cedula = "SIN_CEDULA";
        } else {
            this.cedula = cedula.trim();
        }

        if (especialidad == null || especialidad.trim().isEmpty()) {
            this.especialidad = "GENERAL";
        } else {
            this.especialidad = especialidad.trim().toUpperCase();
        }

        this.noPacientes = 0;
        this.pacientesAsignados = new Paciente[MAX_PACIENTES];
        this.pacienteEnConsulta = null;
    }

    // Solo Getters para atributos inmutables (sin setters)
    public String getNombre() {
        return this.nombre;
    }

    public String getCedula() {
        return this.cedula;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public int getNoPacientes() {
        return this.noPacientes;
    }

    public Paciente[] getPacientesAsignados() {
        Paciente[] copia = new Paciente[this.noPacientes];
        for (int i = 0; i < this.noPacientes; i++) {
            copia[i] = this.pacientesAsignados[i];
        }
        return copia;
    }

    public Paciente getPacienteEnConsulta() {
        return this.pacienteEnConsulta;
    }

    public void setPacienteEnConsulta(Paciente pacienteEnConsulta) {
        this.pacienteEnConsulta = pacienteEnConsulta;
    }

    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarMedico(this);
        } else {
            System.out.println("Error: Sistema no válido para registrar al médico.");
        }
    }

    public void solicitarPaciente(Sistema sistema) {
        if (this.noPacientes >= MAX_PACIENTES) {
            System.out.println("El Dr./Dra. " + this.nombre + " ya tiene el cupo máximo de " + MAX_PACIENTES + " pacientes.");
            return;
        }

        if (sistema != null) {
            for (int i = 0; i < sistema.getNoPacientes(); i++) {
                Paciente p = sistema.getPacientes()[i];
                if (p != null && puedeAtender(p)) {
                    boolean yaAsignado = false;
                    for (int j = 0; j < this.noPacientes; j++) {
                        if (this.pacientesAsignados[j] == p) {
                            yaAsignado = true;
                            break;
                        }
                    }
                    if (!yaAsignado) {
                        this.admitirPaciente(p);
                        return;
                    }
                }
            }
            System.out.println("No hay pacientes en espera compatibles para " + this.nombre + " (" + this.especialidad + ").");
        }
    }

    public abstract boolean puedeAtender(Paciente paciente);

    public boolean admitirPaciente(Paciente paciente) {
        if (paciente == null) {
            System.out.println("Error: Paciente nulo.");
            return false;
        }

        if (!puedeAtender(paciente)) {
            System.out.println("Error: El Dr./Dra. " + this.nombre + " (" + this.especialidad 
                    + ") no está facultado para atender al paciente " + paciente.getNombre() + " (" + paciente.getEspecialidad() + ").");
            return false;
        }

        for (int i = 0; i < this.noPacientes; i++) {
            if (this.pacientesAsignados[i] == paciente) {
                System.out.println("Aviso: El paciente " + paciente.getNombre() + " ya está asignado a este médico.");
                return false;
            }
        }

        if (this.noPacientes >= MAX_PACIENTES) {
            System.out.println("Aviso: El Dr./Dra. " + this.nombre + " ya tiene cupo lleno (" + MAX_PACIENTES + "/" + MAX_PACIENTES + ").");
            return false;
        }

        this.pacientesAsignados[this.noPacientes] = paciente;
        this.noPacientes++;
        System.out.println("Paciente " + paciente.getNombre() + " admitido con el Dr./Dra. " + this.nombre 
                + " (" + this.noPacientes + "/" + MAX_PACIENTES + ").");
        return true;
    }

    @Override
    public void darConsulta(Paciente paciente) {
        if (paciente == null) {
            System.out.println("Error: Paciente nulo en consulta.");
            return;
        }

        if (this.pacienteEnConsulta != null && this.pacienteEnConsulta != paciente) {
            System.out.println("El Dr./Dra. " + this.nombre + " ya está atendiendo a " + this.pacienteEnConsulta.getNombre() + ". Solo puede atender a uno a la vez.");
            return;
        }

        this.pacienteEnConsulta = paciente;
        paciente.setEstaEnConsulta(true);
        paciente.setEstaEnTratamiento(false);
        System.out.println("El Dr./Dra. " + this.nombre + " está dando consulta médica a: " + paciente.getNombre());
    }

    @Override
    public void darTratamiento(Paciente paciente) {
        darTratamiento(paciente, "Reposo y seguimiento clínico general.");
    }

    @Override
    public void darTratamiento(Paciente paciente, String indicacion) {
        if (paciente == null) {
            System.out.println("Error: Paciente nulo al prescribir tratamiento.");
            return;
        }

        if (indicacion == null || indicacion.trim().isEmpty()) {
            System.out.println("Error: La indicación o prescripción médica no puede estar vacía.");
            return;
        }

        if (this.pacienteEnConsulta == paciente) {
            this.pacienteEnConsulta = null;
        }

        paciente.setEstaEnConsulta(false);
        paciente.setEstaEnTratamiento(true);
        paciente.setTratamiento(indicacion.trim());
        System.out.println("El Dr./Dra. " + this.nombre + " recetó e indicó a " + paciente.getNombre() + ": " + indicacion);
    }

    public void verListaPacientes() {
        System.out.println("\n--- Lista de Pacientes: Dr./Dra. " + this.nombre + " (" + getTipoMedico() + ") ---");
        System.out.println("Cédula: " + this.cedula + " | Especialidad: " + this.especialidad + " | Total: " + this.noPacientes + "/" + MAX_PACIENTES);

        if (this.noPacientes == 0) {
            System.out.println("No tiene pacientes asignados actualmente.");
            return;
        }

        Paciente[] copia = new Paciente[this.noPacientes];
        for (int i = 0; i < this.noPacientes; i++) {
            copia[i] = this.pacientesAsignados[i];
        }

        mergeSortDescendente(copia, 0, this.noPacientes - 1);

        for (int i = 0; i < this.noPacientes; i++) {
            Paciente p = copia[i];
            String estado = "En espera";
            if (p.isEstaEnConsulta()) {
                estado = "En consulta activa";
            } else if (p.isEstaEnTratamiento()) {
                estado = "En tratamiento (" + p.getTratamiento() + ")";
            }
            System.out.println((i + 1) + ". " + p.getNombre() + " | Especialidad: " + p.getEspecialidad() + " | Estado: " + estado);
        }
    }

    private void mergeSortDescendente(Paciente[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            mergeSortDescendente(arreglo, izquierda, medio);
            mergeSortDescendente(arreglo, medio + 1, derecha);
            mezclarDescendente(arreglo, izquierda, medio, derecha);
        }
    }

    private void mezclarDescendente(Paciente[] arreglo, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        Paciente[] L = new Paciente[n1];
        Paciente[] R = new Paciente[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arreglo[izquierda + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arreglo[medio + 1 + j];
        }

        int i = 0, j = 0, k = izquierda;
        while (i < n1 && j < n2) {
            if (L[i].getNombre().compareToIgnoreCase(R[j].getNombre()) >= 0) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }

    public abstract String getTipoMedico();

    @Override
    public String toString() {
        return getTipoMedico() + ": Dr./Dra. " + this.nombre + " (Cédula: " + this.cedula + ", " + this.especialidad + ")";
    }
}
