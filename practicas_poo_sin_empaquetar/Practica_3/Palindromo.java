import java.util.Scanner;

public class Palindromo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingresa un numero entero de 5 digitos:");
        int num = sc.nextInt();

        if (num<0) {
            num=num*(-1);
            
        }
        
        
        while (num < 10000 || num > 99999) {
            System.out.println("Error: el numero debe tener 5 digitos");
            System.out.println("Ingresa el nuevo numero:");
            num = sc.nextInt();
        }
        
      
        if (esPalindromo(num)) {
            System.out.println(num + " es un palindromo");
        } else {
            System.out.println(num + " no es un palindromo");
        }
        
        sc.close();
    }

    
    public static boolean esPalindromo(int num) {
        
        if ((num / 10000 == num % 10) && ((num / 1000) % 10 == (num / 10) % 10)) {
            return true;
        } else {
            return false;
        }
    }
}