import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Extra_1 {
    public static void main(String args[]){
        final String input_file = "input.txt";
        final String output_file = "output.txt";
        String subline = new Scanner(System.in).nextLine();
        try(Scanner input = new Scanner(new File(input_file)); FileWriter output = new FileWriter(output_file)){
            while (input.hasNext()){
                output.write(
                        input.nextLine()
                                .replaceAll(
                                        subline.replaceAll(
                                                "(\\W)",
                                                "\\\\$1"),
                                        "")
                                + "\n");
            }
            input.close();
            output.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
