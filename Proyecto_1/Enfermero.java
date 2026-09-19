public class Enfermero {
    // Atributos
    String nombre;
    String apellidos; 
     String cedula;
     String especialidad;
     int noPacientes;

    // Estructura lineal para pacientes asignados (máximo 3)
    Paciente[] pacientesAsignados;

    // Constructor
    public Enfermero(String nombre, String apellidos, String cedula, String especialidad) {
        // TODO: Inicializar atributos
    }

    // Comportamientos (Métodos)
    public void registroEnSistema(Sistema sistema) {
        // TODO: Implementar lógica
    }

    public void verListaPacientes() {
        // TODO: Implementar lógica (ordenar por alfabeto descendente: apellidos, nombres, especialidad)
    }

    public void darTratamiento(Paciente paciente) {
        // TODO: Implementar lógica
    }

    // TODO: Puedes agregar Getters y Setters según necesites
}
