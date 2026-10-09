package mx.unam.fi.die.poo.g7.practicas.proyecto1;

/**
 * Representa a un paciente dentro del sistema hospitalario.
 * Contiene informacion sobre su nombre, especialidad clinica requerida,
 * tratamiento asignado y su estado actual de atencion medica.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Paciente {
    /** Nombre del paciente. */
    String nombre;

    /** Especialidad medica que requiere el paciente. */
    String especialidad;

    /** Descripcion o receta del tratamiento asignado. */
    String tratamiento;

    /** Indica si el paciente se encuentra actualmente en consulta medica. */
    boolean estaEnConsulta;

    /** Indica si el paciente se encuentra actualmente bajo tratamiento. */
    boolean estaEnTratamiento;

    /**
     * Construye una nueva instancia de Paciente con nombre y especialidad requerida.
     * Inicializa el tratamiento como "Sin tratamiento asignado" y los estados en falso.
     *
     * @param nombre Nombre completo del paciente.
     * @param especialidad Especialidad medica que necesita el paciente.
     */
    public Paciente(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.tratamiento = "Sin tratamiento asignado";
        this.estaEnConsulta = false;
        this.estaEnTratamiento = false;
    }

    /**
     * Registra al paciente en el sistema hospitalario especificado.
     *
     * @param sistema Sistema hospitalario donde se dara de alta al paciente.
     */
    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarPaciente(this);
        }
    }

    /**
     * Solicita una consulta medica al sistema para asignacion automatica de especialista.
     *
     * @param sistema Sistema hospitalario encargado de la asignacion.
     */
    public void solicitarConsulta(Sistema sistema) {
        if (sistema != null) {
            sistema.asignarPacienteAutomatico(this);
        }
    }

    /**
     * Muestra en consola el estado actual de atencion del paciente y su tratamiento o receta.
     */
    public void verTratamiento() {
        System.out.println("\n--- Estado y Tratamiento del Paciente ---");
        System.out.println("Paciente: " + this.nombre);
        System.out.println("Especialidad: " + this.especialidad);
        if (this.estaEnConsulta) {
            System.out.println("Estado: En consulta medica.");
        } else if (this.estaEnTratamiento) {
            System.out.println("Estado: En tratamiento.");
            System.out.println("Indicacion / Medicamento: " + this.tratamiento);
        } else {
            System.out.println("Estado: En espera de atencion.");
        }
    }
}
