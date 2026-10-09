package mx.unam.fi.die.poo.g7.practicas.proyecto1;

public class Paciente {
    // Atributos
    String nombre;
    String especialidad;
    String tratamiento;
    boolean estaEnConsulta;
    boolean estaEnTratamiento;

    // Constructor
    public Paciente(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.tratamiento = "Sin tratamiento asignado";
        this.estaEnConsulta = false;
        this.estaEnTratamiento = false;
    }

    // Comportamientos
    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarPaciente(this);
        }
    }

    public void solicitarConsulta(Sistema sistema) {
        if (sistema != null) {
            sistema.asignarPacienteAutomatico(this);
        }
    }

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
