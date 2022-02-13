package ro.fasttrackit.homework;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> persons;

    public PersonService(Collection<Person> persons) {
        this.persons = persons != null
                ? new ArrayList<>(persons)
                : new ArrayList<>();
    }

    public List<String> personsNames() {
        return persons.stream()
                .map(person -> person.firstName() + " " + person.lastName())
                .collect(Collectors.toList());
    }

    public List<Person> olderThen18() {
        return persons.stream()
                .filter(person -> person.age() >= 18)
                .collect(Collectors.toList());
    }

    public List<Person> peopleFromOradea() {
        return persons.stream()
                .filter(person -> person.city().equalsIgnoreCase("oradea"))
                .collect(Collectors.toList());
    }
    public List<Person> peopleFromOradeaOrCluj() {
        return persons.stream()
                .filter(person -> person.city().equalsIgnoreCase("oradea") || person.city().equalsIgnoreCase("cluj"))
                .collect(Collectors.toList());
    }

    public List<String> firstNameCapital() {
        return persons.stream()
                .map(person -> person.firstName().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<String> compactName() {
        return persons.stream()
                .map(person ->
                        person.firstName() + " " +
                        person.lastName().substring(0,1).toUpperCase() + ".")
                .collect(Collectors.toList());
    }

    public List<Person> between18and60() {
        return persons.stream()
                .filter(person -> person.age() >= 18 && person.age() <= 60)
                .collect(Collectors.toList());
    }

    public List<Person> startsWithA() {
        return persons.stream()
                .filter(person -> person.firstName().startsWith("A"))
                .collect(Collectors.toList());
    }

    public List<String> uniqueName() {
        return persons.stream()
                .map(Person::firstName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Person> orderByFirstName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .collect(Collectors.toList());
    }

    public List<Person> orderByLastName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::lastName))
                .collect(Collectors.toList());
    }

    public List<Person> orderedPersons() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .sorted(Comparator.comparing(Person::lastName))
                .sorted(Comparator.comparing(Person::age))
                .collect(Collectors.toList());
    }
}
