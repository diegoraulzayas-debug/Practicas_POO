package hospital.sistema;

import hospital.personal.Medico;
import hospital.personal.Enfermero;
import hospital.pacientes.Paciente;

/**
 * Gestor central del hospital que coordina personal médico, de enfermería y pacientes.
 * Emplea polimorfismo dinámico: maneja arreglos polimórficos de Medico[], Enfermero[] y Paciente[],
 * permitiendo almacenar cualquier subclase sin crear estructuras independientes.
 * Crecimiento dinámico automático: cuando los arreglos se llenan, se redimensionan al doble.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public class Sistema {
    /** Nombre oficial del centro hospitalario. */
    private String nombreHospital;
    /** Arreglo polimórfico que almacena a los médicos adscritos al hospital. */
    private Medico[] medicos;
    /** Contador del número actual de médicos registrados. */
    private int noMedicos;
    /** Arreglo polimórfico que almacena al personal de enfermería adscrito. */
    private Enfermero[] enfermeros;
    /** Contador del número actual de enfermeros registrados. */
    private int noEnfermeros;
    /** Arreglo polimórfico que almacena a los pacientes ingresados. */
    private Paciente[] pacientes;
    /** Contador del número actual de pacientes ingresados. */
    private int noPacientes;
    /** Arreglo que almacena las actas administrativas y reportes levantados. */
    private ActaAdministrativa[] actasAdministrativas;
    /** Contador del número actual de actas administrativas registradas. */
    private int noActas;

    /** Capacidad inicial por defecto para el arreglo de médicos. */
    public static final int CAPACIDAD_INICIAL_MEDICOS = 50;
    /** Capacidad inicial por defecto para el arreglo de enfermeros. */
    public static final int CAPACIDAD_INICIAL_ENFERMEROS = 100;
    /** Capacidad inicial por defecto para el arreglo de pacientes. */
    public static final int CAPACIDAD_INICIAL_PACIENTES = 10;
    /** Capacidad inicial por defecto para el arreglo de actas administrativas. */
    public static final int CAPACIDAD_INICIAL_ACTAS = 20;

    /**
     * Constructor que inicializa el sistema hospitalario con un nombre personalizado
     * y capacidades iniciales para los arreglos dinámicos.
     *
     * @param nombreHospital Nombre institucional del hospital.
     */
    public Sistema(String nombreHospital) {
        setNombreHospital(nombreHospital);
        this.medicos = new Medico[CAPACIDAD_INICIAL_MEDICOS];
        this.noMedicos = 0;
        this.enfermeros = new Enfermero[CAPACIDAD_INICIAL_ENFERMEROS];
        this.noEnfermeros = 0;
        this.pacientes = new Paciente[CAPACIDAD_INICIAL_PACIENTES];
        this.noPacientes = 0;
        this.actasAdministrativas = new ActaAdministrativa[CAPACIDAD_INICIAL_ACTAS];
        this.noActas = 0;
    }

    /**
     * Constructor por defecto que asigna el nombre "Hospital Central Universitario".
     */
    public Sistema() {
        this("Hospital Central Universitario");
    }

    /**
     * Obtiene el nombre del hospital.
     *
     * @return Cadena de texto con el nombre institucional.
     */
    public String getNombreHospital() {
        return this.nombreHospital;
    }

    /**
     * Establece o actualiza el nombre del hospital con validación de valores nulos o vacíos.
     *
     * @param nombreHospital Nuevo nombre del hospital.
     */
    public void setNombreHospital(String nombreHospital) {
        if (nombreHospital == null || nombreHospital.trim().isEmpty()) {
            this.nombreHospital = "Hospital General";
        } else {
            this.nombreHospital = nombreHospital.trim();
        }
    }

    /**
     * Obtiene el arreglo polimórfico de médicos registrados.
     *
     * @return Arreglo de instancias de {@link Medico}.
     */
    public Medico[] getMedicos() {
        return this.medicos;
    }

    /**
     * Obtiene el número de médicos actualmente registrados.
     *
     * @return Cantidad de médicos.
     */
    public int getNoMedicos() {
        return this.noMedicos;
    }

    /**
     * Obtiene el arreglo polimórfico del personal de enfermería.
     *
     * @return Arreglo de instancias de {@link Enfermero}.
     */
    public Enfermero[] getEnfermeros() {
        return this.enfermeros;
    }

    /**
     * Obtiene el número de enfermeros actualmente registrados.
     *
     * @return Cantidad de enfermeros.
     */
    public int getNoEnfermeros() {
        return this.noEnfermeros;
    }

    /**
     * Obtiene el arreglo polimórfico de pacientes ingresados en el hospital.
     *
     * @return Arreglo de instancias de {@link Paciente}.
     */
    public Paciente[] getPacientes() {
        return this.pacientes;
    }

    /**
     * Obtiene el número de pacientes actualmente registrados.
     *
     * @return Cantidad de pacientes.
     */
    public int getNoPacientes() {
        return this.noPacientes;
    }

    /**
     * Obtiene el arreglo de actas administrativas registradas.
     *
     * @return Arreglo de instancias de {@link ActaAdministrativa}.
     */
    public ActaAdministrativa[] getActasAdministrativas() {
        return this.actasAdministrativas;
    }

    /**
     * Obtiene el total de actas administrativas emitidas.
     *
     * @return Cantidad de actas administrativas.
     */
    public int getNoActas() {
        return this.noActas;
    }

    /**
     * Registra un acta administrativa en el sistema, redimensionando dinámicamente
     * el arreglo si se alcanza la capacidad máxima actual.
     *
     * @param acta Instancia de {@link ActaAdministrativa} a registrar.
     */
    public void registrarActa(ActaAdministrativa acta) {
        if (acta == null) {
            System.out.println("Error: No se puede registrar un acta nula.");
            return;
        }
        if (this.noActas == this.actasAdministrativas.length) {
            ActaAdministrativa[] nuevoArreglo = new ActaAdministrativa[this.actasAdministrativas.length * 2];
            for (int i = 0; i < this.actasAdministrativas.length; i++) {
                nuevoArreglo[i] = this.actasAdministrativas[i];
            }
            this.actasAdministrativas = nuevoArreglo;
        }
        this.actasAdministrativas[this.noActas] = acta;
        this.noActas++;
        System.out.println("Acta Administrativa folio ACTA-" + acta.getFolio() + " registrada con éxito en el sistema.");
    }

    /**
     * Despliega en consola el listado completo y detalle de todas las actas
     * administrativas levantadas en el hospital.
     */
    public void listarActas() {
        System.out.println("\n=== REGISTRO GENERAL DE ACTAS ADMINISTRATIVAS (" + this.noActas + ") ===");
        if (this.noActas == 0) {
            System.out.println("No se han levantado actas administrativas en el hospital.");
            return;
        }
        for (int i = 0; i < this.noActas; i++) {
            this.actasAdministrativas[i].mostrarDetalleActa();
        }
    }

    /**
     * Registra un médico en el hospital aplicando polimorfismo dinámico.
     * Evita duplicados y redimensiona el arreglo dinámico al doble si se llena.
     *
     * @param medico Instancia de {@link Medico} (general o especialista) a registrar.
     */
    public void registrarMedico(Medico medico) {
        if (medico == null) {
            System.out.println("Error: No se puede registrar un médico nulo.");
            return;
        }
        for (int i = 0; i < this.noMedicos; i++) {
            if (this.medicos[i] == medico) {
                System.out.println("Aviso: El médico " + medico.getNombre() + " ya está registrado en el hospital.");
                return;
            }
        }
        if (this.noMedicos == this.medicos.length) {
            Medico[] nuevoArreglo = new Medico[this.medicos.length * 2];
            for (int i = 0; i < this.medicos.length; i++) {
                nuevoArreglo[i] = this.medicos[i];
            }
            this.medicos = nuevoArreglo;
        }
        this.medicos[this.noMedicos] = medico;
        this.noMedicos++;
        System.out.println(medico.getTipoMedico() + " Dr./Dra. " + medico.getNombre() + " registrado exitosamente.");
    }

    /**
     * Registra un enfermero en el hospital aplicando polimorfismo dinámico.
     * Evita duplicados y redimensiona el arreglo dinámico al doble si se llena.
     *
     * @param enfermero Instancia de {@link Enfermero} (especialista o jefe) a registrar.
     */
    public void registrarEnfermero(Enfermero enfermero) {
        if (enfermero == null) {
            System.out.println("Error: No se puede registrar un enfermero nulo.");
            return;
        }
        for (int i = 0; i < this.noEnfermeros; i++) {
            if (this.enfermeros[i] == enfermero) {
                System.out.println("Aviso: El enfermero " + enfermero.getNombre() + " ya está registrado en el hospital.");
                return;
            }
        }
        if (this.noEnfermeros == this.enfermeros.length) {
            Enfermero[] nuevoArreglo = new Enfermero[this.enfermeros.length * 2];
            for (int i = 0; i < this.enfermeros.length; i++) {
                nuevoArreglo[i] = this.enfermeros[i];
            }
            this.enfermeros = nuevoArreglo;
        }
        this.enfermeros[this.noEnfermeros] = enfermero;
        this.noEnfermeros++;
        System.out.println(enfermero.getCargo() + " " + enfermero.getNombre() + " registrado exitosamente.");
    }

    /**
     * Registra un paciente en el sistema general aplicando polimorfismo dinámico.
     * Evita duplicados y redimensiona el arreglo dinámico al doble si se llena.
     *
     * @param paciente Instancia de {@link Paciente} (general o de especialidad) a registrar.
     */
    public void registrarPaciente(Paciente paciente) {
        if (paciente == null) {
            System.out.println("Error: No se puede registrar un paciente nulo.");
            return;
        }
        for (int i = 0; i < this.noPacientes; i++) {
            if (this.pacientes[i] == paciente) {
                System.out.println("Aviso: El paciente " + paciente.getNombre() + " ya está registrado en el hospital.");
                return;
            }
        }

        if (this.noPacientes == this.pacientes.length) {
            Paciente[] nuevoArreglo = new Paciente[this.pacientes.length * 2];
            for (int i = 0; i < this.pacientes.length; i++) {
                nuevoArreglo[i] = this.pacientes[i];
            }
            this.pacientes = nuevoArreglo;
        }
        this.pacientes[this.noPacientes] = paciente;
        this.noPacientes++;
        System.out.println("Paciente " + paciente.getNombre() + " registrado en el sistema (" + paciente.obtenerTipoCondicion() + ").");
    }

    /**
     * Asigna un paciente a un médico verificando la compatibilidad clínica de especialidad.
     * Demuestra polimorfismo estático mediante sobrecarga de métodos.
     *
     * @param paciente Paciente a admitir.
     * @param medico Médico al cual se asignará el paciente.
     */
    public void asignarPaciente(Paciente paciente, Medico medico) {
        if (paciente == null || medico == null) {
            System.out.println("Error: Datos no válidos para asignación a médico.");
            return;
        }
        if (!medico.puedeAtender(paciente)) {
            System.out.println("Incompatibilidad clínica: El médico (" + medico.getEspecialidad() 
                    + ") no corresponde con la especialidad del paciente (" + paciente.getEspecialidad() + ").");
            return;
        }
        medico.admitirPaciente(paciente);
    }

    /**
     * Asigna un paciente a un enfermero verificando la compatibilidad clínica de especialidad.
     * Demuestra polimorfismo estático mediante sobrecarga de métodos.
     *
     * @param paciente Paciente a admitir.
     * @param enfermero Enfermero al cual se asignará el paciente.
     */
    public void asignarPaciente(Paciente paciente, Enfermero enfermero) {
        if (paciente == null || enfermero == null) {
            System.out.println("Error: Datos no válidos para asignación a enfermero.");
            return;
        }
        if (!enfermero.puedeAtender(paciente)) {
            System.out.println("Incompatibilidad clínica: El enfermero (" + enfermero.getEspecialidad() 
                    + ") no corresponde con la especialidad del paciente (" + paciente.getEspecialidad() + ").");
            return;
        }
        enfermero.admitirPaciente(paciente);
    }

    /**
     * Realiza una asignación automática de un paciente buscando el primer médico compatible
     * por especialidad que cuente con cupo disponible.
     *
     * @param paciente Paciente que requiere asignación médica.
     */
    public void asignarPacienteAutomatico(Paciente paciente) {
        if (paciente == null) return;

        for (int i = 0; i < this.noMedicos; i++) {
            Medico m = this.medicos[i];
            if (m.puedeAtender(paciente) && m.getNoPacientes() < Medico.MAX_PACIENTES) {
                asignarPaciente(paciente, m);
                return;
            }
        }
        System.out.println("No hay médico disponible con cupo para la especialidad " + paciente.getEspecialidad() + " del paciente " + paciente.getNombre());
    }

    /**
     * Despliega en consola un resumen general con las estadísticas operativas del hospital:
     * cantidad de médicos, enfermeros, pacientes y actas administrativas.
     */
    public void mostrarEstadisticas() {
        System.out.println("\n=======================================================");
        System.out.println("       ESTADO ACTUAL DEL HOSPITAL: " + this.nombreHospital);
        System.out.println("=======================================================");
        System.out.println("Total de médicos registrados: " + this.noMedicos + " (Capacidad actual: " + this.medicos.length + ")");
        System.out.println("Total de enfermeros registrados: " + this.noEnfermeros + " (Capacidad actual: " + this.enfermeros.length + ")");
        System.out.println("Total de pacientes ingresados: " + this.noPacientes + " (Capacidad actual: " + this.pacientes.length + ")");
        System.out.println("Total de actas administrativas / quejas: " + this.noActas);
        System.out.println("=======================================================\n");
    }
}
