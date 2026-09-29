
import java.util.Scanner;

public class MainEmpleado {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Empleado 1");

        System.out.print("Ingrese el nombre: ");
        String nombre1 = entrada.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido1 = entrada.nextLine();

        System.out.print("Ingrese el salario mensual: ");
        double salario1 = entrada.nextDouble();
        entrada.nextLine();

        Empleado empleado1 = new Empleado(nombre1, apellido1, salario1);

        System.out.println("\nEmpleado 2");

        System.out.print("Ingrese el nombre: ");
        String nombre2 = entrada.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido2 = entrada.nextLine();

        System.out.print("Ingrese el salario mensual: ");
        double salario2 = entrada.nextDouble();

        Empleado empleado2 = new Empleado(nombre2, apellido2, salario2);

        System.out.println("\nSalario anual antes del aumento:");

        System.out.println(empleado1.getNombre() + ": $"
                + empleado1.salarioAnual());

        System.out.println(empleado2.getNombre() + ": $"
                + empleado2.salarioAnual());

        empleado1.aumentarSalario();
        empleado2.aumentarSalario();

        System.out.println("\nSalario anual después del aumento del 10%:");

        System.out.println(empleado1.getNombre() + ": $"
                + empleado1.salarioAnual());

        System.out.println(empleado2.getNombre() + ": $"
                + empleado2.salarioAnual());

        entrada.close();
    }
}

