package hospital.sistema;

import java.util.Scanner;
import interfaces.AtencionMedica;
import hospital.personal.Medico;
import hospital.personal.MedicoGeneral;
import hospital.personal.MedicoEspecialista;
import hospital.personal.Enfermero;
import hospital.personal.EnfermeroEspecialista;
import hospital.personal.JefeEnfermeria;
import hospital.pacientes.Paciente;
import hospital.pacientes.PacienteGeneral;
import hospital.pacientes.PacienteEspecialidad;

/**
 * Clase principal interactiva del sistema hospitalario.
 * Estilo estándar: lectura directa con scanner.nextInt() y scanner.nextLine()
 * sin bloques try-catch ni manejo de excepciones no visto en clase.
 */
public class Main {

    public static void main(String[] args) {
        Sistema hospital = new Sistema("Hospital General de Especialidades Médicas");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        cargarDatosDePrueba(hospital);

        int opcion = 0;
        do {
            System.out.println("\n=======================================================");
            System.out.println("     SISTEMA DE GESTIÓN HOSPITALARIA (ETAPA 2)         ");
            System.out.println("     Hospital: " + hospital.getNombreHospital());
            System.out.println("=======================================================");
            System.out.println("1. Menú Médicos (General y Especialista)");
            System.out.println("2. Menú Enfermeros (Especialista y Jefatura)");
            System.out.println("3. Menú Pacientes (General y Especialidad)");
            System.out.println("4. Demostración de Polimorfismo e Interfaces");
            System.out.println("5. Ver Estadísticas Globales del Hospital");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

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
                    demostrarPolimorfismo(hospital);
                    break;
                case 5:
                    hospital.mostrarEstadisticas();
                    break;
                case 6:
                    System.out.println("Saliendo del simulador de sistema hospitalario... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    public static void menuMedico(Sistema hospital, Scanner scanner) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ DE MÉDICOS ---");
            System.out.println("1. Registrar Médico General");
            System.out.println("2. Registrar Médico Especialista");
            System.out.println("3. Solicitar paciente al sistema (Polimórfico)");
            System.out.println("4. Dar consulta médica");
            System.out.println("5. Dar tratamiento / Receta");
            System.out.println("6. Emitir dictamen quirúrgico / especialista");
            System.out.println("7. Ver lista de pacientes (Merge Sort descendente Z-A)");
            System.out.println("8. Regresar al menú principal");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    System.out.print("Nombre del Médico General: ");
                    String nombre = scanner.nextLine().toUpperCase();
                    System.out.print("Cédula Profesional: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Consultorio asignado: ");
                    String consultorio = scanner.nextLine();
                    MedicoGeneral mg = new MedicoGeneral(nombre, cedula, consultorio);
                    mg.registroEnSistema(hospital);
                    break;
                }
                case 2: {
                    System.out.print("Nombre del Médico Especialista: ");
                    String nombre = scanner.nextLine().toUpperCase();
                    System.out.print("Cédula Profesional: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Especialidad (ej. CARDIOLOGIA, PEDIATRIA): ");
                    String esp = scanner.nextLine().toUpperCase();
                    System.out.print("Años de experiencia: ");
                    int exp = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Subespecialidad o área clínica: ");
                    String sub = scanner.nextLine();
                    MedicoEspecialista me = new MedicoEspecialista(nombre, cedula, esp, exp, sub);
                    me.registroEnSistema(hospital);
                    break;
                }
                case 3: {
                    Medico med = seleccionarMedico(hospital, scanner);
                    if (med != null) {
                        med.solicitarPaciente(hospital);
                    }
                    break;
                }
                case 4: {
                    Medico med = seleccionarMedico(hospital, scanner);
                    if (med != null) {
                        if (med.getNoPacientes() == 0) {
                            System.out.println("El médico no tiene pacientes asignados.");
                        } else {
                            System.out.println("Seleccione paciente a atender en consulta:");
                            for (int i = 0; i < med.getNoPacientes(); i++) {
                                System.out.println((i + 1) + ". " + med.getPacientesAsignados()[i].getNombre());
                            }
                            int pIdx = scanner.nextInt() - 1;
                            scanner.nextLine();
                            if (pIdx >= 0 && pIdx < med.getNoPacientes()) {
                                med.darConsulta(med.getPacientesAsignados()[pIdx]);
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    Medico med = seleccionarMedico(hospital, scanner);
                    if (med != null) {
                        if (med.getNoPacientes() == 0) {
                            System.out.println("El médico no tiene pacientes asignados.");
                        } else {
                            System.out.println("Seleccione paciente a recetar tratamiento:");
                            for (int i = 0; i < med.getNoPacientes(); i++) {
                                System.out.println((i + 1) + ". " + med.getPacientesAsignados()[i].getNombre());
                            }
                            int pIdx = scanner.nextInt() - 1;
                            scanner.nextLine();
                            if (pIdx >= 0 && pIdx < med.getNoPacientes()) {
                                System.out.print("Ingrese indicación o medicamento recetado: ");
                                String indicacion = scanner.nextLine();
                                med.darTratamiento(med.getPacientesAsignados()[pIdx], indicacion);
                            }
                        }
                    }
                    break;
                }
                case 6: {
                    Medico med = seleccionarMedico(hospital, scanner);
                    if (med instanceof MedicoEspecialista) {
                        MedicoEspecialista me = (MedicoEspecialista) med;
                        if (me.getNoPacientes() == 0) {
                            System.out.println("No tiene pacientes para emitir dictamen.");
                        } else {
                            System.out.println("Seleccione paciente:");
                            for (int i = 0; i < me.getNoPacientes(); i++) {
                                System.out.println((i + 1) + ". " + me.getPacientesAsignados()[i].getNombre());
                            }
                            int pIdx = scanner.nextInt() - 1;
                            scanner.nextLine();
                            if (pIdx >= 0 && pIdx < me.getNoPacientes()) {
                                System.out.print("Procedimiento o dictamen de alta especialidad: ");
                                String proc = scanner.nextLine();
                                me.emitirDictamenEspecializado(me.getPacientesAsignados()[pIdx], proc);
                            }
                        }
                    } else if (med != null) {
                        System.out.println("Solo los médicos especialistas pueden emitir dictámenes especializados.");
                    }
                    break;
                }
                case 7: {
                    Medico med = seleccionarMedico(hospital, scanner);
                    if (med != null) {
                        med.verListaPacientes();
                    }
                    break;
                }
            }
        } while (opcion != 8);
    }

    public static void menuEnfermero(Sistema hospital, Scanner scanner) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ DE ENFERMEROS ---");
            System.out.println("1. Registrar Enfermero Especialista");
            System.out.println("2. Registrar Jefe de Enfermería");
            System.out.println("3. Asignar paciente a Enfermero");
            System.out.println("4. Administrar tratamiento / cuidados");
            System.out.println("5. Ejecutar supervisión de guardia (Exclusivo Jefe de Enfermería)");
            System.out.println("6. Dictaminar / Canalizar Acta Administrativa (Exclusivo Jefe de Enfermería)");
            System.out.println("7. Ver lista de pacientes a su cuidado (Merge Sort descendente Z-A)");
            System.out.println("8. Regresar al menú principal");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    System.out.print("Nombre del Enfermero/a: ");
                    String nombre = scanner.nextLine().toUpperCase();
                    System.out.print("Cédula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Especialidad (ej. PEDIATRIA, UCI, CARDIOLOGIA): ");
                    String esp = scanner.nextLine().toUpperCase();
                    System.out.print("Certificación avanzada: ");
                    String cert = scanner.nextLine();
                    EnfermeroEspecialista ee = new EnfermeroEspecialista(nombre, cedula, esp, cert);
                    ee.registroEnSistema(hospital);
                    break;
                }
                case 2: {
                    System.out.print("Nombre del Jefe/a de Enfermería: ");
                    String nombre = scanner.nextLine().toUpperCase();
                    System.out.print("Cédula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Turno de supervisión (MATUTINO/VESPERTINO/NOCTURNO): ");
                    String turno = scanner.nextLine();
                    System.out.print("Piso asignado (entero): ");
                    int piso = scanner.nextInt();
                    scanner.nextLine();
                    JefeEnfermeria je = new JefeEnfermeria(nombre, cedula, turno, piso);
                    je.registroEnSistema(hospital);
                    break;
                }
                case 3: {
                    Enfermero enf = seleccionarEnfermero(hospital, scanner);
                    Paciente pac = seleccionarPaciente(hospital, scanner);
                    if (enf != null && pac != null) {
                        hospital.asignarPaciente(pac, enf);
                    }
                    break;
                }
                case 4: {
                    Enfermero enf = seleccionarEnfermero(hospital, scanner);
                    if (enf != null) {
                        if (enf.getNoPacientes() == 0) {
                            System.out.println("El enfermero no tiene pacientes a su cuidado.");
                        } else {
                            System.out.println("Seleccione paciente:");
                            for (int i = 0; i < enf.getNoPacientes(); i++) {
                                System.out.println((i + 1) + ". " + enf.getPacientesAsignados()[i].getNombre());
                            }
                            int pIdx = scanner.nextInt() - 1;
                            scanner.nextLine();
                            if (pIdx >= 0 && pIdx < enf.getNoPacientes()) {
                                enf.darTratamiento(enf.getPacientesAsignados()[pIdx]);
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    Enfermero enf = seleccionarEnfermero(hospital, scanner);
                    if (enf instanceof JefeEnfermeria) {
                        JefeEnfermeria jefe = (JefeEnfermeria) enf;
                        jefe.supervisarGuardia(hospital.getEnfermeros(), hospital.getNoEnfermeros());
                    } else if (enf != null) {
                        System.out.println("Esta función de supervisión y coordinación solo corresponde al Jefe de Enfermería.");
                    }
                    break;
                }
                case 6: {
                    Enfermero enf = seleccionarEnfermero(hospital, scanner);
                    if (enf instanceof JefeEnfermeria) {
                        JefeEnfermeria jefe = (JefeEnfermeria) enf;
                        if (hospital.getNoActas() == 0) {
                            System.out.println("No hay actas registradas para procesar.");
                        } else {
                            System.out.println("Seleccione el acta a revisar y dictaminar:");
                            for (int i = 0; i < hospital.getNoActas(); i++) {
                                ActaAdministrativa a = hospital.getActasAdministrativas()[i];
                                System.out.println((i + 1) + ". Folio ACTA-" + a.getFolio() + " - " + a.getMotivo() 
                                        + " (Reportado: " + (a.getEnfermeroReportado() != null ? a.getEnfermeroReportado().getNombre() : "N/A") 
                                        + " | " + (a.isProcesada() ? "PROCESADA" : "PENDIENTE") + ")");
                            }
                            int actIdx = scanner.nextInt() - 1;
                            scanner.nextLine();
                            if (actIdx >= 0 && actIdx < hospital.getNoActas()) {
                                ActaAdministrativa actaSel = hospital.getActasAdministrativas()[actIdx];
                                actaSel.mostrarDetalleActa();
                                System.out.println("\n¿A dónde desea canalizar el acta?");
                                System.out.println("1. RECURSOS HUMANOS (Sanción / Expediente laboral)");
                                System.out.println("2. COMITÉ DE ÉTICA (Investigación por mala praxis)");
                                System.out.println("3. CONSEJO DIRECTIVO / ASUNTOS JURÍDICOS");
                                System.out.print("Seleccione opción: ");
                                int destinoOp = scanner.nextInt();
                                scanner.nextLine();
                                String destino = "RECURSOS HUMANOS";
                                if (destinoOp == 2) {
                                    destino = "COMITÉ DE ÉTICA";
                                } else if (destinoOp == 3) {
                                    destino = "CONSEJO DIRECTIVO Y JURÍDICO";
                                }

                                System.out.print("Ingrese resolución / dictamen oficial de la Jefatura: ");
                                String resolucion = scanner.nextLine();
                                jefe.gestionarActaAdministrativa(actaSel, destino, resolucion);
                            } else {
                                System.out.println("Índice de acta no válido.");
                            }
                        }
                    } else if (enf != null) {
                        System.out.println("Solo el Jefe de Enfermería tiene atribución disciplinaria para dictaminar actas.");
                    }
                    break;
                }
                case 7: {
                    Enfermero enf = seleccionarEnfermero(hospital, scanner);
                    if (enf != null) {
                        enf.verListaPacientes();
                    }
                    break;
                }
            }
        } while (opcion != 8);
    }

    public static void menuPaciente(Sistema hospital, Scanner scanner) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ DE PACIENTES ---");
            System.out.println("1. Registrar Paciente General");
            System.out.println("2. Registrar Paciente de Especialidad");
            System.out.println("3. Solicitar consulta médica al sistema");
            System.out.println("4. Ver estado y tratamiento actual");
            System.out.println("5. Levantar queja / acta administrativa contra enfermero");
            System.out.println("6. Ver historial de actas / quejas del hospital");
            System.out.println("7. Regresar al menú principal");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    System.out.print("Nombre del paciente: ");
                    String nombre = scanner.nextLine().toUpperCase();
                    System.out.print("Motivo de consulta: ");
                    String motivo = scanner.nextLine();
                    PacienteGeneral pg = new PacienteGeneral(nombre, motivo);
                    pg.registroEnSistema(hospital);
                    break;
                }
                case 2: {
                    System.out.print("Nombre del paciente: ");
                    String nombre = scanner.nextLine().toUpperCase();
                    System.out.print("Especialidad requerida (ej. CARDIOLOGIA, PEDIATRIA): ");
                    String esp = scanner.nextLine().toUpperCase();
                    System.out.print("Nivel de urgencia (1 a 5): ");
                    int urg = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Diagnóstico previo / síntomas: ");
                    String diag = scanner.nextLine();
                    PacienteEspecialidad pe = new PacienteEspecialidad(nombre, esp, urg, diag);
                    pe.registroEnSistema(hospital);
                    break;
                }
                case 3: {
                    Paciente pac = seleccionarPaciente(hospital, scanner);
                    if (pac != null) {
                        pac.solicitarConsulta(hospital);
                    }
                    break;
                }
                case 4: {
                    Paciente pac = seleccionarPaciente(hospital, scanner);
                    if (pac != null) {
                        pac.verTratamiento();
                    }
                    break;
                }
                case 5: {
                    System.out.println("\n=== LEVANTAMIENTO DE ACTA ADMINISTRATIVA / REPORTE CLÍNICO ===");
                    Paciente pac = seleccionarPaciente(hospital, scanner);
                    if (pac == null) break;

                    System.out.println("Seleccione al enfermero reportado:");
                    Enfermero enf = seleccionarEnfermero(hospital, scanner);
                    if (enf == null) break;

                    System.out.print("Fecha y hora del incidente (ej. 24/10/2026 10:30 hrs): ");
                    String fechaHora = scanner.nextLine();

                    System.out.print("Motivo del reporte (ej. MALA PRAXIS, NEGLIGENCIA, MALTRATO, TRATAMIENTO ERRÓNEO): ");
                    String motivo = scanner.nextLine();

                    System.out.print("Descripción detallada de los hechos: ");
                    String desc = scanner.nextLine();

                    ActaAdministrativa acta = new ActaAdministrativa(pac, enf, fechaHora, motivo, desc);
                    hospital.registrarActa(acta);
                    acta.mostrarDetalleActa();
                    System.out.println("El acta ha sido turnada a la Jefatura de Enfermería para su correspondiente resolución.");
                    break;
                }
                case 6: {
                    hospital.listarActas();
                    break;
                }
            }
        } while (opcion != 7);
    }

    public static void demostrarPolimorfismo(Sistema hospital) {
        System.out.println("\n=======================================================");
        System.out.println("      DEMOSTRACIÓN DE POLIMORFISMO (ESTÁTICO Y DINÁMICO)");
        System.out.println("=======================================================");

        // 1. Polimorfismo a través de la Interfaz AtencionMedica
        System.out.println("\n--- 1. POLIMORFISMO MEDIANTE LA INTERFAZ AtencionMedica ---");
        AtencionMedica[] profesionales = new AtencionMedica[3];
        profesionales[0] = new MedicoGeneral("DRA. GABRIELA RUIZ", "MED-0099", "Consultorio 102");
        profesionales[1] = new MedicoEspecialista("DR. HÉCTOR VEGA", "MED-0088", "CARDIOLOGIA", 15, "Hemodinamia");
        profesionales[2] = new EnfermeroEspecialista("LIC. CARMEN SOSA", "ENF-0077", "CARDIOLOGIA", "ACLS");

        Paciente pacDemo = new PacienteEspecialidad("VALENTINA LOPEZ", "CARDIOLOGIA", 4, "Dolor torácico");

        for (AtencionMedica profesional : profesionales) {
            System.out.println("Ejecutando darConsulta() en objeto de tipo real: " + profesional.getClass().getSimpleName());
            profesional.darConsulta(pacDemo);
        }

        // 2. Polimorfismo en Jerarquía de Pacientes
        System.out.println("\n--- 2. POLIMORFISMO EN JERARQUÍA DE PACIENTES ---");
        Paciente[] pacientesDemo = new Paciente[2];
        pacientesDemo[0] = new PacienteGeneral("ALBERTO DIAZ", "Chequeo anual preventivo");
        pacientesDemo[1] = new PacienteEspecialidad("BEATRIZ MORA", "PEDIATRIA", 3, "Fiebre persistente");

        for (Paciente p : pacientesDemo) {
            System.out.println("\nInvocando solicitarConsulta() polimórfico en: " + p.getClass().getSimpleName());
            p.solicitarConsulta(hospital);
        }

        // 3. Polimorfismo Estático (Sobrecarga de Métodos)
        System.out.println("\n--- 3. POLIMORFISMO ESTÁTICO (SOBRECARGA DE MÉTODOS) ---");
        Medico med = hospital.getMedicos()[0];
        System.out.println("Llamando a darTratamiento(paciente) [1 argumento]:");
        med.darTratamiento(pacDemo);
        System.out.println("Llamando a darTratamiento(paciente, indicacion) [2 argumentos]:");
        med.darTratamiento(pacDemo, "Enalapril 10mg cada 12 horas por 30 días.");

        System.out.println("\nDemostración finalizada exitosamente.");
    }

    private static Medico seleccionarMedico(Sistema hospital, Scanner scanner) {
        if (hospital.getNoMedicos() == 0) {
            System.out.println("No hay médicos registrados en el sistema.");
            return null;
        }
        System.out.println("\nSeleccione Médico:");
        for (int i = 0; i < hospital.getNoMedicos(); i++) {
            Medico m = hospital.getMedicos()[i];
            System.out.println((i + 1) + ". " + m.getNombre() + " (" + m.getTipoMedico() + ") [" + m.getNoPacientes() + "/10]");
        }
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx >= 0 && idx < hospital.getNoMedicos()) {
            return hospital.getMedicos()[idx];
        }
        System.out.println("Selección inválida.");
        return null;
    }

    private static Enfermero seleccionarEnfermero(Sistema hospital, Scanner scanner) {
        if (hospital.getNoEnfermeros() == 0) {
            System.out.println("No hay enfermeros registrados en el sistema.");
            return null;
        }
        System.out.println("\nSeleccione Enfermero:");
        for (int i = 0; i < hospital.getNoEnfermeros(); i++) {
            Enfermero e = hospital.getEnfermeros()[i];
            System.out.println((i + 1) + ". " + e.getNombre() + " (" + e.getCargo() + ") [" + e.getNoPacientes() + "/3]");
        }
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx >= 0 && idx < hospital.getNoEnfermeros()) {
            return hospital.getEnfermeros()[idx];
        }
        System.out.println("Selección inválida.");
        return null;
    }

    private static Paciente seleccionarPaciente(Sistema hospital, Scanner scanner) {
        if (hospital.getNoPacientes() == 0) {
            System.out.println("No hay pacientes registrados en el sistema.");
            return null;
        }
        System.out.println("\nSeleccione Paciente:");
        for (int i = 0; i < hospital.getNoPacientes(); i++) {
            Paciente p = hospital.getPacientes()[i];
            System.out.println((i + 1) + ". " + p.getNombre() + " [" + p.obtenerTipoCondicion() + "]");
        }
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx >= 0 && idx < hospital.getNoPacientes()) {
            return hospital.getPacientes()[idx];
        }
        System.out.println("Selección inválida.");
        return null;
    }

    private static void cargarDatosDePrueba(Sistema hospital) {
        MedicoGeneral mg1 = new MedicoGeneral("DR. ROBERTO SALAS", "10101", "Consultorio 3A");
        MedicoEspecialista me1 = new MedicoEspecialista("DRA. CLARA MENDEZ", "20202", "CARDIOLOGIA", 12, "Ecocardiografía");
        MedicoEspecialista me2 = new MedicoEspecialista("DR. MIGUEL TORRES", "30303", "PEDIATRIA", 8, "Neonatología");

        hospital.registrarMedico(mg1);
        hospital.registrarMedico(me1);
        hospital.registrarMedico(me2);

        EnfermeroEspecialista ee1 = new EnfermeroEspecialista("LIC. ANA LAURA", "40404", "CARDIOLOGIA", "Reanimación Cardiopulmonar Avanzada");
        EnfermeroEspecialista ee2 = new EnfermeroEspecialista("LIC. PEDRO CASTILLO", "50505", "PEDIATRIA", "Cuidados Pediátricos Críticos");
        JefeEnfermeria je1 = new JefeEnfermeria("JEFA SOFIA LOZANO", "60606", "MATUTINO", 2);

        hospital.registrarEnfermero(ee1);
        hospital.registrarEnfermero(ee2);
        hospital.registrarEnfermero(je1);

        PacienteGeneral pg1 = new PacienteGeneral("JUAN PEREZ", "Gripe común e hipertensión controlada");
        PacienteEspecialidad pe1 = new PacienteEspecialidad("MARIA GARCIA", "CARDIOLOGIA", 4, "Arritmia sinusal severa");
        PacienteEspecialidad pe2 = new PacienteEspecialidad("LUCIA RAMOS", "PEDIATRIA", 2, "Revisión mensual de crecimiento");

        hospital.registrarPaciente(pg1);
        hospital.registrarPaciente(pe1);
        hospital.registrarPaciente(pe2);
    }
}
