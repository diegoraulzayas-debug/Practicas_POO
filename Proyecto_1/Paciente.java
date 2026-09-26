public class Paciente {

    String nombre;
    String apellidos;
    String especialidadAtencion;

    boolean estaEnConsulta;
    boolean estaEnTratamiento;

    public Paciente(String nombre, String apellidos, String especialidadAtencion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidadAtencion = especialidadAtencion;
        this.estaEnConsulta = false;
        this.estaEnTratamiento = false;
    }

    public void registroEnSistema(Sistema sistema) {
        sistema.registroPaciente(this);
        System.out.println(nombre + " " + apellidos + " registrado en el sistema.");
    }

    public void solicitarConsulta() {

        if (!estaEnConsulta && !estaEnTratamiento) {
            estaEnConsulta = true;

            System.out.println(nombre + " " + apellidos + " solicitó consulta de " + especialidadAtencion + ".");
        } else {
            System.out.println(nombre + " " + apellidos + " no puede solicitar consulta.");
        }
    }

    public void verTratamiento() {

        if (estaEnTratamiento) {
            System.out.println(nombre + " " + apellidos + " se encuentra en tratamiento de " + especialidadAtencion + ".");
        } else {
            System.out.println(nombre + " " + apellidos + " no se encuentra en tratamiento.");
        }
    }

    public void pasarATratamiento() {
        estaEnConsulta = false;
        estaEnTratamiento = true;
    }
}
