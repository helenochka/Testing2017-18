import java.util.*;

public class Task_1 {
    private static long get_time_add(Collection<Integer> col, Integer elem){
        long time = System.nanoTime();
        col.add(elem);
        time = System.nanoTime() - time;
        return time;
    }

    private static long get_time_search(Collection<Integer> col, Integer elem){
        long time = System.nanoTime();
        col.contains(elem);
        time = System.nanoTime() - time;
        return time;
    }

    private static long get_time_remove(Collection<Integer> col, Integer elem){
        long time = System.nanoTime();
        col.remove(elem);
        time = System.nanoTime() - time;
        return time;
    }

    public static void main(String args[]) {
        List<Collection<Integer>> list = new ArrayList<>(4);
        List<Integer> values = new ArrayList<>();
        Random rand = new Random();

        list.add(new ArrayList<>());
        list.add(new LinkedList<>());
        list.add(new TreeSet<>());
        list.add(new HashSet<>());

        System.out.println("Add item in empty collection:");
        for (Collection<Integer> col : list){
            System.out.println(col.
                    getClass().
                        getTypeName().
                            replaceAll(
                                    ".*\\.([A-Z].*)",
                                    "$1") +
                                " - " +
                                get_time_add(col, 256) +
                                " ns.");
        }

        for(int i = 0; i < 10000; i++){
            values.add(rand.nextInt(25000));
        }
        System.out.println("\nAdd item in not empty collection:");
        for (Collection<Integer> col : list){
            col.addAll(values);
            System.out.println(col.
                    getClass().
                    getTypeName().
                    replaceAll(
                            ".*\\.([A-Z].*)",
                            "$1") +
                    " - " +
                    get_time_add(col, 256) +
                    " ns.");
        }

        System.out.println("\nSearch for an item in a collection:");
        for (Collection<Integer> col : list){
            System.out.println(col.
                    getClass().
                    getTypeName().
                    replaceAll(
                            ".*\\.([A-Z].*)",
                            "$1") +
                    " - " +
                    get_time_search(col, 25) +
                    " ns.");
        }

        System.out.println("\nRemove item from collection:");
        for (Collection<Integer> col : list){
            System.out.println(col.
                    getClass().
                    getTypeName().
                    replaceAll(
                            ".*\\.([A-Z].*)",
                            "$1") +
                    " - " +
                    get_time_remove(col, 256) +
                    " ns.");
        }
        System.out.println('\n');
    }
}
