package persons.comparators;

import persons.Person;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getAge() - secondPerson.getAge();
    }
}
