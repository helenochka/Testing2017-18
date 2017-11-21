import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Task_5  {
    private static Collator alphabet_sort_comp(List<String> list){
        if (list.get(list.size() - 1).matches(".*\\w.*"))
            return Collator.getInstance(new Locale("en"));
        else if (list.get(list.size() - 1).matches(".*[а-яА-Яъёэы].*"))
                return Collator.getInstance(new Locale("ru"));
            else return Collator.getInstance(new Locale("ua"));
    }


    private static void alphsort(String str){
        List<String> words = new ArrayList<>();
        try{
            FileReader in = new FileReader(str);
            BufferedReader cin = new BufferedReader(in);
            if(in.getEncoding().equals("UTF8")){
                while(cin.ready()){
                    words.addAll(
                            words.size(),
                            Arrays.asList(
                                    cin.readLine()
                                            .trim()
                                                .split(
                                                        "[^\\wа-яіїєёъыэЁЪЫЭІЇЄА-Я\'\\d]+"
                                                )
                            )
                    );
                }
                words.remove("");
                words.sort(
                        (String s1, String s2) -> alphabet_sort_comp(words)
                                .compare(
                                        s1.toUpperCase(),
                                        s2.toUpperCase()
                                )
                );
                System.out.println(words);
            }
            else System.out.println(str + " - file has incorrect encoding!");
            cin.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String args[])  {
        alphsort("text_eng.txt");
        alphsort("text_rus.txt");
        alphsort("text_ukr.txt");
    }
}