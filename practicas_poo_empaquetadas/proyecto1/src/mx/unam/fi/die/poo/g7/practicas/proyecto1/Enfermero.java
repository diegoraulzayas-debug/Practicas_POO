package mx.unam.fi.die.poo.g7.practicas.proyecto1;

public class Enfermero {
    // Atributos
    String nombre;
    String cedula;
    String especialidad;
    int noPacientes;
    Paciente[] pacientesAsignados;

    // Constructor
    public Enfermero(String nombre, String cedula, String especialidad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.noPacientes = 0;
        this.pacientesAsignados = new Paciente[3]; // Maximo 3 pacientes
    }

    // Comportamientos
    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarEnfermero(this);
        } else {
            System.out.println("Error: Sistema no valido.");
        }
    }

    // Admitir paciente (maximo 3)
    public boolean admitirPaciente(Paciente paciente) {
        if (paciente == null) {
            return false;
        }

        // Si ya tiene 3 pacientes, no admite el numero 4
        if (this.noPacientes >= 3) {
            System.out.println("Aviso: El enfermero " + this.nombre + " ya tiene el cupo lleno (3/3). No puede cuidar mas pacientes.");
            return false;
        }

        this.pacientesAsignados[this.noPacientes] = paciente;
        this.noPacientes++;
        System.out.println("Paciente " + paciente.nombre + " asignado al enfermero " + this.nombre + " (" + this.noPacientes + "/3).");
        return true;
    }

    // Dar tratamiento administrando la indicacion que receto el medico
    public void darTratamiento(Paciente paciente) {
        if (paciente == null) {
            return;
        }

        paciente.estaEnTratamiento = true;
        paciente.estaEnConsulta = false;
        System.out.println("El enfermero " + this.nombre + " administro el tratamiento a " + paciente.nombre + ": " + paciente.tratamiento);
    }

    // Dar tratamiento con indicacion manual
    public void darTratamiento(Paciente paciente, String indicacion) {
        if (paciente == null) {
            return;
        }

        paciente.estaEnTratamiento = true;
        paciente.estaEnConsulta = false;
        paciente.tratamiento = indicacion;
        System.out.println("El enfermero " + this.nombre + " administro tratamiento a " + paciente.nombre + ": " + indicacion);
    }

    // Ver lista de pacientes con Ordenamiento Burbuja (Bubble Sort) descendente (Z a A)
    public void verListaPacientes() {
        System.out.println("\n--- Lista de Pacientes: Enfermero " + this.nombre + " ---");
        System.out.println("Especialidad: " + this.especialidad + " | Total: " + this.noPacientes + "/3");

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
