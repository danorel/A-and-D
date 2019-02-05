package persons.comparators;

import persons.Person;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getName().compareTo(secondPerson.getName());
    }
}
