package mx.unam.fi.die.poo.g7.practicas.proyecto1;

/**
 * Representa a un medico dentro del sistema hospitalario.
 * Gestiona una consulta medica individual y una lista de hasta 10 pacientes asignados,
 * permitiendo dar consulta, prescribir tratamientos y listar pacientes en orden descendente.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Medico {
    /** Nombre del medico. */
    String nombre;

    /** Cedula profesional del medico. */
    String cedula;

    /** Especialidad medica del doctor. */
    String especialidad;

    /** Numero actual de pacientes asignados (maximo 10). */
    int noPacientes;

    /** Arreglo de pacientes asignados al medico. */
    Paciente[] pacientesAsignados;

    /** Paciente que se encuentra actualmente en consulta con el medico. */
    Paciente pacienteEnConsulta;

    /**
     * Construye una nueva instancia de Medico con nombre, cedula y especialidad.
     * Inicializa la capacidad de pacientes en un maximo de 10.
     *
     * @param nombre Nombre completo del medico.
     * @param cedula Cedula profesional.
     * @param especialidad Area medica de especialidad.
     */
    public Medico(String nombre, String cedula, String especialidad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.noPacientes = 0;
        this.pacientesAsignados = new Paciente[10]; // Maximo 10 pacientes
        this.pacienteEnConsulta = null;
    }

    /**
     * Registra al medico dentro del sistema hospitalario provisto.
     *
     * @param sistema Instancia del sistema hospitalario donde se dara de alta al medico.
     */
    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarMedico(this);
        } else {
            System.out.println("Error: Sistema no valido.");
        }
    }

    /**
     * Solicita al sistema un paciente disponible cuya especialidad coincida con la del medico
     * y lo admite si no se ha superado el limite de 10 pacientes.
     *
     * @param sistema Sistema hospitalario del cual se obtendra el paciente.
     */
    public void solicitarPaciente(Sistema sistema) {
        if (this.noPacientes >= 10) {
            System.out.println("El Dr./Dra. " + this.nombre + " ya tiene el maximo de 10 pacientes.");
            return;
        }

        if (sistema != null) {
            for (int i = 0; i < sistema.noPacientes; i++) {
                Paciente p = sistema.pacientes[i];
                if (p != null && p.especialidad.equalsIgnoreCase(this.especialidad)) {
                    this.admitirPaciente(p);
                    return;
                }
            }
            System.out.println("No hay pacientes disponibles para la especialidad " + this.especialidad);
        }
    }

    /**
     * Admite a un paciente bajo el cuidado del medico si hay cupo disponible (maximo 10).
     *
     * @param paciente Paciente a admitir.
     * @return {@code true} si el paciente fue admitido correctamente; {@code false} si el cupo esta lleno o el paciente es nulo.
     */
    public boolean admitirPaciente(Paciente paciente) {
        if (paciente == null) {
            return false;
        }

        // Si ya tiene 10 pacientes, no admite el numero 11
        if (this.noPacientes >= 10) {
            System.out.println("Aviso: El Dr./Dra. " + this.nombre + " ya tiene el cupo lleno (10/10). No puede admitir mas pacientes.");
            return false;
        }

        this.pacientesAsignados[this.noPacientes] = paciente;
        this.noPacientes++;
        System.out.println("Paciente " + paciente.nombre + " admitido con el Dr./Dra. " + this.nombre + " (" + this.noPacientes + "/10).");
        return true;
    }

    /**
     * Inicia la atencion en consulta para el paciente indicado.
     * Solo permite atender a un paciente a la vez.
     *
     * @param paciente Paciente que ingresa a consulta.
     */
    public void darConsulta(Paciente paciente) {
        if (paciente == null) {
            return;
        }

        if (this.pacienteEnConsulta != null && this.pacienteEnConsulta != paciente) {
            System.out.println("El medico ya esta atendiendo a " + this.pacienteEnConsulta.nombre + ". Solo puede atender a uno a la vez.");
            return;
        }

        this.pacienteEnConsulta = paciente;
        paciente.estaEnConsulta = true;
        paciente.estaEnTratamiento = false;
        System.out.println("El Dr./Dra. " + this.nombre + " esta dando consulta a: " + paciente.nombre);
    }

    /**
     * Asigna tratamiento general a un paciente y finaliza su consulta activa.
     *
     * @param paciente Paciente que pasa a tratamiento.
     */
    public void darTratamiento(Paciente paciente) {
        if (paciente == null) {
            return;
        }

        if (this.pacienteEnConsulta == paciente) {
            this.pacienteEnConsulta = null;
        }

        paciente.estaEnConsulta = false;
        paciente.estaEnTratamiento = true;
        System.out.println("El Dr./Dra. " + this.nombre + " ha indicado tratamiento a: " + paciente.nombre);
    }

    /**
     * Receta una indicacion medica o tratamiento particular al paciente y finaliza su consulta activa.
     *
     * @param paciente Paciente al que se le prescribe el tratamiento.
     * @param indicacion Descripcion o receta medica indicada por el doctor.
     */
    public void darTratamiento(Paciente paciente, String indicacion) {
        if (paciente == null) {
            return;
        }

        if (this.pacienteEnConsulta == paciente) {
            this.pacienteEnConsulta = null;
        }

        paciente.estaEnConsulta = false;
        paciente.estaEnTratamiento = true;
        paciente.tratamiento = indicacion;
        System.out.println("El Dr./Dra. " + this.nombre + " receto a " + paciente.nombre + ": " + indicacion);
    }

    /**
     * Muestra la lista de pacientes a cargo del medico ordenada alfabeticamente
     * de forma descendente (Z a A) utilizando el algoritmo de ordenamiento burbuja.
     */
    public void verListaPacientes() {
        System.out.println("\n--- Lista de Pacientes: Dr./Dra. " + this.nombre + " ---");
        System.out.println("Especialidad: " + this.especialidad + " | Total: " + this.noPacientes + "/10");

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
