import java.util.List;

public class Task_1 extends GoogleSearch  {
    public static void main (String args[]){
        List<String> list = searching("осцилограф",2,3);
            for(String  iter : list)
                System.out.println(iter);
    }
}
