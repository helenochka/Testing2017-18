import java.util.Scanner;

public class FormatOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for(int i = 0; i < 3; i++){
            String s1 = sc.next();
            int x = sc.nextInt();
            String res = (x <100) ? ((x < 10) ? "00" + x : "0" + x) : Integer.toString(x);
            System.out.println(String.format("%-14s %-16s", s1, res));
        }
        System.out.println("================================");
    }
}
