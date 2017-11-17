import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_3 {
    private static boolean isPath(String path){
        return path.matches("^.+\\.txt$");
    }

    private final static String default_filepath_i = "employees_i.txt";

    private final static String default_filepath_o = "employees_o.txt";

    private static List<Employee> add(List<Employee> list, String record) {
        String[] records_parts = record.trim().split("\\|");
        if (records_parts[0].equals("hourly")) {
            list.add(new Hourly_payment(
                    records_parts[1],
                    Long.parseLong(records_parts[2]),
                    Double.parseDouble(records_parts[3]))
            );
        }
        if (records_parts[0].equals("fixed")) {
            list.add(new Fixed_payment(
                    records_parts[1],
                    Long.parseLong(records_parts[2]),
                    Double.parseDouble(records_parts[3]))
            );
        }
        return list;
    }

    private static boolean test_record(String record){
        return record.matches("^(hourly|fixed)\\|[\\w\\s]+\\|\\d+\\|\\d+(\\.\\d{1,2})?$");
    }

    private static List<Employee> read(String filepath) {
        List<Employee> list = new ArrayList<>();
        try(Scanner cin = new Scanner(new FileReader(filepath))){
            while (cin.hasNext()){
                String record = cin.nextLine();
                if(test_record(record)) {
                    list = add(list, record);
                }
            }
        }
        catch (Exception ex){
            print(ex.getMessage());
        }
        return list;
    }

    private static void write(String filepath, List<Employee> list){
        try(FileWriter cout = new FileWriter(filepath)){
            for(Employee record : list)
                cout.write(record.toString()+"\n");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void print(Object obj){
        System.out.println(obj.toString().trim());
    }

    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        List<Employee> list;
        final int n_1 = 5;
        final int n_2 = 3;

        print("Input name of file: ");
        String filepath = cin.nextLine();
        if (isPath(filepath)){
            list = read(filepath);
        }
        else{
            list = read(default_filepath_i);
            print("Input file isn't a text file!(Opened default file)");
            print("");
        }
        print(list.toString());
        print("");
        if(!list.isEmpty()){
            list.sort(Employee::compareTo);
            write(default_filepath_o, list);
            print(" First " + n_1 + "name:");
            for (int i = 0; i < Integer.min(n_1, list.size()); i++)
                print(list.get(i).full_name);
            print("");
            print("Last " + n_2 + "id:");
            for (int i = 1; i <= Integer.min(n_2, list.size()); i++)
                print(list.get(list.size() - i).id);
        }
    }
}
