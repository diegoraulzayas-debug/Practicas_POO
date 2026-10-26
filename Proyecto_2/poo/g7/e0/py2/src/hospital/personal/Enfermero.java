package hospital.personal;

import interfaces.AtencionMedica;
import hospital.pacientes.Paciente;
import hospital.sistema.Sistema;

/**
 * Clase abstracta base que representa a un Enfermero/a del sistema hospitalario.
 * Encapsulamiento estricto:
 * - 'nombre', 'cedula' y 'especialidad' son private final (inmutables, solo getters, sin setters).
 * - 'pacientesAsignados' limitado a un máximo de 3 pacientes simultáneos.
 * - Implementa Merge Sort nativo descendente O(n log n) para listar pacientes en orden alfabético inverso (Z-A).
 * 
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public abstract class Enfermero implements AtencionMedica {
    private final String nombre; // Inmutable
    private final String cedula; // Inmutable
    private final String especialidad; // Inmutable
    private int noPacientes;
    private Paciente[] pacientesAsignados;

    /** Capacidad máxima de pacientes que un enfermero puede cuidar simultáneamente. */
    public static final int MAX_PACIENTES = 3;

    /**
     * Construye un enfermero con nombre, cédula profesional y especialidad.
     * 
     * @param nombre Nombre del profesional de enfermería.
     * @param cedula Cédula profesional.
     * @param especialidad Especialidad clínica del enfermero.
     */
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

    /**
     * Obtiene el nombre del enfermero.
     * 
     * @return Nombre del enfermero (inmutable).
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la cédula profesional del enfermero.
     * 
     * @return Cédula profesional (inmutable).
     */
    public String getCedula() {
        return this.cedula;
    }

    /**
     * Obtiene la especialidad del enfermero.
     * 
     * @return Especialidad en mayúsculas (inmutable).
     */
    public String getEspecialidad() {
        return this.especialidad;
    }

    /**
     * Obtiene el número actual de pacientes asignados.
     * 
     * @return Número de pacientes asignados (máximo 3).
     */
    public int getNoPacientes() {
        return this.noPacientes;
    }

    /**
     * Retorna una copia segura del arreglo de pacientes asignados.
     * 
     * @return Arreglo nuevo con los pacientes asignados actuales.
     */
    public Paciente[] getPacientesAsignados() {
        Paciente[] copia = new Paciente[this.noPacientes];
        for (int i = 0; i < this.noPacientes; i++) {
            copia[i] = this.pacientesAsignados[i];
        }
        return copia;
    }

    /**
     * Registra formalmente al enfermero en el sistema hospitalario central.
     * 
     * @param sistema Instancia central del hospital.
     */
    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarEnfermero(this);
        } else {
            System.out.println("Error: Sistema no válido para registrar al enfermero.");
        }
    }

    /**
     * Evalúa polimórficamente si el enfermero puede atender y cuidar al paciente dado.
     * 
     * @param paciente Paciente a evaluar.
     * @return true si cumple con el perfil clínico correspondiente, false de lo contrario.
     */
    public abstract boolean puedeAtender(Paciente paciente);

    /**
     * Admite y asigna un paciente al cuidado del enfermero si no supera la capacidad máxima de 3.
     * 
     * @param paciente Paciente a admitir.
     * @return true si fue admitido exitosamente, false si no es compatible o ya tiene 3 pacientes.
     */
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

    /**
     * Realiza la valoración inicial de enfermería, toma de signos vitales y control clínico.
     * 
     * @param paciente Paciente valorado.
     */
    @Override
    public void darConsulta(Paciente paciente) {
        if (paciente == null) return;
        paciente.setEstaEnConsulta(true);
        paciente.setEstaEnTratamiento(false);
        System.out.println("El personal de enfermería " + this.nombre + " toma signos vitales y evalúa a: " + paciente.getNombre());
    }

    /**
     * Administra el tratamiento prescrito previamente al paciente.
     * 
     * @param paciente Paciente receptor del tratamiento.
     */
    @Override
    public void darTratamiento(Paciente paciente) {
        if (paciente == null) return;
        paciente.setEstaEnTratamiento(true);
        paciente.setEstaEnConsulta(false);
        System.out.println("El enfermero " + this.nombre + " administró el tratamiento a " 
                + paciente.getNombre() + ": " + paciente.getTratamiento());
    }

    /**
     * Administra cuidados específicos o un medicamento con indicación detallada al paciente.
     * 
     * @param paciente Paciente receptor del cuidado.
     * @param indicacion Indicación o medicamento administrado.
     */
    @Override
    public void darTratamiento(Paciente paciente, String indicacion) {
        if (paciente == null) return;
        paciente.setEstaEnTratamiento(true);
        paciente.setEstaEnConsulta(false);
        paciente.setTratamiento(indicacion);
        System.out.println("El enfermero " + this.nombre + " administró cuidados/tratamiento a " 
                + paciente.getNombre() + ": " + indicacion);
    }

    /**
     * Muestra en consola la lista de pacientes asignados al enfermero, ordenados alfabéticamente
     * de forma descendente (Z-A) utilizando Merge Sort nativo.
     */
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

    /**
     * Ordena recursivamente los pacientes mediante el algoritmo Merge Sort descendente.
     * 
     * @param arreglo Arreglo de pacientes.
     * @param izquierda Índice inicial del rango.
     * @param derecha Índice final del rango.
     */
    private void mergeSortDescendente(Paciente[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            mergeSortDescendente(arreglo, izquierda, medio);
            mergeSortDescendente(arreglo, medio + 1, derecha);
            mezclarDescendente(arreglo, izquierda, medio, derecha);
        }
    }

    /**
     * Mezcla dos subarreglos ordenados en orden alfabético inverso (Z-A).
     * 
     * @param arreglo Arreglo a mezclar.
     * @param izquierda Límite izquierdo.
     * @param medio Índice central de división.
     * @param derecha Límite derecho.
     */
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

    /**
     * Retorna la denominación específica del cargo de enfermería.
     * 
     * @return Nombre del cargo desempeñado.
     */
    public abstract String getCargo();

    /**
     * Retorna una representación textual concisa del enfermero.
     * 
     * @return Cadena formateada con cargo, nombre, cédula y especialidad.
     */
    @Override
    public String toString() {
        return getCargo() + ": " + this.nombre + " (Cédula: " + this.cedula + ", " + this.especialidad + ")";
    }
}
