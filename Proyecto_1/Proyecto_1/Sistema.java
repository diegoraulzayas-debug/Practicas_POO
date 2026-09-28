public class Sistema {
    // Atributos
    String nombreHospital;
    Medico[] medicos;
    int noMedicos;
    Enfermero[] enfermeros;
    int noEnfermeros;
    Paciente[] pacientes;
    int noPacientes;

    // Constructor principal
    public Sistema(String nombreHospital) {
        this.nombreHospital = nombreHospital;
        this.medicos = new Medico[50];
        this.noMedicos = 0;
        this.enfermeros = new Enfermero[50];
        this.noEnfermeros = 0;
        this.pacientes = new Paciente[100];
        this.noPacientes = 0;
    }

    // Constructor por defecto
    public Sistema() {
        this.nombreHospital = "Hospital General";
        this.medicos = new Medico[50];
        this.noMedicos = 0;
        this.enfermeros = new Enfermero[50];
        this.noEnfermeros = 0;
        this.pacientes = new Paciente[100];
        this.noPacientes = 0;
    }

    // Comportamientos de registro
    public void registrarMedico(Medico medico) {
        if (medico != null && this.noMedicos < 50) {
            this.medicos[this.noMedicos] = medico;
            this.noMedicos++;
            System.out.println("Médico " + medico.nombre + " registrado exitosamente en el sistema.");
        }
    }

    public void registrarEnfermero(Enfermero enfermero) {
        if (enfermero != null && this.noEnfermeros < 50) {
            this.enfermeros[this.noEnfermeros] = enfermero;
            this.noEnfermeros++;
            System.out.println("Enfermero " + enfermero.nombre + " registrado exitosamente en el sistema.");
        }
    }

    public void registrarPaciente(Paciente paciente) {
        if (paciente != null && this.noPacientes < 100) {
            this.pacientes[this.noPacientes] = paciente;
            this.noPacientes++;
            System.out.println("Paciente " + paciente.nombre + " registrado exitosamente en el sistema.");
        }
    }

    // Método sobrecargado: Asignar paciente a Médico
    public void asignarPaciente(Paciente paciente, Medico medico) {
        if (paciente == null || medico == null) {
            System.out.println("Error: Datos no válidos.");
            return;
        }

        if (!paciente.especialidad.equalsIgnoreCase(medico.especialidad)) {
            System.out.println("Error: La especialidad del médico (" + medico.especialidad + ") no coincide con la del paciente (" + paciente.especialidad + ").");
            return;
        }

        medico.admitirPaciente(paciente);
    }

    // Método sobrecargado: Asignar paciente a Enfermero
    public void asignarPaciente(Paciente paciente, Enfermero enfermero) {
        if (paciente == null || enfermero == null) {
            System.out.println("Error: Datos no válidos.");
            return;
        }

        if (!paciente.especialidad.equalsIgnoreCase(enfermero.especialidad)) {
            System.out.println("Error: La especialidad del enfermero (" + enfermero.especialidad + ") no coincide con la del paciente (" + paciente.especialidad + ").");
            return;
        }

        enfermero.admitirPaciente(paciente);
    }

    // Asignación automática al primer médico disponible con cupo
    public void asignarPacienteAutomatico(Paciente paciente) {
        if (paciente == null) return;

        for (int i = 0; i < this.noMedicos; i++) {
            Medico m = this.medicos[i];
            if (m.especialidad.equalsIgnoreCase(paciente.especialidad) && m.noPacientes < 10) {
                asignarPaciente(paciente, m);
                return;
            }
        }
        System.out.println("No hay médico disponible para la especialidad " + paciente.especialidad);
    }
}
