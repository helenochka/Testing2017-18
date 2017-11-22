import java.util.Scanner;

public class Extra_3 {
    public static void main (String args[]){
        System.out.print("Input line: ");
        System.out.println(
                        new Scanner(System.in)
                                .nextLine()
                                    .split("\\s+")
                                        .length
        );
    }
}
