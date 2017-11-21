import java.util.Scanner;

public class Task_6 {
    private static String no_reverse(String str, int iter){
        return iter >= 0 ? str.charAt(iter) + no_reverse(str, iter - 1): "";
    }

    public static void main(String args[]){
        System.out.print("Input line: ");
        String string = new Scanner(System.in).nextLine();
        System.out.print("Result: " + no_reverse(string, string.length() - 1));
    }
}
