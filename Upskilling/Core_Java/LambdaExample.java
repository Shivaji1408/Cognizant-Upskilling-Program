import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExample {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Rahul");
        names.add("Shiv");
        names.add("Aman");
        names.add("Priya");
        names.add("Neha");

        System.out.println("Before Sorting:");
        System.out.println(names);

        Collections.sort(names, (a, b) -> a.compareTo(b));

        System.out.println("\nAfter Sorting:");
        System.out.println(names);
    }
}