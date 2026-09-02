public class ejercicio_3 {
    public static void main(String[] args) {
        int n, mult10, mult100, mult1000;

        System.out.println("n\t10*n\t100*n\t1000*n");
        for (n = 1; n < 6; n++) {
            mult10 = n * 10;
            mult100 = n * 100;
            mult1000 = n * 1000;
            System.out.println(n + "\t" + mult10 + "\t" + mult100 + "\t" + mult1000);
        }
    }
}