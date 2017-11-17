import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task_4 {
    private static void cout(String str) { System.out.print(str); }

    private static void endl() { System.out.println(); }

    private static void coutln(String str){
        cout(str);
        endl();
    }

    public static void main(String[] args){
        Random rand = new Random();
        final String input_label = "ukr.txt";
        List<String> labels = new ArrayList<>();
        try(Scanner lang = new Scanner(new File(input_label))){
            while (lang.hasNext()){
                labels.add(lang.nextLine());
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        Scanner scan = new Scanner(System.in);
        int max = 100, min = 0;
        boolean victory = false;
        int answer = rand.nextInt(101);
        int number;
        while (!victory){
            cout(labels.get(0));
            try {
                number = Integer.parseInt(scan.nextLine());
            }
            catch (NumberFormatException err){
                coutln(labels.get(1));
                continue;
            }
            if(number == answer){
                coutln(labels.get(2));
                victory = true;
            }
            else{
                if(number > max || number < min){
                    coutln( labels.get(3) + " [" + min + "; " + max + "].");
                }
                else{
                    String simile;
                    if(number > answer){
                        max = number - 1;
                        simile = labels.get(4);
                    }
                    else{
                        min = number + 1;
                        simile = labels.get(5);
                    }
                    coutln(simile + ", " + labels.get(6) + " [" + min + "; " + max + "].");
                }
            }
        }
    }
}
