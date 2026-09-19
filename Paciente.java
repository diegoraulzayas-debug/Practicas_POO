public class Paciente {
    // Atributos
     String nombre;
     String apellidos; 
     String especialidadAtencion;

    // Mecanismos para determinar si está en consulta o en tratamiento (Restricción del PDF)
     boolean estaEnConsulta;
     boolean estaEnTratamiento;

    // Constructor
    public Paciente(String nombre, String apellidos, String especialidadAtencion) {
        // TODO: Inicializar atributos
        this.estaEnConsulta = false;
        this.estaEnTratamiento = false;
    }

    // Comportamientos (Métodos)
    public void registroEnSistema(Sistema sistema) {
        // TODO: Implementar lógica
    }

    public void solicitarConsulta() {
        // TODO: Implementar lógica
    }

    public void verTratamiento() {
        // TODO: Implementar lógica
    }

    // Getters y Setters sugeridos para controlar los estados
    public boolean isEstaEnConsulta() {
        return estaEnConsulta;
    }

    public void setEstaEnConsulta(boolean estaEnConsulta) {
        this.estaEnConsulta = estaEnConsulta;
    }

    public boolean isEstaEnTratamiento() {
        return estaEnTratamiento;
    }

    public void setEstaEnTratamiento(boolean estaEnTratamiento) {
        this.estaEnTratamiento = estaEnTratamiento;
    }

    // TODO: Agregar Getters adicionales para nombre, apellidos y especialidad
}
