public class Tabla {
    public static void main(String[] args) {
        System.out.println("n\t10*n\t100*n\t1000*n");
        
        for (int n = 1; n < 6; n++) {
            System.out.println(n + "\t" + (n * 10) + "\t" + (n * 100) + "\t" + (n * 1000));
        }
    }
}