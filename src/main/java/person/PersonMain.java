package person;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonMain {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        Person person1 = new Person("Ivan", "Ivanov", 30, 80, Arrays.asList("Dima", "Masha", "Katya", "Lena"));
        Person person2 = new Person("Petr", "Petrov", 42, 100, Arrays.asList("Vasya", "Kolja", "Imma", "Olja"));
        Person person3 = new Person("Serhej", "Sidorov", 56, 98, Arrays.asList("Dasha", "Maksim", "Zhora", "Bob"));
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        for (Person p : persons) {
            String personGSON = GSON.toJson(p);
            System.out.println(personGSON);
        }
        for (Person p : persons) {
            String personGSON = GSON.toJson(p);
            Person per = GSON.fromJson(personGSON, Person.class);
            System.out.println(per.getFirstName() + " -> " + per.getFirstName().toUpperCase());
            System.out.println(per.getLastName() + " -> " + per.getLastName().toUpperCase());
            System.out.println("---CHILDREN---");
            for (String child : per.getChildren()) {
                System.out.println(child + " -> " + child.toUpperCase());
            }
            System.out.println("==============");
        }
    }
}

