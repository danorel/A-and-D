package persons.comparators;

import persons.Person;

import java.util.Comparator;

public class PersonSurnameComparator implements Comparator<Person> {
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getSurname().compareTo(secondPerson.getSurname());
    }
}
