package mx.unam.fi.die.poo.g7.practicas.proyecto1;

/**
 * Representa al personal de enfermeria en el hospital.
 * Gestiona la atencion de hasta un maximo de 3 pacientes asignados,
 * administrando tratamientos y mostrando el listado ordenado de pacientes.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Enfermero {
    /** Nombre del enfermero. */
    String nombre;

    /** Cedula profesional del enfermero. */
    String cedula;

    /** Especialidad medica del enfermero. */
    String especialidad;

    /** Numero actual de pacientes asignados (maximo 3). */
    int noPacientes;

    /** Arreglo que almacena a los pacientes asignados. */
    Paciente[] pacientesAsignados;

    /**
     * Construye un objeto Enfermero con nombre, cedula y especialidad.
     * Inicializa la capacidad de atencion para un maximo de 3 pacientes.
     *
     * @param nombre Nombre completo del enfermero.
     * @param cedula Cedula profesional del enfermero.
     * @param especialidad Area medica o especialidad asignada.
     */
    public Enfermero(String nombre, String cedula, String especialidad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.noPacientes = 0;
        this.pacientesAsignados = new Paciente[3]; // Maximo 3 pacientes
    }

    /**
     * Registra al enfermero dentro del sistema hospitalario provisto.
     *
     * @param sistema Instancia del sistema hospitalario donde se realizara el alta.
     */
    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarEnfermero(this);
        } else {
            System.out.println("Error: Sistema no valido.");
        }
    }

    /**
     * Admite y asigna a un paciente bajo el cuidado del enfermero si no ha alcanzado
     * el cupo maximo de 3 pacientes.
     *
     * @param paciente Paciente que sera asignado.
     * @return {@code true} si el paciente fue admitido con exito; {@code false} si el cupo esta lleno o el paciente es nulo.
     */
    public boolean admitirPaciente(Paciente paciente) {
        if (paciente == null) {
            return false;
        }

        // Si ya tiene 3 pacientes, no admite el numero 4
        if (this.noPacientes >= 3) {
            System.out.println("Aviso: El enfermero " + this.nombre + " ya tiene el cupo lleno (3/3). No puede cuidar mas pacientes.");
            return false;
        }

        this.pacientesAsignados[this.noPacientes] = paciente;
        this.noPacientes++;
        System.out.println("Paciente " + paciente.nombre + " asignado al enfermero " + this.nombre + " (" + this.noPacientes + "/3).");
        return true;
    }

    /**
     * Administra el tratamiento que previamente le fue recetado al paciente por el medico.
     * Actualiza el estado del paciente a en tratamiento.
     *
     * @param paciente Paciente al que se le aplicara el tratamiento.
     */
    public void darTratamiento(Paciente paciente) {
        if (paciente == null) {
            return;
        }

        paciente.estaEnTratamiento = true;
        paciente.estaEnConsulta = false;
        System.out.println("El enfermero " + this.nombre + " administro el tratamiento a " + paciente.nombre + ": " + paciente.tratamiento);
    }

    /**
     * Administra una indicacion o tratamiento personalizado a un paciente.
     *
     * @param paciente Paciente al que se le aplicara el tratamiento.
     * @param indicacion Descripcion del medicamento o cuidado a administrar.
     */
    public void darTratamiento(Paciente paciente, String indicacion) {
        if (paciente == null) {
            return;
        }

        paciente.estaEnTratamiento = true;
        paciente.estaEnConsulta = false;
        paciente.tratamiento = indicacion;
        System.out.println("El enfermero " + this.nombre + " administro tratamiento a " + paciente.nombre + ": " + indicacion);
    }

    /**
     * Muestra la lista de pacientes a cargo del enfermero ordenada alfabeticamente
     * de forma descendente (Z a A) utilizando el algoritmo de ordenamiento burbuja.
     */
    public void verListaPacientes() {
        System.out.println("\n--- Lista de Pacientes: Enfermero " + this.nombre + " ---");
        System.out.println("Especialidad: " + this.especialidad + " | Total: " + this.noPacientes + "/3");

        if (this.noPacientes == 0) {
            System.out.println("No tiene pacientes asignados.");
            return;
        }

        // Copia del arreglo para ordenar
        Paciente[] copia = new Paciente[this.noPacientes];
        for (int i = 0; i < this.noPacientes; i++) {
            copia[i] = this.pacientesAsignados[i];
        }

        // Ordenamiento Burbuja (Bubble Sort) descendente (Z a A)
        for (int i = 0; i < this.noPacientes - 1; i++) {
            for (int j = 0; j < this.noPacientes - 1 - i; j++) {
                if (copia[j].nombre.charAt(0) < copia[j + 1].nombre.charAt(0)) {
                    Paciente temp = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = temp;
                }
            }
        }

        // Mostrar lista ordenada
        for (int i = 0; i < this.noPacientes; i++) {
            Paciente p = copia[i];
            String estado = "En espera";
            if (p.estaEnConsulta) {
                estado = "En consulta";
            } else if (p.estaEnTratamiento) {
                estado = "En tratamiento (" + p.tratamiento + ")";
            }
            System.out.println((i + 1) + ". " + p.nombre + " | Especialidad: " + p.especialidad + " | Estado: " + estado);
        }
    }
}
