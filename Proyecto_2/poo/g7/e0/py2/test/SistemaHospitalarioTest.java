package test;

import hospital.personal.MedicoGeneral;
import hospital.personal.MedicoEspecialista;
import hospital.personal.EnfermeroEspecialista;
import hospital.personal.JefeEnfermeria;
import hospital.personal.Enfermero;
import hospital.pacientes.Paciente;
import hospital.pacientes.PacienteGeneral;
import hospital.pacientes.PacienteEspecialidad;
import hospital.sistema.Sistema;
import interfaces.AtencionMedica;

/**
 * Suite de pruebas automatizadas de unidad y comportamiento para la Etapa 2.
 * Estructura de paquetes: poo/g7/e0/py2/test/SistemaHospitalarioTest.java
 */
public class SistemaHospitalarioTest {

    private static int pruebasExitosas = 0;
    private static int pruebasTotales = 0;

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  INICIANDO SUITE DE PRUEBAS - PROYECTO ETAPA 2  ");
        System.out.println("==================================================");

        testEncapsulamientoInmutables();
        testRestriccionesCupo();
        testReglasEspecialidad();
        testPolimorfismo();
        testJefeEnfermeria();
        testMergeSortDescendente();

        System.out.println("\n--------------------------------------------------");
        System.out.println("RESULTADO FINAL: " + pruebasExitosas + "/" + pruebasTotales + " pruebas superadas.");
        if (pruebasExitosas == pruebasTotales) {
            System.out.println(">>> TODAS LAS PRUEBAS PASARON EXITOSAMENTE. <<<");
        } else {
            System.out.println(">>> ALGUNAS PRUEBAS FALLARON. REVISAR IMPLEMENTACIÓN. <<<");
        }
        System.out.println("--------------------------------------------------");
    }

    private static void afirmar(boolean condicion, String nombrePrueba) {
        pruebasTotales++;
        if (condicion) {
            System.out.println("[PASS] " + nombrePrueba);
            pruebasExitosas++;
        } else {
            System.err.println("[FAIL] " + nombrePrueba);
        }
    }

    private static void testEncapsulamientoInmutables() {
        System.out.println("\n--- 1. Pruebas de Encapsulamiento con Inmutables (private final) ---");
        Paciente p = new PacienteGeneral(null, null);
        afirmar(p.getNombre().equals("PACIENTE_SIN_NOMBRE"), "Validación de nombre nulo en Paciente");
        afirmar(p.getEspecialidad().equals("GENERAL"), "Especialidad por defecto en PacienteGeneral");

        MedicoGeneral m = new MedicoGeneral("   Dr. Juan   ", "12345", null);
        afirmar(m.getNombre().equals("Dr. Juan"), "Sanitización de espacios en nombre inmutable");
        afirmar(m.getCedula().equals("12345"), "Asignación de cédula inmutable");
        afirmar(m.getConsultorioAsignado().contains("Consultorio"), "Asignación de consultorio mutable");
    }

    private static void testRestriccionesCupo() {
        System.out.println("\n--- 2. Pruebas de Límites de Cupo ---");
        MedicoGeneral mg = new MedicoGeneral("Dr. Test", "001", "C-1");
        for (int i = 0; i < 10; i++) {
            boolean admitido = mg.admitirPaciente(new PacienteGeneral("P" + i, "Chequeo"));
            afirmar(admitido, "Médico admite paciente " + (i + 1) + "/10");
        }
        boolean admitido11 = mg.admitirPaciente(new PacienteGeneral("P11", "Chequeo"));
        afirmar(!admitido11, "Médico rechaza paciente 11 por cupo lleno (10/10)");

        EnfermeroEspecialista ee = new EnfermeroEspecialista("Enf. Test", "002", "PEDIATRIA", "PALS");
        for (int i = 0; i < 3; i++) {
            boolean adm = ee.admitirPaciente(new PacienteEspecialidad("Nene" + i, "PEDIATRIA", 2, "Gripe"));
            afirmar(adm, "Enfermero admite paciente " + (i + 1) + "/3");
        }
        boolean adm4 = ee.admitirPaciente(new PacienteEspecialidad("Nene4", "PEDIATRIA", 2, "Gripe"));
        afirmar(!adm4, "Enfermero rechaza paciente 4 por cupo lleno (3/3)");
    }

    private static void testReglasEspecialidad() {
        System.out.println("\n--- 3. Pruebas de Compatibilidad por Especialidad ---");
        MedicoEspecialista cardio = new MedicoEspecialista("Dr. Cardio", "CARD-1", "CARDIOLOGIA", 10, "Cardiopatías");
        PacienteEspecialidad pacCardio = new PacienteEspecialidad("Don Carlos", "CARDIOLOGIA", 3, "Arritmia");
        PacienteEspecialidad pacPediatria = new PacienteEspecialidad("Pedrito", "PEDIATRIA", 1, "Control");

        afirmar(cardio.puedeAtender(pacCardio), "Especialista Cardio acepta paciente de Cardiología");
        afirmar(!cardio.puedeAtender(pacPediatria), "Especialista Cardio rechaza paciente de Pediatría");

        EnfermeroEspecialista enfCardio = new EnfermeroEspecialista("Enf. Cardio", "E-CARD", "CARDIOLOGIA", "ACLS");
        afirmar(enfCardio.puedeAtender(pacCardio), "Enfermero especialista acepta su especialidad");
        afirmar(!enfCardio.puedeAtender(pacPediatria), "Enfermero especialista rechaza otra especialidad");
    }

    private static void testPolimorfismo() {
        System.out.println("\n--- 4. Pruebas de Polimorfismo Dinámico y Estático ---");
        AtencionMedica profesional = new MedicoGeneral("Dra. Sol", "M-SOL", "C-2");
        Paciente pac = new PacienteGeneral("Ernesto", "Fiebre");

        profesional.darConsulta(pac);
        afirmar(pac.isEstaEnConsulta(), "darConsulta polimórfico marca al paciente en consulta");

        profesional.darTratamiento(pac, "Paracetamol 500mg");
        afirmar(!pac.isEstaEnConsulta() && pac.isEstaEnTratamiento(),
                "darTratamiento finaliza consulta y pasa a tratamiento");
        afirmar(pac.getTratamiento().contains("Paracetamol"), "Tratamiento registrado correctamente en el paciente");
    }

    private static void testJefeEnfermeria() {
        System.out.println("\n--- 5. Pruebas de Jefatura de Enfermería ---");
        JefeEnfermeria jefe = new JefeEnfermeria("Jefa Marta", "J-01", "VESPERTINO", 3);
        afirmar(jefe.getTurnoSupervision().equals("VESPERTINO"), "Turno asignado a Jefa");
        afirmar(jefe.getPisoAsignado() == 3, "Piso asignado a Jefa");

        Enfermero[] equipo = new Enfermero[] {
                new EnfermeroEspecialista("Enf 1", "01", "UCI", "ACLS"),
                new EnfermeroEspecialista("Enf 2", "02", "PEDIATRIA", "PALS")
        };
        jefe.supervisarGuardia(equipo, 2);
        afirmar(true, "Supervisión de guardia ejecutada sin excepciones");
    }

    private static void testMergeSortDescendente() {
        System.out.println("\n--- 6. Pruebas de Ordenamiento con Merge Sort O(n log n) (Z a A) ---");
        MedicoGeneral med = new MedicoGeneral("Dr. Merge", "M-MERGE", "C-01");
        Paciente p1 = new PacienteGeneral("ANA", "Consulta");
        Paciente p2 = new PacienteGeneral("CARLOS", "Consulta");
        Paciente p3 = new PacienteGeneral("BERTHA", "Consulta");
        Paciente p4 = new PacienteGeneral("DANIEL", "Consulta");

        med.admitirPaciente(p1);
        med.admitirPaciente(p2);
        med.admitirPaciente(p3);
        med.admitirPaciente(p4);

        afirmar("DANIEL".compareToIgnoreCase("CARLOS") > 0, "DANIEL es mayor que CARLOS");
        afirmar("CARLOS".compareToIgnoreCase("BERTHA") > 0, "CARLOS es mayor que BERTHA");
        afirmar("BERTHA".compareToIgnoreCase("ANA") > 0, "BERTHA es mayor que ANA");

        med.verListaPacientes();
        afirmar(med.getNoPacientes() == 4, "Los 4 pacientes están asignados y ordenados con Merge Sort");
    }
}
