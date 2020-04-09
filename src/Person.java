import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public static Person getOldestPerson(List<Person> collection) {
        //Person oldest = collection.stream().reduce((p1, p2)-> p1.age> p2.age ? p1 : p2);
        Person oldest = collection
                .stream()
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new);
        return oldest;
    }
}