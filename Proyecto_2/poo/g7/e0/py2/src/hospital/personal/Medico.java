package hospital.personal;

import interfaces.AtencionMedica;
import hospital.pacientes.Paciente;
import hospital.sistema.Sistema;

/**
 * Clase abstracta base que representa a un Médico en el hospital.
 * Encapsulamiento estricto:
 * - 'nombre' y 'cedula' son private final (inmutables, solo getter, sin setter).
 * - 'especialidad' es private final (la especialidad del médico es fija, solo getter).
 * - 'pacientesAsignados' y 'pacienteEnConsulta' son administrados por métodos clínicos protegidos.
 * - Implementa Merge Sort nativo O(n log n) sin bibliotecas externas para ordenar pacientes alfabéticamente de forma descendente.
 * 
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 2.0
 */
public abstract class Medico implements AtencionMedica {
    private final String nombre; // Inmutable tras contratación
    private final String cedula; // Inmutable (cédula profesional)
    private final String especialidad; // Inmutable: especialidad del médico
    private int noPacientes;
    private Paciente[] pacientesAsignados;
    private Paciente pacienteEnConsulta;

    /** Capacidad máxima de pacientes que un médico puede tener asignados simultáneamente. */
    public static final int MAX_PACIENTES = 10;

    /**
     * Construye un médico con nombre, cédula profesional y especialidad.
     * Inicializa el arreglo de pacientes asignados con la capacidad máxima establecida.
     * 
     * @param nombre Nombre completo del médico.
     * @param cedula Cédula profesional oficial.
     * @param especialidad Especialidad médica del profesional.
     */
    public Medico(String nombre, String cedula, String especialidad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "MEDICO_DESCONOCIDO";
        } else {
            this.nombre = nombre.trim();
        }

        if (cedula == null || cedula.trim().isEmpty()) {
            this.cedula = "SIN_CEDULA";
        } else {
            this.cedula = cedula.trim();
        }

        if (especialidad == null || especialidad.trim().isEmpty()) {
            this.especialidad = "GENERAL";
        } else {
            this.especialidad = especialidad.trim().toUpperCase();
        }

        this.noPacientes = 0;
        this.pacientesAsignados = new Paciente[MAX_PACIENTES];
        this.pacienteEnConsulta = null;
    }

    /**
     * Obtiene el nombre del médico.
     * 
     * @return Nombre del médico (inmutable).
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la cédula profesional del médico.
     * 
     * @return Cédula profesional (inmutable).
     */
    public String getCedula() {
        return this.cedula;
    }

    /**
     * Obtiene la especialidad del médico.
     * 
     * @return Especialidad en mayúsculas (inmutable).
     */
    public String getEspecialidad() {
        return this.especialidad;
    }

    /**
     * Obtiene el número actual de pacientes asignados al médico.
     * 
     * @return Cantidad de pacientes actualmente asignados.
     */
    public int getNoPacientes() {
        return this.noPacientes;
    }

    /**
     * Retorna una copia segura del arreglo de pacientes asignados para proteger el encapsulamiento.
     * 
     * @return Arreglo nuevo con los pacientes asignados actuales.
     */
    public Paciente[] getPacientesAsignados() {
        Paciente[] copia = new Paciente[this.noPacientes];
        for (int i = 0; i < this.noPacientes; i++) {
            copia[i] = this.pacientesAsignados[i];
        }
        return copia;
    }

    /**
     * Obtiene el paciente que se encuentra actualmente en consulta médica activa.
     * 
     * @return Referencia al paciente en consulta, o null si el consultorio está libre.
     */
    public Paciente getPacienteEnConsulta() {
        return this.pacienteEnConsulta;
    }

    /**
     * Asigna el paciente en consulta médica activa.
     * 
     * @param pacienteEnConsulta Paciente que entra a consulta, o null al finalizar.
     */
    public void setPacienteEnConsulta(Paciente pacienteEnConsulta) {
        this.pacienteEnConsulta = pacienteEnConsulta;
    }

    /**
     * Registra formalmente al médico en el sistema hospitalario central.
     * 
     * @param sistema Instancia central del hospital.
     */
    public void registroEnSistema(Sistema sistema) {
        if (sistema != null) {
            sistema.registrarMedico(this);
        } else {
            System.out.println("Error: Sistema no válido para registrar al médico.");
        }
    }

    /**
     * Busca y admite de forma automática a un paciente en lista de espera compatible con su perfil clínico.
     * 
     * @param sistema Instancia central del hospital de donde se toman los pacientes.
     */
    public void solicitarPaciente(Sistema sistema) {
        if (this.noPacientes >= MAX_PACIENTES) {
            System.out.println("El Dr./Dra. " + this.nombre + " ya tiene el cupo máximo de " + MAX_PACIENTES + " pacientes.");
            return;
        }

        if (sistema != null) {
            for (int i = 0; i < sistema.getNoPacientes(); i++) {
                Paciente p = sistema.getPacientes()[i];
                if (p != null && puedeAtender(p)) {
                    boolean yaAsignado = false;
                    for (int j = 0; j < this.noPacientes; j++) {
                        if (this.pacientesAsignados[j] == p) {
                            yaAsignado = true;
                            break;
                        }
                    }
                    if (!yaAsignado) {
                        this.admitirPaciente(p);
                        return;
                    }
                }
            }
            System.out.println("No hay pacientes en espera compatibles para " + this.nombre + " (" + this.especialidad + ").");
        }
    }

    /**
     * Evalúa polimórficamente si el médico está facultado para atender al paciente dado.
     * 
     * @param paciente Paciente a evaluar.
     * @return true si cumple con los criterios de especialidad y normativa clínica, false de lo contrario.
     */
    public abstract boolean puedeAtender(Paciente paciente);

    /**
     * Admite y agrega a un paciente a la lista de seguimiento del médico si cumple los requisitos.
     * 
     * @param paciente Paciente a admitir.
     * @return true si fue admitido exitosamente, false si fue rechazado por incompatibilidad o cupo lleno.
     */
    public boolean admitirPaciente(Paciente paciente) {
        if (paciente == null) {
            System.out.println("Error: Paciente nulo.");
            return false;
        }

        if (!puedeAtender(paciente)) {
            System.out.println("Error: El Dr./Dra. " + this.nombre + " (" + this.especialidad 
                    + ") no está facultado para atender al paciente " + paciente.getNombre() + " (" + paciente.getEspecialidad() + ").");
            return false;
        }

        for (int i = 0; i < this.noPacientes; i++) {
            if (this.pacientesAsignados[i] == paciente) {
                System.out.println("Aviso: El paciente " + paciente.getNombre() + " ya está asignado a este médico.");
                return false;
            }
        }

        if (this.noPacientes >= MAX_PACIENTES) {
            System.out.println("Aviso: El Dr./Dra. " + this.nombre + " ya tiene cupo lleno (" + MAX_PACIENTES + "/" + MAX_PACIENTES + ").");
            return false;
        }

        this.pacientesAsignados[this.noPacientes] = paciente;
        this.noPacientes++;
        System.out.println("Paciente " + paciente.getNombre() + " admitido con el Dr./Dra. " + this.nombre 
                + " (" + this.noPacientes + "/" + MAX_PACIENTES + ").");
        return true;
    }

    /**
     * Inicia una consulta médica presencial con el paciente.
     * 
     * @param paciente Paciente atendido en consulta.
     */
    @Override
    public void darConsulta(Paciente paciente) {
        if (paciente == null) {
            System.out.println("Error: Paciente nulo en consulta.");
            return;
        }

        if (this.pacienteEnConsulta != null && this.pacienteEnConsulta != paciente) {
            System.out.println("El Dr./Dra. " + this.nombre + " ya está atendiendo a " + this.pacienteEnConsulta.getNombre() + ". Solo puede atender a uno a la vez.");
            return;
        }

        this.pacienteEnConsulta = paciente;
        paciente.setEstaEnConsulta(true);
        paciente.setEstaEnTratamiento(false);
        System.out.println("El Dr./Dra. " + this.nombre + " está dando consulta médica a: " + paciente.getNombre());
    }

    /**
     * Prescribe el tratamiento clínico estándar por defecto al paciente.
     * 
     * @param paciente Paciente que recibe el tratamiento general.
     */
    @Override
    public void darTratamiento(Paciente paciente) {
        darTratamiento(paciente, "Reposo y seguimiento clínico general.");
    }

    /**
     * Prescribe un tratamiento clínico específico o medicamento al paciente.
     * 
     * @param paciente Paciente receptor de la prescripción.
     * @param indicacion Descripción detallada del tratamiento o medicamento recetado.
     */
    @Override
    public void darTratamiento(Paciente paciente, String indicacion) {
        if (paciente == null) {
            System.out.println("Error: Paciente nulo al prescribir tratamiento.");
            return;
        }

        if (indicacion == null || indicacion.trim().isEmpty()) {
            System.out.println("Error: La indicación o prescripción médica no puede estar vacía.");
            return;
        }

        if (this.pacienteEnConsulta == paciente) {
            this.pacienteEnConsulta = null;
        }

        paciente.setEstaEnConsulta(false);
        paciente.setEstaEnTratamiento(true);
        paciente.setTratamiento(indicacion.trim());
        System.out.println("El Dr./Dra. " + this.nombre + " recetó e indicó a " + paciente.getNombre() + ": " + indicacion);
    }

    /**
     * Imprime en consola la lista de pacientes asignados, ordenados alfabéticamente de la Z a la A
     * mediante el algoritmo Merge Sort descendente nativo.
     */
    public void verListaPacientes() {
        System.out.println("\n--- Lista de Pacientes: Dr./Dra. " + this.nombre + " (" + getTipoMedico() + ") ---");
        System.out.println("Cédula: " + this.cedula + " | Especialidad: " + this.especialidad + " | Total: " + this.noPacientes + "/" + MAX_PACIENTES);

        if (this.noPacientes == 0) {
            System.out.println("No tiene pacientes asignados actualmente.");
            return;
        }

        Paciente[] copia = new Paciente[this.noPacientes];
        for (int i = 0; i < this.noPacientes; i++) {
            copia[i] = this.pacientesAsignados[i];
        }

        mergeSortDescendente(copia, 0, this.noPacientes - 1);

        for (int i = 0; i < this.noPacientes; i++) {
            Paciente p = copia[i];
            String estado = "En espera";
            if (p.isEstaEnConsulta()) {
                estado = "En consulta activa";
            } else if (p.isEstaEnTratamiento()) {
                estado = "En tratamiento (" + p.getTratamiento() + ")";
            }
            System.out.println((i + 1) + ". " + p.getNombre() + " | Especialidad: " + p.getEspecialidad() + " | Estado: " + estado);
        }
    }

    /**
     * Algoritmo Merge Sort recursivo para ordenar pacientes en orden alfabético descendente (Z-A).
     * Complejidad temporal garantizada: O(n log n).
     * 
     * @param arreglo Arreglo de pacientes a ordenar.
     * @param izquierda Índice de inicio del subarreglo.
     * @param derecha Índice final del subarreglo.
     */
    private void mergeSortDescendente(Paciente[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            mergeSortDescendente(arreglo, izquierda, medio);
            mergeSortDescendente(arreglo, medio + 1, derecha);
            mezclarDescendente(arreglo, izquierda, medio, derecha);
        }
    }

    /**
     * Función de mezcla (merge) para combinar dos subarreglos ordenados en orden descendente.
     * 
     * @param arreglo Arreglo objetivo.
     * @param izquierda Límite izquierdo del primer subarreglo.
     * @param medio Punto de corte intermedio.
     * @param derecha Límite derecho del segundo subarreglo.
     */
    private void mezclarDescendente(Paciente[] arreglo, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        Paciente[] L = new Paciente[n1];
        Paciente[] R = new Paciente[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arreglo[izquierda + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arreglo[medio + 1 + j];
        }

        int i = 0, j = 0, k = izquierda;
        while (i < n1 && j < n2) {
            if (L[i].getNombre().compareToIgnoreCase(R[j].getNombre()) >= 0) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Retorna la denominación específica del tipo de médico.
     * 
     * @return Cadena que representa el tipo (ej. "Médico General", "Médico Especialista").
     */
    public abstract String getTipoMedico();

    /**
     * Retorna una representación textual concisa del médico.
     * 
     * @return Cadena formateada con tipo, nombre, cédula y especialidad.
     */
    @Override
    public String toString() {
        return getTipoMedico() + ": Dr./Dra. " + this.nombre + " (Cédula: " + this.cedula + ", " + this.especialidad + ")";
    }
}
