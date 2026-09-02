import java.util.Scanner;

public class ejercicio_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cont = 0;
        int mayor =0;
        int num;

        while (cont < 10) {
            System.out.print("Ingresa un numero  ");
            num = sc.nextInt();
            if (num<0) {
                num=num*(-1);
            }
            if (num > mayor) {
                mayor = num;
            }

            cont++;
        }

        System.out.println("El numero mayor es: " + mayor);

        sc.close();
    }
}