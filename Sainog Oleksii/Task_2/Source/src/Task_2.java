import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task_2 {
    public static void main(String[] args){
        final String output_file = "Task_2_result.txt";
        final int AlphaCapacty = 150;
        final int BetaCapacity = 15;
        List<Integer> Alpha = new ArrayList<>();
        List<Integer> Beta = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < AlphaCapacty; i++){
            Alpha.add(rand.nextInt(200) + 1);
        }
        List<Integer> Alpha_copy = new ArrayList<>(Alpha);
        for (int i = 0; i < BetaCapacity; i++){
            int t = Alpha_copy.get(i);
            int q = i;
            for(int j = i + 1; j < AlphaCapacty; j ++){
                int num = Alpha_copy.get(j);
                if (t < num){
                    q = j;
                    t = num;
                }
            }
            Beta.add(Alpha_copy.get(q));
            Alpha_copy.set(q, Alpha_copy.get(i));
        }
        try(FileWriter output = new FileWriter(output_file)) {
            System.out.println(Beta.toString());
            output.write(Beta.toString());
            output.close();
        }
        catch (IOException error){
            System.out.println(error.getMessage());
        }
    }
}
