import java.util.ArrayList;

public class Enfermero {
    // Atributos
    String nombre;
    String apellidos; 
    String cedula;
    String especialidad;
    int noPacientes;

    // Estructura lineal para pacientes asignados (máximo 3)
    private ArrayList<Paciente> pacientesAsignados;

    // Constructor
    public Enfermero(String nombre, String apellidos, String cedula, String especialidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.especialidad = especialidad;

        this.noPacientes = 0;
        this.pacientesAsignados = new ArrayList<Paciente>();
    }


    // Comportamientos (Métodos)
    public void registroEnSistema(Sistema sistema) {
       if(sistema != null){
        sistema.registroEnSistema(this);
        System.out.println("¡Enfermero " + this.nombre + " " + this.apellidos + " registrado exitosamente");
       }else{
        System.out.println("Error: El sistema no es valido");
       }
    }

    public void verListaPacientes() {
        int total = this.pacientesAsignados.size(); // Obtiene la cantidad de elementos en el ArrayList[cite: 1]
        
        if (total == 0) {
            System.out.println("El enfermero " + this.nombre + " no tiene pacientes asignados.");
            return;
        }

        // Se crea una copia local del ArrayList para no alterar el orden original de asignación[cite: 1]
        ArrayList<Paciente> copiaVisual = new ArrayList<Paciente>(this.pacientesAsignados);

        // Algoritmo de ordenamiento simple adaptado a ArrayList
        for (int i = 0; i < total - 1; i++) {
            for (int j = i + 1; j < total; j++) {
                
                // Compara apellidos usando get(index)[cite: 3]
                int comp = copiaVisual.get(i).getApellidos().compareToIgnoreCase(copiaVisual.get(j).getApellidos());
                
                // Si son iguales, desempatan por nombre[cite: 3]
                if (comp == 0) {
                    comp = copiaVisual.get(i).getNombre().compareToIgnoreCase(copiaVisual.get(j).getNombre());
                }
                // Si también son iguales, desempatan por especialidad[cite: 3, 5]
                if (comp == 0) {
                    comp = copiaVisual.get(i).getEspecialidadAtencion().compareToIgnoreCase(copiaVisual.get(j).getEspecialidadAtencion());
                }

                // Intercambia elementos usando get() y set()[cite: 1]
                if (comp < 0) {
                    Paciente temp = copiaVisual.get(i);
                    copiaVisual.set(i, copiaVisual.get(j));
                    copiaVisual.set(j, temp);
                }
            }
        }

        // Imprime la lista ordenada
        System.out.println("\n--- Pacientes Asignados (Orden Alfabético Descendente) ---");
        for (int i = 0; i < total; i++) {
            System.out.println((i + 1) + ". " + copiaVisual.get(i).getApellidos() + ", "  + copiaVisual.get(i).getNombre() + " | Especialidad: "  + copiaVisual.get(i).getEspecialidadAtencion());
        }
    }

    public void darTratamiento(Paciente paciente) {
        
        if(paciente == null){
            System.out.println("Paciente no valido...");
            return;
        }

        boolean pacienteEncontrado = false;

        if (this.pacientesAsignados.contains(paciente)) {
            paciente.setEstaEnTratamiento(true); // Cambia el estado del paciente[cite: 3]
            paciente.setEstaEnConsulta(false);
            System.out.println("El enfermero " + this.nombre + " está administrando tratamiento al paciente: "  + paciente.getApellidos() + " " + paciente.getNombre());
            return;
        }

        System.out.println("El paciente no está asignado a este enfermero.");
    }

    //Getters y Setters
   public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNoPacientes() {
        // Devuelve directamente el tamaño actual de la lista para mantener congruencia[cite: 1]
        return this.pacientesAsignados.size();
    }

    public void setNoPacientes(int noPacientes) {
        this.noPacientes = noPacientes;
    }

    // Tipo de retorno y parámetro adaptados a ArrayList[cite: 1]
    public ArrayList<Paciente> getPacientesAsignados() {
    return pacientesAsignados;
}

public void setPacientesAsignados(ArrayList<Paciente> pacientesAsignados) {
    this.pacientesAsignados = pacientesAsignados;
    this.noPacientes = pacientesAsignados.size();
}
}