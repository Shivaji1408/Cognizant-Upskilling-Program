import java.util.Arrays;
import java.util.List;

record Person(String name, int age) {}

public class RecordExample {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("Shiv", 20),
                new Person("Rahul", 17),
                new Person("Aman", 22),
                new Person("Priya", 18)
        );

        System.out.println("All Persons:");

        persons.forEach(System.out::println);

        System.out.println("\nAge >= 18");

        persons.stream()
                .filter(p -> p.age() >= 18)
                .forEach(System.out::println);
    }
}