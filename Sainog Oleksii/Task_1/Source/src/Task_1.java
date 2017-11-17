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
        List<Collection> list = new ArrayList<>(4);
        list.add(new ArrayList<>());
        list.add(new LinkedList<>());
        list.add(new TreeSet<>());
        list.add(new HashSet<>());

        for (Collection col : list){
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
    }
}
