public class Medico {
    // Atributos
     String nombre;
    String apellidos;
     String cedula;
     String especialidad;
     int noPacientes;

    // Estructura lineal para pacientes asignados (máximo 10)
     Paciente[] pacientesAsignados;

    // Constructor
    public Medico(String nombre, String apellidos, String cedula, String especialidad) {
        // TODO: Inicializar atributos
    }

    // Comportamientos (Métodos)
    public void registroEnSistema(Sistema sistema) {
        // TODO: Implementar lógica para registrarse en el sistema
    }

    public void solicitarPaciente(Paciente paciente) {
        // TODO: Implementar lógica
    }

    public void darConsulta(Paciente paciente) {
        // TODO: Implementar lógica (Recordar restricción: un paciente a la vez)
    }

    public void darTratamiento(Paciente paciente) {
        // TODO: Implementar lógica
    }

    public void verListaPacientes() {
        // TODO: Implementar lógica (ordenar por alfabeto descendente: apellidos, nombres, especialidad)
    }

    // TODO: Puedes agregar Getters y Setters según necesites
}
