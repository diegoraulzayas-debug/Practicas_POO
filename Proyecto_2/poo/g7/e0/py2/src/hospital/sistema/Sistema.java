package hospital.sistema;

import hospital.personal.Medico;
import hospital.personal.Enfermero;
import hospital.pacientes.Paciente;

/**
 * Gestor central del hospital que coordina personal médico, de enfermería y pacientes.
 * Emplea polimorfismo dinámico: maneja arreglos polimórficos de Medico[], Enfermero[] y Paciente[],
 * permitiendo almacenar cualquier subclase sin crear estructuras independientes.
 * Crecimiento dinámico automático: cuando los arreglos se llenan, se redimensionan al doble.
 */
public class Sistema {
    private String nombreHospital;
    private Medico[] medicos;
    private int noMedicos;
    private Enfermero[] enfermeros;
    private int noEnfermeros;
    private Paciente[] pacientes;
    private int noPacientes;
    private ActaAdministrativa[] actasAdministrativas;
    private int noActas;

    public static final int CAPACIDAD_INICIAL_MEDICOS = 50;
    public static final int CAPACIDAD_INICIAL_ENFERMEROS = 100;
    public static final int CAPACIDAD_INICIAL_PACIENTES = 10;
    public static final int CAPACIDAD_INICIAL_ACTAS = 20;

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

    public Sistema() {
        this("Hospital Central Universitario");
    }

    public String getNombreHospital() {
        return this.nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        if (nombreHospital == null || nombreHospital.trim().isEmpty()) {
            this.nombreHospital = "Hospital General";
        } else {
            this.nombreHospital = nombreHospital.trim();
        }
    }

    public Medico[] getMedicos() {
        return this.medicos;
    }

    public int getNoMedicos() {
        return this.noMedicos;
    }

    public Enfermero[] getEnfermeros() {
        return this.enfermeros;
    }

    public int getNoEnfermeros() {
        return this.noEnfermeros;
    }

    public Paciente[] getPacientes() {
        return this.pacientes;
    }

    public int getNoPacientes() {
        return this.noPacientes;
    }

    public ActaAdministrativa[] getActasAdministrativas() {
        return this.actasAdministrativas;
    }

    public int getNoActas() {
        return this.noActas;
    }

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

    // Registro polimórfico de médicos con crecimiento dinámico de arreglo
    public void registrarMedico(Medico medico) {
        if (medico == null) {
            System.out.println("Error: No se puede registrar un médico nulo.");
            return;
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

    // Registro polimórfico de enfermeros con crecimiento dinámico de arreglo
    public void registrarEnfermero(Enfermero enfermero) {
        if (enfermero == null) {
            System.out.println("Error: No se puede registrar un enfermero nulo.");
            return;
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

    // Registro polimórfico de pacientes con crecimiento dinámico de arreglo
    public void registrarPaciente(Paciente paciente) {
        if (paciente == null) {
            System.out.println("Error: No se puede registrar un paciente nulo.");
            return;
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

    // Polimorfismo estático (Sobrecarga de método): Asignación a Médico
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

    // Polimorfismo estático (Sobrecarga de método): Asignación a Enfermero
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

    // Asignación automática inteligente respetando reglas de especialidad y cupos
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

    // Resumen general del hospital
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
