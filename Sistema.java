public class Sistema {
    // Atributos principales
   String nombreHospital;
    int noMedicos;
    int noEnfermeros;
    int noPacientes;

    // Estructuras lineales sugeridas para el registro
     Medico[] medicos;
    private Enfermero[] enfermeros;
    private Paciente[] pacientes;

    // Constructor
    public Sistema(String nombreHospital) {
        // TODO: Inicializar los atributos y los arreglos/listas
    }

    // Comportamientos (Métodos)
    public void registroMedico(Medico medico) {
        // TODO: Implementar lógica de registro
    }

    public void registroEnfermero(Enfermero enfermero) {
        // TODO: Implementar lógica de registro
    }

    public void registroPaciente(Paciente paciente) {
        // TODO: Implementar lógica de registro
    }

    // Método sobrecargado: asignarPaciente
    public void asignarPaciente(Paciente paciente, Medico medico) {
        // TODO: Implementar lógica (validar límite de 10 pacientes y especialidad)
    }

    public void asignarPaciente(Paciente paciente, Enfermero enfermero) {
        // TODO: Implementar lógica (validar límite de 3 pacientes y especialidad)
    }
}
