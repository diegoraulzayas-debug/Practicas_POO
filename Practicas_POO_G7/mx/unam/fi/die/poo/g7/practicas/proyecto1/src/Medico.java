package mx.unam.fi.die.poo.g7.practicas.proyecto1;

/**
 * Proporciona las funciones de un médico dentro del hospital.
 */
public class Medico {
    // Atributos
    String nombre;
    String cedula;
    String especialidad;
    int noPacientes;
    Paciente[] pacientesAsignados;
    Paciente pacienteEnConsulta;

    // Constructor
    /**
     * Inicializa los datos básicos del médico mediante tres cadenas de tipo String.
     */
    public Medico(String nombre, String cedula, String especialidad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.noPacientes = 0;
        this.pacientesAsignados = new Paciente[10]; // Maximo 10 pacientes
        this.pacienteEnConsulta = null;
    }

    // Comportamientos
    /**
     * Vincula al médico en la base de datos central mediante un objeto de tipo Sistema y realiza la operación sin devolver un valor.
     */
    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarMedico(this);
        } else {
            System.out.println("Error: Sistema no valido.");
        }
    }

    // Solicitar paciente al sistema
    /**
     * Pide un enfermo de la lista de espera mediante un objeto de tipo Sistema y realiza la operación sin devolver un valor.
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

    // Admitir paciente (maximo 10)
    /**
     * Recibe a un enfermo en su lista mediante un objeto de tipo Paciente y devuelve un valor booleano de tipo boolean.
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

    // Dar consulta
    /**
     * Inicia la atención médica mediante un objeto de tipo Paciente y realiza la operación sin devolver un valor.
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

    // Dar tratamiento general
    /**
     * Indica el tratamiento a seguir mediante un objeto de tipo Paciente y realiza la operación sin devolver un valor.
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

    // Dar tratamiento con indicacion medica
    /**
     * Asigna un tratamiento específico mediante un objeto de tipo Paciente y una cadena de tipo String, y realiza la operación sin devolver un valor.
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

    // Ver lista de pacientes con Ordenamiento Burbuja (Bubble Sort) descendente (Z a A)
    /**
     * Muestra los enfermos asignados sin recibir datos y sin devolver un valor.
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
