package mx.unam.fi.die.poo.g7.practicas.proyecto1;

import java.util.Scanner;

/**
 * Clase principal que gestiona la ejecucion del Sistema de Gestion Hospitalaria (Proyecto 1).
 * Presenta la interfaz de consola interactiva con menus dedicados para medicos,
 * enfermeros y pacientes.
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
     * Punto de entrada principal de la aplicacion hospitalaria.
     * Despliega el menu principal y coordina la navegacion entre los modulos.
     *
     * @param args Argumentos de la linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Sistema hospital = new Sistema("Hospital Central Universitario");
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n==========================================");
            System.out.println("     SISTEMA DE GESTION HOSPITALARIA      ");
            System.out.println("     Hospital: " + hospital.nombreHospital);
            System.out.println("==========================================");
            System.out.println("1. Medico");
            System.out.println("2. Enfermero");
            System.out.println("3. Paciente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuMedico(hospital, scanner);
                    break;
                case 2:
                    menuEnfermero(hospital, scanner);
                    break;
                case 3:
                    menuPaciente(hospital, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    // Menu interactivo de Medico
    /**
     * Gestiona el menu interactivo de opciones y operaciones de los medicos,
     * tales como registro, solicitud de pacientes, consultas, recetas y listado ordenado.
     *
     * @param hospital Instancia del sistema hospitalario activo.
     * @param scanner Lector para recepcion de datos del usuario por consola.
     */
    public static void menuMedico(Sistema hospital, Scanner scanner) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENU DE MEDICO ---");
            System.out.println("1. Registrar medico");
            System.out.println("2. Solicitar paciente al sistema");
            System.out.println("3. Dar consulta");
            System.out.println("4. Dar tratamiento (recetar)");
            System.out.println("5. Ver lista de pacientes");
            System.out.println("6. Regresar");
            System.out.print("Opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del medico: ");
                    String nom = scanner.nextLine().toUpperCase();
                    System.out.print("Cedula: ");
                    String ced = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String esp = scanner.nextLine().toUpperCase();
                    Medico nuevoMed = new Medico(nom, ced, esp);
                    nuevoMed.registroEnSistema(hospital);
                    break;

                case 2:
                    if (hospital.noMedicos == 0) {
                        System.out.println("No hay medicos registrados.");
                    } else {
                        System.out.println("\nSeleccione Medico:");
                        for (int i = 0; i < hospital.noMedicos; i++) {
                            System.out.println((i + 1) + ". " + hospital.medicos[i].nombre + " (" + hospital.medicos[i].especialidad + ") [" + hospital.medicos[i].noPacientes + "/10]");
                        }
                        int mIdx = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (mIdx >= 0 && mIdx < hospital.noMedicos) {
                            hospital.medicos[mIdx].solicitarPaciente(hospital);
                        }
                    }
                    break;

                case 3:
                    if (hospital.noMedicos == 0) {
                        System.out.println("No hay medicos registrados.");
                    } else {
                        System.out.println("\nSeleccione Medico:");
                        for (int i = 0; i < hospital.noMedicos; i++) {
                            System.out.println((i + 1) + ". " + hospital.medicos[i].nombre + " [" + hospital.medicos[i].noPacientes + "/10]");
                        }
                        int mIdx = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (mIdx >= 0 && mIdx < hospital.noMedicos) {
                            Medico med = hospital.medicos[mIdx];
                            if (med.noPacientes == 0) {
                                System.out.println("El medico no tiene pacientes asignados.");
                            } else {
                                System.out.println("Seleccione Paciente:");
                                for (int i = 0; i < med.noPacientes; i++) {
                                    System.out.println((i + 1) + ". " + med.pacientesAsignados[i].nombre);
                                }
                                int pIdx = scanner.nextInt() - 1;
                                scanner.nextLine();
                                if (pIdx >= 0 && pIdx < med.noPacientes) {
                                    med.darConsulta(med.pacientesAsignados[pIdx]);
                                }
                            }
                        }
                    }
                    break;

                case 4:
                    if (hospital.noMedicos == 0) {
                        System.out.println("No hay medicos registrados.");
                    } else {
                        System.out.println("\nSeleccione Medico:");
                        for (int i = 0; i < hospital.noMedicos; i++) {
                            System.out.println((i + 1) + ". " + hospital.medicos[i].nombre + " [" + hospital.medicos[i].noPacientes + "/10]");
                        }
                        int mIdx = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (mIdx >= 0 && mIdx < hospital.noMedicos) {
                            Medico med = hospital.medicos[mIdx];
                            if (med.noPacientes == 0) {
                                System.out.println("El medico no tiene pacientes asignados.");
                            } else {
                                System.out.println("Seleccione Paciente:");
                                for (int i = 0; i < med.noPacientes; i++) {
                                    System.out.println((i + 1) + ". " + med.pacientesAsignados[i].nombre);
                                }
                                int pIdx = scanner.nextInt() - 1;
                                scanner.nextLine();
                                if (pIdx >= 0 && pIdx < med.noPacientes) {
                                    System.out.print("Ingrese indicacion / receta medica: ");
                                    String ind = scanner.nextLine();
                                    med.darTratamiento(med.pacientesAsignados[pIdx], ind);
                                }
                            }
                        }
                    }
                    break;

                case 5:
                    if (hospital.noMedicos == 0) {
                        System.out.println("No hay medicos registrados.");
                    } else {
                        System.out.println("\nSeleccione Medico:");
                        for (int i = 0; i < hospital.noMedicos; i++) {
                            System.out.println((i + 1) + ". " + hospital.medicos[i].nombre + " [" + hospital.medicos[i].noPacientes + "/10]");
                        }
                        int mIdx = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (mIdx >= 0 && mIdx < hospital.noMedicos) {
                            hospital.medicos[mIdx].verListaPacientes();
                        }
                    }
                    break;

                case 6:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);
    }

    // Menu interactivo de Enfermero
    /**
     * Gestiona el menu interactivo de operaciones para el personal de enfermeria,
     * permitiendo el registro, la administracion de medicamentos y la revision de pacientes ordenados.
     *
     * @param hospital Instancia del sistema hospitalario activo.
     * @param scanner Lector para recepcion de datos del usuario por consola.
     */
    public static void menuEnfermero(Sistema hospital, Scanner scanner) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENU DE ENFERMERO ---");
            System.out.println("1. Registrar enfermero");
            System.out.println("2. Dar tratamiento (administrar medicamento)");
            System.out.println("3. Ver lista de pacientes");
            System.out.println("4. Regresar");
            System.out.print("Opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del enfermero: ");
                    String nom = scanner.nextLine().toUpperCase();
                    System.out.print("Cedula: ");
                    String ced = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String esp = scanner.nextLine().toUpperCase();
                    Enfermero nuevoEnf = new Enfermero(nom, ced, esp);
                    nuevoEnf.registroEnSistema(hospital);
                    break;

                case 2:
                    if (hospital.noEnfermeros == 0) {
                        System.out.println("No hay enfermeros registrados.");
                    } else {
                        System.out.println("\nSeleccione Enfermero:");
                        for (int i = 0; i < hospital.noEnfermeros; i++) {
                            System.out.println((i + 1) + ". " + hospital.enfermeros[i].nombre + " [" + hospital.enfermeros[i].noPacientes + "/3]");
                        }
                        int eIdx = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (eIdx >= 0 && eIdx < hospital.noEnfermeros) {
                            Enfermero enf = hospital.enfermeros[eIdx];
                            if (enf.noPacientes == 0) {
                                System.out.println("El enfermero no tiene pacientes asignados.");
                            } else {
                                System.out.println("Seleccione Paciente:");
                                for (int i = 0; i < enf.noPacientes; i++) {
                                    System.out.println((i + 1) + ". " + enf.pacientesAsignados[i].nombre);
                                }
                                int pIdx = scanner.nextInt() - 1;
                                scanner.nextLine();
                                if (pIdx >= 0 && pIdx < enf.noPacientes) {
                                    // Administra el tratamiento que le receto el medico
                                    enf.darTratamiento(enf.pacientesAsignados[pIdx]);
                                }
                            }
                        }
                    }
                    break;

                case 3:
                    if (hospital.noEnfermeros == 0) {
                        System.out.println("No hay enfermeros registrados.");
                    } else {
                        System.out.println("\nSeleccione Enfermero:");
                        for (int i = 0; i < hospital.noEnfermeros; i++) {
                            System.out.println((i + 1) + ". " + hospital.enfermeros[i].nombre + " [" + hospital.enfermeros[i].noPacientes + "/3]");
                        }
                        int eIdx = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (eIdx >= 0 && eIdx < hospital.noEnfermeros) {
                            hospital.enfermeros[eIdx].verListaPacientes();
                        }
                    }
                    break;

                case 4:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);
    }

    // Menu interactivo de Paciente
    /**
     * Gestiona el menu interactivo de opciones para pacientes, permitiendo su registro,
     * asignacion a personal medico o de enfermeria, solicitud automatica de consulta
     * y revision del estado de tratamiento.
     *
     * @param hospital Instancia del sistema hospitalario activo.
     * @param scanner Lector para recepcion de datos del usuario por consola.
     */
    public static void menuPaciente(Sistema hospital, Scanner scanner) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENU DE PACIENTE ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Asignar paciente a Medico");
            System.out.println("3. Asignar paciente a Enfermero");
            System.out.println("4. Solicitar consulta medica (automatica)");
            System.out.println("5. Ver estado y tratamiento");
            System.out.println("6. Regresar");
            System.out.print("Opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("(Nota: Ingrese el nombre empezando por apellidos. Ej: Zayas Gonzalez Diego Raul)");
                    System.out.print("Nombre del paciente: ");
                    String nom = scanner.nextLine().toUpperCase();
                    System.out.print("Especialidad requerida: ");
                    String esp = scanner.nextLine().toUpperCase();
                    Paciente nuevoPac = new Paciente(nom, esp);
                    nuevoPac.registroEnSistema(hospital);
                    break;

                case 2:
                    if (hospital.noPacientes == 0 || hospital.noMedicos == 0) {
                        System.out.println("Debe haber al menos un paciente y un medico.");
                    } else {
                        System.out.println("\nSeleccione Paciente:");
                        for (int i = 0; i < hospital.noPacientes; i++) {
                            System.out.println((i + 1) + ". " + hospital.pacientes[i].nombre + " (" + hospital.pacientes[i].especialidad + ")");
                        }
                        int pIdx = scanner.nextInt() - 1;
                        scanner.nextLine();

                        System.out.println("\nSeleccione Medico:");
                        for (int i = 0; i < hospital.noMedicos; i++) {
                            System.out.println((i + 1) + ". " + hospital.medicos[i].nombre + " (" + hospital.medicos[i].especialidad + ") [" + hospital.medicos[i].noPacientes + "/10]");
                        }
                        int mIdx = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (pIdx >= 0 && pIdx < hospital.noPacientes && mIdx >= 0 && mIdx < hospital.noMedicos) {
                            hospital.asignarPaciente(hospital.pacientes[pIdx], hospital.medicos[mIdx]);
                        }
                    }
                    break;

                case 3:
                    if (hospital.noPacientes == 0 || hospital.noEnfermeros == 0) {
                        System.out.println("Debe haber al menos un paciente y un enfermero.");
                    } else {
                        System.out.println("\nSeleccione Paciente:");
                        for (int i = 0; i < hospital.noPacientes; i++) {
                            System.out.println((i + 1) + ". " + hospital.pacientes[i].nombre + " (" + hospital.pacientes[i].especialidad + ")");
                        }
                        int pIdx = scanner.nextInt() - 1;
                        scanner.nextLine();

                        System.out.println("\nSeleccione Enfermero:");
                        for (int i = 0; i < hospital.noEnfermeros; i++) {
                            System.out.println((i + 1) + ". " + hospital.enfermeros[i].nombre + " (" + hospital.enfermeros[i].especialidad + ") [" + hospital.enfermeros[i].noPacientes + "/3]");
                        }
                        int eIdx = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (pIdx >= 0 && pIdx < hospital.noPacientes && eIdx >= 0 && eIdx < hospital.noEnfermeros) {
                            hospital.asignarPaciente(hospital.pacientes[pIdx], hospital.enfermeros[eIdx]);
                        }
                    }
                    break;

                case 4:
                    if (hospital.noPacientes == 0) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        System.out.println("\nSeleccione Paciente:");
                        for (int i = 0; i < hospital.noPacientes; i++) {
                            System.out.println((i + 1) + ". " + hospital.pacientes[i].nombre);
                        }
                        int pIdx = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (pIdx >= 0 && pIdx < hospital.noPacientes) {
                            hospital.pacientes[pIdx].solicitarConsulta(hospital);
                        }
                    }
                    break;

                case 5:
                    if (hospital.noPacientes == 0) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        System.out.println("\nSeleccione Paciente:");
                        for (int i = 0; i < hospital.noPacientes; i++) {
                            System.out.println((i + 1) + ". " + hospital.pacientes[i].nombre);
                        }
                        int pIdx = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (pIdx >= 0 && pIdx < hospital.noPacientes) {
                            hospital.pacientes[pIdx].verTratamiento();
                        }
                    }
                    break;

                case 6:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);
    }
}
