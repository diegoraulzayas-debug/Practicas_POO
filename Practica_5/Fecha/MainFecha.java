import java.util.Scanner;

public class MainFecha {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Ingresar fecha
        System.out.println("Ingrese el día:");
        int dia = entrada.nextInt();

        System.out.println("Ingrese el mes:");
        int mes = entrada.nextInt();

        System.out.println("Ingrese el año:");
        int anio = entrada.nextInt();

        // Crear un objeto Fecha
        Fecha fecha1 = new Fecha(mes, dia, anio);

        // Mostrar fecha
        System.out.println("Fecha ingresada");
        fecha1.mostrarFecha();

        // Modificar la fecha
        System.out.println("\nIngrese el nuevo día:");
        fecha1.setDia(entrada.nextInt());

        System.out.println("Ingrese el nuevo mes:");
        fecha1.setMes(entrada.nextInt());

        System.out.println("Ingrese el nuevo año:");
        fecha1.setAnio(entrada.nextInt());

        // Mostrar fecha modificada
        System.out.println("\nFecha modificada:");
        fecha1.mostrarFecha();

        entrada.close();
    }
}