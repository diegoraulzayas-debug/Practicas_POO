package mx.unam.fi.die.poo.g7.practicas.practica10;

/**
 * Clase principal de ejecución para demostrar el manejo de excepciones
 * durante la construcción de objetos de tipo {@link Empleado}.
 * Ejecuta casos de prueba para errores de límite, tipos incompatibles,
 * formato numérico inválido e instanciación exitosa.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Main {

    /**
     * Constructor por defecto de la clase Main.
     */
    public Main() {
    }

    /**
     * Método principal que ejecuta los distintos escenarios de prueba
     * invocando al constructor de {@link Empleado} con datos válidos e inválidos.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // PRUEBA 1: Error de límites (horas fuera de rango)
        System.out.println(" PRUEBA 1: Horas fuera de límite ");
        probarConstructor("Carlos Ruiz", "MEDICO", "12345", 120);

        // PRUEBA 2: Error de tipo de uso (rol no soportado en esta clase)
        System.out.println("\nPRUEBA 2: Uso incompatible con el sistema ");
        probarConstructor("Ana Gómez", "CONTADOR", "67890", 40);

        // PRUEBA 3: Error de formato/tipo (se esperaba número y mandaron texto)
        System.out.println("\nPRUEBA 3: Se esperaba número y mandaron texto en ID ");
        probarConstructor("Luis Torres", "ENFERMERO", "NSS-ABC-99", 40);

        // PRUEBA 4: Creación válida
        System.out.println("\n PRUEBA 4: Datos correctos ");
        probarConstructor("Dra. Elena Ramos", "MEDICO", "849201", 60);
    }

    /**
     * Método auxiliar encargado de intentar instanciar un objeto {@link Empleado}
     * dentro de un bloque {@code try-catch-finally}, capturando las excepciones
     * específicas y verificando el estado final de la referencia en memoria.
     *
     * @param nombre Nombre completo del empleado a registrar.
     * @param rol Rol asignado al empleado dentro del sistema.
     * @param id Cadena con el identificador del empleado (se espera numérico).
     * @param horas Cantidad de horas mensuales asignadas al empleado.
     */
    public static void probarConstructor(String nombre, String rol, String id, int horas) {
        // Referencia al objeto Empleado inicializada en null antes de la construcción
        Empleado emp = null;
        try {
            emp = new Empleado(nombre, rol, id, horas);
            System.out.println(" Éxito: " + emp);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(" [IndexOutOfBoundsException atrapada en constructor]: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(" [IllegalArgumentException atrapada en constructor]: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("-> [Error General]: " + e.getMessage());
        } finally {
            // Demuestra que ante cualquier excepción, la referencia nunca se completa
            System.out.println("[Finally] Referencia 'emp' en memoria: " + emp);
        }
    }
}
