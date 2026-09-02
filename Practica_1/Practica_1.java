import java.util.Scanner;

public class Practica_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int op;
        float num1, num2, resultado;
        float multiplicacion, division;

        do {
            System.out.println("\n1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Exponente");
            System.out.println("6. Raiz");
            System.out.println("7. Modulo");
            System.out.println("8. Salir");
            System.out.print("Ingresa opcion deseada: ");
            op = sc.nextInt();

            if (op == 8) {
                System.out.println("Saliendo...");
                break;
            }

            if (op < 1 || op > 8) {
                System.out.println("Opcion no valida.");
                continue;
            }

            System.out.print("Ingresa el primer numero: ");
            num1 = sc.nextFloat();

            System.out.print("Ingresa el segundo numero: ");
            num2 = sc.nextFloat();

            switch (op) {
                case 1:
                    resultado = num1 + num2;
                    System.out.println("Resultado: " + resultado);
                    break;

                case 2:
                    System.out.println("\n¿Que resta deseas realizar?");
                    System.out.println("1. " + num1 + " - " + num2);
                    System.out.println("2. " + num2 + " - " + num1);
                    System.out.print("Selecciona una opcion: ");

                    int resta = sc.nextInt();

                    if (resta == 1) {
                        resultado = num1 - num2;
                    } else {
                        resultado = num2 - num1;
                    }

                    System.out.println("Resultado: " + resultado);
                    break;

                case 3:
                    multiplicacion = num1 * num2;
                    System.out.println("La multiplicación es: " + num1 + " * " + num2 + " = " + multiplicacion);
                    break;

                case 4:
                    if (num2 != 0) {
                        division = num1 / num2;
                        System.out.println("La división es: " + num1 + " / " + num2 + " = " + division);
                    } else {
                        System.out.println("No es posible dividir entre 0");
                    }
                    break;

                case 5:
                    resultado = (float) Math.pow(num1, num2);
                    System.out.println("El resultado es: " + resultado);
                    break;

                case 6:
                    if (num2 != 0) {
                        float answer = (float) Math.pow(num1, 1.0 / num2);
                        System.out.println("Su valor de raiz calculado es: " + answer);
                    } else {
                        System.out.println("El índice de la raíz no puede ser 0");
                    }
                    break;

                case 7:
                    if (num2 != 0) {
                        int r1 = (int) (num1 / num2);
                        float r2 = num1 % num2;
                        System.out.println("El resultado de la division entre " + num1 + " y " + num2 + " es " + r1 + " con residuo " + r2);
                    } else {
                        System.out.println("No es posible calcular módulo con divisor 0");
                    }
                    break;
            }

        } while (op != 8);

        sc.close();
    }
}