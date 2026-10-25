package hospital.personal;

import interfaces.AtencionMedica;
import hospital.pacientes.Paciente;
import hospital.sistema.Sistema;

/**
 * Clase abstracta base que representa a un Enfermero/a del sistema hospitalario.
 * Encapsulamiento estricto:
 * - 'nombre', 'cedula' y 'especialidad' son private final (inmutables, solo getters, sin setters).
 * - 'pacientesAsignados' limitado a 3 pacientes simultáneos.
 * - Implementa Merge Sort nativo descendente O(n log n).
 */
public abstract class Enfermero implements AtencionMedica {
    private final String nombre; // Inmutable
    private final String cedula; // Inmutable
    private final String especialidad; // Inmutable
    private int noPacientes;
    private Paciente[] pacientesAsignados;

    public static final int MAX_PACIENTES = 3;

    public Enfermero(String nombre, String cedula, String especialidad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "ENFERMERO_DESCONOCIDO";
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

    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarEnfermero(this);
        } else {
            System.out.println("Error: Sistema no válido para registrar al enfermero.");
        }
    }

    public abstract boolean puedeAtender(Paciente paciente);

    public boolean admitirPaciente(Paciente paciente) {
        if (paciente == null) return false;

        if (!puedeAtender(paciente)) {
            System.out.println("Error: El enfermero " + this.nombre + " (" + this.especialidad 
                    + ") no puede atender al paciente " + paciente.getNombre() + " (" + paciente.getEspecialidad() + ").");
            return false;
        }

        for (int i = 0; i < this.noPacientes; i++) {
            if (this.pacientesAsignados[i] == paciente) {
                System.out.println("Aviso: El paciente " + paciente.getNombre() + " ya está asignado a este enfermero.");
                return false;
            }
        }

        if (this.noPacientes >= MAX_PACIENTES) {
            System.out.println("Aviso: El enfermero " + this.nombre + " ya tiene el cupo lleno (" 
                    + MAX_PACIENTES + "/" + MAX_PACIENTES + "). No puede cuidar más pacientes.");
            return false;
        }

        this.pacientesAsignados[this.noPacientes] = paciente;
        this.noPacientes++;
        System.out.println("Paciente " + paciente.getNombre() + " asignado al enfermero " + this.nombre 
                + " (" + this.noPacientes + "/" + MAX_PACIENTES + ").");
        return true;
    }

    @Override
    public void darConsulta(Paciente paciente) {
        if (paciente == null) return;
        paciente.setEstaEnConsulta(true);
        paciente.setEstaEnTratamiento(false);
        System.out.println("El personal de enfermería " + this.nombre + " toma signos vitales y evalúa a: " + paciente.getNombre());
    }

    @Override
    public void darTratamiento(Paciente paciente) {
        if (paciente == null) return;
        paciente.setEstaEnTratamiento(true);
        paciente.setEstaEnConsulta(false);
        System.out.println("El enfermero " + this.nombre + " administró el tratamiento a " 
                + paciente.getNombre() + ": " + paciente.getTratamiento());
    }

    @Override
    public void darTratamiento(Paciente paciente, String indicacion) {
        if (paciente == null) return;
        paciente.setEstaEnTratamiento(true);
        paciente.setEstaEnConsulta(false);
        paciente.setTratamiento(indicacion);
        System.out.println("El enfermero " + this.nombre + " administró cuidados/tratamiento a " 
                + paciente.getNombre() + ": " + indicacion);
    }

    public void verListaPacientes() {
        System.out.println("\n--- Lista de Pacientes: Enfermero " + this.nombre + " (" + getCargo() + ") ---");
        System.out.println("Cédula: " + this.cedula + " | Especialidad: " + this.especialidad + " | Total: " + this.noPacientes + "/" + MAX_PACIENTES);

        if (this.noPacientes == 0) {
            System.out.println("No tiene pacientes a su cuidado actualmente.");
            return;
        }

        Paciente[] copia = new Paciente[this.noPacientes];
        for (int i = 0; i < this.noPacientes; i++) {
            copia[i] = this.pacientesAsignados[i];
        }

        mergeSortDescendente(copia, 0, this.noPacientes - 1);

        for (int i = 0; i < this.noPacientes; i++) {
            Paciente p = copia[i];
            String estado = "En reposo/espera";
            if (p.isEstaEnConsulta()) {
                estado = "En valoración";
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

    public abstract String getCargo();

    @Override
    public String toString() {
        return getCargo() + ": " + this.nombre + " (Cédula: " + this.cedula + ", " + this.especialidad + ")";
    }
}
