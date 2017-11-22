import java.util.Scanner;

public class Extra_2 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            System.out.println(
                    input.nextLine()
                            .replaceAll(
                                    "(.)\\1+",
                                    "$1")
            );
        }
        input.close();
    }
}