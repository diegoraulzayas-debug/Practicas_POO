package mx.unam.fi.die.poo.g7.practicas.proyecto1;

/**
 * Representa el sistema central de administracion y gestion hospitalaria.
 * Controla el registro de medicos, enfermeros y pacientes, asi como
 * las politicas de asignacion de pacientes a personal clinico.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Sistema {
    /** Nombre del hospital gestionado por el sistema. */
    String nombreHospital;

    /** Arreglo que almacena a los medicos registrados. */
    Medico[] medicos;

    /** Numero actual de medicos registrados en el sistema. */
    int noMedicos;

    /** Arreglo que almacena a los enfermeros registrados. */
    Enfermero[] enfermeros;

    /** Numero actual de enfermeros registrados en el sistema. */
    int noEnfermeros;

    /** Arreglo con capacidad dinamica que almacena a los pacientes registrados. */
    Paciente[] pacientes;

    /** Numero actual de pacientes registrados en el sistema. */
    int noPacientes;

    /**
     * Construye una instancia del sistema hospitalario con el nombre indicado.
     * Inicializa los arreglos de medicos (50), enfermeros (100) y pacientes (10 con crecimiento dinamico).
     *
     * @param nombreHospital Nombre institucional del hospital.
     */
    public Sistema(String nombreHospital) {
        this.nombreHospital = nombreHospital;
        this.medicos = new Medico[50];
        this.noMedicos = 0;
        this.enfermeros = new Enfermero[100]; // Ahora 100 enfermeros
        this.noEnfermeros = 0;
        this.pacientes = new Paciente[10]; // Empieza en 10, pero crecera dinamicamente
        this.noPacientes = 0;
    }

    /**
     * Constructor por defecto que inicializa el sistema con el nombre "Hospital General".
     */
    public Sistema() {
        this.nombreHospital = "Hospital General";
        this.medicos = new Medico[50];
        this.noMedicos = 0;
        this.enfermeros = new Enfermero[100]; // Ahora 100 enfermeros
        this.noEnfermeros = 0;
        this.pacientes = new Paciente[10]; // Empieza en 10, pero crecera dinamicamente
        this.noPacientes = 0;
    }

    /**
     * Registra un nuevo medico en el sistema hospitalario si hay cupo en el catalogo (maximo 50).
     *
     * @param medico Medico a registrar.
     */
    public void registrarMedico(Medico medico) {
        if (medico != null && this.noMedicos < 50) {
            this.medicos[this.noMedicos] = medico;
            this.noMedicos++;
            System.out.println("Medico " + medico.nombre + " registrado exitosamente en el sistema.");
        }
    }

    /**
     * Registra un nuevo enfermero en el sistema hospitalario si hay cupo en el catalogo (maximo 100).
     *
     * @param enfermero Enfermero a registrar.
     */
    public void registrarEnfermero(Enfermero enfermero) {
        if (enfermero != null && this.noEnfermeros < 100) {
            this.enfermeros[this.noEnfermeros] = enfermero;
            this.noEnfermeros++;
            System.out.println("Enfermero " + enfermero.nombre + " registrado exitosamente en el sistema.");
        }
    }

    /**
     * Registra un nuevo paciente en el sistema, redimensionando dinamicamente
     * el arreglo al doble de capacidad si este se llena.
     *
     * @param paciente Paciente a dar de alta.
     */
    public void registrarPaciente(Paciente paciente) {
        if (paciente != null) {
            // Si el arreglo esta lleno, lo hacemos crecer al doble de su tamano
            if (this.noPacientes == this.pacientes.length) {
                Paciente[] nuevoArreglo = new Paciente[this.pacientes.length * 2];
                for (int i = 0; i < this.pacientes.length; i++) {
                    nuevoArreglo[i] = this.pacientes[i];
                }
                this.pacientes = nuevoArreglo; // Reemplazamos el arreglo viejo por el nuevo mas grande
            }
            this.pacientes[this.noPacientes] = paciente;
            this.noPacientes++;
            System.out.println("Paciente " + paciente.nombre + " registrado exitosamente en el sistema.");
        }
    }

    /**
     * Asigna un paciente de forma manual a un medico, validando compatibilidad de especialidades.
     *
     * @param paciente Paciente que requiere atencion.
     * @param medico Medico al que se asignara el paciente.
     */
    public void asignarPaciente(Paciente paciente, Medico medico) {
        if (paciente == null || medico == null) {
            System.out.println("Error: Datos no validos.");
            return;
        }

        if (!paciente.especialidad.equalsIgnoreCase(medico.especialidad)) {
            System.out.println("Error: La especialidad del medico (" + medico.especialidad + ") no coincide con la del paciente (" + paciente.especialidad + ").");
            return;
        }

        medico.admitirPaciente(paciente);
    }

    /**
     * Asigna un paciente de forma manual a un enfermero, validando compatibilidad de especialidades.
     *
     * @param paciente Paciente a asignar.
     * @param enfermero Enfermero al que se asignara el paciente.
     */
    public void asignarPaciente(Paciente paciente, Enfermero enfermero) {
        if (paciente == null || enfermero == null) {
            System.out.println("Error: Datos no validos.");
            return;
        }

        if (!paciente.especialidad.equalsIgnoreCase(enfermero.especialidad)) {
            System.out.println("Error: La especialidad del enfermero (" + enfermero.especialidad + ") no coincide con la del paciente (" + paciente.especialidad + ").");
            return;
        }

        enfermero.admitirPaciente(paciente);
    }

    /**
     * Asigna de manera automatica a un paciente con el primer medico disponible
     * que coincida con su especialidad y cuente con cupo de atencion.
     *
     * @param paciente Paciente que solicita asignacion automatica.
     */
    public void asignarPacienteAutomatico(Paciente paciente) {
        if (paciente == null) return;

        for (int i = 0; i < this.noMedicos; i++) {
            Medico m = this.medicos[i];
            if (m.especialidad.equalsIgnoreCase(paciente.especialidad) && m.noPacientes < 10) {
                asignarPaciente(paciente, m);
                return;
            }
        }
        System.out.println("No hay medico disponible para la especialidad " + paciente.especialidad);
    }
}
